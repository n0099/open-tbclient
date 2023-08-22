package com.xiaomi.push.service;

import com.xiaomi.push.gg;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class cj extends XMPushService.j {
    public final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f973a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ byte[] f974a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cj(XMPushService xMPushService, int i, String str, byte[] bArr) {
        super(i);
        this.a = xMPushService;
        this.f973a = str;
        this.f974a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo755a() {
        return "send mi push message";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo472a() {
        try {
            ah.a(this.a, this.f973a, this.f974a);
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.a.a(10, e);
        }
    }
}
