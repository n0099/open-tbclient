package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.os.Build;
@SuppressLint({"NewApi"})
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public enum EnumC1031a {
        UNKNOWN,
        SAMSUNG,
        HUAWEI
    }

    private static EnumC1031a eoR() {
        String str = Build.BRAND;
        if (str.equalsIgnoreCase("samsung")) {
            return EnumC1031a.SAMSUNG;
        }
        if (str.equalsIgnoreCase("Huawei")) {
            return EnumC1031a.HUAWEI;
        }
        return EnumC1031a.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        return a(eoR());
    }

    private static int a(EnumC1031a enumC1031a) {
        switch (enumC1031a) {
            case HUAWEI:
                return 0;
            case SAMSUNG:
                return 1;
            default:
                return -1;
        }
    }
}
