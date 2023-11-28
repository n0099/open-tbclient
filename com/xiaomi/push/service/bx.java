package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.searchbox.crius.constants.NativeConstants;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public final class bx implements ar {
    public static volatile bx a;

    /* renamed from: a  reason: collision with other field name */
    public long f953a;

    /* renamed from: a  reason: collision with other field name */
    public Context f954a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f955a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f957a = false;

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, a> f956a = new ConcurrentHashMap<>();

    /* loaded from: classes10.dex */
    public static abstract class a implements Runnable {
        public long a;

        /* renamed from: a  reason: collision with other field name */
        public String f958a;

        public a(String str, long j) {
            this.f958a = str;
            this.a = j;
        }

        public abstract void a(bx bxVar);

        @Override // java.lang.Runnable
        public void run() {
            if (bx.a != null) {
                Context context = bx.a.f954a;
                if (com.xiaomi.push.bi.d(context)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences sharedPreferences = bx.a.f955a;
                    if (currentTimeMillis - sharedPreferences.getLong(":ts-" + this.f958a, 0L) > this.a || com.xiaomi.push.ag.a(context)) {
                        SharedPreferences.Editor edit = bx.a.f955a.edit();
                        com.xiaomi.push.q.a(edit.putLong(":ts-" + this.f958a, System.currentTimeMillis()));
                        a(bx.a);
                    }
                }
            }
        }
    }

    public bx(Context context) {
        this.f954a = context.getApplicationContext();
        this.f955a = context.getSharedPreferences(NativeConstants.COMPONENT_SYNC_TEXT_VIEW, 0);
    }

    public static bx a(Context context) {
        if (a == null) {
            synchronized (bx.class) {
                if (a == null) {
                    a = new bx(context);
                }
            }
        }
        return a;
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f955a;
        return sharedPreferences.getString(str + ":" + str2, "");
    }

    @Override // com.xiaomi.push.service.ar
    /* renamed from: a  reason: collision with other method in class */
    public void mo821a() {
        if (this.f957a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f953a < 3600000) {
            return;
        }
        this.f953a = currentTimeMillis;
        this.f957a = true;
        com.xiaomi.push.aj.a(this.f954a).a(new by(this), (int) (Math.random() * 10.0d));
    }

    public void a(a aVar) {
        if (this.f956a.putIfAbsent(aVar.f958a, aVar) == null) {
            com.xiaomi.push.aj.a(this.f954a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = a.f955a.edit();
        com.xiaomi.push.q.a(edit.putString(str + ":" + str2, str3));
    }
}
