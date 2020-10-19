package com.xiaomi.push;

import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes12.dex */
public final class r {
    public static void a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT > 8) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
}
