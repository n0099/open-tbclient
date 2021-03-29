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
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Field f37851a;

    /* renamed from: b  reason: collision with root package name */
    public static Field f37852b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f37853c;

    /* renamed from: d  reason: collision with root package name */
    public static Object f37854d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, Set<String>> f37855e = new ConcurrentHashMap();

    static {
        try {
            f37851a = Notification.class.getDeclaredField("mFlymeNotification");
            Field declaredField = Class.forName("android.app.NotificationExt").getDeclaredField("internalApp");
            f37852b = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = Notification.class.getDeclaredField("replyIntent");
            f37853c = declaredField2;
            declaredField2.setAccessible(true);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            d.j.a.a.a.b("NotificationUtils", "init NotificationUtils error " + e3.getMessage());
        }
    }

    public static void a(Notification notification, PendingIntent pendingIntent) {
        Field field = f37853c;
        if (field != null) {
            try {
                field.set(notification, pendingIntent);
            } catch (IllegalAccessException e2) {
                d.j.a.a.a.b("NotificationUtils", "setReplyIntent error " + e2.getMessage());
            }
        }
    }

    public static void a(Notification notification, boolean z) {
        Field field = f37851a;
        if (field == null || f37852b == null) {
            return;
        }
        try {
            f37852b.set(field.get(notification), Integer.valueOf(z ? 1 : 0));
        } catch (IllegalAccessException e2) {
            d.j.a.a.a.b("NotificationUtils", "setInternalApp error " + e2.getMessage());
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
        if (notificationManager == null || TextUtils.isEmpty(str) || (set = f37855e.get(str)) == null) {
            return;
        }
        for (String str2 : set) {
            d.j.a.a.a.d("NotificationUtils", "clear notifyId " + str2 + " notification");
            notificationManager.cancel(Integer.parseInt(str2));
        }
        set.clear();
    }

    public static void a(Context context, String str, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        if (notificationManager != null) {
            d.j.a.a.a.d("NotificationUtils", "clear clearNotification notifyId " + i);
            notificationManager.cancel(i);
            Set<String> set = f37855e.get(str);
            if (set != null) {
                set.remove(String.valueOf(i));
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        synchronized (f37854d) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            int i = com.meizu.cloud.pushsdk.util.b.i(context, str, str2);
            d.j.a.a.a.b("NotificationUtils", "removeNotifyKey " + str2 + " notifyId " + i);
            c(context, str, i);
            return com.meizu.cloud.pushsdk.util.b.j(context, str, str2);
        }
    }

    public static void b(Context context, String str, int i) {
        Set<String> set = f37855e.get(str);
        d.j.a.a.a.d("NotificationUtils", "store notifyId " + i);
        if (set != null) {
            set.add(String.valueOf(i));
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(String.valueOf(i));
        f37855e.put(str, hashSet);
    }

    public static void c(Context context, String str, int i) {
        Set<String> set = f37855e.get(str);
        if (set != null) {
            set.remove(String.valueOf(i));
            d.j.a.a.a.d("NotificationUtils", "remove notifyId " + i);
        }
    }
}
