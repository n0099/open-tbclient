package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* loaded from: classes12.dex */
class as extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ap.b.c f5063a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(ap.b.c cVar, int i) {
        super(i);
        this.f5063a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (ap.a().a(this.f5063a.f864a.g, this.f5063a.f864a.f860b).f851a == null) {
            ap.b.this.f853a.a(this.f5063a.f864a.g, this.f5063a.f864a.f860b, 2, null, null);
        }
    }
}
