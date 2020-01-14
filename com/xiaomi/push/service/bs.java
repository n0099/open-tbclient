package com.xiaomi.push.service;

import com.xiaomi.push.fx;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bs extends XMPushService.i {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f905a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f906a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(XMPushService xMPushService, int i, String str, byte[] bArr) {
        super(i);
        this.a = xMPushService;
        this.f905a = str;
        this.f906a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send mi push message";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            w.a(this.a, this.f905a, this.f906a);
        } catch (fx e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.a.a(10, e);
        }
    }
}
