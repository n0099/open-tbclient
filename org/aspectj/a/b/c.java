package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object nXu;
    a.InterfaceC0908a nXv;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC0908a {
        private int id;
        String nXw;
        org.aspectj.lang.c nXx;
        org.aspectj.lang.reflect.d nXy;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.nXw = str;
            this.nXx = cVar;
            this.nXy = dVar;
            this.id = i;
        }

        public String dTl() {
            return this.nXw;
        }

        public org.aspectj.lang.c dTm() {
            return this.nXx;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.SA(dTl()));
            stringBuffer.append("(");
            stringBuffer.append(((f) dTm()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.nXQ);
        }
    }

    public c(a.InterfaceC0908a interfaceC0908a, Object obj, Object obj2, Object[] objArr) {
        this.nXv = interfaceC0908a;
        this.nXu = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.nXv.toString();
    }
}
