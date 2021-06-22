package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes7.dex */
public class bc {

    /* renamed from: a  reason: collision with root package name */
    public static bc f41876a;

    /* renamed from: a  reason: collision with other field name */
    public int f920a = 0;

    /* renamed from: a  reason: collision with other field name */
    public Context f921a;

    public bc(Context context) {
        this.f921a = context.getApplicationContext();
    }

    public static bc a(Context context) {
        if (f41876a == null) {
            f41876a = new bc(context);
        }
        return f41876a;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        int i2 = this.f920a;
        if (i2 != 0) {
            return i2;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                this.f920a = Settings.Global.getInt(this.f921a.getContentResolver(), "device_provisioned", 0);
            } catch (Exception unused) {
            }
            return this.f920a;
        }
        int i3 = Settings.Secure.getInt(this.f921a.getContentResolver(), "device_provisioned", 0);
        this.f920a = i3;
        return i3;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m594a() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m595a() {
        return com.xiaomi.push.ab.f100a.contains("xmsf") || com.xiaomi.push.ab.f100a.contains(RomUtils.MANUFACTURER_XIAOMI) || com.xiaomi.push.ab.f100a.contains("miui");
    }
}
