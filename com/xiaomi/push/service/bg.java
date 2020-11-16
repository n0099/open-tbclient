package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.live.adp.lib.cache.BdKVCache;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes18.dex */
public final class bg implements af {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bg f5079a;

    /* renamed from: a  reason: collision with other field name */
    private long f891a;

    /* renamed from: a  reason: collision with other field name */
    Context f892a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f893a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f895a = false;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, a> f894a = new ConcurrentHashMap<>();

    /* loaded from: classes18.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        long f5080a;

        /* renamed from: a  reason: collision with other field name */
        String f896a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str, long j) {
            this.f896a = str;
            this.f5080a = j;
        }

        abstract void a(bg bgVar);

        @Override // java.lang.Runnable
        public void run() {
            if (bg.f5079a != null) {
                Context context = bg.f5079a.f892a;
                if (com.xiaomi.push.az.c(context)) {
                    if (System.currentTimeMillis() - bg.f5079a.f893a.getLong(":ts-" + this.f896a, 0L) > this.f5080a || com.xiaomi.push.af.a(context)) {
                        com.xiaomi.push.r.a(bg.f5079a.f893a.edit().putLong(":ts-" + this.f896a, System.currentTimeMillis()));
                        a(bg.f5079a);
                    }
                }
            }
        }
    }

    private bg(Context context) {
        this.f892a = context.getApplicationContext();
        this.f893a = context.getSharedPreferences("sync", 0);
    }

    public static bg a(Context context) {
        if (f5079a == null) {
            synchronized (bg.class) {
                if (f5079a == null) {
                    f5079a = new bg(context);
                }
            }
        }
        return f5079a;
    }

    public String a(String str, String str2) {
        return this.f893a.getString(str + ":" + str2, "");
    }

    @Override // com.xiaomi.push.service.af
    /* renamed from: a  reason: collision with other method in class */
    public void mo569a() {
        if (this.f895a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f891a >= BdKVCache.MILLS_1Hour) {
            this.f891a = currentTimeMillis;
            this.f895a = true;
            com.xiaomi.push.ai.a(this.f892a).a(new bh(this), (int) (Math.random() * 10.0d));
        }
    }

    public void a(a aVar) {
        if (this.f894a.putIfAbsent(aVar.f896a, aVar) == null) {
            com.xiaomi.push.ai.a(this.f892a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        com.xiaomi.push.r.a(f5079a.f893a.edit().putString(str + ":" + str2, str3));
    }
}
