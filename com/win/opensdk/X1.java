package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class X1 {

    /* renamed from: b  reason: collision with root package name */
    public static final BlockingQueue f40215b = new LinkedBlockingQueue((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST);

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadFactory f40216c = new W1();

    /* renamed from: d  reason: collision with root package name */
    public static X1 f40217d;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f40218a = new ThreadPoolExecutor(5, 60, 1, TimeUnit.SECONDS, f40215b, f40216c);

    public static synchronized X1 a() {
        X1 x1;
        synchronized (X1.class) {
            if (f40217d == null) {
                f40217d = new X1();
            }
            x1 = f40217d;
        }
        return x1;
    }

    public static void a(Runnable runnable) {
        a().f40218a.execute(runnable);
    }
}
