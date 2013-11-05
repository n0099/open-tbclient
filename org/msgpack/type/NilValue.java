package org.msgpack.type;
/* loaded from: classes.dex */
public class NilValue extends e {

    /* renamed from: a  reason: collision with root package name */
    private static NilValue f2906a = new NilValue();

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public /* bridge */ /* synthetic */ ArrayValue asArrayValue() {
        return super.asArrayValue();
    }

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public /* bridge */ /* synthetic */ BooleanValue asBooleanValue() {
        return super.asBooleanValue();
    }

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public /* bridge */ /* synthetic */ FloatValue asFloatValue() {
        return super.asFloatValue();
    }

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public /* bridge */ /* synthetic */ IntegerValue asIntegerValue() {
        return super.asIntegerValue();
    }

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public /* bridge */ /* synthetic */ MapValue asMapValue() {
        return super.asMapValue();
    }

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public /* bridge */ /* synthetic */ RawValue asRawValue() {
        return super.asRawValue();
    }

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public /* bridge */ /* synthetic */ boolean isArrayValue() {
        return super.isArrayValue();
    }

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public /* bridge */ /* synthetic */ boolean isBooleanValue() {
        return super.isBooleanValue();
    }

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public /* bridge */ /* synthetic */ boolean isFloatValue() {
        return super.isFloatValue();
    }

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public /* bridge */ /* synthetic */ boolean isIntegerValue() {
        return super.isIntegerValue();
    }

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public /* bridge */ /* synthetic */ boolean isMapValue() {
        return super.isMapValue();
    }

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public /* bridge */ /* synthetic */ boolean isRawValue() {
        return super.isRawValue();
    }

    private NilValue() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NilValue a() {
        return f2906a;
    }

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public boolean isNilValue() {
        return true;
    }

    public String toString() {
        return "null";
    }

    @Override // org.msgpack.type.r
    public StringBuilder toString(StringBuilder sb) {
        return sb.append("null");
    }

    @Override // org.msgpack.type.r
    public void writeTo(org.msgpack.packer.a aVar) {
        aVar.d();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        return ((r) obj).isNilValue();
    }

    public int hashCode() {
        return 0;
    }
}
