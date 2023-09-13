package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.searchbox.crius.constants.NativeConstants;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public final class bx implements ar {
    public static volatile bx a;

    /* renamed from: a  reason: collision with other field name */
    public long f957a;

    /* renamed from: a  reason: collision with other field name */
    public Context f958a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f959a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f961a = false;

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, a> f960a = new ConcurrentHashMap<>();

    /* loaded from: classes10.dex */
    public static abstract class a implements Runnable {
        public long a;

        /* renamed from: a  reason: collision with other field name */
        public String f962a;

        public a(String str, long j) {
            this.f962a = str;
            this.a = j;
        }

        public abstract void a(bx bxVar);

        @Override // java.lang.Runnable
        public void run() {
            if (bx.a != null) {
                Context context = bx.a.f958a;
                if (com.xiaomi.push.bi.d(context)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences sharedPreferences = bx.a.f959a;
                    if (currentTimeMillis - sharedPreferences.getLong(":ts-" + this.f962a, 0L) > this.a || com.xiaomi.push.ag.a(context)) {
                        SharedPreferences.Editor edit = bx.a.f959a.edit();
                        com.xiaomi.push.q.a(edit.putLong(":ts-" + this.f962a, System.currentTimeMillis()));
                        a(bx.a);
                    }
                }
            }
        }
    }

    public bx(Context context) {
        this.f958a = context.getApplicationContext();
        this.f959a = context.getSharedPreferences(NativeConstants.COMPONENT_SYNC_TEXT_VIEW, 0);
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
        SharedPreferences sharedPreferences = this.f959a;
        return sharedPreferences.getString(str + ":" + str2, "");
    }

    @Override // com.xiaomi.push.service.ar
    /* renamed from: a  reason: collision with other method in class */
    public void mo812a() {
        if (this.f961a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f957a < 3600000) {
            return;
        }
        this.f957a = currentTimeMillis;
        this.f961a = true;
        com.xiaomi.push.aj.a(this.f958a).a(new by(this), (int) (Math.random() * 10.0d));
    }

    public void a(a aVar) {
        if (this.f960a.putIfAbsent(aVar.f962a, aVar) == null) {
            com.xiaomi.push.aj.a(this.f958a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = a.f959a.edit();
        com.xiaomi.push.q.a(edit.putString(str + ":" + str2, str3));
    }
}
