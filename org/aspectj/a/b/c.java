package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object kwg;
    a.InterfaceC0507a kwh;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0507a {
        String kwi;
        org.aspectj.lang.c kwj;
        org.aspectj.lang.reflect.d kwk;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.kwi = str;
            this.kwj = cVar;
            this.kwk = dVar;
        }

        public String cPg() {
            return this.kwi;
        }

        public org.aspectj.lang.c cPh() {
            return this.kwj;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.IM(cPg()));
            stringBuffer.append("(");
            stringBuffer.append(((f) cPh()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.kwC);
        }
    }

    public c(a.InterfaceC0507a interfaceC0507a, Object obj, Object obj2, Object[] objArr) {
        this.kwh = interfaceC0507a;
        this.kwg = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.kwh.toString();
    }
}
