package com.xiaomi.push.service;

import com.xiaomi.push.gx;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class bf {

    /* renamed from: d  reason: collision with root package name */
    public static int f40996d = 300000;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f924a;

    /* renamed from: b  reason: collision with root package name */
    public int f40998b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f40999c = 0;

    /* renamed from: a  reason: collision with root package name */
    public int f40997a = 500;

    /* renamed from: a  reason: collision with other field name */
    public long f923a = 0;

    public bf(XMPushService xMPushService) {
        this.f924a = xMPushService;
    }

    private int a() {
        if (this.f40998b > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i = this.f40998b;
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
            this.f40997a = 1000;
            this.f40999c = 0;
            return 0;
        }
        int i2 = this.f40997a;
        int i3 = f40996d;
        if (i2 >= i3) {
            return i2;
        }
        int i4 = this.f40999c + 1;
        this.f40999c = i4;
        if (i4 >= 4) {
            return i3;
        }
        double d2 = i2;
        Double.isNaN(d2);
        this.f40997a = (int) (d2 * 1.5d);
        return i2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m592a() {
        this.f923a = System.currentTimeMillis();
        this.f924a.a(1);
        this.f40998b = 0;
    }

    public void a(boolean z) {
        if (!this.f924a.m544a()) {
            com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.f924a.m545a(1)) {
                this.f40998b++;
            }
            this.f924a.a(1);
            XMPushService xMPushService = this.f924a;
            xMPushService.getClass();
            xMPushService.a(new XMPushService.d());
        } else if (this.f924a.m545a(1)) {
        } else {
            int a2 = a();
            this.f40998b++;
            com.xiaomi.channel.commonutils.logger.b.m51a("schedule reconnect in " + a2 + "ms");
            XMPushService xMPushService2 = this.f924a;
            xMPushService2.getClass();
            xMPushService2.a(new XMPushService.d(), (long) a2);
            if (this.f40998b == 2 && gx.m344a().m349a()) {
                ag.b();
            }
            if (this.f40998b == 3) {
                ag.a();
            }
        }
    }
}
