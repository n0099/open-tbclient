package com.meizu.cloud.pushsdk.base;
/* loaded from: classes2.dex */
public class j {
    public static String a(String str) {
        com.meizu.cloud.pushsdk.base.a.d a2 = com.meizu.cloud.pushsdk.base.a.a.a("android.os.SystemProperties").a("get", String.class).a(str);
        if (a2.f68339a) {
            return (String) a2.f68340b;
        }
        return null;
    }
}
