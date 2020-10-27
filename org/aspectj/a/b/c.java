package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object pQM;
    a.InterfaceC1069a pQN;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC1069a {
        private int id;
        String pQO;
        org.aspectj.lang.c pQP;
        org.aspectj.lang.reflect.d pQQ;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.pQO = str;
            this.pQP = cVar;
            this.pQQ = dVar;
            this.id = i;
        }

        public String eAG() {
            return this.pQO;
        }

        public org.aspectj.lang.c eAH() {
            return this.pQP;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Zt(eAG()));
            stringBuffer.append("(");
            stringBuffer.append(((f) eAH()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.pRh);
        }
    }

    public c(a.InterfaceC1069a interfaceC1069a, Object obj, Object obj2, Object[] objArr) {
        this.pQN = interfaceC1069a;
        this.pQM = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.pQN.toString();
    }
}
