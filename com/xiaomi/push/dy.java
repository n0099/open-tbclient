package com.xiaomi.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class dy implements ed {
    private void a(Activity activity, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            String b2 = dv.b(stringExtra);
            if (!TextUtils.isEmpty(b2)) {
                dw.a(activity.getApplicationContext(), b2, 1007, "play with activity successfully");
                return;
            }
        }
        dw.a(activity.getApplicationContext(), "activity", 1008, "B get incorrect message");
    }

    private void b(Context context, dz dzVar) {
        String m266a = dzVar.m266a();
        String b2 = dzVar.b();
        String d2 = dzVar.d();
        int a2 = dzVar.a();
        if (context == null || TextUtils.isEmpty(m266a) || TextUtils.isEmpty(b2) || TextUtils.isEmpty(d2)) {
            if (TextUtils.isEmpty(d2)) {
                dw.a(context, "activity", 1008, "argument error");
            } else {
                dw.a(context, d2, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.g.b(context, m266a, b2)) {
            dw.a(context, d2, 1003, "B is not ready");
        } else {
            dw.a(context, d2, 1002, "B is ready");
            dw.a(context, d2, 1004, "A is ready");
            Intent intent = new Intent(b2);
            intent.setPackage(m266a);
            intent.putExtra("awake_info", dv.a(d2));
            intent.addFlags(276824064);
            intent.setAction(b2);
            if (a2 == 1) {
                try {
                    if (!ea.m269a(context)) {
                        dw.a(context, d2, 1008, "A not in foreground");
                        return;
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    dw.a(context, d2, 1008, "A meet a exception when help B's activity");
                    return;
                }
            }
            context.startActivity(intent);
            dw.a(context, d2, 1005, "A is successful");
            dw.a(context, d2, 1006, "The job is finished");
        }
    }

    @Override // com.xiaomi.push.ed
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Activity) || intent == null) {
            dw.a(context, "activity", 1008, "B receive incorrect message");
        } else {
            a((Activity) context, intent);
        }
    }

    @Override // com.xiaomi.push.ed
    public void a(Context context, dz dzVar) {
        if (dzVar != null) {
            b(context, dzVar);
        } else {
            dw.a(context, "activity", 1008, "A receive incorrect message");
        }
    }
}
