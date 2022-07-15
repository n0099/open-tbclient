package com.kwad.sdk.api.core;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class RequestParamsUtils {
    public static final String USER_AGENT = getUserAgentParams() + "ksad-android-3.3.24";
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
