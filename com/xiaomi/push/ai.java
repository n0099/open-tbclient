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
    public static volatile ai f40513a;

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
        public abstract String mo169a();
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public a f40514a;

        public b(a aVar) {
            this.f40514a = aVar;
        }

        public void a() {
        }

        public void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.f40514a.run();
            b();
        }
    }

    public ai(Context context) {
        this.f103a = context.getSharedPreferences("mipush_extra", 0);
    }

    public static ai a(Context context) {
        if (f40513a == null) {
            synchronized (ai.class) {
                if (f40513a == null) {
                    f40513a = new ai(context);
                }
            }
        }
        return f40513a;
    }

    public static String a(String str) {
        return "last_job_time" + str;
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f104a) {
            scheduledFuture = this.f105a.get(aVar.mo169a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.f106a.schedule(runnable, i, TimeUnit.SECONDS);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m127a(a aVar) {
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
        String a2 = a(aVar.mo169a());
        aj ajVar = new aj(this, aVar, z, a2);
        if (!z) {
            long abs = Math.abs(System.currentTimeMillis() - this.f103a.getLong(a2, 0L)) / 1000;
            if (abs < i - i2) {
                i2 = (int) (i - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f106a.scheduleAtFixedRate(ajVar, i2, i, TimeUnit.SECONDS);
            synchronized (this.f104a) {
                this.f105a.put(aVar.mo169a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return true;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m128a(String str) {
        synchronized (this.f104a) {
            ScheduledFuture scheduledFuture = this.f105a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f105a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    public boolean b(a aVar, int i) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f106a.schedule(new ak(this, aVar), i, TimeUnit.SECONDS);
        synchronized (this.f104a) {
            this.f105a.put(aVar.mo169a(), schedule);
        }
        return true;
    }
}
