package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object qkv;
    a.InterfaceC1298a qkw;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a implements a.InterfaceC1298a {
        private int id;
        String qkx;
        org.aspectj.lang.c qky;
        org.aspectj.lang.reflect.d qkz;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.qkx = str;
            this.qky = cVar;
            this.qkz = dVar;
            this.id = i;
        }

        public String eJs() {
            return this.qkx;
        }

        public org.aspectj.lang.c eJt() {
            return this.qky;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.abj(eJs()));
            stringBuffer.append("(");
            stringBuffer.append(((f) eJt()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.qkQ);
        }
    }

    public c(a.InterfaceC1298a interfaceC1298a, Object obj, Object obj2, Object[] objArr) {
        this.qkw = interfaceC1298a;
        this.qkv = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.qkw.toString();
    }
}
