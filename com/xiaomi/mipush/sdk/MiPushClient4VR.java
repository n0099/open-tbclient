package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.hz;
import com.xiaomi.push.il;
/* loaded from: classes8.dex */
public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        il ilVar = new il();
        ilVar.c(hw.VRUpload.f482a);
        ilVar.b(b.m88a(context).m89a());
        ilVar.d(context.getPackageName());
        ilVar.a("data", str);
        ilVar.a(com.xiaomi.push.service.an.a());
        aq.a(context).a((aq) ilVar, hm.Notification, (hz) null);
    }
}
