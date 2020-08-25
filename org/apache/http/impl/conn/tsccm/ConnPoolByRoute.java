package org.apache.http.impl.conn.tsccm;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes9.dex */
public class ConnPoolByRoute extends AbstractConnPool {
    protected Queue<BasicPoolEntry> freeConnections;
    protected final int maxTotalConnections;
    protected final ClientConnectionOperator operator;
    protected final Map<HttpRoute, RouteSpecificPool> routeToPool;
    protected Queue<WaitingThread> waitingThreads;

    public ConnPoolByRoute(ClientConnectionOperator clientConnectionOperator, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    protected Queue<BasicPoolEntry> createFreeConnQueue() {
        throw new RuntimeException("Stub!");
    }

    protected Queue<WaitingThread> createWaitingThreadQueue() {
        throw new RuntimeException("Stub!");
    }

    protected Map<HttpRoute, RouteSpecificPool> createRouteToPoolMap() {
        throw new RuntimeException("Stub!");
    }

    protected RouteSpecificPool newRouteSpecificPool(HttpRoute httpRoute) {
        throw new RuntimeException("Stub!");
    }

    protected WaitingThread newWaitingThread(Condition condition, RouteSpecificPool routeSpecificPool) {
        throw new RuntimeException("Stub!");
    }

    protected RouteSpecificPool getRoutePool(HttpRoute httpRoute, boolean z) {
        throw new RuntimeException("Stub!");
    }

    public int getConnectionsInPool(HttpRoute httpRoute) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public PoolEntryRequest requestPoolEntry(HttpRoute httpRoute, Object obj) {
        throw new RuntimeException("Stub!");
    }

    protected BasicPoolEntry getEntryBlocking(HttpRoute httpRoute, Object obj, long j, TimeUnit timeUnit, WaitingThreadAborter waitingThreadAborter) throws ConnectionPoolTimeoutException, InterruptedException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public void freeEntry(BasicPoolEntry basicPoolEntry, boolean z, long j, TimeUnit timeUnit) {
        throw new RuntimeException("Stub!");
    }

    protected BasicPoolEntry getFreeEntry(RouteSpecificPool routeSpecificPool, Object obj) {
        throw new RuntimeException("Stub!");
    }

    protected BasicPoolEntry createEntry(RouteSpecificPool routeSpecificPool, ClientConnectionOperator clientConnectionOperator) {
        throw new RuntimeException("Stub!");
    }

    protected void deleteEntry(BasicPoolEntry basicPoolEntry) {
        throw new RuntimeException("Stub!");
    }

    protected void deleteLeastUsedEntry() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.conn.tsccm.AbstractConnPool
    protected void handleLostEntry(HttpRoute httpRoute) {
        throw new RuntimeException("Stub!");
    }

    protected void notifyWaitingThread(RouteSpecificPool routeSpecificPool) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public void deleteClosedConnections() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public void shutdown() {
        throw new RuntimeException("Stub!");
    }
}
