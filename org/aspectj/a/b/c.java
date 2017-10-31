package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hxI;
    Object hxJ;
    a.InterfaceC0166a hxK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0166a {
        String hxL;
        org.aspectj.lang.c hxM;
        org.aspectj.lang.reflect.d hxN;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hxL = str;
            this.hxM = cVar;
            this.hxN = dVar;
        }

        public String bOS() {
            return this.hxL;
        }

        public org.aspectj.lang.c bOT() {
            return this.hxM;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.wg(bOS()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bOT()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.hyg);
        }
    }

    public c(a.InterfaceC0166a interfaceC0166a, Object obj, Object obj2, Object[] objArr) {
        this.hxK = interfaceC0166a;
        this.hxI = obj;
        this.hxJ = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hxJ;
    }

    public final String toString() {
        return this.hxK.toString();
    }
}
