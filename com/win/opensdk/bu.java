package com.win.opensdk;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes4.dex */
public final class bu {
    private static bu qdp = new bu();
    public boolean qbE = false;
    public ThreadPoolExecutor qdb = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    public i qdq;

    private bu() {
    }

    public static bu eKm() {
        return qdp;
    }
}
