package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;
/* loaded from: classes.dex */
public final class u extends r {

    /* renamed from: a  reason: collision with root package name */
    private static final Class[] f1681a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object b;

    public u(Boolean bool) {
        a(bool);
    }

    public u(Number number) {
        a(number);
    }

    public u(String str) {
        a(str);
    }

    void a(Object obj) {
        if (obj instanceof Character) {
            this.b = String.valueOf(((Character) obj).charValue());
            return;
        }
        com.google.gson.internal.a.a((obj instanceof Number) || b(obj));
        this.b = obj;
    }

    public boolean o() {
        return this.b instanceof Boolean;
    }

    @Override // com.google.gson.r
    Boolean n() {
        return (Boolean) this.b;
    }

    @Override // com.google.gson.r
    public boolean f() {
        return o() ? n().booleanValue() : Boolean.parseBoolean(b());
    }

    public boolean p() {
        return this.b instanceof Number;
    }

    @Override // com.google.gson.r
    public Number a() {
        return this.b instanceof String ? new LazilyParsedNumber((String) this.b) : (Number) this.b;
    }

    public boolean q() {
        return this.b instanceof String;
    }

    @Override // com.google.gson.r
    public String b() {
        if (p()) {
            return a().toString();
        }
        if (o()) {
            return n().toString();
        }
        return (String) this.b;
    }

    @Override // com.google.gson.r
    public double c() {
        return p() ? a().doubleValue() : Double.parseDouble(b());
    }

    @Override // com.google.gson.r
    public long d() {
        return p() ? a().longValue() : Long.parseLong(b());
    }

    @Override // com.google.gson.r
    public int e() {
        return p() ? a().intValue() : Integer.parseInt(b());
    }

    private static boolean b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class cls2 : f1681a) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.b == null) {
            return 31;
        }
        if (a(this)) {
            long longValue = a().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (this.b instanceof Number) {
            long doubleToLongBits = Double.doubleToLongBits(a().doubleValue());
            return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        } else {
            return this.b.hashCode();
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        if (this.b == null) {
            return uVar.b == null;
        } else if (a(this) && a(uVar)) {
            return a().longValue() == uVar.a().longValue();
        } else if ((this.b instanceof Number) && (uVar.b instanceof Number)) {
            double doubleValue = a().doubleValue();
            double doubleValue2 = uVar.a().doubleValue();
            if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                z = true;
            }
            return z;
        } else {
            return this.b.equals(uVar.b);
        }
    }

    private static boolean a(u uVar) {
        if (uVar.b instanceof Number) {
            Number number = (Number) uVar.b;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }
}
