package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class m {
    private static m a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f921a;

    /* renamed from: a  reason: collision with other field name */
    private List<String> f922a = new ArrayList();
    private final List<String> b = new ArrayList();
    private final List<String> c = new ArrayList();

    private m(Context context) {
        String[] split;
        String[] split2;
        String[] split3;
        this.f921a = context.getApplicationContext();
        if (this.f921a == null) {
            this.f921a = context;
        }
        SharedPreferences sharedPreferences = this.f921a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (TextUtils.isEmpty(str)) {
                this.f922a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str2)) {
                this.b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str3)) {
                this.c.add(str3);
            }
        }
    }

    public static m a(Context context) {
        if (a == null) {
            a = new m(context);
        }
        return a;
    }

    public void a(String str) {
        synchronized (this.f922a) {
            if (!this.f922a.contains(str)) {
                this.f922a.add(str);
                this.f921a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.ay.a(this.f922a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m542a(String str) {
        boolean contains;
        synchronized (this.f922a) {
            contains = this.f922a.contains(str);
        }
        return contains;
    }

    public void b(String str) {
        synchronized (this.b) {
            if (!this.b.contains(str)) {
                this.b.add(str);
                this.f921a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.ay.a(this.b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m543b(String str) {
        boolean contains;
        synchronized (this.b) {
            contains = this.b.contains(str);
        }
        return contains;
    }

    public void c(String str) {
        synchronized (this.c) {
            if (!this.c.contains(str)) {
                this.c.add(str);
                this.f921a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.ay.a(this.c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m544c(String str) {
        boolean contains;
        synchronized (this.c) {
            contains = this.c.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.f922a) {
            if (this.f922a.contains(str)) {
                this.f922a.remove(str);
                this.f921a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.ay.a(this.f922a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.b) {
            if (this.b.contains(str)) {
                this.b.remove(str);
                this.f921a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.ay.a(this.b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.c) {
            if (this.c.contains(str)) {
                this.c.remove(str);
                this.f921a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.ay.a(this.c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }
}
