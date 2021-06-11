package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class eg implements ed {
    private void a(Service service, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            String b2 = dv.b(stringExtra);
            if (!TextUtils.isEmpty(b2)) {
                dw.a(service.getApplicationContext(), b2, 1007, "play with service successfully");
                return;
            }
        }
        dw.a(service.getApplicationContext(), "service", 1008, "B get a incorrect message");
    }

    private void b(Context context, dz dzVar) {
        String m265a = dzVar.m265a();
        String b2 = dzVar.b();
        String d2 = dzVar.d();
        int a2 = dzVar.a();
        if (context == null || TextUtils.isEmpty(m265a) || TextUtils.isEmpty(b2) || TextUtils.isEmpty(d2)) {
            if (TextUtils.isEmpty(d2)) {
                dw.a(context, "service", 1008, "argument error");
            } else {
                dw.a(context, d2, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.g.a(context, m265a, b2)) {
            dw.a(context, d2, 1003, "B is not ready");
        } else {
            dw.a(context, d2, 1002, "B is ready");
            dw.a(context, d2, 1004, "A is ready");
            try {
                Intent intent = new Intent();
                intent.setAction(b2);
                intent.setPackage(m265a);
                intent.putExtra("awake_info", dv.a(d2));
                if (a2 == 1 && !ea.m268a(context)) {
                    dw.a(context, d2, 1008, "A not in foreground");
                } else if (context.startService(intent) == null) {
                    dw.a(context, d2, 1008, "A is fail to help B's service");
                } else {
                    dw.a(context, d2, 1005, "A is successful");
                    dw.a(context, d2, 1006, "The job is finished");
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                dw.a(context, d2, 1008, "A meet a exception when help B's service");
            }
        }
    }

    @Override // com.xiaomi.push.ed
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Service)) {
            dw.a(context, "service", 1008, "A receive incorrect message");
        } else {
            a((Service) context, intent);
        }
    }

    @Override // com.xiaomi.push.ed
    public void a(Context context, dz dzVar) {
        if (dzVar != null) {
            b(context, dzVar);
        } else {
            dw.a(context, "service", 1008, "A receive incorrect message");
        }
    }
}
