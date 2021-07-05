package d.a.r0.s.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String p = d.a.r0.r.d0.b.j().p("scheme_white_list", null);
            if (StringUtils.isNull(p)) {
                return null;
            }
            try {
                return b(new JSONArray(p));
            } catch (Exception unused) {
                return null;
            }
        }
        return (List) invokeV.objValue;
    }

    public static List<String> b(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONArray)) == null) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                String optString = jSONArray.optString(i2);
                if (!StringUtils.isNull(optString)) {
                    arrayList.add(optString);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, jSONArray) == null) {
            if (jSONArray == null) {
                d.a.r0.r.d0.b.j().x("scheme_white_list", "");
            } else {
                d.a.r0.r.d0.b.j().x("scheme_white_list", jSONArray.toString());
            }
        }
    }
}
