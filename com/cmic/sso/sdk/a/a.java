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
        public static final /* synthetic */ int[] f30309a;

        static {
            int[] iArr = new int[EnumC0344a.values().length];
            f30309a = iArr;
            try {
                iArr[EnumC0344a.HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30309a[EnumC0344a.SAMSUNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public enum EnumC0344a {
        UNKNOWN,
        SAMSUNG,
        HUAWEI
    }

    public static int a() {
        return a(b());
    }

    public static EnumC0344a b() {
        String str = Build.BRAND;
        if (str.equalsIgnoreCase("samsung")) {
            return EnumC0344a.SAMSUNG;
        }
        if (str.equalsIgnoreCase("Huawei")) {
            return EnumC0344a.HUAWEI;
        }
        return EnumC0344a.UNKNOWN;
    }

    public static int a(EnumC0344a enumC0344a) {
        int i = AnonymousClass1.f30309a[enumC0344a.ordinal()];
        if (i != 1) {
            return i != 2 ? -1 : 1;
        }
        return 0;
    }
}
