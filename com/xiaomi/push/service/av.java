package com.xiaomi.push.service;

import com.xiaomi.push.gy;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class av {
    private static int d = 300000;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f878a;
    private int b = 0;
    private int c = 0;
    private int a = 500;

    /* renamed from: a  reason: collision with other field name */
    private long f877a = 0;

    public av(XMPushService xMPushService) {
        this.f878a = xMPushService;
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
        if (this.f877a != 0) {
            if (System.currentTimeMillis() - this.f877a >= 310000) {
                this.a = 1000;
                this.c = 0;
                return 0;
            } else if (this.a >= d) {
                return this.a;
            } else {
                int i = this.a;
                this.c++;
                if (this.c >= 4) {
                    return d;
                }
                this.a = (int) (this.a * 1.5d);
                return i;
            }
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m517a() {
        this.f877a = System.currentTimeMillis();
        this.f878a.a(1);
        this.b = 0;
    }

    public void a(boolean z) {
        if (!this.f878a.m497a()) {
            com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.f878a.m498a(1)) {
                this.b++;
            }
            this.f878a.a(1);
            XMPushService xMPushService = this.f878a;
            XMPushService xMPushService2 = this.f878a;
            xMPushService2.getClass();
            xMPushService.a(new XMPushService.d());
        } else if (this.f878a.m498a(1)) {
        } else {
            int a = a();
            if (!this.f878a.m498a(1)) {
                this.b++;
            }
            com.xiaomi.channel.commonutils.logger.b.m42a("schedule reconnect in " + a + "ms");
            XMPushService xMPushService3 = this.f878a;
            XMPushService xMPushService4 = this.f878a;
            xMPushService4.getClass();
            xMPushService3.a(new XMPushService.d(), a);
            if (this.b == 2 && gy.m318a().m323a()) {
                ac.b();
            }
            if (this.b == 3) {
                ac.a();
            }
        }
    }
}
