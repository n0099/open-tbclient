package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hze;
    Object hzf;
    a.InterfaceC0278a hzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0278a {
        String hzh;
        org.aspectj.lang.c hzi;
        org.aspectj.lang.reflect.d hzj;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hzh = str;
            this.hzi = cVar;
            this.hzj = dVar;
        }

        public String bJz() {
            return this.hzh;
        }

        public org.aspectj.lang.c bJA() {
            return this.hzi;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.wL(bJz()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bJA()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.hzC);
        }
    }

    public c(a.InterfaceC0278a interfaceC0278a, Object obj, Object obj2, Object[] objArr) {
        this.hzg = interfaceC0278a;
        this.hze = obj;
        this.hzf = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hzf;
    }

    public final String toString() {
        return this.hzg.toString();
    }
}
