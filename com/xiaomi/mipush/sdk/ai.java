package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ai implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        String e;
        Context context4;
        Context context5;
        if (com.xiaomi.channel.commonutils.android.f.g()) {
            return;
        }
        context = MiPushClient.sContext;
        if (com.xiaomi.channel.commonutils.android.d.e(context) != null) {
            com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
            context2 = MiPushClient.sContext;
            aiVar.b(d.a(context2).c());
            aiVar.c("client_info_update");
            aiVar.a(com.xiaomi.push.service.aq.a());
            aiVar.a(new HashMap());
            context3 = MiPushClient.sContext;
            String str = TextUtils.isEmpty(com.xiaomi.channel.commonutils.android.d.e(context3)) ? "" : "" + com.xiaomi.channel.commonutils.string.d.a(e);
            context4 = MiPushClient.sContext;
            String g = com.xiaomi.channel.commonutils.android.d.g(context4);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(g)) {
                str = str + Constants.ACCEPT_TIME_SEPARATOR_SP + g;
            }
            if (!TextUtils.isEmpty(str)) {
                aiVar.j().put(Constants.EXTRA_KEY_IMEI_MD5, str);
            }
            int b = com.xiaomi.channel.commonutils.android.d.b();
            if (b >= 0) {
                aiVar.j().put("space_id", Integer.toString(b));
            }
            context5 = MiPushClient.sContext;
            az.a(context5).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, (com.xiaomi.xmpush.thrift.u) null);
        }
    }
}
