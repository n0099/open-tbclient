package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object nBJ;
    a.InterfaceC0889a nBK;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC0889a {
        private int id;
        String nBL;
        org.aspectj.lang.c nBM;
        org.aspectj.lang.reflect.d nBN;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.nBL = str;
            this.nBM = cVar;
            this.nBN = dVar;
            this.id = i;
        }

        public String dOF() {
            return this.nBL;
        }

        public org.aspectj.lang.c dOG() {
            return this.nBM;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.RO(dOF()));
            stringBuffer.append("(");
            stringBuffer.append(((f) dOG()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.nCf);
        }
    }

    public c(a.InterfaceC0889a interfaceC0889a, Object obj, Object obj2, Object[] objArr) {
        this.nBK = interfaceC0889a;
        this.nBJ = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.nBK.toString();
    }
}
