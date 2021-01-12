package com.qq.e.comm.plugin.c;

import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
class o implements k {

    /* renamed from: a  reason: collision with root package name */
    private String f11971a;

    /* renamed from: com.qq.e.comm.plugin.c.o$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f11972a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f11973b;

        AnonymousClass1(com.qq.e.comm.plugin.c.a.a aVar, boolean z) {
            this.f11972a = aVar;
            this.f11973b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11972a.a(this.f11973b);
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
