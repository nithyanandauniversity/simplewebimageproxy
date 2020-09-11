package org.knhu;

import static spark.Spark.*;
public class WebServer {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
        get("/img", (req, res) -> {
            var url = req.queryString();
            var bytes = HttpClient.get(url);
            var out = ImageProcessor.get(bytes);
            res.type("image/webp");
            System.out.println(url +" "+ bytes.length + " " + out.length);
            return out;
        });
    }
}
