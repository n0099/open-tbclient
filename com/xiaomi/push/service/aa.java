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
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tieba.ala.ALaKeepAliveService;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.connect.common.Constants;
import com.xiaomi.push.fb;
import com.xiaomi.push.g;
import com.xiaomi.push.hm;
import com.xiaomi.push.hr;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.ai;
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
/* loaded from: classes6.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    public static long f14222a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final LinkedList<Pair<Integer, ii>> f908a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f909a = Executors.newCachedThreadPool();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements Callable<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private Context f14223a;

        /* renamed from: a  reason: collision with other field name */
        private String f910a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f911a;

        public a(String str, Context context, boolean z) {
            this.f14223a = context;
            this.f910a = str;
            this.f911a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Bitmap call() {
            if (TextUtils.isEmpty(this.f910a)) {
                com.xiaomi.channel.commonutils.logger.b.m79a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            } else if (this.f910a.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                ai.b a2 = ai.a(this.f14223a, this.f910a, this.f911a);
                if (a2 != null) {
                    return a2.f923a;
                }
                com.xiaomi.channel.commonutils.logger.b.m79a("Failed get online picture/icon resource");
                return null;
            } else {
                Bitmap a3 = ai.a(this.f14223a, this.f910a);
                if (a3 == null) {
                    com.xiaomi.channel.commonutils.logger.b.m79a("Failed get online picture/icon resource");
                    return a3;
                }
                return a3;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        long f14224a = 0;

        /* renamed from: a  reason: collision with other field name */
        Notification f912a;
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f14225a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f913a;
    }

    static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
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
            Bitmap a2 = map == null ? null : a(context, map.get("notification_bigPic_uri"), false);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.m79a("can not get big picture.");
            } else {
                Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(builder);
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
        Object a2 = com.xiaomi.push.ba.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.push.ba.a(a2, "setCustomizedIcon", true);
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

    private static PendingIntent a(Context context, ii iiVar, hz hzVar, byte[] bArr, int i) {
        Intent intent;
        int i2 = -1;
        if (c(iiVar)) {
            i2 = 1000;
        } else if (m558a(iiVar)) {
            i2 = 3000;
        }
        String m402a = hzVar != null ? hzVar.m402a() : "";
        if (hzVar != null && !TextUtils.isEmpty(hzVar.f599e)) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(hzVar.f599e));
            intent2.addFlags(268435456);
            intent2.putExtra("messageId", m402a);
            intent2.putExtra("eventMessageType", i2);
            return PendingIntent.getActivity(context, 0, intent2, 134217728);
        }
        if (m558a(iiVar)) {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i));
            intent.addCategory(String.valueOf(m402a));
        } else {
            intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.setComponent(new ComponentName(iiVar.f684b, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i));
            intent.addCategory(String.valueOf(m402a));
        }
        intent.putExtra("messageId", m402a);
        intent.putExtra("eventMessageType", i2);
        if (f.b(context, iiVar.f684b, "com.xiaomi.mipush.MESSAGE_CLICKED")) {
            Intent intent3 = new Intent();
            intent3.setAction("com.xiaomi.mipush.MESSAGE_CLICKED");
            intent3.setClassName(iiVar.f684b, "com.xiaomi.mipush.sdk.BridgeActivity");
            intent3.addFlags(276824064);
            intent3.putExtra("mipush_serviceIntent", intent);
            intent3.addCategory(String.valueOf(i));
            intent3.addCategory(String.valueOf(m402a));
            return PendingIntent.getActivity(context, 0, intent3, 134217728);
        }
        return PendingIntent.getService(context, 0, intent, 134217728);
    }

    private static PendingIntent a(Context context, String str, int i, Map<String, String> map) {
        Intent m554a;
        if (map == null || (m554a = m554a(context, str, i, map)) == null) {
            return null;
        }
        return PendingIntent.getActivity(context, 0, m554a, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Intent m554a(Context context, String str, int i, Map<String, String> map) {
        Intent intent;
        MalformedURLException e;
        Intent intent2;
        String str2 = map.get(i < 2 ? "notification_style_button_left_notify_effect" : i < 3 ? "notification_style_button_mid_notify_effect" : "notification_style_button_right_notify_effect");
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (at.f14255a.equals(str2)) {
            try {
                intent = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e2.getMessage());
                intent = null;
            }
        } else {
            if (at.f14256b.equals(str2)) {
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
                    } else {
                        intent = null;
                    }
                } else if (map.containsKey(str4)) {
                    Intent intent3 = new Intent();
                    intent3.setComponent(new ComponentName(str, map.get(str4)));
                    intent = intent3;
                }
            } else if (at.c.equals(str2)) {
                String str6 = map.get(i < 2 ? "notification_style_button_left_web_uri" : i < 3 ? "notification_style_button_mid_web_uri" : "notification_style_button_right_web_uri");
                if (!TextUtils.isEmpty(str6)) {
                    String trim = str6.trim();
                    String str7 = (trim.startsWith("http://") || trim.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) ? trim : "http://" + trim;
                    try {
                        String protocol = new URL(str7).getProtocol();
                        if (HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || "https".equals(protocol)) {
                            intent = new Intent("android.intent.action.VIEW");
                            try {
                                intent.setData(Uri.parse(str7));
                                aj.a(context, intent);
                            } catch (MalformedURLException e5) {
                                e = e5;
                                intent2 = intent;
                                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                                intent = intent2;
                                if (intent != null) {
                                }
                            }
                        } else {
                            intent = null;
                        }
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
        Future submit = f909a.submit(new a(str, context, z));
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

    private static RemoteViews a(Context context, ii iiVar, byte[] bArr) {
        hz m443a = iiVar.m443a();
        String a2 = a(iiVar);
        Map<String, String> m403a = m443a.m403a();
        if (m403a == null) {
            return null;
        }
        String str = m403a.get("layout_name");
        String str2 = m403a.get("layout_value");
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

    /* JADX WARN: Removed duplicated region for block: B:169:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ec  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static b a(Context context, ii iiVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent) {
        boolean z;
        Bitmap a2;
        long currentTimeMillis;
        int i;
        int c2;
        Notification notification;
        Object a3;
        int a4;
        List list;
        int a5;
        String str;
        b bVar = new b();
        hz m443a = iiVar.m443a();
        String a6 = a(iiVar);
        Map<String, String> m403a = m443a.m403a();
        Notification.Builder builder = new Notification.Builder(context);
        String[] a7 = a(context, m443a);
        builder.setContentTitle(a7[0]);
        builder.setContentText(a7[1]);
        if (remoteViews != null) {
            builder.setContent(remoteViews);
        } else if (Build.VERSION.SDK_INT >= 16 && m403a != null && m403a.containsKey("notification_style_type")) {
            builder = a(context, m403a, builder, a7[1]);
        }
        Notification.Builder a8 = a(builder, context, iiVar.b(), m403a);
        long currentTimeMillis2 = System.currentTimeMillis();
        a8.setWhen(currentTimeMillis2);
        String str2 = m403a == null ? null : m403a.get("notification_show_when");
        if (!TextUtils.isEmpty(str2)) {
            a8.setShowWhen(Boolean.parseBoolean(str2));
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
            Bitmap a11 = m403a == null ? null : a(context, m403a.get("notification_small_icon_uri"), true);
            if (a11 != null) {
                Object a12 = com.xiaomi.push.ba.a("android.graphics.drawable.Icon", "createWithBitmap", a11);
                if (a12 != null) {
                    com.xiaomi.push.ba.a(a8, "setSmallIcon", a12);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("miui.isGrayscaleIcon", true);
                    a8.addExtras(bundle);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m79a("failed te get small icon with url:" + m403a.get("notification_small_icon_uri"));
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.m79a("failed to get small icon url:" + (m403a == null ? null : m403a.get("notification_small_icon_uri")));
            }
            String str3 = m403a == null ? null : m403a.get("notification_small_icon_color");
            if (!TextUtils.isEmpty(str3)) {
                try {
                    com.xiaomi.push.ba.a(a8, "setColor", Integer.valueOf(Color.parseColor(str3)));
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
        String str4 = m403a == null ? null : m403a.get("__dynamic_icon_uri");
        boolean z2 = (m403a != null && Boolean.parseBoolean(m403a.get("__adiom"))) || !com.xiaomi.push.l.m525a();
        if (str4 != null && z2) {
            Bitmap bitmap = null;
            if (str4.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                ai.b a13 = ai.a(context, str4, true);
                if (a13 != null) {
                    bitmap = a13.f923a;
                    bVar.f14224a = a13.f14236a;
                }
            } else {
                bitmap = ai.a(context, str4);
            }
            if (bitmap != null) {
                a8.setLargeIcon(bitmap);
                z = true;
                a2 = m403a != null ? null : a(context, m403a.get("notification_large_icon_uri"), true);
                if (a2 != null) {
                    a8.setLargeIcon(a2);
                }
                if (m403a != null && Build.VERSION.SDK_INT >= 24) {
                    str = m403a.get("notification_group");
                    boolean parseBoolean = Boolean.parseBoolean(m403a.get("notification_is_summary"));
                    if (TextUtils.isEmpty(str)) {
                        str = a(iiVar);
                    }
                    com.xiaomi.push.ba.a(a8, "setGroup", ag.a().a(context, a8, str));
                    com.xiaomi.push.ba.a(a8, "setGroupSummary", Boolean.valueOf(parseBoolean));
                }
                a8.setAutoCancel(true);
                currentTimeMillis = System.currentTimeMillis();
                if (m403a != null && m403a.containsKey(ALaKeepAliveService.KEY_TICKER)) {
                    a8.setTicker(m403a.get(ALaKeepAliveService.KEY_TICKER));
                }
                int i2 = -100;
                Uri uri = null;
                if (currentTimeMillis - f14222a > 10000) {
                    f14222a = currentTimeMillis;
                    i2 = m561b(context, a6) ? a(context, a6) : m443a.f586a;
                    a8.setDefaults(i2);
                    if (m403a != null && (i2 & 1) != 0) {
                        String str5 = m403a.get("sound_uri");
                        if (!TextUtils.isEmpty(str5) && str5.startsWith("android.resource://" + a6)) {
                            a8.setDefaults(i2 ^ 1);
                            Uri parse = Uri.parse(str5);
                            a8.setSound(parse);
                            uri = parse;
                            i = i2;
                            if (m403a == null && Build.VERSION.SDK_INT >= 26) {
                                if (a(m403a) > 0) {
                                    com.xiaomi.push.ba.a(a8, "setTimeoutAfter", Long.valueOf(a4 * 1000));
                                }
                                String str6 = m403a.get(SharedPrefConfig.CHANNEL_ID);
                                if (!TextUtils.isEmpty(str6) || context.getApplicationInfo().targetSdkVersion >= 26) {
                                    String str7 = "mipush_" + a6 + "_default";
                                    String str8 = TextUtils.isEmpty(str6) ? str7 : com.xiaomi.push.l.m525a() ? "mipush_" + a6 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str6 : str6;
                                    com.xiaomi.push.ba.a(a8, "setChannelId", str8);
                                    String a14 = a(context, a6, m403a);
                                    int b2 = b(m403a);
                                    if (b2 >= 4) {
                                        com.xiaomi.push.ba.a(a8, "setGroup", a(iiVar) + "_top_" + currentTimeMillis2);
                                        if ("com.xiaomi.xmsf".equals(context.getPackageName()) && ak.a(context).a(hr.TopNotificationUpdateSwitch.a(), true) && (a5 = ak.a(context).a(hr.TopNotificationUpdateFrequency.a(), 14400)) > 0) {
                                            com.xiaomi.push.ba.a(a8, "setTimeoutAfter", Long.valueOf(a5 * 1000));
                                            Bundle bundle2 = new Bundle();
                                            bundle2.putLong("mipush_org_when", currentTimeMillis2);
                                            a8.addExtras(bundle2);
                                        }
                                    }
                                    NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
                                    try {
                                        if (com.xiaomi.push.ba.a(notificationManager, "getNotificationChannel", str8) == null) {
                                            Object newInstance = com.xiaomi.push.t.a(context, "android.app.NotificationChannel").getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance(str8, a14, Integer.valueOf(b2));
                                            if (i > -100) {
                                                a8.setSound((Uri) null, (AudioAttributes) null);
                                                a8.setDefaults(0);
                                                int i3 = i & 1;
                                                int i4 = i & 2;
                                                int i5 = i & 4;
                                                if (i3 != 1) {
                                                    com.xiaomi.push.ba.a(newInstance, "setSound", null, null);
                                                }
                                                if (uri != null) {
                                                    com.xiaomi.push.ba.a(newInstance, "setSound", uri, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                                                }
                                                Object[] objArr = new Object[1];
                                                objArr[0] = Boolean.valueOf(i4 == 2);
                                                com.xiaomi.push.ba.a(newInstance, "enableVibration", objArr);
                                                Object[] objArr2 = new Object[1];
                                                objArr2[0] = Boolean.valueOf(i5 == 4);
                                                com.xiaomi.push.ba.a(newInstance, "enableLights", objArr2);
                                            }
                                            a(newInstance, m403a);
                                            com.xiaomi.push.ba.a(notificationManager, "createNotificationChannel", newInstance);
                                        }
                                        Object a15 = com.xiaomi.push.ba.a(notificationManager, "getNotificationChannels", new Object[0]);
                                        if (a15 != null && (a15 instanceof List) && (list = (List) a15) != null && list.size() > 0) {
                                            int i6 = 0;
                                            while (true) {
                                                int i7 = i6;
                                                if (i7 >= list.size()) {
                                                    break;
                                                }
                                                Object obj = list.get(i7);
                                                Object a16 = com.xiaomi.push.ba.a(obj, "getName", new Object[0]);
                                                Object a17 = com.xiaomi.push.ba.a(obj, "getId", new Object[0]);
                                                String b3 = com.xiaomi.push.g.b(context, a6);
                                                if (a16 != null && a17 != null && (a16 instanceof CharSequence) && (a17 instanceof String) && a16.equals(b3) && ((String) a17).startsWith("mipush_" + a6) && !a17.equals(str7)) {
                                                    com.xiaomi.push.ba.a(notificationManager, "deleteNotificationChannel", a17);
                                                }
                                                i6 = i7 + 1;
                                            }
                                        }
                                    } catch (Exception e2) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                                    }
                                }
                                String str9 = m403a.get("background_color");
                                if (!TextUtils.isEmpty(str9)) {
                                    try {
                                        int parseInt = Integer.parseInt(str9);
                                        a8.setOngoing(true);
                                        a8.setColor(parseInt);
                                        com.xiaomi.push.ba.a(a8, "setColorized", true);
                                    } catch (Exception e3) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                                    }
                                }
                            } else if (m403a != null && Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 26) {
                                c2 = c(m403a);
                                com.xiaomi.push.ba.a(a8, "setPriority", Integer.valueOf(c2));
                                if (c2 >= 1) {
                                    com.xiaomi.push.ba.a(a8, "setGroup", a(iiVar) + "_top_" + currentTimeMillis2);
                                }
                            }
                            if (com.xiaomi.push.l.c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                                com.xiaomi.push.ba.a("miui.util.NotificationHelper", "setTargetPkg", context, a8, a(iiVar));
                            }
                            notification = a8.getNotification();
                            if (z && com.xiaomi.push.l.m525a()) {
                                a(notification);
                            }
                            if (m403a != null && (a3 = com.xiaomi.push.ba.a(notification, "extraNotification")) != null) {
                                if (!TextUtils.isEmpty(m403a.get("enable_keyguard"))) {
                                    com.xiaomi.push.ba.a(a3, "setEnableKeyguard", Boolean.valueOf(Boolean.parseBoolean(m403a.get("enable_keyguard"))));
                                }
                                if (!TextUtils.isEmpty(m403a.get("enable_float"))) {
                                    com.xiaomi.push.ba.a(a3, "setEnableFloat", Boolean.valueOf(Boolean.parseBoolean(m403a.get("enable_float"))));
                                }
                            }
                            bVar.f912a = notification;
                            return bVar;
                        }
                    }
                }
                i = i2;
                if (m403a == null) {
                }
                if (m403a != null) {
                    c2 = c(m403a);
                    com.xiaomi.push.ba.a(a8, "setPriority", Integer.valueOf(c2));
                    if (c2 >= 1) {
                    }
                }
                if (com.xiaomi.push.l.c()) {
                    com.xiaomi.push.ba.a("miui.util.NotificationHelper", "setTargetPkg", context, a8, a(iiVar));
                }
                notification = a8.getNotification();
                if (z) {
                    a(notification);
                }
                if (m403a != null) {
                    if (!TextUtils.isEmpty(m403a.get("enable_keyguard"))) {
                    }
                    if (!TextUtils.isEmpty(m403a.get("enable_float"))) {
                    }
                }
                bVar.f912a = notification;
                return bVar;
            }
        }
        z = false;
        if (m403a != null) {
        }
        if (a2 != null) {
        }
        if (m403a != null) {
            str = m403a.get("notification_group");
            boolean parseBoolean2 = Boolean.parseBoolean(m403a.get("notification_is_summary"));
            if (TextUtils.isEmpty(str)) {
            }
            com.xiaomi.push.ba.a(a8, "setGroup", ag.a().a(context, a8, str));
            com.xiaomi.push.ba.a(a8, "setGroupSummary", Boolean.valueOf(parseBoolean2));
        }
        a8.setAutoCancel(true);
        currentTimeMillis = System.currentTimeMillis();
        if (m403a != null) {
            a8.setTicker(m403a.get(ALaKeepAliveService.KEY_TICKER));
        }
        int i22 = -100;
        Uri uri2 = null;
        if (currentTimeMillis - f14222a > 10000) {
        }
        i = i22;
        if (m403a == null) {
        }
        if (m403a != null) {
        }
        if (com.xiaomi.push.l.c()) {
        }
        notification = a8.getNotification();
        if (z) {
        }
        if (m403a != null) {
        }
        bVar.f912a = notification;
        return bVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static c m555a(Context context, ii iiVar, byte[] bArr) {
        Notification notification;
        c cVar = new c();
        if (com.xiaomi.push.g.m331a(context, a(iiVar)) == g.a.NOT_ALLOWED) {
            hz m443a = iiVar.m443a();
            if (m443a != null) {
                fb.a(context.getApplicationContext()).a(iiVar.b(), b(iiVar), m443a.m402a(), "10:" + a(iiVar));
            }
            com.xiaomi.channel.commonutils.logger.b.m79a("Do not notify because user block " + a(iiVar) + "‘s notification");
            return cVar;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        hz m443a2 = iiVar.m443a();
        RemoteViews a2 = a(context, iiVar, bArr);
        int hashCode = ((a(iiVar).hashCode() / 10) * 10) + (m443a2 != null ? m443a2.c() : 0);
        PendingIntent a3 = a(context, iiVar, m443a2, bArr, hashCode);
        if (a3 == null) {
            if (m443a2 != null) {
                fb.a(context.getApplicationContext()).a(iiVar.b(), b(iiVar), m443a2.m402a(), Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            }
            com.xiaomi.channel.commonutils.logger.b.m79a("The click PendingIntent is null. ");
            return cVar;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            b a4 = a(context, iiVar, bArr, a2, a3);
            cVar.f14225a = a4.f14224a;
            cVar.f913a = a(iiVar);
            notification = a4.f912a;
        } else {
            Notification notification2 = new Notification(b(context, a(iiVar)), null, System.currentTimeMillis());
            String[] a5 = a(context, m443a2);
            try {
                notification2.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification2, context, a5[0], a5[1], a3);
            } catch (IllegalAccessException e) {
                if (m443a2 != null) {
                    fb.a(context.getApplicationContext()).b(iiVar.b(), b(iiVar), m443a2.m402a(), "5");
                }
                com.xiaomi.channel.commonutils.logger.b.a(e);
            } catch (IllegalArgumentException e2) {
                if (m443a2 != null) {
                    fb.a(context.getApplicationContext()).b(iiVar.b(), b(iiVar), m443a2.m402a(), "6");
                }
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            } catch (NoSuchMethodException e3) {
                if (m443a2 != null) {
                    fb.a(context.getApplicationContext()).b(iiVar.b(), b(iiVar), m443a2.m402a(), "4");
                }
                com.xiaomi.channel.commonutils.logger.b.a(e3);
            } catch (InvocationTargetException e4) {
                if (m443a2 != null) {
                    fb.a(context.getApplicationContext()).b(iiVar.b(), b(iiVar), m443a2.m402a(), "7");
                }
                com.xiaomi.channel.commonutils.logger.b.a(e4);
            }
            Map<String, String> m403a = m443a2.m403a();
            if (m403a != null && m403a.containsKey(ALaKeepAliveService.KEY_TICKER)) {
                notification2.tickerText = m403a.get(ALaKeepAliveService.KEY_TICKER);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f14222a > 10000) {
                f14222a = currentTimeMillis;
                int a6 = m561b(context, a(iiVar)) ? a(context, a(iiVar)) : m443a2.f586a;
                notification2.defaults = a6;
                if (m403a != null && (a6 & 1) != 0) {
                    String str = m403a.get("sound_uri");
                    if (!TextUtils.isEmpty(str) && str.startsWith("android.resource://" + a(iiVar))) {
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
        if (com.xiaomi.push.l.m525a() && Build.VERSION.SDK_INT >= 19) {
            if (!TextUtils.isEmpty(m443a2.m402a())) {
                notification.extras.putString("message_id", m443a2.m402a());
            }
            String str2 = m443a2.m408b() == null ? null : m443a2.m408b().get("score_info");
            if (!TextUtils.isEmpty(str2)) {
                notification.extras.putString("score_info", str2);
            }
            int i = -1;
            if (c(iiVar)) {
                i = 1000;
            } else if (m558a(iiVar)) {
                i = 3000;
            }
            notification.extras.putString("eventMessageType", String.valueOf(i));
            notification.extras.putString("target_package", a(iiVar));
        }
        String str3 = m443a2.m403a() == null ? null : m443a2.m403a().get("message_count");
        if (com.xiaomi.push.l.m525a() && str3 != null) {
            try {
                a(notification, Integer.parseInt(str3));
            } catch (NumberFormatException e5) {
                if (m443a2 != null) {
                    fb.a(context.getApplicationContext()).b(iiVar.b(), b(iiVar), m443a2.m402a(), "8");
                }
                com.xiaomi.channel.commonutils.logger.b.a(e5);
            }
        }
        if (!com.xiaomi.push.l.c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
            a(notification, a(iiVar));
        }
        notificationManager.notify(hashCode, notification);
        if (com.xiaomi.push.l.m525a() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
            ag.a().a(context, hashCode, notification);
        }
        if (m558a(iiVar)) {
            fb.a(context.getApplicationContext()).a(iiVar.b(), b(iiVar), m443a2.m402a(), 3002, null);
        }
        if (c(iiVar)) {
            fb.a(context.getApplicationContext()).a(iiVar.b(), b(iiVar), m443a2.m402a(), 1002, null);
        }
        if (Build.VERSION.SDK_INT < 26) {
            com.xiaomi.push.ai a7 = com.xiaomi.push.ai.a(context);
            a7.m153a(hashCode);
            int a8 = a(m443a2.m403a());
            if (a8 > 0) {
                a7.b(new ab(hashCode, notificationManager), a8);
            }
        }
        Pair<Integer, ii> pair = new Pair<>(Integer.valueOf(hashCode), iiVar);
        synchronized (f908a) {
            f908a.add(pair);
            if (f908a.size() > 100) {
                f908a.remove();
            }
        }
        return cVar;
    }

    private static String a(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? com.xiaomi.push.g.b(context, str) : map.get("channel_name");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(ii iiVar) {
        hz m443a;
        if ("com.xiaomi.xmsf".equals(iiVar.f684b) && (m443a = iiVar.m443a()) != null && m443a.m403a() != null) {
            String str = m443a.m403a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return iiVar.f684b;
    }

    private static void a(Notification notification, int i) {
        Object a2 = com.xiaomi.push.ba.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.push.ba.a(a2, "setMessageCount", Integer.valueOf(i));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m556a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        int hashCode = ((str.hashCode() / 10) * 10) + i;
        LinkedList linkedList = new LinkedList();
        if (i >= 0) {
            notificationManager.cancel(hashCode);
        }
        synchronized (f908a) {
            Iterator<Pair<Integer, ii>> it = f908a.iterator();
            while (it.hasNext()) {
                Pair<Integer, ii> next = it.next();
                ii iiVar = (ii) next.second;
                if (iiVar != null) {
                    String a2 = a(iiVar);
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
            if (f908a != null) {
                f908a.removeAll(linkedList);
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        LinkedList linkedList = new LinkedList();
        synchronized (f908a) {
            Iterator<Pair<Integer, ii>> it = f908a.iterator();
            while (it.hasNext()) {
                Pair<Integer, ii> next = it.next();
                ii iiVar = (ii) next.second;
                if (iiVar != null) {
                    String a2 = a(iiVar);
                    hz m443a = iiVar.m443a();
                    if (m443a != null && TextUtils.equals(a2, str)) {
                        String m410c = m443a.m410c();
                        String d = m443a.d();
                        if (!TextUtils.isEmpty(m410c) && !TextUtils.isEmpty(d) && a(str2, m410c) && a(str3, d)) {
                            notificationManager.cancel(((Integer) next.first).intValue());
                            linkedList.add(next);
                        }
                    }
                }
            }
            if (f908a != null) {
                f908a.removeAll(linkedList);
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        bi.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    private static void a(Object obj, Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(map.get("channel_description"))) {
            return;
        }
        com.xiaomi.push.ba.a(obj, "setDescription", map.get("channel_description"));
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

    private static boolean a(hz hzVar) {
        if (hzVar != null) {
            String m402a = hzVar.m402a();
            return !TextUtils.isEmpty(m402a) && m402a.length() == 22 && "satuigmo".indexOf(m402a.charAt(0)) >= 0;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m558a(ii iiVar) {
        hz m443a = iiVar.m443a();
        return a(m443a) && m443a.l();
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m559a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    private static String[] a(Context context, hz hzVar) {
        String m410c = hzVar.m410c();
        String d = hzVar.d();
        Map<String, String> m403a = hzVar.m403a();
        if (m403a != null) {
            int intValue = Float.valueOf((context.getResources().getDisplayMetrics().widthPixels / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (intValue <= 320) {
                String str = m403a.get("title_short");
                if (!TextUtils.isEmpty(str)) {
                    m410c = str;
                }
                String str2 = m403a.get("description_short");
                if (TextUtils.isEmpty(str2)) {
                    str2 = d;
                }
                d = str2;
            } else if (intValue > 360) {
                String str3 = m403a.get("title_long");
                if (!TextUtils.isEmpty(str3)) {
                    m410c = str3;
                }
                String str4 = m403a.get("description_long");
                if (!TextUtils.isEmpty(str4)) {
                    d = str4;
                }
            }
        }
        return new String[]{m410c, d};
    }

    private static int b(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return (a2 != 0 || Build.VERSION.SDK_INT < 9) ? a2 : context.getApplicationInfo().logo;
    }

    private static int b(Map<String, String> map) {
        if (map != null) {
            String str = map.get("channel_importance");
            if (!TextUtils.isEmpty(str)) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.c("importance=3");
                    return Integer.parseInt(str);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d("parsing channel importance error: " + e);
                    return 3;
                }
            }
        }
        return 3;
    }

    public static String b(ii iiVar) {
        return m558a(iiVar) ? "E100002" : c(iiVar) ? "E100000" : m562b(iiVar) ? "E100001" : d(iiVar) ? "E100003" : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public static void m560b(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public static boolean m561b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m562b(ii iiVar) {
        hz m443a = iiVar.m443a();
        return a(m443a) && m443a.f592b == 1 && !m558a(iiVar);
    }

    private static int c(Map<String, String> map) {
        if (map != null) {
            String str = map.get("notification_priority");
            if (!TextUtils.isEmpty(str)) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.c("priority=" + str);
                    return Integer.parseInt(str);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d("parsing notification priority error: " + e);
                    return 0;
                }
            }
        }
        return 0;
    }

    public static boolean c(ii iiVar) {
        hz m443a = iiVar.m443a();
        return a(m443a) && m443a.f592b == 0 && !m558a(iiVar);
    }

    public static boolean d(ii iiVar) {
        return iiVar.a() == hm.Registration;
    }

    public static boolean e(ii iiVar) {
        return m558a(iiVar) || c(iiVar) || m562b(iiVar);
    }
}
