package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fu2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final File b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755695410, "Lcom/repackage/fu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755695410, "Lcom/repackage/fu2;");
                return;
            }
        }
        a = sg1.a;
        b = AppRuntime.getAppContext().getExternalCacheDir();
    }

    public static JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject D = pj2.g0().D();
            String k = pj2.g0().k();
            try {
                jSONObject.put(SetImageWatermarkTypeReqMsg.SWITCH, D);
                JSONArray jSONArray = null;
                if (!TextUtils.isEmpty(k)) {
                    jSONArray = new JSONArray();
                    for (String str : k.split("-")) {
                        jSONArray.put(str);
                    }
                }
                jSONObject.put("sid", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b + File.separator + "swan_perf";
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
                        jSONObject3.put("id", ubcFlowEvent.a);
                        jSONObject3.put("time", ubcFlowEvent.g());
                        jSONObject3.put("value", ubcFlowEvent.j());
                        jSONArray.put(jSONObject3);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                jSONObject2.put("eventlist", jSONArray);
                jSONObject2.put(SavedStateHandle.VALUES, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject2;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void d(List<UbcFlowEvent> list, JSONObject jSONObject) {
        i03 b0;
        Map<String, String> t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, jSONObject) == null) {
            if (a) {
                ff4.b().f();
            }
            if (hw2.E() && (b0 = i03.b0()) != null && (t = ae3.t(ae3.o(b0.W().W()))) != null && TextUtils.equals(t.get("_SwanStartupPerf_"), "1")) {
                ArrayList arrayList = new ArrayList(list);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("670", c(arrayList, jSONObject));
                    jSONObject2.put("ab", a());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                File file = new File(b, "swan_perf");
                if (file.exists() || file.mkdirs()) {
                    kg4.N(jSONObject2.toString(), new File(file, String.format(Locale.getDefault(), "perf_%s.json", Long.valueOf(System.currentTimeMillis() / 1000))));
                }
            }
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            File file = new File(b, "swan_stability");
            if (!kg4.m(file)) {
                ix1.k("StartupPerf", "创建目录失败 path" + file);
                return;
            }
            kg4.N(str, new File(file, String.format(Locale.getDefault(), "stability_%s.json", Long.valueOf(System.currentTimeMillis() / 1000))));
        }
    }
}
