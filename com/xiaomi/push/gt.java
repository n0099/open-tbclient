package com.xiaomi.push;

import com.xiaomi.push.gw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.al;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class gt implements al.b.a {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fm f430a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f431a;

    /* renamed from: a  reason: collision with other field name */
    private al.b f432a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f434a = false;

    /* renamed from: a  reason: collision with other field name */
    private al.c f433a = al.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gt(XMPushService xMPushService, al.b bVar) {
        this.f431a = xMPushService;
        this.f432a = bVar;
    }

    private void b() {
        this.f432a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f434a && this.a != 11) {
            fc m323a = gy.m321a().m323a();
            switch (gv.a[this.f433a.ordinal()]) {
                case 1:
                    if (this.a != 17) {
                        if (this.a != 21) {
                            try {
                                gw.a c = gw.c(gy.a().a());
                                m323a.f337a = c.a.a();
                                m323a.c(c.f435a);
                                break;
                            } catch (NullPointerException e) {
                                m323a = null;
                                break;
                            }
                        } else {
                            m323a.f337a = fb.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m323a.f337a = fb.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m323a.f337a = fb.BIND_SUCCESS.a();
                    break;
            }
            if (m323a != null) {
                m323a.b(this.f430a.m281a());
                m323a.d(this.f432a.f863b);
                m323a.f340b = 1;
                try {
                    m323a.a((byte) Integer.parseInt(this.f432a.g));
                } catch (NumberFormatException e2) {
                }
                gy.m321a().a(m323a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f432a.a(this);
        this.f430a = this.f431a.m497a();
    }

    @Override // com.xiaomi.push.service.al.b.a
    public void a(al.c cVar, al.c cVar2, int i) {
        if (!this.f434a && cVar == al.c.binding) {
            this.f433a = cVar2;
            this.a = i;
            this.f434a = true;
        }
        this.f431a.a(new gu(this, 4));
    }
}
