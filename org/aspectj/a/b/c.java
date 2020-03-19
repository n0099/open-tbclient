package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object nLR;
    a.InterfaceC0782a nLS;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC0782a {
        private int id;
        String nLT;
        org.aspectj.lang.c nLU;
        org.aspectj.lang.reflect.d nLV;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.nLT = str;
            this.nLU = cVar;
            this.nLV = dVar;
            this.id = i;
        }

        public String dNA() {
            return this.nLT;
        }

        public org.aspectj.lang.c dNB() {
            return this.nLU;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Sp(dNA()));
            stringBuffer.append("(");
            stringBuffer.append(((f) dNB()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.nMn);
        }
    }

    public c(a.InterfaceC0782a interfaceC0782a, Object obj, Object obj2, Object[] objArr) {
        this.nLS = interfaceC0782a;
        this.nLR = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.nLS.toString();
    }
}
