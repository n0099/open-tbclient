package com.xiaomi.push;

import com.xiaomi.push.fe;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
/* loaded from: classes10.dex */
public class fb implements bg.b.a {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public fv f356a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f357a;

    /* renamed from: a  reason: collision with other field name */
    public bg.b f358a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f360a = false;

    /* renamed from: a  reason: collision with other field name */
    public bg.c f359a = bg.c.binding;

    public fb(XMPushService xMPushService, bg.b bVar) {
        this.f357a = xMPushService;
        this.f358a = bVar;
    }

    private void b() {
        this.f358a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        ey eyVar;
        b();
        if (!this.f360a || this.a == 11) {
            return;
        }
        ez m477a = fg.m475a().m477a();
        int i = fd.a[this.f359a.ordinal()];
        if (i != 1) {
            if (i == 3) {
                eyVar = ey.BIND_SUCCESS;
            }
            if (m477a != null) {
                m477a.b(this.f356a.mo504a());
                m477a.d(this.f358a.f939b);
                m477a.f345b = 1;
                try {
                    m477a.a((byte) Integer.parseInt(this.f358a.g));
                } catch (NumberFormatException unused) {
                }
                fg.m475a().a(m477a);
                return;
            }
            return;
        }
        int i2 = this.a;
        if (i2 == 17) {
            eyVar = ey.BIND_TCP_READ_TIMEOUT;
        } else if (i2 == 21) {
            eyVar = ey.BIND_TIMEOUT;
        } else {
            try {
                fe.a c = fe.c(fg.a().a());
                m477a.f342a = c.a.a();
                m477a.c(c.f361a);
            } catch (NullPointerException unused2) {
                m477a = null;
            }
            if (m477a != null) {
            }
        }
        m477a.f342a = eyVar.a();
        if (m477a != null) {
        }
    }

    public void a() {
        this.f358a.a(this);
        this.f356a = this.f357a.m745a();
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public void a(bg.c cVar, bg.c cVar2, int i) {
        if (!this.f360a && cVar == bg.c.binding) {
            this.f359a = cVar2;
            this.a = i;
            this.f360a = true;
        }
        this.f357a.a(new fc(this, 4));
    }
}
