package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
/* loaded from: classes3.dex */
public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        Cif cif = new Cif();
        cif.c(hq.VRUpload.f489a);
        cif.b(d.m68a(context).m69a());
        cif.d(context.getPackageName());
        cif.a("data", str);
        cif.a(com.xiaomi.push.service.aj.a());
        ay.a(context).a((ay) cif, hg.Notification, (ht) null);
    }
}
