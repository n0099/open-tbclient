package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.live.adp.lib.cache.BdKVCache;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class bg implements af {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bg f14571a;

    /* renamed from: a  reason: collision with other field name */
    private long f968a;

    /* renamed from: a  reason: collision with other field name */
    Context f969a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f970a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f972a = false;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, a> f971a = new ConcurrentHashMap<>();

    /* loaded from: classes6.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        long f14572a;

        /* renamed from: a  reason: collision with other field name */
        String f973a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str, long j) {
            this.f973a = str;
            this.f14572a = j;
        }

        abstract void a(bg bgVar);

        @Override // java.lang.Runnable
        public void run() {
            if (bg.f14571a != null) {
                Context context = bg.f14571a.f969a;
                if (com.xiaomi.push.az.c(context)) {
                    if (System.currentTimeMillis() - bg.f14571a.f970a.getLong(":ts-" + this.f973a, 0L) > this.f14572a || com.xiaomi.push.af.a(context)) {
                        com.xiaomi.push.r.a(bg.f14571a.f970a.edit().putLong(":ts-" + this.f973a, System.currentTimeMillis()));
                        a(bg.f14571a);
                    }
                }
            }
        }
    }

    private bg(Context context) {
        this.f969a = context.getApplicationContext();
        this.f970a = context.getSharedPreferences("sync", 0);
    }

    public static bg a(Context context) {
        if (f14571a == null) {
            synchronized (bg.class) {
                if (f14571a == null) {
                    f14571a = new bg(context);
                }
            }
        }
        return f14571a;
    }

    public String a(String str, String str2) {
        return this.f970a.getString(str + ":" + str2, "");
    }

    @Override // com.xiaomi.push.service.af
    /* renamed from: a  reason: collision with other method in class */
    public void mo596a() {
        if (this.f972a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f968a >= BdKVCache.MILLS_1Hour) {
            this.f968a = currentTimeMillis;
            this.f972a = true;
            com.xiaomi.push.ai.a(this.f969a).a(new bh(this), (int) (Math.random() * 10.0d));
        }
    }

    public void a(a aVar) {
        if (this.f971a.putIfAbsent(aVar.f973a, aVar) == null) {
            com.xiaomi.push.ai.a(this.f969a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        com.xiaomi.push.r.a(f14571a.f970a.edit().putString(str + ":" + str2, str3));
    }
}
