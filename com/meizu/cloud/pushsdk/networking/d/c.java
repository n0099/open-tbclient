package com.meizu.cloud.pushsdk.networking.d;

import com.meizu.cloud.pushsdk.networking.b.k;
import com.meizu.cloud.pushsdk.networking.common.Priority;
import com.meizu.cloud.pushsdk.networking.common.ResponseType;
import com.meizu.cloud.pushsdk.networking.error.ANError;
/* loaded from: classes3.dex */
public class c implements Runnable {
    public final int a;
    public final com.meizu.cloud.pushsdk.networking.common.b b;
    private final Priority c;

    public c(com.meizu.cloud.pushsdk.networking.common.b bVar) {
        this.b = bVar;
        this.a = bVar.f();
        this.c = bVar.d();
    }

    @Override // java.lang.Runnable
    public void run() {
        com.meizu.cloud.pushsdk.networking.common.a.a("execution started : " + this.b.toString());
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
        com.meizu.cloud.pushsdk.networking.common.a.a("execution done : " + this.b.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [100=6] */
    private void b() {
        k kVar = null;
        try {
            try {
                kVar = b.a(this.b);
                if (kVar == null) {
                    a(this.b, com.meizu.cloud.pushsdk.networking.e.b.a(new ANError()));
                    com.meizu.cloud.pushsdk.networking.e.a.a(kVar, this.b);
                } else if (this.b.g() == ResponseType.OK_HTTP_RESPONSE) {
                    this.b.b(kVar);
                    com.meizu.cloud.pushsdk.networking.e.a.a(kVar, this.b);
                } else if (kVar.a() >= 400) {
                    a(this.b, com.meizu.cloud.pushsdk.networking.e.b.a(new ANError(kVar), this.b, kVar.a()));
                    com.meizu.cloud.pushsdk.networking.e.a.a(kVar, this.b);
                } else {
                    com.meizu.cloud.pushsdk.networking.common.c a = this.b.a(kVar);
                    if (a.b()) {
                        a.a(kVar);
                        this.b.a(a);
                        com.meizu.cloud.pushsdk.networking.e.a.a(kVar, this.b);
                    } else {
                        a(this.b, a.c());
                        com.meizu.cloud.pushsdk.networking.e.a.a(kVar, this.b);
                    }
                }
            } catch (Exception e) {
                a(this.b, com.meizu.cloud.pushsdk.networking.e.b.a(new ANError(e)));
                com.meizu.cloud.pushsdk.networking.e.a.a(kVar, this.b);
            }
        } catch (Throwable th) {
            com.meizu.cloud.pushsdk.networking.e.a.a(kVar, this.b);
            throw th;
        }
    }

    private void c() {
        try {
            k b = b.b(this.b);
            if (b == null) {
                a(this.b, com.meizu.cloud.pushsdk.networking.e.b.a(new ANError()));
            } else if (b.a() >= 400) {
                a(this.b, com.meizu.cloud.pushsdk.networking.e.b.a(new ANError(b), this.b, b.a()));
            } else {
                this.b.j();
            }
        } catch (Exception e) {
            a(this.b, com.meizu.cloud.pushsdk.networking.e.b.a(new ANError(e)));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [153=6] */
    private void d() {
        k kVar = null;
        try {
            try {
                kVar = b.c(this.b);
                if (kVar == null) {
                    a(this.b, com.meizu.cloud.pushsdk.networking.e.b.a(new ANError()));
                    com.meizu.cloud.pushsdk.networking.e.a.a(kVar, this.b);
                } else if (this.b.g() == ResponseType.OK_HTTP_RESPONSE) {
                    this.b.b(kVar);
                    com.meizu.cloud.pushsdk.networking.e.a.a(kVar, this.b);
                } else if (kVar.a() >= 400) {
                    a(this.b, com.meizu.cloud.pushsdk.networking.e.b.a(new ANError(kVar), this.b, kVar.a()));
                    com.meizu.cloud.pushsdk.networking.e.a.a(kVar, this.b);
                } else {
                    com.meizu.cloud.pushsdk.networking.common.c a = this.b.a(kVar);
                    if (a.b()) {
                        a.a(kVar);
                        this.b.a(a);
                        com.meizu.cloud.pushsdk.networking.e.a.a(kVar, this.b);
                    } else {
                        a(this.b, a.c());
                        com.meizu.cloud.pushsdk.networking.e.a.a(kVar, this.b);
                    }
                }
            } catch (Exception e) {
                a(this.b, com.meizu.cloud.pushsdk.networking.e.b.a(new ANError(e)));
                com.meizu.cloud.pushsdk.networking.e.a.a(kVar, this.b);
            }
        } catch (Throwable th) {
            com.meizu.cloud.pushsdk.networking.e.a.a(kVar, this.b);
            throw th;
        }
    }

    public Priority a() {
        return this.c;
    }

    private void a(final com.meizu.cloud.pushsdk.networking.common.b bVar, final ANError aNError) {
        com.meizu.cloud.pushsdk.networking.a.b.a().b().c().execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.networking.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                bVar.b(aNError);
                bVar.p();
            }
        });
    }
}
