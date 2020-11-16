package com.cmic.sso.sdk.e;

import android.content.Context;
/* loaded from: classes10.dex */
public class g {
    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
