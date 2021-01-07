package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class gz implements ap.b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f14374a;

    /* renamed from: a  reason: collision with other field name */
    private fs f497a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f498a;

    /* renamed from: a  reason: collision with other field name */
    private ap.b f499a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f501a = false;

    /* renamed from: a  reason: collision with other field name */
    private ap.c f500a = ap.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gz(XMPushService xMPushService, ap.b bVar) {
        this.f498a = xMPushService;
        this.f499a = bVar;
    }

    private void b() {
        this.f499a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f501a && this.f14374a != 11) {
            fi m366a = he.m364a().m366a();
            switch (hb.f14377a[this.f500a.ordinal()]) {
                case 1:
                    if (this.f14374a != 17) {
                        if (this.f14374a != 21) {
                            try {
                                hc.a c = hc.c(he.a().a());
                                m366a.f404a = c.f14378a.a();
                                m366a.c(c.f502a);
                                break;
                            } catch (NullPointerException e) {
                                m366a = null;
                                break;
                            }
                        } else {
                            m366a.f404a = fh.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m366a.f404a = fh.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m366a.f404a = fh.BIND_SUCCESS.a();
                    break;
            }
            if (m366a != null) {
                m366a.b(this.f497a.m324a());
                m366a.d(this.f499a.f942b);
                m366a.f407b = 1;
                try {
                    m366a.a((byte) Integer.parseInt(this.f499a.g));
                } catch (NumberFormatException e2) {
                }
                he.m364a().a(m366a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f499a.a(this);
        this.f497a = this.f498a.m549a();
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        if (!this.f501a && cVar == ap.c.binding) {
            this.f500a = cVar2;
            this.f14374a = i;
            this.f501a = true;
        }
        this.f498a.a(new ha(this, 4));
    }
}
