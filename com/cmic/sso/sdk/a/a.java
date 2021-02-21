package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.os.Build;
@SuppressLint({"NewApi"})
/* loaded from: classes15.dex */
public class a {

    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public enum EnumC1037a {
        UNKNOWN,
        SAMSUNG,
        HUAWEI
    }

    private static EnumC1037a ers() {
        String str = Build.BRAND;
        if (str.equalsIgnoreCase("samsung")) {
            return EnumC1037a.SAMSUNG;
        }
        if (str.equalsIgnoreCase("Huawei")) {
            return EnumC1037a.HUAWEI;
        }
        return EnumC1037a.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        return a(ers());
    }

    private static int a(EnumC1037a enumC1037a) {
        switch (enumC1037a) {
            case HUAWEI:
                return 0;
            case SAMSUNG:
                return 1;
            default:
                return -1;
        }
    }
}
