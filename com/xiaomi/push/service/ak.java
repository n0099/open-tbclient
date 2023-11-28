package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
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
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import com.xiaomi.push.ep;
import com.xiaomi.push.eq;
import com.xiaomi.push.g;
import com.xiaomi.push.hh;
import com.xiaomi.push.hu;
import com.xiaomi.push.id;
import com.xiaomi.push.service.aw;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ak {
    public static long a;

    /* renamed from: a  reason: collision with other field name */
    public static volatile as f885a;

    /* renamed from: a  reason: collision with other field name */
    public static final LinkedList<Pair<Integer, id>> f886a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    public static ExecutorService f887a = Executors.newCachedThreadPool();

    /* loaded from: classes10.dex */
    public static class a implements Callable<Bitmap> {
        public Context a;

        /* renamed from: a  reason: collision with other field name */
        public String f888a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f889a;

        public a(String str, Context context, boolean z) {
            this.a = context;
            this.f888a = str;
            this.f889a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Bitmap call() {
            Bitmap bitmap = null;
            if (TextUtils.isEmpty(this.f888a)) {
                com.xiaomi.channel.commonutils.logger.b.m190a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            }
            if (this.f888a.startsWith("http")) {
                aw.b a = aw.a(this.a, this.f888a, this.f889a);
                if (a != null) {
                    return a.f909a;
                }
            } else {
                bitmap = aw.a(this.a, this.f888a);
                if (bitmap != null) {
                    return bitmap;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m190a("Failed get online picture/icon resource");
            return bitmap;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public long a = 0;

        /* renamed from: a  reason: collision with other field name */
        public Notification f890a;
    }

    /* loaded from: classes10.dex */
    public static class c {

        /* renamed from: a  reason: collision with other field name */
        public String f891a;
        public long a = 0;

        /* renamed from: a  reason: collision with other field name */
        public boolean f892a = false;
    }

    public static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    public static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, ResourceManager.DRAWABLE, str);
        }
        return 0;
    }

    public static int a(Context context, String str, Map<String, String> map, int i) {
        ComponentName a2;
        Intent b2 = b(context, str, map, i);
        if (b2 == null || (a2 = l.a(context, b2)) == null) {
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
        Object a2 = com.xiaomi.push.bj.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.push.bj.a(a2, "setCustomizedIcon", Boolean.TRUE);
        }
        return notification;
    }

    public static PendingIntent a(Context context, id idVar, String str, byte[] bArr, int i) {
        return a(context, idVar, str, bArr, i, 0, a(context, idVar, str));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PendingIntent a(Context context, id idVar, String str, byte[] bArr, int i, int i2, boolean z) {
        Intent intent;
        String protocol;
        int i3 = c(idVar) ? 1000 : m775a(idVar) ? 3000 : -1;
        hu m634a = idVar.m634a();
        String m594a = m634a != null ? m634a.m594a() : "";
        boolean m775a = m775a(idVar);
        if (m634a == null || TextUtils.isEmpty(m634a.f548e)) {
            if (m775a) {
                intent = new Intent();
                intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            } else {
                intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent.setComponent(new ComponentName(str, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            }
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i));
            intent.addCategory(String.valueOf(m594a));
            intent.putExtra("notification_click_button", i2);
            intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m594a);
            intent.putExtra("eventMessageType", i3);
            if (m775a || !z) {
                a(context, intent, idVar, m634a, m594a, i2);
                return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getService(context, 0, intent, 167772160) : PendingIntent.getService(context, 0, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
            }
            Intent intent2 = new Intent();
            intent2.setComponent(a(str));
            intent2.addFlags(276824064);
            intent2.putExtra("mipush_serviceIntent", intent);
            intent2.addCategory(String.valueOf(i));
            intent2.addCategory(String.valueOf(m594a));
            intent2.addCategory(String.valueOf(i2));
            a(context, intent2, idVar, m634a, m594a, i2);
            a(intent2);
            return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getActivity(context, 0, intent2, 167772160) : PendingIntent.getActivity(context, 0, intent2, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
        }
        Intent intent3 = new Intent(IntentConstants.ACTION_BOX_BROWSER);
        intent3.setData(Uri.parse(m634a.f548e));
        try {
            protocol = new URL(m634a.f548e).getProtocol();
        } catch (MalformedURLException unused) {
            com.xiaomi.channel.commonutils.logger.b.m190a("meet URL exception : " + m634a.f548e);
            intent3.setPackage(str);
        }
        if (!"http".equals(protocol) && !"https".equals(protocol)) {
            intent3.setPackage(str);
            intent3.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent3.putExtra(MiPushMessage.KEY_MESSAGE_ID, m594a);
            intent3.putExtra("eventMessageType", i3);
            return Build.VERSION.SDK_INT < 31 ? PendingIntent.getActivity(context, 0, intent3, 167772160) : PendingIntent.getActivity(context, 0, intent3, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
        }
        ay.a(context, str, intent3);
        intent3.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent3.putExtra(MiPushMessage.KEY_MESSAGE_ID, m594a);
        intent3.putExtra("eventMessageType", i3);
        if (Build.VERSION.SDK_INT < 31) {
        }
    }

    public static PendingIntent a(Context context, String str, id idVar, byte[] bArr, int i, int i2) {
        Map<String, String> m595a = idVar.m634a().m595a();
        if (m595a == null) {
            return null;
        }
        boolean a2 = a(context, idVar, str);
        if (a2) {
            return a(context, idVar, str, bArr, i, i2, a2);
        }
        Intent m770a = m770a(context, str, m595a, i2);
        if (m770a != null) {
            return PendingIntent.getActivity(context, 0, m770a, Build.VERSION.SDK_INT >= 31 ? 167772160 : SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
        }
        return null;
    }

    public static ComponentName a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Intent m770a(Context context, String str, Map<String, String> map, int i) {
        if (m780b(map)) {
            return a(context, str, map, String.format("cust_btn_%s_ne", Integer.valueOf(i)), String.format("cust_btn_%s_iu", Integer.valueOf(i)), String.format("cust_btn_%s_ic", Integer.valueOf(i)), String.format("cust_btn_%s_wu", Integer.valueOf(i)));
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return a(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
                }
                return a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
            }
            return a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
        }
        return a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent a(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5) {
        Intent launchIntentForPackage;
        Intent intent;
        Intent intent2;
        String str6 = map.get(str2);
        if (TextUtils.isEmpty(str6)) {
            return null;
        }
        if (bk.a.equals(str6)) {
            try {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
            }
        } else {
            if (bk.b.equals(str6)) {
                if (map.containsKey(str3)) {
                    String str7 = map.get(str3);
                    if (str7 != null) {
                        try {
                            intent2 = Intent.parseUri(str7, 1);
                        } catch (URISyntaxException e2) {
                            e = e2;
                            intent2 = null;
                        }
                        try {
                            intent2.setPackage(str);
                        } catch (URISyntaxException e3) {
                            e = e3;
                            com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                            launchIntentForPackage = intent2;
                            if (launchIntentForPackage != null) {
                            }
                            return null;
                        }
                        launchIntentForPackage = intent2;
                    }
                } else if (map.containsKey(str4)) {
                    intent = new Intent();
                    intent.setComponent(new ComponentName(str, map.get(str4)));
                }
                launchIntentForPackage = null;
            } else {
                if (bk.c.equals(str6)) {
                    String str8 = map.get(str5);
                    if (!TextUtils.isEmpty(str8)) {
                        String trim = str8.trim();
                        if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                            trim = "http://" + trim;
                        }
                        try {
                            String protocol = new URL(trim).getProtocol();
                            if ("http".equals(protocol) || "https".equals(protocol)) {
                                intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
                                try {
                                    intent.setData(Uri.parse(trim));
                                    ay.a(context, str, intent);
                                } catch (MalformedURLException e4) {
                                    e = e4;
                                    com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                                    launchIntentForPackage = intent;
                                    if (launchIntentForPackage != null) {
                                    }
                                    return null;
                                }
                            }
                        } catch (MalformedURLException e5) {
                            e = e5;
                            intent = null;
                        }
                    }
                }
                launchIntentForPackage = null;
            }
            launchIntentForPackage = intent;
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            try {
                if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                    return launchIntentForPackage;
                }
                if (Build.VERSION.SDK_INT >= 30 && !com.xiaomi.push.j.m721a(context) && bk.c.equals(str6)) {
                    return launchIntentForPackage;
                }
                com.xiaomi.channel.commonutils.logger.b.m190a("not resolve activity:" + launchIntentForPackage + "for buttons");
            } catch (Exception e6) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e6.getMessage());
            }
        }
        return null;
    }

    public static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    public static Bitmap a(Context context, String str, boolean z) {
        Future submit = f887a.submit(new a(str, context, z));
        try {
            try {
                Bitmap bitmap = (Bitmap) submit.get(180L, TimeUnit.SECONDS);
                return bitmap == null ? bitmap : bitmap;
            } finally {
                submit.cancel(true);
            }
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
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

    public static RemoteViews a(Context context, id idVar, byte[] bArr) {
        hu m634a = idVar.m634a();
        String a2 = a(idVar);
        if (m634a != null && m634a.m595a() != null) {
            Map<String, String> m595a = m634a.m595a();
            String str = m595a.get("layout_name");
            String str2 = m595a.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a2);
                    int identifier = resourcesForApplication.getIdentifier(str, TtmlNode.TAG_LAYOUT, a2);
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
                                int identifier4 = resourcesForApplication.getIdentifier(string2, ResourceManager.DRAWABLE, a2);
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
                }
            }
        }
        return null;
    }

    @TargetApi(16)
    public static ep a(Context context, id idVar, byte[] bArr, String str, int i) {
        PendingIntent a2;
        String a3 = a(idVar);
        Map<String, String> m595a = idVar.m634a().m595a();
        String str2 = m595a.get("notification_style_type");
        ep a4 = (!com.xiaomi.push.j.m721a(context) || f885a == null) ? null : f885a.a(context, i, a3, m595a);
        if (a4 != null) {
            a4.a(m595a);
            return a4;
        } else if ("2".equals(str2)) {
            ep epVar = new ep(context);
            Bitmap a5 = TextUtils.isEmpty(m595a.get("notification_bigPic_uri")) ? null : a(context, m595a.get("notification_bigPic_uri"), false);
            if (a5 == null) {
                com.xiaomi.channel.commonutils.logger.b.m190a("can not get big picture.");
                return epVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(epVar);
            bigPictureStyle.bigPicture(a5);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            epVar.setStyle(bigPictureStyle);
            return epVar;
        } else if ("1".equals(str2)) {
            ep epVar2 = new ep(context);
            epVar2.setStyle(new Notification.BigTextStyle().bigText(str));
            return epVar2;
        } else if ("4".equals(str2) && com.xiaomi.push.j.m720a()) {
            eo eoVar = new eo(context, a3);
            if (!TextUtils.isEmpty(m595a.get("notification_banner_image_uri"))) {
                eoVar.a(a(context, m595a.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty(m595a.get("notification_banner_icon_uri"))) {
                eoVar.b(a(context, m595a.get("notification_banner_icon_uri"), false));
            }
            eoVar.a(m595a);
            return eoVar;
        } else if ("3".equals(str2) && com.xiaomi.push.j.m720a()) {
            eq eqVar = new eq(context, i, a3);
            if (!TextUtils.isEmpty(m595a.get("notification_colorful_button_text")) && (a2 = a(context, a3, idVar, bArr, i, 4)) != null) {
                eqVar.a(m595a.get("notification_colorful_button_text"), a2).mo467a(m595a.get("notification_colorful_button_bg_color"));
            }
            if (!TextUtils.isEmpty(m595a.get("notification_colorful_bg_color"))) {
                eqVar.b(m595a.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty(m595a.get("notification_colorful_bg_image_uri"))) {
                eqVar.a(a(context, m595a.get("notification_colorful_bg_image_uri"), false));
            }
            eqVar.a(m595a);
            return eqVar;
        } else {
            return new ep(context);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v20, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0275  */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v21 */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(Context context, id idVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent, int i) {
        ep epVar;
        boolean z;
        Bitmap a2;
        boolean z2;
        String str;
        boolean z3;
        boolean z4;
        long currentTimeMillis;
        boolean z5;
        b bVar;
        int i2;
        String str2;
        Notification notification;
        int a3;
        boolean z6;
        int i3;
        Bitmap a4;
        int i4;
        Bitmap a5;
        StringBuilder sb;
        String a6;
        b bVar2 = new b();
        hu m634a = idVar.m634a();
        String a7 = a(idVar);
        Map<String, String> m595a = m634a.m595a();
        String[] a8 = a(context, m634a);
        if (remoteViews != null) {
            epVar = new ep(context);
            epVar.setCustomContentView(remoteViews);
        } else {
            epVar = (m595a == null || !m595a.containsKey("notification_style_type")) ? new ep(context) : a(context, idVar, bArr, a8[1], i);
        }
        ep epVar2 = epVar;
        a(epVar2, context, idVar.b(), idVar, bArr, i);
        epVar2.setContentTitle(a8[0]);
        epVar2.setContentText(a8[1]);
        long currentTimeMillis2 = System.currentTimeMillis();
        epVar2.setWhen(currentTimeMillis2);
        String a9 = a(m595a, "notification_show_when");
        if (!TextUtils.isEmpty(a9)) {
            epVar2.setShowWhen(Boolean.parseBoolean(a9));
        } else if (Build.VERSION.SDK_INT >= 24) {
            epVar2.setShowWhen(true);
        }
        epVar2.setContentIntent(pendingIntent);
        a(context, a7, epVar2, m595a);
        if (Build.VERSION.SDK_INT >= 23) {
            if (m595a == null) {
                a5 = null;
                i4 = 1;
            } else {
                i4 = 1;
                a5 = a(context, m595a.get("notification_small_icon_uri"), true);
            }
            if (a5 != null) {
                Object[] objArr = new Object[i4];
                objArr[0] = a5;
                Object a10 = com.xiaomi.push.bj.a("android.graphics.drawable.Icon", "createWithBitmap", objArr);
                if (a10 != null) {
                    Object[] objArr2 = new Object[i4];
                    objArr2[0] = a10;
                    com.xiaomi.push.bj.a((Object) epVar2, "setSmallIcon", objArr2);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("miui.isGrayscaleIcon", i4);
                    epVar2.addExtras(bundle);
                    epVar2.mo467a(a(m595a, "notification_small_icon_color"));
                } else {
                    sb = new StringBuilder();
                    sb.append("failed te get small icon with url:");
                    a6 = m595a.get("notification_small_icon_uri");
                }
            } else {
                sb = new StringBuilder();
                sb.append("failed to get small icon url:");
                a6 = a(m595a, "notification_small_icon_uri");
            }
            sb.append(a6);
            com.xiaomi.channel.commonutils.logger.b.m190a(sb.toString());
            epVar2.mo467a(a(m595a, "notification_small_icon_color"));
        }
        String a11 = a(m595a, "__dynamic_icon_uri");
        boolean z7 = Boolean.parseBoolean(a(m595a, "__adiom")) || !com.xiaomi.push.j.m720a();
        if (!TextUtils.isEmpty(a11) && z7) {
            if (a11.startsWith("http")) {
                aw.b a12 = aw.a(context, a11, true);
                if (a12 != null) {
                    a4 = a12.f909a;
                    bVar2.a = a12.a;
                } else {
                    a4 = null;
                }
            } else {
                a4 = aw.a(context, a11);
            }
            if (a4 != null) {
                epVar2.setLargeIcon(a4);
                z = true;
                a2 = m595a != null ? null : a(context, m595a.get("notification_large_icon_uri"), true);
                if (a2 != null) {
                    epVar2.setLargeIcon(a2);
                }
                if (m595a != null || Build.VERSION.SDK_INT < 24) {
                    z2 = false;
                    str = null;
                    z3 = false;
                    z4 = true;
                } else {
                    String str3 = m595a.get("notification_group");
                    boolean parseBoolean = Boolean.parseBoolean(m595a.get("notification_is_summary"));
                    boolean parseBoolean2 = Boolean.parseBoolean(m595a.get("notification_group_disable_default"));
                    if (TextUtils.isEmpty(str3) && (com.xiaomi.push.j.m720a() || !parseBoolean2)) {
                        str3 = a(idVar);
                    }
                    String str4 = str3;
                    com.xiaomi.push.bj.a((Object) epVar2, "setGroupSummary", Boolean.valueOf(parseBoolean));
                    String str5 = m595a.get("notification_style_type");
                    if ("com.xiaomi.xmsf".equals(context.getPackageName()) && ("4".equals(str5) || "3".equals(str5))) {
                        z3 = true;
                        z4 = true;
                        str = a(idVar) + "_custom_" + currentTimeMillis2;
                        z2 = parseBoolean;
                    } else {
                        z2 = parseBoolean;
                        z3 = false;
                        z4 = true;
                        str = str4;
                    }
                }
                epVar2.setAutoCancel(z4);
                currentTimeMillis = System.currentTimeMillis();
                if (m595a != null && m595a.containsKey("ticker")) {
                    epVar2.setTicker(m595a.get("ticker"));
                }
                if (currentTimeMillis - a <= 10000) {
                    a = currentTimeMillis;
                    i2 = m634a.f535a;
                    if (m778b(context, a7)) {
                        i2 = a(context, a7);
                    }
                    epVar2.setDefaults(i2);
                    if (m595a != null && (i2 & 1) != 0) {
                        String str6 = m595a.get("sound_uri");
                        if (!TextUtils.isEmpty(str6)) {
                            bVar = bVar2;
                            StringBuilder sb2 = new StringBuilder();
                            z5 = z;
                            sb2.append("android.resource://");
                            sb2.append(a7);
                            if (str6.startsWith(sb2.toString())) {
                                epVar2.setDefaults(i2 ^ 1);
                                epVar2.setSound(Uri.parse(str6));
                            }
                        }
                    }
                    z5 = z;
                    bVar = bVar2;
                } else {
                    z5 = z;
                    bVar = bVar2;
                    i2 = -100;
                }
                if (m595a != null || Build.VERSION.SDK_INT < 26) {
                    str2 = "com.xiaomi.xmsf";
                    if (m595a != null && Build.VERSION.SDK_INT < 26) {
                        com.xiaomi.push.bj.a((Object) epVar2, "setPriority", Integer.valueOf(c(m595a)));
                    }
                } else {
                    ax a13 = ax.a(context, a7);
                    if (a(m595a) > 0) {
                        str2 = "com.xiaomi.xmsf";
                        z6 = z2;
                        i3 = i2;
                        com.xiaomi.push.bj.a((Object) epVar2, "setTimeoutAfter", Long.valueOf(a3 * 1000));
                    } else {
                        z6 = z2;
                        i3 = i2;
                        str2 = "com.xiaomi.xmsf";
                    }
                    at.a(m634a);
                    String str7 = m595a.get("channel_id");
                    if (!TextUtils.isEmpty(str7) || context.getApplicationInfo().targetSdkVersion >= 26) {
                        String a14 = a(context, a7, m595a);
                        int b2 = b(m595a);
                        int i5 = m634a.f535a;
                        cc.a(context, m595a, epVar2, currentTimeMillis2);
                        com.xiaomi.push.bj.a((Object) epVar2, "setChannelId", at.a(a13, str7, a14, m595a.get("channel_description"), i5, b2, m595a.get("sound_uri"), m595a.get("channel_perm")));
                        if (i3 == -100 && ay.a(m595a)) {
                            ay.a(epVar2, z6);
                        }
                        if ("pulldown".equals(ay.a((Object) m595a)) && ay.a(m595a) && Objects.equals(m595a.get("pull_down_pop_type"), "0")) {
                            ay.a(epVar2, z6);
                        }
                        if ("tts".equals(ay.a((Object) m595a)) && ay.a(m595a)) {
                            ay.a(epVar2, z6);
                        }
                    }
                    String str8 = m595a.get("background_color");
                    if (!TextUtils.isEmpty(str8)) {
                        try {
                            int parseInt = Integer.parseInt(str8);
                            epVar2.setOngoing(true);
                            epVar2.setColor(parseInt);
                            com.xiaomi.push.bj.a((Object) epVar2, "setColorized", Boolean.TRUE);
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                        }
                    }
                }
                if (str != null) {
                    if (!z3) {
                        str = au.a().a(context, epVar2, str);
                    }
                    com.xiaomi.push.bj.a((Object) epVar2, "setGroup", str);
                }
                if (com.xiaomi.push.j.m725c() && str2.equals(context.getPackageName())) {
                    com.xiaomi.push.bj.a("miui.util.NotificationHelper", "setTargetPkg", context, epVar2, a(idVar));
                }
                notification = epVar2.getNotification();
                if (z5 && com.xiaomi.push.j.m720a()) {
                    a(notification);
                }
                if (m595a != null) {
                    if (notification.extras == null) {
                        notification.extras = new Bundle();
                    }
                    if (!TextUtils.isEmpty(m595a.get("enable_keyguard"))) {
                        ay.b(notification, Boolean.parseBoolean(m595a.get("enable_keyguard")));
                    }
                    if (!TextUtils.isEmpty(m595a.get("enable_float"))) {
                        ay.a(notification, Boolean.parseBoolean(m595a.get("enable_float")));
                    }
                    if (!TextUtils.isEmpty(m595a.get("float_small_win")) && "0".equals(m595a.get("float_small_win")) && com.xiaomi.push.g.e(context, a7)) {
                        ay.a(notification, false);
                    }
                    int a15 = com.xiaomi.push.t.a(m595a.get("section_is_prr"), -1);
                    int a16 = com.xiaomi.push.t.a(m595a.get("section_prr_cl"), -1);
                    if (a15 >= 0 && a16 >= 0) {
                        ay.a(notification, a15, a16);
                    }
                }
                b bVar3 = bVar;
                bVar3.f890a = notification;
                return bVar3;
            }
        }
        z = false;
        if (m595a != null) {
        }
        if (a2 != null) {
        }
        if (m595a != null) {
        }
        z2 = false;
        str = null;
        z3 = false;
        z4 = true;
        epVar2.setAutoCancel(z4);
        currentTimeMillis = System.currentTimeMillis();
        if (m595a != null) {
            epVar2.setTicker(m595a.get("ticker"));
        }
        if (currentTimeMillis - a <= 10000) {
        }
        if (m595a != null) {
        }
        str2 = "com.xiaomi.xmsf";
        if (m595a != null) {
            com.xiaomi.push.bj.a((Object) epVar2, "setPriority", Integer.valueOf(c(m595a)));
        }
        if (str != null) {
        }
        if (com.xiaomi.push.j.m725c()) {
            com.xiaomi.push.bj.a("miui.util.NotificationHelper", "setTargetPkg", context, epVar2, a(idVar));
        }
        notification = epVar2.getNotification();
        if (z5) {
            a(notification);
        }
        if (m595a != null) {
        }
        b bVar32 = bVar;
        bVar32.f890a = notification;
        return bVar32;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static c m771a(Context context, id idVar, byte[] bArr) {
        int i;
        Map<String, String> map;
        String str;
        c cVar = new c();
        g.b a2 = com.xiaomi.push.g.a(context, a(idVar), true);
        hu m634a = idVar.m634a();
        if (m634a != null) {
            i = m634a.c();
            map = m634a.m595a();
        } else {
            i = 0;
            map = null;
        }
        int b2 = com.xiaomi.push.t.b(a(idVar), i);
        if (com.xiaomi.push.j.m721a(context) && a2 == g.b.NOT_ALLOWED) {
            if (m634a != null) {
                en.a(context.getApplicationContext()).a(idVar.b(), b(idVar), m634a.m594a(), "10:" + a(idVar));
            }
            str = "Do not notify because user block " + a(idVar) + "‘s notification";
        } else if (com.xiaomi.push.j.m721a(context) && f885a != null && f885a.m782a(context, b2, a(idVar), map)) {
            if (m634a != null) {
                en.a(context.getApplicationContext()).a(idVar.b(), b(idVar), m634a.m594a(), "14:" + a(idVar));
            }
            str = "Do not notify because card notification is canceled or sequence incorrect";
        } else {
            RemoteViews a3 = a(context, idVar, bArr);
            PendingIntent a4 = a(context, idVar, idVar.b(), bArr, b2);
            if (a4 != null) {
                b a5 = a(context, idVar, bArr, a3, a4, b2);
                cVar.a = a5.a;
                cVar.f891a = a(idVar);
                Notification notification = a5.f890a;
                if (com.xiaomi.push.j.m720a()) {
                    if (!TextUtils.isEmpty(m634a.m594a())) {
                        notification.extras.putString(ForbidActivityConfig.CHAT_MSG_ID, m634a.m594a());
                    }
                    notification.extras.putString("local_paid", idVar.m635a());
                    ay.a(map, notification.extras, "msg_busi_type");
                    ay.a(map, notification.extras, "disable_notification_flags");
                    String str2 = m634a.m600b() == null ? null : m634a.m600b().get("score_info");
                    if (!TextUtils.isEmpty(str2)) {
                        notification.extras.putString("score_info", str2);
                    }
                    notification.extras.putString("pushUid", a(m634a.f539a, "n_stats_expose"));
                    int i2 = -1;
                    if (c(idVar)) {
                        i2 = 1000;
                    } else if (m775a(idVar)) {
                        i2 = 3000;
                    }
                    notification.extras.putString("eventMessageType", String.valueOf(i2));
                    notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, a(idVar));
                }
                String str3 = m634a.m595a() == null ? null : m634a.m595a().get("message_count");
                if (com.xiaomi.push.j.m720a() && str3 != null) {
                    try {
                        ay.a(notification, Integer.parseInt(str3));
                    } catch (NumberFormatException e) {
                        if (m634a != null) {
                            en.a(context.getApplicationContext()).b(idVar.b(), b(idVar), m634a.m594a(), "8");
                        }
                        com.xiaomi.channel.commonutils.logger.b.d("fail to set message count. " + e);
                    }
                }
                String a6 = a(idVar);
                ay.m798a(notification, a6);
                ax a7 = ax.a(context, a6);
                if (com.xiaomi.push.j.m721a(context) && f885a != null) {
                    f885a.a(idVar, m634a.m595a(), b2, notification);
                }
                if (com.xiaomi.push.j.m721a(context) && f885a != null && f885a.a(m634a.m595a(), b2, notification)) {
                    com.xiaomi.channel.commonutils.logger.b.b("consume this notificaiton by agent");
                } else {
                    a7.a(b2, notification);
                    cVar.f892a = true;
                    com.xiaomi.channel.commonutils.logger.b.m190a("notification: " + m634a.m594a() + " is notifyied");
                }
                if (com.xiaomi.push.j.m720a() && com.xiaomi.push.j.m721a(context)) {
                    au.a().a(context, b2, notification);
                    cc.m822a(context, a6, b2, m634a.m594a(), notification);
                }
                if (m775a(idVar)) {
                    en.a(context.getApplicationContext()).a(idVar.b(), b(idVar), m634a.m594a(), 3002, null);
                }
                if (c(idVar)) {
                    en.a(context.getApplicationContext()).a(idVar.b(), b(idVar), m634a.m594a(), 1002, null);
                }
                if (Build.VERSION.SDK_INT < 26) {
                    String m594a = m634a != null ? m634a.m594a() : null;
                    com.xiaomi.push.aj a8 = com.xiaomi.push.aj.a(context);
                    int a9 = a(m634a.m595a());
                    if (a9 > 0 && !TextUtils.isEmpty(m594a)) {
                        String str4 = "n_timeout_" + m594a;
                        a8.m270a(str4);
                        a8.b(new al(str4, a7, b2), a9);
                    }
                }
                Pair<Integer, id> pair = new Pair<>(Integer.valueOf(b2), idVar);
                synchronized (f886a) {
                    f886a.add(pair);
                    if (f886a.size() > 100) {
                        f886a.remove();
                    }
                }
                return cVar;
            }
            if (m634a != null) {
                en.a(context.getApplicationContext()).a(idVar.b(), b(idVar), m634a.m594a(), "11");
            }
            str = "The click PendingIntent is null. ";
        }
        com.xiaomi.channel.commonutils.logger.b.m190a(str);
        return cVar;
    }

    public static String a(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? com.xiaomi.push.g.m529b(context, str) : map.get("channel_name");
    }

    public static String a(id idVar) {
        hu m634a;
        if ("com.xiaomi.xmsf".equals(idVar.f634b) && (m634a = idVar.m634a()) != null && m634a.m595a() != null) {
            String str = m634a.m595a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return idVar.f634b;
    }

    public static String a(Map<String, String> map, int i) {
        String format = i == 0 ? "notify_effect" : m780b(map) ? String.format("cust_btn_%s_ne", Integer.valueOf(i)) : i == 1 ? "notification_style_button_left_notify_effect" : i == 2 ? "notification_style_button_mid_notify_effect" : i == 3 ? "notification_style_button_right_notify_effect" : i == 4 ? "notification_colorful_button_notify_effect" : null;
        if (map == null || format == null) {
            return null;
        }
        return map.get(format);
    }

    public static String a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public static void a(Context context, Intent intent, id idVar, hu huVar, String str, int i) {
        if (idVar == null || huVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = a(huVar.m595a(), i);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (bk.a.equals(a2) || bk.b.equals(a2) || bk.c.equals(a2)) {
            intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
            intent.putExtra("local_paid", idVar.f630a);
            if (!TextUtils.isEmpty(idVar.f634b)) {
                intent.putExtra(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, idVar.f634b);
            }
            intent.putExtra("job_key", a(huVar.m595a(), "jobkey"));
            intent.putExtra(i + "_target_component", a(context, idVar.f634b, huVar.m595a(), i));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m772a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i) {
        a(context, str, i, -1);
    }

    public static void a(Context context, String str, int i, int i2) {
        int hashCode;
        if (context == null || TextUtils.isEmpty(str) || i < -1) {
            return;
        }
        ax a2 = ax.a(context, str);
        List<StatusBarNotification> m797b = a2.m797b();
        if (com.xiaomi.push.t.a(m797b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        if (i == -1) {
            hashCode = 0;
            z = true;
        } else {
            hashCode = ((str.hashCode() / 10) * 10) + i;
        }
        Iterator<StatusBarNotification> it = m797b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StatusBarNotification next = it.next();
            if (!TextUtils.isEmpty(String.valueOf(next.getId()))) {
                int id = next.getId();
                if (z) {
                    linkedList.add(next);
                    a2.a(id);
                } else if (hashCode == id) {
                    d.a(context, next, i2);
                    linkedList.add(next);
                    a2.a(id);
                    break;
                }
            }
        }
        a(context, linkedList);
    }

    public static void a(Context context, String str, ep epVar, Map<String, String> map) {
        int a2 = a(context, str, "mipush_small_notification");
        int a3 = a(context, str, "mipush_notification");
        if (!com.xiaomi.push.j.m721a(context)) {
            if (a2 > 0) {
                epVar.setSmallIcon(a2);
            } else {
                b(context, str, epVar, map);
            }
            if (a3 <= 0) {
                return;
            }
        } else if (a2 <= 0 || a3 <= 0) {
            b(context, str, epVar, map);
            return;
        } else {
            epVar.setSmallIcon(a2);
        }
        epVar.setLargeIcon(a(context, a3));
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        ax a2 = ax.a(context, str);
        List<StatusBarNotification> m797b = a2.m797b();
        if (com.xiaomi.push.t.a(m797b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (StatusBarNotification statusBarNotification : m797b) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                int id = statusBarNotification.getId();
                String a3 = ay.a(notification);
                String b2 = ay.b(notification);
                if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(b2) && a(a3, str2) && a(b2, str3)) {
                    linkedList.add(statusBarNotification);
                    a2.a(id);
                }
            }
        }
        a(context, linkedList);
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        bz.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    public static void a(Intent intent) {
        try {
            Method declaredMethod = intent.getClass().getDeclaredMethod("addMiuiFlags", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(intent, 2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.b("insert flags error " + e);
        }
    }

    @TargetApi(16)
    public static void a(ep epVar, Context context, String str, id idVar, byte[] bArr, int i) {
        PendingIntent a2;
        PendingIntent a3;
        PendingIntent a4;
        PendingIntent a5;
        Map<String, String> m595a = idVar.m634a().m595a();
        if (TextUtils.equals("3", m595a.get("notification_style_type")) || TextUtils.equals("4", m595a.get("notification_style_type"))) {
            return;
        }
        if (m780b(m595a)) {
            for (int i2 = 1; i2 <= 3; i2++) {
                String str2 = m595a.get(String.format("cust_btn_%s_n", Integer.valueOf(i2)));
                if (!TextUtils.isEmpty(str2) && (a5 = a(context, str, idVar, bArr, i, i2)) != null) {
                    epVar.addAction(0, str2, a5);
                }
            }
            return;
        }
        if (!TextUtils.isEmpty(m595a.get("notification_style_button_left_name")) && (a4 = a(context, str, idVar, bArr, i, 1)) != null) {
            epVar.addAction(0, m595a.get("notification_style_button_left_name"), a4);
        }
        if (!TextUtils.isEmpty(m595a.get("notification_style_button_mid_name")) && (a3 = a(context, str, idVar, bArr, i, 2)) != null) {
            epVar.addAction(0, m595a.get("notification_style_button_mid_name"), a3);
        }
        if (TextUtils.isEmpty(m595a.get("notification_style_button_right_name")) || (a2 = a(context, str, idVar, bArr, i, 3)) == null) {
            return;
        }
        epVar.addAction(0, m595a.get("notification_style_button_right_name"), a2);
    }

    public static boolean a(Context context, id idVar, String str) {
        if (idVar != null && idVar.m634a() != null && idVar.m634a().m595a() != null && !TextUtils.isEmpty(str)) {
            return Boolean.parseBoolean(idVar.m634a().m595a().get("use_clicked_activity")) && l.a(context, a(str));
        }
        com.xiaomi.channel.commonutils.logger.b.m190a("should clicked activity params are null.");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m773a(Context context, String str) {
        return com.xiaomi.push.g.m530b(context, str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m774a(Context context, String str, boolean z) {
        return com.xiaomi.push.j.m720a() && !z && m773a(context, str);
    }

    public static boolean a(hu huVar) {
        if (huVar != null) {
            String m594a = huVar.m594a();
            return !TextUtils.isEmpty(m594a) && m594a.length() == 22 && "satuigmo".indexOf(m594a.charAt(0)) >= 0;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m775a(id idVar) {
        hu m634a = idVar.m634a();
        return a(m634a) && m634a.l();
    }

    public static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m776a(Map<String, String> map) {
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
    public static String[] a(Context context, hu huVar) {
        String str;
        String m602c = huVar.m602c();
        String d = huVar.d();
        Map<String, String> m595a = huVar.m595a();
        if (m595a != null) {
            int intValue = Float.valueOf((context.getResources().getDisplayMetrics().widthPixels / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (intValue <= 320) {
                String str2 = m595a.get("title_short");
                if (!TextUtils.isEmpty(str2)) {
                    m602c = str2;
                }
                str = m595a.get("description_short");
            } else if (intValue > 360) {
                String str3 = m595a.get("title_long");
                if (!TextUtils.isEmpty(str3)) {
                    m602c = str3;
                }
                str = m595a.get("description_long");
            }
        }
        return new String[]{m602c, d};
    }

    public static int b(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return a2 == 0 ? context.getApplicationInfo().logo : a2;
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
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("parsing channel importance error: " + e);
                return 3;
            }
        }
        return 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent b(Context context, String str, Map<String, String> map, int i) {
        Intent launchIntentForPackage;
        String str2;
        Intent intent;
        Intent intent2;
        if (map == null) {
            return null;
        }
        if (i != 0) {
            return m770a(context, str, map, i);
        }
        if (map.containsKey("notify_effect")) {
            String str3 = map.get("notify_effect");
            int i2 = -1;
            String str4 = map.get("intent_flag");
            try {
                if (!TextUtils.isEmpty(str4)) {
                    i2 = Integer.parseInt(str4);
                }
            } catch (NumberFormatException e) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause by intent_flag: " + e.getMessage());
            }
            if (bk.a.equals(str3)) {
                try {
                    launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e2.getMessage());
                }
            } else {
                if (bk.b.equals(str3)) {
                    if (map.containsKey("intent_uri")) {
                        String str5 = map.get("intent_uri");
                        if (str5 != null) {
                            try {
                                intent2 = Intent.parseUri(str5, 1);
                            } catch (URISyntaxException e3) {
                                e = e3;
                                intent2 = null;
                            }
                            try {
                                intent2.setPackage(str);
                            } catch (URISyntaxException e4) {
                                e = e4;
                                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                                launchIntentForPackage = intent2;
                                if (launchIntentForPackage != null) {
                                }
                                return null;
                            }
                            launchIntentForPackage = intent2;
                        }
                    } else if (map.containsKey(ForumSquareActivityConfig.FORUM_CLASS_NAME)) {
                        intent = new Intent();
                        intent.setComponent(new ComponentName(str, map.get(ForumSquareActivityConfig.FORUM_CLASS_NAME)));
                    }
                    launchIntentForPackage = null;
                } else {
                    if (bk.c.equals(str3) && (str2 = map.get("web_uri")) != null) {
                        String trim = str2.trim();
                        if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                            trim = "http://" + trim;
                        }
                        try {
                            String protocol = new URL(trim).getProtocol();
                            if ("http".equals(protocol) || "https".equals(protocol)) {
                                intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
                                try {
                                    intent.setData(Uri.parse(trim));
                                    ay.a(context, str, intent);
                                } catch (MalformedURLException e5) {
                                    e = e5;
                                    com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                                    launchIntentForPackage = intent;
                                    if (launchIntentForPackage != null) {
                                    }
                                    return null;
                                }
                            }
                        } catch (MalformedURLException e6) {
                            e = e6;
                            intent = null;
                        }
                    }
                    launchIntentForPackage = null;
                }
                launchIntentForPackage = intent;
            }
            if (launchIntentForPackage != null) {
                if (i2 >= 0) {
                    launchIntentForPackage.setFlags(i2);
                }
                b(launchIntentForPackage);
                launchIntentForPackage.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                try {
                    if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                        return launchIntentForPackage;
                    }
                    if (Build.VERSION.SDK_INT >= 30 && !com.xiaomi.push.j.m721a(context) && bk.c.equals(str3)) {
                        return launchIntentForPackage;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m190a("not resolve activity:" + launchIntentForPackage);
                } catch (Exception e7) {
                    com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e7.getMessage());
                }
            }
            return null;
        }
        return null;
    }

    public static String b(id idVar) {
        return m775a(idVar) ? "E100002" : c(idVar) ? "E100000" : m779b(idVar) ? "E100001" : d(idVar) ? "E100003" : "";
    }

    /* renamed from: b  reason: collision with other method in class */
    public static void m777b(Context context, String str) {
        if (!com.xiaomi.push.j.m721a(context) || f885a == null || TextUtils.isEmpty(str)) {
            return;
        }
        f885a.a(str);
    }

    public static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Context context, String str, ep epVar, Map<String, String> map) {
        boolean z;
        int a2;
        if (!com.xiaomi.push.j.m721a(context)) {
            String a3 = a(map, "fcm_icon_uri");
            String a4 = a(map, "fcm_icon_color");
            if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(a4) && (a2 = a(context, str, a3)) > 0) {
                z = true;
                epVar.setSmallIcon(a2);
                epVar.mo467a(a4);
                if (z) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        epVar.setSmallIcon(Icon.createWithResource(str, ay.a(context, str)));
                        return;
                    } else {
                        epVar.setSmallIcon(b(context, str));
                        return;
                    }
                }
                return;
            }
        }
        z = false;
        if (z) {
        }
    }

    public static void b(Intent intent) {
        if (intent == null) {
            return;
        }
        int flags = intent.getFlags() & (-2) & (-3) & (-65);
        if (Build.VERSION.SDK_INT >= 21) {
            flags &= -129;
        }
        intent.setFlags(flags);
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m778b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m779b(id idVar) {
        hu m634a = idVar.m634a();
        return a(m634a) && m634a.f541b == 1 && !m775a(idVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m780b(Map<String, String> map) {
        if (map == null) {
            com.xiaomi.channel.commonutils.logger.b.m190a("meta extra is null");
            return false;
        }
        return "6".equals(map.get("notification_style_type"));
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
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("parsing notification priority error: " + e);
                return 0;
            }
        }
        return 0;
    }

    public static void c(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static boolean c(id idVar) {
        hu m634a = idVar.m634a();
        return a(m634a) && m634a.f541b == 0 && !m775a(idVar);
    }

    public static boolean d(id idVar) {
        return idVar.a() == hh.Registration;
    }

    public static boolean e(id idVar) {
        return m775a(idVar) || c(idVar) || m779b(idVar);
    }
}
