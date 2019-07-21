package com.coolchatting.annotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BiMapperRegistar implements ImportBeanDefinitionRegistrar {
    private ResourcePatternResolver resourcePatternResolver = new
            PathMatchingResourcePatternResolver();
    private static final String scanPattern = "**/*.class";
    private List<String> packageList = new ArrayList<String>();
    private String annotation = "com.coolchatting.annotation.BiMapperScan";

    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        if (annotationMetadata.hasAnnotation(annotation)) {
            Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(annotation);
            String[] packages = (String[]) annotationAttributes.get("basePackages");
            //扫描包及其子包
            try {
                for (String s : packages) {
                    doScanPackages(s);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            //封装为BeanDefinition对象
            makeBeanDefinitionAndRegist(packageList, beanDefinitionRegistry);
        }
    }

    private void makeBeanDefinitionAndRegist(List<String> packageList, BeanDefinitionRegistry beanDefinitionRegistry) {
        for (String s : packageList) {
            Class clazz = null;
            try {
                clazz = Class.forName(s);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
            BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
            beanDefinitionRegistry.registerBeanDefinition(toLowerCaseFirst(clazz.getSimpleName()), beanDefinition);
        }

    }

    private String toLowerCaseFirst(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private void doScanPackages(String packageName) throws Exception {
        URL url = this.getClass().getResource("/" + packageName.replaceAll("\\.", "/"));
        String urlFile = url.getFile();
        File file = new File(urlFile);
        if (!file.exists()) {
            return;
        }
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File f : files) {
                if (f.isDirectory()) {
                    doScanPackages(packageName + "." + f.getName());
                } else {
                    packageList.add(packageName + "." + f.getName().replaceAll(".class", ""));
                }
            }
        }
    }


}
