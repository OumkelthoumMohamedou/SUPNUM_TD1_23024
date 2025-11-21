// package com.example.demo.controller;

// public class ServerController {
    
// }



package com.example.demo.controller;

import com.example.demo.model.Server;
import com.example.demo.service.ServerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servers")
public class ServerController {

    private final ServerService service;

    public ServerController(ServerService service) {
        this.service = service;
    }

    @PostMapping
    public Server createServer(@RequestParam String name) {
        return service.createServer(name);
    }

    @GetMapping
    public List<Server> getAllServers() {
        return service.getAllServers();
    }

    @GetMapping("/{id}")
    public Server getServer(@PathVariable Long id) {
        return service.getServer(id).orElse(null);
    }
}
