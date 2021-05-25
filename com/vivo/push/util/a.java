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
    public Context f36692a;

    /* renamed from: b  reason: collision with root package name */
    public String f36693b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SharedPreferences f36694c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f36695d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Long> f36696e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Integer> f36697f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Boolean> f36698g = new HashMap<>();

    public final void a(Context context, String str) {
        if (context instanceof Application) {
            if (!TextUtils.isEmpty(str)) {
                this.f36693b = str;
                this.f36694c = context.getSharedPreferences(str, 0);
                this.f36692a = context;
                return;
            }
            throw new RuntimeException("sharedFileName can't be null");
        }
        throw new RuntimeException("you can't invoke this in other sContext but Application, in case memory leak");
    }

    public final int b(String str) {
        Integer num = this.f36697f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.f36694c != null) {
            num = Integer.valueOf(this.f36694c.getInt(str, 0));
            if (!num.equals(0)) {
                this.f36697f.put(str, num);
            }
        }
        return num.intValue();
    }

    public final void c(String str) {
        this.f36696e.remove(str);
        this.f36697f.remove(str);
        this.f36698g.remove(str);
        this.f36695d.remove(str);
        b();
        if (this.f36694c != null) {
            SharedPreferences.Editor edit = this.f36694c.edit();
            if (this.f36694c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }

    public final void a(String str, String str2) {
        this.f36695d.put(str, str2);
        b();
        if (this.f36694c != null) {
            SharedPreferences.Editor edit = this.f36694c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final long b(String str, long j) {
        Long l = this.f36696e.get(str);
        if (l != null) {
            return l.longValue();
        }
        b();
        if (this.f36694c != null) {
            l = Long.valueOf(this.f36694c.getLong(str, j));
            if (!l.equals(Long.valueOf(j))) {
                this.f36696e.put(str, l);
            }
        }
        return l.longValue();
    }

    public final void a(String str, int i2) {
        this.f36697f.put(str, Integer.valueOf(i2));
        b();
        if (this.f36694c != null) {
            SharedPreferences.Editor edit = this.f36694c.edit();
            edit.putInt(str, i2);
            a(edit);
        }
    }

    private void b() {
        if (this.f36694c == null) {
            Context context = this.f36692a;
            if (context != null) {
                this.f36694c = context.getSharedPreferences(this.f36693b, 0);
                return;
            }
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
    }

    public final void a(String str, long j) {
        this.f36696e.put(str, Long.valueOf(j));
        b();
        if (this.f36694c != null) {
            SharedPreferences.Editor edit = this.f36694c.edit();
            edit.putLong(str, j);
            a(edit);
        }
    }

    public final String a(String str) {
        String str2 = this.f36695d.get(str);
        if (str2 != null) {
            return str2;
        }
        b();
        if (this.f36694c != null) {
            str2 = this.f36694c.getString(str, null);
            if (!TextUtils.isEmpty(str2) && !str2.equals(null)) {
                this.f36695d.put(str, str2);
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
        this.f36696e.clear();
        this.f36697f.clear();
        this.f36698g.clear();
        this.f36695d.clear();
        b();
        if (this.f36694c != null) {
            SharedPreferences.Editor edit = this.f36694c.edit();
            edit.clear();
            a(edit);
        }
    }
}
