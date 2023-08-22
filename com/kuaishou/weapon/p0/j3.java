package com.kuaishou.weapon.p0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class j3 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "bGlidmErKw==";
    public static final String b = "WnBvc2VkQnJpZGdlLmphcg==";
    public static final String c = "bGlienBvc2VkX2FydC5zbw==";
    public transient /* synthetic */ FieldHolder $fh;

    public j3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Integer a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONArray)) == null) {
            if (jSONArray != null) {
                try {
                    if (jSONArray.length() > 0) {
                        String str = new String(d.a(a.getBytes(), 2));
                        return (str.length() <= 1 || !a(jSONArray, str)) ? null : 1;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (Integer) invokeL.objValue;
    }

    public static boolean a(JSONArray jSONArray, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONArray, str)) == null) {
            try {
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (((String) jSONArray.get(i)).contains(str)) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(JSONArray jSONArray, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, jSONArray, str, str2)) == null) {
            try {
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String str3 = (String) jSONArray.get(i);
                        if (str3.contains(str) || str3.contains(str2)) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static Integer b(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray)) == null) {
            if (jSONArray != null) {
                try {
                    if (jSONArray.length() > 0) {
                        String str = new String(d.a(b.getBytes(), 2));
                        byte[] a2 = d.a(c.getBytes(), 2);
                        return (a2 == null || !a(jSONArray, str, new String(a2))) ? null : 1;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (Integer) invokeL.objValue;
    }
}
