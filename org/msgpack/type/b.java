package org.msgpack.type;
/* loaded from: classes.dex */
abstract class b extends e implements BooleanValue {
    @Override // org.msgpack.type.e, org.msgpack.type.r
    public boolean isBooleanValue() {
        return true;
    }

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public BooleanValue asBooleanValue() {
        return this;
    }
}
