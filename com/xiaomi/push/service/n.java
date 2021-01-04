package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import java.io.IOException;
import java.util.Collection;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class n extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f14610a;

    /* renamed from: a  reason: collision with other field name */
    private String f998a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f999a;

    /* renamed from: b  reason: collision with root package name */
    private String f14611b;
    private String c;

    public n(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f14610a = xMPushService;
        this.f998a = str;
        this.f999a = bArr;
        this.f14611b = str2;
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
        k a2 = l.a((Context) this.f14610a);
        if (a2 == null) {
            try {
                kVar = l.a(this.f14610a, this.f998a, this.f14611b, this.c);
            } catch (IOException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                kVar = a2;
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
            if (kVar != null) {
                com.xiaomi.channel.commonutils.logger.b.d("no account for mipush");
                o.a(this.f14610a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
                return;
            }
            Collection<ap.b> m564a = ap.a().m564a("5");
            if (m564a.isEmpty()) {
                next = kVar.a(this.f14610a);
                w.a(this.f14610a, next);
                ap.a().a(next);
            } else {
                next = m564a.iterator().next();
            }
            if (!this.f14610a.m545c()) {
                this.f14610a.a(true);
                return;
            }
            try {
                if (next.f936a == ap.c.binded) {
                    w.a(this.f14610a, this.f998a, this.f999a);
                } else if (next.f936a == ap.c.unbind) {
                    XMPushService xMPushService = this.f14610a;
                    XMPushService xMPushService2 = this.f14610a;
                    xMPushService2.getClass();
                    xMPushService.a(new XMPushService.a(next));
                }
                return;
            } catch (gd e3) {
                com.xiaomi.channel.commonutils.logger.b.a(e3);
                this.f14610a.a(10, e3);
                return;
            }
        }
        kVar = a2;
        if (kVar != null) {
        }
    }
}
