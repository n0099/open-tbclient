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
    public Context f39530a;

    /* renamed from: b  reason: collision with root package name */
    public String f39531b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SharedPreferences f39532c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f39533d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Long> f39534e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Integer> f39535f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Boolean> f39536g = new HashMap<>();

    public final void a(Context context, String str) {
        if (context instanceof Application) {
            if (!TextUtils.isEmpty(str)) {
                this.f39531b = str;
                this.f39532c = context.getSharedPreferences(str, 0);
                this.f39530a = context;
                return;
            }
            throw new RuntimeException("sharedFileName can't be null");
        }
        throw new RuntimeException("you can't invoke this in other sContext but Application, in case memory leak");
    }

    public final int b(String str) {
        Integer num = this.f39535f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.f39532c != null) {
            num = Integer.valueOf(this.f39532c.getInt(str, 0));
            if (!num.equals(0)) {
                this.f39535f.put(str, num);
            }
        }
        return num.intValue();
    }

    public final void c(String str) {
        this.f39534e.remove(str);
        this.f39535f.remove(str);
        this.f39536g.remove(str);
        this.f39533d.remove(str);
        b();
        if (this.f39532c != null) {
            SharedPreferences.Editor edit = this.f39532c.edit();
            if (this.f39532c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }

    public final void a(String str, String str2) {
        this.f39533d.put(str, str2);
        b();
        if (this.f39532c != null) {
            SharedPreferences.Editor edit = this.f39532c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final long b(String str, long j) {
        Long l = this.f39534e.get(str);
        if (l != null) {
            return l.longValue();
        }
        b();
        if (this.f39532c != null) {
            l = Long.valueOf(this.f39532c.getLong(str, j));
            if (!l.equals(Long.valueOf(j))) {
                this.f39534e.put(str, l);
            }
        }
        return l.longValue();
    }

    public final void a(String str, int i) {
        this.f39535f.put(str, Integer.valueOf(i));
        b();
        if (this.f39532c != null) {
            SharedPreferences.Editor edit = this.f39532c.edit();
            edit.putInt(str, i);
            a(edit);
        }
    }

    private void b() {
        if (this.f39532c == null) {
            Context context = this.f39530a;
            if (context != null) {
                this.f39532c = context.getSharedPreferences(this.f39531b, 0);
                return;
            }
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
    }

    public final void a(String str, long j) {
        this.f39534e.put(str, Long.valueOf(j));
        b();
        if (this.f39532c != null) {
            SharedPreferences.Editor edit = this.f39532c.edit();
            edit.putLong(str, j);
            a(edit);
        }
    }

    public final String a(String str) {
        String str2 = this.f39533d.get(str);
        if (str2 != null) {
            return str2;
        }
        b();
        if (this.f39532c != null) {
            str2 = this.f39532c.getString(str, null);
            if (!TextUtils.isEmpty(str2) && !str2.equals(null)) {
                this.f39533d.put(str, str2);
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
        this.f39534e.clear();
        this.f39535f.clear();
        this.f39536g.clear();
        this.f39533d.clear();
        b();
        if (this.f39532c != null) {
            SharedPreferences.Editor edit = this.f39532c.edit();
            edit.clear();
            a(edit);
        }
    }
}
