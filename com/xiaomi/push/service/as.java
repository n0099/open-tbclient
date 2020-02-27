package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
/* loaded from: classes8.dex */
public class as {
    private static as a;

    /* renamed from: a  reason: collision with other field name */
    private int f871a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f872a;

    private as(Context context) {
        this.f872a = context.getApplicationContext();
    }

    public static as a(Context context) {
        if (a == null) {
            a = new as(context);
        }
        return a;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        if (this.f871a != 0) {
            return this.f871a;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.f871a = Settings.Global.getInt(this.f872a.getContentResolver(), "device_provisioned", 0);
            return this.f871a;
        }
        this.f871a = Settings.Secure.getInt(this.f872a.getContentResolver(), "device_provisioned", 0);
        return this.f871a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m519a() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m520a() {
        return com.xiaomi.push.ab.f113a.contains("xmsf") || com.xiaomi.push.ab.f113a.contains("xiaomi") || com.xiaomi.push.ab.f113a.contains("miui");
    }
}
