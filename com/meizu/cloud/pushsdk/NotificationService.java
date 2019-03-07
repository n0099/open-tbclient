package com.meizu.cloud.pushsdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.util.c;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes3.dex */
public class NotificationService extends IntentService {
    private static final String TAG = "NotificationService";

    public NotificationService(String str) {
        super(str);
    }

    public NotificationService() {
        super(TAG);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        com.meizu.cloud.a.a.i(TAG, "NotificationService destroy");
        super.onDestroy();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            try {
                com.meizu.cloud.a.a.i(TAG, "onHandleIntentaction " + intent.getAction());
                String stringExtra = intent.getStringExtra("command_type");
                com.meizu.cloud.a.a.d(TAG, "-- command_type -- " + stringExtra);
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
                    reflectReceiver(intent);
                }
            } catch (Exception e) {
                com.meizu.cloud.a.a.e(TAG, "onHandleIntent error " + e.getMessage());
            }
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public String getReceiver(String str, String str2) {
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

    public void reflectReceiver(Intent intent) {
        String receiver = getReceiver(getPackageName(), intent.getAction());
        if (TextUtils.isEmpty(receiver)) {
            c.a(this, intent, "reflectReceiver sendbroadcast", PushConstants.NOTIFICATIONSERVICE_SEND_MESSAGE_BROADCAST);
            com.meizu.cloud.a.a.i(TAG, " reflectReceiver error: receiver for: " + intent.getAction() + " not found, package: " + getPackageName());
            intent.setPackage(getPackageName());
            sendBroadcast(intent);
            return;
        }
        try {
            c.a(this, intent, "reflectReceiver startservice", 2003);
            Class<?> cls = Class.forName(receiver);
            Object newInstance = cls.getConstructor(null).newInstance(null);
            Method method = cls.getMethod("onReceive", Context.class, Intent.class);
            intent.setClassName(getPackageName(), receiver);
            method.invoke(newInstance, getApplicationContext(), intent);
        } catch (Exception e) {
            com.meizu.cloud.a.a.i(TAG, "reflect e: " + e);
            c.a(this, intent, e.getMessage(), 2004);
        }
    }
}
