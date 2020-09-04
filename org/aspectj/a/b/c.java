package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object oAy;
    a.InterfaceC0982a oAz;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class a implements a.InterfaceC0982a {
        private int id;
        String oAA;
        org.aspectj.lang.c oAB;
        org.aspectj.lang.reflect.d oAC;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.oAA = str;
            this.oAB = cVar;
            this.oAC = dVar;
            this.id = i;
        }

        public String eiY() {
            return this.oAA;
        }

        public org.aspectj.lang.c eiZ() {
            return this.oAB;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Wq(eiY()));
            stringBuffer.append("(");
            stringBuffer.append(((f) eiZ()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.oAT);
        }
    }

    public c(a.InterfaceC0982a interfaceC0982a, Object obj, Object obj2, Object[] objArr) {
        this.oAz = interfaceC0982a;
        this.oAy = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.oAz.toString();
    }
}
