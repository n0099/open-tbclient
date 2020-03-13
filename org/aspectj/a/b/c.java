package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object nKe;
    a.InterfaceC0781a nKf;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC0781a {
        private int id;
        String nKg;
        org.aspectj.lang.c nKh;
        org.aspectj.lang.reflect.d nKi;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.nKg = str;
            this.nKh = cVar;
            this.nKi = dVar;
            this.id = i;
        }

        public String dNa() {
            return this.nKg;
        }

        public org.aspectj.lang.c dNb() {
            return this.nKh;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Sp(dNa()));
            stringBuffer.append("(");
            stringBuffer.append(((f) dNb()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.nKA);
        }
    }

    public c(a.InterfaceC0781a interfaceC0781a, Object obj, Object obj2, Object[] objArr) {
        this.nKf = interfaceC0781a;
        this.nKe = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.nKf.toString();
    }
}
