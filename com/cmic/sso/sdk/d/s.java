package com.cmic.sso.sdk.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.UUID;
/* loaded from: classes7.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1436819527, "Lcom/cmic/sso/sdk/d/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1436819527, "Lcom/cmic/sso/sdk/d/s;");
                return;
            }
        }
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr == null) {
                return "";
            }
            char[] cArr = new char[bArr.length * 2];
            int i2 = 0;
            for (byte b2 : bArr) {
                int i3 = i2 + 1;
                char[] cArr2 = a;
                cArr[i2] = cArr2[(b2 >>> 4) & 15];
                i2 = i3 + 1;
                cArr[i3] = cArr2[b2 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c().replace("-", "") : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? UUID.randomUUID().toString() : (String) invokeV.objValue;
    }

    public static void b(com.cmic.sso.sdk.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, aVar, str) == null) {
            if (TextUtils.isEmpty(aVar.b("interfaceCode", ""))) {
                aVar.a("interfaceCode", str);
                return;
            }
            aVar.a("interfaceCode", aVar.b("interfaceCode") + ";" + str);
        }
    }

    public static void c(com.cmic.sso.sdk.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, aVar, str) == null) {
            if (TextUtils.isEmpty(aVar.b("interfaceElasped", ""))) {
                aVar.a("interfaceElasped", str);
                return;
            }
            aVar.a("interfaceElasped", aVar.b("interfaceElasped") + ";" + str);
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? UUID.randomUUID().toString().replaceAll("-", "") : (String) invokeV.objValue;
    }

    public static void a(com.cmic.sso.sdk.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, aVar, str) == null) {
            if (TextUtils.isEmpty(aVar.b("interfaceType", ""))) {
                aVar.a("interfaceType", str);
                return;
            }
            aVar.a("interfaceType", aVar.b("interfaceType") + ";" + str);
        }
    }
}
