package com.xiaomi.push.service;

import com.xiaomi.push.he;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class az {
    private static int d = 300000;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f871a;
    private int b = 0;
    private int c = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f5069a = 500;

    /* renamed from: a  reason: collision with other field name */
    private long f870a = 0;

    public az(XMPushService xMPushService) {
        this.f871a = xMPushService;
    }

    private int a() {
        if (this.b > 8) {
            return 300000;
        }
        double random = 1.0d + (Math.random() * 2.0d);
        if (this.b > 4) {
            return (int) (60000.0d * random);
        }
        if (this.b > 1) {
            return (int) (10000.0d * random);
        }
        if (this.f870a != 0) {
            if (System.currentTimeMillis() - this.f870a >= 310000) {
                this.f5069a = 1000;
                this.c = 0;
                return 0;
            } else if (this.f5069a >= d) {
                return this.f5069a;
            } else {
                int i = this.f5069a;
                this.c++;
                if (this.c >= 4) {
                    return d;
                }
                this.f5069a = (int) (this.f5069a * 1.5d);
                return i;
            }
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m555a() {
        this.f870a = System.currentTimeMillis();
        this.f871a.a(1);
        this.b = 0;
    }

    public void a(boolean z) {
        if (!this.f871a.m522a()) {
            com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.f871a.m523a(1)) {
                this.b++;
            }
            this.f871a.a(1);
            XMPushService xMPushService = this.f871a;
            XMPushService xMPushService2 = this.f871a;
            xMPushService2.getClass();
            xMPushService.a(new XMPushService.d());
        } else if (this.f871a.m523a(1)) {
        } else {
            int a2 = a();
            this.b++;
            com.xiaomi.channel.commonutils.logger.b.m54a("schedule reconnect in " + a2 + "ms");
            XMPushService xMPushService3 = this.f871a;
            XMPushService xMPushService4 = this.f871a;
            xMPushService4.getClass();
            xMPushService3.a(new XMPushService.d(), a2);
            if (this.b == 2 && he.m334a().m339a()) {
                ad.b();
            }
            if (this.b == 3) {
                ad.a();
            }
        }
    }
}
