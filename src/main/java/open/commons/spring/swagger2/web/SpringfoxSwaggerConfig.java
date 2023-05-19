/*
 * Copyright 2023 Park Jun-Hong_(parkjunhong77@gmail.com)
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
 * Date  : 2023. 5. 19. 오후 4:55:55
 *
 * Author: Park Jun-Hong (parkjunhong77@gmail.com)
 * 
 */

package open.commons.spring.swagger2.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

/**
 * 
 * @since 2023. 5. 19.
 * @version 0.1.0
 * @author Park Jun-Hong (parkjunhong77@gmail.com)
 */
public class SpringfoxSwaggerConfig implements InitializingBean {

    public static final String SWAGGER2_API_INFO = "open.commons.spring.swagger2.SpringfoxSwaggerConfig#SWAGGER2_API_INFO";

    protected Logger logger = LoggerFactory.getLogger(getClass());

    private Map<String, SwaggerApiInfo> swaggerApis;

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
    public SpringfoxSwaggerConfig() {
    }

    /**
     *
     * @since 2023. 5. 19.
     * @version 0.1.0
     * @author Park Jun-Hong (parkjunhong77@gmail.com)
     *
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @SuppressWarnings("unchecked")
    @Override
    public void afterPropertiesSet() throws Exception {
        this.swaggerApis = (Map<String, SwaggerApiInfo>) this.context.getBean(SWAGGER2_API_INFO);
        this.swaggerApis.forEach((k, v) -> {
            logger.info("[loaded] swagger-apiinfo. {} = {}", k, v);
        });
    }

    /**
     * 그룹명에 해당하는 {@link ApiInfo} 를 제공한다. 없는 경우 default 정보를 제공한다. <br>
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
     * @param groupName
     * @return
     *
     * @since 2023. 5. 19.
     * @version 0.1.0
     * @author Park Jun-Hong (parkjunhong77@gmail.com)
     */
    protected ApiInfo api(String groupName) {
        SwaggerApiInfo conf = this.swaggerApis.get(groupName);

        return conf == null //
                ? new ApiInfo("default", null, "default", null, null, null, null, new ArrayList<>()) //
                : new ApiInfo(conf.getTitle(), conf.getDescription(), conf.getVersion(), conf.getTermsOfServiceUrl(), toContact(conf.getContactName()), conf.getLicense(),
                        conf.getLicenseUrl(), new ArrayList<>());
    }

    /**
     * {@link ApiInfo} 정보를 제공한다. <br>
     * 아래 2개의 어노테이션을 적용하여 구현한다.
     * <ul>
     * <li>{@link Bean}: Qualifer 로는 {@link #SWAGGER_API_INFO} 를 이용한다.
     * <li>{@link ConfigurationProperties}: yml 속성경로를 설정한다.
     * </ul>
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
     * @return
     *
     * @since 2023. 5. 19.
     * @version 0.1.0
     * @author Park Jun-Hong (parkjunhong77@gmail.com)
     */
    @Bean(SWAGGER2_API_INFO)
    @ConfigurationProperties("springfox.swagger.api-config")
    public Map<String, SwaggerApiInfo> getSwaggerApiInfo() {
        return new HashMap<>();
    }

    /**
     * {@link Contact} 를 제공한다. <br>
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
     * @param contact
     * @return
     *
     * @since 2023. 5. 19.
     * @version 0.1.0
     * @author Park Jun-Hong (parkjunhong77@gmail.com)
     */
    private Contact toContact(io.swagger.models.Contact contact) {
        return new Contact(contact.getName(), contact.getUrl(), contact.getEmail());
    }

}
