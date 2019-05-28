package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object klf;
    a.InterfaceC0495a klg;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0495a {
        String klh;
        org.aspectj.lang.c kli;
        org.aspectj.lang.reflect.d klj;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.klh = str;
            this.kli = cVar;
            this.klj = dVar;
        }

        public String cKo() {
            return this.klh;
        }

        public org.aspectj.lang.c cKp() {
            return this.kli;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Hj(cKo()));
            stringBuffer.append("(");
            stringBuffer.append(((f) cKp()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.klB);
        }
    }

    public c(a.InterfaceC0495a interfaceC0495a, Object obj, Object obj2, Object[] objArr) {
        this.klg = interfaceC0495a;
        this.klf = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.klg.toString();
    }
}
