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
    public static Field f38235a;

    /* renamed from: b  reason: collision with root package name */
    public static Field f38236b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f38237c;

    /* renamed from: d  reason: collision with root package name */
    public static Object f38238d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, Set<String>> f38239e = new ConcurrentHashMap();

    static {
        try {
            f38235a = Notification.class.getDeclaredField("mFlymeNotification");
            Field declaredField = Class.forName("android.app.NotificationExt").getDeclaredField("internalApp");
            f38236b = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = Notification.class.getDeclaredField("replyIntent");
            f38237c = declaredField2;
            declaredField2.setAccessible(true);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            d.k.a.a.a.b("NotificationUtils", "init NotificationUtils error " + e3.getMessage());
        }
    }

    public static void a(Notification notification, PendingIntent pendingIntent) {
        Field field = f38237c;
        if (field != null) {
            try {
                field.set(notification, pendingIntent);
            } catch (IllegalAccessException e2) {
                d.k.a.a.a.b("NotificationUtils", "setReplyIntent error " + e2.getMessage());
            }
        }
    }

    public static void a(Notification notification, boolean z) {
        Field field = f38235a;
        if (field == null || f38236b == null) {
            return;
        }
        try {
            f38236b.set(field.get(notification), Integer.valueOf(z ? 1 : 0));
        } catch (IllegalAccessException e2) {
            d.k.a.a.a.b("NotificationUtils", "setInternalApp error " + e2.getMessage());
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
        if (notificationManager == null || TextUtils.isEmpty(str) || (set = f38239e.get(str)) == null) {
            return;
        }
        for (String str2 : set) {
            d.k.a.a.a.d("NotificationUtils", "clear notifyId " + str2 + " notification");
            notificationManager.cancel(Integer.parseInt(str2));
        }
        set.clear();
    }

    public static void a(Context context, String str, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        if (notificationManager != null) {
            d.k.a.a.a.d("NotificationUtils", "clear clearNotification notifyId " + i);
            notificationManager.cancel(i);
            Set<String> set = f38239e.get(str);
            if (set != null) {
                set.remove(String.valueOf(i));
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        synchronized (f38238d) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            int i = com.meizu.cloud.pushsdk.util.b.i(context, str, str2);
            d.k.a.a.a.b("NotificationUtils", "removeNotifyKey " + str2 + " notifyId " + i);
            c(context, str, i);
            return com.meizu.cloud.pushsdk.util.b.j(context, str, str2);
        }
    }

    public static void b(Context context, String str, int i) {
        Set<String> set = f38239e.get(str);
        d.k.a.a.a.d("NotificationUtils", "store notifyId " + i);
        if (set != null) {
            set.add(String.valueOf(i));
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(String.valueOf(i));
        f38239e.put(str, hashSet);
    }

    public static void c(Context context, String str, int i) {
        Set<String> set = f38239e.get(str);
        if (set != null) {
            set.remove(String.valueOf(i));
            d.k.a.a.a.d("NotificationUtils", "remove notifyId " + i);
        }
    }
}
