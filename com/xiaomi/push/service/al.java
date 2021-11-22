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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.hk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@TargetApi(24)
/* loaded from: classes2.dex */
public class al {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static al f72326a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ al f72327a;

        /* renamed from: a  reason: collision with other field name */
        public List<b> f893a;

        /* renamed from: b  reason: collision with root package name */
        public List<b> f72328b;

        public a(al alVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72327a = alVar;
            this.f893a = new ArrayList();
            this.f72328b = new ArrayList();
        }

        public /* synthetic */ a(al alVar, am amVar) {
            this(alVar);
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f72329a;

        /* renamed from: a  reason: collision with other field name */
        public Notification f894a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ al f895a;

        public b(al alVar, int i2, Notification notification) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alVar, Integer.valueOf(i2), notification};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f895a = alVar;
            this.f72329a = i2;
            this.f894a = notification;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "id:" + this.f72329a;
            }
            return (String) invokeV.objValue;
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
        f72326a = new al();
    }

    public al() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public static al a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f72326a : (al) invokeV.objValue;
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

    private List<StatusBarNotification> a(ao aoVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aoVar)) == null) {
            List<StatusBarNotification> m600b = aoVar != null ? aoVar.m600b() : null;
            if (m600b == null || m600b.size() == 0) {
                return null;
            }
            return m600b;
        }
        return (List) invokeL.objValue;
    }

    private void a(Context context, int i2, Notification notification, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{context, Integer.valueOf(i2), notification, Boolean.valueOf(z)}) == null) {
            String a2 = ap.a(notification);
            if (TextUtils.isEmpty(a2)) {
                str = "group auto not extract pkg from notification:" + i2;
            } else {
                List<StatusBarNotification> a3 = a(ao.a(context, a2));
                if (a3 != null) {
                    String b2 = b(notification);
                    HashMap hashMap = new HashMap();
                    for (StatusBarNotification statusBarNotification : a3) {
                        if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i2) {
                            a(hashMap, statusBarNotification);
                        }
                    }
                    for (Map.Entry<String, a> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            a value = entry.getValue();
                            if (z && key.equals(b2) && !m590b(notification)) {
                                (m589a(notification) ? value.f72328b : value.f893a).add(new b(this, i2, notification));
                            }
                            int size = value.f893a.size();
                            if (value.f72328b.size() <= 0) {
                                if (z && size >= 2) {
                                    a(context, a2, key, value.f893a.get(0).f894a);
                                }
                            } else if (size <= 0) {
                                a(context, a2, key);
                            }
                        }
                    }
                    return;
                }
                str = "group auto not get notifications";
            }
            com.xiaomi.channel.commonutils.logger.b.m73a(str);
        }
    }

    private void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, context, str, str2) == null) {
            com.xiaomi.channel.commonutils.logger.b.b("group cancel summary:" + str2);
            ao.a(context, str).a(a(str, str2));
        }
    }

    private void a(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, this, context, str, str2, notification) == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    com.xiaomi.channel.commonutils.logger.b.m73a("group show summary group is null");
                    return;
                }
                int a2 = ap.a(context, str);
                if (a2 == 0) {
                    com.xiaomi.channel.commonutils.logger.b.m73a("group show summary not get icon from " + str);
                    return;
                }
                ao a3 = ao.a(context, str);
                if (Build.VERSION.SDK_INT >= 26) {
                    String b2 = a3.b(notification.getChannelId(), "groupSummary");
                    NotificationChannel m594a = a3.m594a(b2);
                    if ("groupSummary".equals(b2) && m594a == null) {
                        a3.a(new NotificationChannel(b2, "group_summary", 3));
                    }
                    defaults = new Notification.Builder(context, b2);
                } else {
                    defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
                }
                ap.a(defaults, true);
                Notification build = defaults.setContentTitle("GroupSummary").setContentText("GroupSummary").setSmallIcon(Icon.createWithResource(str, a2)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
                if (!com.xiaomi.push.l.c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                    ap.a(build, str);
                }
                int a4 = a(str, str2);
                a3.a(a4, build);
                com.xiaomi.channel.commonutils.logger.b.b("group show summary notify:" + a4);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m73a("group show summary error " + e2);
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
            (m589a(statusBarNotification.getNotification()) ? aVar.f72328b : aVar.f893a).add(new b(this, statusBarNotification.getId(), statusBarNotification.getNotification()));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m588a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? Build.VERSION.SDK_INT >= 24 : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m589a(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, notification)) == null) {
            if (notification != null) {
                Object a2 = com.xiaomi.push.bh.a((Object) notification, "isGroupSummary", (Object[]) null);
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
            if (b(context) && ao.m593a(context)) {
                return aq.a(context).a(hk.aX.a(), false);
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
            return m590b(notification) ? a(notification) : notification.getGroup();
        }
        return (String) invokeL.objValue;
    }

    private void b(Context context, int i2, Notification notification) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65550, this, context, i2, notification) == null) {
            String a2 = ap.a(notification);
            if (TextUtils.isEmpty(a2)) {
                str = "group restore not extract pkg from notification:" + i2;
            } else {
                ao a3 = ao.a(context, a2);
                List<StatusBarNotification> a4 = a(a3);
                if (a4 != null) {
                    for (StatusBarNotification statusBarNotification : a4) {
                        Notification notification2 = statusBarNotification.getNotification();
                        if (notification2 != null && m590b(notification2) && statusBarNotification.getId() != i2) {
                            Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                            recoverBuilder.setGroup(a(notification2));
                            ap.a(recoverBuilder, m589a(notification2));
                            a3.a(statusBarNotification.getId(), recoverBuilder.build());
                            com.xiaomi.channel.commonutils.logger.b.b("group restore notification:" + statusBarNotification.getId());
                        }
                    }
                    return;
                }
                str = "group restore not get notifications";
            }
            com.xiaomi.channel.commonutils.logger.b.m73a(str);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m590b(Notification notification) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, this, context)) == null) ? aq.a(context).a(hk.aW.a(), true) : invokeL.booleanValue;
    }

    public String a(Context context, Notification.Builder builder, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, builder, str)) == null) {
            if (m588a() && a(context)) {
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

    public void a(Context context, int i2, Notification notification) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, notification) == null) && m588a()) {
            if (a(context)) {
                try {
                    b(context, i2, notification);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m73a("group notify handle restore error " + e2);
                }
            }
            if (b(context)) {
                try {
                    a(context, i2, notification, true);
                } catch (Exception e3) {
                    com.xiaomi.channel.commonutils.logger.b.m73a("group notify handle auto error " + e3);
                }
            }
        }
    }
}
