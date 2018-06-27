package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hSZ;
    Object hTa;
    a.InterfaceC0298a hTb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0298a {
        String hTc;
        org.aspectj.lang.c hTd;
        org.aspectj.lang.reflect.d hTe;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hTc = str;
            this.hTd = cVar;
            this.hTe = dVar;
        }

        public String bPP() {
            return this.hTc;
        }

        public org.aspectj.lang.c bPQ() {
            return this.hTd;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.xJ(bPP()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bPQ()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.hTw);
        }
    }

    public c(a.InterfaceC0298a interfaceC0298a, Object obj, Object obj2, Object[] objArr) {
        this.hTb = interfaceC0298a;
        this.hSZ = obj;
        this.hTa = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hTa;
    }

    public final String toString() {
        return this.hTb.toString();
    }
}
