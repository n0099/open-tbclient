package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes10.dex */
public final class i {
    public static SimpleDateFormat aGN = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String ap(long j) {
        if (j <= 0) {
            return "unknown";
        }
        return aGN.format(new Date(j));
    }
}
