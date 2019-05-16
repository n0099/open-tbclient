package com.xiaomi.clientreport.util;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public class d {
    private static volatile d a;
    private Context b;

    private d(Context context) {
        this.b = context;
    }

    public static d a(Context context) {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    public synchronized void a(String str, String str2, long j) {
        SharedPreferences.Editor edit = this.b.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    public synchronized void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.b.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }

    public synchronized long b(String str, String str2, long j) {
        try {
            j = this.b.getSharedPreferences(str, 4).getLong(str2, j);
        } catch (Throwable th) {
        }
        return j;
    }

    public synchronized String b(String str, String str2, String str3) {
        try {
            str3 = this.b.getSharedPreferences(str, 4).getString(str2, str3);
        } catch (Throwable th) {
        }
        return str3;
    }
}
