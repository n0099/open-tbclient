package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import java.io.IOException;
import java.util.Collection;
import org.json.JSONException;
/* loaded from: classes18.dex */
public class n extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f4881a;

    /* renamed from: a  reason: collision with other field name */
    private String f920a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f921a;
    private String b;
    private String c;

    public n(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f4881a = xMPushService;
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
        ap.b next;
        k a2 = l.a((Context) this.f4881a);
        if (a2 == null) {
            try {
                kVar = l.a(this.f4881a, this.f920a, this.b, this.c);
            } catch (IOException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                kVar = a2;
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
            if (kVar != null) {
                com.xiaomi.channel.commonutils.logger.b.d("no account for mipush");
                o.a(this.f4881a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
                return;
            }
            Collection<ap.b> m538a = ap.a().m538a("5");
            if (m538a.isEmpty()) {
                next = kVar.a(this.f4881a);
                w.a(this.f4881a, next);
                ap.a().a(next);
            } else {
                next = m538a.iterator().next();
            }
            if (!this.f4881a.m519c()) {
                this.f4881a.a(true);
                return;
            }
            try {
                if (next.f858a == ap.c.binded) {
                    w.a(this.f4881a, this.f920a, this.f921a);
                } else if (next.f858a == ap.c.unbind) {
                    XMPushService xMPushService = this.f4881a;
                    XMPushService xMPushService2 = this.f4881a;
                    xMPushService2.getClass();
                    xMPushService.a(new XMPushService.a(next));
                }
                return;
            } catch (gd e3) {
                com.xiaomi.channel.commonutils.logger.b.a(e3);
                this.f4881a.a(10, e3);
                return;
            }
        }
        kVar = a2;
        if (kVar != null) {
        }
    }
}
