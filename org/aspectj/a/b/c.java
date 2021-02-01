package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object quy;
    a.InterfaceC1308a quz;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC1308a {
        private int id;
        String quA;
        org.aspectj.lang.c quB;
        org.aspectj.lang.reflect.d quC;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.quA = str;
            this.quB = cVar;
            this.quC = dVar;
            this.id = i;
        }

        public String eLI() {
            return this.quA;
        }

        public org.aspectj.lang.c eLJ() {
            return this.quB;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.ack(eLI()));
            stringBuffer.append("(");
            stringBuffer.append(((f) eLJ()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.quT);
        }
    }

    public c(a.InterfaceC1308a interfaceC1308a, Object obj, Object obj2, Object[] objArr) {
        this.quz = interfaceC1308a;
        this.quy = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.quz.toString();
    }
}
