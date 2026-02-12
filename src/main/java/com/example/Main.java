package com.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create HTTP server on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        // Create context for handling requests
        server.createContext("/", new HomeHandler());
        server.createContext("/api/data", new ApiHandler());
        
        server.setExecutor(null); // Creates a default executor
        server.start();
        System.out.println("Server running on http://localhost:8080");
    }
    
    // Handler for home page
    static class HomeHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (exchange.getRequestURI().getPath().equals("/")) {
                // Serve index.html
                byte[] response = Files.readAllBytes(Paths.get("src/main/resources/index.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                OutputStream os = exchange.getResponseBody();
                os.write(response);
                os.close();
            } else if (exchange.getRequestURI().getPath().endsWith(".css")) {
                // Serve CSS files
                String filePath = "src/main/resources" + exchange.getRequestURI().getPath();
                byte[] response = Files.readAllBytes(Paths.get(filePath));
                exchange.getResponseHeaders().set("Content-Type", "text/css");
                exchange.sendResponseHeaders(200, response.length);
                OutputStream os = exchange.getResponseBody();
                os.write(response);
                os.close();
            }
        }
    }
    
    // Handler for API endpoints
    static class ApiHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "{\"message\": \"Hello from Java Backend!\", \"timestamp\": " + System.currentTimeMillis() + "}";
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
