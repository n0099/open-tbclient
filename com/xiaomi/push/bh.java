package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public class bh {
    private static volatile bh a;

    /* renamed from: a  reason: collision with other field name */
    private Context f145a;

    private bh(Context context) {
        this.f145a = context;
    }

    public static bh a(Context context) {
        if (a == null) {
            synchronized (bh.class) {
                if (a == null) {
                    a = new bh(context);
                }
            }
        }
        return a;
    }

    public synchronized long a(String str, String str2, long j) {
        try {
            j = this.f145a.getSharedPreferences(str, 4).getLong(str2, j);
        } catch (Throwable th) {
        }
        return j;
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
            str3 = this.f145a.getSharedPreferences(str, 4).getString(str2, str3);
        } catch (Throwable th) {
        }
        return str3;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m156a(String str, String str2, long j) {
        SharedPreferences.Editor edit = this.f145a.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m157a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f145a.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }
}
