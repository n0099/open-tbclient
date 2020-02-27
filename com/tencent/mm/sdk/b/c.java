package com.tencent.mm.sdk.b;

import java.util.TimeZone;
/* loaded from: classes8.dex */
public final class c {
    private static final long[] q = {300, 200, 300, 200};
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final char[] r = {'<', '>', '\"', '\'', '&'};
    private static final String[] s = {"&lt;", "&gt;", "&quot;", "&apos;", "&amp;"};

    public static boolean a(String str) {
        return str == null || str.length() <= 0;
    }
}
