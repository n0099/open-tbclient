package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
/* loaded from: classes8.dex */
public final class c {
    public static boolean bQ(Context context) {
        try {
            if (context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
                if (!Environment.isExternalStorageLegacy()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
