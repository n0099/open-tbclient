package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.hs;
import com.xiaomi.push.ie;
/* loaded from: classes7.dex */
public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        ie ieVar = new ie();
        ieVar.c(hp.VRUpload.f506a);
        ieVar.b(b.m98a(context).m99a());
        ieVar.d(context.getPackageName());
        ieVar.a("data", str);
        ieVar.a(com.xiaomi.push.service.at.a());
        an.a(context).a((an) ieVar, hf.Notification, (hs) null);
    }
}
