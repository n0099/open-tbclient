package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object ksH;
    a.InterfaceC0501a ksI;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0501a {
        String ksJ;
        org.aspectj.lang.c ksK;
        org.aspectj.lang.reflect.d ksL;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.ksJ = str;
            this.ksK = cVar;
            this.ksL = dVar;
        }

        public String cNZ() {
            return this.ksJ;
        }

        public org.aspectj.lang.c cOa() {
            return this.ksK;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.In(cNZ()));
            stringBuffer.append("(");
            stringBuffer.append(((f) cOa()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.ktd);
        }
    }

    public c(a.InterfaceC0501a interfaceC0501a, Object obj, Object obj2, Object[] objArr) {
        this.ksI = interfaceC0501a;
        this.ksH = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.ksI.toString();
    }
}
