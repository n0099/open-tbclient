package com.qq.e.comm.plugin.c;

import com.qq.e.comm.plugin.util.w;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
class b implements com.qq.e.comm.plugin.c.a.b, k {

    /* renamed from: a  reason: collision with root package name */
    private f f11924a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.ad.j f11925b;
    private String c;
    private int d;
    private com.qq.e.comm.plugin.c.a.a e;

    /* renamed from: com.qq.e.comm.plugin.c.b$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.c.a.a f11926a;

        AnonymousClass1(com.qq.e.comm.plugin.c.a.a aVar) {
            this.f11926a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11926a.a(b.a(b.this).i(), b.b(b.this));
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.b$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.c(b.this).a(b.b(b.this), b.this);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.b$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a d = b.d(b.this);
            if (d == null || b.e(b.this).a().f12445a != 200) {
                if (b.c(b.this) != null) {
                    w.a(new Runnable() { // from class: com.qq.e.comm.plugin.c.b.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.c(b.this).a();
                        }
                    });
                    return;
                }
                return;
            }
            final com.qq.e.comm.plugin.a.c a2 = b.a(b.this, d);
            if (b.c(b.this) != null) {
                w.a(new Runnable() { // from class: com.qq.e.comm.plugin.c.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.c(b.this).a(a2.f(), b.b(b.this));
                    }
                });
            }
            com.qq.e.comm.plugin.a.l.a().a(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f11933a;

        /* renamed from: b  reason: collision with root package name */
        private final String f11934b;

        public a(String str, String str2) {
            this.f11933a = str;
            this.f11934b = str2;
        }

        public a(JSONObject jSONObject) {
            this.f11933a = jSONObject.optString("name");
            this.f11934b = jSONObject.optString("iconurl");
        }
    }

    b() {
    }

    private com.qq.e.comm.plugin.a.c a(a aVar) {
        return (com.qq.e.comm.plugin.a.c) gdtadv.getobjresult(312, 0, this, aVar);
    }

    static /* synthetic */ com.qq.e.comm.plugin.a.c a(b bVar, a aVar) {
        return (com.qq.e.comm.plugin.a.c) gdtadv.getobjresult(313, 1, bVar, aVar);
    }

    static /* synthetic */ com.qq.e.comm.plugin.ad.j a(b bVar) {
        return (com.qq.e.comm.plugin.ad.j) gdtadv.getobjresult(314, 1, bVar);
    }

    private String a(String str, int i) {
        return (String) gdtadv.getobjresult(315, 0, this, str, Integer.valueOf(i));
    }

    static /* synthetic */ int b(b bVar) {
        return gdtadv.getIresult(316, 1, bVar);
    }

    static /* synthetic */ com.qq.e.comm.plugin.c.a.a c(b bVar) {
        return (com.qq.e.comm.plugin.c.a.a) gdtadv.getobjresult(317, 1, bVar);
    }

    static /* synthetic */ a d(b bVar) {
        return (a) gdtadv.getobjresult(318, 1, bVar);
    }

    private void d() {
        gdtadv.getVresult(319, 0, this);
    }

    static /* synthetic */ f e(b bVar) {
        return (f) gdtadv.getobjresult(320, 1, bVar);
    }

    private void e() {
        gdtadv.getVresult(321, 0, this);
    }

    private a f() {
        return (a) gdtadv.getobjresult(322, 0, this);
    }

    private a g() {
        return (a) gdtadv.getobjresult(323, 0, this);
    }

    private a h() {
        return (a) gdtadv.getobjresult(324, 0, this);
    }

    private boolean i() {
        return gdtadv.getZresult(325, 0, this);
    }

    private com.qq.e.comm.plugin.a.c j() {
        return (com.qq.e.comm.plugin.a.c) gdtadv.getobjresult(326, 0, this);
    }

    @Override // com.qq.e.comm.plugin.c.a.b
    public void a() {
        gdtadv.getVresult(327, 0, this);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar) {
        return gdtadv.getZresult(328, 0, this, fVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        return gdtadv.getZresult(329, 0, this, fVar, aVar);
    }

    @Override // com.qq.e.comm.plugin.c.a.b
    public void b() {
        gdtadv.getVresult(330, 0, this);
    }

    @Override // com.qq.e.comm.plugin.c.a.b
    public void c() {
        gdtadv.getVresult(331, 0, this);
    }
}
