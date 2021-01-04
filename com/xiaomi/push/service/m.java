package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static m f14608a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f996a;

    /* renamed from: a  reason: collision with other field name */
    private List<String> f997a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f14609b = new ArrayList();
    private final List<String> c = new ArrayList();

    private m(Context context) {
        String[] split;
        String[] split2;
        String[] split3;
        this.f996a = context.getApplicationContext();
        if (this.f996a == null) {
            this.f996a = context;
        }
        SharedPreferences sharedPreferences = this.f996a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(",")) {
            if (TextUtils.isEmpty(str)) {
                this.f997a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(",")) {
            if (!TextUtils.isEmpty(str2)) {
                this.f14609b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",")) {
            if (!TextUtils.isEmpty(str3)) {
                this.c.add(str3);
            }
        }
    }

    public static m a(Context context) {
        if (f14608a == null) {
            f14608a = new m(context);
        }
        return f14608a;
    }

    public void a(String str) {
        synchronized (this.f997a) {
            if (!this.f997a.contains(str)) {
                this.f997a.add(str);
                this.f996a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bf.a(this.f997a, ",")).commit();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m599a(String str) {
        boolean contains;
        synchronized (this.f997a) {
            contains = this.f997a.contains(str);
        }
        return contains;
    }

    public void b(String str) {
        synchronized (this.f14609b) {
            if (!this.f14609b.contains(str)) {
                this.f14609b.add(str);
                this.f996a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bf.a(this.f14609b, ",")).commit();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m600b(String str) {
        boolean contains;
        synchronized (this.f14609b) {
            contains = this.f14609b.contains(str);
        }
        return contains;
    }

    public void c(String str) {
        synchronized (this.c) {
            if (!this.c.contains(str)) {
                this.c.add(str);
                this.f996a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bf.a(this.c, ",")).commit();
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m601c(String str) {
        boolean contains;
        synchronized (this.c) {
            contains = this.c.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.f997a) {
            if (this.f997a.contains(str)) {
                this.f997a.remove(str);
                this.f996a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bf.a(this.f997a, ",")).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.f14609b) {
            if (this.f14609b.contains(str)) {
                this.f14609b.remove(str);
                this.f996a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bf.a(this.f14609b, ",")).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.c) {
            if (this.c.contains(str)) {
                this.c.remove(str);
                this.f996a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bf.a(this.c, ",")).commit();
            }
        }
    }
}
