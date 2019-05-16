package com.xiaomi.stats;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes3.dex */
class b extends XMPushService.i {
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.b = aVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        this.b.c();
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "Handling bind stats";
    }
}
