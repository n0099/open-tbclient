package com.xiaomi.push.service;

import com.baidu.tieba.ms;
import com.xiaomi.push.fg;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class bq {
    public static int d = 300000;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f945a;
    public int b = 0;
    public int c = 0;
    public int a = 500;

    /* renamed from: a  reason: collision with other field name */
    public long f944a = 0;

    public bq(XMPushService xMPushService) {
        this.f945a = xMPushService;
    }

    private int a() {
        if (this.b > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i = this.b;
        if (i > 4) {
            return (int) (random * 60000.0d);
        }
        if (i > 1) {
            return (int) (random * 10000.0d);
        }
        if (this.f944a == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f944a >= 310000) {
            this.a = 1000;
            this.c = 0;
            return 0;
        }
        int i2 = this.a;
        int i3 = d;
        if (i2 >= i3) {
            return i2;
        }
        int i4 = this.c + 1;
        this.c = i4;
        if (i4 >= 4) {
            return i3;
        }
        this.a = (int) (i2 * 1.5d);
        return i2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m813a() {
        this.f944a = System.currentTimeMillis();
        this.f945a.a(1);
        this.b = 0;
    }

    public void a(boolean z) {
        if (!this.f945a.m758a()) {
            com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.f945a.m759a(1)) {
                this.b++;
            }
            this.f945a.a(1);
            XMPushService xMPushService = this.f945a;
            xMPushService.getClass();
            xMPushService.a(new XMPushService.e());
        } else if (this.f945a.m759a(1)) {
        } else {
            int a = a();
            this.b++;
            com.xiaomi.channel.commonutils.logger.b.m190a("schedule reconnect in " + a + ms.c);
            XMPushService xMPushService2 = this.f945a;
            xMPushService2.getClass();
            xMPushService2.a(new XMPushService.e(), (long) a);
            if (this.b == 2 && fg.m485a().m490a()) {
                ap.b();
            }
            if (this.b == 3) {
                ap.a();
            }
        }
    }
}
