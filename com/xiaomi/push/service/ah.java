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
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tieba.ala.ALaKeepAliveService;
import com.coloros.mcssdk.PushManager;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.channel.commonutils.android.a;
import com.xiaomi.mipush.sdk.MIPushNotificationHelper4Hybrid;
import com.xiaomi.push.service.am;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ah {
    public static long a = 0;
    private static final LinkedList<Pair<Integer, com.xiaomi.xmpush.thrift.af>> b = new LinkedList<>();
    private static ExecutorService c = Executors.newCachedThreadPool();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Callable<Bitmap> {
        private String a;
        private Context b;
        private boolean c;

        public a(String str, Context context, boolean z) {
            this.b = context;
            this.a = str;
            this.c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Bitmap call() {
            if (TextUtils.isEmpty(this.a)) {
                com.xiaomi.channel.commonutils.logger.b.a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            } else if (this.a.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                am.b a = am.a(this.b, this.a, this.c);
                if (a != null) {
                    return a.a;
                }
                com.xiaomi.channel.commonutils.logger.b.a("Failed get online picture/icon resource");
                return null;
            } else {
                Bitmap a2 = am.a(this.b, this.a);
                if (a2 == null) {
                    com.xiaomi.channel.commonutils.logger.b.a("Failed get online picture/icon resource");
                    return a2;
                }
                return a2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        Notification a;
        long b = 0;
    }

    /* loaded from: classes3.dex */
    public static class c {
        public String a;
        public long b = 0;
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    private static Notification.Builder a(Notification.Builder builder, Context context, String str, Map<String, String> map) {
        PendingIntent a2 = a(context, str, 1, map);
        if (a2 != null && !TextUtils.isEmpty(map.get("notification_style_button_left_name"))) {
            builder.addAction(0, map.get("notification_style_button_left_name"), a2);
        }
        PendingIntent a3 = a(context, str, 2, map);
        if (a3 != null && !TextUtils.isEmpty(map.get("notification_style_button_mid_name"))) {
            builder.addAction(0, map.get("notification_style_button_mid_name"), a3);
        }
        PendingIntent a4 = a(context, str, 3, map);
        if (a4 != null && !TextUtils.isEmpty(map.get("notification_style_button_right_name"))) {
            builder.addAction(0, map.get("notification_style_button_right_name"), a4);
        }
        return builder;
    }

    private static Notification.Builder a(Context context, Map<String, String> map, Notification.Builder builder, String str) {
        if ("2".equals(map.get("notification_style_type"))) {
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(builder);
            Bitmap a2 = map == null ? null : a(context, map.get("notification_bigPic_uri"), false);
            if (a2 != null) {
                bigPictureStyle.bigPicture(a2);
                bigPictureStyle.bigLargeIcon((Bitmap) null);
                builder.setStyle(bigPictureStyle);
            }
        } else if ("1".equals(map.get("notification_style_type"))) {
            builder.setStyle(new Notification.BigTextStyle().bigText(str));
        }
        return builder;
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

    private static PendingIntent a(Context context, com.xiaomi.xmpush.thrift.af afVar, com.xiaomi.xmpush.thrift.u uVar, byte[] bArr) {
        Intent intent;
        int i = -1;
        if (d(afVar)) {
            i = 1000;
        } else if (b(afVar)) {
            i = 3000;
        }
        String b2 = uVar != null ? uVar.b() : "";
        if (uVar != null && !TextUtils.isEmpty(uVar.g)) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(uVar.g));
            intent.addFlags(268435456);
        } else if (b(afVar)) {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(uVar.q()));
        } else {
            intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.setComponent(new ComponentName(afVar.f, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(uVar.q()));
        }
        intent.putExtra("messageId", b2);
        intent.putExtra("eventMessageType", i);
        return PendingIntent.getService(context, 0, intent, 134217728);
    }

    private static PendingIntent a(Context context, String str, int i, Map<String, String> map) {
        Intent b2;
        if (map == null || (b2 = b(context, str, i, map)) == null) {
            return null;
        }
        return PendingIntent.getActivity(context, 0, b2, 0);
    }

    private static Intent a(Context context, Intent intent) {
        try {
            if (context.getPackageManager().getPackageInfo("com.android.browser", 4) != null) {
                intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
            }
        } catch (PackageManager.NameNotFoundException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
        return intent;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private static Bitmap a(Context context, String str, boolean z) {
        Future submit = c.submit(new a(str, context, z));
        try {
            try {
                Bitmap bitmap = (Bitmap) submit.get(180L, TimeUnit.SECONDS);
                if (bitmap == null) {
                    submit.cancel(true);
                    return bitmap;
                }
                return bitmap;
            } catch (InterruptedException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                if (0 == 0) {
                    submit.cancel(true);
                }
                return null;
            } catch (ExecutionException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                if (0 == 0) {
                    submit.cancel(true);
                }
                return null;
            } catch (TimeoutException e3) {
                com.xiaomi.channel.commonutils.logger.b.a(e3);
                if (0 == 0) {
                    submit.cancel(true);
                }
                return null;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                submit.cancel(true);
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017c A[Catch: Exception -> 0x02f8, TRY_LEAVE, TryCatch #1 {Exception -> 0x02f8, blocks: (B:61:0x016d, B:63:0x017c), top: B:120:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x020d  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static b a(Context context, com.xiaomi.xmpush.thrift.af afVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent) {
        boolean z;
        Bitmap a2;
        long currentTimeMillis;
        Notification notification;
        int b2;
        String str;
        String str2;
        NotificationManager notificationManager;
        String str3;
        String str4;
        b bVar = new b();
        com.xiaomi.xmpush.thrift.u m = afVar.m();
        String a3 = a(afVar);
        Map<String, String> s = m.s();
        Notification.Builder builder = new Notification.Builder(context);
        String[] a4 = a(context, m);
        builder.setContentTitle(a4[0]);
        builder.setContentText(a4[1]);
        if (remoteViews != null) {
            builder.setContent(remoteViews);
        } else if (Build.VERSION.SDK_INT >= 16 && s != null && s.containsKey("notification_style_type")) {
            builder = a(context, s, builder, a4[1]);
        }
        Notification.Builder a5 = a(builder, context, afVar.j(), s);
        a5.setWhen(System.currentTimeMillis());
        String str5 = s == null ? null : s.get("notification_show_when");
        if (!TextUtils.isEmpty(str5)) {
            a5.setShowWhen(Boolean.parseBoolean(str5));
        } else if (Build.VERSION.SDK_INT >= 24) {
            a5.setShowWhen(true);
        }
        a5.setContentIntent(pendingIntent);
        a5.setSmallIcon(f(context, a3));
        String str6 = s == null ? null : s.get("__dynamic_icon_uri");
        boolean z2 = (s != null && Boolean.parseBoolean(s.get("__adiom"))) || !com.xiaomi.channel.commonutils.android.f.a();
        if (str6 != null && z2) {
            Bitmap bitmap = null;
            if (str6.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                am.b a6 = am.a(context, str6, true);
                if (a6 != null) {
                    bitmap = a6.a;
                    bVar.b = a6.b;
                }
            } else {
                bitmap = am.a(context, str6);
            }
            if (bitmap != null) {
                a5.setLargeIcon(bitmap);
                z = true;
                a2 = s != null ? null : a(context, s.get("notification_large_icon_uri"), true);
                if (a2 != null) {
                    a5.setLargeIcon(a2);
                }
                if (s != null && Build.VERSION.SDK_INT >= 24) {
                    str4 = s.get("notification_group");
                    boolean parseBoolean = Boolean.parseBoolean(s.get("notification_is_summary"));
                    if (TextUtils.isEmpty(str4)) {
                        str4 = a(afVar);
                        if (com.xiaomi.channel.commonutils.android.f.e()) {
                            str4 = str4 + m.q();
                        }
                    }
                    com.xiaomi.channel.commonutils.reflect.a.a(a5, "setGroup", str4);
                    com.xiaomi.channel.commonutils.reflect.a.a(a5, "setGroupSummary", Boolean.valueOf(parseBoolean));
                }
                if (s != null && Build.VERSION.SDK_INT >= 26) {
                    if (b(s) > 0) {
                        com.xiaomi.channel.commonutils.reflect.a.a(a5, "setTimeoutAfter", Long.valueOf(b2 * 1000));
                    }
                    str = s.get("channel_id");
                    if (TextUtils.isEmpty(str) || context.getApplicationInfo().targetSdkVersion >= 26) {
                        str2 = !TextUtils.isEmpty(str) ? "default_channel_mi_push" : str;
                        com.xiaomi.channel.commonutils.reflect.a.a(a5, "setChannelId", str2);
                        notificationManager = (NotificationManager) context.getSystemService(PushManager.MESSAGE_TYPE_NOTI);
                        try {
                            if (com.xiaomi.channel.commonutils.reflect.a.a(notificationManager, "getNotificationChannel", str2) == null) {
                                com.xiaomi.channel.commonutils.reflect.a.a(notificationManager, "createNotificationChannel", Class.forName("android.app.NotificationChannel").getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance(str2, PushManager.MESSAGE_TYPE_NOTI, 3));
                            }
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                        }
                    }
                    str3 = s.get("background_color");
                    if (!TextUtils.isEmpty(str3)) {
                        try {
                            int parseInt = Integer.parseInt(str3);
                            a5.setOngoing(true);
                            a5.setColor(parseInt);
                            com.xiaomi.channel.commonutils.reflect.a.a(a5, "setColorized", true);
                        } catch (Exception e2) {
                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                        }
                    }
                }
                a5.setAutoCancel(true);
                currentTimeMillis = System.currentTimeMillis();
                if (s != null && s.containsKey(ALaKeepAliveService.KEY_TICKER)) {
                    a5.setTicker(s.get(ALaKeepAliveService.KEY_TICKER));
                }
                if (currentTimeMillis - a > 10000) {
                    a = currentTimeMillis;
                    int c2 = e(context, a3) ? c(context, a3) : m.f;
                    a5.setDefaults(c2);
                    if (s != null && (c2 & 1) != 0) {
                        String str7 = s.get("sound_uri");
                        if (!TextUtils.isEmpty(str7) && str7.startsWith("android.resource://" + a3)) {
                            a5.setDefaults(c2 ^ 1);
                            a5.setSound(Uri.parse(str7));
                        }
                    }
                }
                if (com.xiaomi.channel.commonutils.android.f.e() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                    com.xiaomi.channel.commonutils.reflect.a.a("miui.util.NotificationHelper", "setTargetPkg", context, a5, a(afVar));
                }
                notification = a5.getNotification();
                if (z && com.xiaomi.channel.commonutils.android.f.a()) {
                    a(notification);
                }
                bVar.a = notification;
                return bVar;
            }
        }
        z = false;
        if (s != null) {
        }
        if (a2 != null) {
        }
        if (s != null) {
            str4 = s.get("notification_group");
            boolean parseBoolean2 = Boolean.parseBoolean(s.get("notification_is_summary"));
            if (TextUtils.isEmpty(str4)) {
            }
            com.xiaomi.channel.commonutils.reflect.a.a(a5, "setGroup", str4);
            com.xiaomi.channel.commonutils.reflect.a.a(a5, "setGroupSummary", Boolean.valueOf(parseBoolean2));
        }
        if (s != null) {
            if (b(s) > 0) {
            }
            str = s.get("channel_id");
            if (TextUtils.isEmpty(str)) {
            }
            if (!TextUtils.isEmpty(str)) {
            }
            com.xiaomi.channel.commonutils.reflect.a.a(a5, "setChannelId", str2);
            notificationManager = (NotificationManager) context.getSystemService(PushManager.MESSAGE_TYPE_NOTI);
            if (com.xiaomi.channel.commonutils.reflect.a.a(notificationManager, "getNotificationChannel", str2) == null) {
            }
            str3 = s.get("background_color");
            if (!TextUtils.isEmpty(str3)) {
            }
        }
        a5.setAutoCancel(true);
        currentTimeMillis = System.currentTimeMillis();
        if (s != null) {
            a5.setTicker(s.get(ALaKeepAliveService.KEY_TICKER));
        }
        if (currentTimeMillis - a > 10000) {
        }
        if (com.xiaomi.channel.commonutils.android.f.e()) {
            com.xiaomi.channel.commonutils.reflect.a.a("miui.util.NotificationHelper", "setTargetPkg", context, a5, a(afVar));
        }
        notification = a5.getNotification();
        if (z) {
            a(notification);
        }
        bVar.a = notification;
        return bVar;
    }

    public static c a(Context context, com.xiaomi.xmpush.thrift.af afVar, byte[] bArr) {
        Notification notification;
        c cVar = new c();
        if (com.xiaomi.channel.commonutils.android.a.c(context, a(afVar)) == a.EnumC0477a.NOT_ALLOWED) {
            com.xiaomi.xmpush.thrift.u m = afVar.m();
            if (m != null) {
                com.xiaomi.push.service.clientReport.d.a(context.getApplicationContext()).a(f(afVar), m.b(), "Do not notify because user block " + a(afVar) + "‘s notification");
            }
            com.xiaomi.channel.commonutils.logger.b.a("Do not notify because user block " + a(afVar) + "‘s notification");
            return cVar;
        } else if (bm.a(context, afVar)) {
            String a2 = bm.a(afVar);
            com.xiaomi.xmpush.thrift.u m2 = afVar.m();
            if (m2 != null) {
                com.xiaomi.push.service.clientReport.d.a(context.getApplicationContext()).a(f(afVar), m2.b(), "Do not notify because user block " + a2 + "‘s notification");
            }
            com.xiaomi.channel.commonutils.logger.b.a("Do not notify because user block " + a2 + "‘s notification");
            return cVar;
        } else {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(PushManager.MESSAGE_TYPE_NOTI);
            com.xiaomi.xmpush.thrift.u m3 = afVar.m();
            RemoteViews b2 = b(context, afVar, bArr);
            PendingIntent a3 = a(context, afVar, m3, bArr);
            if (a3 == null) {
                if (m3 != null) {
                    com.xiaomi.push.service.clientReport.d.a(context.getApplicationContext()).a(f(afVar), m3.b(), "The click PendingIntent is null. ");
                }
                com.xiaomi.channel.commonutils.logger.b.a("The click PendingIntent is null. ");
                return cVar;
            }
            if (Build.VERSION.SDK_INT >= 11) {
                b a4 = a(context, afVar, bArr, b2, a3);
                cVar.b = a4.b;
                cVar.a = a(afVar);
                notification = a4.a;
            } else {
                Notification notification2 = new Notification(f(context, a(afVar)), null, System.currentTimeMillis());
                String[] a5 = a(context, m3);
                try {
                    notification2.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification2, context, a5[0], a5[1], a3);
                } catch (IllegalAccessException e) {
                    if (m3 != null) {
                        com.xiaomi.push.service.clientReport.d.a(context.getApplicationContext()).a(f(afVar), m3.b(), e);
                    }
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                } catch (IllegalArgumentException e2) {
                    if (m3 != null) {
                        com.xiaomi.push.service.clientReport.d.a(context.getApplicationContext()).a(f(afVar), m3.b(), e2);
                    }
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                } catch (NoSuchMethodException e3) {
                    if (m3 != null) {
                        com.xiaomi.push.service.clientReport.d.a(context.getApplicationContext()).a(f(afVar), m3.b(), e3);
                    }
                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                } catch (InvocationTargetException e4) {
                    if (m3 != null) {
                        com.xiaomi.push.service.clientReport.d.a(context.getApplicationContext()).a(f(afVar), m3.b(), e4);
                    }
                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                }
                Map<String, String> s = m3.s();
                if (s != null && s.containsKey(ALaKeepAliveService.KEY_TICKER)) {
                    notification2.tickerText = s.get(ALaKeepAliveService.KEY_TICKER);
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - a > 10000) {
                    a = currentTimeMillis;
                    int c2 = e(context, a(afVar)) ? c(context, a(afVar)) : m3.f;
                    notification2.defaults = c2;
                    if (s != null && (c2 & 1) != 0) {
                        String str = s.get("sound_uri");
                        if (!TextUtils.isEmpty(str) && str.startsWith("android.resource://" + a(afVar))) {
                            notification2.defaults = c2 ^ 1;
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
            if (com.xiaomi.channel.commonutils.android.f.a() && Build.VERSION.SDK_INT >= 19) {
                if (!TextUtils.isEmpty(m3.b())) {
                    notification.extras.putString(MIPushNotificationHelper4Hybrid.KEY_MESSAGE_ID, m3.b());
                }
                String str2 = m3.u() == null ? null : m3.u().get(MIPushNotificationHelper4Hybrid.KEY_SCORE_INFO);
                if (!TextUtils.isEmpty(str2)) {
                    notification.extras.putString(MIPushNotificationHelper4Hybrid.KEY_SCORE_INFO, str2);
                }
                int i = -1;
                if (d(afVar)) {
                    i = 1000;
                } else if (b(afVar)) {
                    i = 3000;
                }
                notification.extras.putString("eventMessageType", String.valueOf(i));
            }
            String str3 = m3.s() == null ? null : m3.s().get("message_count");
            if (com.xiaomi.channel.commonutils.android.f.a() && str3 != null) {
                try {
                    a(notification, Integer.parseInt(str3));
                } catch (NumberFormatException e5) {
                    if (m3 != null) {
                        com.xiaomi.push.service.clientReport.d.a(context.getApplicationContext()).a(f(afVar), m3.b(), e5);
                    }
                    com.xiaomi.channel.commonutils.logger.b.a(e5);
                }
            }
            if (!com.xiaomi.channel.commonutils.android.f.e() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                a(notification, a(afVar));
            }
            if ("com.xiaomi.xmsf".equals(a(afVar))) {
                bm.a(context, afVar, notification);
            }
            int q = m3.q() + ((a(afVar).hashCode() / 10) * 10);
            notificationManager.notify(q, notification);
            if (b(afVar)) {
                com.xiaomi.push.service.clientReport.d.a(context.getApplicationContext()).a(f(afVar), m3.b(), 3002, "try show business message");
            }
            if (d(afVar)) {
                com.xiaomi.push.service.clientReport.d.a(context.getApplicationContext()).a(f(afVar), m3.b(), 1002, "try show notification message");
            }
            if (Build.VERSION.SDK_INT < 26) {
                com.xiaomi.channel.commonutils.misc.h a6 = com.xiaomi.channel.commonutils.misc.h.a(context);
                a6.a(q);
                int b3 = b(m3.s());
                if (b3 > 0) {
                    a6.b(new ai(q, notificationManager), b3);
                }
            }
            Pair<Integer, com.xiaomi.xmpush.thrift.af> pair = new Pair<>(Integer.valueOf(q), afVar);
            synchronized (b) {
                b.add(pair);
                if (b.size() > 100) {
                    b.remove();
                }
            }
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(com.xiaomi.xmpush.thrift.af afVar) {
        com.xiaomi.xmpush.thrift.u m;
        if ("com.xiaomi.xmsf".equals(afVar.f) && (m = afVar.m()) != null && m.s() != null) {
            String str = m.s().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return afVar.f;
    }

    private static void a(Notification notification, int i) {
        Object a2 = com.xiaomi.channel.commonutils.reflect.a.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.channel.commonutils.reflect.a.a(a2, "setMessageCount", Integer.valueOf(i));
        }
    }

    public static void a(Context context, String str, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(PushManager.MESSAGE_TYPE_NOTI);
        int hashCode = ((str.hashCode() / 10) * 10) + i;
        LinkedList linkedList = new LinkedList();
        if (i >= 0) {
            notificationManager.cancel(hashCode);
        }
        synchronized (b) {
            Iterator<Pair<Integer, com.xiaomi.xmpush.thrift.af>> it = b.iterator();
            while (it.hasNext()) {
                Pair<Integer, com.xiaomi.xmpush.thrift.af> next = it.next();
                com.xiaomi.xmpush.thrift.af afVar = (com.xiaomi.xmpush.thrift.af) next.second;
                if (afVar != null) {
                    String a2 = a(afVar);
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
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(PushManager.MESSAGE_TYPE_NOTI);
        LinkedList linkedList = new LinkedList();
        synchronized (b) {
            Iterator<Pair<Integer, com.xiaomi.xmpush.thrift.af>> it = b.iterator();
            while (it.hasNext()) {
                Pair<Integer, com.xiaomi.xmpush.thrift.af> next = it.next();
                com.xiaomi.xmpush.thrift.af afVar = (com.xiaomi.xmpush.thrift.af) next.second;
                if (afVar != null) {
                    String a2 = a(afVar);
                    com.xiaomi.xmpush.thrift.u m = afVar.m();
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
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        bj.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
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

    private static boolean a(com.xiaomi.xmpush.thrift.u uVar) {
        if (uVar != null) {
            String b2 = uVar.b();
            return !TextUtils.isEmpty(b2) && b2.length() == 22 && "satuigm".indexOf(b2.charAt(0)) >= 0;
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

    private static String[] a(Context context, com.xiaomi.xmpush.thrift.u uVar) {
        String h = uVar.h();
        String j = uVar.j();
        Map<String, String> s = uVar.s();
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

    private static int b(Map<String, String> map) {
        String str = map == null ? null : map.get("timeout");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Intent b(Context context, String str, int i, Map<String, String> map) {
        Intent intent;
        Intent intent2;
        URISyntaxException e;
        String str2 = map.get(i < 2 ? "notification_style_button_left_notify_effect" : i < 3 ? "notification_style_button_mid_notify_effect" : "notification_style_button_right_notify_effect");
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (aw.a.equals(str2)) {
            try {
                intent = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e2.getMessage());
                intent = null;
            }
        } else if (aw.b.equals(str2)) {
            String str3 = i < 2 ? "notification_style_button_left_intent_uri" : i < 3 ? "notification_style_button_mid_intent_uri" : "notification_style_button_right_intent_uri";
            String str4 = i < 2 ? "notification_style_button_left_intent_class" : i < 3 ? "notification_style_button_mid_intent_class" : "notification_style_button_right_intent_class";
            if (map.containsKey(str3)) {
                String str5 = map.get(str3);
                if (str5 != null) {
                    try {
                        intent = Intent.parseUri(str5, 1);
                        try {
                            intent.setPackage(str);
                        } catch (URISyntaxException e3) {
                            e = e3;
                            com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                            if (intent != null) {
                            }
                        }
                    } catch (URISyntaxException e4) {
                        e = e4;
                        intent = null;
                    }
                }
                intent = null;
            } else {
                if (map.containsKey(str4)) {
                    Intent intent3 = new Intent();
                    intent3.setComponent(new ComponentName(str, map.get(str4)));
                    intent = intent3;
                }
                intent = null;
            }
        } else {
            if (aw.c.equals(str2)) {
                String str6 = map.get(i < 2 ? "notification_style_button_left_web_uri" : i < 3 ? "notification_style_button_mid_web_uri" : "notification_style_button_right_web_uri");
                if (!TextUtils.isEmpty(str6)) {
                    String trim = str6.trim();
                    if (!trim.startsWith("http://") && !trim.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
                        trim = "http://" + trim;
                    }
                    try {
                        String protocol = new URL(trim).getProtocol();
                        if (HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || "https".equals(protocol)) {
                            intent2 = new Intent("android.intent.action.VIEW");
                            try {
                                intent2.setData(Uri.parse(trim));
                                intent = a(context, intent2);
                            } catch (MalformedURLException e5) {
                                e = e5;
                                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                                intent = intent2;
                                if (intent != null) {
                                }
                            }
                        }
                        intent = null;
                    } catch (MalformedURLException e6) {
                        e = e6;
                        intent2 = null;
                    }
                }
            }
            intent = null;
        }
        if (intent != null) {
            intent.addFlags(268435456);
            try {
                if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                    return intent;
                }
                return null;
            } catch (Exception e7) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e7.getMessage());
                return null;
            }
        }
        return null;
    }

    private static RemoteViews b(Context context, com.xiaomi.xmpush.thrift.af afVar, byte[] bArr) {
        com.xiaomi.xmpush.thrift.u m = afVar.m();
        String a2 = a(afVar);
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

    public static boolean b(com.xiaomi.xmpush.thrift.af afVar) {
        com.xiaomi.xmpush.thrift.u m = afVar.m();
        return a(m) && m.w();
    }

    static int c(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static boolean c(com.xiaomi.xmpush.thrift.af afVar) {
        com.xiaomi.xmpush.thrift.u m = afVar.m();
        return a(m) && m.h == 1 && !b(afVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static boolean d(com.xiaomi.xmpush.thrift.af afVar) {
        com.xiaomi.xmpush.thrift.u m = afVar.m();
        return a(m) && m.h == 0 && !b(afVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    public static boolean e(com.xiaomi.xmpush.thrift.af afVar) {
        return b(afVar) || d(afVar) || c(afVar);
    }

    private static int f(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return (a2 != 0 || Build.VERSION.SDK_INT < 9) ? a2 : context.getApplicationInfo().logo;
    }

    public static String f(com.xiaomi.xmpush.thrift.af afVar) {
        return b(afVar) ? "E100002" : d(afVar) ? "E100000" : c(afVar) ? "E100001" : "";
    }
}
