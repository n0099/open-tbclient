package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import java.io.IOException;
import java.util.Collection;
import org.json.JSONException;
/* loaded from: classes9.dex */
public class n extends XMPushService.i {
    private XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    private String f919a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f920a;
    private String b;
    private String c;

    public n(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.a = xMPushService;
        this.f919a = str;
        this.f920a = bArr;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "register app";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0016  */
    @Override // com.xiaomi.push.service.XMPushService.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        k kVar;
        ap.b next;
        k a = l.a((Context) this.a);
        if (a == null) {
            try {
                kVar = l.a(this.a, this.f919a, this.b, this.c);
            } catch (IOException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                kVar = a;
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
            if (kVar != null) {
                com.xiaomi.channel.commonutils.logger.b.d("no account for mipush");
                o.a(this.a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
                return;
            }
            Collection<ap.b> m545a = ap.a().m545a("5");
            if (m545a.isEmpty()) {
                next = kVar.a(this.a);
                w.a(this.a, next);
                ap.a().a(next);
            } else {
                next = m545a.iterator().next();
            }
            if (!this.a.m526c()) {
                this.a.a(true);
                return;
            }
            try {
                if (next.f857a == ap.c.binded) {
                    w.a(this.a, this.f919a, this.f920a);
                } else if (next.f857a == ap.c.unbind) {
                    XMPushService xMPushService = this.a;
                    XMPushService xMPushService2 = this.a;
                    xMPushService2.getClass();
                    xMPushService.a(new XMPushService.a(next));
                }
                return;
            } catch (gd e3) {
                com.xiaomi.channel.commonutils.logger.b.a(e3);
                this.a.a(10, e3);
                return;
            }
        }
        kVar = a;
        if (kVar != null) {
        }
    }
}
