package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object ogi;
    a.InterfaceC0924a ogj;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public static class a implements a.InterfaceC0924a {
        private int id;
        String ogk;
        org.aspectj.lang.c ogl;
        org.aspectj.lang.reflect.d ogm;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.ogk = str;
            this.ogl = cVar;
            this.ogm = dVar;
            this.id = i;
        }

        public String dWL() {
            return this.ogk;
        }

        public org.aspectj.lang.c dWM() {
            return this.ogl;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Tm(dWL()));
            stringBuffer.append("(");
            stringBuffer.append(((f) dWM()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.ogD);
        }
    }

    public c(a.InterfaceC0924a interfaceC0924a, Object obj, Object obj2, Object[] objArr) {
        this.ogj = interfaceC0924a;
        this.ogi = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.ogj.toString();
    }
}
