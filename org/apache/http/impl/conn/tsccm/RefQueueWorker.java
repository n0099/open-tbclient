package org.apache.http.impl.conn.tsccm;

import java.lang.ref.ReferenceQueue;
@Deprecated
/* loaded from: classes8.dex */
public class RefQueueWorker implements Runnable {
    public final RefQueueHandler refHandler;
    public final ReferenceQueue<?> refQueue;
    public volatile Thread workerThread;

    public RefQueueWorker(ReferenceQueue<?> referenceQueue, RefQueueHandler refQueueHandler) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new RuntimeException("Stub!");
    }

    public void shutdown() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
