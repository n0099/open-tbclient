package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hAf;
    Object hAg;
    a.InterfaceC0278a hAh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0278a {
        String hAi;
        org.aspectj.lang.c hAj;
        org.aspectj.lang.reflect.d hAk;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hAi = str;
            this.hAj = cVar;
            this.hAk = dVar;
        }

        public String bJx() {
            return this.hAi;
        }

        public org.aspectj.lang.c bJy() {
            return this.hAj;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.wO(bJx()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bJy()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.hAD);
        }
    }

    public c(a.InterfaceC0278a interfaceC0278a, Object obj, Object obj2, Object[] objArr) {
        this.hAh = interfaceC0278a;
        this.hAf = obj;
        this.hAg = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hAg;
    }

    public final String toString() {
        return this.hAh.toString();
    }
}
