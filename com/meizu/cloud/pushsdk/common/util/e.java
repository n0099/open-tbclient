package com.meizu.cloud.pushsdk.common.util;

import com.meizu.cloud.pushsdk.common.util.d;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class e {
    private static HashMap<String, d.c> a = new HashMap<>();

    public static <T> d.c<T> a(String str) {
        if (a.containsKey(str)) {
            return a.get(str);
        }
        d.c<T> a2 = d.a(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES).b("get").a(new Object[]{str}).a();
        if (a2.a) {
            a.put(str, a2);
            return a2;
        }
        return a2;
    }
}
