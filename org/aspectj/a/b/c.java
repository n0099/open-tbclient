package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    a.InterfaceC0401a iDA;
    Object iDy;
    Object iDz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0401a {
        String iDB;
        org.aspectj.lang.c iDC;
        org.aspectj.lang.reflect.d iDD;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.iDB = str;
            this.iDC = cVar;
            this.iDD = dVar;
        }

        public String cdz() {
            return this.iDB;
        }

        public org.aspectj.lang.c cdA() {
            return this.iDC;
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
            return a(h.iDV);
        }
    }

    public c(a.InterfaceC0401a interfaceC0401a, Object obj, Object obj2, Object[] objArr) {
        this.iDA = interfaceC0401a;
        this.iDy = obj;
        this.iDz = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.iDz;
    }

    public final String toString() {
        return this.iDA.toString();
    }
}
