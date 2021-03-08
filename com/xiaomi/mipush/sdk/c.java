package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.baidu.ar.pose.PoseAR;
import com.xiaomi.push.el;
import com.xiaomi.push.eq;
import com.xiaomi.push.eu;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.hz;
import com.xiaomi.push.il;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c implements eu {
    @Override // com.xiaomi.push.eu
    public void a(Context context, HashMap<String, String> hashMap) {
        il ilVar = new il();
        ilVar.b(eq.a(context).m273a());
        ilVar.d(eq.a(context).b());
        ilVar.c(hw.AwakeAppResponse.f476a);
        ilVar.a(com.xiaomi.push.service.an.a());
        ilVar.f617a = hashMap;
        aq.a(context).a((aq) ilVar, hm.Notification, true, (hz) null, true);
        com.xiaomi.channel.commonutils.logger.b.m58a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.eu
    public void b(Context context, HashMap<String, String> hashMap) {
        MiTinyDataClient.upload("category_awake_app", "wake_up_app", 1L, el.a(hashMap));
        com.xiaomi.channel.commonutils.logger.b.m58a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.eu
    public void c(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.channel.commonutils.logger.b.m58a("MoleInfo：\u3000" + el.b(hashMap));
        String str = hashMap.get("awake_info");
        if (String.valueOf(1007).equals(hashMap.get(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY))) {
            n.a(context, str);
        }
    }
}
