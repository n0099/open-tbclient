package com.xiaomi.push.service;

import com.xiaomi.push.protobuf.b;
import java.util.Map;
/* loaded from: classes3.dex */
class bt extends com.xiaomi.smack.b {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(XMPushService xMPushService, Map map, int i, String str, com.xiaomi.smack.e eVar) {
        super(map, i, str, eVar);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.smack.b
    public byte[] a() {
        try {
            b.C0492b c0492b = new b.C0492b();
            c0492b.a(bh.a().c());
            return c0492b.c();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
