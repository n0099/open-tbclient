package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object irW;
    Object irX;
    a.InterfaceC0388a irY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements a.InterfaceC0388a {
        String irZ;
        org.aspectj.lang.c isa;
        org.aspectj.lang.reflect.d isb;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.irZ = str;
            this.isa = cVar;
            this.isb = dVar;
        }

        public String bZV() {
            return this.irZ;
        }

        public org.aspectj.lang.c bZW() {
            return this.isa;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.zc(bZV()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bZW()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.ist);
        }
    }

    public c(a.InterfaceC0388a interfaceC0388a, Object obj, Object obj2, Object[] objArr) {
        this.irY = interfaceC0388a;
        this.irW = obj;
        this.irX = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.irX;
    }

    public final String toString() {
        return this.irY.toString();
    }
}
