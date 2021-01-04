package org.apache.http.message;

import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
@Deprecated
/* loaded from: classes6.dex */
public class BasicHttpRequest extends AbstractHttpMessage implements HttpRequest {
    public BasicHttpRequest(String str, String str2) {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpRequest(String str, String str2, ProtocolVersion protocolVersion) {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpRequest(RequestLine requestLine) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpRequest
    public RequestLine getRequestLine() {
        throw new RuntimeException("Stub!");
    }
}
