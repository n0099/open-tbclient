package com.meizu.cloud.pushsdk.notification;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.util.io.ActionJsonData;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.repackage.ym9;
import com.sina.weibo.sdk.utils.ResourceManager;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a implements c {
    public Context a;
    public PushNotificationBuilder b;
    public Handler c;
    public NotificationManager d;

    public a(Context context, PushNotificationBuilder pushNotificationBuilder) {
        this.b = pushNotificationBuilder;
        this.a = context;
        this.c = new Handler(context.getMainLooper());
        this.d = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
    }

    private void a(Notification.Builder builder) {
        if (MinSdkChecker.isSupportNotificationChannel()) {
            ym9.b("AbstractPushNotification", "support notification channel on non meizu device");
            NotificationChannel notificationChannel = new NotificationChannel("mz_push_notification_channel", "MEIZUPUSH", 3);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-16711936);
            notificationChannel.setShowBadge(true);
            this.d.createNotificationChannel(notificationChannel);
            builder.setChannelId("mz_push_notification_channel");
        }
    }

    @TargetApi(23)
    private Icon b(String str) {
        try {
            int identifier = this.a.getPackageManager().getResourcesForApplication(str).getIdentifier(PushConstants.MZ_PUSH_NOTIFICATION_SMALL_ICON, ResourceManager.DRAWABLE, str);
            if (identifier != 0) {
                ym9.d("AbstractPushNotification", "get " + str + " smallIcon success resId " + identifier);
                return Icon.createWithResource(str, identifier);
            }
            return null;
        } catch (Exception e) {
            ym9.b("AbstractPushNotification", "cannot load smallIcon form package " + str + " Error message " + e.getMessage());
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    private void c(Notification notification, MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.notification.c.b.a(notification, true);
        com.meizu.cloud.pushsdk.notification.c.b.a(notification, c(messageV3));
        notification.extras.putString(PushConstants.EXTRA_ORIGINAL_NOTIFICATION_PACKAGE_NAME, messageV3.getUploadDataPackageName());
        notification.extras.putString(PushConstants.EXTRA_FLYME_GREEN_NOTIFICATION_SETTING, d(messageV3));
        notification.extras.putString(PushConstants.NOTIFICATION_EXTRA_TASK_ID, messageV3.getTaskId());
        notification.extras.putString(PushConstants.NOTIFICATION_EXTRA_SEQ_ID, messageV3.getSeqId());
        notification.extras.putString(PushConstants.NOTIFICATION_EXTRA_DEVICE_ID, messageV3.getDeviceId());
        notification.extras.putString(PushConstants.NOTIFICATION_EXTRA_PUSH_TIMESTAMP, messageV3.getPushTimestamp());
        if (!TextUtils.isEmpty(this.b.getAppLabel())) {
            ym9.b("AbstractPushNotification", "set app label " + this.b.getAppLabel());
            notification.extras.putString(PushConstants.EXTRA_SUBSTITUTE_APP_NAME, this.b.getAppLabel());
            return;
        }
        String b = b(this.a, messageV3.getUploadDataPackageName());
        ym9.b("AbstractPushNotification", "current package " + messageV3.getUploadDataPackageName() + " label is " + b);
        if (TextUtils.isEmpty(b)) {
            return;
        }
        notification.extras.putString(PushConstants.EXTRA_SUBSTITUTE_APP_NAME, b);
    }

    public Notification a(MessageV3 messageV3, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        Notification.Builder builder = new Notification.Builder(this.a);
        a(builder, messageV3, pendingIntent, pendingIntent2);
        c(builder, messageV3);
        b(builder, messageV3);
        a(builder, messageV3);
        a(builder);
        Notification build = MinSdkChecker.isSupportNotificationBuild() ? builder.build() : builder.getNotification();
        c(build, messageV3);
        a(build, messageV3);
        b(build, messageV3);
        return build;
    }

    public PendingIntent a(MessageV3 messageV3) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
        intent.putExtra("method", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE);
        intent.setClassName(messageV3.getUploadDataPackageName(), MzSystemUtils.findReceiver(this.a, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getUploadDataPackageName()));
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        intent.setFlags(32);
        return PendingIntent.getBroadcast(this.a, 0, intent, 1073741824);
    }

    public Bitmap a(Context context, String str) {
        try {
            return ((BitmapDrawable) context.getPackageManager().getApplicationIcon(str)).getBitmap();
        } catch (PackageManager.NameNotFoundException e) {
            ym9.d("AbstractPushNotification", "getappicon error " + e.getMessage());
            return ((BitmapDrawable) context.getApplicationInfo().loadIcon(context.getPackageManager())).getBitmap();
        }
    }

    public Bitmap a(String str) {
        com.meizu.cloud.pushsdk.b.a.c b = com.meizu.cloud.pushsdk.b.a.a(str).a().b();
        if (!b.b() || b.a() == null) {
            ym9.d("AbstractPushNotification", "ANRequest On other Thread down load largeIcon " + str + "image fail");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ANRequest On other Thread down load largeIcon ");
        sb.append(str);
        sb.append("image ");
        sb.append(b.a() != null ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
        ym9.d("AbstractPushNotification", sb.toString());
        return (Bitmap) b.a();
    }

    public void a(Notification.Builder builder, MessageV3 messageV3) {
    }

    public void a(Notification.Builder builder, MessageV3 messageV3, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        int i;
        builder.setContentTitle(messageV3.getTitle());
        builder.setContentText(messageV3.getContent());
        builder.setTicker(messageV3.getTitle());
        builder.setAutoCancel(true);
        if (MinSdkChecker.isSupportSendNotification()) {
            builder.setVisibility(1);
        }
        if (MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            Icon b = b(messageV3.getUploadDataPackageName());
            if (b != null) {
                builder.setSmallIcon(b);
                builder.setContentIntent(pendingIntent);
                builder.setDeleteIntent(pendingIntent2);
            }
            ym9.b("AbstractPushNotification", "cannot get " + messageV3.getUploadDataPackageName() + " smallIcon");
        } else {
            PushNotificationBuilder pushNotificationBuilder = this.b;
            if (pushNotificationBuilder != null && pushNotificationBuilder.getmStatusbarIcon() != 0) {
                i = this.b.getmStatusbarIcon();
                builder.setSmallIcon(i);
                builder.setContentIntent(pendingIntent);
                builder.setDeleteIntent(pendingIntent2);
            }
        }
        i = com.meizu.cloud.pushsdk.notification.c.c.l(this.a);
        builder.setSmallIcon(i);
        builder.setContentIntent(pendingIntent);
        builder.setDeleteIntent(pendingIntent2);
    }

    public void a(Notification notification, MessageV3 messageV3) {
    }

    public void a(final NotificationManager notificationManager, final int i, MessageV3 messageV3) {
        AdvanceSetting advanceSetting = messageV3.getmAdvanceSetting();
        if (advanceSetting != null) {
            boolean isHeadUpNotification = advanceSetting.isHeadUpNotification();
            boolean isClearNotification = advanceSetting.isClearNotification();
            if (!isHeadUpNotification || isClearNotification) {
                return;
            }
            messageV3.getmAdvanceSetting().setHeadUpNotification(false);
            messageV3.getmAdvanceSetting().getNotifyType().setSound(false);
            messageV3.getmAdvanceSetting().getNotifyType().setVibrate(false);
            final Notification a = a(messageV3, a(messageV3), b(messageV3));
            this.c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.notification.a.1
                @Override // java.lang.Runnable
                public void run() {
                    notificationManager.notify(i, a);
                }
            }, 5000L);
        }
    }

    public boolean a() {
        return Thread.currentThread() == this.a.getMainLooper().getThread();
    }

    public PendingIntent b(MessageV3 messageV3) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
        intent.putExtra("method", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_DELETE);
        intent.setClassName(messageV3.getPackageName(), MzSystemUtils.findReceiver(this.a, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getPackageName()));
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        return PendingIntent.getBroadcast(this.a, 0, intent, 1073741824);
    }

    public String b(Context context, String str) {
        CharSequence applicationLabel;
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            if (applicationInfo == null || (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) == null) {
                return null;
            }
            return (String) applicationLabel;
        } catch (PackageManager.NameNotFoundException unused) {
            ym9.b("AbstractPushNotification", "can not find " + str + " application info");
            return null;
        }
    }

    public void b(Notification.Builder builder, MessageV3 messageV3) {
    }

    public void b(Notification notification, MessageV3 messageV3) {
    }

    public PendingIntent c(MessageV3 messageV3) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        intent.putExtra(PushConstants.MZ_PUSH_NOTIFICATION_STATE_MESSAGE, messageV3.getNotificationMessage());
        intent.putExtra(PushConstants.NOTIFICATION_EXTRA_TASK_ID, messageV3.getTaskId());
        intent.putExtra(PushConstants.NOTIFICATION_EXTRA_SEQ_ID, messageV3.getSeqId());
        intent.putExtra(PushConstants.NOTIFICATION_EXTRA_DEVICE_ID, messageV3.getDeviceId());
        intent.putExtra(PushConstants.NOTIFICATION_EXTRA_PUSH_TIMESTAMP, messageV3.getPushTimestamp());
        intent.putExtra(PushConstants.NOTIFICATION_EXTRA_SHOW_PACKAGE_NAME, messageV3.getUploadDataPackageName());
        intent.putExtra("method", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_STATE);
        intent.setClassName(messageV3.getPackageName(), MzSystemUtils.findReceiver(this.a, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getPackageName()));
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        return PendingIntent.getBroadcast(this.a, 0, intent, 1073741824);
    }

    public void c(Notification.Builder builder, MessageV3 messageV3) {
        AdvanceSetting advanceSetting = messageV3.getmAdvanceSetting();
        if (advanceSetting != null) {
            if (advanceSetting.getNotifyType() != null) {
                boolean isVibrate = advanceSetting.getNotifyType().isVibrate();
                boolean isLights = advanceSetting.getNotifyType().isLights();
                boolean isSound = advanceSetting.getNotifyType().isSound();
                if (isVibrate || isLights || isSound) {
                    int i = isVibrate ? 2 : 0;
                    if (isLights) {
                        i |= 4;
                    }
                    if (isSound) {
                        i |= 1;
                    }
                    ym9.b("AbstractPushNotification", "current notification type is " + i);
                    builder.setDefaults(i);
                }
            }
            builder.setOngoing(!advanceSetting.isClearNotification());
            if (advanceSetting.isHeadUpNotification() && MinSdkChecker.isSupportNotificationBuild()) {
                builder.setPriority(2);
            }
        }
    }

    public String d(MessageV3 messageV3) {
        String str = null;
        try {
            if (!TextUtils.isEmpty(messageV3.getNotificationMessage())) {
                str = new JSONObject(messageV3.getNotificationMessage()).getJSONObject("data").getJSONObject("extra").getString("fns");
            }
        } catch (Exception e) {
            ym9.b("AbstractPushNotification", "parse flyme notifification setting error " + e.getMessage());
        }
        ym9.d("AbstractPushNotification", "current FlymeGreen notification setting is " + str);
        return str;
    }

    @Override // com.meizu.cloud.pushsdk.notification.c
    @SuppressLint({"NewApi"})
    public void e(MessageV3 messageV3) {
        Notification a = a(messageV3, a(messageV3), b(messageV3));
        int abs = Math.abs((int) System.currentTimeMillis());
        com.meizu.cloud.pushsdk.notification.model.a a2 = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3);
        if (a2 != null && a2.a() != 0) {
            abs = a2.a();
            ym9.b("AbstractPushNotification", "server notify id " + abs);
            if (!TextUtils.isEmpty(a2.b())) {
                int i = com.meizu.cloud.pushsdk.util.b.i(this.a, messageV3.getUploadDataPackageName(), a2.b());
                ym9.b("AbstractPushNotification", "notifyKey " + a2.b() + " preference notifyId is " + i);
                if (i != 0) {
                    ym9.b("AbstractPushNotification", "use preference notifyId " + i + " and cancel it");
                    this.d.cancel(i);
                }
                ym9.b("AbstractPushNotification", "store new notifyId " + abs + " by notifyKey " + a2.b());
                com.meizu.cloud.pushsdk.util.b.b(this.a, messageV3.getUploadDataPackageName(), a2.b(), abs);
            }
        }
        ym9.b("AbstractPushNotification", "current notify id " + abs);
        if (messageV3.isDiscard()) {
            if (com.meizu.cloud.pushsdk.util.b.c(this.a, messageV3.getPackageName()) == 0) {
                com.meizu.cloud.pushsdk.util.b.a(this.a, messageV3.getPackageName(), abs);
                ym9.d("AbstractPushNotification", "no notification show so put notification id " + abs);
            }
            if (!TextUtils.isEmpty(messageV3.getTaskId())) {
                if (com.meizu.cloud.pushsdk.util.b.d(this.a, messageV3.getPackageName()) == 0) {
                    com.meizu.cloud.pushsdk.util.b.b(this.a, messageV3.getPackageName(), Integer.valueOf(messageV3.getTaskId()).intValue());
                } else if (Integer.valueOf(messageV3.getTaskId()).intValue() < com.meizu.cloud.pushsdk.util.b.d(this.a, messageV3.getPackageName())) {
                    ym9.d("AbstractPushNotification", "current package " + messageV3.getPackageName() + " taskid " + messageV3.getTaskId() + " dont show notification");
                    return;
                } else {
                    com.meizu.cloud.pushsdk.util.b.b(this.a, messageV3.getPackageName(), Integer.valueOf(messageV3.getTaskId()).intValue());
                    abs = com.meizu.cloud.pushsdk.util.b.c(this.a, messageV3.getPackageName());
                }
            }
            ym9.d("AbstractPushNotification", "current package " + messageV3.getPackageName() + " notificationId=" + abs + " taskId=" + messageV3.getTaskId());
        }
        this.d.notify(abs, a);
        a(this.d, abs, messageV3);
    }
}
