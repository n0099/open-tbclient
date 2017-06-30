package com.xiaomi.channel.commonutils.misc;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class f {
    private static volatile f a;
    private ScheduledThreadPoolExecutor b = new ScheduledThreadPoolExecutor(1);
    private SparseArray<ScheduledFuture> c = new SparseArray<>();
    private Object d = new Object();
    private SharedPreferences e;

    /* loaded from: classes2.dex */
    public static abstract class a implements Runnable {
        public abstract int a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements Runnable {
        a c;

        public b(a aVar) {
            this.c = aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
        }

        void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.c.run();
            b();
        }
    }

    private f(Context context) {
        this.e = context.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
    }

    public static f a(Context context) {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f(context);
                }
            }
        }
        return a;
    }

    private static String a(int i) {
        return "last_job_time" + i;
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.d) {
            scheduledFuture = this.c.get(aVar.a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.b.schedule(runnable, i, TimeUnit.SECONDS);
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        String a2 = a(aVar.a());
        g gVar = new g(this, aVar, a2);
        long abs = Math.abs(System.currentTimeMillis() - this.e.getLong(a2, 0L)) / 1000;
        if (abs < i - i2) {
            i2 = (int) (i - abs);
        }
        ScheduledFuture<?> scheduleAtFixedRate = this.b.scheduleAtFixedRate(gVar, i2, i, TimeUnit.SECONDS);
        synchronized (this.d) {
            this.c.put(aVar.a(), scheduleAtFixedRate);
        }
        return true;
    }
}
