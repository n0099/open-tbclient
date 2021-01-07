package com.win.opensdk;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes4.dex */
public final class bu {
    private static bu qeX = new bu();
    public boolean qdm = false;
    public ThreadPoolExecutor qeJ = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    public i qeY;

    private bu() {
    }

    public static bu eKQ() {
        return qeX;
    }
}
