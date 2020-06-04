package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class gz implements ap.b.a {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fs f416a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f417a;

    /* renamed from: a  reason: collision with other field name */
    private ap.b f418a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f420a = false;

    /* renamed from: a  reason: collision with other field name */
    private ap.c f419a = ap.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gz(XMPushService xMPushService, ap.b bVar) {
        this.f417a = xMPushService;
        this.f418a = bVar;
    }

    private void b() {
        this.f418a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f420a && this.a != 11) {
            fi m333a = he.m331a().m333a();
            switch (hb.a[this.f419a.ordinal()]) {
                case 1:
                    if (this.a != 17) {
                        if (this.a != 21) {
                            try {
                                hc.a c = hc.c(he.a().a());
                                m333a.f323a = c.a.a();
                                m333a.c(c.f421a);
                                break;
                            } catch (NullPointerException e) {
                                m333a = null;
                                break;
                            }
                        } else {
                            m333a.f323a = fh.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m333a.f323a = fh.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m333a.f323a = fh.BIND_SUCCESS.a();
                    break;
            }
            if (m333a != null) {
                m333a.b(this.f416a.m291a());
                m333a.d(this.f418a.f861b);
                m333a.f326b = 1;
                try {
                    m333a.a((byte) Integer.parseInt(this.f418a.g));
                } catch (NumberFormatException e2) {
                }
                he.m331a().a(m333a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f418a.a(this);
        this.f416a = this.f417a.m516a();
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        if (!this.f420a && cVar == ap.c.binding) {
            this.f419a = cVar2;
            this.a = i;
            this.f420a = true;
        }
        this.f417a.a(new ha(this, 4));
    }
}
