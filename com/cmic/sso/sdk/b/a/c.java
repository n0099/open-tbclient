package com.cmic.sso.sdk.b.a;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public b f30654a;

    /* renamed from: b  reason: collision with root package name */
    public com.cmic.sso.sdk.b.d.c f30655b;

    /* renamed from: c  reason: collision with root package name */
    public final com.cmic.sso.sdk.b.a f30656c = new com.cmic.sso.sdk.b.a();

    public void b(final com.cmic.sso.sdk.b.c.c cVar, final com.cmic.sso.sdk.b.d.c cVar2, final com.cmic.sso.sdk.a aVar) {
        if (this.f30654a != null) {
            this.f30655b = new com.cmic.sso.sdk.b.d.c() { // from class: com.cmic.sso.sdk.b.a.c.1
                @Override // com.cmic.sso.sdk.b.d.c
                public void a(com.cmic.sso.sdk.b.d.b bVar) {
                    if (bVar.d()) {
                        c.this.b(c.this.f30656c.a(cVar, bVar, aVar), cVar2, aVar);
                    } else if (!TextUtils.isEmpty(c.this.f30656c.a())) {
                        c.this.b(c.this.f30656c.b(cVar, bVar, aVar), cVar2, aVar);
                    } else {
                        cVar2.a(bVar);
                    }
                }

                @Override // com.cmic.sso.sdk.b.d.c
                public void a(com.cmic.sso.sdk.b.d.a aVar2) {
                    if (cVar.j()) {
                        com.cmic.sso.sdk.d.c.a("RetryAndRedirectInterceptor", "retry: " + cVar.a());
                        c.this.b(cVar, cVar2, aVar);
                        return;
                    }
                    cVar2.a(aVar2);
                }
            };
            if (cVar.g()) {
                this.f30654a.a(cVar, this.f30655b, aVar);
            } else {
                cVar2.a(com.cmic.sso.sdk.b.d.a.a(200025));
            }
        }
    }

    @Override // com.cmic.sso.sdk.b.a.b
    public void a(com.cmic.sso.sdk.b.c.c cVar, com.cmic.sso.sdk.b.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        b(cVar, cVar2, aVar);
    }

    public void a(b bVar) {
        this.f30654a = bVar;
    }
}
