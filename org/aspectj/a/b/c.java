package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hnP;
    Object hnQ;
    a.InterfaceC0164a hnR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0164a {
        String hnS;
        org.aspectj.lang.c hnT;
        org.aspectj.lang.reflect.d hnU;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hnS = str;
            this.hnT = cVar;
            this.hnU = dVar;
        }

        public String bLC() {
            return this.hnS;
        }

        public org.aspectj.lang.c bLD() {
            return this.hnT;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.vw(bLC()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bLD()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.hon);
        }
    }

    public c(a.InterfaceC0164a interfaceC0164a, Object obj, Object obj2, Object[] objArr) {
        this.hnR = interfaceC0164a;
        this.hnP = obj;
        this.hnQ = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hnQ;
    }

    public final String toString() {
        return this.hnR.toString();
    }
}
