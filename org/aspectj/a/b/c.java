package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    a.InterfaceC0206a idA;
    Object idy;
    Object idz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0206a {
        String idB;
        org.aspectj.lang.c idC;
        org.aspectj.lang.reflect.d idD;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.idB = str;
            this.idC = cVar;
            this.idD = dVar;
        }

        public String bQJ() {
            return this.idB;
        }

        public org.aspectj.lang.c bQK() {
            return this.idC;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.vz(bQJ()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bQK()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.idX);
        }
    }

    public c(a.InterfaceC0206a interfaceC0206a, Object obj, Object obj2, Object[] objArr) {
        this.idA = interfaceC0206a;
        this.idy = obj;
        this.idz = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.idz;
    }

    public final String toString() {
        return this.idA.toString();
    }
}
