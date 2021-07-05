package d.l.a.a.a.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jSONObject, str)) == null) {
            if (jSONObject == null) {
                return 0L;
            }
            try {
                return Long.valueOf(jSONObject.optString(str)).longValue();
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return invokeLL.longValue;
    }

    public static String b(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, strArr)) == null) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static JSONObject c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            d(jSONObject, jSONObject2);
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject d(JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jSONObject, jSONObject2)) == null) {
            if (jSONObject != null && jSONObject2 != null) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject2.put(next, jSONObject.get(next));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return jSONObject2;
        }
        return (JSONObject) invokeLL.objValue;
    }

    @NonNull
    public static JSONObject e(JSONObject... jSONObjectArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, jSONObjectArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (jSONObjectArr != null && jSONObjectArr.length != 0) {
                for (JSONObject jSONObject2 : jSONObjectArr) {
                    if (jSONObject2 != null) {
                        d(jSONObject2, jSONObject);
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static boolean f(d.l.a.e.b.j.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, aVar, str)) == null) {
            if (aVar == null || aVar.b("apk_update_handler_enable", 1) != 1) {
                return false;
            }
            return "application/ttpatch".equals(str);
        }
        return invokeLL.booleanValue;
    }
}
