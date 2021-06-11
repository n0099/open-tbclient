package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class eh implements ed {
    private void a(Service service, Intent intent) {
        if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("waker_pkgname");
            String stringExtra2 = intent.getStringExtra("awake_info");
            if (TextUtils.isEmpty(stringExtra)) {
                dw.a(service.getApplicationContext(), "service", 1007, "old version message");
            } else if (TextUtils.isEmpty(stringExtra2)) {
                dw.a(service.getApplicationContext(), stringExtra, 1007, "play with service ");
            } else {
                String b2 = dv.b(stringExtra2);
                boolean isEmpty = TextUtils.isEmpty(b2);
                Context applicationContext = service.getApplicationContext();
                if (isEmpty) {
                    dw.a(applicationContext, "service", 1008, "B get a incorrect message");
                } else {
                    dw.a(applicationContext, b2, 1007, "old version message ");
                }
            }
        }
    }

    private void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str3)) {
                dw.a(context, "service", 1008, "argument error");
            } else {
                dw.a(context, str3, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.g.a(context, str)) {
            dw.a(context, str3, 1003, "B is not ready");
        } else {
            dw.a(context, str3, 1002, "B is ready");
            dw.a(context, str3, 1004, "A is ready");
            try {
                Intent intent = new Intent();
                intent.setClassName(str, str2);
                intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                intent.putExtra("waker_pkgname", context.getPackageName());
                intent.putExtra("awake_info", dv.a(str3));
                if (context.startService(intent) == null) {
                    dw.a(context, str3, 1008, "A is fail to help B's service");
                    return;
                }
                dw.a(context, str3, 1005, "A is successful");
                dw.a(context, str3, 1006, "The job is finished");
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                dw.a(context, str3, 1008, "A meet a exception when help B's service");
            }
        }
    }

    @Override // com.xiaomi.push.ed
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Service)) {
            return;
        }
        a((Service) context, intent);
    }

    @Override // com.xiaomi.push.ed
    public void a(Context context, dz dzVar) {
        if (dzVar != null) {
            a(context, dzVar.m265a(), dzVar.c(), dzVar.d());
        }
    }
}
