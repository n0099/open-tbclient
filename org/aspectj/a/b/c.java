package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object iqm;
    Object iqn;
    a.InterfaceC0360a iqo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0360a {
        String iqp;
        org.aspectj.lang.c iqq;
        org.aspectj.lang.reflect.d iqr;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.iqp = str;
            this.iqq = cVar;
            this.iqr = dVar;
        }

        public String cay() {
            return this.iqp;
        }

        public org.aspectj.lang.c caz() {
            return this.iqq;
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
            return a(h.iqJ);
        }
    }

    public c(a.InterfaceC0360a interfaceC0360a, Object obj, Object obj2, Object[] objArr) {
        this.iqo = interfaceC0360a;
        this.iqm = obj;
        this.iqn = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.iqn;
    }

    public final String toString() {
        return this.iqo.toString();
    }
}
