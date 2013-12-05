package org.msgpack.type;

import java.math.BigInteger;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
class LongValueImpl extends IntegerValue {

    /* renamed from: a  reason: collision with root package name */
    private static long f3118a = 127;
    private static long b = 32767;
    private static long c = 2147483647L;
    private static long d = -128;
    private static long e = -32768;
    private static long f = -2147483648L;
    private long value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LongValueImpl(long j) {
        this.value = j;
    }

    @Override // org.msgpack.type.IntegerValue
    public byte getByte() {
        if (this.value > f3118a || this.value < d) {
            throw new MessageTypeException();
        }
        return (byte) this.value;
    }

    @Override // org.msgpack.type.IntegerValue
    public short getShort() {
        if (this.value > b || this.value < e) {
            throw new MessageTypeException();
        }
        return (short) this.value;
    }

    @Override // org.msgpack.type.IntegerValue
    public int getInt() {
        if (this.value > c || this.value < f) {
            throw new MessageTypeException();
        }
        return (int) this.value;
    }

    @Override // org.msgpack.type.IntegerValue
    public long getLong() {
        return this.value;
    }

    @Override // org.msgpack.type.IntegerValue
    public BigInteger getBigInteger() {
        return BigInteger.valueOf(this.value);
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
        return BigInteger.valueOf(this.value);
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
            if (rVar.isIntegerValue()) {
                try {
                    return this.value == rVar.asIntegerValue().getLong();
                } catch (MessageTypeException e2) {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (f > this.value || this.value > c) ? (int) (this.value ^ (this.value >>> 32)) : (int) this.value;
    }

    public String toString() {
        return Long.toString(this.value);
    }

    @Override // org.msgpack.type.r
    public StringBuilder toString(StringBuilder sb) {
        return sb.append(Long.toString(this.value));
    }
}
