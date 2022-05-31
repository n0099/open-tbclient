package com.meizu.cloud.pushsdk.notification.c;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.io.ActionJsonData;
import com.repackage.ni9;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class b {
    public static Field a;
    public static Field b;
    public static Field c;
    public static Object d = new Object();
    public static Map<String, Set<String>> e = new ConcurrentHashMap();

    static {
        try {
            a = Notification.class.getDeclaredField("mFlymeNotification");
            Field declaredField = Class.forName("android.app.NotificationExt").getDeclaredField("internalApp");
            b = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = Notification.class.getDeclaredField("replyIntent");
            c = declaredField2;
            declaredField2.setAccessible(true);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            ni9.b("NotificationUtils", "init NotificationUtils error " + e3.getMessage());
        }
    }

    public static void a(Notification notification, PendingIntent pendingIntent) {
        Field field = c;
        if (field != null) {
            try {
                field.set(notification, pendingIntent);
            } catch (IllegalAccessException e2) {
                ni9.b("NotificationUtils", "setReplyIntent error " + e2.getMessage());
            }
        }
    }

    public static void a(Notification notification, boolean z) {
        Field field = a;
        if (field == null || b == null) {
            return;
        }
        try {
            b.set(field.get(notification), Integer.valueOf(z ? 1 : 0));
        } catch (IllegalAccessException e2) {
            ni9.b("NotificationUtils", "setInternalApp error " + e2.getMessage());
        }
    }

    public static void a(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
    }

    public static void a(Context context, String str) {
        Set<String> set;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        if (notificationManager == null || TextUtils.isEmpty(str) || (set = e.get(str)) == null) {
            return;
        }
        for (String str2 : set) {
            ni9.d("NotificationUtils", "clear notifyId " + str2 + " notification");
            notificationManager.cancel(Integer.parseInt(str2));
        }
        set.clear();
    }

    public static void a(Context context, String str, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        if (notificationManager != null) {
            ni9.d("NotificationUtils", "clear clearNotification notifyId " + i);
            notificationManager.cancel(i);
            Set<String> set = e.get(str);
            if (set != null) {
                set.remove(String.valueOf(i));
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        synchronized (d) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            int i = com.meizu.cloud.pushsdk.util.b.i(context, str, str2);
            ni9.b("NotificationUtils", "removeNotifyKey " + str2 + " notifyId " + i);
            c(context, str, i);
            return com.meizu.cloud.pushsdk.util.b.j(context, str, str2);
        }
    }

    public static void b(Context context, String str, int i) {
        Set<String> set = e.get(str);
        ni9.d("NotificationUtils", "store notifyId " + i);
        if (set != null) {
            set.add(String.valueOf(i));
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(String.valueOf(i));
        e.put(str, hashSet);
    }

    public static void c(Context context, String str, int i) {
        Set<String> set = e.get(str);
        if (set != null) {
            set.remove(String.valueOf(i));
            ni9.d("NotificationUtils", "remove notifyId " + i);
        }
    }
}
