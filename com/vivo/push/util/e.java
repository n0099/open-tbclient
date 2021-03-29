package com.vivo.push.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f39537a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f39538b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f39539c;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f39540d;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f39537a = availableProcessors;
        f39538b = Math.max(2, Math.min(availableProcessors - 1, 4));
        f39539c = (f39537a * 2) + 1;
        f39540d = a("COMMON_THREAD");
    }

    public static ExecutorService a(String str) {
        return new ThreadPoolExecutor(f39538b, f39539c, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new f(str), new ThreadPoolExecutor.DiscardPolicy());
    }
}
