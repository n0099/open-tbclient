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
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12247a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12248b;

        AnonymousClass1(com.qq.e.comm.plugin.c.a.a aVar, String str) {
            this.f12247a = aVar;
            this.f12248b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12247a.b(this.f12248b);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.h$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12249a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12250b;

        AnonymousClass2(com.qq.e.comm.plugin.c.a.a aVar, String str) {
            this.f12249a = aVar;
            this.f12250b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12249a.a(this.f12250b);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.h$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12251a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12252b;
        final /* synthetic */ f c;

        AnonymousClass3(com.qq.e.comm.plugin.c.a.a aVar, String str, f fVar) {
            this.f12251a = aVar;
            this.f12252b = str;
            this.c = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12251a.a(this.f12252b, this.c.D);
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
