package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object kwO;
    a.InterfaceC0608a kwP;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0608a {
        String kwQ;
        org.aspectj.lang.c kwR;
        org.aspectj.lang.reflect.d kwS;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.kwQ = str;
            this.kwR = cVar;
            this.kwS = dVar;
        }

        public String cNn() {
            return this.kwQ;
        }

        public org.aspectj.lang.c cNo() {
            return this.kwR;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Hd(cNn()));
            stringBuffer.append("(");
            stringBuffer.append(((f) cNo()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.kxk);
        }
    }

    public c(a.InterfaceC0608a interfaceC0608a, Object obj, Object obj2, Object[] objArr) {
        this.kwP = interfaceC0608a;
        this.kwO = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.kwP.toString();
    }
}
