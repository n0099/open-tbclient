package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class gz implements ap.b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f14076a;

    /* renamed from: a  reason: collision with other field name */
    private fs f496a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f497a;

    /* renamed from: a  reason: collision with other field name */
    private ap.b f498a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f500a = false;

    /* renamed from: a  reason: collision with other field name */
    private ap.c f499a = ap.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gz(XMPushService xMPushService, ap.b bVar) {
        this.f497a = xMPushService;
        this.f498a = bVar;
    }

    private void b() {
        this.f498a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f500a && this.f14076a != 11) {
            fi m362a = he.m360a().m362a();
            switch (hb.f14079a[this.f499a.ordinal()]) {
                case 1:
                    if (this.f14076a != 17) {
                        if (this.f14076a != 21) {
                            try {
                                hc.a c = hc.c(he.a().a());
                                m362a.f403a = c.f14080a.a();
                                m362a.c(c.f501a);
                                break;
                            } catch (NullPointerException e) {
                                m362a = null;
                                break;
                            }
                        } else {
                            m362a.f403a = fh.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m362a.f403a = fh.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m362a.f403a = fh.BIND_SUCCESS.a();
                    break;
            }
            if (m362a != null) {
                m362a.b(this.f496a.m320a());
                m362a.d(this.f498a.f941b);
                m362a.f406b = 1;
                try {
                    m362a.a((byte) Integer.parseInt(this.f498a.g));
                } catch (NumberFormatException e2) {
                }
                he.m360a().a(m362a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f498a.a(this);
        this.f496a = this.f497a.m545a();
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        if (!this.f500a && cVar == ap.c.binding) {
            this.f499a = cVar2;
            this.f14076a = i;
            this.f500a = true;
        }
        this.f497a.a(new ha(this, 4));
    }
}
