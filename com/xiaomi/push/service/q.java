package com.xiaomi.push.service;

import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ak;
import java.io.IOException;
import java.util.Collection;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class q extends XMPushService.h {
    private XMPushService b;
    private byte[] c;
    private String d;
    private String e;
    private String f;

    public q(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.b = xMPushService;
        this.d = str;
        this.c = bArr;
        this.e = str2;
        this.f = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0016  */
    @Override // com.xiaomi.push.service.XMPushService.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        n nVar;
        ak.b next;
        n a = o.a(this.b);
        if (a == null) {
            try {
                nVar = o.a(this.b, this.d, this.e, this.f);
            } catch (IOException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                nVar = a;
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
            if (nVar != null) {
                com.xiaomi.channel.commonutils.logger.b.d("no account for mipush");
                r.a(this.b, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
                return;
            }
            Collection<ak.b> c = ak.a().c("5");
            if (c.isEmpty()) {
                next = nVar.a(this.b);
                aa.a(this.b, next);
                ak.a().a(next);
            } else {
                next = c.iterator().next();
            }
            if (!this.b.f()) {
                this.b.a(true);
                return;
            }
            try {
                if (next.m == ak.c.binded) {
                    aa.a(this.b, this.d, this.c);
                } else if (next.m == ak.c.unbind) {
                    XMPushService xMPushService = this.b;
                    XMPushService xMPushService2 = this.b;
                    xMPushService2.getClass();
                    xMPushService.a(new XMPushService.a(next));
                }
                return;
            } catch (com.xiaomi.smack.l e3) {
                com.xiaomi.channel.commonutils.logger.b.a(e3);
                this.b.a(10, e3);
                return;
            }
        }
        nVar = a;
        if (nVar != null) {
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public String b() {
        return "register app";
    }
}
