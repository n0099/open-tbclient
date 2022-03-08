package org.apache.http.impl.conn.tsccm;

import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ConnectionPoolTimeoutException;
@Deprecated
/* loaded from: classes9.dex */
public interface PoolEntryRequest {
    void abortRequest();

    BasicPoolEntry getPoolEntry(long j2, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException;
}
