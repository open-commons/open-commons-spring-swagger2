/*
 * Copyright 2023 Park Jun-Hong (parkjunhong77@gmail.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 *
 * This file is generated under this project, "open-commons-spring-swagger2".
 *
 * Date  : 2023. 5. 19. 오후 5:12:05
 *
 * Author: Park Jun-Hong (parkjunhong77@gmail.com)
 * 
 */

package open.commons.spring.swagger2.config;

import java.util.Arrays;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import open.commons.core.utils.ArrayUtils;
import open.commons.spring.swagger2.SpringfoxSwagger;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @since 2023. 5. 19.
 * @version 0.1.0
 * @author Park Jun-Hong (parkjunhong77@gmail.com)
 */

@Configuration
@EnableWebMvc
@EnableSwagger2
@SpringBootApplication(exclude = {
        // Spring Security 자동 실행 방지
        SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class
//
})
public class Swagger2WebMvcConfigurer implements WebMvcConfigurer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApplicationContext context;

    /**
     * <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜    	| 작성자	|	내용
     * ------------------------------------------
     * 2023. 5. 19.		박준홍			최초 작성
     * </pre>
     *
     *
     * @since 2023. 5. 19.
     * @version 0.1.0
     * @author Park Jun-Hong (parkjunhong77@gmail.com)
     */
    public Swagger2WebMvcConfigurer() {
    }

    /**
     * 
     * <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜    	| 작성자	|	내용
     * ------------------------------------------
     * 2023. 5. 19.		박준홍			최초 작성
     * </pre>
     *
     * @param registry
     * @param patterns
     *            URL 처리 예외 패턴
     *
     * @since 2023. 5. 19.
     * @version 0.1.0
     * @author Park Jun-Hong (parkjunhong77@gmail.com)
     */
    private void addExcludePatternsToInterceptor(InterceptorRegistration registry, String... patterns) {
        registry.excludePathPatterns(patterns);
        logger.info("[ADD] exclude.path={}", Arrays.toString(patterns));
    }

    /**
     *
     * @since 2023. 5. 19.
     * @version 0.1.0
     * @author Park Jun-Hong (parkjunhong77@gmail.com)
     *
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Bean 중에서 HandlerIntereceptor 를 구현한 객체를 찾아서.
        Collection<HandlerInterceptor> intcptrs = context.getBeansOfType(HandlerInterceptor.class).values();

        if (intcptrs == null || intcptrs.size() < 1) {
            InterceptorRegistration reg = registry.addInterceptor(new AsyncHandlerInterceptor() {
            });
            addSwagger2ExcludePatternsToInterceptor(reg);
            return;
        }

        intcptrs.stream() //
                .forEach(intcptr -> {
                    InterceptorRegistration reg = registry.addInterceptor(intcptr);
                    addSwagger2ExcludePatternsToInterceptor(reg);
                    logger.info("Register a Interceptor. {}.", intcptr);
                });

        WebMvcConfigurer.super.addInterceptors(registry);
    }

    /**
     *
     * @since 2023. 5. 19.
     * @version 0.1.0
     * @author Park Jun-Hong (parkjunhong77@gmail.com)
     *
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        addSwagger2ResourceHandlers(registry);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    /**
     * 
     * <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜    	| 작성자	|	내용
     * ------------------------------------------
     * 2023. 5. 19.		박준홍			최초 작성
     * </pre>
     *
     * @param registry
     * @param handlers
     *            Resource Handler, {@link AntPathMatcher}
     * @param locations
     *            Resource Locations, {@link AntPathMatcher}
     *
     * @since 2023. 5. 19.
     * @version 0.1.0
     * @author Park Jun-Hong (parkjunhong77@gmail.com)
     */
    private void addResourceHandlers(ResourceHandlerRegistry registry, String[] handlers, String[] locations) {
        registry.addResourceHandler(handlers).addResourceLocations(locations);
        logger.info("[ADD] resource.handler={}, resource.locations={}", Arrays.toString(handlers), Arrays.toString(locations));
    }

    /**
     * Springfox-swagger-ui 지원을 위한 패턴 예외사항을 적용한다. <br>
     * 
     * <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜    	| 작성자	|	내용
     * ------------------------------------------
     * 2023. 5. 19.		박준홍			최초 작성
     * </pre>
     *
     * @param registry
     *
     * @since 2023. 5. 19.
     * @version 0.1.0
     * @author Park Jun-Hong (parkjunhong77@gmail.com)
     */
    private void addSwagger2ExcludePatternsToInterceptor(InterceptorRegistration registry) {
        addExcludePatternsToInterceptor(registry, SpringfoxSwagger.getUrlList());
    }

    private void addSwagger2ResourceHandlers(ResourceHandlerRegistry registry) {
        // start - support 'sprignfox-swagger-ui-2.9.2' : 2020. 9. 3. 오후 5:15:51
        addResourceHandlers(registry, ArrayUtils.add(null, SpringfoxSwagger.URL_HTML), ArrayUtils.add(null, SpringfoxSwagger.RESOURCE_HTML));
        addResourceHandlers(registry, ArrayUtils.add(null, SpringfoxSwagger.URL_WEBJARS), ArrayUtils.add(null, SpringfoxSwagger.RESOURCE_WEBJARS));
        // end - support 'sprignfox-swagger-ui-2.9.2' : 2020. 9. 3. 오후 5:15:51
    }

    /**
     *
     * @since 2023. 5. 19.
     * @version 0.1.0
     * @author Park Jun-Hong (parkjunhong77@gmail.com)
     *
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry)
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController(SpringfoxSwagger.URL_UI, SpringfoxSwagger.URL_HTML);
        WebMvcConfigurer.super.addViewControllers(registry);
    }

}
