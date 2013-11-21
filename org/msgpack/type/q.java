package org.msgpack.type;
/* loaded from: classes.dex */
class q extends b {

    /* renamed from: a  reason: collision with root package name */
    private static q f2951a = new q();

    private q() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q b() {
        return f2951a;
    }

    @Override // org.msgpack.type.BooleanValue
    public boolean a() {
        return true;
    }

    @Override // org.msgpack.type.r
    public void writeTo(org.msgpack.packer.a aVar) {
        aVar.a(true);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (rVar.isBooleanValue()) {
                return rVar.asBooleanValue().a();
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return 1231;
    }

    public String toString() {
        return "true";
    }

    @Override // org.msgpack.type.r
    public StringBuilder toString(StringBuilder sb) {
        return sb.append("true");
    }
}
