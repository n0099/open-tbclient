package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class ck extends XMPushService.j {
    public final /* synthetic */ XMPushService a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ck(XMPushService xMPushService, int i) {
        super(i);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo755a() {
        return "disconnect for service destroy.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo472a() {
        if (this.a.f847a != null) {
            this.a.f847a.b(15, (Exception) null);
            this.a.f847a = null;
        }
    }
}
