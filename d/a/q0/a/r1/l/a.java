package d.a.q0.a.r1.l;

import android.text.TextUtils;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.k;
import d.a.q0.a.v2.o0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50444a;

    /* renamed from: b  reason: collision with root package name */
    public static final File f50445b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1019297524, "Ld/a/q0/a/r1/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1019297524, "Ld/a/q0/a/r1/l/a;");
                return;
            }
        }
        f50444a = k.f49133a;
        f50445b = AppRuntime.getAppContext().getExternalCacheDir();
    }

    public static JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject E = d.a.q0.a.c1.a.Z().E();
            String k = d.a.q0.a.c1.a.Z().k();
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
        return (JSONObject) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return f50445b + File.separator + "swan_perf";
        }
        return (String) invokeV.objValue;
    }

    public static JSONObject c(List<UbcFlowEvent> list, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, list, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (UbcFlowEvent ubcFlowEvent : list) {
                if (!ubcFlowEvent.b()) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("id", ubcFlowEvent.f11205a);
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
        return (JSONObject) invokeLL.objValue;
    }

    public static void d(List<UbcFlowEvent> list, JSONObject jSONObject) {
        d.a.q0.a.a2.e Q;
        Map<String, String> t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, null, list, jSONObject) == null) {
            if (f50444a) {
                d.a.q0.q.d.b().f();
            }
            if (d.a.q0.a.u1.a.a.D() && (Q = d.a.q0.a.a2.e.Q()) != null && (t = o0.t(o0.o(Q.L().W()))) != null && TextUtils.equals(t.get("_SwanStartupPerf_"), "1")) {
                ArrayList arrayList = new ArrayList(list);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("670", c(arrayList, jSONObject));
                    jSONObject2.put("ab", a());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                File file = new File(f50445b, "swan_perf");
                if (file.exists() || file.mkdirs()) {
                    d.a.q0.t.d.M(jSONObject2.toString(), new File(file, String.format(Locale.getDefault(), "perf_%s.json", Long.valueOf(System.currentTimeMillis() / 1000))));
                }
            }
        }
    }
}
