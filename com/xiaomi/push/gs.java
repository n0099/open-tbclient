package com.xiaomi.push;

import com.xiaomi.push.gv;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes7.dex */
public class gs implements av.b.a {

    /* renamed from: a  reason: collision with root package name */
    public int f40991a;

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
        if (!this.f451a || this.f40991a == 11) {
            return;
        }
        ex m350a = gx.m348a().m350a();
        int i = gu.f40993a[this.f450a.ordinal()];
        if (i != 1) {
            if (i == 3) {
                ewVar = ew.BIND_SUCCESS;
            }
            if (m350a != null) {
                m350a.b(this.f447a.m306a());
                m350a.d(this.f449a.f911b);
                m350a.f345b = 1;
                try {
                    m350a.a((byte) Integer.parseInt(this.f449a.f41351g));
                } catch (NumberFormatException unused) {
                }
                gx.m348a().a(m350a);
                return;
            }
            return;
        }
        int i2 = this.f40991a;
        if (i2 == 17) {
            ewVar = ew.BIND_TCP_READ_TIMEOUT;
        } else if (i2 == 21) {
            ewVar = ew.BIND_TIMEOUT;
        } else {
            try {
                gv.a c2 = gv.c(gx.a().a());
                m350a.f342a = c2.f40994a.a();
                m350a.c(c2.f452a);
            } catch (NullPointerException unused2) {
                m350a = null;
            }
            if (m350a != null) {
            }
        }
        m350a.f342a = ewVar.a();
        if (m350a != null) {
        }
    }

    public void a() {
        this.f449a.a(this);
        this.f447a = this.f448a.m545a();
    }

    @Override // com.xiaomi.push.service.av.b.a
    public void a(av.c cVar, av.c cVar2, int i) {
        if (!this.f451a && cVar == av.c.binding) {
            this.f450a = cVar2;
            this.f40991a = i;
            this.f451a = true;
        }
        this.f448a.a(new gt(this, 4));
    }
}
