package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object nIX;
    a.InterfaceC0773a nIY;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0773a {
        private int id;
        String nIZ;
        org.aspectj.lang.c nJa;
        org.aspectj.lang.reflect.d nJb;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.nIZ = str;
            this.nJa = cVar;
            this.nJb = dVar;
            this.id = i;
        }

        public String dLI() {
            return this.nIZ;
        }

        public org.aspectj.lang.c dLJ() {
            return this.nJa;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Sd(dLI()));
            stringBuffer.append("(");
            stringBuffer.append(((f) dLJ()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.nJt);
        }
    }

    public c(a.InterfaceC0773a interfaceC0773a, Object obj, Object obj2, Object[] objArr) {
        this.nIY = interfaceC0773a;
        this.nIX = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.nIY.toString();
    }
}
