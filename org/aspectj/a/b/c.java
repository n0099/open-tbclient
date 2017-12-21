package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hNa;
    Object hNb;
    a.InterfaceC0184a hNc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0184a {
        String hNd;
        org.aspectj.lang.c hNe;
        org.aspectj.lang.reflect.d hNf;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hNd = str;
            this.hNe = cVar;
            this.hNf = dVar;
        }

        public String bSL() {
            return this.hNd;
        }

        public org.aspectj.lang.c bSM() {
            return this.hNe;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.xb(bSL()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bSM()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.hNy);
        }
    }

    public c(a.InterfaceC0184a interfaceC0184a, Object obj, Object obj2, Object[] objArr) {
        this.hNc = interfaceC0184a;
        this.hNa = obj;
        this.hNb = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hNb;
    }

    public final String toString() {
        return this.hNc.toString();
    }
}
