package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object oKd;
    a.InterfaceC0979a oKe;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0979a {
        private int id;
        String oKf;
        org.aspectj.lang.c oKg;
        org.aspectj.lang.reflect.d oKh;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.oKf = str;
            this.oKg = cVar;
            this.oKh = dVar;
            this.id = i;
        }

        public String emV() {
            return this.oKf;
        }

        public org.aspectj.lang.c emW() {
            return this.oKg;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.WS(emV()));
            stringBuffer.append("(");
            stringBuffer.append(((f) emW()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.oKy);
        }
    }

    public c(a.InterfaceC0979a interfaceC0979a, Object obj, Object obj2, Object[] objArr) {
        this.oKe = interfaceC0979a;
        this.oKd = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.oKe.toString();
    }
}
