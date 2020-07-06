package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object nXx;
    a.InterfaceC0909a nXy;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC0909a {
        private int id;
        org.aspectj.lang.c nXA;
        org.aspectj.lang.reflect.d nXB;
        String nXz;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.nXz = str;
            this.nXA = cVar;
            this.nXB = dVar;
            this.id = i;
        }

        public String dTp() {
            return this.nXz;
        }

        public org.aspectj.lang.c dTq() {
            return this.nXA;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.SB(dTp()));
            stringBuffer.append("(");
            stringBuffer.append(((f) dTq()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.nXT);
        }
    }

    public c(a.InterfaceC0909a interfaceC0909a, Object obj, Object obj2, Object[] objArr) {
        this.nXy = interfaceC0909a;
        this.nXx = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.nXy.toString();
    }
}
