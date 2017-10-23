package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hnA;
    a.InterfaceC0164a hnB;
    Object hnz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0164a {
        String hnC;
        org.aspectj.lang.c hnD;
        org.aspectj.lang.reflect.d hnE;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hnC = str;
            this.hnD = cVar;
            this.hnE = dVar;
        }

        public String bLu() {
            return this.hnC;
        }

        public org.aspectj.lang.c bLv() {
            return this.hnD;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.vv(bLu()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bLv()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.hnX);
        }
    }

    public c(a.InterfaceC0164a interfaceC0164a, Object obj, Object obj2, Object[] objArr) {
        this.hnB = interfaceC0164a;
        this.hnz = obj;
        this.hnA = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hnA;
    }

    public final String toString() {
        return this.hnB.toString();
    }
}
