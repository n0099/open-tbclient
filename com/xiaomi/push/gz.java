package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class gz implements ap.b.a {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fs f418a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f419a;

    /* renamed from: a  reason: collision with other field name */
    private ap.b f420a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f422a = false;

    /* renamed from: a  reason: collision with other field name */
    private ap.c f421a = ap.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gz(XMPushService xMPushService, ap.b bVar) {
        this.f419a = xMPushService;
        this.f420a = bVar;
    }

    private void b() {
        this.f420a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f422a && this.a != 11) {
            fi m336a = he.m334a().m336a();
            switch (hb.a[this.f421a.ordinal()]) {
                case 1:
                    if (this.a != 17) {
                        if (this.a != 21) {
                            try {
                                hc.a c = hc.c(he.a().a());
                                m336a.f325a = c.a.a();
                                m336a.c(c.f423a);
                                break;
                            } catch (NullPointerException e) {
                                m336a = null;
                                break;
                            }
                        } else {
                            m336a.f325a = fh.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m336a.f325a = fh.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m336a.f325a = fh.BIND_SUCCESS.a();
                    break;
            }
            if (m336a != null) {
                m336a.b(this.f418a.m294a());
                m336a.d(this.f420a.f863b);
                m336a.f328b = 1;
                try {
                    m336a.a((byte) Integer.parseInt(this.f420a.g));
                } catch (NumberFormatException e2) {
                }
                he.m334a().a(m336a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f420a.a(this);
        this.f418a = this.f419a.m519a();
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        if (!this.f422a && cVar == ap.c.binding) {
            this.f421a = cVar2;
            this.a = i;
            this.f422a = true;
        }
        this.f419a.a(new ha(this, 4));
    }
}
