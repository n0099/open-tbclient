package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class gz implements ap.b.a {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fs f423a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f424a;

    /* renamed from: a  reason: collision with other field name */
    private ap.b f425a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f427a = false;

    /* renamed from: a  reason: collision with other field name */
    private ap.c f426a = ap.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gz(XMPushService xMPushService, ap.b bVar) {
        this.f424a = xMPushService;
        this.f425a = bVar;
    }

    private void b() {
        this.f425a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f427a && this.a != 11) {
            fi m330a = he.m328a().m330a();
            switch (hb.a[this.f426a.ordinal()]) {
                case 1:
                    if (this.a != 17) {
                        if (this.a != 21) {
                            try {
                                hc.a c = hc.c(he.a().a());
                                m330a.f330a = c.a.a();
                                m330a.c(c.f428a);
                                break;
                            } catch (NullPointerException e) {
                                m330a = null;
                                break;
                            }
                        } else {
                            m330a.f330a = fh.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m330a.f330a = fh.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m330a.f330a = fh.BIND_SUCCESS.a();
                    break;
            }
            if (m330a != null) {
                m330a.b(this.f423a.m288a());
                m330a.d(this.f425a.f868b);
                m330a.f333b = 1;
                try {
                    m330a.a((byte) Integer.parseInt(this.f425a.g));
                } catch (NumberFormatException e2) {
                }
                he.m328a().a(m330a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f425a.a(this);
        this.f423a = this.f424a.m513a();
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        if (!this.f427a && cVar == ap.c.binding) {
            this.f426a = cVar2;
            this.a = i;
            this.f427a = true;
        }
        this.f424a.a(new ha(this, 4));
    }
}
