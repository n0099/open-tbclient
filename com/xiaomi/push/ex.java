package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ex implements et {
    private void a(Service service, Intent intent) {
        if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("waker_pkgname");
            String stringExtra2 = intent.getStringExtra("awake_info");
            if (TextUtils.isEmpty(stringExtra)) {
                em.a(service.getApplicationContext(), "service", 1007, "old version message");
            } else if (TextUtils.isEmpty(stringExtra2)) {
                em.a(service.getApplicationContext(), stringExtra, 1007, "play with service ");
            } else {
                String b2 = el.b(stringExtra2);
                if (TextUtils.isEmpty(b2)) {
                    em.a(service.getApplicationContext(), "service", 1008, "B get a incorrect message");
                } else {
                    em.a(service.getApplicationContext(), b2, 1007, "old version message ");
                }
            }
        }
    }

    private void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str3)) {
                em.a(context, "service", 1008, "argument error");
            } else {
                em.a(context, str3, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.f.a(context, str)) {
            em.a(context, str3, 1003, "B is not ready");
        } else {
            em.a(context, str3, 1002, "B is ready");
            em.a(context, str3, 1004, "A is ready");
            try {
                Intent intent = new Intent();
                intent.setClassName(str, str2);
                intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                intent.putExtra("waker_pkgname", context.getPackageName());
                intent.putExtra("awake_info", el.a(str3));
                if (context.startService(intent) != null) {
                    em.a(context, str3, 1005, "A is successful");
                    em.a(context, str3, 1006, "The job is finished");
                } else {
                    em.a(context, str3, 1008, "A is fail to help B's service");
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                em.a(context, str3, 1008, "A meet a exception when help B's service");
            }
        }
    }

    @Override // com.xiaomi.push.et
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Service)) {
            return;
        }
        a((Service) context, intent);
    }

    @Override // com.xiaomi.push.et
    public void a(Context context, ep epVar) {
        if (epVar != null) {
            a(context, epVar.m285a(), epVar.c(), epVar.d());
        }
    }
}
