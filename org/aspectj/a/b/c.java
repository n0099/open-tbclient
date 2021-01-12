package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object qku;
    a.InterfaceC1298a qkv;
    Object target;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a implements a.InterfaceC1298a {
        private int id;
        String qkw;
        org.aspectj.lang.c qkx;
        org.aspectj.lang.reflect.d qky;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.qkw = str;
            this.qkx = cVar;
            this.qky = dVar;
            this.id = i;
        }

        public String eJs() {
            return this.qkw;
        }

        public org.aspectj.lang.c eJt() {
            return this.qkx;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.abi(eJs()));
            stringBuffer.append("(");
            stringBuffer.append(((f) eJt()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.qkP);
        }
    }

    public c(a.InterfaceC1298a interfaceC1298a, Object obj, Object obj2, Object[] objArr) {
        this.qkv = interfaceC1298a;
        this.qku = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.target;
    }

    public final String toString() {
        return this.qkv.toString();
    }
}
