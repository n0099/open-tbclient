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
    public Context f36763a;

    /* renamed from: b  reason: collision with root package name */
    public String f36764b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SharedPreferences f36765c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f36766d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Long> f36767e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Integer> f36768f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Boolean> f36769g = new HashMap<>();

    public final void a(Context context, String str) {
        if (context instanceof Application) {
            if (!TextUtils.isEmpty(str)) {
                this.f36764b = str;
                this.f36765c = context.getSharedPreferences(str, 0);
                this.f36763a = context;
                return;
            }
            throw new RuntimeException("sharedFileName can't be null");
        }
        throw new RuntimeException("you can't invoke this in other sContext but Application, in case memory leak");
    }

    public final int b(String str) {
        Integer num = this.f36768f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.f36765c != null) {
            num = Integer.valueOf(this.f36765c.getInt(str, 0));
            if (!num.equals(0)) {
                this.f36768f.put(str, num);
            }
        }
        return num.intValue();
    }

    public final void c(String str) {
        this.f36767e.remove(str);
        this.f36768f.remove(str);
        this.f36769g.remove(str);
        this.f36766d.remove(str);
        b();
        if (this.f36765c != null) {
            SharedPreferences.Editor edit = this.f36765c.edit();
            if (this.f36765c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }

    public final void a(String str, String str2) {
        this.f36766d.put(str, str2);
        b();
        if (this.f36765c != null) {
            SharedPreferences.Editor edit = this.f36765c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final long b(String str, long j) {
        Long l = this.f36767e.get(str);
        if (l != null) {
            return l.longValue();
        }
        b();
        if (this.f36765c != null) {
            l = Long.valueOf(this.f36765c.getLong(str, j));
            if (!l.equals(Long.valueOf(j))) {
                this.f36767e.put(str, l);
            }
        }
        return l.longValue();
    }

    public final void a(String str, int i2) {
        this.f36768f.put(str, Integer.valueOf(i2));
        b();
        if (this.f36765c != null) {
            SharedPreferences.Editor edit = this.f36765c.edit();
            edit.putInt(str, i2);
            a(edit);
        }
    }

    private void b() {
        if (this.f36765c == null) {
            Context context = this.f36763a;
            if (context != null) {
                this.f36765c = context.getSharedPreferences(this.f36764b, 0);
                return;
            }
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
    }

    public final void a(String str, long j) {
        this.f36767e.put(str, Long.valueOf(j));
        b();
        if (this.f36765c != null) {
            SharedPreferences.Editor edit = this.f36765c.edit();
            edit.putLong(str, j);
            a(edit);
        }
    }

    public final String a(String str) {
        String str2 = this.f36766d.get(str);
        if (str2 != null) {
            return str2;
        }
        b();
        if (this.f36765c != null) {
            str2 = this.f36765c.getString(str, null);
            if (!TextUtils.isEmpty(str2) && !str2.equals(null)) {
                this.f36766d.put(str, str2);
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
        this.f36767e.clear();
        this.f36768f.clear();
        this.f36769g.clear();
        this.f36766d.clear();
        b();
        if (this.f36765c != null) {
            SharedPreferences.Editor edit = this.f36765c.edit();
            edit.clear();
            a(edit);
        }
    }
}
