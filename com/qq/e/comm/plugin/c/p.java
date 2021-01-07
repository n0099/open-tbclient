package com.qq.e.comm.plugin.c;

import android.content.Intent;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes4.dex */
class p implements k {

    /* renamed from: a  reason: collision with root package name */
    private String f12274a;

    /* renamed from: com.qq.e.comm.plugin.c.p$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12275a;

        AnonymousClass1(com.qq.e.comm.plugin.c.a.a aVar) {
            this.f12275a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12275a.a(true);
        }
    }

    p() {
    }

    private Intent a(f fVar, String str) {
        return (Intent) gdtadv.getobjresult(264, 0, this, fVar, str);
    }

    private String b(f fVar) {
        return (String) gdtadv.getobjresult(265, 0, this, fVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar) {
        return gdtadv.getZresult(266, 0, this, fVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        return gdtadv.getZresult(267, 0, this, fVar, aVar);
    }
}
