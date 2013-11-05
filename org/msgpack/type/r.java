package org.msgpack.type;
/* loaded from: classes.dex */
public interface r {
    ArrayValue asArrayValue();

    BooleanValue asBooleanValue();

    FloatValue asFloatValue();

    IntegerValue asIntegerValue();

    MapValue asMapValue();

    RawValue asRawValue();

    boolean isArrayValue();

    boolean isBooleanValue();

    boolean isFloatValue();

    boolean isIntegerValue();

    boolean isMapValue();

    boolean isNilValue();

    boolean isRawValue();

    StringBuilder toString(StringBuilder sb);

    void writeTo(org.msgpack.packer.a aVar);
}
