package d.a.h0.a.j1.m;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.h0.a.i2.i0;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final File f42965a;

    static {
        boolean z = k.f43101a;
        f42965a = AppRuntime.getAppContext().getExternalCacheDir();
    }

    public static void a(List<UbcFlowEvent> list) {
        e O;
        Map<String, String> r;
        if (d.a.h0.a.m1.a.a.A() && (O = e.O()) != null && (r = i0.r(i0.n(O.J().V()))) != null && TextUtils.equals(r.get("_SwanStartupPerf_"), "1")) {
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(list);
            JSONArray jSONArray = new JSONArray();
            for (UbcFlowEvent ubcFlowEvent : arrayList) {
                if (!ubcFlowEvent.b()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", ubcFlowEvent.f11915a);
                        jSONObject.put("time", ubcFlowEvent.g());
                        jSONObject.put("value", ubcFlowEvent.j());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            File file = new File(f42965a, "swan_perf");
            if (!file.exists()) {
                file.mkdirs();
            }
            d.a.h0.p.d.y(jSONArray.toString(), new File(file, String.format(Locale.getDefault(), "perf_%s.json", Long.valueOf(System.currentTimeMillis() / 1000))));
        }
    }
}
