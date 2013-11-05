package org.msgpack.type;

import java.math.BigDecimal;
import java.math.BigInteger;
/* loaded from: classes.dex */
class FloatValueImpl extends FloatValue {
    private float value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatValueImpl(float f) {
        this.value = f;
    }

    @Override // org.msgpack.type.FloatValue
    public float getFloat() {
        return this.value;
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
        return this.value;
    }

    @Override // org.msgpack.type.NumberValue
    public BigInteger bigIntegerValue() {
        return new BigDecimal(this.value).toBigInteger();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            return rVar.isFloatValue() && ((double) this.value) == rVar.asFloatValue().getDouble();
        }
        return false;
    }

    @Override // org.msgpack.type.r
    public void writeTo(org.msgpack.packer.a aVar) {
        aVar.a(this.value);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    public String toString() {
        return Float.toString(this.value);
    }

    @Override // org.msgpack.type.r
    public StringBuilder toString(StringBuilder sb) {
        return sb.append(Float.toString(this.value));
    }
}
