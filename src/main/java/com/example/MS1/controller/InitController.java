package com.example.MS1.controller;


import com.example.MS1.dto.Payload;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/DevOps")
public class InitController {

	@PostMapping( value="", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> buscarCliente (@RequestBody Payload payload) {
		
			String retorno = "Hello "+ payload.getTo()+" your message will be send";
			return new ResponseEntity<String>(retorno, HttpStatus.OK);
	}	
}
