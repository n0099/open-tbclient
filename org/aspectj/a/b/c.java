package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object pLL;
    a.InterfaceC1056a pLM;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a implements a.InterfaceC1056a {
        private int id;
        String pLN;
        org.aspectj.lang.c pLO;
        org.aspectj.lang.reflect.d pLP;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.pLN = str;
            this.pLO = cVar;
            this.pLP = dVar;
            this.id = i;
        }

        public String eEw() {
            return this.pLN;
        }

        public org.aspectj.lang.c eEx() {
            return this.pLO;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.aav(eEw()));
            stringBuffer.append("(");
            stringBuffer.append(((f) eEx()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.pMg);
        }
    }

    public c(a.InterfaceC1056a interfaceC1056a, Object obj, Object obj2, Object[] objArr) {
        this.pLM = interfaceC1056a;
        this.pLL = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.pLM.toString();
    }
}
