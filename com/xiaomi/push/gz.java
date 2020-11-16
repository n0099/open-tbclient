package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class gz implements ap.b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f4940a;

    /* renamed from: a  reason: collision with other field name */
    private fs f420a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f421a;

    /* renamed from: a  reason: collision with other field name */
    private ap.b f422a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f424a = false;

    /* renamed from: a  reason: collision with other field name */
    private ap.c f423a = ap.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gz(XMPushService xMPushService, ap.b bVar) {
        this.f421a = xMPushService;
        this.f422a = bVar;
    }

    private void b() {
        this.f422a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f424a && this.f4940a != 11) {
            fi m339a = he.m337a().m339a();
            switch (hb.f4943a[this.f423a.ordinal()]) {
                case 1:
                    if (this.f4940a != 17) {
                        if (this.f4940a != 21) {
                            try {
                                hc.a c = hc.c(he.a().a());
                                m339a.f327a = c.f4944a.a();
                                m339a.c(c.f425a);
                                break;
                            } catch (NullPointerException e) {
                                m339a = null;
                                break;
                            }
                        } else {
                            m339a.f327a = fh.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m339a.f327a = fh.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m339a.f327a = fh.BIND_SUCCESS.a();
                    break;
            }
            if (m339a != null) {
                m339a.b(this.f420a.m297a());
                m339a.d(this.f422a.f865b);
                m339a.f330b = 1;
                try {
                    m339a.a((byte) Integer.parseInt(this.f422a.g));
                } catch (NumberFormatException e2) {
                }
                he.m337a().a(m339a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f422a.a(this);
        this.f420a = this.f421a.m522a();
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        if (!this.f424a && cVar == ap.c.binding) {
            this.f423a = cVar2;
            this.f4940a = i;
            this.f424a = true;
        }
        this.f421a.a(new ha(this, 4));
    }
}
