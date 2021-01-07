package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object qoW;
    a.InterfaceC1315a qoX;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a implements a.InterfaceC1315a {
        private int id;
        String qoY;
        org.aspectj.lang.c qoZ;
        org.aspectj.lang.reflect.d qpa;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.qoY = str;
            this.qoZ = cVar;
            this.qpa = dVar;
            this.id = i;
        }

        public String eNi() {
            return this.qoY;
        }

        public org.aspectj.lang.c eNj() {
            return this.qoZ;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.acq(eNi()));
            stringBuffer.append("(");
            stringBuffer.append(((f) eNj()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.qpr);
        }
    }

    public c(a.InterfaceC1315a interfaceC1315a, Object obj, Object obj2, Object[] objArr) {
        this.qoX = interfaceC1315a;
        this.qoW = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.qoX.toString();
    }
}
