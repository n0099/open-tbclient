package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object nJR;
    a.InterfaceC0781a nJS;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC0781a {
        private int id;
        String nJT;
        org.aspectj.lang.c nJU;
        org.aspectj.lang.reflect.d nJV;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.nJT = str;
            this.nJU = cVar;
            this.nJV = dVar;
            this.id = i;
        }

        public String dMX() {
            return this.nJT;
        }

        public org.aspectj.lang.c dMY() {
            return this.nJU;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.So(dMX()));
            stringBuffer.append("(");
            stringBuffer.append(((f) dMY()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.nKn);
        }
    }

    public c(a.InterfaceC0781a interfaceC0781a, Object obj, Object obj2, Object[] objArr) {
        this.nJS = interfaceC0781a;
        this.nJR = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.nJS.toString();
    }
}
