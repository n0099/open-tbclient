package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object qvA;
    a.InterfaceC1292a qvB;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a implements a.InterfaceC1292a {
        private int id;
        String qvC;
        org.aspectj.lang.c qvD;
        org.aspectj.lang.reflect.d qvE;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.qvC = str;
            this.qvD = cVar;
            this.qvE = dVar;
            this.id = i;
        }

        public String eLy() {
            return this.qvC;
        }

        public org.aspectj.lang.c eLz() {
            return this.qvD;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.acv(eLy()));
            stringBuffer.append("(");
            stringBuffer.append(((f) eLz()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.qvV);
        }
    }

    public c(a.InterfaceC1292a interfaceC1292a, Object obj, Object obj2, Object[] objArr) {
        this.qvB = interfaceC1292a;
        this.qvA = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.qvB.toString();
    }
}
