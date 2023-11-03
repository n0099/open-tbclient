package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.baidu.ar.pose.PoseAR;
import com.xiaomi.push.dx;
import com.xiaomi.push.ec;
import com.xiaomi.push.eg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hr;
import com.xiaomi.push.hu;
import com.xiaomi.push.ig;
import com.xiaomi.push.service.bd;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class c implements eg {
    @Override // com.xiaomi.push.eg
    public void a(Context context, HashMap<String, String> hashMap) {
        ig igVar = new ig();
        igVar.b(ec.a(context).m456a());
        igVar.d(ec.a(context).b());
        igVar.c(hr.AwakeAppResponse.f508a);
        igVar.a(bd.a());
        igVar.f650a = hashMap;
        ao.a(context).a((ao) igVar, hh.Notification, true, (hu) null, true);
        com.xiaomi.channel.commonutils.logger.b.m186a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.eg
    public void b(Context context, HashMap<String, String> hashMap) {
        MiTinyDataClient.upload("category_awake_app", "wake_up_app", 1L, dx.a(hashMap));
        com.xiaomi.channel.commonutils.logger.b.m186a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.eg
    public void c(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.channel.commonutils.logger.b.m186a("MoleInfo：\u3000" + dx.b(hashMap));
        String str = hashMap.get("awake_info");
        if (String.valueOf(1007).equals(hashMap.get(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY))) {
            o.a(context, str);
        }
    }
}
