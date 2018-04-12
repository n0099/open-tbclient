package com.xiaomi.channel.commonutils.android;

import com.meizu.cloud.pushsdk.constants.MeizuConstants;
/* loaded from: classes3.dex */
public class i {
    public static String a(String str, String str2) {
        try {
            return (String) Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES).getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }
}
