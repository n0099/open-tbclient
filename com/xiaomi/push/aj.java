package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class aj {
    public static volatile aj a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f93a;

    /* renamed from: a  reason: collision with other field name */
    public ScheduledThreadPoolExecutor f96a = new ScheduledThreadPoolExecutor(1);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, ScheduledFuture> f95a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public Object f94a = new Object();

    /* loaded from: classes10.dex */
    public static abstract class a implements Runnable {
        /* renamed from: a */
        public abstract String mo310a();
    }

    /* loaded from: classes10.dex */
    public static class b implements Runnable {
        public a a;

        public b(a aVar) {
            this.a = aVar;
        }

        public void a() {
        }

        public void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.a.run();
            b();
        }
    }

    public aj(Context context) {
        this.f93a = context.getSharedPreferences("mipush_extra", 0);
    }

    public static aj a(Context context) {
        if (a == null) {
            synchronized (aj.class) {
                if (a == null) {
                    a = new aj(context);
                }
            }
        }
        return a;
    }

    public static String a(String str) {
        return "last_job_time" + str;
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f94a) {
            scheduledFuture = this.f95a.get(aVar.mo310a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.f96a.schedule(runnable, i, TimeUnit.SECONDS);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m269a(a aVar) {
        return b(aVar, 0);
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        return a(aVar, i, i2, false);
    }

    public boolean a(a aVar, int i, int i2, boolean z) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        String a2 = a(aVar.mo310a());
        ak akVar = new ak(this, aVar, z, a2);
        if (!z) {
            long abs = Math.abs(System.currentTimeMillis() - this.f93a.getLong(a2, 0L)) / 1000;
            if (abs < i - i2) {
                i2 = (int) (i - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f96a.scheduleAtFixedRate(akVar, i2, i, TimeUnit.SECONDS);
            synchronized (this.f94a) {
                this.f95a.put(aVar.mo310a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return true;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m270a(String str) {
        synchronized (this.f94a) {
            ScheduledFuture scheduledFuture = this.f95a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f95a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    public boolean b(a aVar, int i) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f96a.schedule(new al(this, aVar), i, TimeUnit.SECONDS);
        synchronized (this.f94a) {
            this.f95a.put(aVar.mo310a(), schedule);
        }
        return true;
    }
}
