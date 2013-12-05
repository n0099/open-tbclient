package org.msgpack.type;
/* loaded from: classes.dex */
class i extends b {

    /* renamed from: a  reason: collision with root package name */
    private static i f3124a = new i();

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i b() {
        return f3124a;
    }

    @Override // org.msgpack.type.BooleanValue
    public boolean a() {
        return false;
    }

    @Override // org.msgpack.type.r
    public void writeTo(org.msgpack.packer.a aVar) {
        aVar.a(false);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            return rVar.isBooleanValue() && !rVar.asBooleanValue().a();
        }
        return false;
    }

    public int hashCode() {
        return 1237;
    }

    public String toString() {
        return "false";
    }

    @Override // org.msgpack.type.r
    public StringBuilder toString(StringBuilder sb) {
        return sb.append("false");
    }
}
