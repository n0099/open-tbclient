package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object inU;
    Object inV;
    a.InterfaceC0206a inW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0206a {
        String inX;
        org.aspectj.lang.c inY;
        org.aspectj.lang.reflect.d inZ;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.inX = str;
            this.inY = cVar;
            this.inZ = dVar;
        }

        public String bRK() {
            return this.inX;
        }

        public org.aspectj.lang.c bRL() {
            return this.inY;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.wT(bRK()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bRL()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.ios);
        }
    }

    public c(a.InterfaceC0206a interfaceC0206a, Object obj, Object obj2, Object[] objArr) {
        this.inW = interfaceC0206a;
        this.inU = obj;
        this.inV = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.inV;
    }

    public final String toString() {
        return this.inW.toString();
    }
}
