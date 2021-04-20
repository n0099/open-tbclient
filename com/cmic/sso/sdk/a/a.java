package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.os.Build;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class a {

    /* renamed from: com.cmic.sso.sdk.a.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30214a;

        static {
            int[] iArr = new int[EnumC0342a.values().length];
            f30214a = iArr;
            try {
                iArr[EnumC0342a.HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30214a[EnumC0342a.SAMSUNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public enum EnumC0342a {
        UNKNOWN,
        SAMSUNG,
        HUAWEI
    }

    public static int a() {
        return a(b());
    }

    public static EnumC0342a b() {
        String str = Build.BRAND;
        if (str.equalsIgnoreCase("samsung")) {
            return EnumC0342a.SAMSUNG;
        }
        if (str.equalsIgnoreCase("Huawei")) {
            return EnumC0342a.HUAWEI;
        }
        return EnumC0342a.UNKNOWN;
    }

    public static int a(EnumC0342a enumC0342a) {
        int i = AnonymousClass1.f30214a[enumC0342a.ordinal()];
        if (i != 1) {
            return i != 2 ? -1 : 1;
        }
        return 0;
    }
}
