package com.bytedance.sdk.openadsdk.preload.a;

import java.math.BigInteger;
/* loaded from: classes6.dex */
public final class q extends l {

    /* renamed from: a  reason: collision with root package name */
    public final Object f30022a;

    public q(Boolean bool) {
        this.f30022a = com.bytedance.sdk.openadsdk.preload.a.b.a.a(bool);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public Number a() {
        Object obj = this.f30022a;
        return obj instanceof String ? new com.bytedance.sdk.openadsdk.preload.a.b.g((String) this.f30022a) : (Number) obj;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public String b() {
        if (o()) {
            return a().toString();
        }
        if (n()) {
            return ((Boolean) this.f30022a).toString();
        }
        return (String) this.f30022a;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public double c() {
        return o() ? a().doubleValue() : Double.parseDouble(b());
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public long d() {
        return o() ? a().longValue() : Long.parseLong(b());
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public int e() {
        return o() ? a().intValue() : Integer.parseInt(b());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f30022a == null) {
            return qVar.f30022a == null;
        } else if (a(this) && a(qVar)) {
            return a().longValue() == qVar.a().longValue();
        } else if ((this.f30022a instanceof Number) && (qVar.f30022a instanceof Number)) {
            double doubleValue = a().doubleValue();
            double doubleValue2 = qVar.a().doubleValue();
            if (doubleValue != doubleValue2) {
                return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
            }
            return true;
        } else {
            return this.f30022a.equals(qVar.f30022a);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public boolean f() {
        if (n()) {
            return ((Boolean) this.f30022a).booleanValue();
        }
        return Boolean.parseBoolean(b());
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f30022a == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = a().longValue();
        } else {
            Object obj = this.f30022a;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(a().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean n() {
        return this.f30022a instanceof Boolean;
    }

    public boolean o() {
        return this.f30022a instanceof Number;
    }

    public boolean p() {
        return this.f30022a instanceof String;
    }

    public static boolean a(q qVar) {
        Object obj = qVar.f30022a;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }

    public q(Number number) {
        this.f30022a = com.bytedance.sdk.openadsdk.preload.a.b.a.a(number);
    }

    public q(String str) {
        this.f30022a = com.bytedance.sdk.openadsdk.preload.a.b.a.a(str);
    }
}
