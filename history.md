[2025/07/24]
- Dependencies
  + Add
    + jakarta.validation:jakarata.validation-api:${managed-version}
    + com.google.code.findbugs:jsr305:${managed-version}

[2025/02/21]
Apply 'Maven Central Deployment'

- Update
  + <deploymentManagement>
    + Release: Maven Central (https://central.sonatype.com)
  + 'open.commons' dependencies 
    + groupId: io.github.open-commons
- Add
  + <build>
    + org.sonatype.central:central-publishing-maven-plugin
    + org.apache.maven.plugins:maven-gpg-plugin

[2024/10/31]
- ETC
  + Maven Repository 주소 변경 (http -> https)
  
[2023/05/18]
- Release: 0.1.0-SNAPSHOT
- Migration
  + maven: open.commons:open-commons-spring-web-0.5.0
  + changes
    - package:
      + open.commons.spring.web.springfox.swagger -> open.commons.spring.swagger2
      + open.commons.spring.web.swagger -> open.commons.spring.swagger2.web
      + open.commons.spring.web.web.config -> open.commons.spring.swagger2.config

