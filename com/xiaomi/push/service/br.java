package com.xiaomi.push.service;

import com.xiaomi.push.ek;
import com.xiaomi.push.ft;
import com.xiaomi.push.fw;
import java.util.Map;
/* loaded from: classes18.dex */
class br extends ft {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f4861a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(XMPushService xMPushService, Map map, int i, String str, fw fwVar) {
        super(map, i, str, fwVar);
        this.f4861a = xMPushService;
    }

    @Override // com.xiaomi.push.ft
    /* renamed from: a */
    public byte[] mo294a() {
        try {
            ek.b bVar = new ek.b();
            bVar.a(be.a().m555a());
            return bVar.a();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m47a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
