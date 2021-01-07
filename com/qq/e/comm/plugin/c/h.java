package com.qq.e.comm.plugin.c;

import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes4.dex */
class h implements k {

    /* renamed from: com.qq.e.comm.plugin.c.h$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12248a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12249b;

        AnonymousClass1(com.qq.e.comm.plugin.c.a.a aVar, String str) {
            this.f12248a = aVar;
            this.f12249b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12248a.b(this.f12249b);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.h$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12250a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12251b;

        AnonymousClass2(com.qq.e.comm.plugin.c.a.a aVar, String str) {
            this.f12250a = aVar;
            this.f12251b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12250a.a(this.f12251b);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.h$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12252a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12253b;
        final /* synthetic */ f c;

        AnonymousClass3(com.qq.e.comm.plugin.c.a.a aVar, String str, f fVar) {
            this.f12252a = aVar;
            this.f12253b = str;
            this.c = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12252a.a(this.f12253b, this.c.D);
        }
    }

    h() {
    }

    private boolean b(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        return gdtadv.getZresult(287, 0, this, fVar, aVar);
    }

    private boolean c(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        return gdtadv.getZresult(288, 0, this, fVar, aVar);
    }

    private boolean d(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        return gdtadv.getZresult(289, 0, this, fVar, aVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar) {
        return gdtadv.getZresult(290, 0, this, fVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        return gdtadv.getZresult(291, 0, this, fVar, aVar);
    }
}
