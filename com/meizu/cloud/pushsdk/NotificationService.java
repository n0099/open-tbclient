package com.meizu.cloud.pushsdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Process;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.a.b.b;
import com.meizu.cloud.pushsdk.util.d;
import java.util.List;
/* loaded from: classes8.dex */
public class NotificationService extends IntentService {
    private Object a;

    public NotificationService() {
        super("NotificationService");
    }

    public NotificationService(String str) {
        super(str);
    }

    public String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        List<ResolveInfo> queryBroadcastReceivers = getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            return null;
        }
        return queryBroadcastReceivers.get(0).activityInfo.name;
    }

    public void a(Intent intent) {
        String a = a(getPackageName(), intent.getAction());
        if (TextUtils.isEmpty(a)) {
            d.a(this, intent, "reflectReceiver sendbroadcast", 2005);
            com.meizu.cloud.a.a.i("NotificationService", " reflectReceiver error: receiver for: " + intent.getAction() + " not found, package: " + getPackageName());
            intent.setPackage(getPackageName());
            sendBroadcast(intent);
            return;
        }
        try {
            d.a(this, intent, "reflectReceiver startservice", 2003);
            intent.setClassName(getPackageName(), a);
            com.meizu.cloud.pushsdk.base.a.d a2 = com.meizu.cloud.pushsdk.base.a.a.a(a).a((Class<?>[]) null).a(null);
            if (!a2.a || a2.b == 0) {
                return;
            }
            com.meizu.cloud.a.a.i("NotificationService", "Reflect MzPushReceiver " + a2.a);
            com.meizu.cloud.pushsdk.base.a.a.a(a2.b).a("onReceive", Context.class, Intent.class).a(a2.b, getApplicationContext(), intent);
        } catch (Exception e) {
            com.meizu.cloud.a.a.i("NotificationService", "reflect e: " + e);
            d.a(this, intent, e.getMessage(), 2004);
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        com.meizu.cloud.a.a.i("NotificationService", "NotificationService destroy");
        this.a = null;
        super.onDestroy();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        Process.setThreadPriority(10);
        if (intent != null) {
            try {
                com.meizu.cloud.a.a.i("NotificationService", "onHandleIntentaction " + intent.getAction());
                String stringExtra = intent.getStringExtra("command_type");
                boolean z = PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) || PushConstants.MZ_PUSH_ON_REGISTER_ACTION.equals(intent.getAction()) || PushConstants.MZ_PUSH_ON_UNREGISTER_ACTION.equals(intent.getAction());
                com.meizu.cloud.a.a.d("NotificationService", "-- command_type -- " + stringExtra + " legalAction " + z);
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver") && z) {
                    String stringExtra2 = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
                    com.meizu.cloud.a.a.i("NotificationService", "control message is " + stringExtra2);
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        com.meizu.cloud.pushsdk.c.a.a(this, new b(stringExtra2, null, null).b().c());
                    }
                    a(intent);
                }
            } catch (Exception e) {
                com.meizu.cloud.a.a.e("NotificationService", "onHandleIntent error " + e.getMessage());
            }
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
