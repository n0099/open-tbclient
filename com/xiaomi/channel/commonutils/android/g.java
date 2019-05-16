package com.xiaomi.channel.commonutils.android;

import android.content.Context;
/* loaded from: classes3.dex */
public class g {
    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
