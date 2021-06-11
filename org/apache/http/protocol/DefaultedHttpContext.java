package org.apache.http.protocol;
@Deprecated
/* loaded from: classes8.dex */
public final class DefaultedHttpContext implements HttpContext {
    public DefaultedHttpContext(HttpContext httpContext, HttpContext httpContext2) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpContext
    public Object getAttribute(String str) {
        throw new RuntimeException("Stub!");
    }

    public HttpContext getDefaults() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpContext
    public Object removeAttribute(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpContext
    public void setAttribute(String str, Object obj) {
        throw new RuntimeException("Stub!");
    }
}
