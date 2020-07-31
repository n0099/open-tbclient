package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes9.dex */
public class aw {
    private static aw a;

    /* renamed from: a  reason: collision with other field name */
    private int f871a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f872a;

    private aw(Context context) {
        this.f872a = context.getApplicationContext();
    }

    public static aw a(Context context) {
        if (a == null) {
            a = new aw(context);
        }
        return a;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        if (this.f871a != 0) {
            return this.f871a;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                this.f871a = Settings.Global.getInt(this.f872a.getContentResolver(), "device_provisioned", 0);
            } catch (Exception e) {
            }
            return this.f871a;
        }
        this.f871a = Settings.Secure.getInt(this.f872a.getContentResolver(), "device_provisioned", 0);
        return this.f871a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m547a() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m548a() {
        return com.xiaomi.push.ab.f93a.contains("xmsf") || com.xiaomi.push.ab.f93a.contains(RomUtils.MANUFACTURER_XIAOMI) || com.xiaomi.push.ab.f93a.contains("miui");
    }
}
