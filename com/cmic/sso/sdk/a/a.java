package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.os.Build;
@SuppressLint({"NewApi"})
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.cmic.sso.sdk.a.a$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30528a;

        static {
            int[] iArr = new int[EnumC0339a.values().length];
            f30528a = iArr;
            try {
                iArr[EnumC0339a.HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30528a[EnumC0339a.SAMSUNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public enum EnumC0339a {
        UNKNOWN,
        SAMSUNG,
        HUAWEI
    }

    public static int a() {
        return a(b());
    }

    public static EnumC0339a b() {
        String str = Build.BRAND;
        if (str.equalsIgnoreCase("samsung")) {
            return EnumC0339a.SAMSUNG;
        }
        if (str.equalsIgnoreCase("Huawei")) {
            return EnumC0339a.HUAWEI;
        }
        return EnumC0339a.UNKNOWN;
    }

    public static int a(EnumC0339a enumC0339a) {
        int i = AnonymousClass1.f30528a[enumC0339a.ordinal()];
        if (i != 1) {
            return i != 2 ? -1 : 1;
        }
        return 0;
    }
}
