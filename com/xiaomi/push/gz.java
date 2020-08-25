package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class gz implements ap.b.a {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fs f419a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f420a;

    /* renamed from: a  reason: collision with other field name */
    private ap.b f421a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f423a = false;

    /* renamed from: a  reason: collision with other field name */
    private ap.c f422a = ap.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gz(XMPushService xMPushService, ap.b bVar) {
        this.f420a = xMPushService;
        this.f421a = bVar;
    }

    private void b() {
        this.f421a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f423a && this.a != 11) {
            fi m336a = he.m334a().m336a();
            switch (hb.a[this.f422a.ordinal()]) {
                case 1:
                    if (this.a != 17) {
                        if (this.a != 21) {
                            try {
                                hc.a c = hc.c(he.a().a());
                                m336a.f326a = c.a.a();
                                m336a.c(c.f424a);
                                break;
                            } catch (NullPointerException e) {
                                m336a = null;
                                break;
                            }
                        } else {
                            m336a.f326a = fh.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m336a.f326a = fh.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m336a.f326a = fh.BIND_SUCCESS.a();
                    break;
            }
            if (m336a != null) {
                m336a.b(this.f419a.m294a());
                m336a.d(this.f421a.f864b);
                m336a.f329b = 1;
                try {
                    m336a.a((byte) Integer.parseInt(this.f421a.g));
                } catch (NumberFormatException e2) {
                }
                he.m334a().a(m336a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f421a.a(this);
        this.f419a = this.f420a.m519a();
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        if (!this.f423a && cVar == ap.c.binding) {
            this.f422a = cVar2;
            this.a = i;
            this.f423a = true;
        }
        this.f420a.a(new ha(this, 4));
    }
}
