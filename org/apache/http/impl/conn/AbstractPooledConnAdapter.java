package org.apache.http.impl.conn;

import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
@Deprecated
/* loaded from: classes7.dex */
public abstract class AbstractPooledConnAdapter extends AbstractClientConnAdapter {
    public volatile AbstractPoolEntry poolEntry;

    public AbstractPooledConnAdapter(ClientConnectionManager clientConnectionManager, AbstractPoolEntry abstractPoolEntry) {
        super(null, null);
        throw new RuntimeException("Stub!");
    }

    public final void assertAttached() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.conn.AbstractClientConnAdapter
    public void detach() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public HttpRoute getRoute() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public Object getState() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void layerProtocol(HttpContext httpContext, HttpParams httpParams) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void open(HttpRoute httpRoute, HttpContext httpContext, HttpParams httpParams) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void setState(Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public void shutdown() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void tunnelProxy(HttpHost httpHost, boolean z, HttpParams httpParams) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void tunnelTarget(boolean z, HttpParams httpParams) throws IOException {
        throw new RuntimeException("Stub!");
    }
}
