package com.vivo.push.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f37525a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f37526b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f37527c;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f37528d;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f37525a = availableProcessors;
        f37526b = Math.max(2, Math.min(availableProcessors - 1, 4));
        f37527c = (f37525a * 2) + 1;
        f37528d = a("COMMON_THREAD");
    }

    public static ExecutorService a(String str) {
        return new ThreadPoolExecutor(f37526b, f37527c, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new f(str), new ThreadPoolExecutor.DiscardPolicy());
    }
}
