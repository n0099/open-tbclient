package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.wl2;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class r73 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755397469, "Lcom/repackage/r73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755397469, "Lcom/repackage/r73;");
                return;
            }
        }
        boolean z = jh1.a;
        a = 0;
    }

    public static void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        wl2.a W = y03.K().q().W();
        String i = ea3.i(W.j0(), W.G());
        if (!jSONObject.has("appid")) {
            zd3.f(jSONObject, "appid", W.H());
        }
        if (!jSONObject.has("swan")) {
            zd3.f(jSONObject, "swan", i);
        }
        if (!jSONObject.has("appversion")) {
            zd3.f(jSONObject, "appversion", W.v1());
        }
        if (!jSONObject.has("swanNativeVersion")) {
            zd3.f(jSONObject, "swanNativeVersion", kh1.a());
        }
        if (!jSONObject.has("thirdversion")) {
            zd3.f(jSONObject, "thirdversion", W.w1());
        }
        if (!y03.K().q().y0() || jSONObject.has("isWebDowngrade")) {
            return;
        }
        zd3.f(jSONObject, "isWebDowngrade", "1");
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String o = re3.o(str);
            if (TextUtils.isEmpty(o)) {
                return str;
            }
            HashSet hashSet = new HashSet();
            hashSet.add("bduss");
            hashSet.add("bduss".toUpperCase());
            String i = re3.i(o, hashSet);
            String f = re3.f(str);
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

    public static <EvenT extends b83> EvenT e(EvenT event, String str, Object obj) {
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

    public static <EvenT extends b83> EvenT f(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, event)) == null) {
            e(event, "isDownloading", String.valueOf(y03.K().q().F0() ? 1 : 0));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends b83> EvenT g(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, event)) == null) {
            e(event, "launchType", c() == 2 ? "2" : "1");
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends b83> EvenT h(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, event)) == null) {
            e(event, "packageState", String.valueOf(y03.K().q().E0()));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends b83> EvenT i(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, event)) == null) {
            e(event, "coreState", String.valueOf(t72.B0()));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }
}
