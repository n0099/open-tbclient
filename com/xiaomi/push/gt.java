package com.xiaomi.push;

import com.xiaomi.push.gw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.al;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class gt implements al.b.a {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fm f434a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f435a;

    /* renamed from: a  reason: collision with other field name */
    private al.b f436a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f438a = false;

    /* renamed from: a  reason: collision with other field name */
    private al.c f437a = al.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gt(XMPushService xMPushService, al.b bVar) {
        this.f435a = xMPushService;
        this.f436a = bVar;
    }

    private void b() {
        this.f436a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f438a && this.a != 11) {
            fc m320a = gy.m318a().m320a();
            switch (gv.a[this.f437a.ordinal()]) {
                case 1:
                    if (this.a != 17) {
                        if (this.a != 21) {
                            try {
                                gw.a c = gw.c(gy.a().a());
                                m320a.f341a = c.a.a();
                                m320a.c(c.f439a);
                                break;
                            } catch (NullPointerException e) {
                                m320a = null;
                                break;
                            }
                        } else {
                            m320a.f341a = fb.BIND_TIMEOUT.a();
                            break;
                        }
                    } else {
                        m320a.f341a = fb.BIND_TCP_READ_TIMEOUT.a();
                        break;
                    }
                case 3:
                    m320a.f341a = fb.BIND_SUCCESS.a();
                    break;
            }
            if (m320a != null) {
                m320a.b(this.f434a.m278a());
                m320a.d(this.f436a.f867b);
                m320a.f344b = 1;
                try {
                    m320a.a((byte) Integer.parseInt(this.f436a.g));
                } catch (NumberFormatException e2) {
                }
                gy.m318a().a(m320a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f436a.a(this);
        this.f434a = this.f435a.m494a();
    }

    @Override // com.xiaomi.push.service.al.b.a
    public void a(al.c cVar, al.c cVar2, int i) {
        if (!this.f438a && cVar == al.c.binding) {
            this.f437a = cVar2;
            this.a = i;
            this.f438a = true;
        }
        this.f435a.a(new gu(this, 4));
    }
}
