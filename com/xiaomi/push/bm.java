package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public class bm {
    private static volatile bm a;

    /* renamed from: a  reason: collision with other field name */
    private Context f126a;

    private bm(Context context) {
        this.f126a = context;
    }

    public static bm a(Context context) {
        if (a == null) {
            synchronized (bm.class) {
                if (a == null) {
                    a = new bm(context);
                }
            }
        }
        return a;
    }

    public synchronized long a(String str, String str2, long j) {
        try {
            j = this.f126a.getSharedPreferences(str, 4).getLong(str2, j);
        } catch (Throwable th) {
        }
        return j;
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
            str3 = this.f126a.getSharedPreferences(str, 4).getString(str2, str3);
        } catch (Throwable th) {
        }
        return str3;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m168a(String str, String str2, long j) {
        SharedPreferences.Editor edit = this.f126a.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m169a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f126a.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }
}
