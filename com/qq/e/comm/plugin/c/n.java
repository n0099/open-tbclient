package com.qq.e.comm.plugin.c;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes4.dex */
class n implements com.qq.e.comm.plugin.c.a.b, k {

    /* renamed from: a  reason: collision with root package name */
    private f f12266a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.c.a.a f12267b;
    private Intent c;

    /* renamed from: com.qq.e.comm.plugin.c.n$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f12268a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12269b;

        AnonymousClass1(com.qq.e.comm.plugin.c.a.a aVar, String str) {
            this.f12268a = aVar;
            this.f12269b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12268a.a(this.f12269b, n.this);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.n$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.a(n.this).a(true);
        }
    }

    n() {
    }

    static /* synthetic */ com.qq.e.comm.plugin.c.a.a a(n nVar) {
        return (com.qq.e.comm.plugin.c.a.a) gdtadv.getobjresult(274, 1, nVar);
    }

    private String a(PackageManager packageManager, ResolveInfo resolveInfo) {
        return (String) gdtadv.getobjresult(275, 0, this, packageManager, resolveInfo);
    }

    private void a(int i) {
        gdtadv.getVresult(276, 0, this, Integer.valueOf(i));
    }

    private void a(PackageManager packageManager, ResolveInfo resolveInfo, com.qq.e.comm.plugin.c.a.a aVar) {
        gdtadv.getVresult(277, 0, this, packageManager, resolveInfo, aVar);
    }

    private Intent b(f fVar) {
        return (Intent) gdtadv.getobjresult(278, 0, this, fVar);
    }

    private String c(f fVar) {
        return (String) gdtadv.getobjresult(279, 0, this, fVar);
    }

    private void d() {
        gdtadv.getVresult(280, 0, this);
    }

    private String e() {
        return (String) gdtadv.getobjresult(281, 0, this);
    }

    @Override // com.qq.e.comm.plugin.c.a.b
    public void a() {
        gdtadv.getVresult(282, 0, this);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar) {
        return gdtadv.getZresult(283, 0, this, fVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        return gdtadv.getZresult(284, 0, this, fVar, aVar);
    }

    @Override // com.qq.e.comm.plugin.c.a.b
    public void b() {
        gdtadv.getVresult(285, 0, this);
    }

    @Override // com.qq.e.comm.plugin.c.a.b
    public void c() {
        gdtadv.getVresult(286, 0, this);
    }
}
