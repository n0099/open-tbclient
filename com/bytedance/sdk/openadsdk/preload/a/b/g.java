package com.bytedance.sdk.openadsdk.preload.a.b;

import java.math.BigDecimal;
/* loaded from: classes5.dex */
public final class g extends Number {

    /* renamed from: a  reason: collision with root package name */
    public final String f29732a;

    public g(String str) {
        this.f29732a = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f29732a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            String str = this.f29732a;
            String str2 = ((g) obj).f29732a;
            return str == str2 || str.equals(str2);
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f29732a);
    }

    public int hashCode() {
        return this.f29732a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f29732a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f29732a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f29732a).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f29732a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f29732a).longValue();
        }
    }

    public String toString() {
        return this.f29732a;
    }
}
