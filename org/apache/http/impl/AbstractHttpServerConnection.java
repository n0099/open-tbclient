package org.apache.http.impl;

import java.io.IOException;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.impl.entity.EntityDeserializer;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes8.dex */
public abstract class AbstractHttpServerConnection implements HttpServerConnection {
    public AbstractHttpServerConnection() {
        throw new RuntimeException("Stub!");
    }

    public abstract void assertOpen() throws IllegalStateException;

    public EntityDeserializer createEntityDeserializer() {
        throw new RuntimeException("Stub!");
    }

    public EntitySerializer createEntitySerializer() {
        throw new RuntimeException("Stub!");
    }

    public HttpRequestFactory createHttpRequestFactory() {
        throw new RuntimeException("Stub!");
    }

    public HttpMessageParser createRequestParser(SessionInputBuffer sessionInputBuffer, HttpRequestFactory httpRequestFactory, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    public HttpMessageWriter createResponseWriter(SessionOutputBuffer sessionOutputBuffer, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    public void doFlush() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpServerConnection
    public void flush() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        throw new RuntimeException("Stub!");
    }

    public void init(SessionInputBuffer sessionInputBuffer, SessionOutputBuffer sessionOutputBuffer, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public boolean isStale() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpServerConnection
    public void receiveRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpServerConnection
    public HttpRequest receiveRequestHeader() throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpServerConnection
    public void sendResponseEntity(HttpResponse httpResponse) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpServerConnection
    public void sendResponseHeader(HttpResponse httpResponse) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }
}
