package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public final class k extends h {
    private static final Class<?>[] kmI = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
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
        com.google.gson.internal.a.checkArgument((obj instanceof Number) || bd(obj));
        this.value = obj;
    }

    public boolean cLW() {
        return this.value instanceof Boolean;
    }

    @Override // com.google.gson.h
    Boolean cLV() {
        return (Boolean) this.value;
    }

    @Override // com.google.gson.h
    public boolean cLN() {
        return cLW() ? cLV().booleanValue() : Boolean.parseBoolean(cLM());
    }

    public boolean cLX() {
        return this.value instanceof Number;
    }

    @Override // com.google.gson.h
    public Number cLL() {
        return this.value instanceof String ? new LazilyParsedNumber((String) this.value) : (Number) this.value;
    }

    public boolean cLY() {
        return this.value instanceof String;
    }

    @Override // com.google.gson.h
    public String cLM() {
        if (cLX()) {
            return cLL().toString();
        }
        if (cLW()) {
            return cLV().toString();
        }
        return (String) this.value;
    }

    private static boolean bd(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : kmI) {
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
            long longValue = cLL().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (this.value instanceof Number) {
            long doubleToLongBits = Double.doubleToLongBits(cLL().doubleValue());
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
            return cLL().longValue() == kVar.cLL().longValue();
        } else if ((this.value instanceof Number) && (kVar.value instanceof Number)) {
            double doubleValue = cLL().doubleValue();
            double doubleValue2 = kVar.cLL().doubleValue();
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
