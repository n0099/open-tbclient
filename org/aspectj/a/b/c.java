package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hMV;
    Object hMW;
    a.InterfaceC0185a hMX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0185a {
        String hMY;
        org.aspectj.lang.c hMZ;
        org.aspectj.lang.reflect.d hNa;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hMY = str;
            this.hMZ = cVar;
            this.hNa = dVar;
        }

        public String bSL() {
            return this.hMY;
        }

        public org.aspectj.lang.c bSM() {
            return this.hMZ;
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
            return a(h.hNt);
        }
    }

    public c(a.InterfaceC0185a interfaceC0185a, Object obj, Object obj2, Object[] objArr) {
        this.hMX = interfaceC0185a;
        this.hMV = obj;
        this.hMW = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hMW;
    }

    public final String toString() {
        return this.hMX.toString();
    }
}
