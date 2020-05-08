package com.meizu.cloud.pushsdk.notification.c;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.io.ActionJsonData;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class b {
    private static Field a;
    private static Field b;
    private static Field c;
    private static Object d = new Object();
    private static Map<String, Set<String>> e = new ConcurrentHashMap();

    static {
        a = null;
        b = null;
        try {
            a = Notification.class.getDeclaredField("mFlymeNotification");
            b = Class.forName("android.app.NotificationExt").getDeclaredField("internalApp");
            b.setAccessible(true);
            c = Notification.class.getDeclaredField("replyIntent");
            c.setAccessible(true);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            com.meizu.cloud.a.a.e("NotificationUtils", "init NotificationUtils error " + e3.getMessage());
        }
    }

    public static void a(Notification notification, PendingIntent pendingIntent) {
        if (c != null) {
            try {
                c.set(notification, pendingIntent);
            } catch (IllegalAccessException e2) {
                com.meizu.cloud.a.a.e("NotificationUtils", "setReplyIntent error " + e2.getMessage());
            }
        }
    }

    public static void a(Notification notification, boolean z) {
        if (a == null || b == null) {
            return;
        }
        try {
            b.set(a.get(notification), Integer.valueOf(z ? 1 : 0));
        } catch (IllegalAccessException e2) {
            com.meizu.cloud.a.a.e("NotificationUtils", "setInternalApp error " + e2.getMessage());
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
            com.meizu.cloud.a.a.i("NotificationUtils", "clear notifyId " + str2 + " notification");
            notificationManager.cancel(Integer.parseInt(str2));
        }
        set.clear();
    }

    public static void a(Context context, String str, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        if (notificationManager != null) {
            com.meizu.cloud.a.a.i("NotificationUtils", "clear clearNotification notifyId " + i);
            notificationManager.cancel(i);
            Set<String> set = e.get(str);
            if (set != null) {
                set.remove(String.valueOf(i));
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        boolean z;
        synchronized (d) {
            if (TextUtils.isEmpty(str2)) {
                z = false;
            } else {
                int i = com.meizu.cloud.pushsdk.util.b.i(context, str, str2);
                com.meizu.cloud.a.a.e("NotificationUtils", "removeNotifyKey " + str2 + " notifyId " + i);
                c(context, str, i);
                z = com.meizu.cloud.pushsdk.util.b.j(context, str, str2);
            }
        }
        return z;
    }

    public static void b(Context context, String str, int i) {
        Set<String> set = e.get(str);
        com.meizu.cloud.a.a.i("NotificationUtils", "store notifyId " + i);
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
            com.meizu.cloud.a.a.i("NotificationUtils", "remove notifyId " + i);
        }
    }
}
