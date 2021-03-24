package com.bytedance.sdk.openadsdk.preload.a.b;

import java.math.BigDecimal;
/* loaded from: classes6.dex */
public final class g extends Number {

    /* renamed from: a  reason: collision with root package name */
    public final String f30046a;

    public g(String str) {
        this.f30046a = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f30046a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            String str = this.f30046a;
            String str2 = ((g) obj).f30046a;
            return str == str2 || str.equals(str2);
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f30046a);
    }

    public int hashCode() {
        return this.f30046a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f30046a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f30046a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f30046a).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f30046a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f30046a).longValue();
        }
    }

    public String toString() {
        return this.f30046a;
    }
}
