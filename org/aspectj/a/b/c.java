package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object quY;
    a.InterfaceC1310a quZ;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC1310a {
        private int id;
        String qva;
        org.aspectj.lang.c qvb;
        org.aspectj.lang.reflect.d qvc;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.qva = str;
            this.qvb = cVar;
            this.qvc = dVar;
            this.id = i;
        }

        public String eLQ() {
            return this.qva;
        }

        public org.aspectj.lang.c eLR() {
            return this.qvb;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.acw(eLQ()));
            stringBuffer.append("(");
            stringBuffer.append(((f) eLR()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.qvt);
        }
    }

    public c(a.InterfaceC1310a interfaceC1310a, Object obj, Object obj2, Object[] objArr) {
        this.quZ = interfaceC1310a;
        this.quY = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.quZ.toString();
    }
}
