package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.rl2;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class m73 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755546424, "Lcom/repackage/m73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755546424, "Lcom/repackage/m73;");
                return;
            }
        }
        boolean z = eh1.a;
        a = 0;
    }

    public static void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        rl2.a V = t03.J().r().V();
        String i = z93.i(V.j0(), V.G());
        if (!jSONObject.has("appid")) {
            ud3.f(jSONObject, "appid", V.H());
        }
        if (!jSONObject.has("swan")) {
            ud3.f(jSONObject, "swan", i);
        }
        if (!jSONObject.has("appversion")) {
            ud3.f(jSONObject, "appversion", V.v1());
        }
        if (!jSONObject.has("swanNativeVersion")) {
            ud3.f(jSONObject, "swanNativeVersion", fh1.a());
        }
        if (!jSONObject.has("thirdversion")) {
            ud3.f(jSONObject, "thirdversion", V.w1());
        }
        if (!t03.J().r().x0() || jSONObject.has("isWebDowngrade")) {
            return;
        }
        ud3.f(jSONObject, "isWebDowngrade", "1");
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String o = me3.o(str);
            if (TextUtils.isEmpty(o)) {
                return str;
            }
            HashSet hashSet = new HashSet();
            hashSet.add("bduss");
            hashSet.add("bduss".toUpperCase());
            String i = me3.i(o, hashSet);
            String f = me3.f(str);
            return f + "?" + i;
        }
        return (String) invokeL.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a : invokeV.intValue;
    }

    public static void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            a = i;
        }
    }

    public static <EvenT extends w73> EvenT e(EvenT event, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, event, str, obj)) == null) {
            if (event != null && !TextUtils.isEmpty(str)) {
                event.a(str, obj);
            }
            return event;
        }
        return (EvenT) invokeLLL.objValue;
    }

    public static <EvenT extends w73> EvenT f(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, event)) == null) {
            e(event, "isDownloading", String.valueOf(t03.J().r().E0() ? 1 : 0));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends w73> EvenT g(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, event)) == null) {
            e(event, "launchType", c() == 2 ? "2" : "1");
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends w73> EvenT h(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, event)) == null) {
            e(event, "packageState", String.valueOf(t03.J().r().D0()));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends w73> EvenT i(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, event)) == null) {
            e(event, "coreState", String.valueOf(o72.B0()));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }
}
