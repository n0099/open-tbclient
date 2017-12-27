package com.meizu.cloud.pushsdk.a.f;

import com.meizu.cloud.pushsdk.a.d.k;
/* loaded from: classes2.dex */
public class c implements Runnable {
    public final int a;
    public final com.meizu.cloud.pushsdk.a.a.b b;
    private final com.meizu.cloud.pushsdk.a.a.d c;

    public c(com.meizu.cloud.pushsdk.a.a.b bVar) {
        this.b = bVar;
        this.a = bVar.f();
        this.c = bVar.d();
    }

    @Override // java.lang.Runnable
    public void run() {
        com.meizu.cloud.pushsdk.a.a.a.a("execution started : " + this.b.toString());
        switch (this.b.h()) {
            case 0:
                b();
                break;
            case 1:
                c();
                break;
            case 2:
                d();
                break;
        }
        com.meizu.cloud.pushsdk.a.a.a.a("execution done : " + this.b.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [100=6] */
    private void b() {
        k kVar = null;
        try {
            try {
                kVar = b.a(this.b);
                if (kVar == null) {
                    a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a()));
                    com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
                } else if (this.b.g() == com.meizu.cloud.pushsdk.a.a.e.OK_HTTP_RESPONSE) {
                    this.b.b(kVar);
                    com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
                } else if (kVar.a() >= 400) {
                    a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a(kVar), this.b, kVar.a()));
                    com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
                } else {
                    com.meizu.cloud.pushsdk.a.a.c a = this.b.a(kVar);
                    if (a.b()) {
                        a.a(kVar);
                        this.b.a(a);
                        com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
                    } else {
                        a(this.b, a.c());
                        com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
                    }
                }
            } catch (Exception e) {
                a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a(e)));
                com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
            }
        } catch (Throwable th) {
            com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
            throw th;
        }
    }

    private void c() {
        try {
            k b = b.b(this.b);
            if (b == null) {
                a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a()));
            } else if (b.a() >= 400) {
                a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a(b), this.b, b.a()));
            } else {
                this.b.j();
            }
        } catch (Exception e) {
            a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a(e)));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [153=6] */
    private void d() {
        k kVar = null;
        try {
            try {
                kVar = b.c(this.b);
                if (kVar == null) {
                    a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a()));
                    com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
                } else if (this.b.g() == com.meizu.cloud.pushsdk.a.a.e.OK_HTTP_RESPONSE) {
                    this.b.b(kVar);
                    com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
                } else if (kVar.a() >= 400) {
                    a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a(kVar), this.b, kVar.a()));
                    com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
                } else {
                    com.meizu.cloud.pushsdk.a.a.c a = this.b.a(kVar);
                    if (a.b()) {
                        a.a(kVar);
                        this.b.a(a);
                        com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
                    } else {
                        a(this.b, a.c());
                        com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
                    }
                }
            } catch (Exception e) {
                a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a(e)));
                com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
            }
        } catch (Throwable th) {
            com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
            throw th;
        }
    }

    public com.meizu.cloud.pushsdk.a.a.d a() {
        return this.c;
    }

    private void a(final com.meizu.cloud.pushsdk.a.a.b bVar, final com.meizu.cloud.pushsdk.a.c.a aVar) {
        com.meizu.cloud.pushsdk.a.b.b.a().b().c().execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.a.f.c.1
            @Override // java.lang.Runnable
            public void run() {
                bVar.b(aVar);
                bVar.p();
            }
        });
    }
}
