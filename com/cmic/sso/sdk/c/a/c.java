package com.cmic.sso.sdk.c.a;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class c implements b {
    private b niI;
    private com.cmic.sso.sdk.c.d.c niJ;
    private com.cmic.sso.sdk.c.a niK = new com.cmic.sso.sdk.c.a();

    @Override // com.cmic.sso.sdk.c.a.b
    public void a(com.cmic.sso.sdk.c.c.c cVar, com.cmic.sso.sdk.c.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        b(cVar, cVar2, aVar);
    }

    public void a(b bVar) {
        this.niI = bVar;
    }

    public void b(final com.cmic.sso.sdk.c.c.c cVar, final com.cmic.sso.sdk.c.d.c cVar2, final com.cmic.sso.sdk.a aVar) {
        if (this.niI != null) {
            this.niJ = new com.cmic.sso.sdk.c.d.c() { // from class: com.cmic.sso.sdk.c.a.c.1
                @Override // com.cmic.sso.sdk.c.d.c
                public void a(com.cmic.sso.sdk.c.d.b bVar) {
                    if (bVar.d()) {
                        c.this.b(c.this.niK.a(cVar, bVar, aVar), c.this.niJ, aVar);
                    } else if (!TextUtils.isEmpty(c.this.niK.a())) {
                        c.this.b(c.this.niK.b(cVar, bVar, aVar), c.this.niJ, aVar);
                    } else {
                        cVar2.a(bVar);
                    }
                }

                @Override // com.cmic.sso.sdk.c.d.c
                public void a(com.cmic.sso.sdk.c.d.a aVar2) {
                    if (cVar.j()) {
                        com.cmic.sso.sdk.e.c.a("RetryAndRedirectInterceptor", "retry");
                        c.this.b(cVar, cVar2, aVar);
                        return;
                    }
                    cVar2.a(aVar2);
                }
            };
            if (cVar.g()) {
                this.niI.a(cVar, this.niJ, aVar);
            } else {
                cVar2.a(com.cmic.sso.sdk.c.d.a.KM(200025));
            }
        }
    }
}
