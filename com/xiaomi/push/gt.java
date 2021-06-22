package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class gt extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ gs f41473a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gt(gs gsVar, int i2) {
        super(i2);
        this.f41473a = gsVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "Handling bind stats";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        this.f41473a.c();
    }
}
