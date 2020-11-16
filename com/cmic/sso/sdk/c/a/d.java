package com.cmic.sso.sdk.c.a;

import android.net.Network;
import android.os.Build;
import com.cmic.sso.sdk.e.o;
import com.cmic.sso.sdk.e.t;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class d implements b {
    private b oKs;

    @Override // com.cmic.sso.sdk.c.a.b
    public void a(final com.cmic.sso.sdk.c.c.c cVar, final com.cmic.sso.sdk.c.d.c cVar2, final com.cmic.sso.sdk.a aVar) {
        if (!cVar.b()) {
            b(cVar, cVar2, aVar);
            return;
        }
        t gU = t.gU(null);
        if (Build.VERSION.SDK_INT >= 21) {
            gU.a(new t.a() { // from class: com.cmic.sso.sdk.c.a.d.1
                private AtomicBoolean e = new AtomicBoolean(false);

                @Override // com.cmic.sso.sdk.e.t.a
                public void f(final Network network) {
                    if (!this.e.getAndSet(true) && network != null) {
                        o.a(new o.a(null, aVar) { // from class: com.cmic.sso.sdk.c.a.d.1.1
                            @Override // com.cmic.sso.sdk.e.o.a
                            protected void a() {
                                com.cmic.sso.sdk.e.c.b("WifiChangeInterceptor", "onAvailable");
                                cVar.f(network);
                                d.this.b(cVar, cVar2, aVar);
                            }
                        });
                    }
                }
            });
        } else if (gU.a(cVar.a())) {
            com.cmic.sso.sdk.e.c.b("WifiChangeInterceptor", "切换网络成功");
            b(cVar, cVar2, aVar);
        } else {
            com.cmic.sso.sdk.e.c.a("WifiChangeInterceptor", "切换网络失败or无数据网络");
            cVar2.a(com.cmic.sso.sdk.c.d.a.OM(102508));
        }
    }

    public void b(com.cmic.sso.sdk.c.c.c cVar, final com.cmic.sso.sdk.c.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        if (this.oKs != null) {
            this.oKs.a(cVar, new com.cmic.sso.sdk.c.d.c() { // from class: com.cmic.sso.sdk.c.a.d.2
                @Override // com.cmic.sso.sdk.c.d.c
                public void a(com.cmic.sso.sdk.c.d.b bVar) {
                    cVar2.a(bVar);
                }

                @Override // com.cmic.sso.sdk.c.d.c
                public void a(com.cmic.sso.sdk.c.d.a aVar2) {
                    cVar2.a(aVar2);
                }
            }, aVar);
        }
    }

    public void a(b bVar) {
        this.oKs = bVar;
    }
}
