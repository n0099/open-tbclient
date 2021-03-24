package com.vivo.push.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f39536a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f39537b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f39538c;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f39539d;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f39536a = availableProcessors;
        f39537b = Math.max(2, Math.min(availableProcessors - 1, 4));
        f39538c = (f39536a * 2) + 1;
        f39539d = a("COMMON_THREAD");
    }

    public static ExecutorService a(String str) {
        return new ThreadPoolExecutor(f39537b, f39538c, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new f(str), new ThreadPoolExecutor.DiscardPolicy());
    }
}
