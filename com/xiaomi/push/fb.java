package com.xiaomi.push;

import com.xiaomi.push.fe;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
/* loaded from: classes10.dex */
public class fb implements bg.b.a {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public fv f351a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f352a;

    /* renamed from: a  reason: collision with other field name */
    public bg.b f353a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f355a = false;

    /* renamed from: a  reason: collision with other field name */
    public bg.c f354a = bg.c.binding;

    public fb(XMPushService xMPushService, bg.b bVar) {
        this.f352a = xMPushService;
        this.f353a = bVar;
    }

    private void b() {
        this.f353a.b(this);
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
        if (!this.f355a || this.a == 11) {
            return;
        }
        ez m487a = fg.m485a().m487a();
        int i = fd.a[this.f354a.ordinal()];
        if (i != 1) {
            if (i == 3) {
                eyVar = ey.BIND_SUCCESS;
            }
            if (m487a != null) {
                m487a.b(this.f351a.mo514a());
                m487a.d(this.f353a.f934b);
                m487a.f340b = 1;
                try {
                    m487a.a((byte) Integer.parseInt(this.f353a.g));
                } catch (NumberFormatException unused) {
                }
                fg.m485a().a(m487a);
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
                m487a.f337a = c.a.a();
                m487a.c(c.f356a);
            } catch (NullPointerException unused2) {
                m487a = null;
            }
            if (m487a != null) {
            }
        }
        m487a.f337a = eyVar.a();
        if (m487a != null) {
        }
    }

    public void a() {
        this.f353a.a(this);
        this.f351a = this.f352a.m755a();
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public void a(bg.c cVar, bg.c cVar2, int i) {
        if (!this.f355a && cVar == bg.c.binding) {
            this.f354a = cVar2;
            this.a = i;
            this.f355a = true;
        }
        this.f352a.a(new fc(this, 4));
    }
}
