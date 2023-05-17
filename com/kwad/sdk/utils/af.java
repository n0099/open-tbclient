package com.kwad.sdk.utils;

import androidx.annotation.Nullable;
import java.util.List;
/* loaded from: classes9.dex */
public final class af {
    public static boolean C(@Nullable List<?> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static void checkUiThread() {
        SystemUtil.checkUiThread();
    }
}
