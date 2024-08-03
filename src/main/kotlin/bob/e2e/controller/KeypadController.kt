package bob.e2e.controller

import bob.e2e.service.KeypadService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/keypad")
@RestController
class KeypadController(private val keypadService: KeypadService) {

    @GetMapping
    fun getKeypad(): ResponseEntity<KeypadResponse> {
        val (base64Image, hashList) = keypadService.generateKeypadImageAndHash()
        return ResponseEntity.ok(KeypadResponse(base64Image, hashList))
    }
}

data class KeypadResponse(val keypadImage: String, val hasList: List<String>)