package ${package}.entity;

import lombok.Data;
import javax.persistence.*;
<#if hasTimestamp>
    import java.sql.Timestamp;
</#if>
<#if hasBigDecimal>
    import java.math.BigDecimal;
</#if>
import java.io.Serializable;

/**
* @author ${author}
* @date ${date}
*/
@Data
@Entity
@Table(name="${tableName}")
public class ${className} implements Serializable {
<#if columns??>
    <#list columns as column>
        <#if column.columnKey = 'PRI'>
            @Id
            <#if auto>
                @GeneratedValue(strategy = GenerationType.IDENTITY)
            </#if>
        </#if>
        @Column(name = "${column.columnName}"<#if column.columnKey = 'UNI'>,unique = true</#if><#if column.isNullable = 'NO' && column.columnKey != 'PRI'>,nullable = false</#if><#if column.columnComment != ''>, columnDefinition = "COMMENT '${column.columnComment}'"</#if>)
        private ${column.columnType} ${column.changeColumnName};

    </#list>
</#if>
}