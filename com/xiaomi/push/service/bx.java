package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.searchbox.crius.constants.NativeConstants;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public final class bx implements ar {
    public static volatile bx a;

    /* renamed from: a  reason: collision with other field name */
    public long f958a;

    /* renamed from: a  reason: collision with other field name */
    public Context f959a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f960a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f962a = false;

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, a> f961a = new ConcurrentHashMap<>();

    /* loaded from: classes10.dex */
    public static abstract class a implements Runnable {
        public long a;

        /* renamed from: a  reason: collision with other field name */
        public String f963a;

        public a(String str, long j) {
            this.f963a = str;
            this.a = j;
        }

        public abstract void a(bx bxVar);

        @Override // java.lang.Runnable
        public void run() {
            if (bx.a != null) {
                Context context = bx.a.f959a;
                if (com.xiaomi.push.bi.d(context)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences sharedPreferences = bx.a.f960a;
                    if (currentTimeMillis - sharedPreferences.getLong(":ts-" + this.f963a, 0L) > this.a || com.xiaomi.push.ag.a(context)) {
                        SharedPreferences.Editor edit = bx.a.f960a.edit();
                        com.xiaomi.push.q.a(edit.putLong(":ts-" + this.f963a, System.currentTimeMillis()));
                        a(bx.a);
                    }
                }
            }
        }
    }

    public bx(Context context) {
        this.f959a = context.getApplicationContext();
        this.f960a = context.getSharedPreferences(NativeConstants.COMPONENT_SYNC_TEXT_VIEW, 0);
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
        SharedPreferences sharedPreferences = this.f960a;
        return sharedPreferences.getString(str + ":" + str2, "");
    }

    @Override // com.xiaomi.push.service.ar
    /* renamed from: a  reason: collision with other method in class */
    public void mo811a() {
        if (this.f962a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f958a < 3600000) {
            return;
        }
        this.f958a = currentTimeMillis;
        this.f962a = true;
        com.xiaomi.push.aj.a(this.f959a).a(new by(this), (int) (Math.random() * 10.0d));
    }

    public void a(a aVar) {
        if (this.f961a.putIfAbsent(aVar.f963a, aVar) == null) {
            com.xiaomi.push.aj.a(this.f959a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = a.f960a.edit();
        com.xiaomi.push.q.a(edit.putString(str + ":" + str2, str3));
    }
}
