package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object kvX;
    a.InterfaceC0591a kvY;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0591a {
        String kvZ;
        org.aspectj.lang.c kwa;
        org.aspectj.lang.reflect.d kwb;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.kvZ = str;
            this.kwa = cVar;
            this.kwb = dVar;
        }

        public String cNl() {
            return this.kvZ;
        }

        public org.aspectj.lang.c cNm() {
            return this.kwa;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.Hd(cNl()));
            stringBuffer.append("(");
            stringBuffer.append(((f) cNm()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.kwt);
        }
    }

    public c(a.InterfaceC0591a interfaceC0591a, Object obj, Object obj2, Object[] objArr) {
        this.kvY = interfaceC0591a;
        this.kvX = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.kvY.toString();
    }
}
