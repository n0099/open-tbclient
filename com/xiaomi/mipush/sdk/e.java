package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.support.v4.view.PointerIconCompat;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class e implements com.xiaomi.push.service.awake.module.g {
    @Override // com.xiaomi.push.service.awake.module.g
    public void a(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
        aiVar.b(com.xiaomi.push.service.awake.module.c.a(context).b());
        aiVar.d(com.xiaomi.push.service.awake.module.c.a(context).c());
        aiVar.c(com.xiaomi.xmpush.thrift.r.AwakeAppResponse.aa);
        aiVar.a(com.xiaomi.push.service.aq.a());
        aiVar.h = hashMap;
        az.a(context).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, true, (com.xiaomi.xmpush.thrift.u) null, true);
        com.xiaomi.channel.commonutils.logger.b.a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.service.awake.module.g
    public void b(Context context, HashMap<String, String> hashMap) {
        MiTinyDataClient.upload("category_awake_app", "wake_up_app", 1L, com.xiaomi.push.service.awake.a.a(hashMap));
        com.xiaomi.channel.commonutils.logger.b.a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.service.awake.module.g
    public void c(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.channel.commonutils.logger.b.a("MoleInfo：\u3000" + com.xiaomi.push.service.awake.a.b(hashMap));
        String str = hashMap.get("awake_info");
        if (String.valueOf((int) PointerIconCompat.TYPE_CROSSHAIR).equals(hashMap.get("event_type"))) {
            o.a(context, str);
        }
    }
}
