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
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tieba.ala.ALaKeepAliveService;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
/* loaded from: classes9.dex */
public class aa {
    public static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final LinkedList<Pair<Integer, ii>> f834a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f835a = Executors.newCachedThreadPool();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements Callable<Bitmap> {
        private Context a;

        /* renamed from: a  reason: collision with other field name */
        private String f836a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f837a;

        public a(String str, Context context, boolean z) {
            this.a = context;
            this.f836a = str;
            this.f837a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Bitmap call() {
            if (TextUtils.isEmpty(this.f836a)) {
                com.xiaomi.channel.commonutils.logger.b.m49a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            } else if (this.f836a.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                ai.b a = ai.a(this.a, this.f836a, this.f837a);
                if (a != null) {
                    return a.f849a;
                }
                com.xiaomi.channel.commonutils.logger.b.m49a("Failed get online picture/icon resource");
                return null;
            } else {
                Bitmap a2 = ai.a(this.a, this.f836a);
                if (a2 == null) {
                    com.xiaomi.channel.commonutils.logger.b.m49a("Failed get online picture/icon resource");
                    return a2;
                }
                return a2;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        long a = 0;

        /* renamed from: a  reason: collision with other field name */
        Notification f838a;
    }

    /* loaded from: classes9.dex */
    public static class c {
        public long a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f839a;
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
                com.xiaomi.channel.commonutils.logger.b.m49a("can not get big picture.");
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
        } else if (m528a(iiVar)) {
            i2 = 3000;
        }
        String m372a = hzVar != null ? hzVar.m372a() : "";
        if (hzVar != null && !TextUtils.isEmpty(hzVar.f525e)) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(hzVar.f525e));
            intent2.addFlags(268435456);
            intent2.putExtra("messageId", m372a);
            intent2.putExtra("eventMessageType", i2);
            return PendingIntent.getActivity(context, 0, intent2, 134217728);
        }
        if (m528a(iiVar)) {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i));
            intent.addCategory(String.valueOf(m372a));
        } else {
            intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.setComponent(new ComponentName(iiVar.f610b, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i));
            intent.addCategory(String.valueOf(m372a));
        }
        intent.putExtra("messageId", m372a);
        intent.putExtra("eventMessageType", i2);
        if (f.b(context, iiVar.f610b, "com.xiaomi.mipush.MESSAGE_CLICKED")) {
            Intent intent3 = new Intent();
            intent3.setAction("com.xiaomi.mipush.MESSAGE_CLICKED");
            intent3.setClassName(iiVar.f610b, "com.xiaomi.mipush.sdk.BridgeActivity");
            intent3.addFlags(276824064);
            intent3.putExtra("mipush_serviceIntent", intent);
            intent3.addCategory(String.valueOf(i));
            intent3.addCategory(String.valueOf(m372a));
            return PendingIntent.getActivity(context, 0, intent3, 134217728);
        }
        return PendingIntent.getService(context, 0, intent, 134217728);
    }

    private static PendingIntent a(Context context, String str, int i, Map<String, String> map) {
        Intent m524a;
        if (map == null || (m524a = m524a(context, str, i, map)) == null) {
            return null;
        }
        return PendingIntent.getActivity(context, 0, m524a, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Intent m524a(Context context, String str, int i, Map<String, String> map) {
        Intent intent;
        Intent intent2;
        URISyntaxException e;
        String str2 = map.get(i < 2 ? "notification_style_button_left_notify_effect" : i < 3 ? "notification_style_button_mid_notify_effect" : "notification_style_button_right_notify_effect");
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (at.a.equals(str2)) {
            try {
                intent = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e2.getMessage());
                intent = null;
            }
        } else {
            if (at.b.equals(str2)) {
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
                                intent2 = intent;
                                e = e5;
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
        Future submit = f835a.submit(new a(str, context, z));
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
        hz m413a = iiVar.m413a();
        String a2 = a(iiVar);
        Map<String, String> m373a = m413a.m373a();
        if (m373a == null) {
            return null;
        }
        String str = m373a.get("layout_name");
        String str2 = m373a.get("layout_value");
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
        hz m413a = iiVar.m413a();
        String a6 = a(iiVar);
        Map<String, String> m373a = m413a.m373a();
        Notification.Builder builder = new Notification.Builder(context);
        String[] a7 = a(context, m413a);
        builder.setContentTitle(a7[0]);
        builder.setContentText(a7[1]);
        if (remoteViews != null) {
            builder.setContent(remoteViews);
        } else if (Build.VERSION.SDK_INT >= 16 && m373a != null && m373a.containsKey("notification_style_type")) {
            builder = a(context, m373a, builder, a7[1]);
        }
        Notification.Builder a8 = a(builder, context, iiVar.b(), m373a);
        long currentTimeMillis2 = System.currentTimeMillis();
        a8.setWhen(currentTimeMillis2);
        String str2 = m373a == null ? null : m373a.get("notification_show_when");
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
            Bitmap a11 = m373a == null ? null : a(context, m373a.get("notification_small_icon_uri"), true);
            if (a11 != null) {
                Object a12 = com.xiaomi.push.ba.a("android.graphics.drawable.Icon", "createWithBitmap", a11);
                if (a12 != null) {
                    com.xiaomi.push.ba.a(a8, "setSmallIcon", a12);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("miui.isGrayscaleIcon", true);
                    a8.addExtras(bundle);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m49a("failed te get small icon with url:" + m373a.get("notification_small_icon_uri"));
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.m49a("failed to get small icon url:" + (m373a == null ? null : m373a.get("notification_small_icon_uri")));
            }
            String str3 = m373a == null ? null : m373a.get("notification_small_icon_color");
            if (!TextUtils.isEmpty(str3)) {
                try {
                    com.xiaomi.push.ba.a(a8, "setColor", Integer.valueOf(Color.parseColor(str3)));
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
        String str4 = m373a == null ? null : m373a.get("__dynamic_icon_uri");
        boolean z2 = (m373a != null && Boolean.parseBoolean(m373a.get("__adiom"))) || !com.xiaomi.push.l.m495a();
        if (str4 != null && z2) {
            Bitmap bitmap = null;
            if (str4.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                ai.b a13 = ai.a(context, str4, true);
                if (a13 != null) {
                    bitmap = a13.f849a;
                    bVar.a = a13.a;
                }
            } else {
                bitmap = ai.a(context, str4);
            }
            if (bitmap != null) {
                a8.setLargeIcon(bitmap);
                z = true;
                a2 = m373a != null ? null : a(context, m373a.get("notification_large_icon_uri"), true);
                if (a2 != null) {
                    a8.setLargeIcon(a2);
                }
                if (m373a != null && Build.VERSION.SDK_INT >= 24) {
                    str = m373a.get("notification_group");
                    boolean parseBoolean = Boolean.parseBoolean(m373a.get("notification_is_summary"));
                    if (TextUtils.isEmpty(str)) {
                        str = a(iiVar);
                    }
                    com.xiaomi.push.ba.a(a8, "setGroup", ag.a().a(context, a8, str));
                    com.xiaomi.push.ba.a(a8, "setGroupSummary", Boolean.valueOf(parseBoolean));
                }
                a8.setAutoCancel(true);
                currentTimeMillis = System.currentTimeMillis();
                if (m373a != null && m373a.containsKey(ALaKeepAliveService.KEY_TICKER)) {
                    a8.setTicker(m373a.get(ALaKeepAliveService.KEY_TICKER));
                }
                int i2 = -100;
                Uri uri = null;
                if (currentTimeMillis - a > 10000) {
                    a = currentTimeMillis;
                    i2 = m531b(context, a6) ? a(context, a6) : m413a.f512a;
                    a8.setDefaults(i2);
                    if (m373a != null && (i2 & 1) != 0) {
                        String str5 = m373a.get("sound_uri");
                        if (!TextUtils.isEmpty(str5) && str5.startsWith("android.resource://" + a6)) {
                            a8.setDefaults(i2 ^ 1);
                            Uri parse = Uri.parse(str5);
                            a8.setSound(parse);
                            uri = parse;
                            i = i2;
                            if (m373a == null && Build.VERSION.SDK_INT >= 26) {
                                if (a(m373a) > 0) {
                                    com.xiaomi.push.ba.a(a8, "setTimeoutAfter", Long.valueOf(a4 * 1000));
                                }
                                String str6 = m373a.get(SharedPrefConfig.CHANNEL_ID);
                                if (!TextUtils.isEmpty(str6) || context.getApplicationInfo().targetSdkVersion >= 26) {
                                    String str7 = "mipush_" + a6 + "_default";
                                    String str8 = TextUtils.isEmpty(str6) ? str7 : com.xiaomi.push.l.m495a() ? "mipush_" + a6 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str6 : str6;
                                    com.xiaomi.push.ba.a(a8, "setChannelId", str8);
                                    String a14 = a(context, a6, m373a);
                                    int b2 = b(m373a);
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
                                            a(newInstance, m373a);
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
                                String str9 = m373a.get("background_color");
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
                            } else if (m373a != null && Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 26) {
                                c2 = c(m373a);
                                com.xiaomi.push.ba.a(a8, "setPriority", Integer.valueOf(c2));
                                if (c2 >= 1) {
                                    com.xiaomi.push.ba.a(a8, "setGroup", a(iiVar) + "_top_" + currentTimeMillis2);
                                }
                            }
                            if (com.xiaomi.push.l.c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                                com.xiaomi.push.ba.a("miui.util.NotificationHelper", "setTargetPkg", context, a8, a(iiVar));
                            }
                            notification = a8.getNotification();
                            if (z && com.xiaomi.push.l.m495a()) {
                                a(notification);
                            }
                            if (m373a != null && (a3 = com.xiaomi.push.ba.a(notification, "extraNotification")) != null) {
                                if (!TextUtils.isEmpty(m373a.get("enable_keyguard"))) {
                                    com.xiaomi.push.ba.a(a3, "setEnableKeyguard", Boolean.valueOf(Boolean.parseBoolean(m373a.get("enable_keyguard"))));
                                }
                                if (!TextUtils.isEmpty(m373a.get("enable_float"))) {
                                    com.xiaomi.push.ba.a(a3, "setEnableFloat", Boolean.valueOf(Boolean.parseBoolean(m373a.get("enable_float"))));
                                }
                            }
                            bVar.f838a = notification;
                            return bVar;
                        }
                    }
                }
                i = i2;
                if (m373a == null) {
                }
                if (m373a != null) {
                    c2 = c(m373a);
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
                if (m373a != null) {
                    if (!TextUtils.isEmpty(m373a.get("enable_keyguard"))) {
                    }
                    if (!TextUtils.isEmpty(m373a.get("enable_float"))) {
                    }
                }
                bVar.f838a = notification;
                return bVar;
            }
        }
        z = false;
        if (m373a != null) {
        }
        if (a2 != null) {
        }
        if (m373a != null) {
            str = m373a.get("notification_group");
            boolean parseBoolean2 = Boolean.parseBoolean(m373a.get("notification_is_summary"));
            if (TextUtils.isEmpty(str)) {
            }
            com.xiaomi.push.ba.a(a8, "setGroup", ag.a().a(context, a8, str));
            com.xiaomi.push.ba.a(a8, "setGroupSummary", Boolean.valueOf(parseBoolean2));
        }
        a8.setAutoCancel(true);
        currentTimeMillis = System.currentTimeMillis();
        if (m373a != null) {
            a8.setTicker(m373a.get(ALaKeepAliveService.KEY_TICKER));
        }
        int i22 = -100;
        Uri uri2 = null;
        if (currentTimeMillis - a > 10000) {
        }
        i = i22;
        if (m373a == null) {
        }
        if (m373a != null) {
        }
        if (com.xiaomi.push.l.c()) {
        }
        notification = a8.getNotification();
        if (z) {
        }
        if (m373a != null) {
        }
        bVar.f838a = notification;
        return bVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static c m525a(Context context, ii iiVar, byte[] bArr) {
        Notification notification;
        c cVar = new c();
        if (com.xiaomi.push.g.m301a(context, a(iiVar)) == g.a.NOT_ALLOWED) {
            hz m413a = iiVar.m413a();
            if (m413a != null) {
                fb.a(context.getApplicationContext()).a(iiVar.b(), b(iiVar), m413a.m372a(), "10:" + a(iiVar));
            }
            com.xiaomi.channel.commonutils.logger.b.m49a("Do not notify because user block " + a(iiVar) + "‘s notification");
            return cVar;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        hz m413a2 = iiVar.m413a();
        RemoteViews a2 = a(context, iiVar, bArr);
        int hashCode = ((a(iiVar).hashCode() / 10) * 10) + (m413a2 != null ? m413a2.c() : 0);
        PendingIntent a3 = a(context, iiVar, m413a2, bArr, hashCode);
        if (a3 == null) {
            if (m413a2 != null) {
                fb.a(context.getApplicationContext()).a(iiVar.b(), b(iiVar), m413a2.m372a(), "11");
            }
            com.xiaomi.channel.commonutils.logger.b.m49a("The click PendingIntent is null. ");
            return cVar;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            b a4 = a(context, iiVar, bArr, a2, a3);
            cVar.a = a4.a;
            cVar.f839a = a(iiVar);
            notification = a4.f838a;
        } else {
            Notification notification2 = new Notification(b(context, a(iiVar)), null, System.currentTimeMillis());
            String[] a5 = a(context, m413a2);
            try {
                notification2.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification2, context, a5[0], a5[1], a3);
            } catch (IllegalAccessException e) {
                if (m413a2 != null) {
                    fb.a(context.getApplicationContext()).b(iiVar.b(), b(iiVar), m413a2.m372a(), "5");
                }
                com.xiaomi.channel.commonutils.logger.b.a(e);
            } catch (IllegalArgumentException e2) {
                if (m413a2 != null) {
                    fb.a(context.getApplicationContext()).b(iiVar.b(), b(iiVar), m413a2.m372a(), "6");
                }
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            } catch (NoSuchMethodException e3) {
                if (m413a2 != null) {
                    fb.a(context.getApplicationContext()).b(iiVar.b(), b(iiVar), m413a2.m372a(), "4");
                }
                com.xiaomi.channel.commonutils.logger.b.a(e3);
            } catch (InvocationTargetException e4) {
                if (m413a2 != null) {
                    fb.a(context.getApplicationContext()).b(iiVar.b(), b(iiVar), m413a2.m372a(), "7");
                }
                com.xiaomi.channel.commonutils.logger.b.a(e4);
            }
            Map<String, String> m373a = m413a2.m373a();
            if (m373a != null && m373a.containsKey(ALaKeepAliveService.KEY_TICKER)) {
                notification2.tickerText = m373a.get(ALaKeepAliveService.KEY_TICKER);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a > 10000) {
                a = currentTimeMillis;
                int a6 = m531b(context, a(iiVar)) ? a(context, a(iiVar)) : m413a2.f512a;
                notification2.defaults = a6;
                if (m373a != null && (a6 & 1) != 0) {
                    String str = m373a.get("sound_uri");
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
        if (com.xiaomi.push.l.m495a() && Build.VERSION.SDK_INT >= 19) {
            if (!TextUtils.isEmpty(m413a2.m372a())) {
                notification.extras.putString("message_id", m413a2.m372a());
            }
            String str2 = m413a2.m378b() == null ? null : m413a2.m378b().get("score_info");
            if (!TextUtils.isEmpty(str2)) {
                notification.extras.putString("score_info", str2);
            }
            int i = -1;
            if (c(iiVar)) {
                i = 1000;
            } else if (m528a(iiVar)) {
                i = 3000;
            }
            notification.extras.putString("eventMessageType", String.valueOf(i));
            notification.extras.putString("target_package", a(iiVar));
        }
        String str3 = m413a2.m373a() == null ? null : m413a2.m373a().get("message_count");
        if (com.xiaomi.push.l.m495a() && str3 != null) {
            try {
                a(notification, Integer.parseInt(str3));
            } catch (NumberFormatException e5) {
                if (m413a2 != null) {
                    fb.a(context.getApplicationContext()).b(iiVar.b(), b(iiVar), m413a2.m372a(), "8");
                }
                com.xiaomi.channel.commonutils.logger.b.a(e5);
            }
        }
        if (!com.xiaomi.push.l.c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
            a(notification, a(iiVar));
        }
        notificationManager.notify(hashCode, notification);
        if (com.xiaomi.push.l.m495a() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
            ag.a().a(context, hashCode, notification);
        }
        if (m528a(iiVar)) {
            fb.a(context.getApplicationContext()).a(iiVar.b(), b(iiVar), m413a2.m372a(), 3002, null);
        }
        if (c(iiVar)) {
            fb.a(context.getApplicationContext()).a(iiVar.b(), b(iiVar), m413a2.m372a(), 1002, null);
        }
        if (Build.VERSION.SDK_INT < 26) {
            com.xiaomi.push.ai a7 = com.xiaomi.push.ai.a(context);
            a7.m123a(hashCode);
            int a8 = a(m413a2.m373a());
            if (a8 > 0) {
                a7.b(new ab(hashCode, notificationManager), a8);
            }
        }
        Pair<Integer, ii> pair = new Pair<>(Integer.valueOf(hashCode), iiVar);
        synchronized (f834a) {
            f834a.add(pair);
            if (f834a.size() > 100) {
                f834a.remove();
            }
        }
        return cVar;
    }

    private static String a(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? com.xiaomi.push.g.b(context, str) : map.get("channel_name");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(ii iiVar) {
        hz m413a;
        if ("com.xiaomi.xmsf".equals(iiVar.f610b) && (m413a = iiVar.m413a()) != null && m413a.m373a() != null) {
            String str = m413a.m373a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return iiVar.f610b;
    }

    private static void a(Notification notification, int i) {
        Object a2 = com.xiaomi.push.ba.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.push.ba.a(a2, "setMessageCount", Integer.valueOf(i));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m526a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        int hashCode = ((str.hashCode() / 10) * 10) + i;
        LinkedList linkedList = new LinkedList();
        if (i >= 0) {
            notificationManager.cancel(hashCode);
        }
        synchronized (f834a) {
            Iterator<Pair<Integer, ii>> it = f834a.iterator();
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
            if (f834a != null) {
                f834a.removeAll(linkedList);
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
        synchronized (f834a) {
            Iterator<Pair<Integer, ii>> it = f834a.iterator();
            while (it.hasNext()) {
                Pair<Integer, ii> next = it.next();
                ii iiVar = (ii) next.second;
                if (iiVar != null) {
                    String a2 = a(iiVar);
                    hz m413a = iiVar.m413a();
                    if (m413a != null && TextUtils.equals(a2, str)) {
                        String m380c = m413a.m380c();
                        String d = m413a.d();
                        if (!TextUtils.isEmpty(m380c) && !TextUtils.isEmpty(d) && a(str2, m380c) && a(str3, d)) {
                            notificationManager.cancel(((Integer) next.first).intValue());
                            linkedList.add(next);
                        }
                    }
                }
            }
            if (f834a != null) {
                f834a.removeAll(linkedList);
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
    public static boolean m527a(Context context, String str) {
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
            String m372a = hzVar.m372a();
            return !TextUtils.isEmpty(m372a) && m372a.length() == 22 && "satuigmo".indexOf(m372a.charAt(0)) >= 0;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m528a(ii iiVar) {
        hz m413a = iiVar.m413a();
        return a(m413a) && m413a.l();
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m529a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    private static String[] a(Context context, hz hzVar) {
        String m380c = hzVar.m380c();
        String d = hzVar.d();
        Map<String, String> m373a = hzVar.m373a();
        if (m373a != null) {
            int intValue = Float.valueOf((context.getResources().getDisplayMetrics().widthPixels / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (intValue <= 320) {
                String str = m373a.get("title_short");
                if (!TextUtils.isEmpty(str)) {
                    m380c = str;
                }
                String str2 = m373a.get("description_short");
                if (TextUtils.isEmpty(str2)) {
                    str2 = d;
                }
                d = str2;
            } else if (intValue > 360) {
                String str3 = m373a.get("title_long");
                if (!TextUtils.isEmpty(str3)) {
                    m380c = str3;
                }
                String str4 = m373a.get("description_long");
                if (!TextUtils.isEmpty(str4)) {
                    d = str4;
                }
            }
        }
        return new String[]{m380c, d};
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
        return m528a(iiVar) ? "E100002" : c(iiVar) ? "E100000" : m532b(iiVar) ? "E100001" : d(iiVar) ? "E100003" : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public static void m530b(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public static boolean m531b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m532b(ii iiVar) {
        hz m413a = iiVar.m413a();
        return a(m413a) && m413a.f518b == 1 && !m528a(iiVar);
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
        hz m413a = iiVar.m413a();
        return a(m413a) && m413a.f518b == 0 && !m528a(iiVar);
    }

    public static boolean d(ii iiVar) {
        return iiVar.a() == hm.Registration;
    }

    public static boolean e(ii iiVar) {
        return m528a(iiVar) || c(iiVar) || m532b(iiVar);
    }
}
