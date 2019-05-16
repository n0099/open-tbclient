package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object kle;
    a.InterfaceC0495a klf;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0495a {
        String klg;
        org.aspectj.lang.c klh;
        org.aspectj.lang.reflect.d kli;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.klg = str;
            this.klh = cVar;
            this.kli = dVar;
        }

        public String cKm() {
            return this.klg;
        }

        public org.aspectj.lang.c cKn() {
            return this.klh;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Hj(cKm()));
            stringBuffer.append("(");
            stringBuffer.append(((f) cKn()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.klA);
        }
    }

    public c(a.InterfaceC0495a interfaceC0495a, Object obj, Object obj2, Object[] objArr) {
        this.klf = interfaceC0495a;
        this.kle = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.klf.toString();
    }
}
