package com.vivo.push.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f37518a;

    /* renamed from: b  reason: collision with root package name */
    public String f37519b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SharedPreferences f37520c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f37521d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Long> f37522e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Integer> f37523f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Boolean> f37524g = new HashMap<>();

    public final void a(Context context, String str) {
        if (context instanceof Application) {
            if (!TextUtils.isEmpty(str)) {
                this.f37519b = str;
                this.f37520c = context.getSharedPreferences(str, 0);
                this.f37518a = context;
                return;
            }
            throw new RuntimeException("sharedFileName can't be null");
        }
        throw new RuntimeException("you can't invoke this in other sContext but Application, in case memory leak");
    }

    public final int b(String str) {
        Integer num = this.f37523f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.f37520c != null) {
            num = Integer.valueOf(this.f37520c.getInt(str, 0));
            if (!num.equals(0)) {
                this.f37523f.put(str, num);
            }
        }
        return num.intValue();
    }

    public final void c(String str) {
        this.f37522e.remove(str);
        this.f37523f.remove(str);
        this.f37524g.remove(str);
        this.f37521d.remove(str);
        b();
        if (this.f37520c != null) {
            SharedPreferences.Editor edit = this.f37520c.edit();
            if (this.f37520c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }

    public final void a(String str, String str2) {
        this.f37521d.put(str, str2);
        b();
        if (this.f37520c != null) {
            SharedPreferences.Editor edit = this.f37520c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final long b(String str, long j) {
        Long l = this.f37522e.get(str);
        if (l != null) {
            return l.longValue();
        }
        b();
        if (this.f37520c != null) {
            l = Long.valueOf(this.f37520c.getLong(str, j));
            if (!l.equals(Long.valueOf(j))) {
                this.f37522e.put(str, l);
            }
        }
        return l.longValue();
    }

    public final void a(String str, int i2) {
        this.f37523f.put(str, Integer.valueOf(i2));
        b();
        if (this.f37520c != null) {
            SharedPreferences.Editor edit = this.f37520c.edit();
            edit.putInt(str, i2);
            a(edit);
        }
    }

    private void b() {
        if (this.f37520c == null) {
            Context context = this.f37518a;
            if (context != null) {
                this.f37520c = context.getSharedPreferences(this.f37519b, 0);
                return;
            }
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
    }

    public final void a(String str, long j) {
        this.f37522e.put(str, Long.valueOf(j));
        b();
        if (this.f37520c != null) {
            SharedPreferences.Editor edit = this.f37520c.edit();
            edit.putLong(str, j);
            a(edit);
        }
    }

    public final String a(String str) {
        String str2 = this.f37521d.get(str);
        if (str2 != null) {
            return str2;
        }
        b();
        if (this.f37520c != null) {
            str2 = this.f37520c.getString(str, null);
            if (!TextUtils.isEmpty(str2) && !str2.equals(null)) {
                this.f37521d.put(str, str2);
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
        this.f37522e.clear();
        this.f37523f.clear();
        this.f37524g.clear();
        this.f37521d.clear();
        b();
        if (this.f37520c != null) {
            SharedPreferences.Editor edit = this.f37520c.edit();
            edit.clear();
            a(edit);
        }
    }
}
