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
            fi m361a = he.m359a().m361a();
            switch (hb.f14079a[this.f499a.ordinal()]) {
                case 1:
                    if (this.f14076a != 17) {
                        if (this.f14076a != 21) {
                            try {
                                hc.a c = hc.c(he.a().a());
                                m361a.f403a = c.f14080a.a();
                                m361a.c(c.f501a);
                                break;
                            } catch (NullPointerException e) {
                                m361a = null;
                                break;
                            }
                        } else {
                            m361a.f403a = fh.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m361a.f403a = fh.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m361a.f403a = fh.BIND_SUCCESS.a();
                    break;
            }
            if (m361a != null) {
                m361a.b(this.f496a.m319a());
                m361a.d(this.f498a.f941b);
                m361a.f406b = 1;
                try {
                    m361a.a((byte) Integer.parseInt(this.f498a.g));
                } catch (NumberFormatException e2) {
                }
                he.m359a().a(m361a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f498a.a(this);
        this.f496a = this.f497a.m544a();
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
