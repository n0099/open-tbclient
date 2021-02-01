package com.qq.e.comm.plugin.d;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.baidu.android.util.io.ActionJsonData;
/* loaded from: classes15.dex */
public class d {
    public static NotificationManager a(Context context) {
        NotificationManager notificationManager;
        ApplicationInfo applicationInfo;
        if (context == null || (notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)) == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 26 || (applicationInfo = context.getApplicationInfo()) == null || applicationInfo.targetSdkVersion < 26) {
            return notificationManager;
        }
        NotificationChannel notificationChannel = new NotificationChannel("TencentAdNetCH1", "TencentAdNetCH1", 2);
        notificationChannel.setSound(null, null);
        notificationChannel.enableVibration(false);
        notificationChannel.enableLights(false);
        notificationManager.createNotificationChannel(notificationChannel);
        return notificationManager;
    }

    public static void a(Context context, Notification.Builder builder) {
        if (Build.VERSION.SDK_INT < 26 || builder == null || context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 26) {
            return;
        }
        builder.setChannelId("TencentAdNetCH1");
    }
}
