package org.aspectj.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements org.aspectj.lang.b {
    Object[] args;
    Object imq;
    Object imr;
    a.InterfaceC0295a ims;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC0295a {
        String imt;
        org.aspectj.lang.c imu;
        org.aspectj.lang.reflect.d imv;

        public a(String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.imt = str;
            this.imu = cVar;
            this.imv = dVar;
        }

        public String bRW() {
            return this.imt;
        }

        public org.aspectj.lang.c bRX() {
            return this.imu;
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.wZ(bRW()));
            stringBuffer.append("(");
            stringBuffer.append(((f) bRX()).a(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return a(h.imO);
        }
    }

    public c(a.InterfaceC0295a interfaceC0295a, Object obj, Object obj2, Object[] objArr) {
        this.ims = interfaceC0295a;
        this.imq = obj;
        this.imr = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.imr;
    }

    public final String toString() {
        return this.ims.toString();
    }
}
