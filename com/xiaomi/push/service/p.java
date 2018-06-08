package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class p {
    private static p a = null;
    private Context b;
    private List<String> c = new ArrayList();
    private final List<String> d = new ArrayList();
    private final List<String> e = new ArrayList();

    private p(Context context) {
        String[] split;
        String[] split2;
        String[] split3;
        this.b = context.getApplicationContext();
        if (this.b == null) {
            this.b = context;
        }
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(",")) {
            if (TextUtils.isEmpty(str)) {
                this.c.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(",")) {
            if (!TextUtils.isEmpty(str2)) {
                this.d.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",")) {
            if (!TextUtils.isEmpty(str3)) {
                this.e.add(str3);
            }
        }
    }

    public static p a(Context context) {
        if (a == null) {
            a = new p(context);
        }
        return a;
    }

    public boolean a(String str) {
        boolean contains;
        synchronized (this.c) {
            contains = this.c.contains(str);
        }
        return contains;
    }

    public boolean b(String str) {
        boolean contains;
        synchronized (this.d) {
            contains = this.d.contains(str);
        }
        return contains;
    }

    public boolean c(String str) {
        boolean contains;
        synchronized (this.e) {
            contains = this.e.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.c) {
            if (!this.c.contains(str)) {
                this.c.add(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.channel.commonutils.string.d.a(this.c, ",")).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.d) {
            if (!this.d.contains(str)) {
                this.d.add(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.channel.commonutils.string.d.a(this.d, ",")).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.e) {
            if (!this.e.contains(str)) {
                this.e.add(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.channel.commonutils.string.d.a(this.e, ",")).commit();
            }
        }
    }

    public void g(String str) {
        synchronized (this.c) {
            if (this.c.contains(str)) {
                this.c.remove(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.channel.commonutils.string.d.a(this.c, ",")).commit();
            }
        }
    }

    public void h(String str) {
        synchronized (this.d) {
            if (this.d.contains(str)) {
                this.d.remove(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.channel.commonutils.string.d.a(this.d, ",")).commit();
            }
        }
    }

    public void i(String str) {
        synchronized (this.e) {
            if (this.e.contains(str)) {
                this.e.remove(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.channel.commonutils.string.d.a(this.e, ",")).commit();
            }
        }
    }
}
