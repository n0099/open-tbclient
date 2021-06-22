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
    public Context f40474a;

    /* renamed from: b  reason: collision with root package name */
    public String f40475b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SharedPreferences f40476c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f40477d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Long> f40478e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Integer> f40479f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Boolean> f40480g = new HashMap<>();

    public final void a(Context context, String str) {
        if (context instanceof Application) {
            if (!TextUtils.isEmpty(str)) {
                this.f40475b = str;
                this.f40476c = context.getSharedPreferences(str, 0);
                this.f40474a = context;
                return;
            }
            throw new RuntimeException("sharedFileName can't be null");
        }
        throw new RuntimeException("you can't invoke this in other sContext but Application, in case memory leak");
    }

    public final int b(String str) {
        Integer num = this.f40479f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.f40476c != null) {
            num = Integer.valueOf(this.f40476c.getInt(str, 0));
            if (!num.equals(0)) {
                this.f40479f.put(str, num);
            }
        }
        return num.intValue();
    }

    public final void c(String str) {
        this.f40478e.remove(str);
        this.f40479f.remove(str);
        this.f40480g.remove(str);
        this.f40477d.remove(str);
        b();
        if (this.f40476c != null) {
            SharedPreferences.Editor edit = this.f40476c.edit();
            if (this.f40476c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }

    public final void a(String str, String str2) {
        this.f40477d.put(str, str2);
        b();
        if (this.f40476c != null) {
            SharedPreferences.Editor edit = this.f40476c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final long b(String str, long j) {
        Long l = this.f40478e.get(str);
        if (l != null) {
            return l.longValue();
        }
        b();
        if (this.f40476c != null) {
            l = Long.valueOf(this.f40476c.getLong(str, j));
            if (!l.equals(Long.valueOf(j))) {
                this.f40478e.put(str, l);
            }
        }
        return l.longValue();
    }

    public final void a(String str, int i2) {
        this.f40479f.put(str, Integer.valueOf(i2));
        b();
        if (this.f40476c != null) {
            SharedPreferences.Editor edit = this.f40476c.edit();
            edit.putInt(str, i2);
            a(edit);
        }
    }

    private void b() {
        if (this.f40476c == null) {
            Context context = this.f40474a;
            if (context != null) {
                this.f40476c = context.getSharedPreferences(this.f40475b, 0);
                return;
            }
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
    }

    public final void a(String str, long j) {
        this.f40478e.put(str, Long.valueOf(j));
        b();
        if (this.f40476c != null) {
            SharedPreferences.Editor edit = this.f40476c.edit();
            edit.putLong(str, j);
            a(edit);
        }
    }

    public final String a(String str) {
        String str2 = this.f40477d.get(str);
        if (str2 != null) {
            return str2;
        }
        b();
        if (this.f40476c != null) {
            str2 = this.f40476c.getString(str, null);
            if (!TextUtils.isEmpty(str2) && !str2.equals(null)) {
                this.f40477d.put(str, str2);
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
        this.f40478e.clear();
        this.f40479f.clear();
        this.f40480g.clear();
        this.f40477d.clear();
        b();
        if (this.f40476c != null) {
            SharedPreferences.Editor edit = this.f40476c.edit();
            edit.clear();
            a(edit);
        }
    }
}
