package org.msgpack.type;

import java.math.BigInteger;
/* loaded from: classes.dex */
public abstract class IntegerValue extends NumberValue {
    public abstract byte getByte();

    public abstract int getInt();

    public abstract long getLong();

    public abstract short getShort();

    public ValueType getType() {
        return ValueType.INTEGER;
    }

    @Override // org.msgpack.type.NumberValue, org.msgpack.type.r
    public boolean isIntegerValue() {
        return true;
    }

    @Override // org.msgpack.type.NumberValue, org.msgpack.type.r
    public IntegerValue asIntegerValue() {
        return this;
    }

    public BigInteger getBigInteger() {
        return bigIntegerValue();
    }
}
