package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.live.adp.lib.cache.BdKVCache;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes12.dex */
public final class bg implements af {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bg f5077a;

    /* renamed from: a  reason: collision with other field name */
    private long f886a;

    /* renamed from: a  reason: collision with other field name */
    Context f887a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f888a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f890a = false;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, a> f889a = new ConcurrentHashMap<>();

    /* loaded from: classes12.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        long f5078a;

        /* renamed from: a  reason: collision with other field name */
        String f891a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str, long j) {
            this.f891a = str;
            this.f5078a = j;
        }

        abstract void a(bg bgVar);

        @Override // java.lang.Runnable
        public void run() {
            if (bg.f5077a != null) {
                Context context = bg.f5077a.f887a;
                if (com.xiaomi.push.az.c(context)) {
                    if (System.currentTimeMillis() - bg.f5077a.f888a.getLong(":ts-" + this.f891a, 0L) > this.f5078a || com.xiaomi.push.af.a(context)) {
                        com.xiaomi.push.r.a(bg.f5077a.f888a.edit().putLong(":ts-" + this.f891a, System.currentTimeMillis()));
                        a(bg.f5077a);
                    }
                }
            }
        }
    }

    private bg(Context context) {
        this.f887a = context.getApplicationContext();
        this.f888a = context.getSharedPreferences("sync", 0);
    }

    public static bg a(Context context) {
        if (f5077a == null) {
            synchronized (bg.class) {
                if (f5077a == null) {
                    f5077a = new bg(context);
                }
            }
        }
        return f5077a;
    }

    public String a(String str, String str2) {
        return this.f888a.getString(str + ":" + str2, "");
    }

    @Override // com.xiaomi.push.service.af
    /* renamed from: a  reason: collision with other method in class */
    public void mo566a() {
        if (this.f890a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f886a >= BdKVCache.MILLS_1Hour) {
            this.f886a = currentTimeMillis;
            this.f890a = true;
            com.xiaomi.push.ai.a(this.f887a).a(new bh(this), (int) (Math.random() * 10.0d));
        }
    }

    public void a(a aVar) {
        if (this.f889a.putIfAbsent(aVar.f891a, aVar) == null) {
            com.xiaomi.push.ai.a(this.f887a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        com.xiaomi.push.r.a(f5077a.f888a.edit().putString(str + ":" + str2, str3));
    }
}
