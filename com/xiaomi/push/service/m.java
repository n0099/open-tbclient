package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static m f14609a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f997a;

    /* renamed from: a  reason: collision with other field name */
    private List<String> f998a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f14610b = new ArrayList();
    private final List<String> c = new ArrayList();

    private m(Context context) {
        String[] split;
        String[] split2;
        String[] split3;
        this.f997a = context.getApplicationContext();
        if (this.f997a == null) {
            this.f997a = context;
        }
        SharedPreferences sharedPreferences = this.f997a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(",")) {
            if (TextUtils.isEmpty(str)) {
                this.f998a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(",")) {
            if (!TextUtils.isEmpty(str2)) {
                this.f14610b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",")) {
            if (!TextUtils.isEmpty(str3)) {
                this.c.add(str3);
            }
        }
    }

    public static m a(Context context) {
        if (f14609a == null) {
            f14609a = new m(context);
        }
        return f14609a;
    }

    public void a(String str) {
        synchronized (this.f998a) {
            if (!this.f998a.contains(str)) {
                this.f998a.add(str);
                this.f997a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bf.a(this.f998a, ",")).commit();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m610a(String str) {
        boolean contains;
        synchronized (this.f998a) {
            contains = this.f998a.contains(str);
        }
        return contains;
    }

    public void b(String str) {
        synchronized (this.f14610b) {
            if (!this.f14610b.contains(str)) {
                this.f14610b.add(str);
                this.f997a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bf.a(this.f14610b, ",")).commit();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m611b(String str) {
        boolean contains;
        synchronized (this.f14610b) {
            contains = this.f14610b.contains(str);
        }
        return contains;
    }

    public void c(String str) {
        synchronized (this.c) {
            if (!this.c.contains(str)) {
                this.c.add(str);
                this.f997a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bf.a(this.c, ",")).commit();
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m612c(String str) {
        boolean contains;
        synchronized (this.c) {
            contains = this.c.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.f998a) {
            if (this.f998a.contains(str)) {
                this.f998a.remove(str);
                this.f997a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bf.a(this.f998a, ",")).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.f14610b) {
            if (this.f14610b.contains(str)) {
                this.f14610b.remove(str);
                this.f997a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bf.a(this.f14610b, ",")).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.c) {
            if (this.c.contains(str)) {
                this.c.remove(str);
                this.f997a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bf.a(this.c, ",")).commit();
            }
        }
    }
}
