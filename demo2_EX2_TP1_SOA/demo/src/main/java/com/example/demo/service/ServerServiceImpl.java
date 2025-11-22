// package com.example.demo.service;

// public class ServerServiceImpl {
    
// }



package com.example.demo.service;

import com.example.demo.entity.Server;
import com.example.demo.repository.ServerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerServiceImpl implements ServerService {

    private final ServerRepository repo;

    public ServerServiceImpl(ServerRepository repo) {
        this.repo = repo;
    }

    @Override
    public Server create(Server s) {
        s.setStatus(false);
        return repo.save(s);
    }

    @Override
    public List<Server> list() {
        return repo.findAll();
    }

    @Override
    public Server start(Long id) {
        Server s = repo.findById(id).orElseThrow();
        s.setStatus(true);
        return repo.save(s);
    }

    @Override
    public Server stop(Long id) {
        Server s = repo.findById(id).orElseThrow();
        s.setStatus(false);
        return repo.save(s);
    }
}
