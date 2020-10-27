package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes12.dex */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    private static aw f5066a;

    /* renamed from: a  reason: collision with other field name */
    private int f867a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f868a;

    private aw(Context context) {
        this.f868a = context.getApplicationContext();
    }

    public static aw a(Context context) {
        if (f5066a == null) {
            f5066a = new aw(context);
        }
        return f5066a;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        if (this.f867a != 0) {
            return this.f867a;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                this.f867a = Settings.Global.getInt(this.f868a.getContentResolver(), "device_provisioned", 0);
            } catch (Exception e) {
            }
            return this.f867a;
        }
        this.f867a = Settings.Secure.getInt(this.f868a.getContentResolver(), "device_provisioned", 0);
        return this.f867a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m552a() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m553a() {
        return com.xiaomi.push.ab.f89a.contains("xmsf") || com.xiaomi.push.ab.f89a.contains(RomUtils.MANUFACTURER_XIAOMI) || com.xiaomi.push.ab.f89a.contains("miui");
    }
}
