package org.msgpack.type;

import com.tencent.mm.sdk.contact.RContact;
import java.math.BigInteger;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
class IntValueImpl extends IntegerValue {

    /* renamed from: a  reason: collision with root package name */
    private static int f2952a = RContact.MM_CONTACTFLAG_ALL;
    private static int b = 32767;
    private static int c = -128;
    private static int d = -32768;
    private int value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntValueImpl(int i) {
        this.value = i;
    }

    @Override // org.msgpack.type.IntegerValue
    public byte getByte() {
        if (this.value > f2952a || this.value < c) {
            throw new MessageTypeException();
        }
        return (byte) this.value;
    }

    @Override // org.msgpack.type.IntegerValue
    public short getShort() {
        if (this.value > b || this.value < d) {
            throw new MessageTypeException();
        }
        return (short) this.value;
    }

    @Override // org.msgpack.type.IntegerValue
    public int getInt() {
        return this.value;
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
        return this.value;
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
        return this.value;
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
                    return this.value == rVar.asIntegerValue().getInt();
                } catch (MessageTypeException e) {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return this.value;
    }

    public String toString() {
        return Integer.toString(this.value);
    }

    @Override // org.msgpack.type.r
    public StringBuilder toString(StringBuilder sb) {
        return sb.append(Integer.toString(this.value));
    }
}
