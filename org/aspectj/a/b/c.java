package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object iCq;
    Object iCr;
    a.InterfaceC0402a iCs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0402a {
        String iCt;
        org.aspectj.lang.c iCu;
        org.aspectj.lang.reflect.d iCv;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.iCt = str;
            this.iCu = cVar;
            this.iCv = dVar;
        }

        public String ccR() {
            return this.iCt;
        }

        public org.aspectj.lang.c ccS() {
            return this.iCu;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.zI(ccR()));
            stringBuffer.append("(");
            stringBuffer.append(((f) ccS()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.iCN);
        }
    }

    public c(a.InterfaceC0402a interfaceC0402a, Object obj, Object obj2, Object[] objArr) {
        this.iCs = interfaceC0402a;
        this.iCq = obj;
        this.iCr = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.iCr;
    }

    public final String toString() {
        return this.iCs.toString();
    }
}
