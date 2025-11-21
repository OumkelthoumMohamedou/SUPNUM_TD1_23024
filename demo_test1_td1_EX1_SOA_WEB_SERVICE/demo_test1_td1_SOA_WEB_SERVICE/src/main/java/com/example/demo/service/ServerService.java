// package com.example.demo.service;

// public class ServerService {
    
// }


package com.example.demo.service;

import com.example.demo.model.Server;
import com.example.demo.repository.ServerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServerService {

    private final ServerRepository repository;

    public ServerService(ServerRepository repository) {
        this.repository = repository;
    }

    public Server createServer(String name) {
        Server server = new Server(name);
        return repository.save(server);
    }

    public List<Server> getAllServers() {
        return repository.findAll();
    }

    public Optional<Server> getServer(Long id) {
        return repository.findById(id);
    }
}
