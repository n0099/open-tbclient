package com.sdk.base.api;

import android.content.Context;
import com.sdk.base.framework.f.h.b;
import com.sdk.base.framework.f.i.a;
import com.sdk.base.framework.f.i.d;
/* loaded from: classes6.dex */
public class ToolUtils {
    public static String AES_Decrypt(String str, String str2) {
        return a.a(str, str2);
    }

    public static String Base64_Decrypt(String str) {
        return d.a(str);
    }

    public static String RsaDecrypt(String str, String str2) {
        return b.a(str, str2);
    }

    public static void clearCache(Context context) {
        com.sdk.base.framework.a.a.a.a(context);
    }

    public static String getAppMd5(Context context) {
        return com.sdk.base.framework.f.a.a.e(context);
    }
}
