package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public final class k extends h {
    private static final Class<?>[] knG = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object value;

    public k(Boolean bool) {
        setValue(bool);
    }

    public k(Number number) {
        setValue(number);
    }

    public k(String str) {
        setValue(str);
    }

    void setValue(Object obj) {
        if (obj instanceof Character) {
            this.value = String.valueOf(((Character) obj).charValue());
            return;
        }
        com.google.gson.internal.a.checkArgument((obj instanceof Number) || aY(obj));
        this.value = obj;
    }

    public boolean cKa() {
        return this.value instanceof Boolean;
    }

    @Override // com.google.gson.h
    Boolean cJZ() {
        return (Boolean) this.value;
    }

    @Override // com.google.gson.h
    public boolean cJR() {
        return cKa() ? cJZ().booleanValue() : Boolean.parseBoolean(cJQ());
    }

    public boolean cKb() {
        return this.value instanceof Number;
    }

    @Override // com.google.gson.h
    public Number cJP() {
        return this.value instanceof String ? new LazilyParsedNumber((String) this.value) : (Number) this.value;
    }

    public boolean cKc() {
        return this.value instanceof String;
    }

    @Override // com.google.gson.h
    public String cJQ() {
        if (cKb()) {
            return cJP().toString();
        }
        if (cKa()) {
            return cJZ().toString();
        }
        return (String) this.value;
    }

    private static boolean aY(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : knG) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.value == null) {
            return 31;
        }
        if (a(this)) {
            long longValue = cJP().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (this.value instanceof Number) {
            long doubleToLongBits = Double.doubleToLongBits(cJP().doubleValue());
            return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        } else {
            return this.value.hashCode();
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
        k kVar = (k) obj;
        if (this.value == null) {
            return kVar.value == null;
        } else if (a(this) && a(kVar)) {
            return cJP().longValue() == kVar.cJP().longValue();
        } else if ((this.value instanceof Number) && (kVar.value instanceof Number)) {
            double doubleValue = cJP().doubleValue();
            double doubleValue2 = kVar.cJP().doubleValue();
            if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                z = true;
            }
            return z;
        } else {
            return this.value.equals(kVar.value);
        }
    }

    private static boolean a(k kVar) {
        if (kVar.value instanceof Number) {
            Number number = (Number) kVar.value;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }
}
