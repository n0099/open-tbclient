package com.ta.utdid2.a.a;

import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f38982a = Pattern.compile("([\t\r\n])+");

    public static int hashCode(String str) {
        if (str.length() > 0) {
            int i = 0;
            for (char c2 : str.toCharArray()) {
                i = (i * 31) + c2;
            }
            return i;
        }
        return 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() <= 0;
    }
}
