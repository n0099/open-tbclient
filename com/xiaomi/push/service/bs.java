package com.xiaomi.push.service;

import com.xiaomi.push.fw;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class bs extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f41012a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f940a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ byte[] f941a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(XMPushService xMPushService, int i, String str, byte[] bArr) {
        super(i);
        this.f41012a = xMPushService;
        this.f940a = str;
        this.f941a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send mi push message";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            y.a(this.f41012a, this.f940a, this.f941a);
        } catch (fw e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.f41012a.a(10, e2);
        }
    }
}
