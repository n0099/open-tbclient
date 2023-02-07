package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ho;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@TargetApi(24)
/* loaded from: classes8.dex */
public class au {
    public static /* synthetic */ Interceptable $ic;
    public static au a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au a;

        /* renamed from: a  reason: collision with other field name */
        public List<b> f931a;
        public List<b> b;

        public a(au auVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {auVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = auVar;
            this.f931a = new ArrayList();
            this.b = new ArrayList();
        }

        public /* synthetic */ a(au auVar, av avVar) {
            this(auVar);
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public Notification f932a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ au f933a;

        public b(au auVar, int i, Notification notification) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {auVar, Integer.valueOf(i), notification};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f933a = auVar;
            this.a = i;
            this.f932a = notification;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "id:" + this.a;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071162674, "Lcom/xiaomi/push/service/au;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071162674, "Lcom/xiaomi/push/service/au;");
                return;
            }
        }
        a = new au();
    }

    public au() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            return ("GroupSummary" + str + str2).hashCode();
        }
        return invokeLL.intValue;
    }

    public static au a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a : (au) invokeV.objValue;
    }

    private String a(Notification notification) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, notification)) == null) {
            if (notification == null || (bundle = notification.extras) == null) {
                return null;
            }
            return bundle.getString("push_src_group_name");
        }
        return (String) invokeL.objValue;
    }

    private List<StatusBarNotification> a(ax axVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, axVar)) == null) {
            List<StatusBarNotification> m707b = axVar != null ? axVar.m707b() : null;
            if (m707b == null || m707b.size() == 0) {
                return null;
            }
            return m707b;
        }
        return (List) invokeL.objValue;
    }

    private void a(Context context, int i, Notification notification, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{context, Integer.valueOf(i), notification, Boolean.valueOf(z)}) == null) {
            String c = ay.c(notification);
            if (TextUtils.isEmpty(c)) {
                str = "group auto not extract pkg from notification:" + i;
            } else {
                List<StatusBarNotification> a2 = a(ax.a(context, c));
                if (a2 != null) {
                    String b2 = b(notification);
                    HashMap hashMap = new HashMap();
                    for (StatusBarNotification statusBarNotification : a2) {
                        if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i) {
                            a(hashMap, statusBarNotification);
                        }
                    }
                    for (Map.Entry<String, a> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            a value = entry.getValue();
                            if (z && key.equals(b2) && !m696b(notification)) {
                                (m695a(notification) ? value.b : value.f931a).add(new b(this, i, notification));
                            }
                            int size = value.f931a.size();
                            if (value.b.size() <= 0) {
                                if (z && size >= 2) {
                                    a(context, c, key, value.f931a.get(0).f932a);
                                }
                            } else if (size <= 0) {
                                a(context, c, key);
                            }
                        }
                    }
                    return;
                }
                str = "group auto not get notifications";
            }
            com.xiaomi.channel.commonutils.logger.b.m105a(str);
        }
    }

    private void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, context, str, str2) == null) {
            com.xiaomi.channel.commonutils.logger.b.b("group cancel summary:" + str2);
            ax.a(context, str).a(a(str, str2));
        }
    }

    private void a(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, this, context, str, str2, notification) == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    com.xiaomi.channel.commonutils.logger.b.m105a("group show summary group is null");
                    return;
                }
                int a2 = ay.a(context, str);
                if (a2 == 0) {
                    com.xiaomi.channel.commonutils.logger.b.m105a("group show summary not get icon from " + str);
                    return;
                }
                ax a3 = ax.a(context, str);
                if (Build.VERSION.SDK_INT >= 26) {
                    String b2 = a3.b(notification.getChannelId(), "groupSummary");
                    NotificationChannel m701a = a3.m701a(b2);
                    if ("groupSummary".equals(b2) && m701a == null) {
                        a3.a(new NotificationChannel(b2, "group_summary", 3));
                    }
                    defaults = new Notification.Builder(context, b2);
                } else {
                    defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
                }
                ay.a(defaults, true);
                Notification build = defaults.setContentTitle("GroupSummary").setContentText("GroupSummary").setSmallIcon(Icon.createWithResource(str, a2)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
                if (!com.xiaomi.push.m.m641c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                    ay.m708a(build, str);
                }
                int a4 = a(str, str2);
                a3.a(a4, build);
                com.xiaomi.channel.commonutils.logger.b.b("group show summary notify:" + a4);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m105a("group show summary error " + e);
            }
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, map, statusBarNotification) == null) {
            String b2 = b(statusBarNotification.getNotification());
            a aVar = map.get(b2);
            if (aVar == null) {
                aVar = new a(this, null);
                map.put(b2, aVar);
            }
            (m695a(statusBarNotification.getNotification()) ? aVar.b : aVar.f931a).add(new b(this, statusBarNotification.getId(), statusBarNotification.getNotification()));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m694a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? Build.VERSION.SDK_INT >= 24 : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m695a(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, notification)) == null) {
            if (notification != null) {
                Object a2 = com.xiaomi.push.bk.a((Object) notification, "isGroupSummary", (Object[]) null);
                if (a2 instanceof Boolean) {
                    return ((Boolean) a2).booleanValue();
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, context)) == null) {
            if (b(context) && ax.m699a(context)) {
                return ba.a(context).a(ho.aX.a(), false);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private String b(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, notification)) == null) {
            if (notification == null) {
                return null;
            }
            return m696b(notification) ? a(notification) : notification.getGroup();
        }
        return (String) invokeL.objValue;
    }

    private void b(Context context, int i, Notification notification) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65550, this, context, i, notification) == null) {
            String c = ay.c(notification);
            if (TextUtils.isEmpty(c)) {
                str = "group restore not extract pkg from notification:" + i;
            } else {
                ax a2 = ax.a(context, c);
                List<StatusBarNotification> a3 = a(a2);
                if (a3 != null) {
                    for (StatusBarNotification statusBarNotification : a3) {
                        Notification notification2 = statusBarNotification.getNotification();
                        if (notification2 != null && m696b(notification2) && statusBarNotification.getId() != i) {
                            Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                            recoverBuilder.setGroup(a(notification2));
                            ay.a(recoverBuilder, m695a(notification2));
                            a2.a(statusBarNotification.getId(), recoverBuilder.build());
                            com.xiaomi.channel.commonutils.logger.b.b("group restore notification:" + statusBarNotification.getId());
                        }
                    }
                    return;
                }
                str = "group restore not get notifications";
            }
            com.xiaomi.channel.commonutils.logger.b.m105a(str);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m696b(Notification notification) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, notification)) == null) {
            if (notification == null || notification.getGroup() == null || (bundle = notification.extras) == null) {
                return false;
            }
            return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(bundle.getLong("push_src_group_time")), a(notification)));
        }
        return invokeL.booleanValue;
    }

    private boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, this, context)) == null) ? ba.a(context).a(ho.aW.a(), true) : invokeL.booleanValue;
    }

    public String a(Context context, Notification.Builder builder, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, builder, str)) == null) {
            if (m694a() && a(context)) {
                long currentTimeMillis = System.currentTimeMillis();
                Bundle extras = builder.getExtras();
                extras.putString("push_src_group_name", str);
                extras.putLong("push_src_group_time", currentTimeMillis);
                return String.format("pushmask_%s_%s", Long.valueOf(currentTimeMillis), str);
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    public void a(Context context, int i, Notification notification) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i, notification) == null) && m694a()) {
            if (a(context)) {
                try {
                    b(context, i, notification);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m105a("group notify handle restore error " + e);
                }
            }
            if (b(context)) {
                try {
                    a(context, i, notification, true);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m105a("group notify handle auto error " + e2);
                }
            }
        }
    }
}
