package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object jSM;
    Object jSN;
    a.InterfaceC0474a jSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0474a {
        String jSP;
        org.aspectj.lang.c jSQ;
        org.aspectj.lang.reflect.d jSR;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.jSP = str;
            this.jSQ = cVar;
            this.jSR = dVar;
        }

        public String cCG() {
            return this.jSP;
        }

        public org.aspectj.lang.c cCH() {
            return this.jSQ;
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
            return a(h.jTj);
        }
    }

    public c(a.InterfaceC0474a interfaceC0474a, Object obj, Object obj2, Object[] objArr) {
        this.jSO = interfaceC0474a;
        this.jSM = obj;
        this.jSN = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.jSN;
    }

    public final String toString() {
        return this.jSO.toString();
    }
}
