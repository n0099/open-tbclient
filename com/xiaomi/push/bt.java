package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes7.dex */
public class bt {

    /* renamed from: a  reason: collision with root package name */
    public static volatile bt f40291a;

    /* renamed from: a  reason: collision with other field name */
    public Context f156a;

    public bt(Context context) {
        this.f156a = context;
    }

    public static bt a(Context context) {
        if (f40291a == null) {
            synchronized (bt.class) {
                if (f40291a == null) {
                    f40291a = new bt(context);
                }
            }
        }
        return f40291a;
    }

    public synchronized long a(String str, String str2, long j) {
        try {
        } catch (Throwable unused) {
            return j;
        }
        return this.f156a.getSharedPreferences(str, 4).getLong(str2, j);
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f156a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m169a(String str, String str2, long j) {
        SharedPreferences.Editor edit = this.f156a.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m170a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f156a.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }
}
