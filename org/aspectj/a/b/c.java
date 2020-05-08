package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object nfy;
    a.InterfaceC0826a nfz;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC0826a {
        private int id;
        String nfA;
        org.aspectj.lang.c nfB;
        org.aspectj.lang.reflect.d nfC;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.nfA = str;
            this.nfB = cVar;
            this.nfC = dVar;
            this.id = i;
        }

        public String dGw() {
            return this.nfA;
        }

        public org.aspectj.lang.c dGx() {
            return this.nfB;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.PH(dGw()));
            stringBuffer.append("(");
            stringBuffer.append(((f) dGx()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.nfU);
        }
    }

    public c(a.InterfaceC0826a interfaceC0826a, Object obj, Object obj2, Object[] objArr) {
        this.nfz = interfaceC0826a;
        this.nfy = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.nfz.toString();
    }
}
