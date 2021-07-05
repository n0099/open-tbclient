package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
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
public class ek {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f43046a;

    /* renamed from: a  reason: collision with other field name */
    public static Map<String, hp> f320a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        void uploader(Context context, hj hjVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56375718, "Lcom/xiaomi/push/ek;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56375718, "Lcom/xiaomi/push/ek;");
        }
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 > 0) {
                return i2 + 1000;
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
                if (r4 instanceof hf) {
                    return r4.ordinal() + 1001;
                }
                if (r4 instanceof hp) {
                    return r4.ordinal() + 2001;
                }
                if (r4 instanceof ev) {
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
            return Config.getBuilder().setEventUploadSwitchOpen(com.xiaomi.push.service.aq.a(context).a(hk.aU.a(), false)).setEventUploadFrequency(com.xiaomi.push.service.aq.a(context).a(hk.aB.a(), 86400)).setPerfUploadSwitchOpen(com.xiaomi.push.service.aq.a(context).a(hk.aA.a(), false)).setPerfUploadFrequency(com.xiaomi.push.service.aq.a(context).a(hk.aC.a(), 86400)).build(context);
        }
        return (Config) invokeL.objValue;
    }

    public static EventClientReport a(Context context, String str, String str2, int i2, long j, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{context, str, str2, Integer.valueOf(i2), Long.valueOf(j), str3})) == null) {
            EventClientReport a2 = a(str);
            a2.eventId = str2;
            a2.eventType = i2;
            a2.eventTime = j;
            a2.eventContent = str3;
            return a2;
        }
        return (EventClientReport) invokeCommon.objValue;
    }

    public static EventClientReport a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            PerfClientReport perfClientReport = new PerfClientReport();
            perfClientReport.production = 1000;
            perfClientReport.reportType = 1000;
            perfClientReport.clientInterfaceId = "P100000";
            return perfClientReport;
        }
        return (PerfClientReport) invokeV.objValue;
    }

    public static PerfClientReport a(Context context, int i2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            PerfClientReport a2 = a();
            a2.code = i2;
            a2.perfCounts = j;
            a2.perfLatencies = j2;
            return a2;
        }
        return (PerfClientReport) invokeCommon.objValue;
    }

    public static hj a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            hj hjVar = new hj();
            hjVar.d("category_client_report_data");
            hjVar.a("push_sdk_channel");
            hjVar.a(1L);
            hjVar.b(str);
            hjVar.a(true);
            hjVar.b(System.currentTimeMillis());
            hjVar.g(context.getPackageName());
            hjVar.e("com.xiaomi.xmsf");
            hjVar.f(com.xiaomi.push.service.bm.a());
            hjVar.c("quality_support");
            return hjVar;
        }
        return (hj) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static hp m285a(String str) {
        InterceptResult invokeL;
        hp[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (f320a == null) {
                synchronized (hp.class) {
                    if (f320a == null) {
                        f320a = new HashMap();
                        for (hp hpVar : hp.values()) {
                            f320a.put(hpVar.f509a.toLowerCase(), hpVar);
                        }
                    }
                }
            }
            hp hpVar2 = f320a.get(str.toLowerCase());
            return hpVar2 != null ? hpVar2 : hp.f43287a;
        }
        return (hp) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m286a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) ? i2 == 1000 ? "E100000" : i2 == 3000 ? "E100002" : i2 == 2000 ? "E100001" : i2 == 6000 ? "E100003" : "" : (String) invokeI.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m287a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            ClientReportClient.updateConfig(context, a(context));
        }
    }

    public static void a(Context context, Config config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, config) == null) {
            ClientReportClient.init(context, config, new ei(context), new ej(context));
        }
    }

    public static void a(Context context, hj hjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, hjVar) == null) {
            if (m288a(context.getApplicationContext())) {
                com.xiaomi.push.service.bn.a(context.getApplicationContext(), hjVar);
                return;
            }
            a aVar = f43046a;
            if (aVar != null) {
                aVar.uploader(context, hjVar);
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
                hj a2 = a(context, str);
                if (!com.xiaomi.push.service.bm.a(a2, false)) {
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
            f43046a = aVar;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m288a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) ? (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true : invokeL.booleanValue;
    }
}
