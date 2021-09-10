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
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Field f74939a;

    /* renamed from: b  reason: collision with root package name */
    public static Field f74940b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f74941c;

    /* renamed from: d  reason: collision with root package name */
    public static Object f74942d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, Set<String>> f74943e = new ConcurrentHashMap();

    static {
        try {
            f74939a = Notification.class.getDeclaredField("mFlymeNotification");
            Field declaredField = Class.forName("android.app.NotificationExt").getDeclaredField("internalApp");
            f74940b = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = Notification.class.getDeclaredField("replyIntent");
            f74941c = declaredField2;
            declaredField2.setAccessible(true);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            c.l.a.a.a.b("NotificationUtils", "init NotificationUtils error " + e3.getMessage());
        }
    }

    public static void a(Notification notification, PendingIntent pendingIntent) {
        Field field = f74941c;
        if (field != null) {
            try {
                field.set(notification, pendingIntent);
            } catch (IllegalAccessException e2) {
                c.l.a.a.a.b("NotificationUtils", "setReplyIntent error " + e2.getMessage());
            }
        }
    }

    public static void a(Notification notification, boolean z) {
        Field field = f74939a;
        if (field == null || f74940b == null) {
            return;
        }
        try {
            f74940b.set(field.get(notification), Integer.valueOf(z ? 1 : 0));
        } catch (IllegalAccessException e2) {
            c.l.a.a.a.b("NotificationUtils", "setInternalApp error " + e2.getMessage());
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
        if (notificationManager == null || TextUtils.isEmpty(str) || (set = f74943e.get(str)) == null) {
            return;
        }
        for (String str2 : set) {
            c.l.a.a.a.d("NotificationUtils", "clear notifyId " + str2 + " notification");
            notificationManager.cancel(Integer.parseInt(str2));
        }
        set.clear();
    }

    public static void a(Context context, String str, int i2) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        if (notificationManager != null) {
            c.l.a.a.a.d("NotificationUtils", "clear clearNotification notifyId " + i2);
            notificationManager.cancel(i2);
            Set<String> set = f74943e.get(str);
            if (set != null) {
                set.remove(String.valueOf(i2));
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        synchronized (f74942d) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            int i2 = com.meizu.cloud.pushsdk.util.b.i(context, str, str2);
            c.l.a.a.a.b("NotificationUtils", "removeNotifyKey " + str2 + " notifyId " + i2);
            c(context, str, i2);
            return com.meizu.cloud.pushsdk.util.b.j(context, str, str2);
        }
    }

    public static void b(Context context, String str, int i2) {
        Set<String> set = f74943e.get(str);
        c.l.a.a.a.d("NotificationUtils", "store notifyId " + i2);
        if (set != null) {
            set.add(String.valueOf(i2));
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(String.valueOf(i2));
        f74943e.put(str, hashSet);
    }

    public static void c(Context context, String str, int i2) {
        Set<String> set = f74943e.get(str);
        if (set != null) {
            set.remove(String.valueOf(i2));
            c.l.a.a.a.d("NotificationUtils", "remove notifyId " + i2);
        }
    }
}
