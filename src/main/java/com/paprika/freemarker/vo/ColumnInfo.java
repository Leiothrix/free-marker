package com.paprika.freemarker.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author adam
 * @date 2019/12/20
 */
@Data
@AllArgsConstructor
public class ColumnInfo {
    /** 数据库字段名称 **/
    private Object columnName;

    /** 允许空值 **/
    private Object isNullable;

    /** 数据库字段类型 **/
    private Object columnType;

    /** 数据库字段注释 **/
    private Object columnComment;

    /** 数据库字段键类型 **/
    private Object columnKey;

    /** 额外的参数 **/
    private Object extra;
}
