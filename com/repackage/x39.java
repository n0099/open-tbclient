package com.repackage;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class x39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, b49 b49Var, a49 a49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, b49Var, a49Var) == null) {
            if (p79.a) {
                p79.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + a49Var.toString());
            }
            v39 g = s39.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (a49Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", a49Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", a49Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", a49Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", a49Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", a49Var.d + ""));
                }
                g.a("perf_record_arperf", str, b49Var.a, b49Var.b, b49Var.c, b49Var.d, b49Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (p79.a) {
                p79.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            v39 g = s39.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", n79.a(s39.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(n79.b(s39.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
