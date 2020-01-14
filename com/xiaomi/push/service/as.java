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
    private int f874a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f875a;

    private as(Context context) {
        this.f875a = context.getApplicationContext();
    }

    public static as a(Context context) {
        if (a == null) {
            a = new as(context);
        }
        return a;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        if (this.f874a != 0) {
            return this.f874a;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.f874a = Settings.Global.getInt(this.f875a.getContentResolver(), "device_provisioned", 0);
            return this.f874a;
        }
        this.f874a = Settings.Secure.getInt(this.f875a.getContentResolver(), "device_provisioned", 0);
        return this.f874a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m514a() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m515a() {
        return com.xiaomi.push.ab.f116a.contains("xmsf") || com.xiaomi.push.ab.f116a.contains("xiaomi") || com.xiaomi.push.ab.f116a.contains("miui");
    }
}
