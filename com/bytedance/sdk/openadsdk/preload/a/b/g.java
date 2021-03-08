package com.bytedance.sdk.openadsdk.preload.a.b;

import java.math.BigDecimal;
/* loaded from: classes6.dex */
public final class g extends Number {

    /* renamed from: a  reason: collision with root package name */
    private final String f5009a;

    public g(String str) {
        this.f5009a = str;
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            return Integer.parseInt(this.f5009a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f5009a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.f5009a).intValue();
            }
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f5009a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.f5009a).longValue();
        }
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f5009a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f5009a);
    }

    public String toString() {
        return this.f5009a;
    }

    public int hashCode() {
        return this.f5009a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f5009a == gVar.f5009a || this.f5009a.equals(gVar.f5009a);
        }
        return false;
    }
}
