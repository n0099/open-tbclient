package org.apache.http.client.methods;

import java.io.IOException;
import java.net.URI;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.message.AbstractHttpMessage;
@Deprecated
/* loaded from: classes8.dex */
public abstract class HttpRequestBase extends AbstractHttpMessage implements HttpUriRequest, AbortableHttpRequest {
    public HttpRequestBase() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.HttpUriRequest, org.apache.http.client.methods.AbortableHttpRequest
    public void abort() {
        throw new RuntimeException("Stub!");
    }

    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }

    public abstract String getMethod();

    @Override // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpRequest
    public RequestLine getRequestLine() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public URI getURI() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public boolean isAborted() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.AbortableHttpRequest
    public void setConnectionRequest(ClientConnectionRequest clientConnectionRequest) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.AbortableHttpRequest
    public void setReleaseTrigger(ConnectionReleaseTrigger connectionReleaseTrigger) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void setURI(URI uri) {
        throw new RuntimeException("Stub!");
    }
}
