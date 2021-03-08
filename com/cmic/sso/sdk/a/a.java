package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.os.Build;
@SuppressLint({"NewApi"})
/* loaded from: classes14.dex */
public class a {

    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public enum EnumC1052a {
        UNKNOWN,
        SAMSUNG,
        HUAWEI
    }

    private static EnumC1052a erB() {
        String str = Build.BRAND;
        if (str.equalsIgnoreCase("samsung")) {
            return EnumC1052a.SAMSUNG;
        }
        if (str.equalsIgnoreCase("Huawei")) {
            return EnumC1052a.HUAWEI;
        }
        return EnumC1052a.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        return a(erB());
    }

    private static int a(EnumC1052a enumC1052a) {
        switch (enumC1052a) {
            case HUAWEI:
                return 0;
            case SAMSUNG:
                return 1;
            default:
                return -1;
        }
    }
}
