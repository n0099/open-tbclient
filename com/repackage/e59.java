package com.repackage;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, i59 i59Var, h59 h59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, i59Var, h59Var) == null) {
            if (w89.a) {
                w89.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + h59Var.toString());
            }
            c59 g = z49.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (h59Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", h59Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", h59Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", h59Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", h59Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", h59Var.d + ""));
                }
                g.a("perf_record_arperf", str, i59Var.a, i59Var.b, i59Var.c, i59Var.d, i59Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (w89.a) {
                w89.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            c59 g = z49.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", u89.a(z49.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(u89.b(z49.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
