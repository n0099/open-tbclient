package org.apache.http.impl.conn;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.OperatedClientConnection;
@Deprecated
/* loaded from: classes6.dex */
public abstract class AbstractClientConnAdapter implements ManagedClientConnection {
    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractClientConnAdapter(ClientConnectionManager clientConnectionManager, OperatedClientConnection operatedClientConnection) {
        throw new RuntimeException("Stub!");
    }

    protected void detach() {
        throw new RuntimeException("Stub!");
    }

    protected OperatedClientConnection getWrappedConnection() {
        throw new RuntimeException("Stub!");
    }

    protected ClientConnectionManager getManager() {
        throw new RuntimeException("Stub!");
    }

    protected final void assertNotAborted() throws InterruptedIOException {
        throw new RuntimeException("Stub!");
    }

    protected final void assertValid(OperatedClientConnection operatedClientConnection) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public boolean isOpen() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public boolean isStale() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public void setSocketTimeout(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public int getSocketTimeout() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpClientConnection
    public void flush() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpClientConnection
    public boolean isResponseAvailable(int i) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpClientConnection
    public void receiveResponseEntity(HttpResponse httpResponse) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpClientConnection
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpClientConnection
    public void sendRequestHeader(HttpRequest httpRequest) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getLocalAddress() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public int getLocalPort() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getRemoteAddress() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public int getRemotePort() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public boolean isSecure() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public SSLSession getSSLSession() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void markReusable() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void unmarkReusable() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public boolean isMarkedReusable() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void setIdleDuration(long j, TimeUnit timeUnit) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ConnectionReleaseTrigger
    public void releaseConnection() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ConnectionReleaseTrigger
    public void abortConnection() {
        throw new RuntimeException("Stub!");
    }
}
