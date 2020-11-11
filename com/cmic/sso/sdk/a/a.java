package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.os.Build;
@SuppressLint({"NewApi"})
/* loaded from: classes8.dex */
public class a {

    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public enum EnumC0961a {
        UNKNOWN,
        SAMSUNG,
        HUAWEI
    }

    private static EnumC0961a eiJ() {
        String str = Build.BRAND;
        if (str.equalsIgnoreCase("samsung")) {
            return EnumC0961a.SAMSUNG;
        }
        if (str.equalsIgnoreCase("Huawei")) {
            return EnumC0961a.HUAWEI;
        }
        return EnumC0961a.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        return a(eiJ());
    }

    private static int a(EnumC0961a enumC0961a) {
        switch (enumC0961a) {
            case HUAWEI:
                return 0;
            case SAMSUNG:
                return 1;
            default:
                return -1;
        }
    }
}
