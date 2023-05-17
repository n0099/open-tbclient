package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes10.dex */
public class bv {
    public static volatile bv a;

    /* renamed from: a  reason: collision with other field name */
    public Context f151a;

    public bv(Context context) {
        this.f151a = context;
    }

    public static bv a(Context context) {
        if (a == null) {
            synchronized (bv.class) {
                if (a == null) {
                    a = new bv(context);
                }
            }
        }
        return a;
    }

    public synchronized long a(String str, String str2, long j) {
        try {
        } catch (Throwable unused) {
            return j;
        }
        return this.f151a.getSharedPreferences(str, 4).getLong(str2, j);
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f151a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m244a(String str, String str2, long j) {
        SharedPreferences.Editor edit = this.f151a.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m245a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f151a.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }
}
