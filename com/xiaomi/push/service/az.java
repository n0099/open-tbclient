package com.xiaomi.push.service;

import com.xiaomi.push.he;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class az {
    private static int d = 300000;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f953a;

    /* renamed from: b  reason: collision with root package name */
    private int f14562b = 0;
    private int c = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f14561a = 500;

    /* renamed from: a  reason: collision with other field name */
    private long f952a = 0;

    public az(XMPushService xMPushService) {
        this.f953a = xMPushService;
    }

    private int a() {
        if (this.f14562b > 8) {
            return 300000;
        }
        double random = 1.0d + (Math.random() * 2.0d);
        if (this.f14562b > 4) {
            return (int) (60000.0d * random);
        }
        if (this.f14562b > 1) {
            return (int) (10000.0d * random);
        }
        if (this.f952a != 0) {
            if (System.currentTimeMillis() - this.f952a >= 310000) {
                this.f14561a = 1000;
                this.c = 0;
                return 0;
            } else if (this.f14561a >= d) {
                return this.f14561a;
            } else {
                int i = this.f14561a;
                this.c++;
                if (this.c >= 4) {
                    return d;
                }
                this.f14561a = (int) (this.f14561a * 1.5d);
                return i;
            }
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m585a() {
        this.f952a = System.currentTimeMillis();
        this.f953a.a(1);
        this.f14562b = 0;
    }

    public void a(boolean z) {
        if (!this.f953a.m552a()) {
            com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.f953a.m553a(1)) {
                this.f14562b++;
            }
            this.f953a.a(1);
            XMPushService xMPushService = this.f953a;
            XMPushService xMPushService2 = this.f953a;
            xMPushService2.getClass();
            xMPushService.a(new XMPushService.d());
        } else if (this.f953a.m553a(1)) {
        } else {
            int a2 = a();
            this.f14562b++;
            com.xiaomi.channel.commonutils.logger.b.m84a("schedule reconnect in " + a2 + "ms");
            XMPushService xMPushService3 = this.f953a;
            XMPushService xMPushService4 = this.f953a;
            xMPushService4.getClass();
            xMPushService3.a(new XMPushService.d(), a2);
            if (this.f14562b == 2 && he.m364a().m369a()) {
                ad.b();
            }
            if (this.f14562b == 3) {
                ad.a();
            }
        }
    }
}
