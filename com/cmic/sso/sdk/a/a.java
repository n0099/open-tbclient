package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.os.Build;
@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public enum EnumC1048a {
        UNKNOWN,
        SAMSUNG,
        HUAWEI
    }

    private static EnumC1048a esL() {
        String str = Build.BRAND;
        if (str.equalsIgnoreCase("samsung")) {
            return EnumC1048a.SAMSUNG;
        }
        if (str.equalsIgnoreCase("Huawei")) {
            return EnumC1048a.HUAWEI;
        }
        return EnumC1048a.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        return a(esL());
    }

    private static int a(EnumC1048a enumC1048a) {
        switch (enumC1048a) {
            case HUAWEI:
                return 0;
            case SAMSUNG:
                return 1;
            default:
                return -1;
        }
    }
}
