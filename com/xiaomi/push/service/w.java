package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.gg;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.util.Collection;
/* loaded from: classes10.dex */
public class w extends XMPushService.j {
    public XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    public String f1009a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f1010a;
    public String b;
    public String c;

    public w(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.a = xMPushService;
        this.f1009a = str;
        this.f1010a = bArr;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo756a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo473a() {
        bg.b next;
        t m837a = u.m837a((Context) this.a);
        if (m837a == null) {
            try {
                m837a = u.a(this.a, this.f1009a, this.b, this.c);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. " + e);
            }
        }
        if (m837a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("no account for registration.");
            x.a(this.a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m181a("do registration now.");
        Collection<bg.b> m794a = bg.a().m794a("5");
        if (m794a.isEmpty()) {
            next = m837a.a(this.a);
            ah.a(this.a, next);
            bg.a().a(next);
        } else {
            next = m794a.iterator().next();
        }
        if (!this.a.m754c()) {
            x.a(this.f1009a, this.f1010a);
            this.a.a(true);
            return;
        }
        try {
            if (next.f933a == bg.c.binded) {
                ah.a(this.a, this.f1009a, this.f1010a);
            } else if (next.f933a == bg.c.unbind) {
                x.a(this.f1009a, this.f1010a);
                XMPushService xMPushService = this.a;
                XMPushService xMPushService2 = this.a;
                xMPushService2.getClass();
                xMPushService.a(new XMPushService.b(next));
            }
        } catch (gg e2) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. " + e2);
            this.a.a(10, e2);
        }
    }
}
