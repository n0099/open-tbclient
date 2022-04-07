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
/* loaded from: classes8.dex */
public class ac {
    public static /* synthetic */ Interceptable $ic;
    public static long a;

    /* renamed from: a  reason: collision with other field name */
    public static volatile aj f853a;

    /* renamed from: a  reason: collision with other field name */
    public static final LinkedList<Pair<Integer, ib>> f854a;

    /* renamed from: a  reason: collision with other field name */
    public static ExecutorService f855a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Callable<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: a  reason: collision with other field name */
        public String f856a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f857a;

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
            this.f856a = str;
            this.f857a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Bitmap call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Bitmap bitmap = null;
                if (TextUtils.isEmpty(this.f856a)) {
                    com.xiaomi.channel.commonutils.logger.b.m108a("Failed get online picture/icon resource cause picUrl is empty");
                    return null;
                }
                if (this.f856a.startsWith("http")) {
                    an.b a = an.a(this.a, this.f856a, this.f857a);
                    if (a != null) {
                        return a.f873a;
                    }
                } else {
                    bitmap = an.a(this.a, this.f856a);
                    if (bitmap != null) {
                        return bitmap;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.m108a("Failed get online picture/icon resource");
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
        public Notification f858a;

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
        public String f859a;

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
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071162116, "Lcom/xiaomi/push/service/ac;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071162116, "Lcom/xiaomi/push/service/ac;");
                return;
            }
        }
        f854a = new LinkedList<>();
        f855a = Executors.newCachedThreadPool();
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

    public static int a(Context context, String str, Map<String, String> map) {
        InterceptResult invokeLLL;
        ComponentName a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, map)) == null) {
            Intent a3 = a(context, str, map, "notify_effect", "intent_uri", ForumSquareActivityConfig.FORUM_CLASS_NAME, "web_uri");
            if (a3 == null || (a2 = g.a(context, a3)) == null) {
                return 0;
            }
            return a2.hashCode();
        }
        return invokeLLL.intValue;
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
            Object a2 = com.xiaomi.push.bh.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.bh.a(a2, "setCustomizedIcon", Boolean.TRUE);
            }
            return notification;
        }
        return (Notification) invokeL.objValue;
    }

    public static Notification a(Notification notification, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, notification, str)) == null) {
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
        return (Notification) invokeLL.objValue;
    }

    public static PendingIntent a(Context context, ib ibVar, String str, byte[] bArr, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, ibVar, str, bArr, Integer.valueOf(i)})) == null) ? a(context, ibVar, str, bArr, i, 0, a(context, ibVar, str)) : (PendingIntent) invokeCommon.objValue;
    }

    public static PendingIntent a(Context context, ib ibVar, String str, byte[] bArr, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, ibVar, str, bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int i3 = c(ibVar) ? 1000 : m613a(ibVar) ? 3000 : -1;
            hs m488a = ibVar.m488a();
            String m445a = m488a != null ? m488a.m445a() : "";
            boolean m613a = m613a(ibVar);
            if (m488a != null && !TextUtils.isEmpty(m488a.f534e)) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(m488a.f534e));
                intent2.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent2.putExtra(MiPushMessage.KEY_MESSAGE_ID, m445a);
                intent2.putExtra("eventMessageType", i3);
                return PendingIntent.getActivity(context, 0, intent2, 134217728);
            }
            if (m613a) {
                intent = new Intent();
                intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
                intent.putExtra("mipush_payload", bArr);
                intent.putExtra("mipush_notified", true);
                intent.addCategory(String.valueOf(i));
                intent.addCategory(String.valueOf(m445a));
            } else {
                intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent.setComponent(new ComponentName(str, "com.xiaomi.mipush.sdk.PushMessageHandler"));
                intent.putExtra("mipush_payload", bArr);
                intent.putExtra("mipush_notified", true);
                intent.addCategory(String.valueOf(i));
                intent.addCategory(String.valueOf(m445a));
            }
            intent.putExtra("notification_click_button", i2);
            intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m445a);
            intent.putExtra("eventMessageType", i3);
            if (m613a || !z) {
                a(context, intent, ibVar, m488a);
                return PendingIntent.getService(context, 0, intent, 134217728);
            }
            Intent intent3 = new Intent();
            intent3.setComponent(a(str));
            intent3.addFlags(276824064);
            intent3.putExtra("mipush_serviceIntent", intent);
            intent3.addCategory(String.valueOf(i));
            intent3.addCategory(String.valueOf(m445a));
            intent3.addCategory(String.valueOf(i2));
            a(context, intent3, ibVar, m488a);
            a(intent3);
            return PendingIntent.getActivity(context, 0, intent3, 134217728);
        }
        return (PendingIntent) invokeCommon.objValue;
    }

    public static PendingIntent a(Context context, String str, ib ibVar, byte[] bArr, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, str, ibVar, bArr, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            Map<String, String> m446a = ibVar.m488a().m446a();
            if (m446a == null) {
                return null;
            }
            boolean a2 = a(context, ibVar, str);
            if (a2) {
                return a(context, ibVar, str, bArr, i, i2, a2);
            }
            Intent a3 = a(context, str, m446a, i2);
            if (a3 != null) {
                return PendingIntent.getActivity(context, 0, a3, 134217728);
            }
            return null;
        }
        return (PendingIntent) invokeCommon.objValue;
    }

    public static ComponentName a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity") : (ComponentName) invokeL.objValue;
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i) {
        InterceptResult invokeLLLI;
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65547, null, context, str, map, i)) == null) {
            if (i == 1) {
                str2 = "notification_style_button_left_notify_effect";
                str3 = "notification_style_button_left_intent_uri";
                str4 = "notification_style_button_left_intent_class";
                str5 = "notification_style_button_left_web_uri";
            } else if (i == 2) {
                str2 = "notification_style_button_mid_notify_effect";
                str3 = "notification_style_button_mid_intent_uri";
                str4 = "notification_style_button_mid_intent_class";
                str5 = "notification_style_button_mid_web_uri";
            } else if (i == 3) {
                str2 = "notification_style_button_right_notify_effect";
                str3 = "notification_style_button_right_intent_uri";
                str4 = "notification_style_button_right_intent_class";
                str5 = "notification_style_button_right_web_uri";
            } else if (i != 4) {
                return null;
            } else {
                str2 = "notification_colorful_button_notify_effect";
                str3 = "notification_colorful_button_intent_uri";
                str4 = "notification_colorful_button_intent_class";
                str5 = "notification_colorful_button_web_uri";
            }
            return a(context, str, map, str2, str3, str4, str5);
        }
        return (Intent) invokeLLLI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent a(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Intent launchIntentForPackage;
        Intent intent;
        StringBuilder sb;
        String message;
        String protocol;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{context, str, map, str2, str3, str4, str5})) == null) {
            String str6 = map.get(str2);
            if (TextUtils.isEmpty(str6)) {
                return null;
            }
            if (az.a.equals(str6)) {
                try {
                    launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                }
            } else if (az.b.equals(str6)) {
                if (map.containsKey(str3)) {
                    String str7 = map.get(str3);
                    if (str7 != null) {
                        try {
                            intent = Intent.parseUri(str7, 1);
                            try {
                                intent.setPackage(str);
                            } catch (URISyntaxException e2) {
                                e = e2;
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
                        } catch (URISyntaxException e3) {
                            e = e3;
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
                if (az.c.equals(str6)) {
                    String str8 = map.get(str5);
                    if (!TextUtils.isEmpty(str8)) {
                        String trim = str8.trim();
                        if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                            trim = "http://" + trim;
                        }
                        try {
                            protocol = new URL(trim).getProtocol();
                        } catch (MalformedURLException e4) {
                            e = e4;
                            intent = null;
                        }
                        if ("http".equals(protocol) || "https".equals(protocol)) {
                            intent = new Intent("android.intent.action.VIEW");
                            try {
                                intent.setData(Uri.parse(trim));
                                ap.a(context, intent);
                            } catch (MalformedURLException e5) {
                                e = e5;
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
                launchIntentForPackage.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                try {
                    if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                        return launchIntentForPackage;
                    }
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
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, context, i)) == null) ? a(context.getResources().getDrawable(i)) : (Bitmap) invokeLI.objValue;
    }

    public static Bitmap a(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65550, null, context, str, z)) == null) {
            Future submit = f855a.submit(new a(str, context, z));
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, drawable)) == null) {
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

    public static RemoteViews a(Context context, ib ibVar, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, context, ibVar, bArr)) == null) {
            hs m488a = ibVar.m488a();
            String a2 = a(ibVar);
            if (m488a != null && m488a.m446a() != null) {
                Map<String, String> m446a = m488a.m446a();
                String str = m446a.get("layout_name");
                String str2 = m446a.get("layout_value");
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

    public static ai.a a(Context context, String str, int i, String str2, Notification notification) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{context, str, Integer.valueOf(i), str2, notification})) == null) ? new ae(i, str2, context, str, notification) : (ai.a) invokeCommon.objValue;
    }

    @TargetApi(16)
    public static en a(Context context, ib ibVar, byte[] bArr, String str, int i) {
        InterceptResult invokeCommon;
        PendingIntent a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{context, ibVar, bArr, str, Integer.valueOf(i)})) == null) {
            String a3 = a(ibVar);
            Map<String, String> m446a = ibVar.m488a().m446a();
            String str2 = m446a.get("notification_style_type");
            en a4 = (!com.xiaomi.push.l.m574a(context) || f853a == null) ? null : f853a.a(context, i, a3, m446a);
            if (a4 != null) {
                a4.a(m446a);
                return a4;
            } else if (Build.VERSION.SDK_INT >= 16 && "2".equals(str2)) {
                en enVar = new en(context);
                Bitmap a5 = TextUtils.isEmpty(m446a.get("notification_bigPic_uri")) ? null : a(context, m446a.get("notification_bigPic_uri"), false);
                if (a5 == null) {
                    com.xiaomi.channel.commonutils.logger.b.m108a("can not get big picture.");
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
            } else if ("4".equals(str2) && com.xiaomi.push.l.m574a(context)) {
                em emVar = new em(context, a3);
                if (!TextUtils.isEmpty(m446a.get("notification_banner_image_uri"))) {
                    emVar.a(a(context, m446a.get("notification_banner_image_uri"), false));
                }
                if (!TextUtils.isEmpty(m446a.get("notification_banner_icon_uri"))) {
                    emVar.b(a(context, m446a.get("notification_banner_icon_uri"), false));
                }
                emVar.a(m446a);
                return emVar;
            } else if ("3".equals(str2) && com.xiaomi.push.l.m574a(context)) {
                eo eoVar = new eo(context, i, a3);
                if (!TextUtils.isEmpty(m446a.get("notification_colorful_button_text")) && (a2 = a(context, a3, ibVar, bArr, i, 4)) != null) {
                    eoVar.a(m446a.get("notification_colorful_button_text"), a2).a(m446a.get("notification_colorful_button_bg_color"));
                }
                if (!TextUtils.isEmpty(m446a.get("notification_colorful_bg_color"))) {
                    eoVar.b(m446a.get("notification_colorful_bg_color"));
                } else if (!TextUtils.isEmpty(m446a.get("notification_colorful_bg_image_uri"))) {
                    eoVar.a(a(context, m446a.get("notification_colorful_bg_image_uri"), false));
                }
                eoVar.a(m446a);
                return eoVar;
            } else {
                return new en(context);
            }
        }
        return (en) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v20, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0281  */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v21 */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(Context context, ib ibVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent, int i) {
        InterceptResult invokeCommon;
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
        int i2;
        String str2;
        String str3;
        int i3;
        Notification notification;
        Object a3;
        Bundle bundle;
        int a4;
        String str4;
        Bitmap a5;
        int i4;
        Bitmap a6;
        StringBuilder sb;
        String a7;
        String a8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{context, ibVar, bArr, remoteViews, pendingIntent, Integer.valueOf(i)})) == null) {
            b bVar2 = new b();
            hs m488a = ibVar.m488a();
            String a9 = a(ibVar);
            Map<String, String> m446a = m488a.m446a();
            String[] a10 = a(context, m488a);
            if (remoteViews != null) {
                enVar = new en(context);
                enVar.setCustomContentView(remoteViews);
            } else {
                enVar = (m446a == null || !m446a.containsKey("notification_style_type")) ? new en(context) : a(context, ibVar, bArr, a10[1], i);
            }
            en enVar2 = enVar;
            a(enVar2, context, ibVar.b(), ibVar, bArr, i);
            enVar2.setContentTitle(a10[0]);
            enVar2.setContentText(a10[1]);
            long currentTimeMillis2 = System.currentTimeMillis();
            enVar2.setWhen(currentTimeMillis2);
            String a11 = a(m446a, "notification_show_when");
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
                if (m446a == null) {
                    a6 = null;
                    i4 = 1;
                } else {
                    i4 = 1;
                    a6 = a(context, m446a.get("notification_small_icon_uri"), true);
                }
                if (a6 != null) {
                    Object[] objArr = new Object[i4];
                    objArr[0] = a6;
                    Object a14 = com.xiaomi.push.bh.a("android.graphics.drawable.Icon", "createWithBitmap", objArr);
                    if (a14 != null) {
                        Object[] objArr2 = new Object[i4];
                        objArr2[0] = a14;
                        com.xiaomi.push.bh.a((Object) enVar2, "setSmallIcon", objArr2);
                        Bundle bundle2 = new Bundle();
                        bundle2.putBoolean("miui.isGrayscaleIcon", i4);
                        enVar2.addExtras(bundle2);
                        a8 = a(m446a, "notification_small_icon_color");
                        if (!TextUtils.isEmpty(a8)) {
                            try {
                                com.xiaomi.push.bh.a((Object) enVar2, "setColor", Integer.valueOf(Color.parseColor(a8)));
                            } catch (Exception e) {
                                com.xiaomi.channel.commonutils.logger.b.d("fail to set color. " + e);
                            }
                        }
                    } else {
                        sb = new StringBuilder();
                        sb.append("failed te get small icon with url:");
                        a7 = m446a.get("notification_small_icon_uri");
                    }
                } else {
                    sb = new StringBuilder();
                    sb.append("failed to get small icon url:");
                    a7 = a(m446a, "notification_small_icon_uri");
                }
                sb.append(a7);
                com.xiaomi.channel.commonutils.logger.b.m108a(sb.toString());
                a8 = a(m446a, "notification_small_icon_color");
                if (!TextUtils.isEmpty(a8)) {
                }
            }
            String a15 = a(m446a, "__dynamic_icon_uri");
            boolean z6 = Boolean.parseBoolean(a(m446a, "__adiom")) || !com.xiaomi.push.l.m573a();
            if (!TextUtils.isEmpty(a15) && z6) {
                if (a15.startsWith("http")) {
                    an.b a16 = an.a(context, a15, true);
                    if (a16 != null) {
                        a5 = a16.f873a;
                        bVar2.a = a16.a;
                    } else {
                        a5 = null;
                    }
                } else {
                    a5 = an.a(context, a15);
                }
                if (a5 != null) {
                    enVar2.setLargeIcon(a5);
                    z = true;
                    a2 = m446a != null ? null : a(context, m446a.get("notification_large_icon_uri"), true);
                    if (a2 != null) {
                        enVar2.setLargeIcon(a2);
                    }
                    if (m446a != null || Build.VERSION.SDK_INT < 24) {
                        z2 = false;
                        str = null;
                        z3 = false;
                        z4 = true;
                    } else {
                        String str5 = m446a.get("notification_group");
                        boolean parseBoolean = Boolean.parseBoolean(m446a.get("notification_is_summary"));
                        boolean parseBoolean2 = Boolean.parseBoolean(m446a.get("notification_group_disable_default"));
                        if (TextUtils.isEmpty(str5) && (com.xiaomi.push.l.m573a() || !parseBoolean2)) {
                            str5 = a(ibVar);
                        }
                        String str6 = str5;
                        com.xiaomi.push.bh.a((Object) enVar2, "setGroupSummary", Boolean.valueOf(parseBoolean));
                        String str7 = m446a.get("notification_style_type");
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
                    if (m446a != null && m446a.containsKey(ALaKeepAliveService.KEY_TICKER)) {
                        enVar2.setTicker(m446a.get(ALaKeepAliveService.KEY_TICKER));
                    }
                    if (currentTimeMillis - a <= 10000) {
                        a = currentTimeMillis;
                        i2 = m488a.f521a;
                        if (m616b(context, a9)) {
                            i2 = a(context, a9);
                        }
                        enVar2.setDefaults(i2);
                        if (m446a != null && (i2 & 1) != 0) {
                            String str8 = m446a.get("sound_uri");
                            if (!TextUtils.isEmpty(str8)) {
                                bVar = bVar2;
                                StringBuilder sb2 = new StringBuilder();
                                z5 = z;
                                sb2.append("android.resource://");
                                sb2.append(a9);
                                if (str8.startsWith(sb2.toString())) {
                                    enVar2.setDefaults(i2 ^ 1);
                                    enVar2.setSound(Uri.parse(str8));
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
                    if (m446a != null || Build.VERSION.SDK_INT < 26) {
                        str2 = "com.xiaomi.xmsf";
                        str3 = str;
                        if (m446a != null && (i3 = Build.VERSION.SDK_INT) >= 16 && i3 < 26) {
                            com.xiaomi.push.bh.a((Object) enVar2, "setPriority", Integer.valueOf(c(m446a)));
                        }
                    } else {
                        ao a17 = ao.a(context, a9);
                        if (a(m446a) > 0) {
                            str2 = "com.xiaomi.xmsf";
                            str3 = str;
                            com.xiaomi.push.bh.a((Object) enVar2, "setTimeoutAfter", Long.valueOf(a4 * 1000));
                        } else {
                            str2 = "com.xiaomi.xmsf";
                            str3 = str;
                        }
                        String str9 = m446a.get("channel_id");
                        if (!TextUtils.isEmpty(str9) || context.getApplicationInfo().targetSdkVersion >= 26) {
                            String m609a = m609a(context, a9, m446a);
                            int b2 = b(m446a);
                            int i5 = m488a.f521a;
                            String str10 = m446a.get("channel_description");
                            String str11 = m446a.get("sound_uri");
                            if (b2 >= 4 && com.xiaomi.push.l.m574a(context) && m618b(m446a)) {
                                int e2 = e(m446a);
                                if (e2 == 0) {
                                    com.xiaomi.channel.commonutils.logger.b.d("meet prd of top notification is zero.");
                                    str4 = ak.a(a17);
                                    if (str4 == null) {
                                        str4 = ak.a(a17, str9, m609a, str10, i5, b2, str11);
                                    }
                                    com.xiaomi.push.bh.a((Object) enVar2, "setChannelId", str4);
                                    if (i2 == -100) {
                                        ap.a(enVar2, z2);
                                    }
                                } else {
                                    enVar2.setPriority(2);
                                    int d = d(m446a);
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putLong("mipush_org_when", currentTimeMillis2);
                                    bundle3.putBoolean("mipush_n_top_flag", true);
                                    if (d > 0 && d <= e2) {
                                        bundle3.putInt("mipush_n_top_fre", d);
                                    }
                                    if (e2 > 0 && d <= e2) {
                                        bundle3.putInt("mipush_n_top_prd", e2);
                                    }
                                    enVar2.addExtras(bundle3);
                                }
                            }
                            str4 = null;
                            if (str4 == null) {
                            }
                            com.xiaomi.push.bh.a((Object) enVar2, "setChannelId", str4);
                            if (i2 == -100) {
                            }
                        }
                        String str12 = m446a.get("background_color");
                        if (!TextUtils.isEmpty(str12)) {
                            try {
                                int parseInt = Integer.parseInt(str12);
                                enVar2.setOngoing(true);
                                enVar2.setColor(parseInt);
                                com.xiaomi.push.bh.a((Object) enVar2, "setColorized", Boolean.TRUE);
                            } catch (Exception e3) {
                                com.xiaomi.channel.commonutils.logger.b.a(e3);
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
                    if (z5 && com.xiaomi.push.l.m573a()) {
                        a(notification);
                    }
                    if (m446a != null && (a3 = com.xiaomi.push.bh.a(notification, "extraNotification")) != null) {
                        bundle = notification.extras;
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        if (!TextUtils.isEmpty(m446a.get("enable_keyguard"))) {
                            com.xiaomi.push.bh.a(a3, "setEnableKeyguard", Boolean.valueOf(Boolean.parseBoolean(m446a.get("enable_keyguard"))));
                            bundle.putBoolean("miui.enableKeyguard", Boolean.parseBoolean(m446a.get("enable_keyguard")));
                        }
                        if (!TextUtils.isEmpty(m446a.get("enable_float"))) {
                            com.xiaomi.push.bh.a(a3, "setEnableFloat", Boolean.valueOf(Boolean.parseBoolean(m446a.get("enable_float"))));
                            bundle.putBoolean("miui.enableFloat", Boolean.parseBoolean(m446a.get("enable_float")));
                        }
                        notification.extras = bundle;
                    }
                    b bVar3 = bVar;
                    bVar3.f858a = notification;
                    return bVar3;
                }
            }
            z = false;
            if (m446a != null) {
            }
            if (a2 != null) {
            }
            if (m446a != null) {
            }
            z2 = false;
            str = null;
            z3 = false;
            z4 = true;
            enVar2.setAutoCancel(z4);
            currentTimeMillis = System.currentTimeMillis();
            if (m446a != null) {
                enVar2.setTicker(m446a.get(ALaKeepAliveService.KEY_TICKER));
            }
            if (currentTimeMillis - a <= 10000) {
            }
            if (m446a != null) {
            }
            str2 = "com.xiaomi.xmsf";
            str3 = str;
            if (m446a != null) {
                com.xiaomi.push.bh.a((Object) enVar2, "setPriority", Integer.valueOf(c(m446a)));
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
            if (m446a != null) {
                bundle = notification.extras;
                if (bundle == null) {
                }
                if (!TextUtils.isEmpty(m446a.get("enable_keyguard"))) {
                }
                if (!TextUtils.isEmpty(m446a.get("enable_float"))) {
                }
                notification.extras = bundle;
            }
            b bVar32 = bVar;
            bVar32.f858a = notification;
            return bVar32;
        }
        return (b) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0325 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0460 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0311  */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c m608a(Context context, ib ibVar, byte[] bArr) {
        InterceptResult invokeLLL;
        Map<String, String> map;
        int i;
        Notification notification;
        StringBuilder sb;
        String str;
        Map<String, String> m446a;
        long currentTimeMillis;
        String str2;
        String a2;
        ao a3;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, null, context, ibVar, bArr)) == null) {
            c cVar = new c();
            g.a a4 = com.xiaomi.push.g.a(context, a(ibVar), true);
            hs m488a = ibVar.m488a();
            if (m488a != null) {
                i = m488a.c();
                map = m488a.m446a();
            } else {
                map = null;
                i = 0;
            }
            int hashCode = ((a(ibVar).hashCode() / 10) * 10) + i;
            if (com.xiaomi.push.l.m574a(context) && a4 == g.a.c) {
                if (m488a != null) {
                    el.a(context.getApplicationContext()).a(ibVar.b(), b(ibVar), m488a.m445a(), "10:" + a(ibVar));
                }
                str4 = "Do not notify because user block " + a(ibVar) + "‘s notification";
            } else if (com.xiaomi.push.l.m574a(context) && f853a != null && f853a.m620a(context, hashCode, a(ibVar), map)) {
                if (m488a != null) {
                    el.a(context.getApplicationContext()).a(ibVar.b(), b(ibVar), m488a.m445a(), "14:" + a(ibVar));
                }
                str4 = "Do not notify because card notification is canceled or sequence incorrect";
            } else {
                RemoteViews a5 = a(context, ibVar, bArr);
                PendingIntent a6 = a(context, ibVar, ibVar.b(), bArr, hashCode);
                if (a6 != null) {
                    if (Build.VERSION.SDK_INT >= 11) {
                        b a7 = a(context, ibVar, bArr, a5, a6, hashCode);
                        cVar.a = a7.a;
                        cVar.f859a = a(ibVar);
                        notification = a7.f858a;
                    } else {
                        notification = new Notification(b(context, a(ibVar)), null, System.currentTimeMillis());
                        String[] a8 = a(context, m488a);
                        try {
                            notification.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context, a8[0], a8[1], a6);
                        } catch (IllegalAccessException e) {
                            e = e;
                            if (m488a != null) {
                                el.a(context.getApplicationContext()).b(ibVar.b(), b(ibVar), m488a.m445a(), "5");
                            }
                            sb = new StringBuilder();
                            str = "meet illegal access error. ";
                            sb.append(str);
                            sb.append(e);
                            com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                            m446a = m488a.m446a();
                            if (m446a != null) {
                                notification.tickerText = m446a.get(ALaKeepAliveService.KEY_TICKER);
                            }
                            currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - a > 10000) {
                            }
                            notification.flags |= 16;
                            if (a5 != null) {
                            }
                            if (com.xiaomi.push.l.m573a()) {
                                if (!TextUtils.isEmpty(m488a.m445a())) {
                                }
                                notification.extras.putString("local_paid", ibVar.m489a());
                                if (m488a.m451b() != null) {
                                }
                                if (!TextUtils.isEmpty(str3)) {
                                }
                                notification.extras.putString("pushUid", a(m488a.f525a, "n_stats_expose"));
                                int i2 = -1;
                                if (!c(ibVar)) {
                                }
                                notification.extras.putString("eventMessageType", String.valueOf(i2));
                                notification.extras.putString("target_package", a(ibVar));
                            }
                            if (m488a.m446a() == null) {
                            }
                            if (com.xiaomi.push.l.m573a()) {
                                try {
                                    a(notification, Integer.parseInt(str2));
                                } catch (NumberFormatException e2) {
                                    if (m488a != null) {
                                        el.a(context.getApplicationContext()).b(ibVar.b(), b(ibVar), m488a.m445a(), "8");
                                    }
                                    com.xiaomi.channel.commonutils.logger.b.d("fail to set message count. " + e2);
                                }
                            }
                            if (!com.xiaomi.push.l.c()) {
                                a(notification, a(ibVar));
                            }
                            a2 = a(ibVar);
                            a3 = ao.a(context, a2);
                            if (com.xiaomi.push.l.m574a(context)) {
                                f853a.a(m488a.m446a(), hashCode, notification);
                            }
                            if (com.xiaomi.push.l.m574a(context)) {
                            }
                            a3.a(hashCode, notification);
                            if (com.xiaomi.push.l.m573a()) {
                                al.a().a(context, hashCode, notification);
                                if (Build.VERSION.SDK_INT >= 26) {
                                    b(context, a2, hashCode, m488a.m445a(), notification);
                                }
                            }
                            if (m613a(ibVar)) {
                            }
                            if (c(ibVar)) {
                            }
                            if (Build.VERSION.SDK_INT < 26) {
                            }
                            Pair<Integer, ib> pair = new Pair<>(Integer.valueOf(hashCode), ibVar);
                            synchronized (f854a) {
                            }
                        } catch (IllegalArgumentException e3) {
                            e = e3;
                            if (m488a != null) {
                                el.a(context.getApplicationContext()).b(ibVar.b(), b(ibVar), m488a.m445a(), "6");
                            }
                            sb = new StringBuilder();
                            str = "meet illegal argument error. ";
                            sb.append(str);
                            sb.append(e);
                            com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                            m446a = m488a.m446a();
                            if (m446a != null) {
                            }
                            currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - a > 10000) {
                            }
                            notification.flags |= 16;
                            if (a5 != null) {
                            }
                            if (com.xiaomi.push.l.m573a()) {
                            }
                            if (m488a.m446a() == null) {
                            }
                            if (com.xiaomi.push.l.m573a()) {
                            }
                            if (!com.xiaomi.push.l.c()) {
                            }
                            a2 = a(ibVar);
                            a3 = ao.a(context, a2);
                            if (com.xiaomi.push.l.m574a(context)) {
                            }
                            if (com.xiaomi.push.l.m574a(context)) {
                            }
                            a3.a(hashCode, notification);
                            if (com.xiaomi.push.l.m573a()) {
                            }
                            if (m613a(ibVar)) {
                            }
                            if (c(ibVar)) {
                            }
                            if (Build.VERSION.SDK_INT < 26) {
                            }
                            Pair<Integer, ib> pair2 = new Pair<>(Integer.valueOf(hashCode), ibVar);
                            synchronized (f854a) {
                            }
                        } catch (NoSuchMethodException e4) {
                            e = e4;
                            if (m488a != null) {
                                el.a(context.getApplicationContext()).b(ibVar.b(), b(ibVar), m488a.m445a(), "4");
                            }
                            sb = new StringBuilder();
                            str = "meet no such method error. ";
                            sb.append(str);
                            sb.append(e);
                            com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                            m446a = m488a.m446a();
                            if (m446a != null) {
                            }
                            currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - a > 10000) {
                            }
                            notification.flags |= 16;
                            if (a5 != null) {
                            }
                            if (com.xiaomi.push.l.m573a()) {
                            }
                            if (m488a.m446a() == null) {
                            }
                            if (com.xiaomi.push.l.m573a()) {
                            }
                            if (!com.xiaomi.push.l.c()) {
                            }
                            a2 = a(ibVar);
                            a3 = ao.a(context, a2);
                            if (com.xiaomi.push.l.m574a(context)) {
                            }
                            if (com.xiaomi.push.l.m574a(context)) {
                            }
                            a3.a(hashCode, notification);
                            if (com.xiaomi.push.l.m573a()) {
                            }
                            if (m613a(ibVar)) {
                            }
                            if (c(ibVar)) {
                            }
                            if (Build.VERSION.SDK_INT < 26) {
                            }
                            Pair<Integer, ib> pair22 = new Pair<>(Integer.valueOf(hashCode), ibVar);
                            synchronized (f854a) {
                            }
                        } catch (InvocationTargetException e5) {
                            e = e5;
                            if (m488a != null) {
                                el.a(context.getApplicationContext()).b(ibVar.b(), b(ibVar), m488a.m445a(), "7");
                            }
                            sb = new StringBuilder();
                            str = "meet invocation target error. ";
                            sb.append(str);
                            sb.append(e);
                            com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                            m446a = m488a.m446a();
                            if (m446a != null) {
                            }
                            currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - a > 10000) {
                            }
                            notification.flags |= 16;
                            if (a5 != null) {
                            }
                            if (com.xiaomi.push.l.m573a()) {
                            }
                            if (m488a.m446a() == null) {
                            }
                            if (com.xiaomi.push.l.m573a()) {
                            }
                            if (!com.xiaomi.push.l.c()) {
                            }
                            a2 = a(ibVar);
                            a3 = ao.a(context, a2);
                            if (com.xiaomi.push.l.m574a(context)) {
                            }
                            if (com.xiaomi.push.l.m574a(context)) {
                            }
                            a3.a(hashCode, notification);
                            if (com.xiaomi.push.l.m573a()) {
                            }
                            if (m613a(ibVar)) {
                            }
                            if (c(ibVar)) {
                            }
                            if (Build.VERSION.SDK_INT < 26) {
                            }
                            Pair<Integer, ib> pair222 = new Pair<>(Integer.valueOf(hashCode), ibVar);
                            synchronized (f854a) {
                            }
                        }
                        m446a = m488a.m446a();
                        if (m446a != null && m446a.containsKey(ALaKeepAliveService.KEY_TICKER)) {
                            notification.tickerText = m446a.get(ALaKeepAliveService.KEY_TICKER);
                        }
                        currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - a > 10000) {
                            a = currentTimeMillis;
                            int i3 = m488a.f521a;
                            if (m616b(context, a(ibVar))) {
                                i3 = a(context, a(ibVar));
                            }
                            notification.defaults = i3;
                            if (m446a != null && (i3 & 1) != 0) {
                                String str5 = m446a.get("sound_uri");
                                if (!TextUtils.isEmpty(str5)) {
                                    if (str5.startsWith("android.resource://" + a(ibVar))) {
                                        notification.defaults = 1 ^ i3;
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
                    if (com.xiaomi.push.l.m573a() && Build.VERSION.SDK_INT >= 19) {
                        if (!TextUtils.isEmpty(m488a.m445a())) {
                            notification.extras.putString("message_id", m488a.m445a());
                        }
                        notification.extras.putString("local_paid", ibVar.m489a());
                        str3 = m488a.m451b() != null ? null : m488a.m451b().get("score_info");
                        if (!TextUtils.isEmpty(str3)) {
                            notification.extras.putString("score_info", str3);
                        }
                        notification.extras.putString("pushUid", a(m488a.f525a, "n_stats_expose"));
                        int i22 = -1;
                        if (!c(ibVar)) {
                            i22 = 1000;
                        } else if (m613a(ibVar)) {
                            i22 = 3000;
                        }
                        notification.extras.putString("eventMessageType", String.valueOf(i22));
                        notification.extras.putString("target_package", a(ibVar));
                    }
                    str2 = m488a.m446a() == null ? null : m488a.m446a().get("message_count");
                    if (com.xiaomi.push.l.m573a() && str2 != null) {
                        a(notification, Integer.parseInt(str2));
                    }
                    if (!com.xiaomi.push.l.c() && com.xiaomi.push.l.m574a(context)) {
                        a(notification, a(ibVar));
                    }
                    a2 = a(ibVar);
                    a3 = ao.a(context, a2);
                    if (com.xiaomi.push.l.m574a(context) && f853a != null) {
                        f853a.a(m488a.m446a(), hashCode, notification);
                    }
                    if (com.xiaomi.push.l.m574a(context) || f853a == null || !f853a.m621a(m488a.m446a(), hashCode, notification)) {
                        a3.a(hashCode, notification);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.b("consume this notificaiton by agent");
                    }
                    if (com.xiaomi.push.l.m573a() && com.xiaomi.push.l.m574a(context)) {
                        al.a().a(context, hashCode, notification);
                        if (Build.VERSION.SDK_INT >= 26 && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
                            b(context, a2, hashCode, m488a.m445a(), notification);
                        }
                    }
                    if (m613a(ibVar)) {
                        el.a(context.getApplicationContext()).a(ibVar.b(), b(ibVar), m488a.m445a(), 3002, null);
                    }
                    if (c(ibVar)) {
                        el.a(context.getApplicationContext()).a(ibVar.b(), b(ibVar), m488a.m445a(), 1002, null);
                    }
                    if (Build.VERSION.SDK_INT < 26) {
                        String m445a = m488a != null ? m488a.m445a() : null;
                        com.xiaomi.push.ai a9 = com.xiaomi.push.ai.a(context);
                        int a10 = a(m488a.m446a());
                        if (a10 > 0 && !TextUtils.isEmpty(m445a)) {
                            String str6 = "n_timeout_" + m445a;
                            a9.m181a(str6);
                            a9.b(new ad(str6, a3, hashCode), a10);
                        }
                    }
                    Pair<Integer, ib> pair2222 = new Pair<>(Integer.valueOf(hashCode), ibVar);
                    synchronized (f854a) {
                        f854a.add(pair2222);
                        if (f854a.size() > 100) {
                            f854a.remove();
                        }
                    }
                    return cVar;
                }
                if (m488a != null) {
                    el.a(context.getApplicationContext()).a(ibVar.b(), b(ibVar), m488a.m445a(), "11");
                }
                str4 = "The click PendingIntent is null. ";
            }
            com.xiaomi.channel.commonutils.logger.b.m108a(str4);
            return cVar;
        }
        return (c) invokeLLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m609a(Context context, String str, Map<String, String> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65558, null, context, str, map)) == null) ? (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? com.xiaomi.push.g.m379b(context, str) : map.get("channel_name") : (String) invokeLLL.objValue;
    }

    public static String a(ib ibVar) {
        InterceptResult invokeL;
        hs m488a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, ibVar)) == null) {
            if ("com.xiaomi.xmsf".equals(ibVar.f619b) && (m488a = ibVar.m488a()) != null && m488a.m446a() != null) {
                String str = m488a.m446a().get("miui_package_name");
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
            return ibVar.f619b;
        }
        return (String) invokeL.objValue;
    }

    public static String a(Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, map, str)) == null) {
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static void a(Notification notification, int i) {
        Object a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65561, null, notification, i) == null) || (a2 = com.xiaomi.push.bh.a(notification, "extraNotification")) == null) {
            return;
        }
        com.xiaomi.push.bh.a(a2, "setMessageCount", Integer.valueOf(i));
    }

    public static void a(Context context, Intent intent, ib ibVar, hs hsVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65562, null, context, intent, ibVar, hsVar) == null) || ibVar == null || hsVar == null) {
            return;
        }
        String a2 = a(hsVar.m446a(), "notify_effect");
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (az.a.equals(a2) || az.b.equals(a2) || az.c.equals(a2)) {
            intent.putExtra("local_paid", ibVar.f615a);
            if (!TextUtils.isEmpty(ibVar.f619b)) {
                intent.putExtra("target_package", ibVar.f619b);
            }
            intent.putExtra("job_key", a(hsVar.m446a(), "jobkey"));
            intent.putExtra("target_component", a(context, ibVar.f619b, hsVar.m446a()));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m610a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, context, str) == null) {
            a(context, str, -1);
        }
    }

    public static void a(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65564, null, context, str, i) == null) {
            ao a2 = ao.a(context, str);
            int hashCode = ((str.hashCode() / 10) * 10) + i;
            LinkedList linkedList = new LinkedList();
            if (i >= 0) {
                a2.a(hashCode);
            }
            synchronized (f854a) {
                Iterator<Pair<Integer, ib>> it = f854a.iterator();
                while (it.hasNext()) {
                    Pair<Integer, ib> next = it.next();
                    ib ibVar = (ib) next.second;
                    if (ibVar != null) {
                        String a3 = a(ibVar);
                        if (i >= 0) {
                            if (hashCode == ((Integer) next.first).intValue() && TextUtils.equals(a3, str)) {
                                linkedList.add(next);
                            }
                        } else if (i == -1 && TextUtils.equals(a3, str)) {
                            a2.a(((Integer) next.first).intValue());
                            linkedList.add(next);
                        }
                    }
                }
                if (f854a != null) {
                    f854a.removeAll(linkedList);
                    a(context, linkedList);
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65566, null, context, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                return;
            }
            LinkedList linkedList = new LinkedList();
            synchronized (f854a) {
                Iterator<Pair<Integer, ib>> it = f854a.iterator();
                while (it.hasNext()) {
                    Pair<Integer, ib> next = it.next();
                    ib ibVar = (ib) next.second;
                    if (ibVar != null) {
                        String a2 = a(ibVar);
                        hs m488a = ibVar.m488a();
                        if (m488a != null && TextUtils.equals(a2, str)) {
                            String m453c = m488a.m453c();
                            String d = m488a.d();
                            if (!TextUtils.isEmpty(m453c) && !TextUtils.isEmpty(d) && a(str2, m453c) && a(str3, d)) {
                                ao.a(context, str).a(((Integer) next.first).intValue());
                                linkedList.add(next);
                            }
                        }
                    }
                }
                if (f854a != null) {
                    f854a.removeAll(linkedList);
                    a(context, linkedList);
                }
            }
        }
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65567, null, context, linkedList) == null) || linkedList == null || linkedList.size() <= 0) {
            return;
        }
        bm.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    public static void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, intent) == null) {
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
    public static void a(en enVar, Context context, String str, ib ibVar, byte[] bArr, int i) {
        PendingIntent a2;
        PendingIntent a3;
        PendingIntent a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65569, null, new Object[]{enVar, context, str, ibVar, bArr, Integer.valueOf(i)}) == null) {
            Map<String, String> m446a = ibVar.m488a().m446a();
            if (TextUtils.equals("3", m446a.get("notification_style_type")) || TextUtils.equals("4", m446a.get("notification_style_type"))) {
                return;
            }
            if (!TextUtils.isEmpty(m446a.get("notification_style_button_left_name")) && (a4 = a(context, str, ibVar, bArr, i, 1)) != null) {
                enVar.addAction(0, m446a.get("notification_style_button_left_name"), a4);
            }
            if (!TextUtils.isEmpty(m446a.get("notification_style_button_mid_name")) && (a3 = a(context, str, ibVar, bArr, i, 2)) != null) {
                enVar.addAction(0, m446a.get("notification_style_button_mid_name"), a3);
            }
            if (TextUtils.isEmpty(m446a.get("notification_style_button_right_name")) || (a2 = a(context, str, ibVar, bArr, i, 3)) == null) {
                return;
            }
            enVar.addAction(0, m446a.get("notification_style_button_right_name"), a2);
        }
    }

    public static boolean a(Context context, ib ibVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65570, null, context, ibVar, str)) == null) {
            if (ibVar != null && ibVar.m488a() != null && ibVar.m488a().m446a() != null && !TextUtils.isEmpty(str)) {
                return Boolean.parseBoolean(ibVar.m488a().m446a().get("use_clicked_activity")) && g.a(context, a(str));
            }
            com.xiaomi.channel.commonutils.logger.b.m108a("should clicked activity params are null.");
            return false;
        }
        return invokeLLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m612a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, context, str)) == null) {
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

    public static boolean a(hs hsVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, hsVar)) == null) {
            if (hsVar != null) {
                String m445a = hsVar.m445a();
                return !TextUtils.isEmpty(m445a) && m445a.length() == 22 && "satuigmo".indexOf(m445a.charAt(0)) >= 0;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m613a(ib ibVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, ibVar)) == null) {
            hs m488a = ibVar.m488a();
            return a(m488a) && m488a.l();
        }
        return invokeL.booleanValue;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, str, str2)) == null) ? TextUtils.isEmpty(str) || str2.contains(str) : invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m614a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, map)) == null) {
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
    public static String[] a(Context context, hs hsVar) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, context, hsVar)) == null) {
            String m453c = hsVar.m453c();
            String d = hsVar.d();
            Map<String, String> m446a = hsVar.m446a();
            if (m446a != null) {
                int intValue = Float.valueOf((context.getResources().getDisplayMetrics().widthPixels / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
                if (intValue <= 320) {
                    String str2 = m446a.get("title_short");
                    if (!TextUtils.isEmpty(str2)) {
                        m453c = str2;
                    }
                    str = m446a.get("description_short");
                } else if (intValue > 360) {
                    String str3 = m446a.get("title_long");
                    if (!TextUtils.isEmpty(str3)) {
                        m453c = str3;
                    }
                    str = m446a.get("description_long");
                }
            }
            return new String[]{m453c, d};
        }
        return (String[]) invokeLL.objValue;
    }

    public static int b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, context, str)) == null) {
            int a2 = a(context, str, "mipush_notification");
            int a3 = a(context, str, "mipush_small_notification");
            if (a2 <= 0) {
                a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
            }
            return (a2 != 0 || Build.VERSION.SDK_INT < 9) ? a2 : context.getApplicationInfo().logo;
        }
        return invokeLL.intValue;
    }

    public static int b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, map)) == null) {
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

    public static String b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65579, null, i, str)) == null) {
            return "n_top_update_" + i + "_" + str;
        }
        return (String) invokeIL.objValue;
    }

    public static String b(ib ibVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65580, null, ibVar)) == null) ? m613a(ibVar) ? "E100002" : c(ibVar) ? "E100000" : m617b(ibVar) ? "E100001" : d(ibVar) ? "E100003" : "" : (String) invokeL.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static void m615b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65581, null, context, str) == null) {
            context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
        }
    }

    public static void b(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65582, null, context, str, i) == null) {
            context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
        }
    }

    @TargetApi(19)
    public static void b(Context context, String str, int i, String str2, Notification notification) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65583, null, new Object[]{context, str, Integer.valueOf(i), str2, notification}) == null) {
            Notification notification2 = notification;
            if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || ao.a(context, str) == null || Build.VERSION.SDK_INT < 26) {
                return;
            }
            ao a2 = ao.a(context, str);
            if (notification2 == null) {
                List<StatusBarNotification> m635b = a2.m635b();
                if (m635b == null) {
                    return;
                }
                Iterator<StatusBarNotification> it = m635b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        notification2 = null;
                        break;
                    }
                    StatusBarNotification next = it.next();
                    Notification notification3 = next.getNotification();
                    String string = notification3.extras.getString("message_id");
                    if (i == next.getId() && str2.equals(string)) {
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
                int i2 = notification2.extras.getInt("mipush_n_top_fre", 0);
                int i3 = notification2.extras.getInt("mipush_n_top_prd", 0);
                if (i3 <= 0 || i3 < i2) {
                    return;
                }
                long j2 = (i3 * 1000) + j;
                if (j >= currentTimeMillis || currentTimeMillis >= j2) {
                    i3 = 0;
                } else if (i2 > 0 && (i3 = (int) Math.min((j2 - currentTimeMillis) / 1000, i2)) > 0 && !z) {
                    notification2.when = currentTimeMillis;
                    com.xiaomi.channel.commonutils.logger.b.m108a("update top notification: " + str2);
                    a2.a(i, notification2);
                }
                if (i3 > 0) {
                    com.xiaomi.channel.commonutils.logger.b.m108a("schedule top notification next update delay: " + i3);
                    com.xiaomi.push.ai.a(context).m181a(b(i, str2));
                    com.xiaomi.push.ai.a(context).b(a(context, str, i, str2, (Notification) null), i3);
                    return;
                }
                String a3 = ak.a(a2);
                Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, notification2);
                recoverBuilder.setChannelId(a3);
                recoverBuilder.setPriority(0);
                com.xiaomi.channel.commonutils.logger.b.m108a("update top notification to common: " + str2);
                a2.a(i, recoverBuilder.build());
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m616b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65584, null, context, str)) == null) ? context.getSharedPreferences("pref_notify_type", 0).contains(str) : invokeLL.booleanValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m617b(ib ibVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, ibVar)) == null) {
            hs m488a = ibVar.m488a();
            return a(m488a) && m488a.f527b == 1 && !m613a(ibVar);
        }
        return invokeL.booleanValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m618b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, map)) == null) {
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
        return invokeL.booleanValue;
    }

    public static int c(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, map)) == null) {
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

    public static boolean c(ib ibVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, ibVar)) == null) {
            hs m488a = ibVar.m488a();
            return a(m488a) && m488a.f527b == 0 && !m613a(ibVar);
        }
        return invokeL.booleanValue;
    }

    public static int d(Map<String, String> map) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, map)) == null) {
            if (map != null) {
                String str = map.get("notification_top_frequency");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        com.xiaomi.channel.commonutils.logger.b.c("fre of top notification is " + str);
                        i = Integer.parseInt(str);
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.d("parsing top notification frequency error: " + e);
                    }
                    return Math.max(0, i);
                }
            }
            i = 0;
            return Math.max(0, i);
        }
        return invokeL.intValue;
    }

    public static boolean d(ib ibVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65590, null, ibVar)) == null) ? ibVar.a() == hf.a : invokeL.booleanValue;
    }

    public static int e(Map<String, String> map) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, map)) == null) {
            if (map != null) {
                String str = map.get("notification_top_period");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        com.xiaomi.channel.commonutils.logger.b.c("prd of top notification is " + str);
                        i = Integer.parseInt(str);
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.d("parsing top notification period error: " + e);
                    }
                    return Math.max(0, i);
                }
            }
            i = 0;
            return Math.max(0, i);
        }
        return invokeL.intValue;
    }

    public static boolean e(ib ibVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65592, null, ibVar)) == null) ? m613a(ibVar) || c(ibVar) || m617b(ibVar) : invokeL.booleanValue;
    }
}
