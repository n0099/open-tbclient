package com.win.opensdk;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes3.dex */
public final class bu {
    private static bu qlb = new bu();
    public boolean qjq = false;
    public ThreadPoolExecutor qkN = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    public i qlc;

    private bu() {
    }

    public static bu eJy() {
        return qlb;
    }
}
