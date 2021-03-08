package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class gz implements ap.b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f8403a;

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
        if (this.f421a && this.f8403a != 11) {
            fi m340a = he.m338a().m340a();
            switch (hb.f8406a[this.f420a.ordinal()]) {
                case 1:
                    if (this.f8403a != 17) {
                        if (this.f8403a != 21) {
                            try {
                                hc.a c = hc.c(he.a().a());
                                m340a.f324a = c.f8407a.a();
                                m340a.c(c.f422a);
                                break;
                            } catch (NullPointerException e) {
                                m340a = null;
                                break;
                            }
                        } else {
                            m340a.f324a = fh.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m340a.f324a = fh.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m340a.f324a = fh.BIND_SUCCESS.a();
                    break;
            }
            if (m340a != null) {
                m340a.b(this.f417a.m298a());
                m340a.d(this.f419a.f862b);
                m340a.f327b = 1;
                try {
                    m340a.a((byte) Integer.parseInt(this.f419a.g));
                } catch (NumberFormatException e2) {
                }
                he.m338a().a(m340a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f419a.a(this);
        this.f417a = this.f418a.m523a();
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        if (!this.f421a && cVar == ap.c.binding) {
            this.f420a = cVar2;
            this.f8403a = i;
            this.f421a = true;
        }
        this.f418a.a(new ha(this, 4));
    }
}
