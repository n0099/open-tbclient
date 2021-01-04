package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public class bm {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bm f14182a;

    /* renamed from: a  reason: collision with other field name */
    private Context f206a;

    private bm(Context context) {
        this.f206a = context;
    }

    public static bm a(Context context) {
        if (f14182a == null) {
            synchronized (bm.class) {
                if (f14182a == null) {
                    f14182a = new bm(context);
                }
            }
        }
        return f14182a;
    }

    public synchronized long a(String str, String str2, long j) {
        try {
            j = this.f206a.getSharedPreferences(str, 4).getLong(str2, j);
        } catch (Throwable th) {
        }
        return j;
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
            str3 = this.f206a.getSharedPreferences(str, 4).getString(str2, str3);
        } catch (Throwable th) {
        }
        return str3;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m189a(String str, String str2, long j) {
        SharedPreferences.Editor edit = this.f206a.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m190a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f206a.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }
}
