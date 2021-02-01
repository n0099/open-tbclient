package com.qq.e.comm.plugin.c;

import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes15.dex */
class i implements k {

    /* renamed from: com.qq.e.comm.plugin.c.i$1  reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f11956a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f11957b;

        AnonymousClass1(com.qq.e.comm.plugin.c.a.a aVar, f fVar) {
            this.f11956a = aVar;
            this.f11957b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11956a.c(i.a(i.this, this.f11957b, false));
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.i$2  reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f11958a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f11959b;

        AnonymousClass2(com.qq.e.comm.plugin.c.a.a aVar, f fVar) {
            this.f11958a = aVar;
            this.f11959b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11958a.b(this.f11959b.D);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.i$3  reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f11960a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f11961b;

        AnonymousClass3(com.qq.e.comm.plugin.c.a.a aVar, f fVar) {
            this.f11960a = aVar;
            this.f11961b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11960a.a(this.f11961b.D);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.i$4  reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f11962a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f11963b;

        AnonymousClass4(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
            this.f11962a = fVar;
            this.f11963b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a2 = i.a(i.this, this.f11962a, true);
            this.f11962a.B = this.f11963b.b(a2, this.f11962a.D);
        }
    }

    i() {
    }

    private String a(f fVar, boolean z) {
        return (String) gdtadv.getobjresult(347, 0, this, fVar, Boolean.valueOf(z));
    }

    static /* synthetic */ String a(i iVar, f fVar, boolean z) {
        return (String) gdtadv.getobjresult(348, 1, iVar, fVar, Boolean.valueOf(z));
    }

    private boolean b(f fVar) {
        return gdtadv.getZresult(349, 0, this, fVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar) {
        return gdtadv.getZresult(350, 0, this, fVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        return gdtadv.getZresult(351, 0, this, fVar, aVar);
    }
}
