package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
/* loaded from: classes3.dex */
public class az {
    private static az a;
    private Context b;
    private int c = 0;

    private az(Context context) {
        this.b = context.getApplicationContext();
    }

    public static az a(Context context) {
        if (a == null) {
            a = new az(context);
        }
        return a;
    }

    public boolean a() {
        return com.xiaomi.channel.commonutils.misc.a.a.contains("xmsf") || com.xiaomi.channel.commonutils.misc.a.a.contains("xiaomi") || com.xiaomi.channel.commonutils.misc.a.a.contains("miui");
    }

    @SuppressLint({"NewApi"})
    public int b() {
        if (this.c != 0) {
            return this.c;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.c = Settings.Global.getInt(this.b.getContentResolver(), "device_provisioned", 0);
            return this.c;
        }
        this.c = Settings.Secure.getInt(this.b.getContentResolver(), "device_provisioned", 0);
        return this.c;
    }

    @SuppressLint({"NewApi"})
    public Uri c() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }
}
