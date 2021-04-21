package com.kwad.sdk.core.network;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final String f34262a = b() + "ksad-android-3.3.9";

    public static String a() {
        return f34262a;
    }

    public static String b() {
        String property = System.getProperty("http.agent");
        if (TextUtils.isEmpty(property)) {
            return property;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = property.length();
        for (int i = 0; i < length; i++) {
            char charAt = property.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                stringBuffer.append(charAt);
            }
        }
        stringBuffer.append("-");
        return stringBuffer.toString();
    }
}
