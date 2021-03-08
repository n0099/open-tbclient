package com.kwad.sdk.core.network;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6189a = b() + "ksad-android-3.3.9";

    public static String a() {
        return f6189a;
    }

    private static String b() {
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
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return stringBuffer.toString();
    }
}
