package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hnQ;
    Object hnR;
    a.InterfaceC0164a hnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0164a {
        String hnT;
        org.aspectj.lang.c hnU;
        org.aspectj.lang.reflect.d hnV;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hnT = str;
            this.hnU = cVar;
            this.hnV = dVar;
        }

        public String bLD() {
            return this.hnT;
        }

        public org.aspectj.lang.c bLE() {
            return this.hnU;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.vw(bLD()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bLE()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.hoo);
        }
    }

    public c(a.InterfaceC0164a interfaceC0164a, Object obj, Object obj2, Object[] objArr) {
        this.hnS = interfaceC0164a;
        this.hnQ = obj;
        this.hnR = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hnR;
    }

    public final String toString() {
        return this.hnS.toString();
    }
}
