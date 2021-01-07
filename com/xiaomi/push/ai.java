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
    private static volatile ai f14151a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f174a;

    /* renamed from: a  reason: collision with other field name */
    private ScheduledThreadPoolExecutor f177a = new ScheduledThreadPoolExecutor(1);

    /* renamed from: a  reason: collision with other field name */
    private SparseArray<ScheduledFuture> f175a = new SparseArray<>();

    /* renamed from: a  reason: collision with other field name */
    private Object f176a = new Object();

    /* loaded from: classes6.dex */
    public static abstract class a implements Runnable {
        /* renamed from: a */
        public abstract int mo196a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        a f14152a;

        public b(a aVar) {
            this.f14152a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
        }

        void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.f14152a.run();
            b();
        }
    }

    private ai(Context context) {
        this.f174a = context.getSharedPreferences("mipush_extra", 0);
    }

    public static ai a(Context context) {
        if (f14151a == null) {
            synchronized (ai.class) {
                if (f14151a == null) {
                    f14151a = new ai(context);
                }
            }
        }
        return f14151a;
    }

    private static String a(int i) {
        return "last_job_time" + i;
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f176a) {
            scheduledFuture = this.f175a.get(aVar.mo196a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.f177a.schedule(runnable, i, TimeUnit.SECONDS);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m158a(int i) {
        synchronized (this.f176a) {
            ScheduledFuture scheduledFuture = this.f175a.get(i);
            if (scheduledFuture == null) {
                return false;
            }
            this.f175a.remove(i);
            return scheduledFuture.cancel(false);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m159a(a aVar) {
        return b(aVar, 0);
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        String a2 = a(aVar.mo196a());
        aj ajVar = new aj(this, aVar, a2);
        long abs = Math.abs(System.currentTimeMillis() - this.f174a.getLong(a2, 0L)) / 1000;
        if (abs < i - i2) {
            i2 = (int) (i - abs);
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f177a.scheduleAtFixedRate(ajVar, i2, i, TimeUnit.SECONDS);
            synchronized (this.f176a) {
                this.f175a.put(aVar.mo196a(), scheduleAtFixedRate);
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
        ScheduledFuture<?> schedule = this.f177a.schedule(new ak(this, aVar), i, TimeUnit.SECONDS);
        synchronized (this.f176a) {
            this.f175a.put(aVar.mo196a(), schedule);
        }
        return true;
    }
}
