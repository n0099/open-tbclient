package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object hJs;
    Object hJt;
    a.InterfaceC0298a hJu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0298a {
        String hJv;
        org.aspectj.lang.c hJw;
        org.aspectj.lang.reflect.d hJx;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.hJv = str;
            this.hJw = cVar;
            this.hJx = dVar;
        }

        public String bKN() {
            return this.hJv;
        }

        public org.aspectj.lang.c bKO() {
            return this.hJw;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.wK(bKN()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bKO()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.hJQ);
        }
    }

    public c(a.InterfaceC0298a interfaceC0298a, Object obj, Object obj2, Object[] objArr) {
        this.hJu = interfaceC0298a;
        this.hJs = obj;
        this.hJt = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.hJt;
    }

    public final String toString() {
        return this.hJu.toString();
    }
}
