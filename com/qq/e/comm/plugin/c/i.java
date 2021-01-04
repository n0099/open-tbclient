package com.qq.e.comm.plugin.c;

import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
class i implements k {

    /* renamed from: com.qq.e.comm.plugin.c.i$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12253a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f12254b;

        AnonymousClass1(com.qq.e.comm.plugin.c.a.a aVar, f fVar) {
            this.f12253a = aVar;
            this.f12254b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12253a.c(i.a(i.this, this.f12254b, false));
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.i$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12255a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f12256b;

        AnonymousClass2(com.qq.e.comm.plugin.c.a.a aVar, f fVar) {
            this.f12255a = aVar;
            this.f12256b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12255a.b(this.f12256b.D);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.i$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12257a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f12258b;

        AnonymousClass3(com.qq.e.comm.plugin.c.a.a aVar, f fVar) {
            this.f12257a = aVar;
            this.f12258b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12257a.a(this.f12258b.D);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.i$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f12259a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12260b;

        AnonymousClass4(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
            this.f12259a = fVar;
            this.f12260b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a2 = i.a(i.this, this.f12259a, true);
            this.f12259a.B = this.f12260b.b(a2, this.f12259a.D);
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
