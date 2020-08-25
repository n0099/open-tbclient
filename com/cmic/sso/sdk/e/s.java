package com.cmic.sso.sdk.e;

import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;
/* loaded from: classes7.dex */
public class s {
    private static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr[i] = a[(b >>> 4) & 15];
            i = i2 + 1;
            cArr[i2] = a[b & 15];
        }
        return new String(cArr);
    }

    public static String a() {
        return UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public static String b() {
        return c().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    private static String c() {
        return UUID.randomUUID().toString();
    }

    public static void a(com.cmic.sso.sdk.a aVar, String str) {
        if (TextUtils.isEmpty(aVar.b("interfaceType", ""))) {
            aVar.a("interfaceType", str);
        } else {
            aVar.a("interfaceType", aVar.b("interfaceType") + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str);
        }
    }

    public static void b(com.cmic.sso.sdk.a aVar, String str) {
        if (TextUtils.isEmpty(aVar.b("interfaceCode", ""))) {
            aVar.a("interfaceCode", str);
        } else {
            aVar.a("interfaceCode", aVar.b("interfaceCode") + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str);
        }
    }

    public static void c(com.cmic.sso.sdk.a aVar, String str) {
        if (TextUtils.isEmpty(aVar.b("interfaceElasped", ""))) {
            aVar.a("interfaceElasped", str);
        } else {
            aVar.a("interfaceElasped", aVar.b("interfaceElasped") + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str);
        }
    }
}
