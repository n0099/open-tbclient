package com.xiaomi.push.service;

import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class bm extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f4856a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f898a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f899a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(XMPushService xMPushService, int i, String str, byte[] bArr) {
        super(i);
        this.f4856a = xMPushService;
        this.f898a = str;
        this.f899a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send mi push message";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            w.a(this.f4856a, this.f898a, this.f899a);
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f4856a.a(10, e);
        }
    }
}
