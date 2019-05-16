package com.xiaomi.mipush.sdk;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.tieba.ala.ALaKeepAliveService;
import com.coloros.mcssdk.PushManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes3.dex */
public class MIPushNotificationHelper4Hybrid {
    public static final String KEY_CATEGORY = "miui.category";
    public static final String KEY_MESSAGE_ID = "message_id";
    public static final String KEY_SCORE_INFO = "score_info";
    public static final String KEY_SUBST_NAME = "miui.substName";
    private static final LinkedList<a> a = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        int a;
        String b;
        MiPushMessage c;

        public a(int i, String str, MiPushMessage miPushMessage) {
            this.a = i;
            this.b = str;
            this.c = miPushMessage;
        }
    }

    private static Notification a(Notification notification) {
        Object a2 = com.xiaomi.channel.commonutils.reflect.a.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.channel.commonutils.reflect.a.a(a2, "setCustomizedIcon", true);
        }
        return notification;
    }

    @SuppressLint({"NewApi"})
    private static Notification a(Context context, MiPushMessage miPushMessage, PendingIntent pendingIntent, Bitmap bitmap) {
        boolean z;
        Map<String, String> extra = miPushMessage.getExtra();
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(miPushMessage.getTitle());
        builder.setContentText(miPushMessage.getDescription());
        if (Build.VERSION.SDK_INT >= 16) {
            builder.setStyle(new Notification.BigTextStyle().bigText(miPushMessage.getDescription()));
        }
        builder.setWhen(System.currentTimeMillis());
        String str = extra == null ? null : extra.get("notification_show_when");
        if (!TextUtils.isEmpty(str)) {
            builder.setShowWhen(Boolean.parseBoolean(str));
        } else if (Build.VERSION.SDK_INT >= 24) {
            builder.setShowWhen(true);
        }
        builder.setContentIntent(pendingIntent);
        int i = context.getApplicationInfo().icon;
        if (i == 0 && Build.VERSION.SDK_INT >= 9) {
            i = context.getApplicationInfo().logo;
        }
        builder.setSmallIcon(i);
        if (bitmap != null) {
            builder.setLargeIcon(bitmap);
            z = true;
        } else {
            z = false;
        }
        if (extra != null && Build.VERSION.SDK_INT >= 24) {
            boolean parseBoolean = Boolean.parseBoolean(extra.get("notification_is_summary"));
            com.xiaomi.channel.commonutils.reflect.a.a(builder, "setGroup", extra.get("notification_group"));
            com.xiaomi.channel.commonutils.reflect.a.a(builder, "setGroupSummary", Boolean.valueOf(parseBoolean));
        }
        builder.setAutoCancel(true);
        long currentTimeMillis = System.currentTimeMillis();
        if (extra != null && extra.containsKey(ALaKeepAliveService.KEY_TICKER)) {
            builder.setTicker(extra.get(ALaKeepAliveService.KEY_TICKER));
        }
        if (currentTimeMillis - com.xiaomi.push.service.ah.a > 10000) {
            com.xiaomi.push.service.ah.a = currentTimeMillis;
            builder.setDefaults(miPushMessage.getNotifyType());
        }
        Notification notification = builder.getNotification();
        if (z && com.xiaomi.channel.commonutils.android.f.a()) {
            a(notification);
        }
        return notification;
    }

    private static PendingIntent a(Context context, String str, MiPushMessage miPushMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setComponent(new ComponentName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushMessageHandler"));
        intent.setAction("com.xiaomi.mipush.sdk.HYBRID_NOTIFICATION_CLICK");
        intent.putExtra("mipush_payload", miPushMessage);
        intent.putExtra("mipush_hybrid_app_pkg", str);
        intent.putExtra("mipush_notified", true);
        intent.addCategory(String.valueOf(miPushMessage.getNotifyId()));
        return PendingIntent.getService(context, 0, intent, 134217728);
    }

    private static void a(Notification notification, String str) {
        try {
            Object a2 = com.xiaomi.channel.commonutils.reflect.a.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.channel.commonutils.reflect.a.b(a2, "setMessageClassName", str);
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("Get null extraNotification, setShortcutId failed.");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void clearNotification(Context context, String str) {
        clearNotification(context, str, -1);
    }

    public static void clearNotification(Context context, String str, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(PushManager.MESSAGE_TYPE_NOTI);
        int hashCode = ((str.hashCode() / 10) * 10) + i;
        LinkedList linkedList = new LinkedList();
        if (i >= 0) {
            notificationManager.cancel(hashCode);
        }
        synchronized (a) {
            Iterator<a> it = a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (i >= 0) {
                    if (hashCode == next.a && TextUtils.equals(str, next.b)) {
                        linkedList.add(next);
                    }
                } else if (i == -1 && TextUtils.equals(str, next.b)) {
                    notificationManager.cancel(next.a);
                    linkedList.add(next);
                }
            }
            if (a != null) {
                a.removeAll(linkedList);
                com.xiaomi.push.service.ah.a(context, linkedList);
            }
        }
    }

    public static void notifyPushMessage(Context context, MiPushMessage miPushMessage, Bitmap bitmap, String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(PushManager.MESSAGE_TYPE_NOTI);
        PendingIntent a2 = a(context, str, miPushMessage);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.a("The click PendingIntent is null. ");
            return;
        }
        Notification a3 = a(context, miPushMessage, a2, bitmap);
        if (com.xiaomi.channel.commonutils.android.f.a()) {
            if (Build.VERSION.SDK_INT >= 19) {
                if (!TextUtils.isEmpty(miPushMessage.getMessageId())) {
                    a3.extras.putString(KEY_MESSAGE_ID, miPushMessage.getMessageId());
                }
                String str4 = miPushMessage.getExtra() == null ? null : miPushMessage.getExtra().get(KEY_SCORE_INFO);
                if (!TextUtils.isEmpty(str4)) {
                    a3.extras.putString(KEY_SCORE_INFO, str4);
                }
                if (!TextUtils.isEmpty(str)) {
                    a3.extras.putString(KEY_CATEGORY, str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    a3.extras.putString(KEY_SUBST_NAME, str2);
                }
            }
            if (!TextUtils.isEmpty(str3)) {
                a(a3, str3);
            }
        }
        int notifyId = miPushMessage.getNotifyId();
        if (str != null) {
            notifyId += (str.hashCode() / 10) * 10;
        }
        notificationManager.notify(notifyId, a3);
        a aVar = new a(notifyId, str, miPushMessage);
        synchronized (a) {
            a.add(aVar);
            if (a.size() > 100) {
                a.remove();
            }
        }
    }
}
