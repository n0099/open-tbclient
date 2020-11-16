package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes18.dex */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ai f4789a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f97a;

    /* renamed from: a  reason: collision with other field name */
    private ScheduledThreadPoolExecutor f100a = new ScheduledThreadPoolExecutor(1);

    /* renamed from: a  reason: collision with other field name */
    private SparseArray<ScheduledFuture> f98a = new SparseArray<>();

    /* renamed from: a  reason: collision with other field name */
    private Object f99a = new Object();

    /* loaded from: classes18.dex */
    public static abstract class a implements Runnable {
        /* renamed from: a */
        public abstract int mo169a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        a f4790a;

        public b(a aVar) {
            this.f4790a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
        }

        void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.f4790a.run();
            b();
        }
    }

    private ai(Context context) {
        this.f97a = context.getSharedPreferences("mipush_extra", 0);
    }

    public static ai a(Context context) {
        if (f4789a == null) {
            synchronized (ai.class) {
                if (f4789a == null) {
                    f4789a = new ai(context);
                }
            }
        }
        return f4789a;
    }

    private static String a(int i) {
        return "last_job_time" + i;
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f99a) {
            scheduledFuture = this.f98a.get(aVar.mo169a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.f100a.schedule(runnable, i, TimeUnit.SECONDS);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m131a(int i) {
        synchronized (this.f99a) {
            ScheduledFuture scheduledFuture = this.f98a.get(i);
            if (scheduledFuture == null) {
                return false;
            }
            this.f98a.remove(i);
            return scheduledFuture.cancel(false);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m132a(a aVar) {
        return b(aVar, 0);
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        String a2 = a(aVar.mo169a());
        aj ajVar = new aj(this, aVar, a2);
        long abs = Math.abs(System.currentTimeMillis() - this.f97a.getLong(a2, 0L)) / 1000;
        if (abs < i - i2) {
            i2 = (int) (i - abs);
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f100a.scheduleAtFixedRate(ajVar, i2, i, TimeUnit.SECONDS);
            synchronized (this.f99a) {
                this.f98a.put(aVar.mo169a(), scheduleAtFixedRate);
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
        ScheduledFuture<?> schedule = this.f100a.schedule(new ak(this, aVar), i, TimeUnit.SECONDS);
        synchronized (this.f99a) {
            this.f98a.put(aVar.mo169a(), schedule);
        }
        return true;
    }
}
