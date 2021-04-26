package com.bytedance.sdk.openadsdk.preload.a.b;

import java.math.BigDecimal;
/* loaded from: classes5.dex */
public final class g extends Number {

    /* renamed from: a  reason: collision with root package name */
    public final String f30647a;

    public g(String str) {
        this.f30647a = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f30647a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            String str = this.f30647a;
            String str2 = ((g) obj).f30647a;
            return str == str2 || str.equals(str2);
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f30647a);
    }

    public int hashCode() {
        return this.f30647a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f30647a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f30647a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f30647a).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f30647a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f30647a).longValue();
        }
    }

    public String toString() {
        return this.f30647a;
    }
}
