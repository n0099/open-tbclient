package com.ta.utdid2.a.a;

import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f39812a = Pattern.compile("([\t\r\n])+");

    public static int hashCode(String str) {
        if (str.length() > 0) {
            int i2 = 0;
            for (char c2 : str.toCharArray()) {
                i2 = (i2 * 31) + c2;
            }
            return i2;
        }
        return 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() <= 0;
    }
}
