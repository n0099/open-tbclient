package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class u1 {

    /* renamed from: b  reason: collision with root package name */
    public static final BlockingQueue f37127b = new LinkedBlockingQueue((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST);

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadFactory f37128c = new t1();

    /* renamed from: d  reason: collision with root package name */
    public static u1 f37129d;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f37130a = new ThreadPoolExecutor(5, 60, 1, TimeUnit.SECONDS, f37127b, f37128c);

    public static synchronized u1 a() {
        u1 u1Var;
        synchronized (u1.class) {
            if (f37129d == null) {
                f37129d = new u1();
            }
            u1Var = f37129d;
        }
        return u1Var;
    }

    public static void a(Runnable runnable) {
        a().f37130a.execute(runnable);
    }
}
