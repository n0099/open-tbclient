package com.qq.e.comm.plugin.c;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes4.dex */
class m implements k {

    /* renamed from: com.qq.e.comm.plugin.c.m$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12264a;

        AnonymousClass1(com.qq.e.comm.plugin.c.a.a aVar) {
            this.f12264a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12264a.a();
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
        return gdtadv.getZresult(SubsamplingScaleImageView.ORIENTATION_270, 0, this, fVar, aVar);
    }
}
