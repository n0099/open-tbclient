package org.apache.http.conn;

import java.util.concurrent.TimeUnit;
@Deprecated
/* loaded from: classes20.dex */
public interface ClientConnectionRequest {
    void abortRequest();

    ManagedClientConnection getConnection(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException;
}
