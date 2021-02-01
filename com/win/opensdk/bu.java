package com.win.opensdk;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes3.dex */
public final class bu {
    private static bu qkB = new bu();
    public i qkC;
    public boolean qiQ = false;
    public ThreadPoolExecutor qkn = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    private bu() {
    }

    public static bu eJq() {
        return qkB;
    }
}
