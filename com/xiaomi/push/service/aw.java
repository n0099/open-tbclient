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
    private static aw f14258a;

    /* renamed from: a  reason: collision with other field name */
    private int f948a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f949a;

    private aw(Context context) {
        this.f949a = context.getApplicationContext();
    }

    public static aw a(Context context) {
        if (f14258a == null) {
            f14258a = new aw(context);
        }
        return f14258a;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        if (this.f948a != 0) {
            return this.f948a;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                this.f948a = Settings.Global.getInt(this.f949a.getContentResolver(), "device_provisioned", 0);
            } catch (Exception e) {
            }
            return this.f948a;
        }
        this.f948a = Settings.Secure.getInt(this.f949a.getContentResolver(), "device_provisioned", 0);
        return this.f948a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m577a() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m578a() {
        return com.xiaomi.push.ab.f170a.contains("xmsf") || com.xiaomi.push.ab.f170a.contains(RomUtils.MANUFACTURER_XIAOMI) || com.xiaomi.push.ab.f170a.contains("miui");
    }
}
