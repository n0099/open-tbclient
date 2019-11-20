package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
/* loaded from: classes3.dex */
public class as {
    private static as a;

    /* renamed from: a  reason: collision with other field name */
    private int f870a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f871a;

    private as(Context context) {
        this.f871a = context.getApplicationContext();
    }

    public static as a(Context context) {
        if (a == null) {
            a = new as(context);
        }
        return a;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        if (this.f870a != 0) {
            return this.f870a;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.f870a = Settings.Global.getInt(this.f871a.getContentResolver(), "device_provisioned", 0);
            return this.f870a;
        }
        this.f870a = Settings.Secure.getInt(this.f871a.getContentResolver(), "device_provisioned", 0);
        return this.f870a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m502a() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m503a() {
        return com.xiaomi.push.ab.f112a.contains("xmsf") || com.xiaomi.push.ab.f112a.contains("xiaomi") || com.xiaomi.push.ab.f112a.contains("miui");
    }
}
