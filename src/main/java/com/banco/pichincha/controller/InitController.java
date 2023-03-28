package com.banco.pichincha.controller;


import com.banco.pichincha.dto.Request;
import com.banco.pichincha.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/DevOps")
public class InitController {

	@PostMapping( value="", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> buscarCliente (@RequestBody Request payload) {

		Response retorno = new Response();
		retorno.setMessage( "Hello "+ payload.getTo()+" your message will be send V1");
			return new ResponseEntity<Response>(retorno, HttpStatus.OK);
	}	
}
