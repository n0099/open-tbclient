package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes18.dex */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    private static aw f5068a;

    /* renamed from: a  reason: collision with other field name */
    private int f872a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f873a;

    private aw(Context context) {
        this.f873a = context.getApplicationContext();
    }

    public static aw a(Context context) {
        if (f5068a == null) {
            f5068a = new aw(context);
        }
        return f5068a;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        if (this.f872a != 0) {
            return this.f872a;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                this.f872a = Settings.Global.getInt(this.f873a.getContentResolver(), "device_provisioned", 0);
            } catch (Exception e) {
            }
            return this.f872a;
        }
        this.f872a = Settings.Secure.getInt(this.f873a.getContentResolver(), "device_provisioned", 0);
        return this.f872a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m555a() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m556a() {
        return com.xiaomi.push.ab.f94a.contains("xmsf") || com.xiaomi.push.ab.f94a.contains(RomUtils.MANUFACTURER_XIAOMI) || com.xiaomi.push.ab.f94a.contains("miui");
    }
}
