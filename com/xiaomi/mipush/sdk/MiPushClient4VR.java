package com.xiaomi.mipush.sdk;

import android.content.Context;
/* loaded from: classes3.dex */
public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
        aiVar.c(com.xiaomi.xmpush.thrift.r.VRUpload.aa);
        aiVar.b(d.a(context).c());
        aiVar.d(context.getPackageName());
        aiVar.a("data", str);
        aiVar.a(com.xiaomi.push.service.aq.a());
        az.a(context).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, (com.xiaomi.xmpush.thrift.u) null);
    }
}
