package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object oZr;
    a.InterfaceC0997a oZs;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC0997a {
        private int id;
        String oZt;
        org.aspectj.lang.c oZu;
        org.aspectj.lang.reflect.d oZv;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.oZt = str;
            this.oZu = cVar;
            this.oZv = dVar;
            this.id = i;
        }

        public String eqI() {
            return this.oZt;
        }

        public org.aspectj.lang.c eqJ() {
            return this.oZu;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.XG(eqI()));
            stringBuffer.append("(");
            stringBuffer.append(((f) eqJ()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.oZM);
        }
    }

    public c(a.InterfaceC0997a interfaceC0997a, Object obj, Object obj2, Object[] objArr) {
        this.oZs = interfaceC0997a;
        this.oZr = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.oZs.toString();
    }
}
