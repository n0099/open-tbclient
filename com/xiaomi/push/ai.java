package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ai f37368a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f103a;

    /* renamed from: a  reason: collision with other field name */
    public ScheduledThreadPoolExecutor f106a = new ScheduledThreadPoolExecutor(1);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, ScheduledFuture> f105a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public Object f104a = new Object();

    /* loaded from: classes7.dex */
    public static abstract class a implements Runnable {
        /* renamed from: a */
        public abstract String mo171a();
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public a f37369a;

        public b(a aVar) {
            this.f37369a = aVar;
        }

        public void a() {
        }

        public void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.f37369a.run();
            b();
        }
    }

    public ai(Context context) {
        this.f103a = context.getSharedPreferences("mipush_extra", 0);
    }

    public static ai a(Context context) {
        if (f37368a == null) {
            synchronized (ai.class) {
                if (f37368a == null) {
                    f37368a = new ai(context);
                }
            }
        }
        return f37368a;
    }

    public static String a(String str) {
        return "last_job_time" + str;
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f104a) {
            scheduledFuture = this.f105a.get(aVar.mo171a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i2) {
        this.f106a.schedule(runnable, i2, TimeUnit.SECONDS);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m129a(a aVar) {
        return b(aVar, 0);
    }

    public boolean a(a aVar, int i2) {
        return a(aVar, i2, 0);
    }

    public boolean a(a aVar, int i2, int i3) {
        return a(aVar, i2, i3, false);
    }

    public boolean a(a aVar, int i2, int i3, boolean z) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        String a2 = a(aVar.mo171a());
        aj ajVar = new aj(this, aVar, z, a2);
        if (!z) {
            long abs = Math.abs(System.currentTimeMillis() - this.f103a.getLong(a2, 0L)) / 1000;
            if (abs < i2 - i3) {
                i3 = (int) (i2 - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f106a.scheduleAtFixedRate(ajVar, i3, i2, TimeUnit.SECONDS);
            synchronized (this.f104a) {
                this.f105a.put(aVar.mo171a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return true;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m130a(String str) {
        synchronized (this.f104a) {
            ScheduledFuture scheduledFuture = this.f105a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f105a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    public boolean b(a aVar, int i2) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f106a.schedule(new ak(this, aVar), i2, TimeUnit.SECONDS);
        synchronized (this.f104a) {
            this.f105a.put(aVar.mo171a(), schedule);
        }
        return true;
    }
}
