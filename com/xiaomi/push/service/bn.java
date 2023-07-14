package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes10.dex */
public class bn {
    public static bn a;

    /* renamed from: a  reason: collision with other field name */
    public int f945a = 0;

    /* renamed from: a  reason: collision with other field name */
    public Context f946a;

    public bn(Context context) {
        this.f946a = context.getApplicationContext();
    }

    public static bn a(Context context) {
        if (a == null) {
            a = new bn(context);
        }
        return a;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        int i = this.f945a;
        if (i != 0) {
            return i;
        }
        try {
            this.f945a = Settings.Global.getInt(this.f946a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f945a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m797a() {
        return Settings.Global.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m798a() {
        return com.xiaomi.push.ab.f94a.contains("xmsf") || com.xiaomi.push.ab.f94a.contains(RomUtils.MANUFACTURER_XIAOMI) || com.xiaomi.push.ab.f94a.contains("miui");
    }
}
