package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.live.adp.lib.cache.BdKVCache;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class bg implements af {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bg f14271a;

    /* renamed from: a  reason: collision with other field name */
    private long f967a;

    /* renamed from: a  reason: collision with other field name */
    Context f968a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f969a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f971a = false;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, a> f970a = new ConcurrentHashMap<>();

    /* loaded from: classes6.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        long f14272a;

        /* renamed from: a  reason: collision with other field name */
        String f972a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str, long j) {
            this.f972a = str;
            this.f14272a = j;
        }

        abstract void a(bg bgVar);

        @Override // java.lang.Runnable
        public void run() {
            if (bg.f14271a != null) {
                Context context = bg.f14271a.f968a;
                if (com.xiaomi.push.az.c(context)) {
                    if (System.currentTimeMillis() - bg.f14271a.f969a.getLong(":ts-" + this.f972a, 0L) > this.f14272a || com.xiaomi.push.af.a(context)) {
                        com.xiaomi.push.r.a(bg.f14271a.f969a.edit().putLong(":ts-" + this.f972a, System.currentTimeMillis()));
                        a(bg.f14271a);
                    }
                }
            }
        }
    }

    private bg(Context context) {
        this.f968a = context.getApplicationContext();
        this.f969a = context.getSharedPreferences("sync", 0);
    }

    public static bg a(Context context) {
        if (f14271a == null) {
            synchronized (bg.class) {
                if (f14271a == null) {
                    f14271a = new bg(context);
                }
            }
        }
        return f14271a;
    }

    public String a(String str, String str2) {
        return this.f969a.getString(str + ":" + str2, "");
    }

    @Override // com.xiaomi.push.service.af
    /* renamed from: a  reason: collision with other method in class */
    public void mo592a() {
        if (this.f971a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f967a >= BdKVCache.MILLS_1Hour) {
            this.f967a = currentTimeMillis;
            this.f971a = true;
            com.xiaomi.push.ai.a(this.f968a).a(new bh(this), (int) (Math.random() * 10.0d));
        }
    }

    public void a(a aVar) {
        if (this.f970a.putIfAbsent(aVar.f972a, aVar) == null) {
            com.xiaomi.push.ai.a(this.f968a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        com.xiaomi.push.r.a(f14271a.f969a.edit().putString(str + ":" + str2, str3));
    }
}
