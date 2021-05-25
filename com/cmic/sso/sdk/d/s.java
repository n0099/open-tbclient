package com.cmic.sso.sdk.d;

import android.text.TextUtils;
import java.util.UUID;
/* loaded from: classes6.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static char[] f30592a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = f30592a;
            cArr[i2] = cArr2[(b2 >>> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static String b() {
        return c().replace("-", "");
    }

    public static String c() {
        return UUID.randomUUID().toString();
    }

    public static void b(com.cmic.sso.sdk.a aVar, String str) {
        if (TextUtils.isEmpty(aVar.b("interfaceCode", ""))) {
            aVar.a("interfaceCode", str);
            return;
        }
        aVar.a("interfaceCode", aVar.b("interfaceCode") + ";" + str);
    }

    public static void c(com.cmic.sso.sdk.a aVar, String str) {
        if (TextUtils.isEmpty(aVar.b("interfaceElasped", ""))) {
            aVar.a("interfaceElasped", str);
            return;
        }
        aVar.a("interfaceElasped", aVar.b("interfaceElasped") + ";" + str);
    }

    public static String a() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void a(com.cmic.sso.sdk.a aVar, String str) {
        if (TextUtils.isEmpty(aVar.b("interfaceType", ""))) {
            aVar.a("interfaceType", str);
            return;
        }
        aVar.a("interfaceType", aVar.b("interfaceType") + ";" + str);
    }
}
