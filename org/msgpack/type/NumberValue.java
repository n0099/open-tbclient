package org.msgpack.type;

import java.math.BigInteger;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public abstract class NumberValue extends Number implements r {
    public abstract BigInteger bigIntegerValue();

    @Override // org.msgpack.type.r
    public boolean isNilValue() {
        return false;
    }

    @Override // org.msgpack.type.r
    public boolean isBooleanValue() {
        return false;
    }

    public boolean isIntegerValue() {
        return false;
    }

    public boolean isFloatValue() {
        return false;
    }

    @Override // org.msgpack.type.r
    public boolean isArrayValue() {
        return false;
    }

    @Override // org.msgpack.type.r
    public boolean isMapValue() {
        return false;
    }

    @Override // org.msgpack.type.r
    public boolean isRawValue() {
        return false;
    }

    public NilValue asNilValue() {
        throw new MessageTypeException();
    }

    @Override // org.msgpack.type.r
    public BooleanValue asBooleanValue() {
        throw new MessageTypeException();
    }

    public IntegerValue asIntegerValue() {
        throw new MessageTypeException();
    }

    public FloatValue asFloatValue() {
        throw new MessageTypeException();
    }

    @Override // org.msgpack.type.r
    public ArrayValue asArrayValue() {
        throw new MessageTypeException();
    }

    @Override // org.msgpack.type.r
    public MapValue asMapValue() {
        throw new MessageTypeException();
    }

    @Override // org.msgpack.type.r
    public RawValue asRawValue() {
        throw new MessageTypeException();
    }
}
