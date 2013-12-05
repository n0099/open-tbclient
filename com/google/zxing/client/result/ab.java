package com.google.zxing.client.result;

import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class ab extends q {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f2841a = Pattern.compile(":/*([^/@]+)@[^/]+");
    private final String b;
    private final String c;

    public ab(String str, String str2) {
        super(ParsedResultType.URI);
        this.b = a(str);
        this.c = str2;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        a(this.c, sb);
        a(this.b, sb);
        return sb.toString();
    }

    private static String a(String str) {
        String trim = str.trim();
        int indexOf = trim.indexOf(58);
        if (indexOf < 0) {
            return com.baidu.loginshare.e.f + trim;
        }
        if (a(trim, indexOf)) {
            return com.baidu.loginshare.e.f + trim;
        }
        return trim;
    }

    private static boolean a(String str, int i) {
        int indexOf = str.indexOf(47, i + 1);
        int length = indexOf < 0 ? str.length() : indexOf;
        if (length <= i + 1) {
            return false;
        }
        for (int i2 = i + 1; i2 < length; i2++) {
            if (str.charAt(i2) < '0' || str.charAt(i2) > '9') {
                return false;
            }
        }
        return true;
    }
}
