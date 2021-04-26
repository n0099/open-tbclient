package com.meizu.cloud.pushsdk.base;
/* loaded from: classes6.dex */
public class j {
    public static String a(String str) {
        com.meizu.cloud.pushsdk.base.a.d a2 = com.meizu.cloud.pushsdk.base.a.a.a("android.os.SystemProperties").a("get", String.class).a(str);
        if (a2.f35570a) {
            return (String) a2.f35571b;
        }
        return null;
    }
}
