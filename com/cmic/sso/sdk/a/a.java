package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.os.Build;
@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public enum EnumC1010a {
        UNKNOWN,
        SAMSUNG,
        HUAWEI
    }

    private static EnumC1010a esK() {
        String str = Build.BRAND;
        if (str.equalsIgnoreCase("samsung")) {
            return EnumC1010a.SAMSUNG;
        }
        if (str.equalsIgnoreCase("Huawei")) {
            return EnumC1010a.HUAWEI;
        }
        return EnumC1010a.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        return a(esK());
    }

    private static int a(EnumC1010a enumC1010a) {
        switch (enumC1010a) {
            case HUAWEI:
                return 0;
            case SAMSUNG:
                return 1;
            default:
                return -1;
        }
    }
}
