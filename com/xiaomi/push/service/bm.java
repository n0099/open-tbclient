package com.xiaomi.push.service;

import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class bm extends XMPushService.i {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f902a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f903a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(XMPushService xMPushService, int i, String str, byte[] bArr) {
        super(i);
        this.a = xMPushService;
        this.f902a = str;
        this.f903a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send mi push message";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            w.a(this.a, this.f902a, this.f903a);
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.a.a(10, e);
        }
    }
}
