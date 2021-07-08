package d.a.e0.b.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? d.a.e0.a.c.j.c("open_bes_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? d.a.e0.a.c.j.c("hot_splash_max_count", 3) : invokeV.intValue;
    }

    public static float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? d.a.e0.a.c.j.b("hot_background_time", 5.0f) : invokeV.floatValue;
    }

    public static float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.a.e0.a.c.j.b("hot_update_split_time", 5.0f) : invokeV.floatValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.a.e0.a.c.j.c("query_time_out_advance", 100) : invokeV.intValue;
    }

    public static void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2) == null) {
            d.a.e0.a.c.j.h("open_bes_switch", i2);
        }
    }

    public static void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject) == null) {
            i((float) jSONObject.optDouble("hot_background_time", 5.0d));
            h(jSONObject.optInt("hot_splash_max_count", 3));
        }
    }

    public static void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i2) == null) {
            d.a.e0.a.c.j.h("hot_splash_max_count", i2);
        }
    }

    public static void i(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65544, null, f2) == null) {
            d.a.e0.a.c.j.g("hot_background_time", f2);
        }
    }

    public static void j(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65545, null, f2) == null) {
            d.a.e0.a.c.j.g("hot_update_split_time", f2);
        }
    }

    public static void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, null, i2) == null) {
            d.a.e0.a.c.j.h("query_time_out_advance", i2);
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("freq");
            if (optJSONObject != null) {
                g(optJSONObject);
            }
            k(jSONObject.optInt("query_time_out_advance", 100));
            j((float) jSONObject.optDouble("hot_update_split_time", 5.0d));
            f(jSONObject.optInt("open_bes_switch", 0));
        } catch (JSONException e2) {
            if (d.a.e0.a.a.a.f42207a) {
                e2.printStackTrace();
            }
        }
    }
}
