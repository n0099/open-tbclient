package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.dv;
import com.xiaomi.push.ea;
import com.xiaomi.push.ee;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.hs;
import com.xiaomi.push.ie;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class c implements ee {
    @Override // com.xiaomi.push.ee
    public void a(Context context, HashMap<String, String> hashMap) {
        ie ieVar = new ie();
        ieVar.b(ea.a(context).m265a());
        ieVar.d(ea.a(context).b());
        ieVar.c(hp.AwakeAppResponse.f506a);
        ieVar.a(com.xiaomi.push.service.at.a());
        ieVar.f647a = hashMap;
        an.a(context).a((an) ieVar, hf.Notification, true, (hs) null, true);
        com.xiaomi.channel.commonutils.logger.b.m51a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.ee
    public void b(Context context, HashMap<String, String> hashMap) {
        MiTinyDataClient.upload("category_awake_app", "wake_up_app", 1L, dv.a(hashMap));
        com.xiaomi.channel.commonutils.logger.b.m51a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.ee
    public void c(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.channel.commonutils.logger.b.m51a("MoleInfo：\u3000" + dv.b(hashMap));
        String str = hashMap.get("awake_info");
        if (String.valueOf(1007).equals(hashMap.get("event_type"))) {
            o.a(context, str);
        }
    }
}
