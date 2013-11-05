package org.msgpack.type;

import java.math.BigDecimal;
import java.math.BigInteger;
/* loaded from: classes.dex */
class DoubleValueImpl extends FloatValue {
    private double value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DoubleValueImpl(double d) {
        this.value = d;
    }

    @Override // org.msgpack.type.FloatValue
    public float getFloat() {
        return (float) this.value;
    }

    @Override // org.msgpack.type.FloatValue
    public double getDouble() {
        return this.value;
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return (byte) this.value;
    }

    @Override // java.lang.Number
    public short shortValue() {
        return (short) this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) this.value;
    }

    @Override // org.msgpack.type.NumberValue
    public BigInteger bigIntegerValue() {
        return new BigDecimal(this.value).toBigInteger();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) this.value;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    @Override // org.msgpack.type.r
    public void writeTo(org.msgpack.packer.a aVar) {
        aVar.a(this.value);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            return rVar.isFloatValue() && this.value == rVar.asFloatValue().getDouble();
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.value);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public String toString() {
        return Double.toString(this.value);
    }

    @Override // org.msgpack.type.r
    public StringBuilder toString(StringBuilder sb) {
        return sb.append(Double.toString(this.value));
    }
}
