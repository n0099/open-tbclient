package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
/* loaded from: classes6.dex */
public class as {
    private static as a;

    /* renamed from: a  reason: collision with other field name */
    private int f873a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f874a;

    private as(Context context) {
        this.f874a = context.getApplicationContext();
    }

    public static as a(Context context) {
        if (a == null) {
            a = new as(context);
        }
        return a;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        if (this.f873a != 0) {
            return this.f873a;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.f873a = Settings.Global.getInt(this.f874a.getContentResolver(), "device_provisioned", 0);
            return this.f873a;
        }
        this.f873a = Settings.Secure.getInt(this.f874a.getContentResolver(), "device_provisioned", 0);
        return this.f873a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m514a() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m515a() {
        return com.xiaomi.push.ab.f115a.contains("xmsf") || com.xiaomi.push.ab.f115a.contains("xiaomi") || com.xiaomi.push.ab.f115a.contains("miui");
    }
}
