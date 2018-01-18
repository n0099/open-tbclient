package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object inA;
    Object inB;
    a.InterfaceC0205a inC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0205a {
        String inD;
        org.aspectj.lang.c inE;
        org.aspectj.lang.reflect.d inF;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.inD = str;
            this.inE = cVar;
            this.inF = dVar;
        }

        public String bRI() {
            return this.inD;
        }

        public org.aspectj.lang.c bRJ() {
            return this.inE;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.wM(bRI()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bRJ()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.inY);
        }
    }

    public c(a.InterfaceC0205a interfaceC0205a, Object obj, Object obj2, Object[] objArr) {
        this.inC = interfaceC0205a;
        this.inA = obj;
        this.inB = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.inB;
    }

    public final String toString() {
        return this.inC.toString();
    }
}
