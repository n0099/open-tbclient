package com.vivo.push.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes14.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final int f8074a = Runtime.getRuntime().availableProcessors();
    private static final int b = Math.max(2, Math.min(f8074a - 1, 4));
    private static final int c = (f8074a * 2) + 1;
    private static ExecutorService d = a("COMMON_THREAD");

    public static ExecutorService a(String str) {
        return new ThreadPoolExecutor(b, c, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new f(str), new ThreadPoolExecutor.DiscardPolicy());
    }
}
