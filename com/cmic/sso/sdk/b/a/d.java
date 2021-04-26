package com.cmic.sso.sdk.b.a;

import android.content.Context;
import android.net.Network;
import android.os.Build;
import com.cmic.sso.sdk.d.o;
import com.cmic.sso.sdk.d.t;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public b f31294a;

    @Override // com.cmic.sso.sdk.b.a.b
    public void a(final com.cmic.sso.sdk.b.c.c cVar, final com.cmic.sso.sdk.b.d.c cVar2, final com.cmic.sso.sdk.a aVar) {
        if (!cVar.b()) {
            b(cVar, cVar2, aVar);
            return;
        }
        t a2 = t.a((Context) null);
        if (Build.VERSION.SDK_INT >= 21) {
            a2.a(new t.a() { // from class: com.cmic.sso.sdk.b.a.d.1

                /* renamed from: e  reason: collision with root package name */
                public AtomicBoolean f31299e = new AtomicBoolean(false);

                @Override // com.cmic.sso.sdk.d.t.a
                public void a(final Network network) {
                    if (this.f31299e.getAndSet(true) || network == null) {
                        return;
                    }
                    o.a(new o.a(null, aVar) { // from class: com.cmic.sso.sdk.b.a.d.1.1
                        @Override // com.cmic.sso.sdk.d.o.a
                        public void a() {
                            com.cmic.sso.sdk.d.c.b("WifiChangeInterceptor", "onAvailable");
                            cVar.a(network);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            d.this.b(cVar, cVar2, aVar);
                        }
                    });
                }
            });
        } else if (a2.a(cVar.a())) {
            com.cmic.sso.sdk.d.c.b("WifiChangeInterceptor", "切换网络成功");
            b(cVar, cVar2, aVar);
        } else {
            com.cmic.sso.sdk.d.c.a("WifiChangeInterceptor", "切换网络失败or无数据网络");
            cVar2.a(com.cmic.sso.sdk.b.d.a.a(102508));
        }
    }

    public void b(com.cmic.sso.sdk.b.c.c cVar, final com.cmic.sso.sdk.b.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        b bVar = this.f31294a;
        if (bVar != null) {
            bVar.a(cVar, new com.cmic.sso.sdk.b.d.c() { // from class: com.cmic.sso.sdk.b.a.d.2
                @Override // com.cmic.sso.sdk.b.d.c
                public void a(com.cmic.sso.sdk.b.d.b bVar2) {
                    cVar2.a(bVar2);
                }

                @Override // com.cmic.sso.sdk.b.d.c
                public void a(com.cmic.sso.sdk.b.d.a aVar2) {
                    cVar2.a(aVar2);
                }
            }, aVar);
        }
    }

    public void a(b bVar) {
        this.f31294a = bVar;
    }
}
