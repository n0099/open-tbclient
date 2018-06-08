package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hOT;
    Object hOU;
    a.InterfaceC0296a hOV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0296a {
        String hOW;
        org.aspectj.lang.c hOX;
        org.aspectj.lang.reflect.d hOY;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hOW = str;
            this.hOX = cVar;
            this.hOY = dVar;
        }

        public String bPm() {
            return this.hOW;
        }

        public org.aspectj.lang.c bPn() {
            return this.hOX;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.xL(bPm()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bPn()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.hPq);
        }
    }

    public c(a.InterfaceC0296a interfaceC0296a, Object obj, Object obj2, Object[] objArr) {
        this.hOV = interfaceC0296a;
        this.hOT = obj;
        this.hOU = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hOU;
    }

    public final String toString() {
        return this.hOV.toString();
    }
}
