package com.xiaomi.push.service.awake.module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a implements f {
    private void a(Activity activity, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (TextUtils.isEmpty(stringExtra)) {
            com.xiaomi.push.service.awake.b.a(activity.getApplicationContext(), PushConstants.INTENT_ACTIVITY_NAME, 1008, "B get incorrect message");
            return;
        }
        String b = com.xiaomi.push.service.awake.a.b(stringExtra);
        if (TextUtils.isEmpty(b)) {
            com.xiaomi.push.service.awake.b.a(activity.getApplicationContext(), PushConstants.INTENT_ACTIVITY_NAME, 1008, "B get incorrect message");
        } else {
            com.xiaomi.push.service.awake.b.a(activity.getApplicationContext(), b, 1007, "play with activity successfully");
        }
    }

    private void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            if (TextUtils.isEmpty(str3)) {
                com.xiaomi.push.service.awake.b.a(context, PushConstants.INTENT_ACTIVITY_NAME, 1008, "argument error");
            } else {
                com.xiaomi.push.service.awake.b.a(context, str3, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.awake.d.b(context, str, str2)) {
            com.xiaomi.push.service.awake.b.a(context, str3, 1003, "B is not ready");
        } else {
            com.xiaomi.push.service.awake.b.a(context, str3, 1002, "B is ready");
            com.xiaomi.push.service.awake.b.a(context, str3, 1004, "A is ready");
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            intent.putExtra("awake_info", com.xiaomi.push.service.awake.a.a(str3));
            intent.addFlags(276824064);
            intent.setAction(str2);
            try {
                context.startActivity(intent);
                com.xiaomi.push.service.awake.b.a(context, str3, 1005, "A is successful");
                com.xiaomi.push.service.awake.b.a(context, str3, 1006, "The job is finished");
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.service.awake.b.a(context, str3, 1008, "A meet a exception when help B's activity");
            }
        }
    }

    @Override // com.xiaomi.push.service.awake.module.f
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Activity) || intent == null) {
            com.xiaomi.push.service.awake.b.a(context, PushConstants.INTENT_ACTIVITY_NAME, 1008, "B receive incorrect message");
        } else {
            a((Activity) context, intent);
        }
    }

    @Override // com.xiaomi.push.service.awake.module.f
    public void a(Context context, b bVar) {
        if (bVar != null) {
            a(context, bVar.a(), bVar.b(), bVar.d());
        } else {
            com.xiaomi.push.service.awake.b.a(context, PushConstants.INTENT_ACTIVITY_NAME, 1008, "A receive incorrect message");
        }
    }
}
