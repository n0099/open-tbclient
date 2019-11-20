package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.fx;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.al;
import java.io.IOException;
import java.util.Collection;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class n extends XMPushService.i {
    private XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    private String f920a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f921a;
    private String b;
    private String c;

    public n(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.a = xMPushService;
        this.f920a = str;
        this.f921a = bArr;
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
        al.b next;
        k a = l.a((Context) this.a);
        if (a == null) {
            try {
                kVar = l.a(this.a, this.f920a, this.b, this.c);
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
            Collection<al.b> m495a = al.a().m495a("5");
            if (m495a.isEmpty()) {
                next = kVar.a(this.a);
                w.a(this.a, next);
                al.a().a(next);
            } else {
                next = m495a.iterator().next();
            }
            if (!this.a.m489c()) {
                this.a.a(true);
                return;
            }
            try {
                if (next.f858a == al.c.binded) {
                    w.a(this.a, this.f920a, this.f921a);
                } else if (next.f858a == al.c.unbind) {
                    XMPushService xMPushService = this.a;
                    XMPushService xMPushService2 = this.a;
                    xMPushService2.getClass();
                    xMPushService.a(new XMPushService.a(next));
                }
                return;
            } catch (fx e3) {
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
