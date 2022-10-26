package org.apache.http.client;

import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
@Deprecated
/* loaded from: classes8.dex */
public interface HttpClient {
    Object execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler) throws IOException, ClientProtocolException;

    Object execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException;

    Object execute(HttpUriRequest httpUriRequest, ResponseHandler responseHandler) throws IOException, ClientProtocolException;

    Object execute(HttpUriRequest httpUriRequest, ResponseHandler responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException;

    HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException, ClientProtocolException;

    HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException;

    HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException, ClientProtocolException;

    HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException, ClientProtocolException;

    ClientConnectionManager getConnectionManager();

    HttpParams getParams();
}
