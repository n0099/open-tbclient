package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class en {
    public static /* synthetic */ Interceptable $ic;
    public static a a;

    /* renamed from: a  reason: collision with other field name */
    public static Map<String, ht> f312a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        void uploader(Context context, hn hnVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56375625, "Lcom/xiaomi/push/en;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56375625, "Lcom/xiaomi/push/en;");
        }
    }

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i > 0) {
                return i + 1000;
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public static int a(Enum r4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, r4)) == null) {
            if (r4 != null) {
                if (r4 instanceof hj) {
                    return r4.ordinal() + 1001;
                }
                if (r4 instanceof ht) {
                    return r4.ordinal() + 2001;
                }
                if (r4 instanceof ey) {
                    return r4.ordinal() + 3001;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static Config a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return Config.getBuilder().setEventUploadSwitchOpen(com.xiaomi.push.service.ba.a(context).a(ho.aU.a(), false)).setEventUploadFrequency(com.xiaomi.push.service.ba.a(context).a(ho.aB.a(), 86400)).setPerfUploadSwitchOpen(com.xiaomi.push.service.ba.a(context).a(ho.aA.a(), false)).setPerfUploadFrequency(com.xiaomi.push.service.ba.a(context).a(ho.aC.a(), 86400)).build(context);
        }
        return (Config) invokeL.objValue;
    }

    public static EventClientReport a(Context context, String str, String str2, int i, long j, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, Integer.valueOf(i), Long.valueOf(j), str3})) == null) {
            EventClientReport a2 = a(str);
            a2.eventId = str2;
            a2.eventType = i;
            a2.eventTime = j;
            a2.eventContent = str3;
            return a2;
        }
        return (EventClientReport) invokeCommon.objValue;
    }

    public static EventClientReport a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            EventClientReport eventClientReport = new EventClientReport();
            eventClientReport.production = 1000;
            eventClientReport.reportType = 1001;
            eventClientReport.clientInterfaceId = str;
            return eventClientReport;
        }
        return (EventClientReport) invokeL.objValue;
    }

    public static PerfClientReport a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            PerfClientReport perfClientReport = new PerfClientReport();
            perfClientReport.production = 1000;
            perfClientReport.reportType = 1000;
            perfClientReport.clientInterfaceId = "P100000";
            return perfClientReport;
        }
        return (PerfClientReport) invokeV.objValue;
    }

    public static PerfClientReport a(Context context, int i, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            PerfClientReport a2 = a();
            a2.code = i;
            a2.perfCounts = j;
            a2.perfLatencies = j2;
            return a2;
        }
        return (PerfClientReport) invokeCommon.objValue;
    }

    public static hn a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            hn hnVar = new hn();
            hnVar.d("category_client_report_data");
            hnVar.a("push_sdk_channel");
            hnVar.a(1L);
            hnVar.b(str);
            hnVar.a(true);
            hnVar.b(System.currentTimeMillis());
            hnVar.g(context.getPackageName());
            hnVar.e("com.xiaomi.xmsf");
            hnVar.f(com.xiaomi.push.service.bz.a());
            hnVar.c("quality_support");
            return hnVar;
        }
        return (hn) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static ht m309a(String str) {
        InterceptResult invokeL;
        ht[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (f312a == null) {
                synchronized (ht.class) {
                    if (f312a == null) {
                        f312a = new HashMap();
                        for (ht htVar : ht.values()) {
                            f312a.put(htVar.f506a.toLowerCase(), htVar);
                        }
                    }
                }
            }
            ht htVar2 = f312a.get(str.toLowerCase());
            return htVar2 != null ? htVar2 : ht.a;
        }
        return (ht) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m310a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) ? i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : i == 6000 ? "E100003" : "" : (String) invokeI.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m311a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            ClientReportClient.updateConfig(context, a(context));
        }
    }

    public static void a(Context context, Config config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, config) == null) {
            ClientReportClient.init(context, config, new el(context), new em(context));
        }
    }

    public static void a(Context context, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, hnVar) == null) {
            if (m312a(context.getApplicationContext())) {
                com.xiaomi.push.service.ca.a(context.getApplicationContext(), hnVar);
                return;
            }
            a aVar = a;
            if (aVar != null) {
                aVar.uploader(context, hnVar);
            }
        }
    }

    public static void a(Context context, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, context, list) == null) || list == null) {
            return;
        }
        try {
            for (String str : list) {
                hn a2 = a(context, str);
                if (!com.xiaomi.push.service.bz.a(a2, false)) {
                    a(context, a2);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d(th.getMessage());
        }
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, aVar) == null) {
            a = aVar;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m312a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) ? (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true : invokeL.booleanValue;
    }
}
