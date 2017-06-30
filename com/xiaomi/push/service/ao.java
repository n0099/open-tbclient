package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
/* loaded from: classes2.dex */
public class ao {
    private static ao a;
    private Context b;
    private int c = 0;

    private ao(Context context) {
        this.b = context.getApplicationContext();
    }

    public static ao a(Context context) {
        if (a == null) {
            a = new ao(context);
        }
        return a;
    }

    public boolean a() {
        return com.xiaomi.channel.commonutils.misc.a.a.contains("xmsf") || com.xiaomi.channel.commonutils.misc.a.a.contains("xiaomi") || com.xiaomi.channel.commonutils.misc.a.a.contains("miui");
    }

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

    public Uri c() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }
}
