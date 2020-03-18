package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.live.adp.lib.cache.BdKVCache;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public final class bc implements ae {
    private static volatile bc a;

    /* renamed from: a  reason: collision with other field name */
    private long f889a;

    /* renamed from: a  reason: collision with other field name */
    Context f890a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f891a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f893a = false;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, a> f892a = new ConcurrentHashMap<>();

    /* loaded from: classes8.dex */
    public static abstract class a implements Runnable {
        long a;

        /* renamed from: a  reason: collision with other field name */
        String f894a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str, long j) {
            this.f894a = str;
            this.a = j;
        }

        abstract void a(bc bcVar);

        @Override // java.lang.Runnable
        public void run() {
            if (bc.a != null) {
                Context context = bc.a.f890a;
                if (com.xiaomi.push.as.c(context)) {
                    if (System.currentTimeMillis() - bc.a.f891a.getLong(":ts-" + this.f894a, 0L) > this.a || com.xiaomi.push.af.a(context)) {
                        com.xiaomi.push.r.a(bc.a.f891a.edit().putLong(":ts-" + this.f894a, System.currentTimeMillis()));
                        a(bc.a);
                    }
                }
            }
        }
    }

    private bc(Context context) {
        this.f890a = context.getApplicationContext();
        this.f891a = context.getSharedPreferences("sync", 0);
    }

    public static bc a(Context context) {
        if (a == null) {
            synchronized (bc.class) {
                if (a == null) {
                    a = new bc(context);
                }
            }
        }
        return a;
    }

    public String a(String str, String str2) {
        return this.f891a.getString(str + ":" + str2, "");
    }

    @Override // com.xiaomi.push.service.ae
    /* renamed from: a  reason: collision with other method in class */
    public void mo531a() {
        if (this.f893a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f889a >= BdKVCache.MILLS_1Hour) {
            this.f889a = currentTimeMillis;
            this.f893a = true;
            com.xiaomi.push.ai.a(this.f890a).a(new bd(this), (int) (Math.random() * 10.0d));
        }
    }

    public void a(a aVar) {
        if (this.f892a.putIfAbsent(aVar.f894a, aVar) == null) {
            com.xiaomi.push.ai.a(this.f890a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        com.xiaomi.push.r.a(a.f891a.edit().putString(str + ":" + str2, str3));
    }
}
