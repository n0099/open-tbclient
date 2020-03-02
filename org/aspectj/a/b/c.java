package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object nJT;
    a.InterfaceC0781a nJU;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC0781a {
        private int id;
        String nJV;
        org.aspectj.lang.c nJW;
        org.aspectj.lang.reflect.d nJX;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.nJV = str;
            this.nJW = cVar;
            this.nJX = dVar;
            this.id = i;
        }

        public String dMZ() {
            return this.nJV;
        }

        public org.aspectj.lang.c dNa() {
            return this.nJW;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.So(dMZ()));
            stringBuffer.append("(");
            stringBuffer.append(((f) dNa()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.nKp);
        }
    }

    public c(a.InterfaceC0781a interfaceC0781a, Object obj, Object obj2, Object[] objArr) {
        this.nJU = interfaceC0781a;
        this.nJT = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.nJU.toString();
    }
}
