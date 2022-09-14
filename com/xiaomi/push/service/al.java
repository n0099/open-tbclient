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
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tieba.ala.ALaKeepAliveService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.push.Cif;
import com.xiaomi.push.eo;
import com.xiaomi.push.ep;
import com.xiaomi.push.eq;
import com.xiaomi.push.er;
import com.xiaomi.push.h;
import com.xiaomi.push.hj;
import com.xiaomi.push.hw;
import com.xiaomi.push.service.aw;
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
/* loaded from: classes8.dex */
public class al {
    public static /* synthetic */ Interceptable $ic;
    public static long a;

    /* renamed from: a  reason: collision with other field name */
    public static volatile as f890a;

    /* renamed from: a  reason: collision with other field name */
    public static final LinkedList<Pair<Integer, Cif>> f891a;

    /* renamed from: a  reason: collision with other field name */
    public static ExecutorService f892a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Callable<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: a  reason: collision with other field name */
        public String f893a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f894a;

        public a(String str, Context context, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, context, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f893a = str;
            this.f894a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Bitmap call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Bitmap bitmap = null;
                if (TextUtils.isEmpty(this.f893a)) {
                    com.xiaomi.channel.commonutils.logger.b.m90a("Failed get online picture/icon resource cause picUrl is empty");
                    return null;
                }
                if (this.f893a.startsWith("http")) {
                    aw.b a = aw.a(this.a, this.f893a, this.f894a);
                    if (a != null) {
                        return a.f912a;
                    }
                } else {
                    bitmap = aw.a(this.a, this.f893a);
                    if (bitmap != null) {
                        return bitmap;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.m90a("Failed get online picture/icon resource");
                return bitmap;
            }
            return (Bitmap) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: a  reason: collision with other field name */
        public Notification f895a;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0L;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: a  reason: collision with other field name */
        public String f896a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f897a;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0L;
            this.f897a = false;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071162395, "Lcom/xiaomi/push/service/al;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071162395, "Lcom/xiaomi/push/service/al;");
                return;
            }
        }
        f891a = new LinkedList<>();
        f892a = Executors.newCachedThreadPool();
    }

    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) ? context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE) : invokeLL.intValue;
    }

    public static int a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) == null) {
            if (str.equals(context.getPackageName())) {
                return context.getResources().getIdentifier(str2, ResourceManager.DRAWABLE, str);
            }
            return 0;
        }
        return invokeLLL.intValue;
    }

    public static int a(Context context, String str, Map<String, String> map, int i) {
        InterceptResult invokeLLLI;
        ComponentName a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65539, null, context, str, map, i)) == null) {
            Intent b2 = b(context, str, map, i);
            if (b2 == null || (a2 = l.a(context, b2)) == null) {
                return 0;
            }
            return a2.hashCode();
        }
        return invokeLLLI.intValue;
    }

    public static int a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, map)) == null) {
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
        return invokeL.intValue;
    }

    public static Notification a(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, notification)) == null) {
            Object a2 = com.xiaomi.push.bk.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.bk.a(a2, "setCustomizedIcon", Boolean.TRUE);
            }
            return notification;
        }
        return (Notification) invokeL.objValue;
    }

    public static PendingIntent a(Context context, Cif cif, String str, byte[] bArr, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, cif, str, bArr, Integer.valueOf(i)})) == null) ? a(context, cif, str, bArr, i, 0, a(context, cif, str)) : (PendingIntent) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PendingIntent a(Context context, Cif cif, String str, byte[] bArr, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Intent intent;
        String protocol;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, cif, str, bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) != null) {
            return (PendingIntent) invokeCommon.objValue;
        }
        int i3 = c(cif) ? 1000 : m610a(cif) ? 3000 : -1;
        hw m466a = cif.m466a();
        String m432a = m466a != null ? m466a.m432a() : "";
        boolean m610a = m610a(cif);
        if (m466a == null || TextUtils.isEmpty(m466a.f550e)) {
            if (m610a) {
                intent = new Intent();
                intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            } else {
                intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent.setComponent(new ComponentName(str, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            }
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i));
            intent.addCategory(String.valueOf(m432a));
            intent.putExtra("notification_click_button", i2);
            intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m432a);
            intent.putExtra("eventMessageType", i3);
            if (m610a || !z) {
                a(context, intent, cif, m466a, m432a, i2);
                return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getService(context, 0, intent, 167772160) : PendingIntent.getService(context, 0, intent, 134217728);
            }
            Intent intent2 = new Intent();
            intent2.setComponent(a(str));
            intent2.addFlags(276824064);
            intent2.putExtra("mipush_serviceIntent", intent);
            intent2.addCategory(String.valueOf(i));
            intent2.addCategory(String.valueOf(m432a));
            intent2.addCategory(String.valueOf(i2));
            a(context, intent2, cif, m466a, m432a, i2);
            a(intent2);
            return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getActivity(context, 0, intent2, 167772160) : PendingIntent.getActivity(context, 0, intent2, 134217728);
        }
        Intent intent3 = new Intent("android.intent.action.VIEW");
        intent3.setData(Uri.parse(m466a.f550e));
        try {
            protocol = new URL(m466a.f550e).getProtocol();
        } catch (MalformedURLException unused) {
            com.xiaomi.channel.commonutils.logger.b.m90a("meet URL exception : " + m466a.f550e);
            intent3.setPackage(str);
        }
        if (!"http".equals(protocol) && !"https".equals(protocol)) {
            intent3.setPackage(str);
            intent3.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent3.putExtra(MiPushMessage.KEY_MESSAGE_ID, m432a);
            intent3.putExtra("eventMessageType", i3);
            return Build.VERSION.SDK_INT < 31 ? PendingIntent.getActivity(context, 0, intent3, 167772160) : PendingIntent.getActivity(context, 0, intent3, 134217728);
        }
        ay.a(context, str, intent3);
        intent3.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent3.putExtra(MiPushMessage.KEY_MESSAGE_ID, m432a);
        intent3.putExtra("eventMessageType", i3);
        if (Build.VERSION.SDK_INT < 31) {
        }
    }

    public static PendingIntent a(Context context, String str, Cif cif, byte[] bArr, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, str, cif, bArr, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            Map<String, String> m433a = cif.m466a().m433a();
            if (m433a == null) {
                return null;
            }
            boolean a2 = a(context, cif, str);
            if (a2) {
                return a(context, cif, str, bArr, i, i2, a2);
            }
            Intent m605a = m605a(context, str, m433a, i2);
            if (m605a != null) {
                return PendingIntent.getActivity(context, 0, m605a, Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728);
            }
            return null;
        }
        return (PendingIntent) invokeCommon.objValue;
    }

    public static ComponentName a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity") : (ComponentName) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Intent m605a(Context context, String str, Map<String, String> map, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65546, null, context, str, map, i)) == null) {
            if (m615b(map)) {
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
        return (Intent) invokeLLLI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent a(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Intent launchIntentForPackage;
        Intent intent;
        Intent intent2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{context, str, map, str2, str3, str4, str5})) == null) {
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
                                    intent = new Intent("android.intent.action.VIEW");
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
                    if (Build.VERSION.SDK_INT >= 30 && !com.xiaomi.push.m.m562a(context) && bk.c.equals(str6)) {
                        return launchIntentForPackage;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m90a("not resolve activity:" + launchIntentForPackage + "for buttons");
                } catch (Exception e6) {
                    com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e6.getMessage());
                }
            }
            return null;
        }
        return (Intent) invokeCommon.objValue;
    }

    public static Bitmap a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, context, i)) == null) ? a(context.getResources().getDrawable(i)) : (Bitmap) invokeLI.objValue;
    }

    public static Bitmap a(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65549, null, context, str, z)) == null) {
            Future submit = f892a.submit(new a(str, context, z));
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
        return (Bitmap) invokeLLZ.objValue;
    }

    public static Bitmap a(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, drawable)) == null) {
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
        return (Bitmap) invokeL.objValue;
    }

    public static RemoteViews a(Context context, Cif cif, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, context, cif, bArr)) == null) {
            hw m466a = cif.m466a();
            String a2 = a(cif);
            if (m466a != null && m466a.m433a() != null) {
                Map<String, String> m433a = m466a.m433a();
                String str = m433a.get("layout_name");
                String str2 = m433a.get("layout_value");
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
        return (RemoteViews) invokeLLL.objValue;
    }

    @TargetApi(16)
    public static eq a(Context context, Cif cif, byte[] bArr, String str, int i) {
        InterceptResult invokeCommon;
        PendingIntent a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{context, cif, bArr, str, Integer.valueOf(i)})) == null) {
            String a3 = a(cif);
            Map<String, String> m433a = cif.m466a().m433a();
            String str2 = m433a.get("notification_style_type");
            eq a4 = (!com.xiaomi.push.m.m562a(context) || f890a == null) ? null : f890a.a(context, i, a3, m433a);
            if (a4 != null) {
                a4.a(m433a);
                return a4;
            } else if ("2".equals(str2)) {
                eq eqVar = new eq(context);
                Bitmap a5 = TextUtils.isEmpty(m433a.get("notification_bigPic_uri")) ? null : a(context, m433a.get("notification_bigPic_uri"), false);
                if (a5 == null) {
                    com.xiaomi.channel.commonutils.logger.b.m90a("can not get big picture.");
                    return eqVar;
                }
                Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(eqVar);
                bigPictureStyle.bigPicture(a5);
                bigPictureStyle.setSummaryText(str);
                bigPictureStyle.bigLargeIcon((Bitmap) null);
                eqVar.setStyle(bigPictureStyle);
                return eqVar;
            } else if ("1".equals(str2)) {
                eq eqVar2 = new eq(context);
                eqVar2.setStyle(new Notification.BigTextStyle().bigText(str));
                return eqVar2;
            } else if ("4".equals(str2) && com.xiaomi.push.m.m561a()) {
                ep epVar = new ep(context, a3);
                if (!TextUtils.isEmpty(m433a.get("notification_banner_image_uri"))) {
                    epVar.a(a(context, m433a.get("notification_banner_image_uri"), false));
                }
                if (!TextUtils.isEmpty(m433a.get("notification_banner_icon_uri"))) {
                    epVar.b(a(context, m433a.get("notification_banner_icon_uri"), false));
                }
                epVar.a(m433a);
                return epVar;
            } else if ("3".equals(str2) && com.xiaomi.push.m.m561a()) {
                er erVar = new er(context, i, a3);
                if (!TextUtils.isEmpty(m433a.get("notification_colorful_button_text")) && (a2 = a(context, a3, cif, bArr, i, 4)) != null) {
                    erVar.a(m433a.get("notification_colorful_button_text"), a2).a(m433a.get("notification_colorful_button_bg_color"));
                }
                if (!TextUtils.isEmpty(m433a.get("notification_colorful_bg_color"))) {
                    erVar.b(m433a.get("notification_colorful_bg_color"));
                } else if (!TextUtils.isEmpty(m433a.get("notification_colorful_bg_image_uri"))) {
                    erVar.a(a(context, m433a.get("notification_colorful_bg_image_uri"), false));
                }
                erVar.a(m433a);
                return erVar;
            } else {
                return new eq(context);
            }
        }
        return (eq) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v22, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c6  */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v23 */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(Context context, Cif cif, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent, int i) {
        InterceptResult invokeCommon;
        eq eqVar;
        boolean z;
        int a2;
        boolean z2;
        Bitmap a3;
        boolean z3;
        String str;
        boolean z4;
        boolean z5;
        long currentTimeMillis;
        boolean z6;
        b bVar;
        int i2;
        String str2;
        Notification notification;
        int a4;
        boolean z7;
        int i3;
        Bitmap a5;
        int i4;
        Bitmap a6;
        StringBuilder sb;
        String a7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{context, cif, bArr, remoteViews, pendingIntent, Integer.valueOf(i)})) == null) {
            b bVar2 = new b();
            hw m466a = cif.m466a();
            String a8 = a(cif);
            Map<String, String> m433a = m466a.m433a();
            String[] a9 = a(context, m466a);
            if (remoteViews != null) {
                eqVar = new eq(context);
                eqVar.setCustomContentView(remoteViews);
            } else {
                eqVar = (m433a == null || !m433a.containsKey("notification_style_type")) ? new eq(context) : a(context, cif, bArr, a9[1], i);
            }
            eq eqVar2 = eqVar;
            a(eqVar2, context, cif.b(), cif, bArr, i);
            eqVar2.setContentTitle(a9[0]);
            eqVar2.setContentText(a9[1]);
            long currentTimeMillis2 = System.currentTimeMillis();
            eqVar2.setWhen(currentTimeMillis2);
            String a10 = a(m433a, "notification_show_when");
            if (!TextUtils.isEmpty(a10)) {
                eqVar2.setShowWhen(Boolean.parseBoolean(a10));
            } else if (Build.VERSION.SDK_INT >= 24) {
                eqVar2.setShowWhen(true);
            }
            eqVar2.setContentIntent(pendingIntent);
            int a11 = a(context, a8, "mipush_notification");
            int a12 = a(context, a8, "mipush_small_notification");
            if (a11 <= 0 || a12 <= 0) {
                if (!com.xiaomi.push.m.m562a(context)) {
                    String a13 = a(m433a, "fcm_icon_uri");
                    String a14 = a(m433a, "fcm_icon_color");
                    if (!TextUtils.isEmpty(a13) && !TextUtils.isEmpty(a14) && (a2 = a(context, a8, a13)) > 0) {
                        eqVar2.setSmallIcon(a2);
                        eqVar2.m313a(a14);
                        z = true;
                        if (!z) {
                            if (Build.VERSION.SDK_INT >= 23) {
                                eqVar2.setSmallIcon(Icon.createWithResource(a8, ay.a(context, a8)));
                            } else {
                                eqVar2.setSmallIcon(b(context, a8));
                            }
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            } else {
                eqVar2.setLargeIcon(a(context, a11));
                eqVar2.setSmallIcon(a12);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (m433a == null) {
                    a6 = null;
                    i4 = 1;
                } else {
                    i4 = 1;
                    a6 = a(context, m433a.get("notification_small_icon_uri"), true);
                }
                if (a6 != null) {
                    Object[] objArr = new Object[i4];
                    objArr[0] = a6;
                    Object a15 = com.xiaomi.push.bk.a("android.graphics.drawable.Icon", "createWithBitmap", objArr);
                    if (a15 != null) {
                        Object[] objArr2 = new Object[i4];
                        objArr2[0] = a15;
                        com.xiaomi.push.bk.a((Object) eqVar2, "setSmallIcon", objArr2);
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("miui.isGrayscaleIcon", i4);
                        eqVar2.addExtras(bundle);
                        eqVar2.m313a(a(m433a, "notification_small_icon_color"));
                    } else {
                        sb = new StringBuilder();
                        sb.append("failed te get small icon with url:");
                        a7 = m433a.get("notification_small_icon_uri");
                    }
                } else {
                    sb = new StringBuilder();
                    sb.append("failed to get small icon url:");
                    a7 = a(m433a, "notification_small_icon_uri");
                }
                sb.append(a7);
                com.xiaomi.channel.commonutils.logger.b.m90a(sb.toString());
                eqVar2.m313a(a(m433a, "notification_small_icon_color"));
            }
            String a16 = a(m433a, "__dynamic_icon_uri");
            boolean z8 = Boolean.parseBoolean(a(m433a, "__adiom")) || !com.xiaomi.push.m.m561a();
            if (!TextUtils.isEmpty(a16) && z8) {
                if (a16.startsWith("http")) {
                    aw.b a17 = aw.a(context, a16, true);
                    if (a17 != null) {
                        a5 = a17.f912a;
                        bVar2.a = a17.a;
                    } else {
                        a5 = null;
                    }
                } else {
                    a5 = aw.a(context, a16);
                }
                if (a5 != null) {
                    eqVar2.setLargeIcon(a5);
                    z2 = true;
                    a3 = m433a != null ? null : a(context, m433a.get("notification_large_icon_uri"), true);
                    if (a3 != null) {
                        eqVar2.setLargeIcon(a3);
                    }
                    if (m433a != null || Build.VERSION.SDK_INT < 24) {
                        z3 = false;
                        str = null;
                        z4 = false;
                        z5 = true;
                    } else {
                        String str3 = m433a.get("notification_group");
                        boolean parseBoolean = Boolean.parseBoolean(m433a.get("notification_is_summary"));
                        boolean parseBoolean2 = Boolean.parseBoolean(m433a.get("notification_group_disable_default"));
                        if (TextUtils.isEmpty(str3) && (com.xiaomi.push.m.m561a() || !parseBoolean2)) {
                            str3 = a(cif);
                        }
                        String str4 = str3;
                        com.xiaomi.push.bk.a((Object) eqVar2, "setGroupSummary", Boolean.valueOf(parseBoolean));
                        String str5 = m433a.get("notification_style_type");
                        if ("com.xiaomi.xmsf".equals(context.getPackageName()) && ("4".equals(str5) || "3".equals(str5))) {
                            z4 = true;
                            z5 = true;
                            str = a(cif) + "_custom_" + currentTimeMillis2;
                            z3 = parseBoolean;
                        } else {
                            z3 = parseBoolean;
                            z4 = false;
                            z5 = true;
                            str = str4;
                        }
                    }
                    eqVar2.setAutoCancel(z5);
                    currentTimeMillis = System.currentTimeMillis();
                    if (m433a != null && m433a.containsKey(ALaKeepAliveService.KEY_TICKER)) {
                        eqVar2.setTicker(m433a.get(ALaKeepAliveService.KEY_TICKER));
                    }
                    if (currentTimeMillis - a <= 10000) {
                        a = currentTimeMillis;
                        i2 = m466a.f537a;
                        if (m613b(context, a8)) {
                            i2 = a(context, a8);
                        }
                        eqVar2.setDefaults(i2);
                        if (m433a != null && (i2 & 1) != 0) {
                            String str6 = m433a.get("sound_uri");
                            if (!TextUtils.isEmpty(str6)) {
                                bVar = bVar2;
                                StringBuilder sb2 = new StringBuilder();
                                z6 = z2;
                                sb2.append("android.resource://");
                                sb2.append(a8);
                                if (str6.startsWith(sb2.toString())) {
                                    eqVar2.setDefaults(i2 ^ 1);
                                    eqVar2.setSound(Uri.parse(str6));
                                }
                            }
                        }
                        z6 = z2;
                        bVar = bVar2;
                    } else {
                        z6 = z2;
                        bVar = bVar2;
                        i2 = -100;
                    }
                    if (m433a != null || Build.VERSION.SDK_INT < 26) {
                        str2 = "com.xiaomi.xmsf";
                        if (m433a != null && Build.VERSION.SDK_INT < 26) {
                            com.xiaomi.push.bk.a((Object) eqVar2, "setPriority", Integer.valueOf(c(m433a)));
                        }
                    } else {
                        ax a18 = ax.a(context, a8);
                        if (a(m433a) > 0) {
                            str2 = "com.xiaomi.xmsf";
                            z7 = z3;
                            i3 = i2;
                            com.xiaomi.push.bk.a((Object) eqVar2, "setTimeoutAfter", Long.valueOf(a4 * 1000));
                        } else {
                            z7 = z3;
                            i3 = i2;
                            str2 = "com.xiaomi.xmsf";
                        }
                        at.a(m466a);
                        String str7 = m433a.get("channel_id");
                        if (!TextUtils.isEmpty(str7) || context.getApplicationInfo().targetSdkVersion >= 26) {
                            String a19 = a(context, a8, m433a);
                            int b2 = b(m433a);
                            int i5 = m466a.f537a;
                            cc.a(context, m433a, eqVar2, currentTimeMillis2);
                            com.xiaomi.push.bk.a((Object) eqVar2, "setChannelId", at.a(a18, str7, a19, m433a.get("channel_description"), i5, b2, m433a.get("sound_uri"), m433a.get("channel_perm")));
                            if (i3 == -100 && ay.a(m433a)) {
                                ay.a(eqVar2, z7);
                            }
                            if ("pulldown".equals(ay.a((Object) m433a)) && ay.a(m433a) && Objects.equals(m433a.get("pull_down_pop_type"), "0")) {
                                ay.a(eqVar2, z7);
                            }
                            if ("tts".equals(ay.a((Object) m433a)) && ay.a(m433a)) {
                                ay.a(eqVar2, z7);
                            }
                        }
                        String str8 = m433a.get("background_color");
                        if (!TextUtils.isEmpty(str8)) {
                            try {
                                int parseInt = Integer.parseInt(str8);
                                eqVar2.setOngoing(true);
                                eqVar2.setColor(parseInt);
                                com.xiaomi.push.bk.a((Object) eqVar2, "setColorized", Boolean.TRUE);
                            } catch (Exception e) {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                            }
                        }
                    }
                    if (str != null) {
                        if (!z4) {
                            str = au.a().a(context, eqVar2, str);
                        }
                        com.xiaomi.push.bk.a((Object) eqVar2, "setGroup", str);
                    }
                    if (com.xiaomi.push.m.m566c() && str2.equals(context.getPackageName())) {
                        com.xiaomi.push.bk.a("miui.util.NotificationHelper", "setTargetPkg", context, eqVar2, a(cif));
                    }
                    notification = eqVar2.getNotification();
                    if (z6 && com.xiaomi.push.m.m561a()) {
                        a(notification);
                    }
                    if (m433a != null) {
                        if (notification.extras == null) {
                            notification.extras = new Bundle();
                        }
                        if (!TextUtils.isEmpty(m433a.get("enable_keyguard"))) {
                            ay.b(notification, Boolean.parseBoolean(m433a.get("enable_keyguard")));
                        }
                        if (!TextUtils.isEmpty(m433a.get("enable_float"))) {
                            ay.a(notification, Boolean.parseBoolean(m433a.get("enable_float")));
                        }
                        if (!TextUtils.isEmpty(m433a.get("float_small_win")) && "0".equals(m433a.get("float_small_win")) && com.xiaomi.push.h.d(context, a8)) {
                            ay.a(notification, false);
                        }
                        int a20 = com.xiaomi.push.w.a(m433a.get("section_is_prr"), -1);
                        int a21 = com.xiaomi.push.w.a(m433a.get("section_prr_cl"), -1);
                        if (a20 >= 0 && a21 >= 0) {
                            ay.a(notification, a20, a21);
                        }
                    }
                    b bVar3 = bVar;
                    bVar3.f895a = notification;
                    return bVar3;
                }
            }
            z2 = false;
            if (m433a != null) {
            }
            if (a3 != null) {
            }
            if (m433a != null) {
            }
            z3 = false;
            str = null;
            z4 = false;
            z5 = true;
            eqVar2.setAutoCancel(z5);
            currentTimeMillis = System.currentTimeMillis();
            if (m433a != null) {
                eqVar2.setTicker(m433a.get(ALaKeepAliveService.KEY_TICKER));
            }
            if (currentTimeMillis - a <= 10000) {
            }
            if (m433a != null) {
            }
            str2 = "com.xiaomi.xmsf";
            if (m433a != null) {
                com.xiaomi.push.bk.a((Object) eqVar2, "setPriority", Integer.valueOf(c(m433a)));
            }
            if (str != null) {
            }
            if (com.xiaomi.push.m.m566c()) {
                com.xiaomi.push.bk.a("miui.util.NotificationHelper", "setTargetPkg", context, eqVar2, a(cif));
            }
            notification = eqVar2.getNotification();
            if (z6) {
                a(notification);
            }
            if (m433a != null) {
            }
            b bVar32 = bVar;
            bVar32.f895a = notification;
            return bVar32;
        }
        return (b) invokeCommon.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static c m606a(Context context, Cif cif, byte[] bArr) {
        InterceptResult invokeLLL;
        int i;
        Map<String, String> map;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65554, null, context, cif, bArr)) == null) {
            c cVar = new c();
            h.a a2 = com.xiaomi.push.h.a(context, a(cif), true);
            hw m466a = cif.m466a();
            if (m466a != null) {
                i = m466a.c();
                map = m466a.m433a();
            } else {
                i = 0;
                map = null;
            }
            int b2 = com.xiaomi.push.w.b(a(cif), i);
            if (com.xiaomi.push.m.m562a(context) && a2 == h.a.c) {
                if (m466a != null) {
                    eo.a(context.getApplicationContext()).a(cif.b(), b(cif), m466a.m432a(), "10:" + a(cif));
                }
                str = "Do not notify because user block " + a(cif) + "‘s notification";
            } else if (com.xiaomi.push.m.m562a(context) && f890a != null && f890a.m617a(context, b2, a(cif), map)) {
                if (m466a != null) {
                    eo.a(context.getApplicationContext()).a(cif.b(), b(cif), m466a.m432a(), "14:" + a(cif));
                }
                str = "Do not notify because card notification is canceled or sequence incorrect";
            } else {
                RemoteViews a3 = a(context, cif, bArr);
                PendingIntent a4 = a(context, cif, cif.b(), bArr, b2);
                if (a4 != null) {
                    b a5 = a(context, cif, bArr, a3, a4, b2);
                    cVar.a = a5.a;
                    cVar.f896a = a(cif);
                    Notification notification = a5.f895a;
                    if (com.xiaomi.push.m.m561a()) {
                        if (!TextUtils.isEmpty(m466a.m432a())) {
                            notification.extras.putString("message_id", m466a.m432a());
                        }
                        notification.extras.putString("local_paid", cif.m467a());
                        ay.a(map, notification.extras, "msg_busi_type");
                        ay.a(map, notification.extras, "disable_notification_flags");
                        String str2 = m466a.m438b() == null ? null : m466a.m438b().get("score_info");
                        if (!TextUtils.isEmpty(str2)) {
                            notification.extras.putString("score_info", str2);
                        }
                        notification.extras.putString("pushUid", a(m466a.f541a, "n_stats_expose"));
                        int i2 = -1;
                        if (c(cif)) {
                            i2 = 1000;
                        } else if (m610a(cif)) {
                            i2 = 3000;
                        }
                        notification.extras.putString("eventMessageType", String.valueOf(i2));
                        notification.extras.putString("target_package", a(cif));
                    }
                    String str3 = m466a.m433a() == null ? null : m466a.m433a().get("message_count");
                    if (com.xiaomi.push.m.m561a() && str3 != null) {
                        try {
                            ay.a(notification, Integer.parseInt(str3));
                        } catch (NumberFormatException e) {
                            if (m466a != null) {
                                eo.a(context.getApplicationContext()).b(cif.b(), b(cif), m466a.m432a(), "8");
                            }
                            com.xiaomi.channel.commonutils.logger.b.d("fail to set message count. " + e);
                        }
                    }
                    String a6 = a(cif);
                    if (!com.xiaomi.push.m.m566c() && com.xiaomi.push.m.m562a(context)) {
                        ay.m633a(notification, a6);
                    }
                    ax a7 = ax.a(context, a6);
                    if (com.xiaomi.push.m.m562a(context) && f890a != null) {
                        f890a.a(cif, m466a.m433a(), b2, notification);
                    }
                    if (com.xiaomi.push.m.m562a(context) && f890a != null && f890a.a(m466a.m433a(), b2, notification)) {
                        com.xiaomi.channel.commonutils.logger.b.b("consume this notificaiton by agent");
                    } else {
                        a7.a(b2, notification);
                        cVar.f897a = true;
                        com.xiaomi.channel.commonutils.logger.b.m90a("notification: " + m466a.m432a() + " is notifyied");
                    }
                    if (com.xiaomi.push.m.m561a() && com.xiaomi.push.m.m562a(context)) {
                        au.a().a(context, b2, notification);
                        cc.m657a(context, a6, b2, m466a.m432a(), notification);
                    }
                    if (m610a(cif)) {
                        eo.a(context.getApplicationContext()).a(cif.b(), b(cif), m466a.m432a(), 3002, null);
                    }
                    if (c(cif)) {
                        eo.a(context.getApplicationContext()).a(cif.b(), b(cif), m466a.m432a(), 1002, null);
                    }
                    if (Build.VERSION.SDK_INT < 26) {
                        String m432a = m466a != null ? m466a.m432a() : null;
                        com.xiaomi.push.al a8 = com.xiaomi.push.al.a(context);
                        int a9 = a(m466a.m433a());
                        if (a9 > 0 && !TextUtils.isEmpty(m432a)) {
                            String str4 = "n_timeout_" + m432a;
                            a8.m168a(str4);
                            a8.b(new am(str4, a7, b2), a9);
                        }
                    }
                    Pair<Integer, Cif> pair = new Pair<>(Integer.valueOf(b2), cif);
                    synchronized (f891a) {
                        f891a.add(pair);
                        if (f891a.size() > 100) {
                            f891a.remove();
                        }
                    }
                    return cVar;
                }
                if (m466a != null) {
                    eo.a(context.getApplicationContext()).a(cif.b(), b(cif), m466a.m432a(), "11");
                }
                str = "The click PendingIntent is null. ";
            }
            com.xiaomi.channel.commonutils.logger.b.m90a(str);
            return cVar;
        }
        return (c) invokeLLL.objValue;
    }

    public static String a(Context context, String str, Map<String, String> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, context, str, map)) == null) ? (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? com.xiaomi.push.h.m388b(context, str) : map.get("channel_name") : (String) invokeLLL.objValue;
    }

    public static String a(Cif cif) {
        InterceptResult invokeL;
        hw m466a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, cif)) == null) {
            if ("com.xiaomi.xmsf".equals(cif.f633b) && (m466a = cif.m466a()) != null && m466a.m433a() != null) {
                String str = m466a.m433a().get("miui_package_name");
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
            return cif.f633b;
        }
        return (String) invokeL.objValue;
    }

    public static String a(Map<String, String> map, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, map, i)) == null) {
            String format = i == 0 ? "notify_effect" : m615b(map) ? String.format("cust_btn_%s_ne", Integer.valueOf(i)) : i == 1 ? "notification_style_button_left_notify_effect" : i == 2 ? "notification_style_button_mid_notify_effect" : i == 3 ? "notification_style_button_right_notify_effect" : i == 4 ? "notification_colorful_button_notify_effect" : null;
            if (map == null || format == null) {
                return null;
            }
            return map.get(format);
        }
        return (String) invokeLI.objValue;
    }

    public static String a(Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, map, str)) == null) {
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static void a(Context context, Intent intent, Cif cif, hw hwVar, String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{context, intent, cif, hwVar, str, Integer.valueOf(i)}) == null) || cif == null || hwVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = a(hwVar.m433a(), i);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (bk.a.equals(a2) || bk.b.equals(a2) || bk.c.equals(a2)) {
            intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
            intent.putExtra("local_paid", cif.f629a);
            if (!TextUtils.isEmpty(cif.f633b)) {
                intent.putExtra("target_package", cif.f633b);
            }
            intent.putExtra("job_key", a(hwVar.m433a(), "jobkey"));
            intent.putExtra(i + "_target_component", a(context, cif.f633b, hwVar.m433a(), i));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m607a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, context, str) == null) {
            a(context, str, -1);
        }
    }

    public static void a(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65561, null, context, str, i) == null) {
            a(context, str, i, -1);
        }
    }

    public static void a(Context context, String str, int i, int i2) {
        int hashCode;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65562, null, context, str, i, i2) == null) || context == null || TextUtils.isEmpty(str) || i < -1) {
            return;
        }
        ax a2 = ax.a(context, str);
        List<StatusBarNotification> m632b = a2.m632b();
        if (com.xiaomi.push.w.a(m632b)) {
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
        Iterator<StatusBarNotification> it = m632b.iterator();
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

    public static void a(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65563, null, context, str, str2, str3) == null) || context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        ax a2 = ax.a(context, str);
        List<StatusBarNotification> m632b = a2.m632b();
        if (com.xiaomi.push.w.a(m632b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (StatusBarNotification statusBarNotification : m632b) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65564, null, context, linkedList) == null) || linkedList == null || linkedList.size() <= 0) {
            return;
        }
        bz.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    public static void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, intent) == null) {
            try {
                Method declaredMethod = intent.getClass().getDeclaredMethod("addMiuiFlags", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(intent, 2);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("insert flags error " + e);
            }
        }
    }

    @TargetApi(16)
    public static void a(eq eqVar, Context context, String str, Cif cif, byte[] bArr, int i) {
        PendingIntent a2;
        PendingIntent a3;
        PendingIntent a4;
        PendingIntent a5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{eqVar, context, str, cif, bArr, Integer.valueOf(i)}) == null) {
            Map<String, String> m433a = cif.m466a().m433a();
            if (TextUtils.equals("3", m433a.get("notification_style_type")) || TextUtils.equals("4", m433a.get("notification_style_type"))) {
                return;
            }
            if (m615b(m433a)) {
                for (int i2 = 1; i2 <= 3; i2++) {
                    String str2 = m433a.get(String.format("cust_btn_%s_n", Integer.valueOf(i2)));
                    if (!TextUtils.isEmpty(str2) && (a5 = a(context, str, cif, bArr, i, i2)) != null) {
                        eqVar.addAction(0, str2, a5);
                    }
                }
                return;
            }
            if (!TextUtils.isEmpty(m433a.get("notification_style_button_left_name")) && (a4 = a(context, str, cif, bArr, i, 1)) != null) {
                eqVar.addAction(0, m433a.get("notification_style_button_left_name"), a4);
            }
            if (!TextUtils.isEmpty(m433a.get("notification_style_button_mid_name")) && (a3 = a(context, str, cif, bArr, i, 2)) != null) {
                eqVar.addAction(0, m433a.get("notification_style_button_mid_name"), a3);
            }
            if (TextUtils.isEmpty(m433a.get("notification_style_button_right_name")) || (a2 = a(context, str, cif, bArr, i, 3)) == null) {
                return;
            }
            eqVar.addAction(0, m433a.get("notification_style_button_right_name"), a2);
        }
    }

    public static boolean a(Context context, Cif cif, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65567, null, context, cif, str)) == null) {
            if (cif != null && cif.m466a() != null && cif.m466a().m433a() != null && !TextUtils.isEmpty(str)) {
                return Boolean.parseBoolean(cif.m466a().m433a().get("use_clicked_activity")) && l.a(context, a(str));
            }
            com.xiaomi.channel.commonutils.logger.b.m90a("should clicked activity params are null.");
            return false;
        }
        return invokeLLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m608a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, context, str)) == null) {
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
        return invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m609a(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65569, null, context, str, z)) == null) ? com.xiaomi.push.m.m561a() && !z && m608a(context, str) : invokeLLZ.booleanValue;
    }

    public static boolean a(hw hwVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, hwVar)) == null) {
            if (hwVar != null) {
                String m432a = hwVar.m432a();
                return !TextUtils.isEmpty(m432a) && m432a.length() == 22 && "satuigmo".indexOf(m432a.charAt(0)) >= 0;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m610a(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, cif)) == null) {
            hw m466a = cif.m466a();
            return a(m466a) && m466a.l();
        }
        return invokeL.booleanValue;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, str, str2)) == null) ? TextUtils.isEmpty(str) || str2.contains(str) : invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m611a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, map)) == null) {
            if (map == null || !map.containsKey("notify_foreground")) {
                return true;
            }
            return "1".equals(map.get("notify_foreground"));
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0052, code lost:
        if (android.text.TextUtils.isEmpty(r4) == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0074, code lost:
        if (android.text.TextUtils.isEmpty(r4) == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0076, code lost:
        r1 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] a(Context context, hw hwVar) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, context, hwVar)) == null) {
            String m440c = hwVar.m440c();
            String d = hwVar.d();
            Map<String, String> m433a = hwVar.m433a();
            if (m433a != null) {
                int intValue = Float.valueOf((context.getResources().getDisplayMetrics().widthPixels / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
                if (intValue <= 320) {
                    String str2 = m433a.get("title_short");
                    if (!TextUtils.isEmpty(str2)) {
                        m440c = str2;
                    }
                    str = m433a.get("description_short");
                } else if (intValue > 360) {
                    String str3 = m433a.get("title_long");
                    if (!TextUtils.isEmpty(str3)) {
                        m440c = str3;
                    }
                    str = m433a.get("description_long");
                }
            }
            return new String[]{m440c, d};
        }
        return (String[]) invokeLL.objValue;
    }

    public static int b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65575, null, context, str)) == null) {
            int a2 = a(context, str, "mipush_notification");
            int a3 = a(context, str, "mipush_small_notification");
            if (a2 <= 0) {
                a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
            }
            return a2 == 0 ? context.getApplicationInfo().logo : a2;
        }
        return invokeLL.intValue;
    }

    public static int b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, map)) == null) {
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
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent b(Context context, String str, Map<String, String> map, int i) {
        InterceptResult invokeLLLI;
        Intent launchIntentForPackage;
        String str2;
        Intent intent;
        Intent intent2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65577, null, context, str, map, i)) == null) {
            if (map == null) {
                return null;
            }
            if (i != 0) {
                return m605a(context, str, map, i);
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
                                    intent = new Intent("android.intent.action.VIEW");
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
                    launchIntentForPackage.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    try {
                        if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                            return launchIntentForPackage;
                        }
                        if (Build.VERSION.SDK_INT >= 30 && !com.xiaomi.push.m.m562a(context) && bk.c.equals(str3)) {
                            return launchIntentForPackage;
                        }
                        com.xiaomi.channel.commonutils.logger.b.m90a("not resolve activity:" + launchIntentForPackage);
                    } catch (Exception e7) {
                        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e7.getMessage());
                    }
                }
                return null;
            }
            return null;
        }
        return (Intent) invokeLLLI.objValue;
    }

    public static String b(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65578, null, cif)) == null) ? m610a(cif) ? "E100002" : c(cif) ? "E100000" : m614b(cif) ? "E100001" : d(cif) ? "E100003" : "" : (String) invokeL.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static void m612b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65579, null, context, str) == null) || !com.xiaomi.push.m.m562a(context) || f890a == null || TextUtils.isEmpty(str)) {
            return;
        }
        f890a.a(str);
    }

    public static void b(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65580, null, context, str, i) == null) {
            context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m613b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65581, null, context, str)) == null) ? context.getSharedPreferences("pref_notify_type", 0).contains(str) : invokeLL.booleanValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m614b(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, cif)) == null) {
            hw m466a = cif.m466a();
            return a(m466a) && m466a.f543b == 1 && !m610a(cif);
        }
        return invokeL.booleanValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m615b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, map)) == null) {
            if (map == null) {
                com.xiaomi.channel.commonutils.logger.b.m90a("meta extra is null");
                return false;
            }
            return "6".equals(map.get("notification_style_type"));
        }
        return invokeL.booleanValue;
    }

    public static int c(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, map)) == null) {
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
        return invokeL.intValue;
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65585, null, context, str) == null) {
            context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
        }
    }

    public static boolean c(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, cif)) == null) {
            hw m466a = cif.m466a();
            return a(m466a) && m466a.f543b == 0 && !m610a(cif);
        }
        return invokeL.booleanValue;
    }

    public static boolean d(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65587, null, cif)) == null) ? cif.a() == hj.a : invokeL.booleanValue;
    }

    public static boolean e(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65588, null, cif)) == null) ? m610a(cif) || c(cif) || m614b(cif) : invokeL.booleanValue;
    }
}
