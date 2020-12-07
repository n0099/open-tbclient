package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object pLJ;
    a.InterfaceC1056a pLK;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a implements a.InterfaceC1056a {
        private int id;
        String pLL;
        org.aspectj.lang.c pLM;
        org.aspectj.lang.reflect.d pLN;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.pLL = str;
            this.pLM = cVar;
            this.pLN = dVar;
            this.id = i;
        }

        public String eEv() {
            return this.pLL;
        }

        public org.aspectj.lang.c eEw() {
            return this.pLM;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.aav(eEv()));
            stringBuffer.append("(");
            stringBuffer.append(((f) eEw()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.pMe);
        }
    }

    public c(a.InterfaceC1056a interfaceC1056a, Object obj, Object obj2, Object[] objArr) {
        this.pLK = interfaceC1056a;
        this.pLJ = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.pLK.toString();
    }
}
