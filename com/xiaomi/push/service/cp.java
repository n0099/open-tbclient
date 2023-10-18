package com.xiaomi.push.service;

import com.xiaomi.push.dw;
import com.xiaomi.push.fw;
import com.xiaomi.push.fz;
import java.util.Map;
/* loaded from: classes10.dex */
public class cp extends fw {
    public final /* synthetic */ XMPushService a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp(XMPushService xMPushService, Map map, int i, String str, fz fzVar) {
        super(map, i, str, fzVar);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.fw
    /* renamed from: a */
    public byte[] mo514a() {
        try {
            dw.b bVar = new dw.b();
            bVar.a(bv.a().m809a());
            return bVar.m448a();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m182a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
