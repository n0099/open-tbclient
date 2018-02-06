package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tieba.ala.ALaKeepAliveService;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.channel.commonutils.android.b;
import com.xiaomi.push.service.ag;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ac {
    public static long a = 0;
    private static final LinkedList<Pair<Integer, com.xiaomi.xmpush.thrift.ab>> b = new LinkedList<>();

    /* loaded from: classes2.dex */
    public static class a {
        Notification a;
        long b = 0;
    }

    /* loaded from: classes2.dex */
    public static class b {
        public String a;
        public long b = 0;
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    private static Notification a(Notification notification) {
        Object a2 = com.xiaomi.channel.commonutils.reflect.a.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.channel.commonutils.reflect.a.a(a2, "setCustomizedIcon", true);
        }
        return notification;
    }

    private static Notification a(Notification notification, String str) {
        try {
            Field declaredField = Notification.class.getDeclaredField("extraNotification");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(notification);
            Method declaredMethod = obj.getClass().getDeclaredMethod("setTargetPkg", CharSequence.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, str);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
        return notification;
    }

    private static PendingIntent a(Context context, com.xiaomi.xmpush.thrift.ab abVar, com.xiaomi.xmpush.thrift.r rVar, byte[] bArr) {
        if (rVar != null && !TextUtils.isEmpty(rVar.g)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(rVar.g));
            intent.addFlags(268435456);
            return PendingIntent.getActivity(context, 0, intent, 134217728);
        } else if (b(abVar)) {
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent2.putExtra("mipush_payload", bArr);
            intent2.putExtra("mipush_notified", true);
            intent2.addCategory(String.valueOf(rVar.q()));
            return PendingIntent.getService(context, 0, intent2, 134217728);
        } else {
            Intent intent3 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent3.setComponent(new ComponentName(abVar.f, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent3.putExtra("mipush_payload", bArr);
            intent3.putExtra("mipush_notified", true);
            intent3.addCategory(String.valueOf(rVar.q()));
            return PendingIntent.getService(context, 0, intent3, 134217728);
        }
    }

    private static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight > 0 ? intrinsicHeight : 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x010c  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a a(Context context, com.xiaomi.xmpush.thrift.ab abVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent) {
        boolean z;
        long currentTimeMillis;
        Notification notification;
        a aVar = new a();
        com.xiaomi.xmpush.thrift.r m = abVar.m();
        String a2 = a(abVar);
        Map<String, String> s = m.s();
        Notification.Builder builder = new Notification.Builder(context);
        String[] a3 = a(context, m);
        builder.setContentTitle(a3[0]);
        builder.setContentText(a3[1]);
        if (remoteViews != null) {
            builder.setContent(remoteViews);
        } else if (Build.VERSION.SDK_INT >= 16) {
            builder.setStyle(new Notification.BigTextStyle().bigText(a3[1]));
        }
        builder.setWhen(System.currentTimeMillis());
        String str = s == null ? null : s.get("notification_show_when");
        if (!TextUtils.isEmpty(str)) {
            builder.setShowWhen(Boolean.parseBoolean(str));
        } else if (Build.VERSION.SDK_INT >= 24) {
            builder.setShowWhen(true);
        }
        builder.setContentIntent(pendingIntent);
        int a4 = a(context, a2, "mipush_notification");
        int a5 = a(context, a2, "mipush_small_notification");
        if (a4 <= 0 || a5 <= 0) {
            builder.setSmallIcon(f(context, a2));
        } else {
            builder.setLargeIcon(a(context, a4));
            builder.setSmallIcon(a5);
        }
        String str2 = s == null ? null : s.get("__dynamic_icon_uri");
        boolean z2 = (s != null && Boolean.parseBoolean(s.get("__adiom"))) || com.xiaomi.channel.commonutils.android.g.b();
        if (str2 != null && z2) {
            Bitmap bitmap = null;
            if (str2.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                ag.b a6 = ag.a(context, str2);
                if (a6 != null) {
                    bitmap = a6.a;
                    aVar.b = a6.b;
                }
            } else {
                bitmap = ag.b(context, str2);
            }
            if (bitmap != null) {
                builder.setLargeIcon(bitmap);
                z = true;
                if (s != null && Build.VERSION.SDK_INT >= 24) {
                    boolean parseBoolean = Boolean.parseBoolean(s.get("notification_is_summary"));
                    com.xiaomi.channel.commonutils.reflect.a.a(builder, "setGroup", s.get("notification_group"));
                    com.xiaomi.channel.commonutils.reflect.a.a(builder, "setGroupSummary", Boolean.valueOf(parseBoolean));
                }
                builder.setAutoCancel(true);
                currentTimeMillis = System.currentTimeMillis();
                if (s != null && s.containsKey(ALaKeepAliveService.KEY_TICKER)) {
                    builder.setTicker(s.get(ALaKeepAliveService.KEY_TICKER));
                }
                if (currentTimeMillis - a > 10000) {
                    a = currentTimeMillis;
                    int c = e(context, a2) ? c(context, a2) : m.f;
                    builder.setDefaults(c);
                    if (s != null && (c & 1) != 0) {
                        String str3 = s.get("sound_uri");
                        if (!TextUtils.isEmpty(str3) && str3.startsWith("android.resource://" + a2)) {
                            builder.setDefaults(c ^ 1);
                            builder.setSound(Uri.parse(str3));
                        }
                    }
                }
                notification = builder.getNotification();
                if (z && com.xiaomi.channel.commonutils.android.g.a()) {
                    a(notification);
                }
                aVar.a = notification;
                return aVar;
            }
        }
        z = false;
        if (s != null) {
            boolean parseBoolean2 = Boolean.parseBoolean(s.get("notification_is_summary"));
            com.xiaomi.channel.commonutils.reflect.a.a(builder, "setGroup", s.get("notification_group"));
            com.xiaomi.channel.commonutils.reflect.a.a(builder, "setGroupSummary", Boolean.valueOf(parseBoolean2));
        }
        builder.setAutoCancel(true);
        currentTimeMillis = System.currentTimeMillis();
        if (s != null) {
            builder.setTicker(s.get(ALaKeepAliveService.KEY_TICKER));
        }
        if (currentTimeMillis - a > 10000) {
        }
        notification = builder.getNotification();
        if (z) {
            a(notification);
        }
        aVar.a = notification;
        return aVar;
    }

    public static b a(Context context, com.xiaomi.xmpush.thrift.ab abVar, byte[] bArr) {
        Notification notification;
        b bVar = new b();
        if (com.xiaomi.channel.commonutils.android.b.d(context, a(abVar)) == b.a.NOT_ALLOWED) {
            com.xiaomi.channel.commonutils.logger.b.a("Do not notify because user block " + a(abVar) + "‘s notification");
            return bVar;
        } else if (ay.a(context, abVar)) {
            com.xiaomi.channel.commonutils.logger.b.a("Do not notify because user block " + ay.a(abVar) + "‘s notification");
            return bVar;
        } else {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            com.xiaomi.xmpush.thrift.r m = abVar.m();
            RemoteViews b2 = b(context, abVar, bArr);
            PendingIntent a2 = a(context, abVar, m, bArr);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.a("The click PendingIntent is null. ");
                return bVar;
            }
            if (Build.VERSION.SDK_INT >= 11) {
                a a3 = a(context, abVar, bArr, b2, a2);
                bVar.b = a3.b;
                bVar.a = a(abVar);
                notification = a3.a;
            } else {
                Notification notification2 = new Notification(f(context, a(abVar)), null, System.currentTimeMillis());
                String[] a4 = a(context, m);
                try {
                    notification2.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification2, context, a4[0], a4[1], a2);
                } catch (IllegalAccessException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                } catch (IllegalArgumentException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                } catch (NoSuchMethodException e3) {
                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                } catch (InvocationTargetException e4) {
                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                }
                Map<String, String> s = m.s();
                if (s != null && s.containsKey(ALaKeepAliveService.KEY_TICKER)) {
                    notification2.tickerText = s.get(ALaKeepAliveService.KEY_TICKER);
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - a > 10000) {
                    a = currentTimeMillis;
                    int c = e(context, a(abVar)) ? c(context, a(abVar)) : m.f;
                    notification2.defaults = c;
                    if (s != null && (c & 1) != 0) {
                        String str = s.get("sound_uri");
                        if (!TextUtils.isEmpty(str) && str.startsWith("android.resource://" + a(abVar))) {
                            notification2.defaults = c ^ 1;
                            notification2.sound = Uri.parse(str);
                        }
                    }
                }
                notification2.flags |= 16;
                if (b2 != null) {
                    notification2.contentView = b2;
                }
                notification = notification2;
            }
            if (com.xiaomi.channel.commonutils.android.g.a() && Build.VERSION.SDK_INT >= 19 && !TextUtils.isEmpty(m.b())) {
                notification.extras.putString("message_id", m.b());
            }
            String str2 = m.s() == null ? null : m.s().get("message_count");
            if (com.xiaomi.channel.commonutils.android.g.a() && str2 != null) {
                try {
                    a(notification, Integer.parseInt(str2));
                } catch (NumberFormatException e5) {
                    com.xiaomi.channel.commonutils.logger.b.a(e5);
                }
            }
            if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
                a(notification, a(abVar));
            }
            if ("com.xiaomi.xmsf".equals(a(abVar))) {
                ay.a(context, abVar, notification);
            }
            int q = m.q() + ((a(abVar).hashCode() / 10) * 10);
            notificationManager.notify(q, notification);
            Pair<Integer, com.xiaomi.xmpush.thrift.ab> pair = new Pair<>(Integer.valueOf(q), abVar);
            synchronized (b) {
                b.add(pair);
                if (b.size() > 100) {
                    b.remove();
                }
            }
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(com.xiaomi.xmpush.thrift.ab abVar) {
        com.xiaomi.xmpush.thrift.r m;
        if ("com.xiaomi.xmsf".equals(abVar.f) && (m = abVar.m()) != null && m.s() != null) {
            String str = m.s().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return abVar.f;
    }

    private static void a(Notification notification, int i) {
        Object a2 = com.xiaomi.channel.commonutils.reflect.a.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.channel.commonutils.reflect.a.a(a2, "setMessageCount", Integer.valueOf(i));
        }
    }

    public static void a(Context context, String str, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        int hashCode = ((str.hashCode() / 10) * 10) + i;
        LinkedList linkedList = new LinkedList();
        if (i >= 0) {
            notificationManager.cancel(hashCode);
        }
        synchronized (b) {
            Iterator<Pair<Integer, com.xiaomi.xmpush.thrift.ab>> it = b.iterator();
            while (it.hasNext()) {
                Pair<Integer, com.xiaomi.xmpush.thrift.ab> next = it.next();
                com.xiaomi.xmpush.thrift.ab abVar = (com.xiaomi.xmpush.thrift.ab) next.second;
                if (abVar != null) {
                    String a2 = a(abVar);
                    if (i >= 0) {
                        if (hashCode == ((Integer) next.first).intValue() && TextUtils.equals(a2, str)) {
                            linkedList.add(next);
                        }
                    } else if (i == -1 && TextUtils.equals(a2, str)) {
                        notificationManager.cancel(((Integer) next.first).intValue());
                        linkedList.add(next);
                    }
                }
            }
            if (b != null) {
                b.removeAll(linkedList);
                a(linkedList);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        LinkedList linkedList = new LinkedList();
        synchronized (b) {
            Iterator<Pair<Integer, com.xiaomi.xmpush.thrift.ab>> it = b.iterator();
            while (it.hasNext()) {
                Pair<Integer, com.xiaomi.xmpush.thrift.ab> next = it.next();
                com.xiaomi.xmpush.thrift.ab abVar = (com.xiaomi.xmpush.thrift.ab) next.second;
                if (abVar != null) {
                    String a2 = a(abVar);
                    com.xiaomi.xmpush.thrift.r m = abVar.m();
                    if (m != null && TextUtils.equals(a2, str)) {
                        String h = m.h();
                        String j = m.j();
                        if (!TextUtils.isEmpty(h) && !TextUtils.isEmpty(j) && a(str2, h) && a(str3, j)) {
                            notificationManager.cancel(((Integer) next.first).intValue());
                            linkedList.add(next);
                        }
                    }
                }
            }
            if (b != null) {
                b.removeAll(linkedList);
                a(linkedList);
            }
        }
    }

    private static void a(LinkedList<Pair<Integer, com.xiaomi.xmpush.thrift.ab>> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        aw.a().a("category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    public static boolean a(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    public static boolean a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    private static String[] a(Context context, com.xiaomi.xmpush.thrift.r rVar) {
        String h = rVar.h();
        String j = rVar.j();
        Map<String, String> s = rVar.s();
        if (s != null) {
            int intValue = Float.valueOf((context.getResources().getDisplayMetrics().widthPixels / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (intValue <= 320) {
                String str = s.get("title_short");
                if (!TextUtils.isEmpty(str)) {
                    h = str;
                }
                String str2 = s.get("description_short");
                if (TextUtils.isEmpty(str2)) {
                    str2 = j;
                }
                j = str2;
            } else if (intValue > 360) {
                String str3 = s.get("title_long");
                if (!TextUtils.isEmpty(str3)) {
                    h = str3;
                }
                String str4 = s.get("description_long");
                if (!TextUtils.isEmpty(str4)) {
                    j = str4;
                }
            }
        }
        return new String[]{h, j};
    }

    private static RemoteViews b(Context context, com.xiaomi.xmpush.thrift.ab abVar, byte[] bArr) {
        com.xiaomi.xmpush.thrift.r m = abVar.m();
        String a2 = a(abVar);
        Map<String, String> s = m.s();
        if (s == null) {
            return null;
        }
        String str = s.get("layout_name");
        String str2 = s.get("layout_value");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a2);
            int identifier = resourcesForApplication.getIdentifier(str, "layout", a2);
            if (identifier == 0) {
                return null;
            }
            RemoteViews remoteViews = new RemoteViews(a2, identifier);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has("text")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = jSONObject2.getString(next);
                        int identifier2 = resourcesForApplication.getIdentifier(next, "id", a2);
                        if (identifier2 > 0) {
                            remoteViews.setTextViewText(identifier2, string);
                        }
                    }
                }
                if (jSONObject.has("image")) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                    Iterator<String> keys2 = jSONObject3.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        String string2 = jSONObject3.getString(next2);
                        int identifier3 = resourcesForApplication.getIdentifier(next2, "id", a2);
                        int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", a2);
                        if (identifier3 > 0) {
                            remoteViews.setImageViewResource(identifier3, identifier4);
                        }
                    }
                }
                if (jSONObject.has(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME)) {
                    JSONObject jSONObject4 = jSONObject.getJSONObject(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    Iterator<String> keys3 = jSONObject4.keys();
                    while (keys3.hasNext()) {
                        String next3 = keys3.next();
                        String string3 = jSONObject4.getString(next3);
                        if (string3.length() == 0) {
                            string3 = "yy-MM-dd hh:mm";
                        }
                        int identifier5 = resourcesForApplication.getIdentifier(next3, "id", a2);
                        if (identifier5 > 0) {
                            remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                        }
                    }
                }
                return remoteViews;
            } catch (JSONException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    public static void b(Context context, String str) {
        a(context, str, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    public static boolean b(com.xiaomi.xmpush.thrift.ab abVar) {
        com.xiaomi.xmpush.thrift.r m = abVar.m();
        return m != null && m.v();
    }

    static int c(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    private static int f(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return (a2 != 0 || Build.VERSION.SDK_INT < 9) ? a2 : context.getApplicationInfo().logo;
    }
}
