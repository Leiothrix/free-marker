package com.paprika.freemarker.util;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @author adam
 * @date 2019/12/20
 */
public class ColumnUtil {

    private static final char SEPARATOR = '_';

    /**
     * 获取resources目录下自定义配置信息
     */
    public static PropertiesConfiguration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转换MySQL数据类型为Java数据类型
     *
     * @param type MySQL数据类型
     * @return Java数据类型
     */
    public static String cloToJava(String type) {
        Configuration config = getConfig();
        assert config != null;
        return config.getString(type, null);
    }

    /**
     * 下划线风格转小驼峰
     * @param s 下划线风格字段
     * @return 小驼峰风格字段
     * toCamelCase("hello_world ") == "helloWorld"
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 小驼峰转大驼峰
     * @param s 小驼峰风格字段
     * @return 大驼峰风格字段
     * toCapitalizeCamelCase("helloWorld") == "HelloWorld"
     */
    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}

