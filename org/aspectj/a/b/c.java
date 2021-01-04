package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object qno;
    a.InterfaceC1274a qnp;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements a.InterfaceC1274a {
        private int id;
        String qnq;
        org.aspectj.lang.c qnr;
        org.aspectj.lang.reflect.d qns;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.qnq = str;
            this.qnr = cVar;
            this.qns = dVar;
            this.id = i;
        }

        public String eME() {
            return this.qnq;
        }

        public org.aspectj.lang.c eMF() {
            return this.qnr;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.acp(eME()));
            stringBuffer.append("(");
            stringBuffer.append(((f) eMF()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.qnJ);
        }
    }

    public c(a.InterfaceC1274a interfaceC1274a, Object obj, Object obj2, Object[] objArr) {
        this.qnp = interfaceC1274a;
        this.qno = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.qnp.toString();
    }
}
