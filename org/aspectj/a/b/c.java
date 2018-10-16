package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object iql;
    Object iqm;
    a.InterfaceC0360a iqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0360a {
        String iqo;
        org.aspectj.lang.c iqp;
        org.aspectj.lang.reflect.d iqq;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.iqo = str;
            this.iqp = cVar;
            this.iqq = dVar;
        }

        public String cay() {
            return this.iqo;
        }

        public org.aspectj.lang.c caz() {
            return this.iqp;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.yX(cay()));
            stringBuffer.append("(");
            stringBuffer.append(((f) caz()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.iqI);
        }
    }

    public c(a.InterfaceC0360a interfaceC0360a, Object obj, Object obj2, Object[] objArr) {
        this.iqn = interfaceC0360a;
        this.iql = obj;
        this.iqm = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.iqm;
    }

    public final String toString() {
        return this.iqn.toString();
    }
}
