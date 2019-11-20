package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes3.dex */
class gu extends XMPushService.i {
    final /* synthetic */ gt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gu(gt gtVar, int i) {
        super(i);
        this.a = gtVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "Handling bind stats";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        this.a.c();
    }
}
