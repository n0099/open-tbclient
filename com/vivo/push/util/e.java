package com.vivo.push.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f36699a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f36700b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f36701c;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f36702d;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f36699a = availableProcessors;
        f36700b = Math.max(2, Math.min(availableProcessors - 1, 4));
        f36701c = (f36699a * 2) + 1;
        f36702d = a("COMMON_THREAD");
    }

    public static ExecutorService a(String str) {
        return new ThreadPoolExecutor(f36700b, f36701c, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new f(str), new ThreadPoolExecutor.DiscardPolicy());
    }
}
