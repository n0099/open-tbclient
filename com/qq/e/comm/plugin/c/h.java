package com.qq.e.comm.plugin.c;

import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
class h implements k {

    /* renamed from: com.qq.e.comm.plugin.c.h$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f11948a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f11949b;

        AnonymousClass1(com.qq.e.comm.plugin.c.a.a aVar, String str) {
            this.f11948a = aVar;
            this.f11949b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11948a.b(this.f11949b);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.h$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f11950a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f11951b;

        AnonymousClass2(com.qq.e.comm.plugin.c.a.a aVar, String str) {
            this.f11950a = aVar;
            this.f11951b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11950a.a(this.f11951b);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.h$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f11952a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f11953b;
        final /* synthetic */ f c;

        AnonymousClass3(com.qq.e.comm.plugin.c.a.a aVar, String str, f fVar) {
            this.f11952a = aVar;
            this.f11953b = str;
            this.c = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11952a.a(this.f11953b, this.c.D);
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
