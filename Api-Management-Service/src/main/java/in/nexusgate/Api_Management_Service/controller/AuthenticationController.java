package in.nexusgate.Api_Management_Service.controller;


import in.nexusgate.Api_Management_Service.dto.requestDto.LoginRequest;
import in.nexusgate.Api_Management_Service.dto.responseDto.LoginResponse;
import in.nexusgate.Api_Management_Service.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService)
    {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest)
    {
        return ResponseEntity.ok(authenticationService.login(loginRequest));
    }

}
