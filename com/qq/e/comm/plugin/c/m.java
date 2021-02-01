package com.qq.e.comm.plugin.c;

import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes15.dex */
class m implements k {

    /* renamed from: com.qq.e.comm.plugin.c.m$1  reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f11966a;

        AnonymousClass1(com.qq.e.comm.plugin.c.a.a aVar) {
            this.f11966a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11966a.a();
        }
    }

    m() {
    }

    private void a(com.qq.e.comm.plugin.c.a.a aVar) {
        gdtadv.getVresult(268, 0, this, aVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar) {
        return gdtadv.getZresult(269, 0, this, fVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        return gdtadv.getZresult(270, 0, this, fVar, aVar);
    }
}
