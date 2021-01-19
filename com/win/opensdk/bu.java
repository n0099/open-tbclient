package com.win.opensdk;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes3.dex */
public final class bu {
    private static bu qax = new bu();
    public boolean pYM = false;
    public ThreadPoolExecutor qaj = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    public i qay;

    private bu() {
    }

    public static bu eHa() {
        return qax;
    }
}
