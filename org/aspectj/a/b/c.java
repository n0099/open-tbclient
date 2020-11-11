package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object qag;
    a.InterfaceC1089a qah;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC1089a {
        private int id;
        String qai;
        org.aspectj.lang.c qaj;
        org.aspectj.lang.reflect.d qak;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.qai = str;
            this.qaj = cVar;
            this.qak = dVar;
            this.id = i;
        }

        public String eEv() {
            return this.qai;
        }

        public org.aspectj.lang.c eEw() {
            return this.qaj;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.ZX(eEv()));
            stringBuffer.append("(");
            stringBuffer.append(((f) eEw()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.qaB);
        }
    }

    public c(a.InterfaceC1089a interfaceC1089a, Object obj, Object obj2, Object[] objArr) {
        this.qah = interfaceC1089a;
        this.qag = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.qah.toString();
    }
}
