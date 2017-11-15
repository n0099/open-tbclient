package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hyS;
    Object hyT;
    a.InterfaceC0169a hyU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0169a {
        String hyV;
        org.aspectj.lang.c hyW;
        org.aspectj.lang.reflect.d hyX;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hyV = str;
            this.hyW = cVar;
            this.hyX = dVar;
        }

        public String bPf() {
            return this.hyV;
        }

        public org.aspectj.lang.c bPg() {
            return this.hyW;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.wn(bPf()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bPg()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.hzq);
        }
    }

    public c(a.InterfaceC0169a interfaceC0169a, Object obj, Object obj2, Object[] objArr) {
        this.hyU = interfaceC0169a;
        this.hyS = obj;
        this.hyT = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hyT;
    }

    public final String toString() {
        return this.hyU.toString();
    }
}
