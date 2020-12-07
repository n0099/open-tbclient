package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class gz implements ap.b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f4710a;

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
        if (this.f422a && this.f4710a != 11) {
            fi m329a = he.m327a().m329a();
            switch (hb.f4713a[this.f421a.ordinal()]) {
                case 1:
                    if (this.f4710a != 17) {
                        if (this.f4710a != 21) {
                            try {
                                hc.a c = hc.c(he.a().a());
                                m329a.f325a = c.f4714a.a();
                                m329a.c(c.f423a);
                                break;
                            } catch (NullPointerException e) {
                                m329a = null;
                                break;
                            }
                        } else {
                            m329a.f325a = fh.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m329a.f325a = fh.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m329a.f325a = fh.BIND_SUCCESS.a();
                    break;
            }
            if (m329a != null) {
                m329a.b(this.f418a.m287a());
                m329a.d(this.f420a.f863b);
                m329a.f328b = 1;
                try {
                    m329a.a((byte) Integer.parseInt(this.f420a.g));
                } catch (NumberFormatException e2) {
                }
                he.m327a().a(m329a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f420a.a(this);
        this.f418a = this.f419a.m512a();
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        if (!this.f422a && cVar == ap.c.binding) {
            this.f421a = cVar2;
            this.f4710a = i;
            this.f422a = true;
        }
        this.f419a.a(new ha(this, 4));
    }
}
