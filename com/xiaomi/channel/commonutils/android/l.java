package com.xiaomi.channel.commonutils.android;

import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes3.dex */
public final class l {
    public static void a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT > 8) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
}
