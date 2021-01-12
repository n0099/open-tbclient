package com.win.opensdk;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes3.dex */
public final class bu {
    private static bu qaw = new bu();
    public boolean pYL = false;
    public ThreadPoolExecutor qai = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    public i qax;

    private bu() {
    }

    public static bu eHa() {
        return qaw;
    }
}
