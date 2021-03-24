package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static n f41050a;

    /* renamed from: a  reason: collision with other field name */
    public Context f961a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f962a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f41051b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f41052c = new ArrayList();

    public n(Context context) {
        String[] split;
        String[] split2;
        String[] split3;
        Context applicationContext = context.getApplicationContext();
        this.f961a = applicationContext;
        if (applicationContext == null) {
            this.f961a = context;
        }
        SharedPreferences sharedPreferences = this.f961a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(",")) {
            if (TextUtils.isEmpty(str)) {
                this.f962a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(",")) {
            if (!TextUtils.isEmpty(str2)) {
                this.f41051b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",")) {
            if (!TextUtils.isEmpty(str3)) {
                this.f41052c.add(str3);
            }
        }
    }

    public static n a(Context context) {
        if (f41050a == null) {
            f41050a = new n(context);
        }
        return f41050a;
    }

    public void a(String str) {
        synchronized (this.f962a) {
            if (!this.f962a.contains(str)) {
                this.f962a.add(str);
                this.f961a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bm.a(this.f962a, ",")).commit();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m614a(String str) {
        boolean contains;
        synchronized (this.f962a) {
            contains = this.f962a.contains(str);
        }
        return contains;
    }

    public void b(String str) {
        synchronized (this.f41051b) {
            if (!this.f41051b.contains(str)) {
                this.f41051b.add(str);
                this.f961a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bm.a(this.f41051b, ",")).commit();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m615b(String str) {
        boolean contains;
        synchronized (this.f41051b) {
            contains = this.f41051b.contains(str);
        }
        return contains;
    }

    public void c(String str) {
        synchronized (this.f41052c) {
            if (!this.f41052c.contains(str)) {
                this.f41052c.add(str);
                this.f961a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bm.a(this.f41052c, ",")).commit();
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m616c(String str) {
        boolean contains;
        synchronized (this.f41052c) {
            contains = this.f41052c.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.f962a) {
            if (this.f962a.contains(str)) {
                this.f962a.remove(str);
                this.f961a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bm.a(this.f962a, ",")).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.f41051b) {
            if (this.f41051b.contains(str)) {
                this.f41051b.remove(str);
                this.f961a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bm.a(this.f41051b, ",")).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.f41052c) {
            if (this.f41052c.contains(str)) {
                this.f41052c.remove(str);
                this.f961a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bm.a(this.f41052c, ",")).commit();
            }
        }
    }
}
