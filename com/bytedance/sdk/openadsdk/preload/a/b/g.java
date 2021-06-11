package com.bytedance.sdk.openadsdk.preload.a.b;

import java.math.BigDecimal;
/* loaded from: classes6.dex */
public final class g extends Number {

    /* renamed from: a  reason: collision with root package name */
    public final String f29924a;

    public g(String str) {
        this.f29924a = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f29924a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            String str = this.f29924a;
            String str2 = ((g) obj).f29924a;
            return str == str2 || str.equals(str2);
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f29924a);
    }

    public int hashCode() {
        return this.f29924a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f29924a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f29924a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f29924a).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f29924a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f29924a).longValue();
        }
    }

    public String toString() {
        return this.f29924a;
    }
}
