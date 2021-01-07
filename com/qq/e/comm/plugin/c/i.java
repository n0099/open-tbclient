package com.qq.e.comm.plugin.c;

import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes4.dex */
class i implements k {

    /* renamed from: com.qq.e.comm.plugin.c.i$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12254a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f12255b;

        AnonymousClass1(com.qq.e.comm.plugin.c.a.a aVar, f fVar) {
            this.f12254a = aVar;
            this.f12255b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12254a.c(i.a(i.this, this.f12255b, false));
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.i$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12256a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f12257b;

        AnonymousClass2(com.qq.e.comm.plugin.c.a.a aVar, f fVar) {
            this.f12256a = aVar;
            this.f12257b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12256a.b(this.f12257b.D);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.i$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12258a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f12259b;

        AnonymousClass3(com.qq.e.comm.plugin.c.a.a aVar, f fVar) {
            this.f12258a = aVar;
            this.f12259b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12258a.a(this.f12259b.D);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.i$4  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f12260a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12261b;

        AnonymousClass4(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
            this.f12260a = fVar;
            this.f12261b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a2 = i.a(i.this, this.f12260a, true);
            this.f12260a.B = this.f12261b.b(a2, this.f12260a.D);
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
