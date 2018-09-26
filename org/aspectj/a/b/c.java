package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hRM;
    Object hRN;
    a.InterfaceC0304a hRO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0304a {
        String hRP;
        org.aspectj.lang.c hRQ;
        org.aspectj.lang.reflect.d hRR;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hRP = str;
            this.hRQ = cVar;
            this.hRR = dVar;
        }

        public String bNE() {
            return this.hRP;
        }

        public org.aspectj.lang.c bNF() {
            return this.hRQ;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.xv(bNE()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bNF()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.hSk);
        }
    }

    public c(a.InterfaceC0304a interfaceC0304a, Object obj, Object obj2, Object[] objArr) {
        this.hRO = interfaceC0304a;
        this.hRM = obj;
        this.hRN = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hRN;
    }

    public final String toString() {
        return this.hRO.toString();
    }
}
