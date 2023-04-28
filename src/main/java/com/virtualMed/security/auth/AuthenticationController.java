package com.virtualMed.security.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @ApiOperation(value = "Registers a new user")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully registered a new user"),
          @ApiResponse(code = 400, message = "Invalid request body")
  })

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }



  @ApiOperation(value = "Authenticates a user")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully authenticated the user"),
          @ApiResponse(code = 401, message = "Invalid credentials")
  })
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }


  @ApiOperation(value = "Refreshes the authentication token")
  @ApiResponses(value = {
          @ApiResponse(code = 204, message = "Successfully refreshed the token"),
          @ApiResponse(code = 400, message = "Invalid request"),
          @ApiResponse(code = 401, message = "Unauthorized")
  })

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }

}
