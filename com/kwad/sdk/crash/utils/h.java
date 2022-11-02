package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes8.dex */
public final class h {
    public static SimpleDateFormat aio = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String L(long j) {
        return j <= 0 ? "unknown" : aio.format(new Date(j));
    }
}
