package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes12.dex */
class ha extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ gz f4942a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ha(gz gzVar, int i) {
        super(i);
        this.f4942a = gzVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "Handling bind stats";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        this.f4942a.c();
    }
}
