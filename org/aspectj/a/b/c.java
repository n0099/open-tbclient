package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object imB;
    Object imC;
    a.InterfaceC0296a imD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0296a {
        String imE;
        org.aspectj.lang.c imF;
        org.aspectj.lang.reflect.d imG;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.imE = str;
            this.imF = cVar;
            this.imG = dVar;
        }

        public String bSa() {
            return this.imE;
        }

        public org.aspectj.lang.c bSb() {
            return this.imF;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.wZ(bSa()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bSb()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.imZ);
        }
    }

    public c(a.InterfaceC0296a interfaceC0296a, Object obj, Object obj2, Object[] objArr) {
        this.imD = interfaceC0296a;
        this.imB = obj;
        this.imC = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.imC;
    }

    public final String toString() {
        return this.imD.toString();
    }
}
