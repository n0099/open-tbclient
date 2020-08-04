package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object ogk;
    a.InterfaceC0924a ogl;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public static class a implements a.InterfaceC0924a {
        private int id;
        String ogm;
        org.aspectj.lang.c ogn;
        org.aspectj.lang.reflect.d ogo;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.ogm = str;
            this.ogn = cVar;
            this.ogo = dVar;
            this.id = i;
        }

        public String dWM() {
            return this.ogm;
        }

        public org.aspectj.lang.c dWN() {
            return this.ogn;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Tm(dWM()));
            stringBuffer.append("(");
            stringBuffer.append(((f) dWN()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.ogF);
        }
    }

    public c(a.InterfaceC0924a interfaceC0924a, Object obj, Object obj2, Object[] objArr) {
        this.ogl = interfaceC0924a;
        this.ogk = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.ogl.toString();
    }
}
