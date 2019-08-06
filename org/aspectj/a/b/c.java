package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object ktN;
    a.InterfaceC0501a ktO;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0501a {
        String ktP;
        org.aspectj.lang.c ktQ;
        org.aspectj.lang.reflect.d ktR;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.ktP = str;
            this.ktQ = cVar;
            this.ktR = dVar;
        }

        public String cOu() {
            return this.ktP;
        }

        public org.aspectj.lang.c cOv() {
            return this.ktQ;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Io(cOu()));
            stringBuffer.append("(");
            stringBuffer.append(((f) cOv()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.kuj);
        }
    }

    public c(a.InterfaceC0501a interfaceC0501a, Object obj, Object obj2, Object[] objArr) {
        this.ktO = interfaceC0501a;
        this.ktN = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.ktO.toString();
    }
}
