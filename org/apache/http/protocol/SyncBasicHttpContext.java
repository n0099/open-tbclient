package org.apache.http.protocol;
@Deprecated
/* loaded from: classes7.dex */
public class SyncBasicHttpContext extends BasicHttpContext {
    public SyncBasicHttpContext(HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.BasicHttpContext, org.apache.http.protocol.HttpContext
    public synchronized Object getAttribute(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.BasicHttpContext, org.apache.http.protocol.HttpContext
    public synchronized Object removeAttribute(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.BasicHttpContext, org.apache.http.protocol.HttpContext
    public synchronized void setAttribute(String str, Object obj) {
        throw new RuntimeException("Stub!");
    }
}
