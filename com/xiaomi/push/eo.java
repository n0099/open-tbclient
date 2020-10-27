package com.xiaomi.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class eo implements et {
    private void a(Activity activity, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (TextUtils.isEmpty(stringExtra)) {
            em.a(activity.getApplicationContext(), PushConstants.INTENT_ACTIVITY_NAME, 1008, "B get incorrect message");
            return;
        }
        String b = el.b(stringExtra);
        if (TextUtils.isEmpty(b)) {
            em.a(activity.getApplicationContext(), PushConstants.INTENT_ACTIVITY_NAME, 1008, "B get incorrect message");
        } else {
            em.a(activity.getApplicationContext(), b, 1007, "play with activity successfully");
        }
    }

    private void b(Context context, ep epVar) {
        String m266a = epVar.m266a();
        String b = epVar.b();
        String d = epVar.d();
        int a2 = epVar.a();
        if (context == null || TextUtils.isEmpty(m266a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                em.a(context, PushConstants.INTENT_ACTIVITY_NAME, 1008, "argument error");
            } else {
                em.a(context, d, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.f.b(context, m266a, b)) {
            em.a(context, d, 1003, "B is not ready");
        } else {
            em.a(context, d, 1002, "B is ready");
            em.a(context, d, 1004, "A is ready");
            Intent intent = new Intent(b);
            intent.setPackage(m266a);
            intent.putExtra("awake_info", el.a(d));
            intent.addFlags(276824064);
            intent.setAction(b);
            if (a2 == 1) {
                try {
                    if (!eq.m267a(context)) {
                        em.a(context, d, 1008, "A not in foreground");
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    em.a(context, d, 1008, "A meet a exception when help B's activity");
                    return;
                }
            }
            context.startActivity(intent);
            em.a(context, d, 1005, "A is successful");
            em.a(context, d, 1006, "The job is finished");
        }
    }

    @Override // com.xiaomi.push.et
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Activity) || intent == null) {
            em.a(context, PushConstants.INTENT_ACTIVITY_NAME, 1008, "B receive incorrect message");
        } else {
            a((Activity) context, intent);
        }
    }

    @Override // com.xiaomi.push.et
    public void a(Context context, ep epVar) {
        if (epVar != null) {
            b(context, epVar);
        } else {
            em.a(context, PushConstants.INTENT_ACTIVITY_NAME, 1008, "A receive incorrect message");
        }
    }
}
