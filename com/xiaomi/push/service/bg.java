package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.live.adp.lib.cache.BdKVCache;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes12.dex */
public final class bg implements af {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bg f5079a;

    /* renamed from: a  reason: collision with other field name */
    private long f888a;

    /* renamed from: a  reason: collision with other field name */
    Context f889a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f890a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f892a = false;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, a> f891a = new ConcurrentHashMap<>();

    /* loaded from: classes12.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        long f5080a;

        /* renamed from: a  reason: collision with other field name */
        String f893a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str, long j) {
            this.f893a = str;
            this.f5080a = j;
        }

        abstract void a(bg bgVar);

        @Override // java.lang.Runnable
        public void run() {
            if (bg.f5079a != null) {
                Context context = bg.f5079a.f889a;
                if (com.xiaomi.push.az.c(context)) {
                    if (System.currentTimeMillis() - bg.f5079a.f890a.getLong(":ts-" + this.f893a, 0L) > this.f5080a || com.xiaomi.push.af.a(context)) {
                        com.xiaomi.push.r.a(bg.f5079a.f890a.edit().putLong(":ts-" + this.f893a, System.currentTimeMillis()));
                        a(bg.f5079a);
                    }
                }
            }
        }
    }

    private bg(Context context) {
        this.f889a = context.getApplicationContext();
        this.f890a = context.getSharedPreferences("sync", 0);
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
        return this.f890a.getString(str + ":" + str2, "");
    }

    @Override // com.xiaomi.push.service.af
    /* renamed from: a  reason: collision with other method in class */
    public void mo566a() {
        if (this.f892a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f888a >= BdKVCache.MILLS_1Hour) {
            this.f888a = currentTimeMillis;
            this.f892a = true;
            com.xiaomi.push.ai.a(this.f889a).a(new bh(this), (int) (Math.random() * 10.0d));
        }
    }

    public void a(a aVar) {
        if (this.f891a.putIfAbsent(aVar.f893a, aVar) == null) {
            com.xiaomi.push.ai.a(this.f889a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        com.xiaomi.push.r.a(f5079a.f890a.edit().putString(str + ":" + str2, str3));
    }
}
