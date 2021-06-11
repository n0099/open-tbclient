package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Notification;
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
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.alibaba.fastjson.asm.Label;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tieba.ala.ALaKeepAliveService;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.push.ai;
import com.xiaomi.push.el;
import com.xiaomi.push.em;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import com.xiaomi.push.g;
import com.xiaomi.push.hf;
import com.xiaomi.push.hs;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.an;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    public static long f41715a;

    /* renamed from: a  reason: collision with other field name */
    public static volatile aj f869a;

    /* renamed from: a  reason: collision with other field name */
    public static final LinkedList<Pair<Integer, ib>> f870a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    public static ExecutorService f871a = Executors.newCachedThreadPool();

    /* loaded from: classes7.dex */
    public static class a implements Callable<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public Context f41716a;

        /* renamed from: a  reason: collision with other field name */
        public String f872a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f873a;

        public a(String str, Context context, boolean z) {
            this.f41716a = context;
            this.f872a = str;
            this.f873a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Bitmap call() {
            Bitmap bitmap = null;
            if (TextUtils.isEmpty(this.f872a)) {
                com.xiaomi.channel.commonutils.logger.b.m56a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            }
            if (this.f872a.startsWith("http")) {
                an.b a2 = an.a(this.f41716a, this.f872a, this.f873a);
                if (a2 != null) {
                    return a2.f889a;
                }
            } else {
                bitmap = an.a(this.f41716a, this.f872a);
                if (bitmap != null) {
                    return bitmap;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m56a("Failed get online picture/icon resource");
            return bitmap;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f41717a = 0;

        /* renamed from: a  reason: collision with other field name */
        public Notification f874a;
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f41718a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f875a;
    }

    public static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    public static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    public static int a(Context context, String str, Map<String, String> map) {
        ComponentName a2;
        Intent a3 = a(context, str, map, "notify_effect", "intent_uri", ForumSquareActivityConfig.FORUM_CLASS_NAME, "web_uri");
        if (a3 == null || (a2 = g.a(context, a3)) == null) {
            return 0;
        }
        return a2.hashCode();
    }

    public static int a(Map<String, String> map) {
        String str = map == null ? null : map.get("timeout");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static Notification a(Notification notification) {
        Object a2 = com.xiaomi.push.bh.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.push.bh.a(a2, "setCustomizedIcon", Boolean.TRUE);
        }
        return notification;
    }

    public static Notification a(Notification notification, String str) {
        try {
            Field declaredField = Notification.class.getDeclaredField("extraNotification");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(notification);
            Method declaredMethod = obj.getClass().getDeclaredMethod("setTargetPkg", CharSequence.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, str);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
        return notification;
    }

    public static PendingIntent a(Context context, ib ibVar, String str, byte[] bArr, int i2) {
        return a(context, ibVar, str, bArr, i2, 0, a(context, ibVar, str));
    }

    public static PendingIntent a(Context context, ib ibVar, String str, byte[] bArr, int i2, int i3, boolean z) {
        Intent intent;
        int i4 = c(ibVar) ? 1000 : m561a(ibVar) ? 3000 : -1;
        hs m436a = ibVar.m436a();
        String m393a = m436a != null ? m436a.m393a() : "";
        boolean m561a = m561a(ibVar);
        if (m436a != null && !TextUtils.isEmpty(m436a.f550e)) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(m436a.f550e));
            intent2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent2.putExtra(MiPushMessage.KEY_MESSAGE_ID, m393a);
            intent2.putExtra("eventMessageType", i4);
            return PendingIntent.getActivity(context, 0, intent2, 134217728);
        }
        if (m561a) {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i2));
            intent.addCategory(String.valueOf(m393a));
        } else {
            intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.setComponent(new ComponentName(str, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i2));
            intent.addCategory(String.valueOf(m393a));
        }
        intent.putExtra("notification_click_button", i3);
        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m393a);
        intent.putExtra("eventMessageType", i4);
        if (m561a || !z) {
            a(context, intent, ibVar, m436a);
            return PendingIntent.getService(context, 0, intent, 134217728);
        }
        Intent intent3 = new Intent();
        intent3.setComponent(a(str));
        intent3.addFlags(276824064);
        intent3.putExtra("mipush_serviceIntent", intent);
        intent3.addCategory(String.valueOf(i2));
        intent3.addCategory(String.valueOf(m393a));
        intent3.addCategory(String.valueOf(i3));
        a(context, intent3, ibVar, m436a);
        a(intent3);
        return PendingIntent.getActivity(context, 0, intent3, 134217728);
    }

    public static PendingIntent a(Context context, String str, ib ibVar, byte[] bArr, int i2, int i3) {
        Map<String, String> m394a = ibVar.m436a().m394a();
        if (m394a == null) {
            return null;
        }
        boolean a2 = a(context, ibVar, str);
        if (a2) {
            return a(context, ibVar, str, bArr, i2, i3, a2);
        }
        Intent a3 = a(context, str, m394a, i3);
        if (a3 != null) {
            return PendingIntent.getActivity(context, 0, a3, 134217728);
        }
        return null;
    }

    public static ComponentName a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i2) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (i2 == 1) {
            str2 = "notification_style_button_left_notify_effect";
            str3 = "notification_style_button_left_intent_uri";
            str4 = "notification_style_button_left_intent_class";
            str5 = "notification_style_button_left_web_uri";
        } else if (i2 == 2) {
            str2 = "notification_style_button_mid_notify_effect";
            str3 = "notification_style_button_mid_intent_uri";
            str4 = "notification_style_button_mid_intent_class";
            str5 = "notification_style_button_mid_web_uri";
        } else if (i2 == 3) {
            str2 = "notification_style_button_right_notify_effect";
            str3 = "notification_style_button_right_intent_uri";
            str4 = "notification_style_button_right_intent_class";
            str5 = "notification_style_button_right_web_uri";
        } else if (i2 != 4) {
            return null;
        } else {
            str2 = "notification_colorful_button_notify_effect";
            str3 = "notification_colorful_button_intent_uri";
            str4 = "notification_colorful_button_intent_class";
            str5 = "notification_colorful_button_web_uri";
        }
        return a(context, str, map, str2, str3, str4, str5);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent a(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5) {
        Intent launchIntentForPackage;
        Intent intent;
        StringBuilder sb;
        String message;
        String protocol;
        String str6 = map.get(str2);
        if (TextUtils.isEmpty(str6)) {
            return null;
        }
        if (az.f41762a.equals(str6)) {
            try {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e2.getMessage());
            }
        } else if (az.f41763b.equals(str6)) {
            if (map.containsKey(str3)) {
                String str7 = map.get(str3);
                if (str7 != null) {
                    try {
                        intent = Intent.parseUri(str7, 1);
                        try {
                            intent.setPackage(str);
                        } catch (URISyntaxException e3) {
                            e = e3;
                            sb = new StringBuilder();
                            sb.append("Cause: ");
                            message = e.getMessage();
                            sb.append(message);
                            com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                            launchIntentForPackage = intent;
                            if (launchIntentForPackage != null) {
                            }
                            return null;
                        }
                    } catch (URISyntaxException e4) {
                        e = e4;
                        intent = null;
                    }
                    launchIntentForPackage = intent;
                }
            } else if (map.containsKey(str4)) {
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName(str, map.get(str4)));
                launchIntentForPackage = intent2;
            }
            launchIntentForPackage = null;
        } else {
            if (az.f41764c.equals(str6)) {
                String str8 = map.get(str5);
                if (!TextUtils.isEmpty(str8)) {
                    String trim = str8.trim();
                    if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                        trim = "http://" + trim;
                    }
                    try {
                        protocol = new URL(trim).getProtocol();
                    } catch (MalformedURLException e5) {
                        e = e5;
                        intent = null;
                    }
                    if ("http".equals(protocol) || "https".equals(protocol)) {
                        intent = new Intent("android.intent.action.VIEW");
                        try {
                            intent.setData(Uri.parse(trim));
                            ap.a(context, intent);
                        } catch (MalformedURLException e6) {
                            e = e6;
                            sb = new StringBuilder();
                            sb.append("Cause: ");
                            message = e.getMessage();
                            sb.append(message);
                            com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                            launchIntentForPackage = intent;
                            if (launchIntentForPackage != null) {
                            }
                            return null;
                        }
                        launchIntentForPackage = intent;
                    }
                }
            }
            launchIntentForPackage = null;
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            try {
                if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                    return launchIntentForPackage;
                }
            } catch (Exception e7) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e7.getMessage());
            }
        }
        return null;
    }

    public static Bitmap a(Context context, int i2) {
        return a(context.getResources().getDrawable(i2));
    }

    public static Bitmap a(Context context, String str, boolean z) {
        Future submit = f871a.submit(new a(str, context, z));
        try {
            try {
                Bitmap bitmap = (Bitmap) submit.get(180L, TimeUnit.SECONDS);
                return bitmap == null ? bitmap : bitmap;
            } finally {
                submit.cancel(true);
            }
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            submit.cancel(true);
            return null;
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

    public static RemoteViews a(Context context, ib ibVar, byte[] bArr) {
        hs m436a = ibVar.m436a();
        String a2 = a(ibVar);
        if (m436a != null && m436a.m394a() != null) {
            Map<String, String> m394a = m436a.m394a();
            String str = m394a.get("layout_name");
            String str2 = m394a.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
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
                    } catch (JSONException e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException e3) {
                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                }
            }
        }
        return null;
    }

    public static ai.a a(Context context, String str, int i2, String str2, Notification notification) {
        return new ae(i2, str2, context, str, notification);
    }

    @TargetApi(16)
    public static en a(Context context, ib ibVar, byte[] bArr, String str, int i2) {
        PendingIntent a2;
        String a3 = a(ibVar);
        Map<String, String> m394a = ibVar.m436a().m394a();
        String str2 = m394a.get("notification_style_type");
        en a4 = (!com.xiaomi.push.l.m522a(context) || f869a == null) ? null : f869a.a(context, i2, a3, m394a);
        if (a4 != null) {
            a4.a(m394a);
            return a4;
        } else if (Build.VERSION.SDK_INT >= 16 && "2".equals(str2)) {
            en enVar = new en(context);
            Bitmap a5 = TextUtils.isEmpty(m394a.get("notification_bigPic_uri")) ? null : a(context, m394a.get("notification_bigPic_uri"), false);
            if (a5 == null) {
                com.xiaomi.channel.commonutils.logger.b.m56a("can not get big picture.");
                return enVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(enVar);
            bigPictureStyle.bigPicture(a5);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            enVar.setStyle(bigPictureStyle);
            return enVar;
        } else if (Build.VERSION.SDK_INT >= 16 && "1".equals(str2)) {
            en enVar2 = new en(context);
            enVar2.setStyle(new Notification.BigTextStyle().bigText(str));
            return enVar2;
        } else if ("4".equals(str2) && com.xiaomi.push.l.m522a(context)) {
            em emVar = new em(context, a3);
            if (!TextUtils.isEmpty(m394a.get("notification_banner_image_uri"))) {
                emVar.a(a(context, m394a.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty(m394a.get("notification_banner_icon_uri"))) {
                emVar.b(a(context, m394a.get("notification_banner_icon_uri"), false));
            }
            emVar.a(m394a);
            return emVar;
        } else if ("3".equals(str2) && com.xiaomi.push.l.m522a(context)) {
            eo eoVar = new eo(context, i2, a3);
            if (!TextUtils.isEmpty(m394a.get("notification_colorful_button_text")) && (a2 = a(context, a3, ibVar, bArr, i2, 4)) != null) {
                eoVar.a(m394a.get("notification_colorful_button_text"), a2).a(m394a.get("notification_colorful_button_bg_color"));
            }
            if (!TextUtils.isEmpty(m394a.get("notification_colorful_bg_color"))) {
                eoVar.b(m394a.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty(m394a.get("notification_colorful_bg_image_uri"))) {
                eoVar.a(a(context, m394a.get("notification_colorful_bg_image_uri"), false));
            }
            eoVar.a(m394a);
            return eoVar;
        } else {
            return new en(context);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v20, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x027d  */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v21 */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(Context context, ib ibVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent, int i2) {
        en enVar;
        boolean z;
        Bitmap a2;
        boolean z2;
        String str;
        boolean z3;
        boolean z4;
        long currentTimeMillis;
        boolean z5;
        b bVar;
        int i3;
        String str2;
        String str3;
        int i4;
        Notification notification;
        Object a3;
        Bundle bundle;
        int a4;
        String str4;
        Bitmap a5;
        int i5;
        Bitmap a6;
        StringBuilder sb;
        String a7;
        String a8;
        b bVar2 = new b();
        hs m436a = ibVar.m436a();
        String a9 = a(ibVar);
        Map<String, String> m394a = m436a.m394a();
        String[] a10 = a(context, m436a);
        if (remoteViews != null) {
            enVar = new en(context);
            enVar.setCustomContentView(remoteViews);
        } else {
            enVar = (m394a == null || !m394a.containsKey("notification_style_type")) ? new en(context) : a(context, ibVar, bArr, a10[1], i2);
        }
        en enVar2 = enVar;
        a(enVar2, context, ibVar.b(), ibVar, bArr, i2);
        enVar2.setContentTitle(a10[0]);
        enVar2.setContentText(a10[1]);
        long currentTimeMillis2 = System.currentTimeMillis();
        enVar2.setWhen(currentTimeMillis2);
        String a11 = a(m394a, "notification_show_when");
        if (!TextUtils.isEmpty(a11)) {
            enVar2.setShowWhen(Boolean.parseBoolean(a11));
        } else if (Build.VERSION.SDK_INT >= 24) {
            enVar2.setShowWhen(true);
        }
        enVar2.setContentIntent(pendingIntent);
        int a12 = a(context, a9, "mipush_notification");
        int a13 = a(context, a9, "mipush_small_notification");
        if (a12 > 0 && a13 > 0) {
            enVar2.setLargeIcon(a(context, a12));
            enVar2.setSmallIcon(a13);
        } else if (Build.VERSION.SDK_INT >= 23) {
            enVar2.setSmallIcon(Icon.createWithResource(a9, ap.a(context, a9)));
        } else {
            enVar2.setSmallIcon(b(context, a9));
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (m394a == null) {
                a6 = null;
                i5 = 1;
            } else {
                i5 = 1;
                a6 = a(context, m394a.get("notification_small_icon_uri"), true);
            }
            if (a6 != null) {
                Object[] objArr = new Object[i5];
                objArr[0] = a6;
                Object a14 = com.xiaomi.push.bh.a("android.graphics.drawable.Icon", "createWithBitmap", objArr);
                if (a14 != null) {
                    Object[] objArr2 = new Object[i5];
                    objArr2[0] = a14;
                    com.xiaomi.push.bh.a((Object) enVar2, "setSmallIcon", objArr2);
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("miui.isGrayscaleIcon", i5);
                    enVar2.addExtras(bundle2);
                    a8 = a(m394a, "notification_small_icon_color");
                    if (!TextUtils.isEmpty(a8)) {
                        try {
                            com.xiaomi.push.bh.a((Object) enVar2, "setColor", Integer.valueOf(Color.parseColor(a8)));
                        } catch (Exception e2) {
                            com.xiaomi.channel.commonutils.logger.b.d("fail to set color. " + e2);
                        }
                    }
                } else {
                    sb = new StringBuilder();
                    sb.append("failed te get small icon with url:");
                    a7 = m394a.get("notification_small_icon_uri");
                }
            } else {
                sb = new StringBuilder();
                sb.append("failed to get small icon url:");
                a7 = a(m394a, "notification_small_icon_uri");
            }
            sb.append(a7);
            com.xiaomi.channel.commonutils.logger.b.m56a(sb.toString());
            a8 = a(m394a, "notification_small_icon_color");
            if (!TextUtils.isEmpty(a8)) {
            }
        }
        String a15 = a(m394a, "__dynamic_icon_uri");
        boolean z6 = Boolean.parseBoolean(a(m394a, "__adiom")) || !com.xiaomi.push.l.m521a();
        if (!TextUtils.isEmpty(a15) && z6) {
            if (a15.startsWith("http")) {
                an.b a16 = an.a(context, a15, true);
                if (a16 != null) {
                    a5 = a16.f889a;
                    bVar2.f41717a = a16.f41732a;
                } else {
                    a5 = null;
                }
            } else {
                a5 = an.a(context, a15);
            }
            if (a5 != null) {
                enVar2.setLargeIcon(a5);
                z = true;
                a2 = m394a != null ? null : a(context, m394a.get("notification_large_icon_uri"), true);
                if (a2 != null) {
                    enVar2.setLargeIcon(a2);
                }
                if (m394a != null || Build.VERSION.SDK_INT < 24) {
                    z2 = false;
                    str = null;
                    z3 = false;
                    z4 = true;
                } else {
                    String str5 = m394a.get("notification_group");
                    boolean parseBoolean = Boolean.parseBoolean(m394a.get("notification_is_summary"));
                    boolean parseBoolean2 = Boolean.parseBoolean(m394a.get("notification_group_disable_default"));
                    if (TextUtils.isEmpty(str5) && (com.xiaomi.push.l.m521a() || !parseBoolean2)) {
                        str5 = a(ibVar);
                    }
                    String str6 = str5;
                    com.xiaomi.push.bh.a((Object) enVar2, "setGroupSummary", Boolean.valueOf(parseBoolean));
                    String str7 = m394a.get("notification_style_type");
                    if ("com.xiaomi.xmsf".equals(context.getPackageName()) && ("4".equals(str7) || "3".equals(str7))) {
                        z3 = true;
                        z4 = true;
                        str = a(ibVar) + "_custom_" + currentTimeMillis2;
                        z2 = parseBoolean;
                    } else {
                        z2 = parseBoolean;
                        z3 = false;
                        z4 = true;
                        str = str6;
                    }
                }
                enVar2.setAutoCancel(z4);
                currentTimeMillis = System.currentTimeMillis();
                if (m394a != null && m394a.containsKey(ALaKeepAliveService.KEY_TICKER)) {
                    enVar2.setTicker(m394a.get(ALaKeepAliveService.KEY_TICKER));
                }
                if (currentTimeMillis - f41715a <= 10000) {
                    f41715a = currentTimeMillis;
                    i3 = m436a.f537a;
                    if (m564b(context, a9)) {
                        i3 = a(context, a9);
                    }
                    enVar2.setDefaults(i3);
                    if (m394a != null && (i3 & 1) != 0) {
                        String str8 = m394a.get("sound_uri");
                        if (!TextUtils.isEmpty(str8)) {
                            bVar = bVar2;
                            StringBuilder sb2 = new StringBuilder();
                            z5 = z;
                            sb2.append("android.resource://");
                            sb2.append(a9);
                            if (str8.startsWith(sb2.toString())) {
                                enVar2.setDefaults(i3 ^ 1);
                                enVar2.setSound(Uri.parse(str8));
                            }
                        }
                    }
                    z5 = z;
                    bVar = bVar2;
                } else {
                    z5 = z;
                    bVar = bVar2;
                    i3 = -100;
                }
                if (m394a != null || Build.VERSION.SDK_INT < 26) {
                    str2 = "com.xiaomi.xmsf";
                    str3 = str;
                    if (m394a != null && (i4 = Build.VERSION.SDK_INT) >= 16 && i4 < 26) {
                        com.xiaomi.push.bh.a((Object) enVar2, "setPriority", Integer.valueOf(c(m394a)));
                    }
                } else {
                    ao a17 = ao.a(context, a9);
                    if (a(m394a) > 0) {
                        str2 = "com.xiaomi.xmsf";
                        str3 = str;
                        com.xiaomi.push.bh.a((Object) enVar2, "setTimeoutAfter", Long.valueOf(a4 * 1000));
                    } else {
                        str2 = "com.xiaomi.xmsf";
                        str3 = str;
                    }
                    String str9 = m394a.get("channel_id");
                    if (!TextUtils.isEmpty(str9) || context.getApplicationInfo().targetSdkVersion >= 26) {
                        String m557a = m557a(context, a9, m394a);
                        int b2 = b(m394a);
                        int i6 = m436a.f537a;
                        String str10 = m394a.get("channel_description");
                        String str11 = m394a.get("sound_uri");
                        if (b2 >= 4 && com.xiaomi.push.l.m522a(context) && m566b(m394a)) {
                            int e3 = e(m394a);
                            if (e3 == 0) {
                                com.xiaomi.channel.commonutils.logger.b.d("meet prd of top notification is zero.");
                                str4 = ak.a(a17);
                                if (str4 == null) {
                                    str4 = ak.a(a17, str9, m557a, str10, i6, b2, str11);
                                }
                                com.xiaomi.push.bh.a((Object) enVar2, "setChannelId", str4);
                                if (i3 == -100) {
                                    ap.a(enVar2, z2);
                                }
                            } else {
                                enVar2.setPriority(2);
                                int d2 = d(m394a);
                                Bundle bundle3 = new Bundle();
                                bundle3.putLong("mipush_org_when", currentTimeMillis2);
                                bundle3.putBoolean("mipush_n_top_flag", true);
                                if (d2 > 0 && d2 <= e3) {
                                    bundle3.putInt("mipush_n_top_fre", d2);
                                }
                                if (e3 > 0 && d2 <= e3) {
                                    bundle3.putInt("mipush_n_top_prd", e3);
                                }
                                enVar2.addExtras(bundle3);
                            }
                        }
                        str4 = null;
                        if (str4 == null) {
                        }
                        com.xiaomi.push.bh.a((Object) enVar2, "setChannelId", str4);
                        if (i3 == -100) {
                        }
                    }
                    String str12 = m394a.get("background_color");
                    if (!TextUtils.isEmpty(str12)) {
                        try {
                            int parseInt = Integer.parseInt(str12);
                            enVar2.setOngoing(true);
                            enVar2.setColor(parseInt);
                            com.xiaomi.push.bh.a((Object) enVar2, "setColorized", Boolean.TRUE);
                        } catch (Exception e4) {
                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                        }
                    }
                }
                if (str3 != null) {
                    com.xiaomi.push.bh.a((Object) enVar2, "setGroup", !z3 ? al.a().a(context, enVar2, str3) : str3);
                }
                if (com.xiaomi.push.l.c() && str2.equals(context.getPackageName())) {
                    com.xiaomi.push.bh.a("miui.util.NotificationHelper", "setTargetPkg", context, enVar2, a(ibVar));
                }
                notification = enVar2.getNotification();
                if (z5 && com.xiaomi.push.l.m521a()) {
                    a(notification);
                }
                if (m394a != null && (a3 = com.xiaomi.push.bh.a(notification, "extraNotification")) != null) {
                    bundle = notification.extras;
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    if (!TextUtils.isEmpty(m394a.get("enable_keyguard"))) {
                        com.xiaomi.push.bh.a(a3, "setEnableKeyguard", Boolean.valueOf(Boolean.parseBoolean(m394a.get("enable_keyguard"))));
                        bundle.putBoolean("miui.enableKeyguard", Boolean.parseBoolean(m394a.get("enable_keyguard")));
                    }
                    if (!TextUtils.isEmpty(m394a.get("enable_float"))) {
                        com.xiaomi.push.bh.a(a3, "setEnableFloat", Boolean.valueOf(Boolean.parseBoolean(m394a.get("enable_float"))));
                        bundle.putBoolean("miui.enableFloat", Boolean.parseBoolean(m394a.get("enable_float")));
                    }
                    notification.extras = bundle;
                }
                b bVar3 = bVar;
                bVar3.f874a = notification;
                return bVar3;
            }
        }
        z = false;
        if (m394a != null) {
        }
        if (a2 != null) {
        }
        if (m394a != null) {
        }
        z2 = false;
        str = null;
        z3 = false;
        z4 = true;
        enVar2.setAutoCancel(z4);
        currentTimeMillis = System.currentTimeMillis();
        if (m394a != null) {
            enVar2.setTicker(m394a.get(ALaKeepAliveService.KEY_TICKER));
        }
        if (currentTimeMillis - f41715a <= 10000) {
        }
        if (m394a != null) {
        }
        str2 = "com.xiaomi.xmsf";
        str3 = str;
        if (m394a != null) {
            com.xiaomi.push.bh.a((Object) enVar2, "setPriority", Integer.valueOf(c(m394a)));
        }
        if (str3 != null) {
        }
        if (com.xiaomi.push.l.c()) {
            com.xiaomi.push.bh.a("miui.util.NotificationHelper", "setTargetPkg", context, enVar2, a(ibVar));
        }
        notification = enVar2.getNotification();
        if (z5) {
            a(notification);
        }
        if (m394a != null) {
            bundle = notification.extras;
            if (bundle == null) {
            }
            if (!TextUtils.isEmpty(m394a.get("enable_keyguard"))) {
            }
            if (!TextUtils.isEmpty(m394a.get("enable_float"))) {
            }
            notification.extras = bundle;
        }
        b bVar32 = bVar;
        bVar32.f874a = notification;
        return bVar32;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0321 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x045c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x030f  */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c m556a(Context context, ib ibVar, byte[] bArr) {
        Map<String, String> map;
        int i2;
        Notification notification;
        StringBuilder sb;
        String str;
        Map<String, String> m394a;
        long currentTimeMillis;
        String str2;
        String a2;
        ao a3;
        String str3;
        String str4;
        c cVar = new c();
        g.a a4 = com.xiaomi.push.g.a(context, a(ibVar), true);
        hs m436a = ibVar.m436a();
        if (m436a != null) {
            i2 = m436a.c();
            map = m436a.m394a();
        } else {
            map = null;
            i2 = 0;
        }
        int hashCode = ((a(ibVar).hashCode() / 10) * 10) + i2;
        if (com.xiaomi.push.l.m522a(context) && a4 == g.a.NOT_ALLOWED) {
            if (m436a != null) {
                el.a(context.getApplicationContext()).a(ibVar.b(), b(ibVar), m436a.m393a(), "10:" + a(ibVar));
            }
            str4 = "Do not notify because user block " + a(ibVar) + "‘s notification";
        } else if (com.xiaomi.push.l.m522a(context) && f869a != null && f869a.m568a(context, hashCode, a(ibVar), map)) {
            if (m436a != null) {
                el.a(context.getApplicationContext()).a(ibVar.b(), b(ibVar), m436a.m393a(), "14:" + a(ibVar));
            }
            str4 = "Do not notify because card notification is canceled or sequence incorrect";
        } else {
            RemoteViews a5 = a(context, ibVar, bArr);
            PendingIntent a6 = a(context, ibVar, ibVar.b(), bArr, hashCode);
            if (a6 != null) {
                if (Build.VERSION.SDK_INT >= 11) {
                    b a7 = a(context, ibVar, bArr, a5, a6, hashCode);
                    cVar.f41718a = a7.f41717a;
                    cVar.f875a = a(ibVar);
                    notification = a7.f874a;
                } else {
                    notification = new Notification(b(context, a(ibVar)), null, System.currentTimeMillis());
                    String[] a8 = a(context, m436a);
                    try {
                        notification.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context, a8[0], a8[1], a6);
                    } catch (IllegalAccessException e2) {
                        e = e2;
                        if (m436a != null) {
                            el.a(context.getApplicationContext()).b(ibVar.b(), b(ibVar), m436a.m393a(), "5");
                        }
                        sb = new StringBuilder();
                        str = "meet illegal access error. ";
                        sb.append(str);
                        sb.append(e);
                        com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                        m394a = m436a.m394a();
                        if (m394a != null) {
                            notification.tickerText = m394a.get(ALaKeepAliveService.KEY_TICKER);
                        }
                        currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - f41715a > 10000) {
                        }
                        notification.flags |= 16;
                        if (a5 != null) {
                        }
                        if (com.xiaomi.push.l.m521a()) {
                            if (!TextUtils.isEmpty(m436a.m393a())) {
                            }
                            notification.extras.putString("local_paid", ibVar.m437a());
                            if (m436a.m399b() != null) {
                            }
                            if (!TextUtils.isEmpty(str3)) {
                            }
                            notification.extras.putString("pushUid", a(m436a.f541a, "n_stats_expose"));
                            int i3 = -1;
                            if (!c(ibVar)) {
                            }
                            notification.extras.putString("eventMessageType", String.valueOf(i3));
                            notification.extras.putString("target_package", a(ibVar));
                        }
                        if (m436a.m394a() == null) {
                        }
                        if (com.xiaomi.push.l.m521a()) {
                            try {
                                a(notification, Integer.parseInt(str2));
                            } catch (NumberFormatException e3) {
                                if (m436a != null) {
                                    el.a(context.getApplicationContext()).b(ibVar.b(), b(ibVar), m436a.m393a(), "8");
                                }
                                com.xiaomi.channel.commonutils.logger.b.d("fail to set message count. " + e3);
                            }
                        }
                        if (!com.xiaomi.push.l.c()) {
                            a(notification, a(ibVar));
                        }
                        a2 = a(ibVar);
                        a3 = ao.a(context, a2);
                        if (com.xiaomi.push.l.m522a(context)) {
                            f869a.a(m436a.m394a(), hashCode, notification);
                        }
                        if (com.xiaomi.push.l.m522a(context)) {
                        }
                        a3.a(hashCode, notification);
                        if (com.xiaomi.push.l.m521a()) {
                            al.a().a(context, hashCode, notification);
                            if (Build.VERSION.SDK_INT >= 26) {
                                b(context, a2, hashCode, m436a.m393a(), notification);
                            }
                        }
                        if (m561a(ibVar)) {
                        }
                        if (c(ibVar)) {
                        }
                        if (Build.VERSION.SDK_INT < 26) {
                        }
                        Pair<Integer, ib> pair = new Pair<>(Integer.valueOf(hashCode), ibVar);
                        synchronized (f870a) {
                        }
                    } catch (IllegalArgumentException e4) {
                        e = e4;
                        if (m436a != null) {
                            el.a(context.getApplicationContext()).b(ibVar.b(), b(ibVar), m436a.m393a(), "6");
                        }
                        sb = new StringBuilder();
                        str = "meet illegal argument error. ";
                        sb.append(str);
                        sb.append(e);
                        com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                        m394a = m436a.m394a();
                        if (m394a != null) {
                        }
                        currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - f41715a > 10000) {
                        }
                        notification.flags |= 16;
                        if (a5 != null) {
                        }
                        if (com.xiaomi.push.l.m521a()) {
                        }
                        if (m436a.m394a() == null) {
                        }
                        if (com.xiaomi.push.l.m521a()) {
                        }
                        if (!com.xiaomi.push.l.c()) {
                        }
                        a2 = a(ibVar);
                        a3 = ao.a(context, a2);
                        if (com.xiaomi.push.l.m522a(context)) {
                        }
                        if (com.xiaomi.push.l.m522a(context)) {
                        }
                        a3.a(hashCode, notification);
                        if (com.xiaomi.push.l.m521a()) {
                        }
                        if (m561a(ibVar)) {
                        }
                        if (c(ibVar)) {
                        }
                        if (Build.VERSION.SDK_INT < 26) {
                        }
                        Pair<Integer, ib> pair2 = new Pair<>(Integer.valueOf(hashCode), ibVar);
                        synchronized (f870a) {
                        }
                    } catch (NoSuchMethodException e5) {
                        e = e5;
                        if (m436a != null) {
                            el.a(context.getApplicationContext()).b(ibVar.b(), b(ibVar), m436a.m393a(), "4");
                        }
                        sb = new StringBuilder();
                        str = "meet no such method error. ";
                        sb.append(str);
                        sb.append(e);
                        com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                        m394a = m436a.m394a();
                        if (m394a != null) {
                        }
                        currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - f41715a > 10000) {
                        }
                        notification.flags |= 16;
                        if (a5 != null) {
                        }
                        if (com.xiaomi.push.l.m521a()) {
                        }
                        if (m436a.m394a() == null) {
                        }
                        if (com.xiaomi.push.l.m521a()) {
                        }
                        if (!com.xiaomi.push.l.c()) {
                        }
                        a2 = a(ibVar);
                        a3 = ao.a(context, a2);
                        if (com.xiaomi.push.l.m522a(context)) {
                        }
                        if (com.xiaomi.push.l.m522a(context)) {
                        }
                        a3.a(hashCode, notification);
                        if (com.xiaomi.push.l.m521a()) {
                        }
                        if (m561a(ibVar)) {
                        }
                        if (c(ibVar)) {
                        }
                        if (Build.VERSION.SDK_INT < 26) {
                        }
                        Pair<Integer, ib> pair22 = new Pair<>(Integer.valueOf(hashCode), ibVar);
                        synchronized (f870a) {
                        }
                    } catch (InvocationTargetException e6) {
                        e = e6;
                        if (m436a != null) {
                            el.a(context.getApplicationContext()).b(ibVar.b(), b(ibVar), m436a.m393a(), "7");
                        }
                        sb = new StringBuilder();
                        str = "meet invocation target error. ";
                        sb.append(str);
                        sb.append(e);
                        com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                        m394a = m436a.m394a();
                        if (m394a != null) {
                        }
                        currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - f41715a > 10000) {
                        }
                        notification.flags |= 16;
                        if (a5 != null) {
                        }
                        if (com.xiaomi.push.l.m521a()) {
                        }
                        if (m436a.m394a() == null) {
                        }
                        if (com.xiaomi.push.l.m521a()) {
                        }
                        if (!com.xiaomi.push.l.c()) {
                        }
                        a2 = a(ibVar);
                        a3 = ao.a(context, a2);
                        if (com.xiaomi.push.l.m522a(context)) {
                        }
                        if (com.xiaomi.push.l.m522a(context)) {
                        }
                        a3.a(hashCode, notification);
                        if (com.xiaomi.push.l.m521a()) {
                        }
                        if (m561a(ibVar)) {
                        }
                        if (c(ibVar)) {
                        }
                        if (Build.VERSION.SDK_INT < 26) {
                        }
                        Pair<Integer, ib> pair222 = new Pair<>(Integer.valueOf(hashCode), ibVar);
                        synchronized (f870a) {
                        }
                    }
                    m394a = m436a.m394a();
                    if (m394a != null && m394a.containsKey(ALaKeepAliveService.KEY_TICKER)) {
                        notification.tickerText = m394a.get(ALaKeepAliveService.KEY_TICKER);
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - f41715a > 10000) {
                        f41715a = currentTimeMillis;
                        int i4 = m436a.f537a;
                        if (m564b(context, a(ibVar))) {
                            i4 = a(context, a(ibVar));
                        }
                        notification.defaults = i4;
                        if (m394a != null && (i4 & 1) != 0) {
                            String str5 = m394a.get("sound_uri");
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.startsWith("android.resource://" + a(ibVar))) {
                                    notification.defaults = 1 ^ i4;
                                    notification.sound = Uri.parse(str5);
                                }
                            }
                        }
                    }
                    notification.flags |= 16;
                    if (a5 != null) {
                        notification.contentView = a5;
                    }
                }
                if (com.xiaomi.push.l.m521a() && Build.VERSION.SDK_INT >= 19) {
                    if (!TextUtils.isEmpty(m436a.m393a())) {
                        notification.extras.putString("message_id", m436a.m393a());
                    }
                    notification.extras.putString("local_paid", ibVar.m437a());
                    str3 = m436a.m399b() != null ? null : m436a.m399b().get("score_info");
                    if (!TextUtils.isEmpty(str3)) {
                        notification.extras.putString("score_info", str3);
                    }
                    notification.extras.putString("pushUid", a(m436a.f541a, "n_stats_expose"));
                    int i32 = -1;
                    if (!c(ibVar)) {
                        i32 = 1000;
                    } else if (m561a(ibVar)) {
                        i32 = 3000;
                    }
                    notification.extras.putString("eventMessageType", String.valueOf(i32));
                    notification.extras.putString("target_package", a(ibVar));
                }
                str2 = m436a.m394a() == null ? null : m436a.m394a().get("message_count");
                if (com.xiaomi.push.l.m521a() && str2 != null) {
                    a(notification, Integer.parseInt(str2));
                }
                if (!com.xiaomi.push.l.c() && com.xiaomi.push.l.m522a(context)) {
                    a(notification, a(ibVar));
                }
                a2 = a(ibVar);
                a3 = ao.a(context, a2);
                if (com.xiaomi.push.l.m522a(context) && f869a != null) {
                    f869a.a(m436a.m394a(), hashCode, notification);
                }
                if (com.xiaomi.push.l.m522a(context) || f869a == null || !f869a.m569a(m436a.m394a(), hashCode, notification)) {
                    a3.a(hashCode, notification);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("consume this notificaiton by agent");
                }
                if (com.xiaomi.push.l.m521a() && com.xiaomi.push.l.m522a(context)) {
                    al.a().a(context, hashCode, notification);
                    if (Build.VERSION.SDK_INT >= 26 && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
                        b(context, a2, hashCode, m436a.m393a(), notification);
                    }
                }
                if (m561a(ibVar)) {
                    el.a(context.getApplicationContext()).a(ibVar.b(), b(ibVar), m436a.m393a(), 3002, null);
                }
                if (c(ibVar)) {
                    el.a(context.getApplicationContext()).a(ibVar.b(), b(ibVar), m436a.m393a(), 1002, null);
                }
                if (Build.VERSION.SDK_INT < 26) {
                    String m393a = m436a != null ? m436a.m393a() : null;
                    com.xiaomi.push.ai a9 = com.xiaomi.push.ai.a(context);
                    int a10 = a(m436a.m394a());
                    if (a10 > 0 && !TextUtils.isEmpty(m393a)) {
                        String str6 = "n_timeout_" + m393a;
                        a9.m129a(str6);
                        a9.b(new ad(str6, a3, hashCode), a10);
                    }
                }
                Pair<Integer, ib> pair2222 = new Pair<>(Integer.valueOf(hashCode), ibVar);
                synchronized (f870a) {
                    f870a.add(pair2222);
                    if (f870a.size() > 100) {
                        f870a.remove();
                    }
                }
                return cVar;
            }
            if (m436a != null) {
                el.a(context.getApplicationContext()).a(ibVar.b(), b(ibVar), m436a.m393a(), "11");
            }
            str4 = "The click PendingIntent is null. ";
        }
        com.xiaomi.channel.commonutils.logger.b.m56a(str4);
        return cVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m557a(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? com.xiaomi.push.g.m327b(context, str) : map.get("channel_name");
    }

    public static String a(ib ibVar) {
        hs m436a;
        if ("com.xiaomi.xmsf".equals(ibVar.f635b) && (m436a = ibVar.m436a()) != null && m436a.m394a() != null) {
            String str = m436a.m394a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return ibVar.f635b;
    }

    public static String a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public static void a(Notification notification, int i2) {
        Object a2 = com.xiaomi.push.bh.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.push.bh.a(a2, "setMessageCount", Integer.valueOf(i2));
        }
    }

    public static void a(Context context, Intent intent, ib ibVar, hs hsVar) {
        if (ibVar == null || hsVar == null) {
            return;
        }
        String a2 = a(hsVar.m394a(), "notify_effect");
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (az.f41762a.equals(a2) || az.f41763b.equals(a2) || az.f41764c.equals(a2)) {
            intent.putExtra("local_paid", ibVar.f631a);
            if (!TextUtils.isEmpty(ibVar.f635b)) {
                intent.putExtra("target_package", ibVar.f635b);
            }
            intent.putExtra("job_key", a(hsVar.m394a(), "jobkey"));
            intent.putExtra("target_component", a(context, ibVar.f635b, hsVar.m394a()));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m558a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i2) {
        ao a2 = ao.a(context, str);
        int hashCode = ((str.hashCode() / 10) * 10) + i2;
        LinkedList linkedList = new LinkedList();
        if (i2 >= 0) {
            a2.a(hashCode);
        }
        synchronized (f870a) {
            Iterator<Pair<Integer, ib>> it = f870a.iterator();
            while (it.hasNext()) {
                Pair<Integer, ib> next = it.next();
                ib ibVar = (ib) next.second;
                if (ibVar != null) {
                    String a3 = a(ibVar);
                    if (i2 >= 0) {
                        if (hashCode == ((Integer) next.first).intValue() && TextUtils.equals(a3, str)) {
                            linkedList.add(next);
                        }
                    } else if (i2 == -1 && TextUtils.equals(a3, str)) {
                        a2.a(((Integer) next.first).intValue());
                        linkedList.add(next);
                    }
                }
            }
            if (f870a != null) {
                f870a.removeAll(linkedList);
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        synchronized (f870a) {
            Iterator<Pair<Integer, ib>> it = f870a.iterator();
            while (it.hasNext()) {
                Pair<Integer, ib> next = it.next();
                ib ibVar = (ib) next.second;
                if (ibVar != null) {
                    String a2 = a(ibVar);
                    hs m436a = ibVar.m436a();
                    if (m436a != null && TextUtils.equals(a2, str)) {
                        String m401c = m436a.m401c();
                        String d2 = m436a.d();
                        if (!TextUtils.isEmpty(m401c) && !TextUtils.isEmpty(d2) && a(str2, m401c) && a(str3, d2)) {
                            ao.a(context, str).a(((Integer) next.first).intValue());
                            linkedList.add(next);
                        }
                    }
                }
            }
            if (f870a != null) {
                f870a.removeAll(linkedList);
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        bm.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    public static void a(Intent intent) {
        try {
            Method declaredMethod = intent.getClass().getDeclaredMethod("addMiuiFlags", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(intent, 2);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.b("insert flags error " + e2);
        }
    }

    @TargetApi(16)
    public static void a(en enVar, Context context, String str, ib ibVar, byte[] bArr, int i2) {
        PendingIntent a2;
        PendingIntent a3;
        PendingIntent a4;
        Map<String, String> m394a = ibVar.m436a().m394a();
        if (TextUtils.equals("3", m394a.get("notification_style_type")) || TextUtils.equals("4", m394a.get("notification_style_type"))) {
            return;
        }
        if (!TextUtils.isEmpty(m394a.get("notification_style_button_left_name")) && (a4 = a(context, str, ibVar, bArr, i2, 1)) != null) {
            enVar.addAction(0, m394a.get("notification_style_button_left_name"), a4);
        }
        if (!TextUtils.isEmpty(m394a.get("notification_style_button_mid_name")) && (a3 = a(context, str, ibVar, bArr, i2, 2)) != null) {
            enVar.addAction(0, m394a.get("notification_style_button_mid_name"), a3);
        }
        if (TextUtils.isEmpty(m394a.get("notification_style_button_right_name")) || (a2 = a(context, str, ibVar, bArr, i2, 3)) == null) {
            return;
        }
        enVar.addAction(0, m394a.get("notification_style_button_right_name"), a2);
    }

    public static boolean a(Context context, ib ibVar, String str) {
        if (ibVar != null && ibVar.m436a() != null && ibVar.m436a().m394a() != null && !TextUtils.isEmpty(str)) {
            return Boolean.parseBoolean(ibVar.m436a().m394a().get("use_clicked_activity")) && g.a(context, a(str));
        }
        com.xiaomi.channel.commonutils.logger.b.m56a("should clicked activity params are null.");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m560a(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean a(hs hsVar) {
        if (hsVar != null) {
            String m393a = hsVar.m393a();
            return !TextUtils.isEmpty(m393a) && m393a.length() == 22 && "satuigmo".indexOf(m393a.charAt(0)) >= 0;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m561a(ib ibVar) {
        hs m436a = ibVar.m436a();
        return a(m436a) && m436a.l();
    }

    public static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m562a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004e, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0070, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0072, code lost:
        r1 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] a(Context context, hs hsVar) {
        String str;
        String m401c = hsVar.m401c();
        String d2 = hsVar.d();
        Map<String, String> m394a = hsVar.m394a();
        if (m394a != null) {
            int intValue = Float.valueOf((context.getResources().getDisplayMetrics().widthPixels / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (intValue <= 320) {
                String str2 = m394a.get("title_short");
                if (!TextUtils.isEmpty(str2)) {
                    m401c = str2;
                }
                str = m394a.get("description_short");
            } else if (intValue > 360) {
                String str3 = m394a.get("title_long");
                if (!TextUtils.isEmpty(str3)) {
                    m401c = str3;
                }
                str = m394a.get("description_long");
            }
        }
        return new String[]{m401c, d2};
    }

    public static int b(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return (a2 != 0 || Build.VERSION.SDK_INT < 9) ? a2 : context.getApplicationInfo().logo;
    }

    public static int b(Map<String, String> map) {
        if (map != null) {
            String str = map.get("channel_importance");
            if (TextUtils.isEmpty(str)) {
                return 3;
            }
            try {
                com.xiaomi.channel.commonutils.logger.b.c("importance=" + str);
                return Integer.parseInt(str);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("parsing channel importance error: " + e2);
                return 3;
            }
        }
        return 3;
    }

    public static String b(int i2, String str) {
        return "n_top_update_" + i2 + "_" + str;
    }

    public static String b(ib ibVar) {
        return m561a(ibVar) ? "E100002" : c(ibVar) ? "E100000" : m565b(ibVar) ? "E100001" : d(ibVar) ? "E100003" : "";
    }

    /* renamed from: b  reason: collision with other method in class */
    public static void m563b(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static void b(Context context, String str, int i2) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i2).commit();
    }

    @TargetApi(19)
    public static void b(Context context, String str, int i2, String str2, Notification notification) {
        boolean z;
        Notification notification2 = notification;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || ao.a(context, str) == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        ao a2 = ao.a(context, str);
        if (notification2 == null) {
            List<StatusBarNotification> m583b = a2.m583b();
            if (m583b == null) {
                return;
            }
            Iterator<StatusBarNotification> it = m583b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    notification2 = null;
                    break;
                }
                StatusBarNotification next = it.next();
                Notification notification3 = next.getNotification();
                String string = notification3.extras.getString("message_id");
                if (i2 == next.getId() && str2.equals(string)) {
                    notification2 = notification3;
                    break;
                }
            }
            z = false;
        } else if (!str2.equals(notification2.extras.getString("message_id"))) {
            return;
        } else {
            z = true;
        }
        if (notification2 != null) {
            if (notification2.getGroupAlertBehavior() != 1) {
                com.xiaomi.push.bh.a((Object) notification2, "mGroupAlertBehavior", (Object) 1);
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = notification2.extras.getLong("mipush_org_when", 0L);
            int i3 = notification2.extras.getInt("mipush_n_top_fre", 0);
            int i4 = notification2.extras.getInt("mipush_n_top_prd", 0);
            if (i4 <= 0 || i4 < i3) {
                return;
            }
            long j2 = (i4 * 1000) + j;
            if (j >= currentTimeMillis || currentTimeMillis >= j2) {
                i4 = 0;
            } else if (i3 > 0 && (i4 = (int) Math.min((j2 - currentTimeMillis) / 1000, i3)) > 0 && !z) {
                notification2.when = currentTimeMillis;
                com.xiaomi.channel.commonutils.logger.b.m56a("update top notification: " + str2);
                a2.a(i2, notification2);
            }
            if (i4 > 0) {
                com.xiaomi.channel.commonutils.logger.b.m56a("schedule top notification next update delay: " + i4);
                com.xiaomi.push.ai.a(context).m129a(b(i2, str2));
                com.xiaomi.push.ai.a(context).b(a(context, str, i2, str2, (Notification) null), i4);
                return;
            }
            String a3 = ak.a(a2);
            Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, notification2);
            recoverBuilder.setChannelId(a3);
            recoverBuilder.setPriority(0);
            com.xiaomi.channel.commonutils.logger.b.m56a("update top notification to common: " + str2);
            a2.a(i2, recoverBuilder.build());
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m564b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m565b(ib ibVar) {
        hs m436a = ibVar.m436a();
        return a(m436a) && m436a.f543b == 1 && !m561a(ibVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m566b(Map<String, String> map) {
        if (map != null) {
            String str = map.get("notification_top_repeat");
            if (!TextUtils.isEmpty(str)) {
                boolean parseBoolean = Boolean.parseBoolean(str);
                com.xiaomi.channel.commonutils.logger.b.c("top notification' repeat is " + parseBoolean);
                return parseBoolean;
            }
        }
        return true;
    }

    public static int c(Map<String, String> map) {
        if (map != null) {
            String str = map.get("notification_priority");
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                com.xiaomi.channel.commonutils.logger.b.c("priority=" + str);
                return Integer.parseInt(str);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("parsing notification priority error: " + e2);
                return 0;
            }
        }
        return 0;
    }

    public static boolean c(ib ibVar) {
        hs m436a = ibVar.m436a();
        return a(m436a) && m436a.f543b == 0 && !m561a(ibVar);
    }

    public static int d(Map<String, String> map) {
        int i2;
        if (map != null) {
            String str = map.get("notification_top_frequency");
            if (!TextUtils.isEmpty(str)) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.c("fre of top notification is " + str);
                    i2 = Integer.parseInt(str);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("parsing top notification frequency error: " + e2);
                }
                return Math.max(0, i2);
            }
        }
        i2 = 0;
        return Math.max(0, i2);
    }

    public static boolean d(ib ibVar) {
        return ibVar.a() == hf.Registration;
    }

    public static int e(Map<String, String> map) {
        int i2;
        if (map != null) {
            String str = map.get("notification_top_period");
            if (!TextUtils.isEmpty(str)) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.c("prd of top notification is " + str);
                    i2 = Integer.parseInt(str);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("parsing top notification period error: " + e2);
                }
                return Math.max(0, i2);
            }
        }
        i2 = 0;
        return Math.max(0, i2);
    }

    public static boolean e(ib ibVar) {
        return m561a(ibVar) || c(ibVar) || m565b(ibVar);
    }
}
