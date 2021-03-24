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
    public static final BlockingQueue f39830b = new LinkedBlockingQueue((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST);

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadFactory f39831c = new W1();

    /* renamed from: d  reason: collision with root package name */
    public static X1 f39832d;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f39833a = new ThreadPoolExecutor(5, 60, 1, TimeUnit.SECONDS, f39830b, f39831c);

    public static synchronized X1 a() {
        X1 x1;
        synchronized (X1.class) {
            if (f39832d == null) {
                f39832d = new X1();
            }
            x1 = f39832d;
        }
        return x1;
    }

    public static void a(Runnable runnable) {
        a().f39833a.execute(runnable);
    }
}
