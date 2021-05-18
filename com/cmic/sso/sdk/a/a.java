package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.os.Build;
import com.google.android.material.internal.ManufacturerUtils;
@SuppressLint({"NewApi"})
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.cmic.sso.sdk.a.a$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30478a;

        static {
            int[] iArr = new int[EnumC0324a.values().length];
            f30478a = iArr;
            try {
                iArr[EnumC0324a.HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30478a[EnumC0324a.SAMSUNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public enum EnumC0324a {
        UNKNOWN,
        SAMSUNG,
        HUAWEI
    }

    public static int a() {
        return a(b());
    }

    public static EnumC0324a b() {
        String str = Build.BRAND;
        if (str.equalsIgnoreCase(ManufacturerUtils.SAMSUNG)) {
            return EnumC0324a.SAMSUNG;
        }
        if (str.equalsIgnoreCase("Huawei")) {
            return EnumC0324a.HUAWEI;
        }
        return EnumC0324a.UNKNOWN;
    }

    public static int a(EnumC0324a enumC0324a) {
        int i2 = AnonymousClass1.f30478a[enumC0324a.ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? -1 : 1;
        }
        return 0;
    }
}
