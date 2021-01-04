package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class gz implements ap.b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f14373a;

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
        if (this.f500a && this.f14373a != 11) {
            fi m355a = he.m353a().m355a();
            switch (hb.f14376a[this.f499a.ordinal()]) {
                case 1:
                    if (this.f14373a != 17) {
                        if (this.f14373a != 21) {
                            try {
                                hc.a c = hc.c(he.a().a());
                                m355a.f403a = c.f14377a.a();
                                m355a.c(c.f501a);
                                break;
                            } catch (NullPointerException e) {
                                m355a = null;
                                break;
                            }
                        } else {
                            m355a.f403a = fh.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m355a.f403a = fh.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m355a.f403a = fh.BIND_SUCCESS.a();
                    break;
            }
            if (m355a != null) {
                m355a.b(this.f496a.m313a());
                m355a.d(this.f498a.f941b);
                m355a.f406b = 1;
                try {
                    m355a.a((byte) Integer.parseInt(this.f498a.g));
                } catch (NumberFormatException e2) {
                }
                he.m353a().a(m355a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f498a.a(this);
        this.f496a = this.f497a.m538a();
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        if (!this.f500a && cVar == ap.c.binding) {
            this.f499a = cVar2;
            this.f14373a = i;
            this.f500a = true;
        }
        this.f497a.a(new ha(this, 4));
    }
}
