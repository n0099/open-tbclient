package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class gz implements ap.b.a {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fs f422a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f423a;

    /* renamed from: a  reason: collision with other field name */
    private ap.b f424a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f426a = false;

    /* renamed from: a  reason: collision with other field name */
    private ap.c f425a = ap.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gz(XMPushService xMPushService, ap.b bVar) {
        this.f423a = xMPushService;
        this.f424a = bVar;
    }

    private void b() {
        this.f424a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f426a && this.a != 11) {
            fi m331a = he.m329a().m331a();
            switch (hb.a[this.f425a.ordinal()]) {
                case 1:
                    if (this.a != 17) {
                        if (this.a != 21) {
                            try {
                                hc.a c = hc.c(he.a().a());
                                m331a.f329a = c.a.a();
                                m331a.c(c.f427a);
                                break;
                            } catch (NullPointerException e) {
                                m331a = null;
                                break;
                            }
                        } else {
                            m331a.f329a = fh.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m331a.f329a = fh.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m331a.f329a = fh.BIND_SUCCESS.a();
                    break;
            }
            if (m331a != null) {
                m331a.b(this.f422a.m289a());
                m331a.d(this.f424a.f867b);
                m331a.f332b = 1;
                try {
                    m331a.a((byte) Integer.parseInt(this.f424a.g));
                } catch (NumberFormatException e2) {
                }
                he.m329a().a(m331a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f424a.a(this);
        this.f422a = this.f423a.m514a();
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        if (!this.f426a && cVar == ap.c.binding) {
            this.f425a = cVar2;
            this.a = i;
            this.f426a = true;
        }
        this.f423a.a(new ha(this, 4));
    }
}
