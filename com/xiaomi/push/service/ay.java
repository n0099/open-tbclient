package com.xiaomi.push.service;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ay implements com.xiaomi.push.service.awake.module.g {
    @Override // com.xiaomi.push.service.awake.module.g
    public void a(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
        aiVar.b(com.xiaomi.push.service.awake.module.c.a(context).b());
        aiVar.d(com.xiaomi.push.service.awake.module.c.a(context).c());
        aiVar.c(com.xiaomi.xmpush.thrift.r.AwakeAppResponse.aa);
        aiVar.a(aq.a());
        aiVar.h = hashMap;
        byte[] a = com.xiaomi.xmpush.thrift.at.a(af.a(aiVar.l(), aiVar.e(), aiVar, com.xiaomi.xmpush.thrift.a.Notification));
        if (!(context instanceof XMPushService)) {
            com.xiaomi.channel.commonutils.logger.b.a("MoleInfo : context is not correct in pushLayer " + aiVar.c());
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.a("MoleInfo : send data directly in pushLayer " + aiVar.c());
        ((XMPushService) context).a(context.getPackageName(), a, true);
    }

    @Override // com.xiaomi.push.service.awake.module.g
    public void b(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.tinyData.d a = com.xiaomi.tinyData.d.a(context);
        if (a != null) {
            a.a("category_awake_app", "wake_up_app", 1L, com.xiaomi.push.service.awake.a.a(hashMap));
        }
    }

    @Override // com.xiaomi.push.service.awake.module.g
    public void c(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.channel.commonutils.logger.b.a("MoleInfo：\u3000" + com.xiaomi.push.service.awake.a.b(hashMap));
    }
}
