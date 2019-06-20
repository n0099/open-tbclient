package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object kli;
    a.InterfaceC0495a klj;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0495a {
        String klk;
        org.aspectj.lang.c kll;
        org.aspectj.lang.reflect.d klm;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.klk = str;
            this.kll = cVar;
            this.klm = dVar;
        }

        public String cKn() {
            return this.klk;
        }

        public org.aspectj.lang.c cKo() {
            return this.kll;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Hl(cKn()));
            stringBuffer.append("(");
            stringBuffer.append(((f) cKo()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.klE);
        }
    }

    public c(a.InterfaceC0495a interfaceC0495a, Object obj, Object obj2, Object[] objArr) {
        this.klj = interfaceC0495a;
        this.kli = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.klj.toString();
    }
}
