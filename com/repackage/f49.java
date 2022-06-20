package com.repackage;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class f49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, j49 j49Var, i49 i49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, j49Var, i49Var) == null) {
            if (x79.a) {
                x79.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + i49Var.toString());
            }
            d49 g = a49.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (i49Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", i49Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", i49Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", i49Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", i49Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", i49Var.d + ""));
                }
                g.a("perf_record_arperf", str, j49Var.a, j49Var.b, j49Var.c, j49Var.d, j49Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (x79.a) {
                x79.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            d49 g = a49.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", v79.a(a49.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(v79.b(a49.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
