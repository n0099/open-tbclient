package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes5.dex */
public final class h {
    public static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String a(long j) {
        return j <= 0 ? "unknown" : a.format(new Date(j));
    }
}
