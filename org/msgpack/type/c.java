package org.msgpack.type;

import java.util.AbstractMap;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
abstract class c extends AbstractMap<r, r> implements MapValue {
    @Override // org.msgpack.type.r
    public boolean isMapValue() {
        return true;
    }

    @Override // org.msgpack.type.r
    public MapValue asMapValue() {
        return this;
    }

    @Override // org.msgpack.type.r
    public boolean isNilValue() {
        return false;
    }

    @Override // org.msgpack.type.r
    public boolean isBooleanValue() {
        return false;
    }

    @Override // org.msgpack.type.r
    public boolean isIntegerValue() {
        return false;
    }

    @Override // org.msgpack.type.r
    public boolean isFloatValue() {
        return false;
    }

    @Override // org.msgpack.type.r
    public boolean isArrayValue() {
        return false;
    }

    @Override // org.msgpack.type.r
    public boolean isRawValue() {
        return false;
    }

    @Override // org.msgpack.type.r
    public BooleanValue asBooleanValue() {
        throw new MessageTypeException();
    }

    @Override // org.msgpack.type.r
    public IntegerValue asIntegerValue() {
        throw new MessageTypeException();
    }

    @Override // org.msgpack.type.r
    public FloatValue asFloatValue() {
        throw new MessageTypeException();
    }

    @Override // org.msgpack.type.r
    public ArrayValue asArrayValue() {
        throw new MessageTypeException();
    }

    @Override // org.msgpack.type.r
    public RawValue asRawValue() {
        throw new MessageTypeException();
    }
}
