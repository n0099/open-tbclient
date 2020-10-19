package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class gz implements ap.b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f4940a;

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
        if (this.f422a && this.f4940a != 11) {
            fi m337a = he.m335a().m337a();
            switch (hb.f4943a[this.f421a.ordinal()]) {
                case 1:
                    if (this.f4940a != 17) {
                        if (this.f4940a != 21) {
                            try {
                                hc.a c = hc.c(he.a().a());
                                m337a.f325a = c.f4944a.a();
                                m337a.c(c.f423a);
                                break;
                            } catch (NullPointerException e) {
                                m337a = null;
                                break;
                            }
                        } else {
                            m337a.f325a = fh.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m337a.f325a = fh.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m337a.f325a = fh.BIND_SUCCESS.a();
                    break;
            }
            if (m337a != null) {
                m337a.b(this.f418a.m295a());
                m337a.d(this.f420a.f863b);
                m337a.f328b = 1;
                try {
                    m337a.a((byte) Integer.parseInt(this.f420a.g));
                } catch (NumberFormatException e2) {
                }
                he.m335a().a(m337a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f420a.a(this);
        this.f418a = this.f419a.m520a();
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        if (!this.f422a && cVar == ap.c.binding) {
            this.f421a = cVar2;
            this.f4940a = i;
            this.f422a = true;
        }
        this.f419a.a(new ha(this, 4));
    }
}
