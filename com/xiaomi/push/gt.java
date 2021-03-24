package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class gt extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ gs f40607a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gt(gs gsVar, int i) {
        super(i);
        this.f40607a = gsVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "Handling bind stats";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        this.f40607a.c();
    }
}
