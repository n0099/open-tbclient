package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public final class c {
    public static boolean a(@NonNull Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy();
    }
}
