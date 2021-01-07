package com.qq.e.comm.plugin.c;

import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes4.dex */
class o implements k {

    /* renamed from: a  reason: collision with root package name */
    private String f12271a;

    /* renamed from: com.qq.e.comm.plugin.c.o$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12272a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f12273b;

        AnonymousClass1(com.qq.e.comm.plugin.c.a.a aVar, boolean z) {
            this.f12272a = aVar;
            this.f12273b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12272a.a(this.f12273b);
        }
    }

    o() {
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar) {
        return gdtadv.getZresult(344, 0, this, fVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        return gdtadv.getZresult(345, 0, this, fVar, aVar);
    }
}
