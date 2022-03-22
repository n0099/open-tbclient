package com.meizu.cloud.pushsdk.base;

import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
/* loaded from: classes7.dex */
public class j {
    public static String a(String str) {
        com.meizu.cloud.pushsdk.base.a.d a = com.meizu.cloud.pushsdk.base.a.a.a("android.os.SystemProperties").a(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class).a(str);
        if (a.a) {
            return (String) a.f42035b;
        }
        return null;
    }
}
