package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object mZX;
    a.InterfaceC0719a mZY;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a implements a.InterfaceC0719a {
        private int id;
        String mZZ;
        org.aspectj.lang.c naa;
        org.aspectj.lang.reflect.d nab;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.mZZ = str;
            this.naa = cVar;
            this.nab = dVar;
            this.id = i;
        }

        public String dFh() {
            return this.mZZ;
        }

        public org.aspectj.lang.c dFi() {
            return this.naa;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Ri(dFh()));
            stringBuffer.append("(");
            stringBuffer.append(((f) dFi()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.nat);
        }
    }

    public c(a.InterfaceC0719a interfaceC0719a, Object obj, Object obj2, Object[] objArr) {
        this.mZY = interfaceC0719a;
        this.mZX = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.mZY.toString();
    }
}
