package com.kuaishou.weapon.p0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* renamed from: com.kuaishou.weapon.p0.ʽᴵ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0378 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final String f336 = "bGlidmErKw==";

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final String f337 = "WnBvc2VkQnJpZGdlLmphcg==";

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final String f338 = "bGlienBvc2VkX2FydC5zbw==";
    public transient /* synthetic */ FieldHolder $fh;

    public C0378() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static Integer m441(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONArray)) == null) {
            if (jSONArray != null) {
                try {
                    if (jSONArray.length() > 0) {
                        String str = new String(C0446.m974(f336.getBytes(), 2));
                        return (str.length() <= 1 || !m442(jSONArray, str)) ? null : 1;
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m442(JSONArray jSONArray, String str) {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m443(JSONArray jSONArray, String str, String str2) {
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public static Integer m444(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray)) == null) {
            if (jSONArray != null) {
                try {
                    if (jSONArray.length() > 0) {
                        String str = new String(C0446.m974(f337.getBytes(), 2));
                        byte[] m974 = C0446.m974(f338.getBytes(), 2);
                        return (m974 == null || !m443(jSONArray, str, new String(m974))) ? null : 1;
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
