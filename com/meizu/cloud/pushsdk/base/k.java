package com.meizu.cloud.pushsdk.base;
/* loaded from: classes5.dex */
public class k {
    public static String a(String str) {
        com.meizu.cloud.pushsdk.base.a.d a = com.meizu.cloud.pushsdk.base.a.a.a("android.os.SystemProperties").a("get", String.class).a(str);
        if (a.a) {
            return (String) a.b;
        }
        return null;
    }
}
