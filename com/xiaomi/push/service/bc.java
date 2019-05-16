package com.xiaomi.push.service;

import com.baidu.tieba.model.ReportUserInfoModel;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class bc {
    private static int e = 300000;
    private XMPushService a;
    private int d = 0;
    private int b = 500;
    private long c = 0;

    public bc(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private int b() {
        if (this.d > 8) {
            return 300000;
        }
        double random = 1.0d + (Math.random() * 2.0d);
        if (this.d > 4) {
            return (int) (60000.0d * random);
        }
        if (this.d > 1) {
            return (int) (10000.0d * random);
        }
        if (this.c != 0) {
            if (System.currentTimeMillis() - this.c >= ReportUserInfoModel.TIME_INTERVAL) {
                this.b = 1000;
                return 0;
            } else if (this.b >= e) {
                return this.b;
            } else {
                int i = this.b;
                this.b = (int) (this.b * 1.5d);
                return i;
            }
        }
        return 0;
    }

    public void a() {
        this.c = System.currentTimeMillis();
        this.a.a(1);
        this.d = 0;
    }

    public void a(boolean z) {
        if (!this.a.a()) {
            com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.a.b(1)) {
                this.d++;
            }
            this.a.a(1);
            XMPushService xMPushService = this.a;
            XMPushService xMPushService2 = this.a;
            xMPushService2.getClass();
            xMPushService.a(new XMPushService.d());
        } else if (this.a.b(1)) {
        } else {
            int b = b();
            if (!this.a.b(1)) {
                this.d++;
            }
            com.xiaomi.channel.commonutils.logger.b.a("schedule reconnect in " + b + "ms");
            XMPushService xMPushService3 = this.a;
            XMPushService xMPushService4 = this.a;
            xMPushService4.getClass();
            xMPushService3.a(new XMPushService.d(), b);
            if (this.d == 2 && com.xiaomi.stats.f.a().c()) {
                ak.b();
            }
            if (this.d == 3) {
                ak.a();
            }
        }
    }
}
