package com.xiaomi.push;

import com.xiaomi.push.gw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.al;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class gt implements al.b.a {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fm f435a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f436a;

    /* renamed from: a  reason: collision with other field name */
    private al.b f437a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f439a = false;

    /* renamed from: a  reason: collision with other field name */
    private al.c f438a = al.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gt(XMPushService xMPushService, al.b bVar) {
        this.f436a = xMPushService;
        this.f437a = bVar;
    }

    private void b() {
        this.f437a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f439a && this.a != 11) {
            fc m311a = gy.m309a().m311a();
            switch (gv.a[this.f438a.ordinal()]) {
                case 1:
                    if (this.a != 17) {
                        if (this.a != 21) {
                            try {
                                gw.a c = gw.c(gy.a().a());
                                m311a.f342a = c.a.a();
                                m311a.c(c.f440a);
                                break;
                            } catch (NullPointerException e) {
                                m311a = null;
                                break;
                            }
                        } else {
                            m311a.f342a = fb.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m311a.f342a = fb.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m311a.f342a = fb.BIND_SUCCESS.a();
                    break;
            }
            if (m311a != null) {
                m311a.b(this.f435a.m269a());
                m311a.d(this.f437a.f868b);
                m311a.f345b = 1;
                try {
                    m311a.a((byte) Integer.parseInt(this.f437a.g));
                } catch (NumberFormatException e2) {
                }
                gy.m309a().a(m311a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f437a.a(this);
        this.f435a = this.f436a.m485a();
    }

    @Override // com.xiaomi.push.service.al.b.a
    public void a(al.c cVar, al.c cVar2, int i) {
        if (!this.f439a && cVar == al.c.binding) {
            this.f438a = cVar2;
            this.a = i;
            this.f439a = true;
        }
        this.f436a.a(new gu(this, 4));
    }
}
