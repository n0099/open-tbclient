package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object jTu;
    Object jTv;
    a.InterfaceC0474a jTw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0474a {
        String jTx;
        org.aspectj.lang.c jTy;
        org.aspectj.lang.reflect.d jTz;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.jTx = str;
            this.jTy = cVar;
            this.jTz = dVar;
        }

        public String cCR() {
            return this.jTx;
        }

        public org.aspectj.lang.c cCS() {
            return this.jTy;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Gc(cCR()));
            stringBuffer.append("(");
            stringBuffer.append(((f) cCS()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.jTR);
        }
    }

    public c(a.InterfaceC0474a interfaceC0474a, Object obj, Object obj2, Object[] objArr) {
        this.jTw = interfaceC0474a;
        this.jTu = obj;
        this.jTv = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.jTv;
    }

    public final String toString() {
        return this.jTw.toString();
    }
}
