package com.xiaomi.stats;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ak;
import com.xiaomi.stats.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a implements ak.b.a {
    private XMPushService a;
    private ak.b b;
    private com.xiaomi.smack.a c;
    private int e;
    private boolean f = false;
    private ak.c d = ak.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(XMPushService xMPushService, ak.b bVar) {
        this.a = xMPushService;
        this.b = bVar;
    }

    private void b() {
        this.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f && this.e != 11) {
            com.xiaomi.push.thrift.b f = f.a().f();
            switch (c.a[this.d.ordinal()]) {
                case 1:
                    if (this.e != 17) {
                        if (this.e != 21) {
                            try {
                                d.a c = d.c(f.b().a());
                                f.b = c.a.a();
                                f.c(c.b);
                                break;
                            } catch (NullPointerException e) {
                                f = null;
                                break;
                            }
                        } else {
                            f.b = com.xiaomi.push.thrift.a.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        f.b = com.xiaomi.push.thrift.a.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    f.b = com.xiaomi.push.thrift.a.BIND_SUCCESS.a();
                    break;
            }
            if (f != null) {
                f.b(this.c.d());
                f.d(this.b.b);
                f.c = 1;
                try {
                    f.a((byte) Integer.parseInt(this.b.h));
                } catch (NumberFormatException e2) {
                }
                f.a().a(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.b.a(this);
        this.c = this.a.h();
    }

    @Override // com.xiaomi.push.service.ak.b.a
    public void a(ak.c cVar, ak.c cVar2, int i) {
        if (!this.f && cVar == ak.c.binding) {
            this.d = cVar2;
            this.e = i;
            this.f = true;
        }
        this.a.a(new b(this, 4));
    }
}
