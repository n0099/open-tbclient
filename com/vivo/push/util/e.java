package com.vivo.push.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f40481a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f40482b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f40483c;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f40484d;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f40481a = availableProcessors;
        f40482b = Math.max(2, Math.min(availableProcessors - 1, 4));
        f40483c = (f40481a * 2) + 1;
        f40484d = a("COMMON_THREAD");
    }

    public static ExecutorService a(String str) {
        return new ThreadPoolExecutor(f40482b, f40483c, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new f(str), new ThreadPoolExecutor.DiscardPolicy());
    }
}
