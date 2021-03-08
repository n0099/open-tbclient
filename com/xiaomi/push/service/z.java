package com.xiaomi.push.service;

import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class z implements ap.b.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f8586a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(XMPushService xMPushService) {
        this.f8586a = xMPushService;
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        if (cVar2 == ap.c.binded) {
            o.a(this.f8586a);
            o.b(this.f8586a);
        } else if (cVar2 == ap.c.unbind) {
            o.a(this.f8586a, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
        }
    }
}
