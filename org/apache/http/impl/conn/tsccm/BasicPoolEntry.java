package org.apache.http.impl.conn.tsccm;

import java.lang.ref.ReferenceQueue;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.AbstractPoolEntry;
@Deprecated
/* loaded from: classes9.dex */
public class BasicPoolEntry extends AbstractPoolEntry {
    public BasicPoolEntry(ClientConnectionOperator clientConnectionOperator, HttpRoute httpRoute, ReferenceQueue<Object> referenceQueue) {
        super(null, null);
        throw new RuntimeException("Stub!");
    }

    protected final OperatedClientConnection getConnection() {
        throw new RuntimeException("Stub!");
    }

    protected final HttpRoute getPlannedRoute() {
        throw new RuntimeException("Stub!");
    }

    protected final BasicPoolEntryRef getWeakRef() {
        throw new RuntimeException("Stub!");
    }
}
