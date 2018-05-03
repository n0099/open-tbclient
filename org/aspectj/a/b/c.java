package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hzb;
    Object hzc;
    a.InterfaceC0278a hzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0278a {
        String hze;
        org.aspectj.lang.c hzf;
        org.aspectj.lang.reflect.d hzg;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hze = str;
            this.hzf = cVar;
            this.hzg = dVar;
        }

        public String bJz() {
            return this.hze;
        }

        public org.aspectj.lang.c bJA() {
            return this.hzf;
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
            return a(h.hzz);
        }
    }

    public c(a.InterfaceC0278a interfaceC0278a, Object obj, Object obj2, Object[] objArr) {
        this.hzd = interfaceC0278a;
        this.hzb = obj;
        this.hzc = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hzc;
    }

    public final String toString() {
        return this.hzd.toString();
    }
}
