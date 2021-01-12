package com.bytedance.sdk.openadsdk.k;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7327a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b  reason: collision with root package name */
    private static final int f7328b;
    private static final int c;
    private static final int d;
    private static final PriorityBlockingQueue<Runnable> e;
    private static final PriorityBlockingQueue<Runnable> f;
    private static final PriorityBlockingQueue<Runnable> g;
    private static final ArrayBlockingQueue<Runnable> h;

    static {
        f7328b = (f7327a / 2) + 1 < 4 ? 4 : (f7327a / 2) + 1;
        c = (f7327a / 2) + 1 < 4 ? 4 : (f7327a / 2) + 1;
        d = (f7327a / 2) + 1 > 4 ? 4 : (f7327a / 2) + 1;
        e = new PriorityBlockingQueue<>();
        f = new PriorityBlockingQueue<>();
        g = new PriorityBlockingQueue<>();
        h = new ArrayBlockingQueue<>(4);
    }

    public static ThreadPoolExecutor a() {
        return new ThreadPoolExecutor(2, f7328b, 5L, TimeUnit.SECONDS, e, new d(5, "tt-api-thread-"), f());
    }

    public static ThreadPoolExecutor b() {
        return new ThreadPoolExecutor(2, c, 5L, TimeUnit.SECONDS, f, new d(5, "tt-background-thread-"), f());
    }

    public static ScheduledExecutorService c() {
        return Executors.newSingleThreadScheduledExecutor(new d(1, "tt-delay-thread-"));
    }

    public static ThreadPoolExecutor d() {
        return new ThreadPoolExecutor(0, 2, 5L, TimeUnit.SECONDS, g, new d(5, "tt-aidl-thread-"), f());
    }

    public static ThreadPoolExecutor e() {
        return new ThreadPoolExecutor(2, 4, 10L, TimeUnit.SECONDS, h, new d(5, "tt-file-log-upload-thread-"), f());
    }

    public static RejectedExecutionHandler f() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.k.e.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }
}
