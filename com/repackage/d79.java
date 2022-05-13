package com.repackage;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class d79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, h79 h79Var, g79 g79Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, h79Var, g79Var) == null) {
            if (va9.a) {
                va9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + g79Var.toString());
            }
            b79 g = y69.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (g79Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", g79Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", g79Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", g79Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", g79Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", g79Var.d + ""));
                }
                g.a("perf_record_arperf", str, h79Var.a, h79Var.b, h79Var.c, h79Var.d, h79Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (va9.a) {
                va9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            b79 g = y69.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", ta9.a(y69.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(ta9.b(y69.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
