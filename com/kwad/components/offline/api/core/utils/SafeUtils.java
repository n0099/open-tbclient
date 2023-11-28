package com.kwad.components.offline.api.core.utils;

import android.content.Context;
/* loaded from: classes10.dex */
public class SafeUtils {
    public static boolean isDebugPkg(Context context) {
        if ((context.getApplicationInfo().flags & 2) != 0) {
            return true;
        }
        return false;
    }
}
