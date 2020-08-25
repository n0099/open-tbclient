package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object oAg;
    a.InterfaceC0982a oAh;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class a implements a.InterfaceC0982a {
        private int id;
        String oAi;
        org.aspectj.lang.c oAj;
        org.aspectj.lang.reflect.d oAk;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.oAi = str;
            this.oAj = cVar;
            this.oAk = dVar;
            this.id = i;
        }

        public String eiP() {
            return this.oAi;
        }

        public org.aspectj.lang.c eiQ() {
            return this.oAj;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Wq(eiP()));
            stringBuffer.append("(");
            stringBuffer.append(((f) eiQ()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.oAB);
        }
    }

    public c(a.InterfaceC0982a interfaceC0982a, Object obj, Object obj2, Object[] objArr) {
        this.oAh = interfaceC0982a;
        this.oAg = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.oAh.toString();
    }
}
