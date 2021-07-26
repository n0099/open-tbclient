package d.a.o0.a.o0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(d.a.o0.a.h0.f.a aVar, d.a.o0.a.o0.d.a aVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, aVar, aVar2) == null) || aVar == null || aVar2 == null) {
            return;
        }
        aVar2.c(aVar);
    }

    @NonNull
    public static String b(@Nullable String str, @Nullable String str2, @Nullable Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, obj)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || obj == null) {
                return "";
            }
            if (!(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Long) && !(obj instanceof Boolean)) {
                return c(str, str2, String.valueOf(obj));
            }
            return str + "." + str2 + " = " + obj + ";";
        }
        return (String) invokeLLL.objValue;
    }

    public static String c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return "";
            }
            String quote = JSONObject.quote(str3);
            return str + "." + str2 + " = " + quote + ";";
        }
        return (String) invokeLLL.objValue;
    }

    public static String d(String str, String str2, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, jSONObject)) == null) ? (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || jSONObject == null) ? "" : String.format(Locale.getDefault(), "%s.%s = %s;", str, str2, jSONObject) : (String) invokeLLL.objValue;
    }

    public static String e(d.a.o0.a.h0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar)) == null) ? aVar.isWebView() ? "document" : SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME : (String) invokeL.objValue;
    }
}
