package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.hk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes8.dex */
public class ao {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;

    /* renamed from: a  reason: collision with other field name */
    public static Object f898a;

    /* renamed from: a  reason: collision with other field name */
    public static WeakHashMap<Integer, ao> f899a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f900a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public String f901a;

    /* renamed from: b  reason: collision with root package name */
    public String f59978b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071162488, "Lcom/xiaomi/push/service/ao;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071162488, "Lcom/xiaomi/push/service/ao;");
                return;
            }
        }
        f899a = new WeakHashMap<>();
    }

    public ao(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f901a = str;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    return a.getPackageManager().getPackageUid(str, 0);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static NotificationManager a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NotificationManager) a.getSystemService(ActionJsonData.TAG_NOTIFICATION) : (NotificationManager) invokeV.objValue;
    }

    public static ao a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            a(context);
            int hashCode = str.hashCode();
            ao aoVar = f899a.get(Integer.valueOf(hashCode));
            if (aoVar == null) {
                ao aoVar2 = new ao(str);
                f899a.put(Integer.valueOf(hashCode), aoVar2);
                return aoVar2;
            }
            return aoVar;
        }
        return (ao) invokeLL.objValue;
    }

    public static <T> T a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) {
            if (obj != null) {
                try {
                    return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static Object a(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, list)) == null) ? Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list) : invokeL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String a2 = a("mipush|%s|%s", str2, "");
            return str.startsWith(a2) ? a("mipush_%s_%s", str2, str.replace(a2, "")) : str;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, str, str2, str3)) == null) ? TextUtils.isEmpty(str) ? "" : String.format(str, str2, str3) : (String) invokeLLL.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, context) == null) && a == null) {
            a = context.getApplicationContext();
            NotificationManager a2 = a();
            Boolean bool = (Boolean) com.xiaomi.push.bh.a((Object) a2, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m651a("fwk is support.init:" + bool);
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            f900a = booleanValue;
            if (booleanValue) {
                f898a = com.xiaomi.push.bh.a((Object) a2, "getService", new Object[0]);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m651a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            com.xiaomi.channel.commonutils.logger.b.m133a("NMHelper:" + str);
        }
    }

    @TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public static boolean m652a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (com.xiaomi.push.l.m598a() && aq.a(a).a(hk.aZ.a(), true)) {
                return f900a;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m653a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            a(context);
            return m652a();
        }
        return invokeL.booleanValue;
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) {
            return a(m652a() ? "mipush|%s|%s" : "mipush_%s_%s", this.f901a, str);
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public NotificationChannel m654a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            NotificationChannel notificationChannel = null;
            try {
                if (m652a()) {
                    List<NotificationChannel> m658a = m658a();
                    if (m658a != null) {
                        for (NotificationChannel notificationChannel2 : m658a) {
                            if (str.equals(notificationChannel2.getId())) {
                                notificationChannel = notificationChannel2;
                                break;
                            }
                        }
                    }
                } else {
                    notificationChannel = a().getNotificationChannel(str);
                }
            } catch (Exception e2) {
                m651a("getNotificationChannel error" + e2);
            }
            return notificationChannel;
        }
        return (NotificationChannel) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Context m655a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a : (Context) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m656a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f901a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m657a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? TextUtils.isEmpty(str) ? b() : com.xiaomi.push.l.m598a() ? b(str) : str : (String) invokeL.objValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:12:0x003a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @android.annotation.TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public java.util.List<android.app.NotificationChannel> m658a() {
        /*
            r8 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.xiaomi.push.service.ao.$ic
            if (r0 != 0) goto L92
        L4:
            java.lang.String r0 = r8.f901a
            r1 = 0
            boolean r2 = m652a()     // Catch: java.lang.Exception -> L7c
            if (r2 == 0) goto L3f
            int r2 = a(r0)     // Catch: java.lang.Exception -> L7c
            r3 = -1
            if (r2 == r3) goto L3d
            java.lang.Object r3 = com.xiaomi.push.service.ao.f898a     // Catch: java.lang.Exception -> L7c
            java.lang.String r4 = "getNotificationChannelsForPackage"
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L7c
            r6 = 0
            r5[r6] = r0     // Catch: java.lang.Exception -> L7c
            r6 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L7c
            r5[r6] = r2     // Catch: java.lang.Exception -> L7c
            r2 = 2
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> L7c
            r5[r2] = r6     // Catch: java.lang.Exception -> L7c
            java.lang.Object r2 = com.xiaomi.push.bh.a(r3, r4, r5)     // Catch: java.lang.Exception -> L7c
            java.lang.Object r2 = a(r2)     // Catch: java.lang.Exception -> L7c
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Exception -> L7c
            java.lang.String r1 = "mipush|%s|%s"
            r7 = r2
            r2 = r1
            r1 = r7
            goto L49
        L3a:
            r0 = move-exception
            r1 = r2
            goto L7d
        L3d:
            r2 = r1
            goto L49
        L3f:
            android.app.NotificationManager r2 = a()     // Catch: java.lang.Exception -> L7c
            java.util.List r1 = r2.getNotificationChannels()     // Catch: java.lang.Exception -> L7c
            java.lang.String r2 = "mipush_%s_%s"
        L49:
            boolean r3 = com.xiaomi.push.l.m598a()     // Catch: java.lang.Exception -> L7c
            if (r3 == 0) goto L91
            if (r1 == 0) goto L91
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Exception -> L7c
            r3.<init>()     // Catch: java.lang.Exception -> L7c
            java.lang.String r4 = ""
            java.lang.String r0 = a(r2, r0, r4)     // Catch: java.lang.Exception -> L7c
            java.util.Iterator r2 = r1.iterator()     // Catch: java.lang.Exception -> L7c
        L60:
            boolean r4 = r2.hasNext()     // Catch: java.lang.Exception -> L7c
            if (r4 == 0) goto L7a
            java.lang.Object r4 = r2.next()     // Catch: java.lang.Exception -> L7c
            android.app.NotificationChannel r4 = (android.app.NotificationChannel) r4     // Catch: java.lang.Exception -> L7c
            java.lang.String r5 = r4.getId()     // Catch: java.lang.Exception -> L7c
            boolean r5 = r5.startsWith(r0)     // Catch: java.lang.Exception -> L7c
            if (r5 == 0) goto L60
            r3.add(r4)     // Catch: java.lang.Exception -> L7c
            goto L60
        L7a:
            r1 = r3
            goto L91
        L7c:
            r0 = move-exception
        L7d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getNotificationChannels error "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            m651a(r0)
        L91:
            return r1
        L92:
            r6 = r0
            r7 = 1048580(0x100004, float:1.469374E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r6.invokeV(r7, r8)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            java.util.List r1 = (java.util.List) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ao.m658a():java.util.List");
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            String str = this.f901a;
            try {
                if (!m652a()) {
                    a().cancel(i2);
                    return;
                }
                int a2 = com.xiaomi.push.i.a();
                String packageName = m655a().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    com.xiaomi.push.bh.b(f898a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i2), Integer.valueOf(a2));
                } else {
                    com.xiaomi.push.bh.b(f898a, "cancelNotificationWithTag", str, null, Integer.valueOf(i2), Integer.valueOf(a2));
                }
                m651a("cancel succ:" + i2);
            } catch (Exception e2) {
                m651a("cancel error" + e2);
            }
        }
    }

    public void a(int i2, Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, notification) == null) {
            String str = this.f901a;
            NotificationManager a2 = a();
            try {
                int i3 = Build.VERSION.SDK_INT;
                if (m652a()) {
                    if (i3 >= 19) {
                        notification.extras.putString("xmsf_target_package", str);
                    }
                    if (i3 >= 29) {
                        a2.notifyAsPackage(str, null, i2, notification);
                        return;
                    }
                }
                a2.notify(i2, notification);
            } catch (Exception unused) {
            }
        }
    }

    @TargetApi(26)
    public void a(NotificationChannel notificationChannel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, notificationChannel) == null) {
            String str = this.f901a;
            try {
                if (m652a()) {
                    int a2 = a(str);
                    if (a2 != -1) {
                        com.xiaomi.push.bh.b(f898a, "createNotificationChannelsForPackage", str, Integer.valueOf(a2), a(Arrays.asList(notificationChannel)));
                    }
                } else {
                    a().createNotificationChannel(notificationChannel);
                }
            } catch (Exception e2) {
                m651a("createNotificationChannel error" + e2);
            }
        }
    }

    public void a(NotificationChannel notificationChannel, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, notificationChannel, z) == null) {
            String str = this.f901a;
            try {
                if (z) {
                    int a2 = a(str);
                    if (a2 != -1) {
                        com.xiaomi.push.bh.b(f898a, "updateNotificationChannelForPackage", str, Integer.valueOf(a2), notificationChannel);
                    }
                } else {
                    a(notificationChannel);
                }
            } catch (Exception e2) {
                m651a("updateNotificationChannel error " + e2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m659a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith(b(""));
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (TextUtils.isEmpty(this.f59978b)) {
                this.f59978b = b("default");
            }
            return this.f59978b;
        }
        return (String) invokeV.objValue;
    }

    public String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) ? m652a() ? str : str2 : (String) invokeLL.objValue;
    }

    @TargetApi(23)
    /* renamed from: b  reason: collision with other method in class */
    public List<StatusBarNotification> m660b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String str = this.f901a;
            NotificationManager a2 = a();
            ArrayList arrayList = null;
            try {
                if (m652a()) {
                    int a3 = com.xiaomi.push.i.a();
                    if (a3 != -1) {
                        arrayList = (List) a(com.xiaomi.push.bh.a(f898a, "getAppActiveNotifications", str, Integer.valueOf(a3)));
                    }
                } else {
                    StatusBarNotification[] activeNotifications = a2.getActiveNotifications();
                    boolean m598a = com.xiaomi.push.l.m598a();
                    if (activeNotifications != null && activeNotifications.length > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        try {
                            for (StatusBarNotification statusBarNotification : activeNotifications) {
                                if (!m598a || str.equals(ap.a(statusBarNotification.getNotification()))) {
                                    arrayList2.add(statusBarNotification);
                                }
                            }
                            arrayList = arrayList2;
                        } catch (Exception e2) {
                            e = e2;
                            arrayList = arrayList2;
                            m651a("getActiveNotifications error " + e);
                            return arrayList;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "NotificationManagerHelper{" + this.f901a + "}";
        }
        return (String) invokeV.objValue;
    }
}
