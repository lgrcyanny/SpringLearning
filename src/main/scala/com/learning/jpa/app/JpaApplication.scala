package com.learning.jpa.app

import java.text.SimpleDateFormat

import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.learning.jpa.model.{Customer, CustomerRepository}
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.{Bean, ComponentScan}
import org.springframework.data.jpa.repository.config.{EnableJpaAuditing, EnableJpaRepositories}
import org.springframework.data.repository.core.support.RepositoryFactorySupport
import org.springframework.data.web.config.EnableSpringDataWebSupport
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.web.bind.annotation.{RequestMapping, ResponseBody}

import scala.collection.JavaConverters._

@SpringBootApplication
@EntityScan(Array("com.learning.jpa.model"))
@EnableJpaRepositories(Array("com.learning.jpa.model"))
@EnableJpaAuditing
@EnableSpringDataWebSupport
@ComponentScan
class JpaApplication {

  @Bean
  def jacksonBuilder(): Jackson2ObjectMapperBuilder = {
    // used to support scala data types like Option and case class in spring-mvc
    new Jackson2ObjectMapperBuilder()
      .indentOutput(true)
      .dateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")) // javascript ISO 8601
      .modules(DefaultScalaModule)
  }

}

object JpaApplication {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[JpaApplication], args: _*)
  }
}
