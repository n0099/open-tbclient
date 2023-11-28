package com.kwad.sdk.utils;

import androidx.annotation.Nullable;
import java.util.List;
/* loaded from: classes10.dex */
public final class ah {
    public static boolean L(@Nullable List<?> list) {
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean M(@Nullable List<?> list) {
        if (list != null && !list.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    public static void checkUiThread() {
        SystemUtil.checkUiThread();
    }
}
