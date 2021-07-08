package d.a.v0.f;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.v0.f.b.c.b;
import d.a.v0.t.c;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, b bVar, d.a.v0.f.b.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, bVar, aVar) == null) {
            if (c.f68247a) {
                c.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar.toString());
            }
            d.a.v0.e.a h2 = d.a.v0.b.d().h();
            if (h2 != null) {
                ArrayList arrayList = null;
                if (aVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", aVar.f67825a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", aVar.f67826b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", aVar.f67830f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", aVar.f67827c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", aVar.f67828d + ""));
                }
                h2.a("perf_record_arperf", str, bVar.f67832a, bVar.f67833b, bVar.f67834c, bVar.f67835d, bVar.f67836e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (c.f68247a) {
                c.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            d.a.v0.e.a h2 = d.a.v0.b.d().h();
            if (h2 != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", d.a.v0.t.a.a(d.a.v0.b.d().b())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(d.a.v0.t.a.b(d.a.v0.b.d().b()))));
                }
                h2.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
