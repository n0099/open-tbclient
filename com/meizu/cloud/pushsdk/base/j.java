package com.meizu.cloud.pushsdk.base;
/* loaded from: classes2.dex */
public class j {
    public static String a(String str) {
        com.meizu.cloud.pushsdk.base.a.d a = com.meizu.cloud.pushsdk.base.a.a.a("android.os.SystemProperties").a("get", String.class).a(str);
        if (a.a) {
            return (String) a.f60360b;
        }
        return null;
    }
}
