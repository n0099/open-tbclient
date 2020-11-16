package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object qbJ;
    a.InterfaceC1092a qbK;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a implements a.InterfaceC1092a {
        private int id;
        String qbL;
        org.aspectj.lang.c qbM;
        org.aspectj.lang.reflect.d qbN;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.qbL = str;
            this.qbM = cVar;
            this.qbN = dVar;
            this.id = i;
        }

        public String eEw() {
            return this.qbL;
        }

        public org.aspectj.lang.c eEx() {
            return this.qbM;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.ZI(eEw()));
            stringBuffer.append("(");
            stringBuffer.append(((f) eEx()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.qce);
        }
    }

    public c(a.InterfaceC1092a interfaceC1092a, Object obj, Object obj2, Object[] objArr) {
        this.qbK = interfaceC1092a;
        this.qbJ = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.qbK.toString();
    }
}
