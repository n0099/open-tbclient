package com.xiaomi.push.service;

import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.as;
import java.io.IOException;
import java.util.Collection;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class v extends XMPushService.i {
    private XMPushService b;
    private byte[] c;
    private String d;
    private String e;
    private String f;

    public v(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.b = xMPushService;
        this.d = str;
        this.c = bArr;
        this.e = str2;
        this.f = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0016  */
    @Override // com.xiaomi.push.service.XMPushService.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        s sVar;
        as.b next;
        s a = t.a(this.b);
        if (a == null) {
            try {
                sVar = t.a(this.b, this.d, this.e, this.f);
            } catch (IOException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                sVar = a;
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
            if (sVar != null) {
                com.xiaomi.channel.commonutils.logger.b.d("no account for mipush");
                w.a(this.b, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
                return;
            }
            Collection<as.b> c = as.a().c("5");
            if (c.isEmpty()) {
                next = sVar.a(this.b);
                af.a(this.b, next);
                as.a().a(next);
            } else {
                next = c.iterator().next();
            }
            if (!this.b.e()) {
                this.b.a(true);
                return;
            }
            try {
                if (next.m == as.c.binded) {
                    af.a(this.b, this.d, this.c);
                } else if (next.m == as.c.unbind) {
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
        sVar = a;
        if (sVar != null) {
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "register app";
    }
}
