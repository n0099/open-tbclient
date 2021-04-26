package com.xiaomi.push.service;

import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.av;
/* loaded from: classes7.dex */
public final class ab implements av.b.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f38861a;

    public ab(XMPushService xMPushService) {
        this.f38861a = xMPushService;
    }

    @Override // com.xiaomi.push.service.av.b.a
    public void a(av.c cVar, av.c cVar2, int i2) {
        if (cVar2 == av.c.binded) {
            p.a(this.f38861a);
            p.b(this.f38861a);
        } else if (cVar2 == av.c.unbind) {
            p.a(this.f38861a, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
        }
    }
}
