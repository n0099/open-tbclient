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
        public static final /* synthetic */ int[] f30592a;

        static {
            int[] iArr = new int[EnumC0330a.values().length];
            f30592a = iArr;
            try {
                iArr[EnumC0330a.HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30592a[EnumC0330a.SAMSUNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public enum EnumC0330a {
        UNKNOWN,
        SAMSUNG,
        HUAWEI
    }

    public static int a() {
        return a(b());
    }

    public static EnumC0330a b() {
        String str = Build.BRAND;
        if (str.equalsIgnoreCase(ManufacturerUtils.SAMSUNG)) {
            return EnumC0330a.SAMSUNG;
        }
        if (str.equalsIgnoreCase("Huawei")) {
            return EnumC0330a.HUAWEI;
        }
        return EnumC0330a.UNKNOWN;
    }

    public static int a(EnumC0330a enumC0330a) {
        int i2 = AnonymousClass1.f30592a[enumC0330a.ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? -1 : 1;
        }
        return 0;
    }
}
