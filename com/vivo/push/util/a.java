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
    public Context f39914a;

    /* renamed from: b  reason: collision with root package name */
    public String f39915b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SharedPreferences f39916c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f39917d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Long> f39918e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Integer> f39919f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Boolean> f39920g = new HashMap<>();

    public final void a(Context context, String str) {
        if (context instanceof Application) {
            if (!TextUtils.isEmpty(str)) {
                this.f39915b = str;
                this.f39916c = context.getSharedPreferences(str, 0);
                this.f39914a = context;
                return;
            }
            throw new RuntimeException("sharedFileName can't be null");
        }
        throw new RuntimeException("you can't invoke this in other sContext but Application, in case memory leak");
    }

    public final int b(String str) {
        Integer num = this.f39919f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.f39916c != null) {
            num = Integer.valueOf(this.f39916c.getInt(str, 0));
            if (!num.equals(0)) {
                this.f39919f.put(str, num);
            }
        }
        return num.intValue();
    }

    public final void c(String str) {
        this.f39918e.remove(str);
        this.f39919f.remove(str);
        this.f39920g.remove(str);
        this.f39917d.remove(str);
        b();
        if (this.f39916c != null) {
            SharedPreferences.Editor edit = this.f39916c.edit();
            if (this.f39916c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }

    public final void a(String str, String str2) {
        this.f39917d.put(str, str2);
        b();
        if (this.f39916c != null) {
            SharedPreferences.Editor edit = this.f39916c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final long b(String str, long j) {
        Long l = this.f39918e.get(str);
        if (l != null) {
            return l.longValue();
        }
        b();
        if (this.f39916c != null) {
            l = Long.valueOf(this.f39916c.getLong(str, j));
            if (!l.equals(Long.valueOf(j))) {
                this.f39918e.put(str, l);
            }
        }
        return l.longValue();
    }

    public final void a(String str, int i) {
        this.f39919f.put(str, Integer.valueOf(i));
        b();
        if (this.f39916c != null) {
            SharedPreferences.Editor edit = this.f39916c.edit();
            edit.putInt(str, i);
            a(edit);
        }
    }

    private void b() {
        if (this.f39916c == null) {
            Context context = this.f39914a;
            if (context != null) {
                this.f39916c = context.getSharedPreferences(this.f39915b, 0);
                return;
            }
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
    }

    public final void a(String str, long j) {
        this.f39918e.put(str, Long.valueOf(j));
        b();
        if (this.f39916c != null) {
            SharedPreferences.Editor edit = this.f39916c.edit();
            edit.putLong(str, j);
            a(edit);
        }
    }

    public final String a(String str) {
        String str2 = this.f39917d.get(str);
        if (str2 != null) {
            return str2;
        }
        b();
        if (this.f39916c != null) {
            str2 = this.f39916c.getString(str, null);
            if (!TextUtils.isEmpty(str2) && !str2.equals(null)) {
                this.f39917d.put(str, str2);
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
        this.f39918e.clear();
        this.f39919f.clear();
        this.f39920g.clear();
        this.f39917d.clear();
        b();
        if (this.f39916c != null) {
            SharedPreferences.Editor edit = this.f39916c.edit();
            edit.clear();
            a(edit);
        }
    }
}
