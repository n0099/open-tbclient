package org.msgpack.template.builder.beans;
/* loaded from: classes.dex */
public class Expression extends g {

    /* renamed from: a  reason: collision with root package name */
    boolean f3109a;
    Object b;

    @Override // org.msgpack.template.builder.beans.g
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f3109a) {
            sb.append("<unbound>");
        } else if (this.b == null) {
            sb.append("null");
        } else {
            Class<?> cls = this.b.getClass();
            sb.append(cls == String.class ? "\"\"" : org.a.a.a.a.a(cls));
        }
        sb.append('=');
        sb.append(super.toString());
        return sb.toString();
    }
}
