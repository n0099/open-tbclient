package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ai f14150a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f173a;

    /* renamed from: a  reason: collision with other field name */
    private ScheduledThreadPoolExecutor f176a = new ScheduledThreadPoolExecutor(1);

    /* renamed from: a  reason: collision with other field name */
    private SparseArray<ScheduledFuture> f174a = new SparseArray<>();

    /* renamed from: a  reason: collision with other field name */
    private Object f175a = new Object();

    /* loaded from: classes6.dex */
    public static abstract class a implements Runnable {
        /* renamed from: a */
        public abstract int mo185a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        a f14151a;

        public b(a aVar) {
            this.f14151a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
        }

        void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.f14151a.run();
            b();
        }
    }

    private ai(Context context) {
        this.f173a = context.getSharedPreferences("mipush_extra", 0);
    }

    public static ai a(Context context) {
        if (f14150a == null) {
            synchronized (ai.class) {
                if (f14150a == null) {
                    f14150a = new ai(context);
                }
            }
        }
        return f14150a;
    }

    private static String a(int i) {
        return "last_job_time" + i;
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f175a) {
            scheduledFuture = this.f174a.get(aVar.mo185a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.f176a.schedule(runnable, i, TimeUnit.SECONDS);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m147a(int i) {
        synchronized (this.f175a) {
            ScheduledFuture scheduledFuture = this.f174a.get(i);
            if (scheduledFuture == null) {
                return false;
            }
            this.f174a.remove(i);
            return scheduledFuture.cancel(false);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m148a(a aVar) {
        return b(aVar, 0);
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        String a2 = a(aVar.mo185a());
        aj ajVar = new aj(this, aVar, a2);
        long abs = Math.abs(System.currentTimeMillis() - this.f173a.getLong(a2, 0L)) / 1000;
        if (abs < i - i2) {
            i2 = (int) (i - abs);
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f176a.scheduleAtFixedRate(ajVar, i2, i, TimeUnit.SECONDS);
            synchronized (this.f175a) {
                this.f174a.put(aVar.mo185a(), scheduleAtFixedRate);
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
        ScheduledFuture<?> schedule = this.f176a.schedule(new ak(this, aVar), i, TimeUnit.SECONDS);
        synchronized (this.f175a) {
            this.f174a.put(aVar.mo185a(), schedule);
        }
        return true;
    }
}
