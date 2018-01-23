package dk.lndesign.kotlinspring

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): List<Greeting> {
        return listOf(Greeting(1, "Hello, $name"),
                Greeting(2, "Hi, $name"))
    }

}