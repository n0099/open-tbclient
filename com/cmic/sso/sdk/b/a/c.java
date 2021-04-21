package com.cmic.sso.sdk.b.a;

import android.text.TextUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
/* loaded from: classes5.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public b f30362a;

    /* renamed from: b  reason: collision with root package name */
    public com.cmic.sso.sdk.b.d.c f30363b;

    /* renamed from: c  reason: collision with root package name */
    public com.cmic.sso.sdk.b.a f30364c = new com.cmic.sso.sdk.b.a();

    @Override // com.cmic.sso.sdk.b.a.b
    public void a(com.cmic.sso.sdk.b.c.c cVar, com.cmic.sso.sdk.b.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        b(cVar, cVar2, aVar);
    }

    public void b(final com.cmic.sso.sdk.b.c.c cVar, final com.cmic.sso.sdk.b.d.c cVar2, final com.cmic.sso.sdk.a aVar) {
        if (this.f30362a != null) {
            this.f30363b = new com.cmic.sso.sdk.b.d.c() { // from class: com.cmic.sso.sdk.b.a.c.1
                @Override // com.cmic.sso.sdk.b.d.c
                public void a(com.cmic.sso.sdk.b.d.b bVar) {
                    if (bVar.d()) {
                        com.cmic.sso.sdk.b.c.c a2 = c.this.f30364c.a(cVar, bVar, aVar);
                        c cVar3 = c.this;
                        cVar3.b(a2, cVar3.f30363b, aVar);
                    } else if (!TextUtils.isEmpty(c.this.f30364c.a())) {
                        com.cmic.sso.sdk.b.c.c b2 = c.this.f30364c.b(cVar, bVar, aVar);
                        c cVar4 = c.this;
                        cVar4.b(b2, cVar4.f30363b, aVar);
                    } else {
                        cVar2.a(bVar);
                    }
                }

                @Override // com.cmic.sso.sdk.b.d.c
                public void a(com.cmic.sso.sdk.b.d.a aVar2) {
                    if (cVar.j()) {
                        com.cmic.sso.sdk.d.c.a("RetryAndRedirectInterceptor", HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM);
                        c.this.b(cVar, cVar2, aVar);
                        return;
                    }
                    cVar2.a(aVar2);
                }
            };
            if (cVar.g()) {
                this.f30362a.a(cVar, this.f30363b, aVar);
            } else {
                cVar2.a(com.cmic.sso.sdk.b.d.a.a(200025));
            }
        }
    }

    public void a(b bVar) {
        this.f30362a = bVar;
    }
}
