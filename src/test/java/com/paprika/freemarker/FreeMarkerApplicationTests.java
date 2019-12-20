package com.paprika.freemarker;

import com.paprika.freemarker.service.GeneratorService;
import com.paprika.freemarker.util.GeneratorUtil;
import com.paprika.freemarker.vo.ColumnInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class FreeMarkerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private GeneratorService generatorService;

    @Test
    void genTest() throws IOException {
        String tableName = "student";
        String pack = "com.paprika.freemarker";
        String author = "adam";
        List<ColumnInfo> columnInfos = generatorService.getColumns(tableName);
        GeneratorUtil.generatorCode(columnInfos, pack, author, tableName);
    }

}
