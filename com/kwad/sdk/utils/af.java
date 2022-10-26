package com.kwad.sdk.utils;

import java.util.List;
/* loaded from: classes8.dex */
public final class af {
    public static boolean C(List list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static void checkUiThread() {
        SystemUtil.checkUiThread();
    }
}
