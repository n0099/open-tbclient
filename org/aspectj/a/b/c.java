package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    a.InterfaceC0888a nAA;
    Object nAz;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC0888a {
        private int id;
        String nAB;
        org.aspectj.lang.c nAC;
        org.aspectj.lang.reflect.d nAD;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.nAB = str;
            this.nAC = cVar;
            this.nAD = dVar;
            this.id = i;
        }

        public String dOr() {
            return this.nAB;
        }

        public org.aspectj.lang.c dOs() {
            return this.nAC;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.RN(dOr()));
            stringBuffer.append("(");
            stringBuffer.append(((f) dOs()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.nAV);
        }
    }

    public c(a.InterfaceC0888a interfaceC0888a, Object obj, Object obj2, Object[] objArr) {
        this.nAA = interfaceC0888a;
        this.nAz = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.nAA.toString();
    }
}
