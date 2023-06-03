package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class cs extends XMPushService.j {
    public final /* synthetic */ XMPushService a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cs(XMPushService xMPushService, int i) {
        super(i);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo750a() {
        return "prepare the mi push account.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo467a() {
        ah.a(this.a);
        if (com.xiaomi.push.bi.b(this.a)) {
            this.a.a(true);
        }
    }
}
