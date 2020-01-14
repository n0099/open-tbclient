package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object nJc;
    a.InterfaceC0773a nJd;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0773a {
        private int id;
        String nJe;
        org.aspectj.lang.c nJf;
        org.aspectj.lang.reflect.d nJg;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.nJe = str;
            this.nJf = cVar;
            this.nJg = dVar;
            this.id = i;
        }

        public String dLK() {
            return this.nJe;
        }

        public org.aspectj.lang.c dLL() {
            return this.nJf;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Sd(dLK()));
            stringBuffer.append("(");
            stringBuffer.append(((f) dLL()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.nJy);
        }
    }

    public c(a.InterfaceC0773a interfaceC0773a, Object obj, Object obj2, Object[] objArr) {
        this.nJd = interfaceC0773a;
        this.nJc = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.nJd.toString();
    }
}
