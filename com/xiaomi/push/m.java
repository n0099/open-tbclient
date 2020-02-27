package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes8.dex */
public class m {
    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
