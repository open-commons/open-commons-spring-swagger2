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
 * Date  : 2023. 5. 19. 오후 5:07:17
 *
 * Author: Park Jun-Hong (parkjunhong77@gmail.com)
 * 
 */

package open.commons.spring.swagger2;

/**
 * 
 * @since 2023. 5. 19.
 * @version 0.1.0
 * @author Park Jun-Hong (parkjunhong77@gmail.com)
 */
public class SpringfoxSwagger {

    /** /v2/api-docs */
    public static final String URL_V2_API_DOCS = "/v2/api-docs";
    /** configurations */
    public static final String URL_CONFIGURATION = "/configuration/**";
    /** configurations security */
    public static final String URL_CONFIGURATION_SECURITY = "/configuration/security";
    /** configurations ui */
    public static final String URL_CONFIGURATION_UI = "/configuration/ui";
    /** swagger main page */
    public static final String URL_HTML = "/swagger-ui.html";
    /** configurations */
    public static final String URL_RESOURCES = "/swagger-resources/**";
    /** swagger main page css, font, js, etc ... */
    public static final String URL_WEBJARS = "/webjars/**";
    /** use to frowarindg to 'swagger-ui' to 'swagger-ui.html' */
    public static final String URL_UI = "/swagger-ui";
    /** html 위치 */
    public static final String RESOURCE_HTML = "classpath:/META-INF/resources/";
    /** html 에서 사용되는 css, font, js, etct ... */
    public static final String RESOURCE_WEBJARS = "classpath:/META-INF/resources/webjars/";

    private SpringfoxSwagger() {
    }

    /**
     * Springfox Swagger, Swagger-UI 를 사용하기 위해 제공되는 URL 목록을 제공한다. <br>
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
    public static final String[] getUrlList() {
        return new String[] { URL_V2_API_DOCS, //
                URL_CONFIGURATION, //
                URL_CONFIGURATION_SECURITY, //
                URL_CONFIGURATION_UI, //
                URL_HTML, //
                URL_RESOURCES, //
                URL_WEBJARS, //
                URL_UI, //
        };
    }

}
