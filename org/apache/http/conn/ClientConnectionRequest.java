package org.apache.http.conn;

import java.util.concurrent.TimeUnit;
@Deprecated
/* loaded from: classes5.dex */
public interface ClientConnectionRequest {
    void abortRequest();

    ManagedClientConnection getConnection(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException;
}
