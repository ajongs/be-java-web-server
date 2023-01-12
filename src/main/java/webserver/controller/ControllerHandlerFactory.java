package webserver.controller;

import webserver.domain.HttpRequest;

public class ControllerHandlerFactory {
    public static ControllerHandler getHandler(HttpRequest httpRequest) {
        String url = httpRequest.getRequestLine().getUrl();
        if (url.contains("?")) {
            return new QueryStringHandler(httpRequest);
        }
        return new StaticHandler(httpRequest);
    }
}
