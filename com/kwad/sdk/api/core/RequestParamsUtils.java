package com.kwad.sdk.api.core;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class RequestParamsUtils {
    public static final String USER_AGENT = getUserAgentParams() + "ksad-android-3.3.17.4";
    public static final String USER_AGENT_KEY = "User-Agent";

    public static String getUserAgent() {
        return USER_AGENT;
    }

    public static String getUserAgentParams() {
        String property = System.getProperty("http.agent");
        if (TextUtils.isEmpty(property)) {
            return property;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = property.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = property.charAt(i2);
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
