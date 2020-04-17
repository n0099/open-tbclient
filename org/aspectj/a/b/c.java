package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object nfv;
    a.InterfaceC0805a nfw;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC0805a {
        private int id;
        String nfx;
        org.aspectj.lang.c nfy;
        org.aspectj.lang.reflect.d nfz;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.nfx = str;
            this.nfy = cVar;
            this.nfz = dVar;
            this.id = i;
        }

        public String dGA() {
            return this.nfx;
        }

        public org.aspectj.lang.c dGB() {
            return this.nfy;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.PE(dGA()));
            stringBuffer.append("(");
            stringBuffer.append(((f) dGB()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.nfR);
        }
    }

    public c(a.InterfaceC0805a interfaceC0805a, Object obj, Object obj2, Object[] objArr) {
        this.nfw = interfaceC0805a;
        this.nfv = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.nfw.toString();
    }
}
