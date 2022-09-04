package br.com.alura.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Users;
import br.com.alura.mvc.mudi.repository.UserRepository;

@Controller
@RequestMapping("register")
public class RegisterController {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping()
	public String formUser(Users users) {
		return "usuario/register";
	}

	@PostMapping("novo")
	public String createUser(Users users) {
		Users user = users.cadastro();
		
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "redirect:/login";
	}
}
