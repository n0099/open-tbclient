package com.qq.e.comm.plugin.c;

import okhttp3.internal.http.StatusLine;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
class j implements k {

    /* renamed from: com.qq.e.comm.plugin.c.j$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12261a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f12262b;

        AnonymousClass1(com.qq.e.comm.plugin.c.a.a aVar, boolean z) {
            this.f12261a = aVar;
            this.f12262b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12261a.a(this.f12262b);
        }
    }

    j() {
    }

    private void a(f fVar, boolean z) {
        gdtadv.getVresult(307, 0, this, fVar, Boolean.valueOf(z));
    }

    private boolean a(f fVar, com.qq.e.comm.plugin.y.d dVar) {
        return gdtadv.getZresult(StatusLine.HTTP_PERM_REDIRECT, 0, this, fVar, dVar);
    }

    private void b(f fVar, com.qq.e.comm.plugin.y.d dVar) {
        gdtadv.getVresult(309, 0, this, fVar, dVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar) {
        return gdtadv.getZresult(310, 0, this, fVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        return gdtadv.getZresult(311, 0, this, fVar, aVar);
    }
}
