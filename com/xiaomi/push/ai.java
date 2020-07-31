package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class ai {
    private static volatile ai a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f96a;

    /* renamed from: a  reason: collision with other field name */
    private ScheduledThreadPoolExecutor f99a = new ScheduledThreadPoolExecutor(1);

    /* renamed from: a  reason: collision with other field name */
    private SparseArray<ScheduledFuture> f97a = new SparseArray<>();

    /* renamed from: a  reason: collision with other field name */
    private Object f98a = new Object();

    /* loaded from: classes9.dex */
    public static abstract class a implements Runnable {
        /* renamed from: a */
        public abstract int mo161a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b implements Runnable {
        a a;

        public b(a aVar) {
            this.a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
        }

        void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.a.run();
            b();
        }
    }

    private ai(Context context) {
        this.f96a = context.getSharedPreferences("mipush_extra", 0);
    }

    public static ai a(Context context) {
        if (a == null) {
            synchronized (ai.class) {
                if (a == null) {
                    a = new ai(context);
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
        synchronized (this.f98a) {
            scheduledFuture = this.f97a.get(aVar.mo161a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.f99a.schedule(runnable, i, TimeUnit.SECONDS);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m123a(int i) {
        synchronized (this.f98a) {
            ScheduledFuture scheduledFuture = this.f97a.get(i);
            if (scheduledFuture == null) {
                return false;
            }
            this.f97a.remove(i);
            return scheduledFuture.cancel(false);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m124a(a aVar) {
        return b(aVar, 0);
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        String a2 = a(aVar.mo161a());
        aj ajVar = new aj(this, aVar, a2);
        long abs = Math.abs(System.currentTimeMillis() - this.f96a.getLong(a2, 0L)) / 1000;
        if (abs < i - i2) {
            i2 = (int) (i - abs);
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f99a.scheduleAtFixedRate(ajVar, i2, i, TimeUnit.SECONDS);
            synchronized (this.f98a) {
                this.f97a.put(aVar.mo161a(), scheduleAtFixedRate);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
        return true;
    }

    public boolean b(a aVar, int i) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f99a.schedule(new ak(this, aVar), i, TimeUnit.SECONDS);
        synchronized (this.f98a) {
            this.f97a.put(aVar.mo161a(), schedule);
        }
        return true;
    }
}
