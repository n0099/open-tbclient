package com.xiaomi.push;

import com.xiaomi.push.fe;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
/* loaded from: classes10.dex */
public class fb implements bg.b.a {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public fv f355a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f356a;

    /* renamed from: a  reason: collision with other field name */
    public bg.b f357a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f359a = false;

    /* renamed from: a  reason: collision with other field name */
    public bg.c f358a = bg.c.binding;

    public fb(XMPushService xMPushService, bg.b bVar) {
        this.f356a = xMPushService;
        this.f357a = bVar;
    }

    private void b() {
        this.f357a.b(this);
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
        if (!this.f359a || this.a == 11) {
            return;
        }
        ez m417a = fg.m415a().m417a();
        int i = fd.a[this.f358a.ordinal()];
        if (i != 1) {
            if (i == 3) {
                eyVar = ey.BIND_SUCCESS;
            }
            if (m417a != null) {
                m417a.b(this.f355a.mo444a());
                m417a.d(this.f357a.f938b);
                m417a.f344b = 1;
                try {
                    m417a.a((byte) Integer.parseInt(this.f357a.g));
                } catch (NumberFormatException unused) {
                }
                fg.m415a().a(m417a);
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
                m417a.f341a = c.a.a();
                m417a.c(c.f360a);
            } catch (NullPointerException unused2) {
                m417a = null;
            }
            if (m417a != null) {
            }
        }
        m417a.f341a = eyVar.a();
        if (m417a != null) {
        }
    }

    public void a() {
        this.f357a.a(this);
        this.f355a = this.f356a.m685a();
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public void a(bg.c cVar, bg.c cVar2, int i) {
        if (!this.f359a && cVar == bg.c.binding) {
            this.f358a = cVar2;
            this.a = i;
            this.f359a = true;
        }
        this.f356a.a(new fc(this, 4));
    }
}
