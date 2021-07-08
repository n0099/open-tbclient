package d.a.o0.a.e0;

import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.c.e.p.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(@Nullable JSONObject jSONObject, int i2, int i3, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{jSONObject, Integer.valueOf(i2), Integer.valueOf(i3), str})) == null) {
            if (i2 != 0 && i3 != 0 && !k.isEmpty(str)) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                try {
                    jSONObject.put(i2 + "-" + i3, str);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65537, null, i2, i3) == null) {
            new StatisticItem("c13318").param("obj_source", i2).param("obj_type", i3).eventStat();
        }
    }

    public static void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, null, i2, i3) == null) {
            new StatisticItem("c13317").param("obj_source", i2).param("obj_type", i3).eventStat();
        }
    }
}
