package com.meizu.cloud.pushsdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.util.d;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes2.dex */
public class NotificationService extends IntentService {
    public NotificationService(String str) {
        super(str);
    }

    public NotificationService() {
        super("NotificationService");
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        com.meizu.cloud.a.a.i("NotificationService", "NotificationService destroy");
        super.onDestroy();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            try {
                com.meizu.cloud.a.a.i("NotificationService", "onHandleIntentaction " + intent.getAction());
                String stringExtra = intent.getStringExtra("command_type");
                com.meizu.cloud.a.a.d("NotificationService", "-- command_type -- " + stringExtra);
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
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
            d.a(this, intent, "reflectReceiver sendbroadcast", PushConstants.NOTIFICATIONSERVICE_SEND_MESSAGE_BROADCAST);
            com.meizu.cloud.a.a.i("NotificationService", " reflectReceiver error: receiver for: " + intent.getAction() + " not found, package: " + getPackageName());
            intent.setPackage(getPackageName());
            sendBroadcast(intent);
            return;
        }
        try {
            d.a(this, intent, "reflectReceiver startservice", PushConstants.NOTIFICATIONSERVICE_SEND_MESSAGE);
            Class<?> cls = Class.forName(a);
            Object newInstance = cls.getConstructor(null).newInstance(null);
            Method method = cls.getMethod("onReceive", Context.class, Intent.class);
            intent.setClassName(getPackageName(), a);
            method.invoke(newInstance, getApplicationContext(), intent);
        } catch (Exception e) {
            com.meizu.cloud.a.a.i("NotificationService", "reflect e: " + e);
            d.a(this, intent, e.getMessage(), PushConstants.NOTIFICATIONSERVICE_SEND_MESSAGE_ERROR);
        }
    }
}
