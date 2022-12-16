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
import com.xiaomi.push.ho;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes8.dex */
public class ax {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;

    /* renamed from: a  reason: collision with other field name */
    public static Object f936a;

    /* renamed from: a  reason: collision with other field name */
    public static WeakHashMap<Integer, ax> f937a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f938a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public String f939a;
    public String b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071162767, "Lcom/xiaomi/push/service/ax;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071162767, "Lcom/xiaomi/push/service/ax;");
                return;
            }
        }
        f937a = new WeakHashMap<>();
    }

    public ax(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f939a = str;
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

    public static ax a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            a(context);
            int hashCode = str.hashCode();
            ax axVar = f937a.get(Integer.valueOf(hashCode));
            if (axVar == null) {
                ax axVar2 = new ax(str);
                f937a.put(Integer.valueOf(hashCode), axVar2);
                return axVar2;
            }
            return axVar;
        }
        return (ax) invokeLL.objValue;
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
            Boolean bool = (Boolean) com.xiaomi.push.bk.a((Object) a2, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m631a("fwk is support.init:" + bool);
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            f938a = booleanValue;
            if (booleanValue) {
                f936a = com.xiaomi.push.bk.a((Object) a2, "getService", new Object[0]);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m631a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            com.xiaomi.channel.commonutils.logger.b.m99a("NMHelper:" + str);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m632a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (com.xiaomi.push.m.m570a() && ba.a(a).a(ho.aZ.a(), true)) {
                return f938a;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m633a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            a(context);
            return m632a();
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private StatusBarNotification[] m634a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (com.xiaomi.push.m.m571a(m636a())) {
                try {
                    Object a2 = com.xiaomi.push.bk.a(f936a, "getActiveNotifications", m636a().getPackageName());
                    if (a2 instanceof StatusBarNotification[]) {
                        return (StatusBarNotification[]) a2;
                    }
                    return null;
                } catch (Throwable th) {
                    m631a("getAllNotifications error " + th);
                    return null;
                }
            }
            return null;
        }
        return (StatusBarNotification[]) invokeV.objValue;
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, str)) == null) {
            return a(m632a() ? "mipush|%s|%s" : "mipush_%s_%s", this.f939a, str);
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public NotificationChannel m635a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            NotificationChannel notificationChannel = null;
            try {
                if (m632a()) {
                    List<NotificationChannel> m639a = m639a();
                    if (m639a != null) {
                        for (NotificationChannel notificationChannel2 : m639a) {
                            if (str.equals(notificationChannel2.getId())) {
                                notificationChannel = notificationChannel2;
                                break;
                            }
                        }
                    }
                } else {
                    notificationChannel = a().getNotificationChannel(str);
                }
            } catch (Exception e) {
                m631a("getNotificationChannel error" + e);
            }
            return notificationChannel;
        }
        return (NotificationChannel) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Context m636a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a : (Context) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m637a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f939a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m638a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? TextUtils.isEmpty(str) ? b() : com.xiaomi.push.m.m571a(m636a()) ? b(str) : str : (String) invokeL.objValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:12:0x003a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @android.annotation.TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public java.util.List<android.app.NotificationChannel> m639a() {
        /*
            r8 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.xiaomi.push.service.ax.$ic
            if (r0 != 0) goto L92
        L4:
            java.lang.String r0 = r8.f939a
            r1 = 0
            boolean r2 = m632a()     // Catch: java.lang.Exception -> L7c
            if (r2 == 0) goto L3f
            int r2 = a(r0)     // Catch: java.lang.Exception -> L7c
            r3 = -1
            if (r2 == r3) goto L3d
            java.lang.Object r3 = com.xiaomi.push.service.ax.f936a     // Catch: java.lang.Exception -> L7c
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
            java.lang.Object r2 = com.xiaomi.push.bk.a(r3, r4, r5)     // Catch: java.lang.Exception -> L7c
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
            boolean r3 = com.xiaomi.push.m.m570a()     // Catch: java.lang.Exception -> L7c
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
            m631a(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ax.m639a():java.util.List");
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            String str = this.f939a;
            try {
                if (!m632a()) {
                    a().cancel(i);
                    return;
                }
                int a2 = com.xiaomi.push.j.a();
                String packageName = m636a().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    com.xiaomi.push.bk.b(f936a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i), Integer.valueOf(a2));
                } else {
                    com.xiaomi.push.bk.b(f936a, "cancelNotificationWithTag", str, null, Integer.valueOf(i), Integer.valueOf(a2));
                }
                m631a("cancel succ:" + i);
            } catch (Exception e) {
                m631a("cancel error" + e);
            }
        }
    }

    public void a(int i, Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, notification) == null) {
            String str = this.f939a;
            NotificationManager a2 = a();
            try {
                int i2 = Build.VERSION.SDK_INT;
                if (m632a()) {
                    if (i2 >= 19) {
                        notification.extras.putString("xmsf_target_package", str);
                    }
                    if (i2 >= 29) {
                        a2.notifyAsPackage(str, null, i, notification);
                        return;
                    }
                }
                a2.notify(i, notification);
            } catch (Exception unused) {
            }
        }
    }

    @TargetApi(26)
    public void a(NotificationChannel notificationChannel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, notificationChannel) == null) {
            String str = this.f939a;
            try {
                if (m632a()) {
                    int a2 = a(str);
                    if (a2 != -1) {
                        com.xiaomi.push.bk.b(f936a, "createNotificationChannelsForPackage", str, Integer.valueOf(a2), a(Arrays.asList(notificationChannel)));
                    }
                } else {
                    a().createNotificationChannel(notificationChannel);
                }
            } catch (Exception e) {
                m631a("createNotificationChannel error" + e);
            }
        }
    }

    public void a(NotificationChannel notificationChannel, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, notificationChannel, z) == null) {
            String str = this.f939a;
            try {
                if (z) {
                    int a2 = a(str);
                    if (a2 != -1) {
                        com.xiaomi.push.bk.b(f936a, "updateNotificationChannelForPackage", str, Integer.valueOf(a2), notificationChannel);
                    }
                } else {
                    a(notificationChannel);
                }
            } catch (Exception e) {
                m631a("updateNotificationChannel error " + e);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m640a(String str) {
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
            if (TextUtils.isEmpty(this.b)) {
                this.b = b("default");
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) ? m632a() ? str : str2 : (String) invokeLL.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public List<StatusBarNotification> m641b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048588, this)) != null) {
            return (List) invokeV.objValue;
        }
        String str = this.f939a;
        NotificationManager a2 = a();
        ArrayList arrayList = null;
        try {
            if (m632a()) {
                int a3 = com.xiaomi.push.j.a();
                if (a3 != -1) {
                    return (List) a(com.xiaomi.push.bk.a(f936a, "getAppActiveNotifications", str, Integer.valueOf(a3)));
                }
                return null;
            }
            StatusBarNotification[] activeNotifications = Build.VERSION.SDK_INT >= 23 ? a2.getActiveNotifications() : m634a();
            boolean m570a = com.xiaomi.push.m.m570a();
            if (activeNotifications == null || activeNotifications.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (!m570a || str.equals(ay.c(statusBarNotification.getNotification()))) {
                        arrayList2.add(statusBarNotification);
                    }
                }
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                arrayList = arrayList2;
                m631a("getActiveNotifications error " + th);
                return arrayList;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "NotificationManagerHelper{" + this.f939a + "}";
        }
        return (String) invokeV.objValue;
    }
}
