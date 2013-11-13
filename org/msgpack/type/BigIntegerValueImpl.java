package org.msgpack.type;

import java.math.BigInteger;
import org.msgpack.MessageTypeException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class BigIntegerValueImpl extends IntegerValue {

    /* renamed from: a  reason: collision with root package name */
    private static BigInteger f2951a = BigInteger.valueOf(127);
    private static BigInteger b = BigInteger.valueOf(32767);
    private static BigInteger c = BigInteger.valueOf(2147483647L);
    private static BigInteger d = BigInteger.valueOf(Long.MAX_VALUE);
    private static BigInteger e = BigInteger.valueOf(-128);
    private static BigInteger f = BigInteger.valueOf(-32768);
    private static BigInteger g = BigInteger.valueOf(-2147483648L);
    private static BigInteger h = BigInteger.valueOf(Long.MIN_VALUE);
    private BigInteger value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigIntegerValueImpl(BigInteger bigInteger) {
        this.value = bigInteger;
    }

    @Override // org.msgpack.type.IntegerValue
    public byte getByte() {
        if (this.value.compareTo(f2951a) > 0 || this.value.compareTo(e) < 0) {
            throw new MessageTypeException();
        }
        return this.value.byteValue();
    }

    @Override // org.msgpack.type.IntegerValue
    public short getShort() {
        if (this.value.compareTo(b) > 0 || this.value.compareTo(f) < 0) {
            throw new MessageTypeException();
        }
        return this.value.shortValue();
    }

    @Override // org.msgpack.type.IntegerValue
    public int getInt() {
        if (this.value.compareTo(c) > 0 || this.value.compareTo(g) < 0) {
            throw new MessageTypeException();
        }
        return this.value.intValue();
    }

    @Override // org.msgpack.type.IntegerValue
    public long getLong() {
        if (this.value.compareTo(d) > 0 || this.value.compareTo(h) < 0) {
            throw new MessageTypeException();
        }
        return this.value.longValue();
    }

    @Override // org.msgpack.type.IntegerValue
    public BigInteger getBigInteger() {
        return this.value;
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return this.value.byteValue();
    }

    @Override // java.lang.Number
    public short shortValue() {
        return this.value.shortValue();
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value.intValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value.longValue();
    }

    @Override // org.msgpack.type.NumberValue
    public BigInteger bigIntegerValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value.floatValue();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value.doubleValue();
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
                return this.value.equals(rVar.asIntegerValue().bigIntegerValue());
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        if (g.compareTo(this.value) <= 0 && this.value.compareTo(c) <= 0) {
            return (int) this.value.longValue();
        }
        if (h.compareTo(this.value) <= 0 && this.value.compareTo(d) <= 0) {
            long longValue = this.value.longValue();
            return (int) (longValue ^ (longValue >>> 32));
        }
        return this.value.hashCode();
    }

    public String toString() {
        return this.value.toString();
    }

    @Override // org.msgpack.type.r
    public StringBuilder toString(StringBuilder sb) {
        return sb.append(this.value.toString());
    }
}
