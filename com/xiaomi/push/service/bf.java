package com.xiaomi.push.service;

import com.xiaomi.push.gx;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class bf {

    /* renamed from: d  reason: collision with root package name */
    public static int f41381d = 300000;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f924a;

    /* renamed from: b  reason: collision with root package name */
    public int f41383b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f41384c = 0;

    /* renamed from: a  reason: collision with root package name */
    public int f41382a = 500;

    /* renamed from: a  reason: collision with other field name */
    public long f923a = 0;

    public bf(XMPushService xMPushService) {
        this.f924a = xMPushService;
    }

    private int a() {
        if (this.f41383b > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i = this.f41383b;
        if (i > 4) {
            return (int) (random * 60000.0d);
        }
        if (i > 1) {
            return (int) (random * 10000.0d);
        }
        if (this.f923a == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f923a >= 310000) {
            this.f41382a = 1000;
            this.f41384c = 0;
            return 0;
        }
        int i2 = this.f41382a;
        int i3 = f41381d;
        if (i2 >= i3) {
            return i2;
        }
        int i4 = this.f41384c + 1;
        this.f41384c = i4;
        if (i4 >= 4) {
            return i3;
        }
        this.f41382a = (int) (i2 * 1.5d);
        return i2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m596a() {
        this.f923a = System.currentTimeMillis();
        this.f924a.a(1);
        this.f41383b = 0;
    }

    public void a(boolean z) {
        if (!this.f924a.m548a()) {
            com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.f924a.m549a(1)) {
                this.f41383b++;
            }
            this.f924a.a(1);
            XMPushService xMPushService = this.f924a;
            xMPushService.getClass();
            xMPushService.a(new XMPushService.d());
        } else if (this.f924a.m549a(1)) {
        } else {
            int a2 = a();
            this.f41383b++;
            com.xiaomi.channel.commonutils.logger.b.m55a("schedule reconnect in " + a2 + "ms");
            XMPushService xMPushService2 = this.f924a;
            xMPushService2.getClass();
            xMPushService2.a(new XMPushService.d(), (long) a2);
            if (this.f41383b == 2 && gx.m348a().m353a()) {
                ag.b();
            }
            if (this.f41383b == 3) {
                ag.a();
            }
        }
    }
}
