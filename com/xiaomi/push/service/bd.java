package com.xiaomi.push.service;

import com.xiaomi.push.protobuf.b;
import java.util.Map;
/* loaded from: classes2.dex */
class bd extends com.xiaomi.smack.b {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(XMPushService xMPushService, Map map, int i, String str, com.xiaomi.smack.e eVar) {
        super(map, i, str, eVar);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.smack.b
    public byte[] a() {
        try {
            b.C0180b c0180b = new b.C0180b();
            c0180b.a(at.a().c());
            return c0180b.c();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
