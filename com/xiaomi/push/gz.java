package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class gz implements ap.b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f4938a;

    /* renamed from: a  reason: collision with other field name */
    private fs f415a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f416a;

    /* renamed from: a  reason: collision with other field name */
    private ap.b f417a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f419a = false;

    /* renamed from: a  reason: collision with other field name */
    private ap.c f418a = ap.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gz(XMPushService xMPushService, ap.b bVar) {
        this.f416a = xMPushService;
        this.f417a = bVar;
    }

    private void b() {
        this.f417a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f419a && this.f4938a != 11) {
            fi m336a = he.m334a().m336a();
            switch (hb.f4941a[this.f418a.ordinal()]) {
                case 1:
                    if (this.f4938a != 17) {
                        if (this.f4938a != 21) {
                            try {
                                hc.a c = hc.c(he.a().a());
                                m336a.f322a = c.f4942a.a();
                                m336a.c(c.f420a);
                                break;
                            } catch (NullPointerException e) {
                                m336a = null;
                                break;
                            }
                        } else {
                            m336a.f322a = fh.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m336a.f322a = fh.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m336a.f322a = fh.BIND_SUCCESS.a();
                    break;
            }
            if (m336a != null) {
                m336a.b(this.f415a.m294a());
                m336a.d(this.f417a.f860b);
                m336a.f325b = 1;
                try {
                    m336a.a((byte) Integer.parseInt(this.f417a.g));
                } catch (NumberFormatException e2) {
                }
                he.m334a().a(m336a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f417a.a(this);
        this.f415a = this.f416a.m519a();
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        if (!this.f419a && cVar == ap.c.binding) {
            this.f418a = cVar2;
            this.f4938a = i;
            this.f419a = true;
        }
        this.f416a.a(new ha(this, 4));
    }
}
