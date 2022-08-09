package com.repackage;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class z79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, d89 d89Var, c89 c89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, d89Var, c89Var) == null) {
            if (rb9.a) {
                rb9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + c89Var.toString());
            }
            x79 g = u79.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (c89Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", c89Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", c89Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", c89Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", c89Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", c89Var.d + ""));
                }
                g.a("perf_record_arperf", str, d89Var.a, d89Var.b, d89Var.c, d89Var.d, d89Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (rb9.a) {
                rb9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            x79 g = u79.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", pb9.a(u79.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(pb9.b(u79.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
