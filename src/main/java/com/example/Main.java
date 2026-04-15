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
            String path = exchange.getRequestURI().getPath();
            // Basic static file serving for our small site
            if (path.equals("/") || path.equals("/index.html")) {
                // Serve the main home page
                byte[] response = Files.readAllBytes(Paths.get("src/main/resources/index.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/index2.html")) {
                // Serve the quiz creation page
                byte[] response = Files.readAllBytes(Paths.get("src/main/resources/index2.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1-math-topics.html")) {
                // Serve the grade 1 math topics page
                byte[] response = Files.readAllBytes(Paths.get("grade1-math-topics.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1-addition.html")) {
                // Serve the grade 1 addition page
                byte[] response = Files.readAllBytes(Paths.get("grade1-addition.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1-subtraction.html")) {
                // Serve the grade 1 subtraction page
                byte[] response = Files.readAllBytes(Paths.get("grade1-subtraction.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1-shapes.html")) {
                // Serve the grade 1 shapes page
                byte[] response = Files.readAllBytes(Paths.get("grade1-shapes.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1-counting.html")) {
                // Serve the grade 1 counting page
                byte[] response = Files.readAllBytes(Paths.get("grade1-counting.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/homepage.html")) {
                // Serve the homepage
                byte[] response = Files.readAllBytes(Paths.get("homepage.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/startquiz.html")) {
                // Serve the start quiz page
                byte[] response = Files.readAllBytes(Paths.get("startquiz.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1/history/grade1-history.html")) {
                // Serve the grade 1 history page
                byte[] response = Files.readAllBytes(Paths.get("grade1/history/grade1-history.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1/history/grade1-history-known-people.html")) {
                // Serve the grade 1 history known people page
                byte[] response = Files.readAllBytes(Paths.get("grade1/history/grade1-history-known-people.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1/history/grade1-history-landmarks.html")) {
                // Serve the grade 1 history landmarks page
                byte[] response = Files.readAllBytes(Paths.get("grade1/history/grade1-history-landmarks.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1/history/grade1-history-maps.html")) {
                // Serve the grade 1 history maps page
                byte[] response = Files.readAllBytes(Paths.get("grade1/history/grade1-history-maps.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1/history/grade1-history-symbols.html")) {
                // Serve the grade 1 history symbols page
                byte[] response = Files.readAllBytes(Paths.get("grade1/history/grade1-history-symbols.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1/reading/comp.html")) {
                // Serve the grade 1 reading comp page
                byte[] response = Files.readAllBytes(Paths.get("grade1/reading/comp.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1/reading/grade1-phonics.html")) {
                // Serve the grade 1 reading phonics page
                byte[] response = Files.readAllBytes(Paths.get("grade1/reading/grade1-phonics.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1/reading/grade1-reading.html")) {
                // Serve the grade 1 reading page
                byte[] response = Files.readAllBytes(Paths.get("grade1/reading/grade1-reading.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1/reading/grade1-vocabulary.html")) {
                // Serve the grade 1 reading vocabulary page
                byte[] response = Files.readAllBytes(Paths.get("grade1/reading/grade1-vocabulary.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1/reading/grade1-writing.html")) {
                // Serve the grade 1 reading writing page
                byte[] response = Files.readAllBytes(Paths.get("grade1/reading/grade1-writing.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1/science/grade1-animals.html")) {
                // Serve the grade 1 science animals page
                byte[] response = Files.readAllBytes(Paths.get("grade1/science/grade1-animals.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1/science/grade1-plants.html")) {
                // Serve the grade 1 science plants page
                byte[] response = Files.readAllBytes(Paths.get("grade1/science/grade1-plants.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1/science/grade1-science-topics.html")) {
                // Serve the grade 1 science topics page
                byte[] response = Files.readAllBytes(Paths.get("grade1/science/grade1-science-topics.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1/science/grade1-solarsystems.html")) {
                // Serve the grade 1 science solarsystems page
                byte[] response = Files.readAllBytes(Paths.get("grade1/science/grade1-solarsystems.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade1/science/grade1-weather.html")) {
                // Serve the grade 1 science weather page
                byte[] response = Files.readAllBytes(Paths.get("grade1/science/grade1-weather.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade2/grade2-math-topics.html")) {
                // Serve the grade 2 math topics page
                byte[] response = Files.readAllBytes(Paths.get("grade2/grade2-math-topics.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade2/grade2-money.html")) {
                // Serve the grade 2 money page
                byte[] response = Files.readAllBytes(Paths.get("grade2/grade2-money.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade2/grade2-plants.html.html")) {
                // Serve the grade 2 plants page
                byte[] response = Files.readAllBytes(Paths.get("grade2/grade2-plants.html.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade2/grade2-science-topics.html")) {
                // Serve the grade 2 science topics page
                byte[] response = Files.readAllBytes(Paths.get("grade2/grade2-science-topics.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade2/grade2-shapes.html")) {
                // Serve the grade 2 shapes page
                byte[] response = Files.readAllBytes(Paths.get("grade2/grade2-shapes.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade2/grade2-sub.html")) {
                // Serve the grade 2 sub page
                byte[] response = Files.readAllBytes(Paths.get("grade2/grade2-sub.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-math-topics.html")) {
                // Serve the grade 3 math topics page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-math-topics.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-mult-div.html")) {
                // Serve the grade 3 multiplication and division page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-mult-div.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-add-sub.html")) {
                // Serve the grade 3 addition and subtraction page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-add-sub.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-area-perim.html")) {
                // Serve the grade 3 area and perimeter page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-area-perim.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-estimation.html")) {
                // Serve the grade 3 estimation page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-estimation.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-science-topics.html")) {
                // Serve the grade 3 science topics page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-science-topics.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-weather.html")) {
                // Serve the grade 3 weather page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-weather.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-matter.html")) {
                // Serve the grade 3 states of matter page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-matter.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-ecosystems.html")) {
                // Serve the grade 3 ecosystems page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-ecosystems.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-physics.html")) {
                // Serve the grade 3 physics page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-physics.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-reading-topics.html")) {
                // Serve the grade 3 reading topics page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-reading-topics.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-foundations.html")) {
                // Serve the grade 3 reading foundations page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-foundations.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-strategies.html")) {
                // Serve the grade 3 reading strategies page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-strategies.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-vocab.html")) {
                // Serve the grade 3 vocabulary page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-vocab.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-history-topics.html")) {
                // Serve the grade 3 history topics page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-history-topics.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-communities.html")) {
                // Serve the grade 3 communities page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-communities.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-amer-hist.html")) {
                // Serve the grade 3 american history page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-amer-hist.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-geography.html")) {
                // Serve the grade 3 geography page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-geography.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.equals("/grade 3/grade3-economics.html")) {
                // Serve the grade 3 economics page
                byte[] response = Files.readAllBytes(Paths.get("grade 3/grade3-economics.html"));
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            } else if (path.endsWith(".css") || path.endsWith(".js")) {
                // Serve static CSS/JS assets from resources
                String filePath = "src/main/resources" + path;
                java.nio.file.Path p = Paths.get(filePath);
                if (Files.exists(p)) {
                    byte[] response = Files.readAllBytes(p);
                    String contentType = path.endsWith(".css") ? "text/css" : "application/javascript";
                    exchange.getResponseHeaders().set("Content-Type", contentType);
                    exchange.sendResponseHeaders(200, response.length);
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(response);
                    }
                } else {
                    exchange.sendResponseHeaders(404, -1);
                }
            } 
            else {
                // Fallback - not found
                exchange.sendResponseHeaders(404, -1);
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
