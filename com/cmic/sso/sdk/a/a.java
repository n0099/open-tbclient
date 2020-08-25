package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.os.Build;
@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public enum EnumC0855a {
        UNKNOWN,
        SAMSUNG,
        HUAWEI
    }

    private static EnumC0855a dNe() {
        String str = Build.BRAND;
        if (str.equalsIgnoreCase("samsung")) {
            return EnumC0855a.SAMSUNG;
        }
        if (str.equalsIgnoreCase("Huawei")) {
            return EnumC0855a.HUAWEI;
        }
        return EnumC0855a.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        return a(dNe());
    }

    private static int a(EnumC0855a enumC0855a) {
        switch (enumC0855a) {
            case HUAWEI:
                return 0;
            case SAMSUNG:
                return 1;
            default:
                return -1;
        }
    }
}
