package com.repackage;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class i89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, m89 m89Var, l89 l89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, m89Var, l89Var) == null) {
            if (ac9.a) {
                ac9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + l89Var.toString());
            }
            g89 g = d89.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (l89Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", l89Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", l89Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", l89Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", l89Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", l89Var.d + ""));
                }
                g.a("perf_record_arperf", str, m89Var.a, m89Var.b, m89Var.c, m89Var.d, m89Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (ac9.a) {
                ac9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            g89 g = d89.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", yb9.a(d89.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(yb9.b(d89.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
