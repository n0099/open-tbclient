package com.xiaomi.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ei implements en {
    private void a(Activity activity, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (TextUtils.isEmpty(stringExtra)) {
            eg.a(activity.getApplicationContext(), PushConstants.INTENT_ACTIVITY_NAME, 1008, "B get incorrect message");
            return;
        }
        String b = ef.b(stringExtra);
        if (TextUtils.isEmpty(b)) {
            eg.a(activity.getApplicationContext(), PushConstants.INTENT_ACTIVITY_NAME, 1008, "B get incorrect message");
        } else {
            eg.a(activity.getApplicationContext(), b, 1007, "play with activity successfully");
        }
    }

    private void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            if (TextUtils.isEmpty(str3)) {
                eg.a(context, PushConstants.INTENT_ACTIVITY_NAME, 1008, "argument error");
            } else {
                eg.a(context, str3, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.f.b(context, str, str2)) {
            eg.a(context, str3, 1003, "B is not ready");
        } else {
            eg.a(context, str3, 1002, "B is ready");
            eg.a(context, str3, 1004, "A is ready");
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            intent.putExtra("awake_info", ef.a(str3));
            intent.addFlags(276824064);
            intent.setAction(str2);
            try {
                context.startActivity(intent);
                eg.a(context, str3, 1005, "A is successful");
                eg.a(context, str3, 1006, "The job is finished");
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                eg.a(context, str3, 1008, "A meet a exception when help B's activity");
            }
        }
    }

    @Override // com.xiaomi.push.en
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Activity) || intent == null) {
            eg.a(context, PushConstants.INTENT_ACTIVITY_NAME, 1008, "B receive incorrect message");
        } else {
            a((Activity) context, intent);
        }
    }

    @Override // com.xiaomi.push.en
    public void a(Context context, ej ejVar) {
        if (ejVar != null) {
            a(context, ejVar.a(), ejVar.b(), ejVar.d());
        } else {
            eg.a(context, PushConstants.INTENT_ACTIVITY_NAME, 1008, "A receive incorrect message");
        }
    }
}
