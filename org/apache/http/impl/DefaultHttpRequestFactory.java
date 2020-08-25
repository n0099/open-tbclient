package org.apache.http.impl;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.RequestLine;
@Deprecated
/* loaded from: classes9.dex */
public class DefaultHttpRequestFactory implements HttpRequestFactory {
    public DefaultHttpRequestFactory() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpRequestFactory
    public HttpRequest newHttpRequest(RequestLine requestLine) throws MethodNotSupportedException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpRequestFactory
    public HttpRequest newHttpRequest(String str, String str2) throws MethodNotSupportedException {
        throw new RuntimeException("Stub!");
    }
}
