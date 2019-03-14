package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public final class l extends i {
    private static final Class<?>[] jNt = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object value;

    public l(Boolean bool) {
        setValue(bool);
    }

    public l(Number number) {
        setValue(number);
    }

    public l(String str) {
        setValue(str);
    }

    void setValue(Object obj) {
        if (obj instanceof Character) {
            this.value = String.valueOf(((Character) obj).charValue());
            return;
        }
        com.google.gson.internal.a.checkArgument((obj instanceof Number) || bf(obj));
        this.value = obj;
    }

    public boolean cBc() {
        return this.value instanceof Boolean;
    }

    @Override // com.google.gson.i
    Boolean cBb() {
        return (Boolean) this.value;
    }

    @Override // com.google.gson.i
    public boolean getAsBoolean() {
        return cBc() ? cBb().booleanValue() : Boolean.parseBoolean(cAT());
    }

    public boolean cBd() {
        return this.value instanceof Number;
    }

    @Override // com.google.gson.i
    public Number cAS() {
        return this.value instanceof String ? new LazilyParsedNumber((String) this.value) : (Number) this.value;
    }

    public boolean cBe() {
        return this.value instanceof String;
    }

    @Override // com.google.gson.i
    public String cAT() {
        if (cBd()) {
            return cAS().toString();
        }
        if (cBc()) {
            return cBb().toString();
        }
        return (String) this.value;
    }

    @Override // com.google.gson.i
    public double getAsDouble() {
        return cBd() ? cAS().doubleValue() : Double.parseDouble(cAT());
    }

    @Override // com.google.gson.i
    public long getAsLong() {
        return cBd() ? cAS().longValue() : Long.parseLong(cAT());
    }

    @Override // com.google.gson.i
    public int getAsInt() {
        return cBd() ? cAS().intValue() : Integer.parseInt(cAT());
    }

    private static boolean bf(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : jNt) {
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
            long longValue = cAS().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (this.value instanceof Number) {
            long doubleToLongBits = Double.doubleToLongBits(cAS().doubleValue());
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
        l lVar = (l) obj;
        if (this.value == null) {
            return lVar.value == null;
        } else if (a(this) && a(lVar)) {
            return cAS().longValue() == lVar.cAS().longValue();
        } else if ((this.value instanceof Number) && (lVar.value instanceof Number)) {
            double doubleValue = cAS().doubleValue();
            double doubleValue2 = lVar.cAS().doubleValue();
            if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                z = true;
            }
            return z;
        } else {
            return this.value.equals(lVar.value);
        }
    }

    private static boolean a(l lVar) {
        if (lVar.value instanceof Number) {
            Number number = (Number) lVar.value;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }
}
