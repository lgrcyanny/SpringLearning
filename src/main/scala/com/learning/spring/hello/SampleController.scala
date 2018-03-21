package com.learning.spring.hello

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, ResponseBody}
import scala.collection.JavaConverters._
import org.springframework.boot._

@Controller
@EnableAutoConfiguration
class SampleController {

  @RequestMapping(Array("/"))
  @ResponseBody
  def name() = "Hello World"
}

object SampleController {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[SampleController], args: _*)
  }
}
