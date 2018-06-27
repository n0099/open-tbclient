package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public final class k extends h {
    private static final Class<?>[] hMO = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
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
        com.google.gson.internal.a.checkArgument((obj instanceof Number) || ai(obj));
        this.value = obj;
    }

    public boolean bOm() {
        return this.value instanceof Boolean;
    }

    @Override // com.google.gson.h
    Boolean bOl() {
        return (Boolean) this.value;
    }

    @Override // com.google.gson.h
    public boolean getAsBoolean() {
        return bOm() ? bOl().booleanValue() : Boolean.parseBoolean(bOd());
    }

    public boolean bOn() {
        return this.value instanceof Number;
    }

    @Override // com.google.gson.h
    public Number bOc() {
        return this.value instanceof String ? new LazilyParsedNumber((String) this.value) : (Number) this.value;
    }

    public boolean bOo() {
        return this.value instanceof String;
    }

    @Override // com.google.gson.h
    public String bOd() {
        if (bOn()) {
            return bOc().toString();
        }
        if (bOm()) {
            return bOl().toString();
        }
        return (String) this.value;
    }

    private static boolean ai(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : hMO) {
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
            long longValue = bOc().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (this.value instanceof Number) {
            long doubleToLongBits = Double.doubleToLongBits(bOc().doubleValue());
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
            return bOc().longValue() == kVar.bOc().longValue();
        } else if ((this.value instanceof Number) && (kVar.value instanceof Number)) {
            double doubleValue = bOc().doubleValue();
            double doubleValue2 = kVar.bOc().doubleValue();
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
