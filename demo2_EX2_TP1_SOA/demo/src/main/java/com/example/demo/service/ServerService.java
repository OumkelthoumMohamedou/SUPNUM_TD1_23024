// package com.example.demo.service;

// public class ServerService {
    
// }



package com.example.demo.service;

import com.example.demo.entity.Server;

import java.util.List;

public interface ServerService {

    Server create(Server s);
    List<Server> list();
    Server start(Long id);
    Server stop(Long id);
}
