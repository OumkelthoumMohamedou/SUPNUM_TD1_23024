// package com.example.demo.soap;

// public class ServerEndpoint {
    
// }



package com.example.demo.soap;

import com.example.demo.entity.Server;
import com.example.demo.service.ServerService;
import org.springframework.ws.server.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Endpoint
public class ServerEndpoint {

    public static final String NAMESPACE = "http://supnum.mr/ws";

    private final ServerService service;

    public ServerEndpoint(ServerService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "createServerRequest")
    @ResponsePayload
    public CreateServerResponse create(CreateServerRequest request) {

        Server s = new Server(null, request.getName(), request.getIpAddress(), false);

        Server saved = service.create(s);

        CreateServerResponse response = new CreateServerResponse();
        response.setId(saved.getId());

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "listServersRequest")
    @ResponsePayload
    public ListServersResponse list() {

        List<Server> l = service.list();

        ListServersResponse response = new ListServersResponse();
        response.getServers().addAll(l);

        return response;
    }
}
