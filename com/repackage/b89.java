package com.repackage;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, f89 f89Var, e89 e89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, f89Var, e89Var) == null) {
            if (tb9.a) {
                tb9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + e89Var.toString());
            }
            z79 g = w79.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (e89Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", e89Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", e89Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", e89Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", e89Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", e89Var.d + ""));
                }
                g.a("perf_record_arperf", str, f89Var.a, f89Var.b, f89Var.c, f89Var.d, f89Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (tb9.a) {
                tb9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            z79 g = w79.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", rb9.a(w79.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(rb9.b(w79.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
