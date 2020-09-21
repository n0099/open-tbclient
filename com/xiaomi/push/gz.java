package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class gz implements ap.b.a {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fs f417a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f418a;

    /* renamed from: a  reason: collision with other field name */
    private ap.b f419a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f421a = false;

    /* renamed from: a  reason: collision with other field name */
    private ap.c f420a = ap.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gz(XMPushService xMPushService, ap.b bVar) {
        this.f418a = xMPushService;
        this.f419a = bVar;
    }

    private void b() {
        this.f419a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f421a && this.a != 11) {
            fi m336a = he.m334a().m336a();
            switch (hb.a[this.f420a.ordinal()]) {
                case 1:
                    if (this.a != 17) {
                        if (this.a != 21) {
                            try {
                                hc.a c = hc.c(he.a().a());
                                m336a.f324a = c.a.a();
                                m336a.c(c.f422a);
                                break;
                            } catch (NullPointerException e) {
                                m336a = null;
                                break;
                            }
                        } else {
                            m336a.f324a = fh.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m336a.f324a = fh.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m336a.f324a = fh.BIND_SUCCESS.a();
                    break;
            }
            if (m336a != null) {
                m336a.b(this.f417a.m294a());
                m336a.d(this.f419a.f862b);
                m336a.f327b = 1;
                try {
                    m336a.a((byte) Integer.parseInt(this.f419a.g));
                } catch (NumberFormatException e2) {
                }
                he.m334a().a(m336a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f419a.a(this);
        this.f417a = this.f418a.m519a();
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        if (!this.f421a && cVar == ap.c.binding) {
            this.f420a = cVar2;
            this.a = i;
            this.f421a = true;
        }
        this.f418a.a(new ha(this, 4));
    }
}
