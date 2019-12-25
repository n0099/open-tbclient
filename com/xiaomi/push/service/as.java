package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
/* loaded from: classes5.dex */
public class as {
    private static as a;

    /* renamed from: a  reason: collision with other field name */
    private int f875a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f876a;

    private as(Context context) {
        this.f876a = context.getApplicationContext();
    }

    public static as a(Context context) {
        if (a == null) {
            a = new as(context);
        }
        return a;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        if (this.f875a != 0) {
            return this.f875a;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.f875a = Settings.Global.getInt(this.f876a.getContentResolver(), "device_provisioned", 0);
            return this.f875a;
        }
        this.f875a = Settings.Secure.getInt(this.f876a.getContentResolver(), "device_provisioned", 0);
        return this.f875a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m505a() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m506a() {
        return com.xiaomi.push.ab.f117a.contains("xmsf") || com.xiaomi.push.ab.f117a.contains("xiaomi") || com.xiaomi.push.ab.f117a.contains("miui");
    }
}
