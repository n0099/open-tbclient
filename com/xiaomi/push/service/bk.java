package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public final class bk implements ai {

    /* renamed from: a  reason: collision with root package name */
    public static volatile bk f41891a;

    /* renamed from: a  reason: collision with other field name */
    public long f931a;

    /* renamed from: a  reason: collision with other field name */
    public Context f932a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f933a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f935a = false;

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, a> f934a = new ConcurrentHashMap<>();

    /* loaded from: classes7.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public long f41892a;

        /* renamed from: a  reason: collision with other field name */
        public String f936a;

        public a(String str, long j) {
            this.f936a = str;
            this.f41892a = j;
        }

        public abstract void a(bk bkVar);

        @Override // java.lang.Runnable
        public void run() {
            if (bk.f41891a != null) {
                Context context = bk.f41891a.f932a;
                if (com.xiaomi.push.bg.d(context)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences sharedPreferences = bk.f41891a.f933a;
                    if (currentTimeMillis - sharedPreferences.getLong(":ts-" + this.f936a, 0L) > this.f41892a || com.xiaomi.push.af.a(context)) {
                        SharedPreferences.Editor edit = bk.f41891a.f933a.edit();
                        com.xiaomi.push.r.a(edit.putLong(":ts-" + this.f936a, System.currentTimeMillis()));
                        a(bk.f41891a);
                    }
                }
            }
        }
    }

    public bk(Context context) {
        this.f932a = context.getApplicationContext();
        this.f933a = context.getSharedPreferences("sync", 0);
    }

    public static bk a(Context context) {
        if (f41891a == null) {
            synchronized (bk.class) {
                if (f41891a == null) {
                    f41891a = new bk(context);
                }
            }
        }
        return f41891a;
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f933a;
        return sharedPreferences.getString(str + ":" + str2, "");
    }

    @Override // com.xiaomi.push.service.ai
    /* renamed from: a  reason: collision with other method in class */
    public void mo605a() {
        if (this.f935a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f931a < 3600000) {
            return;
        }
        this.f931a = currentTimeMillis;
        this.f935a = true;
        com.xiaomi.push.ai.a(this.f932a).a(new bl(this), (int) (Math.random() * 10.0d));
    }

    public void a(a aVar) {
        if (this.f934a.putIfAbsent(aVar.f936a, aVar) == null) {
            com.xiaomi.push.ai.a(this.f932a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = f41891a.f933a.edit();
        com.xiaomi.push.r.a(edit.putString(str + ":" + str2, str3));
    }
}
