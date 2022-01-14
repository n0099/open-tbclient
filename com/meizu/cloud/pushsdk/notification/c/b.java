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
/* loaded from: classes3.dex */
public class b {
    public static Field a;

    /* renamed from: b  reason: collision with root package name */
    public static Field f58804b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f58805c;

    /* renamed from: d  reason: collision with root package name */
    public static Object f58806d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, Set<String>> f58807e = new ConcurrentHashMap();

    static {
        try {
            a = Notification.class.getDeclaredField("mFlymeNotification");
            Field declaredField = Class.forName("android.app.NotificationExt").getDeclaredField("internalApp");
            f58804b = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = Notification.class.getDeclaredField("replyIntent");
            f58805c = declaredField2;
            declaredField2.setAccessible(true);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            c.k.a.a.a.b("NotificationUtils", "init NotificationUtils error " + e3.getMessage());
        }
    }

    public static void a(Notification notification, PendingIntent pendingIntent) {
        Field field = f58805c;
        if (field != null) {
            try {
                field.set(notification, pendingIntent);
            } catch (IllegalAccessException e2) {
                c.k.a.a.a.b("NotificationUtils", "setReplyIntent error " + e2.getMessage());
            }
        }
    }

    public static void a(Notification notification, boolean z) {
        Field field = a;
        if (field == null || f58804b == null) {
            return;
        }
        try {
            f58804b.set(field.get(notification), Integer.valueOf(z ? 1 : 0));
        } catch (IllegalAccessException e2) {
            c.k.a.a.a.b("NotificationUtils", "setInternalApp error " + e2.getMessage());
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
        if (notificationManager == null || TextUtils.isEmpty(str) || (set = f58807e.get(str)) == null) {
            return;
        }
        for (String str2 : set) {
            c.k.a.a.a.d("NotificationUtils", "clear notifyId " + str2 + " notification");
            notificationManager.cancel(Integer.parseInt(str2));
        }
        set.clear();
    }

    public static void a(Context context, String str, int i2) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        if (notificationManager != null) {
            c.k.a.a.a.d("NotificationUtils", "clear clearNotification notifyId " + i2);
            notificationManager.cancel(i2);
            Set<String> set = f58807e.get(str);
            if (set != null) {
                set.remove(String.valueOf(i2));
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        synchronized (f58806d) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            int i2 = com.meizu.cloud.pushsdk.util.b.i(context, str, str2);
            c.k.a.a.a.b("NotificationUtils", "removeNotifyKey " + str2 + " notifyId " + i2);
            c(context, str, i2);
            return com.meizu.cloud.pushsdk.util.b.j(context, str, str2);
        }
    }

    public static void b(Context context, String str, int i2) {
        Set<String> set = f58807e.get(str);
        c.k.a.a.a.d("NotificationUtils", "store notifyId " + i2);
        if (set != null) {
            set.add(String.valueOf(i2));
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(String.valueOf(i2));
        f58807e.put(str, hashSet);
    }

    public static void c(Context context, String str, int i2) {
        Set<String> set = f58807e.get(str);
        if (set != null) {
            set.remove(String.valueOf(i2));
            c.k.a.a.a.d("NotificationUtils", "remove notifyId " + i2);
        }
    }
}
