package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hg;
import com.xiaomi.push.ht;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class ag implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        String f;
        Context context4;
        Context context5;
        if (com.xiaomi.push.l.d()) {
            return;
        }
        context = MiPushClient.sContext;
        if (com.xiaomi.push.i.f(context) != null) {
            Cif cif = new Cif();
            context2 = MiPushClient.sContext;
            cif.b(d.m83a(context2).m84a());
            cif.c("client_info_update");
            cif.a(com.xiaomi.push.service.aj.a());
            cif.a(new HashMap());
            context3 = MiPushClient.sContext;
            String str = TextUtils.isEmpty(com.xiaomi.push.i.f(context3)) ? "" : "" + com.xiaomi.push.ay.a(f);
            context4 = MiPushClient.sContext;
            String h = com.xiaomi.push.i.h(context4);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(h)) {
                str = str + Constants.ACCEPT_TIME_SEPARATOR_SP + h;
            }
            if (!TextUtils.isEmpty(str)) {
                cif.m414a().put(Constants.EXTRA_KEY_IMEI_MD5, str);
            }
            int a = com.xiaomi.push.i.a();
            if (a >= 0) {
                cif.m414a().put("space_id", Integer.toString(a));
            }
            context5 = MiPushClient.sContext;
            ay.a(context5).a((ay) cif, hg.Notification, false, (ht) null);
        }
    }
}
