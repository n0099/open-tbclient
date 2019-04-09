package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object jSN;
    Object jSO;
    a.InterfaceC0474a jSP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0474a {
        String jSQ;
        org.aspectj.lang.c jSR;
        org.aspectj.lang.reflect.d jSS;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.jSQ = str;
            this.jSR = cVar;
            this.jSS = dVar;
        }

        public String cCG() {
            return this.jSQ;
        }

        public org.aspectj.lang.c cCH() {
            return this.jSR;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.FR(cCG()));
            stringBuffer.append("(");
            stringBuffer.append(((f) cCH()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.jTk);
        }
    }

    public c(a.InterfaceC0474a interfaceC0474a, Object obj, Object obj2, Object[] objArr) {
        this.jSP = interfaceC0474a;
        this.jSN = obj;
        this.jSO = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.jSO;
    }

    public final String toString() {
        return this.jSP.toString();
    }
}
