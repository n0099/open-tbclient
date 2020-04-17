package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tieba.ala.ALaKeepAliveService;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.push.ev;
import com.xiaomi.push.g;
import com.xiaomi.push.hg;
import com.xiaomi.push.ht;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.af;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
/* loaded from: classes8.dex */
public class z {
    public static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final LinkedList<Pair<Integer, ic>> f938a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f939a = Executors.newCachedThreadPool();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a implements Callable<Bitmap> {
        private Context a;

        /* renamed from: a  reason: collision with other field name */
        private String f940a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f941a;

        public a(String str, Context context, boolean z) {
            this.a = context;
            this.f940a = str;
            this.f941a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Bitmap call() {
            if (TextUtils.isEmpty(this.f940a)) {
                com.xiaomi.channel.commonutils.logger.b.m50a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            } else if (this.f940a.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                af.b a = af.a(this.a, this.f940a, this.f941a);
                if (a != null) {
                    return a.f846a;
                }
                com.xiaomi.channel.commonutils.logger.b.m50a("Failed get online picture/icon resource");
                return null;
            } else {
                Bitmap a2 = af.a(this.a, this.f940a);
                if (a2 == null) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("Failed get online picture/icon resource");
                    return a2;
                }
                return a2;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        long a = 0;

        /* renamed from: a  reason: collision with other field name */
        Notification f942a;
    }

    /* loaded from: classes8.dex */
    public static class c {
        public long a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f943a;
    }

    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a  reason: collision with other field name */
        public boolean f944a = false;
        public HashMap<String, Integer> a = new HashMap<>();
        public HashMap<String, HashSet<Integer>> b = new HashMap<>();
    }

    static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    private static int a(String str, String str2) {
        return 32768 + (((str + str2).hashCode() / 10) * 10);
    }

    private static int a(Map<String, String> map) {
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

    @TargetApi(16)
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

    @TargetApi(16)
    private static Notification.Builder a(Context context, Map<String, String> map, Notification.Builder builder, String str) {
        if ("2".equals(map.get("notification_style_type"))) {
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(builder);
            Bitmap a2 = map == null ? null : a(context, map.get("notification_bigPic_uri"), false);
            if (a2 != null) {
                bigPictureStyle.bigPicture(a2);
                bigPictureStyle.setSummaryText(str);
                bigPictureStyle.bigLargeIcon((Bitmap) null);
                builder.setStyle(bigPictureStyle);
            }
        } else if ("1".equals(map.get("notification_style_type"))) {
            builder.setStyle(new Notification.BigTextStyle().bigText(str));
        }
        return builder;
    }

    private static Notification a(Notification notification) {
        Object a2 = com.xiaomi.push.at.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.push.at.a(a2, "setCustomizedIcon", true);
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

    private static PendingIntent a(Context context, ic icVar, ht htVar, byte[] bArr) {
        Intent intent;
        int i = -1;
        if (c(icVar)) {
            i = 1000;
        } else if (m558a(icVar)) {
            i = 3000;
        }
        String m369a = htVar != null ? htVar.m369a() : "";
        if (htVar != null && !TextUtils.isEmpty(htVar.f534e)) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(htVar.f534e));
            intent2.addFlags(268435456);
            intent2.putExtra("messageId", m369a);
            intent2.putExtra("eventMessageType", i);
            return PendingIntent.getActivity(context, 0, intent2, 134217728);
        }
        if (m558a(icVar)) {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(htVar.c()));
        } else {
            intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.setComponent(new ComponentName(icVar.f618b, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(htVar.c()));
        }
        intent.putExtra("messageId", m369a);
        intent.putExtra("eventMessageType", i);
        if (f.b(context, icVar.f618b, "com.xiaomi.mipush.MESSAGE_CLICKED")) {
            Intent intent3 = new Intent();
            intent3.setAction("com.xiaomi.mipush.MESSAGE_CLICKED");
            intent3.setClassName(icVar.f618b, "com.xiaomi.mipush.sdk.BridgeActivity");
            intent3.addFlags(276824064);
            intent3.putExtra("mipush_serviceIntent", intent);
            intent3.addCategory(String.valueOf(htVar.c()));
            return PendingIntent.getActivity(context, 0, intent3, 134217728);
        }
        return PendingIntent.getService(context, 0, intent, 134217728);
    }

    private static PendingIntent a(Context context, String str, int i, Map<String, String> map) {
        Intent m553a;
        if (map == null || (m553a = m553a(context, str, i, map)) == null) {
            return null;
        }
        return PendingIntent.getActivity(context, 0, m553a, 0);
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Intent m553a(Context context, String str, int i, Map<String, String> map) {
        Intent intent;
        Intent intent2;
        URISyntaxException e;
        String str2 = map.get(i < 2 ? "notification_style_button_left_notify_effect" : i < 3 ? "notification_style_button_mid_notify_effect" : "notification_style_button_right_notify_effect");
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (ap.a.equals(str2)) {
            try {
                intent = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e2.getMessage());
                intent = null;
            }
        } else if (ap.b.equals(str2)) {
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
            if (ap.c.equals(str2)) {
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

    private static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private static Bitmap a(Context context, String str, boolean z) {
        Future submit = f939a.submit(new a(str, context, z));
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
                    return null;
                }
                return null;
            } catch (ExecutionException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                if (0 == 0) {
                    submit.cancel(true);
                    return null;
                }
                return null;
            } catch (TimeoutException e3) {
                com.xiaomi.channel.commonutils.logger.b.a(e3);
                if (0 == 0) {
                    submit.cancel(true);
                    return null;
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

    private static RemoteViews a(Context context, ic icVar, byte[] bArr) {
        ht m404a = icVar.m404a();
        String a2 = a(icVar);
        Map<String, String> m370a = m404a.m370a();
        if (m370a == null) {
            return null;
        }
        String str = m370a.get("layout_name");
        String str2 = m370a.get("layout_value");
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
                if (jSONObject.has("time")) {
                    JSONObject jSONObject4 = jSONObject.getJSONObject("time");
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

    /* JADX WARN: Removed duplicated region for block: B:122:0x0334 A[Catch: Exception -> 0x0498, TryCatch #0 {Exception -> 0x0498, blocks: (B:94:0x025a, B:96:0x026a, B:98:0x02a3, B:100:0x02b5, B:102:0x02ca, B:103:0x02db, B:106:0x02e6, B:109:0x02fa, B:110:0x0303, B:111:0x0312, B:113:0x031e, B:115:0x0322, B:117:0x0326, B:120:0x032e, B:122:0x0334, B:125:0x0356, B:127:0x035a, B:129:0x035e, B:131:0x0364, B:133:0x0382, B:135:0x0388), top: B:198:0x025a }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x049c A[EDGE_INSN: B:204:0x049c->B:168:0x049c ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x026a A[Catch: Exception -> 0x0498, TryCatch #0 {Exception -> 0x0498, blocks: (B:94:0x025a, B:96:0x026a, B:98:0x02a3, B:100:0x02b5, B:102:0x02ca, B:103:0x02db, B:106:0x02e6, B:109:0x02fa, B:110:0x0303, B:111:0x0312, B:113:0x031e, B:115:0x0322, B:117:0x0326, B:120:0x032e, B:122:0x0334, B:125:0x0356, B:127:0x035a, B:129:0x035e, B:131:0x0364, B:133:0x0382, B:135:0x0388), top: B:198:0x025a }] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static b a(Context context, ic icVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent) {
        boolean z;
        Bitmap a2;
        long currentTimeMillis;
        int i;
        Notification notification;
        Object a3;
        int a4;
        String str;
        String str2;
        NotificationManager notificationManager;
        Object a5;
        List list;
        int i2;
        int i3;
        String str3;
        String str4;
        b bVar = new b();
        ht m404a = icVar.m404a();
        String a6 = a(icVar);
        Map<String, String> m370a = m404a.m370a();
        Notification.Builder builder = new Notification.Builder(context);
        String[] a7 = a(context, m404a);
        builder.setContentTitle(a7[0]);
        builder.setContentText(a7[1]);
        if (remoteViews != null) {
            builder.setContent(remoteViews);
        } else if (Build.VERSION.SDK_INT >= 16 && m370a != null && m370a.containsKey("notification_style_type")) {
            builder = a(context, m370a, builder, a7[1]);
        }
        Notification.Builder a8 = a(builder, context, icVar.b(), m370a);
        a8.setWhen(System.currentTimeMillis());
        String str5 = m370a == null ? null : m370a.get("notification_show_when");
        if (!TextUtils.isEmpty(str5)) {
            a8.setShowWhen(Boolean.parseBoolean(str5));
        } else if (Build.VERSION.SDK_INT >= 24) {
            a8.setShowWhen(true);
        }
        a8.setContentIntent(pendingIntent);
        int a9 = a(context, a6, "mipush_notification");
        int a10 = a(context, a6, "mipush_small_notification");
        if (a9 <= 0 || a10 <= 0) {
            a8.setSmallIcon(b(context, a6));
        } else {
            a8.setLargeIcon(a(context, a9));
            a8.setSmallIcon(a10);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            Bitmap a11 = m370a == null ? null : a(context, m370a.get("notification_small_icon_uri"), true);
            if (a11 != null) {
                Object a12 = com.xiaomi.push.at.a("android.graphics.drawable.Icon", "createWithBitmap", a11);
                if (a12 != null) {
                    com.xiaomi.push.at.a(a8, "setSmallIcon", a12);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("miui.isGrayscaleIcon", true);
                    a8.addExtras(bundle);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m50a("failed te get small icon with url:" + m370a.get("notification_small_icon_uri"));
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.m50a("failed to get small icon url:" + (m370a == null ? null : m370a.get("notification_small_icon_uri")));
            }
            String str6 = m370a == null ? null : m370a.get("notification_small_icon_color");
            if (!TextUtils.isEmpty(str6)) {
                try {
                    com.xiaomi.push.at.a(a8, "setColor", Integer.valueOf(Color.parseColor(str6)));
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
        String str7 = m370a == null ? null : m370a.get("__dynamic_icon_uri");
        boolean z2 = (m370a != null && Boolean.parseBoolean(m370a.get("__adiom"))) || !com.xiaomi.push.l.m486a();
        if (str7 != null && z2) {
            Bitmap bitmap = null;
            if (str7.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                af.b a13 = af.a(context, str7, true);
                if (a13 != null) {
                    bitmap = a13.f846a;
                    bVar.a = a13.a;
                }
            } else {
                bitmap = af.a(context, str7);
            }
            if (bitmap != null) {
                a8.setLargeIcon(bitmap);
                z = true;
                a2 = m370a != null ? null : a(context, m370a.get("notification_large_icon_uri"), true);
                if (a2 != null) {
                    a8.setLargeIcon(a2);
                }
                if (m370a != null && Build.VERSION.SDK_INT >= 24) {
                    str4 = m370a.get("notification_group");
                    boolean parseBoolean = Boolean.parseBoolean(m370a.get("notification_is_summary"));
                    if (TextUtils.isEmpty(str4)) {
                        str4 = a(icVar);
                    }
                    com.xiaomi.push.at.a(a8, "setGroup", str4);
                    com.xiaomi.push.at.a(a8, "setGroupSummary", Boolean.valueOf(parseBoolean));
                }
                a8.setAutoCancel(true);
                currentTimeMillis = System.currentTimeMillis();
                if (m370a != null && m370a.containsKey(ALaKeepAliveService.KEY_TICKER)) {
                    a8.setTicker(m370a.get(ALaKeepAliveService.KEY_TICKER));
                }
                int i4 = -100;
                Uri uri = null;
                if (currentTimeMillis - a > 10000) {
                    a = currentTimeMillis;
                    i4 = m562b(context, a6) ? a(context, a6) : m404a.f521a;
                    a8.setDefaults(i4);
                    if (m370a != null && (i4 & 1) != 0) {
                        String str8 = m370a.get("sound_uri");
                        if (!TextUtils.isEmpty(str8) && str8.startsWith("android.resource://" + a6)) {
                            a8.setDefaults(i4 ^ 1);
                            Uri parse = Uri.parse(str8);
                            a8.setSound(parse);
                            uri = parse;
                            i = i4;
                            if (m370a != null && Build.VERSION.SDK_INT >= 26) {
                                if (a(m370a) > 0) {
                                    com.xiaomi.push.at.a(a8, "setTimeoutAfter", Long.valueOf(a4 * 1000));
                                }
                                str = m370a.get(SharedPrefConfig.CHANNEL_ID);
                                if (TextUtils.isEmpty(str) || context.getApplicationInfo().targetSdkVersion >= 26) {
                                    String str9 = "mipush_" + a6 + "_default";
                                    str2 = !TextUtils.isEmpty(str) ? str9 : com.xiaomi.push.l.m486a() ? "mipush_" + a6 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str : str;
                                    com.xiaomi.push.at.a(a8, "setChannelId", str2);
                                    String a14 = a(context, a6, m370a);
                                    notificationManager = (NotificationManager) context.getSystemService("notification");
                                    try {
                                        if (com.xiaomi.push.at.a(notificationManager, "getNotificationChannel", str2) == null) {
                                            Object newInstance = Class.forName("android.app.NotificationChannel").getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance(str2, a14, 3);
                                            if (i > -100) {
                                                a8.setSound((Uri) null, (AudioAttributes) null);
                                                a8.setDefaults(0);
                                                int i5 = i & 1;
                                                int i6 = i & 2;
                                                int i7 = i & 4;
                                                if (i5 != 1) {
                                                    com.xiaomi.push.at.a(newInstance, "setSound", null, null);
                                                }
                                                if (uri != null) {
                                                    com.xiaomi.push.at.a(newInstance, "setSound", uri, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                                                }
                                                Object[] objArr = new Object[1];
                                                objArr[0] = Boolean.valueOf(i6 == 2);
                                                com.xiaomi.push.at.a(newInstance, "enableVibration", objArr);
                                                Object[] objArr2 = new Object[1];
                                                objArr2[0] = Boolean.valueOf(i7 == 4);
                                                com.xiaomi.push.at.a(newInstance, "enableLights", objArr2);
                                            }
                                            a(newInstance, m370a);
                                            com.xiaomi.push.at.a(notificationManager, "createNotificationChannel", newInstance);
                                        }
                                        a5 = com.xiaomi.push.at.a(notificationManager, "getNotificationChannels", new Object[0]);
                                        if (a5 != null && (a5 instanceof List) && (list = (List) a5) != null && list.size() > 0) {
                                            i2 = 0;
                                            while (true) {
                                                i3 = i2;
                                                if (i3 < list.size()) {
                                                    break;
                                                }
                                                Object obj = list.get(i3);
                                                Object a15 = com.xiaomi.push.at.a(obj, "getName", new Object[0]);
                                                Object a16 = com.xiaomi.push.at.a(obj, "getId", new Object[0]);
                                                String b2 = com.xiaomi.push.g.b(context, a6);
                                                if (a15 != null && a16 != null && (a15 instanceof CharSequence) && (a16 instanceof String) && a15.equals(b2) && ((String) a16).startsWith("mipush_" + a6) && !a16.equals(str9)) {
                                                    com.xiaomi.push.at.a(notificationManager, "deleteNotificationChannel", a16);
                                                }
                                                i2 = i3 + 1;
                                            }
                                        }
                                    } catch (Exception e2) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                                    }
                                }
                                str3 = m370a.get("background_color");
                                if (!TextUtils.isEmpty(str3)) {
                                    try {
                                        int parseInt = Integer.parseInt(str3);
                                        a8.setOngoing(true);
                                        a8.setColor(parseInt);
                                        com.xiaomi.push.at.a(a8, "setColorized", true);
                                    } catch (Exception e3) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                                    }
                                }
                            }
                            if (com.xiaomi.push.l.c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                                com.xiaomi.push.at.a("miui.util.NotificationHelper", "setTargetPkg", context, a8, a(icVar));
                            }
                            notification = a8.getNotification();
                            if (z && com.xiaomi.push.l.m486a()) {
                                a(notification);
                            }
                            if (m370a != null && (a3 = com.xiaomi.push.at.a(notification, "extraNotification")) != null) {
                                if (!TextUtils.isEmpty(m370a.get("enable_keyguard"))) {
                                    com.xiaomi.push.at.a(a3, "setEnableKeyguard", Boolean.valueOf(Boolean.parseBoolean(m370a.get("enable_keyguard"))));
                                }
                                if (!TextUtils.isEmpty(m370a.get("enable_float"))) {
                                    com.xiaomi.push.at.a(a3, "setEnableFloat", Boolean.valueOf(Boolean.parseBoolean(m370a.get("enable_float"))));
                                }
                            }
                            bVar.f942a = notification;
                            return bVar;
                        }
                    }
                }
                i = i4;
                if (m370a != null) {
                    if (a(m370a) > 0) {
                    }
                    str = m370a.get(SharedPrefConfig.CHANNEL_ID);
                    if (TextUtils.isEmpty(str)) {
                    }
                    String str92 = "mipush_" + a6 + "_default";
                    if (!TextUtils.isEmpty(str)) {
                    }
                    com.xiaomi.push.at.a(a8, "setChannelId", str2);
                    String a142 = a(context, a6, m370a);
                    notificationManager = (NotificationManager) context.getSystemService("notification");
                    if (com.xiaomi.push.at.a(notificationManager, "getNotificationChannel", str2) == null) {
                    }
                    a5 = com.xiaomi.push.at.a(notificationManager, "getNotificationChannels", new Object[0]);
                    if (a5 != null) {
                        i2 = 0;
                        while (true) {
                            i3 = i2;
                            if (i3 < list.size()) {
                            }
                            i2 = i3 + 1;
                        }
                    }
                    str3 = m370a.get("background_color");
                    if (!TextUtils.isEmpty(str3)) {
                    }
                }
                if (com.xiaomi.push.l.c()) {
                    com.xiaomi.push.at.a("miui.util.NotificationHelper", "setTargetPkg", context, a8, a(icVar));
                }
                notification = a8.getNotification();
                if (z) {
                    a(notification);
                }
                if (m370a != null) {
                    if (!TextUtils.isEmpty(m370a.get("enable_keyguard"))) {
                    }
                    if (!TextUtils.isEmpty(m370a.get("enable_float"))) {
                    }
                }
                bVar.f942a = notification;
                return bVar;
            }
        }
        z = false;
        if (m370a != null) {
        }
        if (a2 != null) {
        }
        if (m370a != null) {
            str4 = m370a.get("notification_group");
            boolean parseBoolean2 = Boolean.parseBoolean(m370a.get("notification_is_summary"));
            if (TextUtils.isEmpty(str4)) {
            }
            com.xiaomi.push.at.a(a8, "setGroup", str4);
            com.xiaomi.push.at.a(a8, "setGroupSummary", Boolean.valueOf(parseBoolean2));
        }
        a8.setAutoCancel(true);
        currentTimeMillis = System.currentTimeMillis();
        if (m370a != null) {
            a8.setTicker(m370a.get(ALaKeepAliveService.KEY_TICKER));
        }
        int i42 = -100;
        Uri uri2 = null;
        if (currentTimeMillis - a > 10000) {
        }
        i = i42;
        if (m370a != null) {
        }
        if (com.xiaomi.push.l.c()) {
        }
        notification = a8.getNotification();
        if (z) {
        }
        if (m370a != null) {
        }
        bVar.f942a = notification;
        return bVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static c m554a(Context context, ic icVar, byte[] bArr) {
        Notification notification;
        c cVar = new c();
        if (com.xiaomi.push.g.m298a(context, a(icVar)) == g.a.NOT_ALLOWED) {
            ht m404a = icVar.m404a();
            if (m404a != null) {
                ev.a(context.getApplicationContext()).a(icVar.b(), b(icVar), m404a.m369a(), "Do not notify because user block " + a(icVar) + "‘s notification");
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("Do not notify because user block " + a(icVar) + "‘s notification");
            return cVar;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        ht m404a2 = icVar.m404a();
        RemoteViews a2 = a(context, icVar, bArr);
        PendingIntent a3 = a(context, icVar, m404a2, bArr);
        if (a3 == null) {
            if (m404a2 != null) {
                ev.a(context.getApplicationContext()).a(icVar.b(), b(icVar), m404a2.m369a(), "The click PendingIntent is null. ");
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("The click PendingIntent is null. ");
            return cVar;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            b a4 = a(context, icVar, bArr, a2, a3);
            cVar.a = a4.a;
            cVar.f943a = a(icVar);
            notification = a4.f942a;
        } else {
            Notification notification2 = new Notification(b(context, a(icVar)), null, System.currentTimeMillis());
            String[] a5 = a(context, m404a2);
            try {
                notification2.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification2, context, a5[0], a5[1], a3);
            } catch (IllegalAccessException e) {
                if (m404a2 != null) {
                    ev.a(context.getApplicationContext()).a(icVar.b(), b(icVar), m404a2.m369a(), e);
                }
                com.xiaomi.channel.commonutils.logger.b.a(e);
            } catch (IllegalArgumentException e2) {
                if (m404a2 != null) {
                    ev.a(context.getApplicationContext()).a(icVar.b(), b(icVar), m404a2.m369a(), e2);
                }
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            } catch (NoSuchMethodException e3) {
                if (m404a2 != null) {
                    ev.a(context.getApplicationContext()).a(icVar.b(), b(icVar), m404a2.m369a(), e3);
                }
                com.xiaomi.channel.commonutils.logger.b.a(e3);
            } catch (InvocationTargetException e4) {
                if (m404a2 != null) {
                    ev.a(context.getApplicationContext()).a(icVar.b(), b(icVar), m404a2.m369a(), e4);
                }
                com.xiaomi.channel.commonutils.logger.b.a(e4);
            }
            Map<String, String> m370a = m404a2.m370a();
            if (m370a != null && m370a.containsKey(ALaKeepAliveService.KEY_TICKER)) {
                notification2.tickerText = m370a.get(ALaKeepAliveService.KEY_TICKER);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a > 10000) {
                a = currentTimeMillis;
                int a6 = m562b(context, a(icVar)) ? a(context, a(icVar)) : m404a2.f521a;
                notification2.defaults = a6;
                if (m370a != null && (a6 & 1) != 0) {
                    String str = m370a.get("sound_uri");
                    if (!TextUtils.isEmpty(str) && str.startsWith("android.resource://" + a(icVar))) {
                        notification2.defaults = a6 ^ 1;
                        notification2.sound = Uri.parse(str);
                    }
                }
            }
            notification2.flags |= 16;
            if (a2 != null) {
                notification2.contentView = a2;
            }
            notification = notification2;
        }
        if (com.xiaomi.push.l.m486a() && Build.VERSION.SDK_INT >= 19) {
            if (!TextUtils.isEmpty(m404a2.m369a())) {
                notification.extras.putString("message_id", m404a2.m369a());
            }
            String str2 = m404a2.m375b() == null ? null : m404a2.m375b().get("score_info");
            if (!TextUtils.isEmpty(str2)) {
                notification.extras.putString("score_info", str2);
            }
            int i = -1;
            if (c(icVar)) {
                i = 1000;
            } else if (m558a(icVar)) {
                i = 3000;
            }
            notification.extras.putString("eventMessageType", String.valueOf(i));
            notification.extras.putString("target_package", a(icVar));
        }
        String str3 = m404a2.m370a() == null ? null : m404a2.m370a().get("message_count");
        if (com.xiaomi.push.l.m486a() && str3 != null) {
            try {
                a(notification, Integer.parseInt(str3));
            } catch (NumberFormatException e5) {
                if (m404a2 != null) {
                    ev.a(context.getApplicationContext()).a(icVar.b(), b(icVar), m404a2.m369a(), e5);
                }
                com.xiaomi.channel.commonutils.logger.b.a(e5);
            }
        }
        if (!com.xiaomi.push.l.c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
            a(notification, a(icVar));
        }
        int hashCode = ((a(icVar).hashCode() / 10) * 10) + m404a2.c();
        notificationManager.notify(hashCode, notification);
        if (com.xiaomi.push.l.m486a() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
            a(context, notification, hashCode, a(icVar));
        }
        if (m558a(icVar)) {
            ev.a(context.getApplicationContext()).a(icVar.b(), b(icVar), m404a2.m369a(), 3002, "try show business message");
        }
        if (c(icVar)) {
            ev.a(context.getApplicationContext()).a(icVar.b(), b(icVar), m404a2.m369a(), 1002, "try show notification message");
        }
        if (Build.VERSION.SDK_INT < 26) {
            com.xiaomi.push.ai a7 = com.xiaomi.push.ai.a(context);
            a7.m130a(hashCode);
            int a8 = a(m404a2.m370a());
            if (a8 > 0) {
                a7.b(new aa(hashCode, notificationManager), a8);
            }
        }
        Pair<Integer, ic> pair = new Pair<>(Integer.valueOf(hashCode), icVar);
        synchronized (f938a) {
            f938a.add(pair);
            if (f938a.size() > 100) {
                f938a.remove();
            }
        }
        return cVar;
    }

    private static d a(NotificationManager notificationManager, String str, String str2) {
        StatusBarNotification[] activeNotifications;
        Object a2;
        d dVar = new d();
        if (notificationManager != null && Build.VERSION.SDK_INT >= 23 && !TextUtils.isEmpty(str) && (activeNotifications = notificationManager.getActiveNotifications()) != null && activeNotifications.length > 0) {
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                if (statusBarNotification != null) {
                    String packageName = statusBarNotification.getPackageName();
                    String group = statusBarNotification.getNotification() != null ? statusBarNotification.getNotification().getGroup() : "";
                    if (!TextUtils.isEmpty(group)) {
                        String str3 = packageName + group;
                        if (str2.equals(str3) && (a2 = com.xiaomi.push.at.a(statusBarNotification.getNotification(), "isGroupSummary", (Object[]) null)) != null && (a2 instanceof Boolean) && ((Boolean) Boolean.class.cast(a2)).booleanValue()) {
                            dVar.f944a = true;
                        } else {
                            dVar.a.put(str3, Integer.valueOf((dVar.a.containsKey(str3) ? dVar.a.get(str3).intValue() : 0) + 1));
                            HashSet<Integer> hashSet = dVar.b.containsKey(str3) ? dVar.b.get(str3) : null;
                            if (hashSet == null) {
                                hashSet = new HashSet<>();
                                dVar.b.put(str3, hashSet);
                            }
                            hashSet.add(Integer.valueOf(statusBarNotification.getId()));
                        }
                    }
                }
            }
        }
        return dVar;
    }

    private static String a(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? com.xiaomi.push.g.b(context, str) : map.get("channel_name");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(ic icVar) {
        ht m404a;
        if ("com.xiaomi.xmsf".equals(icVar.f618b) && (m404a = icVar.m404a()) != null && m404a.m370a() != null) {
            String str = m404a.m370a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return icVar.f618b;
    }

    private static void a(Notification notification, int i) {
        Object a2 = com.xiaomi.push.at.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.push.at.a(a2, "setMessageCount", Integer.valueOf(i));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m555a(NotificationManager notificationManager, String str, String str2) {
        int a2 = a(str, str2);
        com.xiaomi.channel.commonutils.logger.b.b("GROUPSUMMARY  : cancelGroupSummarytargetPackageName = " + str + " id = " + a2);
        notificationManager.cancel(a2);
    }

    @TargetApi(23)
    private static void a(Context context, Notification notification, int i, String str) {
        HashSet<Integer> hashSet;
        boolean z = false;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        String str2 = context.getPackageName() + notification.getGroup();
        d a2 = a(notificationManager, notification.getGroup(), str2);
        int intValue = a2.a.containsKey(str2) ? a2.a.get(str2).intValue() : 0;
        if (a2.b.containsKey(str2) && (hashSet = a2.b.get(str2)) != null && hashSet.contains(Integer.valueOf(i))) {
            z = true;
        }
        if (intValue > 1 || (intValue == 1 && !z)) {
            if (a2.f944a) {
                return;
            }
            a(context, str, notification, notificationManager);
        } else if (intValue >= 1 || !a2.f944a) {
        } else {
            m555a(notificationManager, str, notification.getGroup());
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m556a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        int hashCode = ((str.hashCode() / 10) * 10) + i;
        LinkedList linkedList = new LinkedList();
        if (i >= 0) {
            notificationManager.cancel(hashCode);
        }
        synchronized (f938a) {
            Iterator<Pair<Integer, ic>> it = f938a.iterator();
            while (it.hasNext()) {
                Pair<Integer, ic> next = it.next();
                ic icVar = (ic) next.second;
                if (icVar != null) {
                    String a2 = a(icVar);
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
            if (f938a != null) {
                f938a.removeAll(linkedList);
                a(context, linkedList);
            }
        }
    }

    @TargetApi(23)
    private static void a(Context context, String str, Notification notification, NotificationManager notificationManager) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                String group = notification.getGroup();
                Notification notification2 = null;
                if (Build.VERSION.SDK_INT >= 26) {
                    if (com.xiaomi.push.at.a(notificationManager, "getNotificationChannel", "groupSummary") == null) {
                        com.xiaomi.push.at.a(notificationManager, "createNotificationChannel", Class.forName("android.app.NotificationChannel").getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance("groupSummary", "group_summary", 3));
                    }
                    if (!TextUtils.isEmpty(group)) {
                        Notification.Builder builder = new Notification.Builder(context);
                        builder.setContentTitle("GroupSummary").setContentText("GroupSummary").setLargeIcon(notification.getLargeIcon()).setSmallIcon(notification.getSmallIcon()).setAutoCancel(true).setGroup(group).setGroupSummary(true);
                        com.xiaomi.push.at.a(builder, "setChannelId", "groupSummary");
                        notification2 = builder.build();
                    }
                } else if (!TextUtils.isEmpty(group)) {
                    Notification.Builder builder2 = new Notification.Builder(context);
                    builder2.setContentTitle("GroupSummary").setContentText("GroupSummary").setLargeIcon(notification.getLargeIcon()).setSmallIcon(notification.getSmallIcon()).setPriority(0).setDefaults(-1).setAutoCancel(true).setGroup(group).setGroupSummary(true);
                    notification2 = builder2.build();
                }
                if (notification2 != null && !com.xiaomi.push.l.c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                    a(notification2, str);
                    if (notification2.extras != null) {
                        notification2.extras.putString("target_package", str);
                    }
                }
                int a2 = a(str, group);
                if (notification2 != null) {
                    notificationManager.notify(a2, notification2);
                    com.xiaomi.channel.commonutils.logger.b.b("GROUPSUMMARY  : showGroupSummary targetPackageName = " + str + " id = " + a2);
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        LinkedList linkedList = new LinkedList();
        synchronized (f938a) {
            Iterator<Pair<Integer, ic>> it = f938a.iterator();
            while (it.hasNext()) {
                Pair<Integer, ic> next = it.next();
                ic icVar = (ic) next.second;
                if (icVar != null) {
                    String a2 = a(icVar);
                    ht m404a = icVar.m404a();
                    if (m404a != null && TextUtils.equals(a2, str)) {
                        String m377c = m404a.m377c();
                        String d2 = m404a.d();
                        if (!TextUtils.isEmpty(m377c) && !TextUtils.isEmpty(d2) && m559a(str2, m377c) && m559a(str3, d2)) {
                            notificationManager.cancel(((Integer) next.first).intValue());
                            linkedList.add(next);
                        }
                    }
                }
            }
            if (f938a != null) {
                f938a.removeAll(linkedList);
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        be.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    private static void a(Object obj, Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(map.get("channel_description"))) {
            return;
        }
        com.xiaomi.push.at.a(obj, "setDescription", map.get("channel_description"));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m557a(Context context, String str) {
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

    private static boolean a(ht htVar) {
        if (htVar != null) {
            String m369a = htVar.m369a();
            return !TextUtils.isEmpty(m369a) && m369a.length() == 22 && "satuigm".indexOf(m369a.charAt(0)) >= 0;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m558a(ic icVar) {
        ht m404a = icVar.m404a();
        return a(m404a) && m404a.l();
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m559a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m560a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    private static String[] a(Context context, ht htVar) {
        String m377c = htVar.m377c();
        String d2 = htVar.d();
        Map<String, String> m370a = htVar.m370a();
        if (m370a != null) {
            int intValue = Float.valueOf((context.getResources().getDisplayMetrics().widthPixels / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (intValue <= 320) {
                String str = m370a.get("title_short");
                if (!TextUtils.isEmpty(str)) {
                    m377c = str;
                }
                String str2 = m370a.get("description_short");
                if (TextUtils.isEmpty(str2)) {
                    str2 = d2;
                }
                d2 = str2;
            } else if (intValue > 360) {
                String str3 = m370a.get("title_long");
                if (!TextUtils.isEmpty(str3)) {
                    m377c = str3;
                }
                String str4 = m370a.get("description_long");
                if (!TextUtils.isEmpty(str4)) {
                    d2 = str4;
                }
            }
        }
        return new String[]{m377c, d2};
    }

    private static int b(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return (a2 != 0 || Build.VERSION.SDK_INT < 9) ? a2 : context.getApplicationInfo().logo;
    }

    public static String b(ic icVar) {
        return m558a(icVar) ? "E100002" : c(icVar) ? "E100000" : m563b(icVar) ? "E100001" : d(icVar) ? "E100003" : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public static void m561b(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public static boolean m562b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m563b(ic icVar) {
        ht m404a = icVar.m404a();
        return a(m404a) && m404a.f527b == 1 && !m558a(icVar);
    }

    public static boolean c(ic icVar) {
        ht m404a = icVar.m404a();
        return a(m404a) && m404a.f527b == 0 && !m558a(icVar);
    }

    public static boolean d(ic icVar) {
        return icVar.a() == hg.Registration;
    }

    public static boolean e(ic icVar) {
        return m558a(icVar) || c(icVar) || m563b(icVar);
    }
}
