package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public final class l extends i {
    private static final Class<?>[] itf = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
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
        com.google.gson.internal.a.checkArgument((obj instanceof Number) || aP(obj));
        this.value = obj;
    }

    public boolean cam() {
        return this.value instanceof Boolean;
    }

    @Override // com.google.gson.i
    Boolean cal() {
        return (Boolean) this.value;
    }

    @Override // com.google.gson.i
    public boolean getAsBoolean() {
        return cam() ? cal().booleanValue() : Boolean.parseBoolean(cad());
    }

    public boolean can() {
        return this.value instanceof Number;
    }

    @Override // com.google.gson.i
    public Number cac() {
        return this.value instanceof String ? new LazilyParsedNumber((String) this.value) : (Number) this.value;
    }

    public boolean cao() {
        return this.value instanceof String;
    }

    @Override // com.google.gson.i
    public String cad() {
        if (can()) {
            return cac().toString();
        }
        if (cam()) {
            return cal().toString();
        }
        return (String) this.value;
    }

    @Override // com.google.gson.i
    public double getAsDouble() {
        return can() ? cac().doubleValue() : Double.parseDouble(cad());
    }

    @Override // com.google.gson.i
    public long getAsLong() {
        return can() ? cac().longValue() : Long.parseLong(cad());
    }

    @Override // com.google.gson.i
    public int getAsInt() {
        return can() ? cac().intValue() : Integer.parseInt(cad());
    }

    private static boolean aP(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : itf) {
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
            long longValue = cac().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (this.value instanceof Number) {
            long doubleToLongBits = Double.doubleToLongBits(cac().doubleValue());
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
            return cac().longValue() == lVar.cac().longValue();
        } else if ((this.value instanceof Number) && (lVar.value instanceof Number)) {
            double doubleValue = cac().doubleValue();
            double doubleValue2 = lVar.cac().doubleValue();
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
