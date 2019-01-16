package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object iDx;
    Object iDy;
    a.InterfaceC0401a iDz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0401a {
        String iDA;
        org.aspectj.lang.c iDB;
        org.aspectj.lang.reflect.d iDC;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.iDA = str;
            this.iDB = cVar;
            this.iDC = dVar;
        }

        public String cdz() {
            return this.iDA;
        }

        public org.aspectj.lang.c cdA() {
            return this.iDB;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.zY(cdz()));
            stringBuffer.append("(");
            stringBuffer.append(((f) cdA()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.iDU);
        }
    }

    public c(a.InterfaceC0401a interfaceC0401a, Object obj, Object obj2, Object[] objArr) {
        this.iDz = interfaceC0401a;
        this.iDx = obj;
        this.iDy = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.iDy;
    }

    public final String toString() {
        return this.iDz.toString();
    }
}
