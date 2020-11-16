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
    private XMPushService f5111a;

    /* renamed from: a  reason: collision with other field name */
    private String f922a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f923a;
    private String b;
    private String c;

    public n(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f5111a = xMPushService;
        this.f922a = str;
        this.f923a = bArr;
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
        k a2 = l.a((Context) this.f5111a);
        if (a2 == null) {
            try {
                kVar = l.a(this.f5111a, this.f922a, this.b, this.c);
            } catch (IOException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                kVar = a2;
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
            if (kVar != null) {
                com.xiaomi.channel.commonutils.logger.b.d("no account for mipush");
                o.a(this.f5111a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
                return;
            }
            Collection<ap.b> m548a = ap.a().m548a("5");
            if (m548a.isEmpty()) {
                next = kVar.a(this.f5111a);
                w.a(this.f5111a, next);
                ap.a().a(next);
            } else {
                next = m548a.iterator().next();
            }
            if (!this.f5111a.m529c()) {
                this.f5111a.a(true);
                return;
            }
            try {
                if (next.f860a == ap.c.binded) {
                    w.a(this.f5111a, this.f922a, this.f923a);
                } else if (next.f860a == ap.c.unbind) {
                    XMPushService xMPushService = this.f5111a;
                    XMPushService xMPushService2 = this.f5111a;
                    xMPushService2.getClass();
                    xMPushService.a(new XMPushService.a(next));
                }
                return;
            } catch (gd e3) {
                com.xiaomi.channel.commonutils.logger.b.a(e3);
                this.f5111a.a(10, e3);
                return;
            }
        }
        kVar = a2;
        if (kVar != null) {
        }
    }
}
