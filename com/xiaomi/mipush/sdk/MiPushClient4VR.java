package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hh;
import com.xiaomi.push.hr;
import com.xiaomi.push.hu;
import com.xiaomi.push.ig;
import com.xiaomi.push.service.bd;
/* loaded from: classes10.dex */
public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        ig igVar = new ig();
        igVar.c(hr.VRUpload.f508a);
        igVar.b(b.m164a(context).m165a());
        igVar.d(context.getPackageName());
        igVar.a("data", str);
        igVar.a(bd.a());
        ao.a(context).a((ao) igVar, hh.Notification, (hu) null);
    }
}
