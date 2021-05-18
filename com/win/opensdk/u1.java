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
    public static final BlockingQueue f37198b = new LinkedBlockingQueue((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST);

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadFactory f37199c = new t1();

    /* renamed from: d  reason: collision with root package name */
    public static u1 f37200d;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f37201a = new ThreadPoolExecutor(5, 60, 1, TimeUnit.SECONDS, f37198b, f37199c);

    public static synchronized u1 a() {
        u1 u1Var;
        synchronized (u1.class) {
            if (f37200d == null) {
                f37200d = new u1();
            }
            u1Var = f37200d;
        }
        return u1Var;
    }

    public static void a(Runnable runnable) {
        a().f37201a.execute(runnable);
    }
}
