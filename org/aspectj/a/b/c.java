package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object imc;
    Object imd;
    a.InterfaceC0296a ime;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0296a {
        String imf;
        org.aspectj.lang.c imh;
        org.aspectj.lang.reflect.d imi;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.imf = str;
            this.imh = cVar;
            this.imi = dVar;
        }

        public String bRV() {
            return this.imf;
        }

        public org.aspectj.lang.c bRW() {
            return this.imh;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.wZ(bRV()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bRW()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.imB);
        }
    }

    public c(a.InterfaceC0296a interfaceC0296a, Object obj, Object obj2, Object[] objArr) {
        this.ime = interfaceC0296a;
        this.imc = obj;
        this.imd = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.imd;
    }

    public final String toString() {
        return this.ime.toString();
    }
}
