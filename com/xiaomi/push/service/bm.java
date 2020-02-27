package com.xiaomi.push.service;

import com.xiaomi.push.ee;
import com.xiaomi.push.fn;
import com.xiaomi.push.fq;
import java.util.Map;
/* loaded from: classes8.dex */
class bm extends fn {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(XMPushService xMPushService, Map map, int i, String str, fq fqVar) {
        super(map, i, str, fqVar);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.fn
    /* renamed from: a */
    public byte[] mo290a() {
        try {
            ee.b bVar = new ee.b();
            bVar.a(ba.a().m529a());
            return bVar.a();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m47a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
