package com.xiaomi.push.service;

import com.xiaomi.push.gg;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class cj extends XMPushService.j {
    public final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f972a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ byte[] f973a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cj(XMPushService xMPushService, int i, String str, byte[] bArr) {
        super(i);
        this.a = xMPushService;
        this.f972a = str;
        this.f973a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo695a() {
        return "send mi push message";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo412a() {
        try {
            ah.a(this.a, this.f972a, this.f973a);
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.a.a(10, e);
        }
    }
}
