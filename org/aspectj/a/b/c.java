package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object izg;
    Object izh;
    a.InterfaceC0402a izi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0402a {
        String izj;
        org.aspectj.lang.c izk;
        org.aspectj.lang.reflect.d izl;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.izj = str;
            this.izk = cVar;
            this.izl = dVar;
        }

        public String cca() {
            return this.izj;
        }

        public org.aspectj.lang.c ccb() {
            return this.izk;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.zF(cca()));
            stringBuffer.append("(");
            stringBuffer.append(((f) ccb()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.izD);
        }
    }

    public c(a.InterfaceC0402a interfaceC0402a, Object obj, Object obj2, Object[] objArr) {
        this.izi = interfaceC0402a;
        this.izg = obj;
        this.izh = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.izh;
    }

    public final String toString() {
        return this.izi.toString();
    }
}
