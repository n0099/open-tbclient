package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
class ha extends XMPushService.i {
    final /* synthetic */ gz a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ha(gz gzVar, int i) {
        super(i);
        this.a = gzVar;
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
