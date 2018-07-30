package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hJL;
    Object hJM;
    a.InterfaceC0298a hJN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0298a {
        String hJO;
        org.aspectj.lang.c hJP;
        org.aspectj.lang.reflect.d hJQ;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hJO = str;
            this.hJP = cVar;
            this.hJQ = dVar;
        }

        public String bKW() {
            return this.hJO;
        }

        public org.aspectj.lang.c bKX() {
            return this.hJP;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.wJ(bKW()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bKX()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.hKj);
        }
    }

    public c(a.InterfaceC0298a interfaceC0298a, Object obj, Object obj2, Object[] objArr) {
        this.hJN = interfaceC0298a;
        this.hJL = obj;
        this.hJM = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hJM;
    }

    public final String toString() {
        return this.hJN.toString();
    }
}
