package ru.fishbalka.multilang.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver(){
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setCookieDomain("myAppLocaleCookie");
        resolver.setCookieMaxAge(3600);
        return resolver;
    }

    @Bean(name="messageSource")
    public MessageSource getMessageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localInterceptor = new LocaleChangeInterceptor();
        localInterceptor.setParamName("lang");

        registry.addInterceptor(localInterceptor).addPathPatterns("/*");
    }
}
