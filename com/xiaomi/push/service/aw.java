package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes6.dex */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    private static aw f14556a;

    /* renamed from: a  reason: collision with other field name */
    private int f949a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f950a;

    private aw(Context context) {
        this.f950a = context.getApplicationContext();
    }

    public static aw a(Context context) {
        if (f14556a == null) {
            f14556a = new aw(context);
        }
        return f14556a;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        if (this.f949a != 0) {
            return this.f949a;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                this.f949a = Settings.Global.getInt(this.f950a.getContentResolver(), "device_provisioned", 0);
            } catch (Exception e) {
            }
            return this.f949a;
        }
        this.f949a = Settings.Secure.getInt(this.f950a.getContentResolver(), "device_provisioned", 0);
        return this.f949a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m582a() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m583a() {
        return com.xiaomi.push.ab.f171a.contains("xmsf") || com.xiaomi.push.ab.f171a.contains(RomUtils.MANUFACTURER_XIAOMI) || com.xiaomi.push.ab.f171a.contains("miui");
    }
}
