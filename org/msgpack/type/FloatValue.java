package org.msgpack.type;
/* loaded from: classes.dex */
public abstract class FloatValue extends NumberValue {
    public abstract double getDouble();

    public abstract float getFloat();

    public ValueType getType() {
        return ValueType.FLOAT;
    }

    @Override // org.msgpack.type.NumberValue, org.msgpack.type.r
    public boolean isFloatValue() {
        return true;
    }

    @Override // org.msgpack.type.NumberValue, org.msgpack.type.r
    public FloatValue asFloatValue() {
        return this;
    }
}
