package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ew implements et {
    private void a(Service service, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (TextUtils.isEmpty(stringExtra)) {
            em.a(service.getApplicationContext(), "service", 1008, "B get a incorrect message");
            return;
        }
        String b2 = el.b(stringExtra);
        if (TextUtils.isEmpty(b2)) {
            em.a(service.getApplicationContext(), "service", 1008, "B get a incorrect message");
        } else {
            em.a(service.getApplicationContext(), b2, 1007, "play with service successfully");
        }
    }

    private void b(Context context, ep epVar) {
        String m292a = epVar.m292a();
        String b2 = epVar.b();
        String d = epVar.d();
        int a2 = epVar.a();
        if (context == null || TextUtils.isEmpty(m292a) || TextUtils.isEmpty(b2) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                em.a(context, "service", 1008, "argument error");
            } else {
                em.a(context, d, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.f.a(context, m292a, b2)) {
            em.a(context, d, 1003, "B is not ready");
        } else {
            em.a(context, d, 1002, "B is ready");
            em.a(context, d, 1004, "A is ready");
            try {
                Intent intent = new Intent();
                intent.setAction(b2);
                intent.setPackage(m292a);
                intent.putExtra("awake_info", el.a(d));
                if (a2 == 1 && !eq.m293a(context)) {
                    em.a(context, d, 1008, "A not in foreground");
                } else if (context.startService(intent) != null) {
                    em.a(context, d, 1005, "A is successful");
                    em.a(context, d, 1006, "The job is finished");
                } else {
                    em.a(context, d, 1008, "A is fail to help B's service");
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                em.a(context, d, 1008, "A meet a exception when help B's service");
            }
        }
    }

    @Override // com.xiaomi.push.et
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Service)) {
            em.a(context, "service", 1008, "A receive incorrect message");
        } else {
            a((Service) context, intent);
        }
    }

    @Override // com.xiaomi.push.et
    public void a(Context context, ep epVar) {
        if (epVar != null) {
            b(context, epVar);
        } else {
            em.a(context, "service", 1008, "A receive incorrect message");
        }
    }
}
