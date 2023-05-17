package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class fc extends XMPushService.j {
    public final /* synthetic */ fb a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fc(fb fbVar, int i) {
        super(i);
        this.a = fbVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo695a() {
        return "Handling bind stats";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void mo412a() {
        this.a.c();
    }
}
