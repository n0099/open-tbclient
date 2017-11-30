package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hKc;
    Object hKd;
    a.InterfaceC0168a hKe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0168a {
        String hKf;
        org.aspectj.lang.c hKg;
        org.aspectj.lang.reflect.d hKh;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hKf = str;
            this.hKg = cVar;
            this.hKh = dVar;
        }

        public String bSb() {
            return this.hKf;
        }

        public org.aspectj.lang.c bSc() {
            return this.hKg;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.wW(bSb()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bSc()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.hKA);
        }
    }

    public c(a.InterfaceC0168a interfaceC0168a, Object obj, Object obj2, Object[] objArr) {
        this.hKe = interfaceC0168a;
        this.hKc = obj;
        this.hKd = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hKd;
    }

    public final String toString() {
        return this.hKe.toString();
    }
}
