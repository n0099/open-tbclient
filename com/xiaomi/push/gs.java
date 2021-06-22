package com.xiaomi.push;

import com.xiaomi.push.gv;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes7.dex */
public class gs implements av.b.a {

    /* renamed from: a  reason: collision with root package name */
    public int f41472a;

    /* renamed from: a  reason: collision with other field name */
    public fl f447a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f448a;

    /* renamed from: a  reason: collision with other field name */
    public av.b f449a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f451a = false;

    /* renamed from: a  reason: collision with other field name */
    public av.c f450a = av.c.binding;

    public gs(XMPushService xMPushService, av.b bVar) {
        this.f448a = xMPushService;
        this.f449a = bVar;
    }

    private void b() {
        this.f449a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        ew ewVar;
        b();
        if (!this.f451a || this.f41472a == 11) {
            return;
        }
        ex m351a = gx.m349a().m351a();
        int i2 = gu.f41474a[this.f450a.ordinal()];
        if (i2 != 1) {
            if (i2 == 3) {
                ewVar = ew.BIND_SUCCESS;
            }
            if (m351a != null) {
                m351a.b(this.f447a.m307a());
                m351a.d(this.f449a.f911b);
                m351a.f345b = 1;
                try {
                    m351a.a((byte) Integer.parseInt(this.f449a.f41851g));
                } catch (NumberFormatException unused) {
                }
                gx.m349a().a(m351a);
                return;
            }
            return;
        }
        int i3 = this.f41472a;
        if (i3 == 17) {
            ewVar = ew.BIND_TCP_READ_TIMEOUT;
        } else if (i3 == 21) {
            ewVar = ew.BIND_TIMEOUT;
        } else {
            try {
                gv.a c2 = gv.c(gx.a().a());
                m351a.f342a = c2.f41475a.a();
                m351a.c(c2.f452a);
            } catch (NullPointerException unused2) {
                m351a = null;
            }
            if (m351a != null) {
            }
        }
        m351a.f342a = ewVar.a();
        if (m351a != null) {
        }
    }

    public void a() {
        this.f449a.a(this);
        this.f447a = this.f448a.m546a();
    }

    @Override // com.xiaomi.push.service.av.b.a
    public void a(av.c cVar, av.c cVar2, int i2) {
        if (!this.f451a && cVar == av.c.binding) {
            this.f450a = cVar2;
            this.f41472a = i2;
            this.f451a = true;
        }
        this.f448a.a(new gt(this, 4));
    }
}
