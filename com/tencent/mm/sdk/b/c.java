package com.tencent.mm.sdk.b;

import java.util.TimeZone;
import kotlin.text.Typography;
/* loaded from: classes6.dex */
public final class c {
    public static final long[] q = {300, 200, 300, 200};
    public static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    public static final char[] r = {Typography.less, Typography.greater, Typography.quote, '\'', Typography.amp};
    public static final String[] s = {"&lt;", "&gt;", "&quot;", "&apos;", "&amp;"};

    public static boolean a(String str) {
        return str == null || str.length() <= 0;
    }
}
