package com.vivo.push.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f36770a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f36771b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f36772c;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f36773d;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f36770a = availableProcessors;
        f36771b = Math.max(2, Math.min(availableProcessors - 1, 4));
        f36772c = (f36770a * 2) + 1;
        f36773d = a("COMMON_THREAD");
    }

    public static ExecutorService a(String str) {
        return new ThreadPoolExecutor(f36771b, f36772c, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new f(str), new ThreadPoolExecutor.DiscardPolicy());
    }
}
