package d.a.l0.a.r1.l;

import android.text.TextUtils;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.a.l0.a.k;
import d.a.l0.a.v2.o0;
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
    public static final boolean f48190a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static final File f48191b = AppRuntime.getAppContext().getExternalCacheDir();

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject E = d.a.l0.a.c1.a.Z().E();
        String k = d.a.l0.a.c1.a.Z().k();
        try {
            jSONObject.put(SetImageWatermarkTypeReqMsg.SWITCH, E);
            JSONArray jSONArray = null;
            if (!TextUtils.isEmpty(k)) {
                jSONArray = new JSONArray();
                for (String str : k.split("-")) {
                    jSONArray.put(str);
                }
            }
            jSONObject.put("sid", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static String b() {
        return f48191b + File.separator + "swan_perf";
    }

    public static JSONObject c(List<UbcFlowEvent> list, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (UbcFlowEvent ubcFlowEvent : list) {
            if (!ubcFlowEvent.b()) {
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("id", ubcFlowEvent.f11051a);
                    jSONObject3.put("time", ubcFlowEvent.g());
                    jSONObject3.put("value", ubcFlowEvent.j());
                    jSONArray.put(jSONObject3);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            jSONObject2.put("eventlist", jSONArray);
            jSONObject2.put(SavedStateHandle.VALUES, jSONObject);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject2;
    }

    public static void d(List<UbcFlowEvent> list, JSONObject jSONObject) {
        d.a.l0.a.a2.e Q;
        Map<String, String> t;
        if (f48190a) {
            d.a.l0.q.d.b().f();
        }
        if (d.a.l0.a.u1.a.a.D() && (Q = d.a.l0.a.a2.e.Q()) != null && (t = o0.t(o0.o(Q.L().W()))) != null && TextUtils.equals(t.get("_SwanStartupPerf_"), "1")) {
            ArrayList arrayList = new ArrayList(list);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("670", c(arrayList, jSONObject));
                jSONObject2.put("ab", a());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            File file = new File(f48191b, "swan_perf");
            if (file.exists() || file.mkdirs()) {
                d.a.l0.t.d.M(jSONObject2.toString(), new File(file, String.format(Locale.getDefault(), "perf_%s.json", Long.valueOf(System.currentTimeMillis() / 1000))));
            }
        }
    }
}
