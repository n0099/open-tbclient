package com.vivo.push.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f40371a;

    /* renamed from: b  reason: collision with root package name */
    public String f40372b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SharedPreferences f40373c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f40374d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Long> f40375e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Integer> f40376f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Boolean> f40377g = new HashMap<>();

    public final void a(Context context, String str) {
        if (context instanceof Application) {
            if (!TextUtils.isEmpty(str)) {
                this.f40372b = str;
                this.f40373c = context.getSharedPreferences(str, 0);
                this.f40371a = context;
                return;
            }
            throw new RuntimeException("sharedFileName can't be null");
        }
        throw new RuntimeException("you can't invoke this in other sContext but Application, in case memory leak");
    }

    public final int b(String str) {
        Integer num = this.f40376f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.f40373c != null) {
            num = Integer.valueOf(this.f40373c.getInt(str, 0));
            if (!num.equals(0)) {
                this.f40376f.put(str, num);
            }
        }
        return num.intValue();
    }

    public final void c(String str) {
        this.f40375e.remove(str);
        this.f40376f.remove(str);
        this.f40377g.remove(str);
        this.f40374d.remove(str);
        b();
        if (this.f40373c != null) {
            SharedPreferences.Editor edit = this.f40373c.edit();
            if (this.f40373c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }

    public final void a(String str, String str2) {
        this.f40374d.put(str, str2);
        b();
        if (this.f40373c != null) {
            SharedPreferences.Editor edit = this.f40373c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final long b(String str, long j) {
        Long l = this.f40375e.get(str);
        if (l != null) {
            return l.longValue();
        }
        b();
        if (this.f40373c != null) {
            l = Long.valueOf(this.f40373c.getLong(str, j));
            if (!l.equals(Long.valueOf(j))) {
                this.f40375e.put(str, l);
            }
        }
        return l.longValue();
    }

    public final void a(String str, int i2) {
        this.f40376f.put(str, Integer.valueOf(i2));
        b();
        if (this.f40373c != null) {
            SharedPreferences.Editor edit = this.f40373c.edit();
            edit.putInt(str, i2);
            a(edit);
        }
    }

    private void b() {
        if (this.f40373c == null) {
            Context context = this.f40371a;
            if (context != null) {
                this.f40373c = context.getSharedPreferences(this.f40372b, 0);
                return;
            }
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
    }

    public final void a(String str, long j) {
        this.f40375e.put(str, Long.valueOf(j));
        b();
        if (this.f40373c != null) {
            SharedPreferences.Editor edit = this.f40373c.edit();
            edit.putLong(str, j);
            a(edit);
        }
    }

    public final String a(String str) {
        String str2 = this.f40374d.get(str);
        if (str2 != null) {
            return str2;
        }
        b();
        if (this.f40373c != null) {
            str2 = this.f40373c.getString(str, null);
            if (!TextUtils.isEmpty(str2) && !str2.equals(null)) {
                this.f40374d.put(str, str2);
            }
        }
        return str2;
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public final void a() {
        this.f40375e.clear();
        this.f40376f.clear();
        this.f40377g.clear();
        this.f40374d.clear();
        b();
        if (this.f40373c != null) {
            SharedPreferences.Editor edit = this.f40373c.edit();
            edit.clear();
            a(edit);
        }
    }
}
