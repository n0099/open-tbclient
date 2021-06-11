package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.fw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
import java.util.Collection;
/* loaded from: classes7.dex */
public class o extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public XMPushService f41837a;

    /* renamed from: a  reason: collision with other field name */
    public String f963a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f964a;

    /* renamed from: b  reason: collision with root package name */
    public String f41838b;

    /* renamed from: c  reason: collision with root package name */
    public String f41839c;

    public o(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f41837a = xMPushService;
        this.f963a = str;
        this.f964a = bArr;
        this.f41838b = str2;
        this.f41839c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        av.b next;
        l a2 = m.a((Context) this.f41837a);
        if (a2 == null) {
            try {
                a2 = m.a(this.f41837a, this.f963a, this.f41838b, this.f41839c);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. " + e2);
            }
        }
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("no account for mipush");
            p.a(this.f41837a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        Collection<av.b> m587a = av.a().m587a("5");
        if (m587a.isEmpty()) {
            next = a2.a(this.f41837a);
            y.a(this.f41837a, next);
            av.a().a(next);
        } else {
            next = m587a.iterator().next();
        }
        if (!this.f41837a.m553c()) {
            this.f41837a.a(true);
            return;
        }
        try {
            if (next.f906a == av.c.binded) {
                y.a(this.f41837a, this.f963a, this.f964a);
            } else if (next.f906a == av.c.unbind) {
                XMPushService xMPushService = this.f41837a;
                XMPushService xMPushService2 = this.f41837a;
                xMPushService2.getClass();
                xMPushService.a(new XMPushService.a(next));
            }
        } catch (fw e3) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. " + e3);
            this.f41837a.a(10, e3);
        }
    }
}
