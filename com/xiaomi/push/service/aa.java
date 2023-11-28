package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gg;
import com.xiaomi.push.id;
import com.xiaomi.push.service.XMPushService;
import java.util.Map;
/* loaded from: classes10.dex */
public final class aa extends XMPushService.j {
    public final /* synthetic */ id a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f874a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(int i, XMPushService xMPushService, id idVar) {
        super(i);
        this.f874a = xMPushService;
        this.a = idVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo765a() {
        return "send ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo482a() {
        Map<String, String> map = null;
        try {
            if (com.xiaomi.push.j.m721a((Context) this.f874a)) {
                try {
                    map = ag.a((Context) this.f874a, this.a);
                } catch (Throwable unused) {
                }
            }
            ah.a(this.f874a, y.a(this.f874a, this.a, map));
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f874a.a(10, e);
        }
    }
}
