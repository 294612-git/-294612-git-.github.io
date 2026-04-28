package com.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create HTTP server on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        // Create context for handling requests
        server.createContext("/", new StaticFileHandler());
        server.createContext("/api/data", new ApiHandler());
        
        server.setExecutor(null); // Creates a default executor
        server.start();
        System.out.println("Server running on http://localhost:8080");
    }
    
    // Handler for serving static files
    static class StaticFileHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String rawPath = exchange.getRequestURI().getPath();
            if (rawPath == null || rawPath.isEmpty()) {
                rawPath = "/";
            }
            rawPath = URLDecoder.decode(rawPath, StandardCharsets.UTF_8.name());
            if (rawPath.equals("/")) {
                rawPath = "/index.html";
            }

            Path filePath = resolveStaticPath(rawPath);
            if (filePath == null || !Files.exists(filePath) || Files.isDirectory(filePath)) {
                exchange.sendResponseHeaders(404, -1);
                return;
            }

            byte[] response = Files.readAllBytes(filePath);
            exchange.getResponseHeaders().set("Content-Type", getContentType(filePath));
            exchange.sendResponseHeaders(200, response.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response);
            }
        }

        private Path resolveStaticPath(String rawPath) {
            String trimmed = rawPath.startsWith("/") ? rawPath.substring(1) : rawPath;
            Path normalized = Paths.get(trimmed).normalize();
            if (normalized.startsWith("..")) {
                return null;
            }

            Path resourcePath = Paths.get("src/main/resources").resolve(normalized);
            if (Files.exists(resourcePath) && !Files.isDirectory(resourcePath)) {
                return resourcePath;
            }

            Path rootPath = Paths.get(".").resolve(normalized).normalize();
            if (Files.exists(rootPath) && !Files.isDirectory(rootPath)) {
                return rootPath;
            }

            if ("grade2/grade2-plants.html".equals(trimmed)) {
                Path alt = Paths.get("grade2/grade2-plants.html.html");
                if (Files.exists(alt) && !Files.isDirectory(alt)) {
                    return alt;
                }
            }

            return null;
        }

        private String getContentType(Path path) {
            String name = path.getFileName().toString().toLowerCase();
            int idx = name.lastIndexOf('.');
            String ext = idx >= 0 ? name.substring(idx + 1) : "";
            if (ext.equals("html") || ext.equals("htm")) {
                return "text/html";
            } else if (ext.equals("css")) {
                return "text/css";
            } else if (ext.equals("js")) {
                return "application/javascript";
            } else if (ext.equals("json")) {
                return "application/json";
            } else if (ext.equals("png")) {
                return "image/png";
            } else if (ext.equals("jpg") || ext.equals("jpeg")) {
                return "image/jpeg";
            } else if (ext.equals("gif")) {
                return "image/gif";
            } else if (ext.equals("svg")) {
                return "image/svg+xml";
            } else {
                return "application/octet-stream";
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
