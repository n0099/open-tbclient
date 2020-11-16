package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpMessage;
import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes12.dex */
public abstract class AbstractHttpMessage implements HttpMessage {
    protected HeaderGroup headergroup;
    protected HttpParams params;

    protected AbstractHttpMessage(HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractHttpMessage() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public boolean containsHeader(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public Header[] getHeaders(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public Header getFirstHeader(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public Header getLastHeader(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public Header[] getAllHeaders() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void addHeader(Header header) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void addHeader(String str, String str2) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void setHeader(Header header) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void setHeader(String str, String str2) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void setHeaders(Header[] headerArr) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void removeHeader(Header header) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void removeHeaders(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public HeaderIterator headerIterator() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public HeaderIterator headerIterator(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public HttpParams getParams() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void setParams(HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }
}
