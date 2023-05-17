package com.cmic.sso.sdk.e;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.security.SecureRandom;
import java.util.UUID;
/* loaded from: classes8.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1436789798, "Lcom/cmic/sso/sdk/e/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1436789798, "Lcom/cmic/sso/sdk/e/q;");
                return;
            }
        }
        a = new char[]{TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr == null) {
                return "";
            }
            char[] cArr = new char[bArr.length * 2];
            int i = 0;
            for (byte b : bArr) {
                int i2 = i + 1;
                char[] cArr2 = a;
                cArr[i] = cArr2[(b >>> 4) & 15];
                i = i2 + 1;
                cArr[i2] = cArr2[b & 15];
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }

    public static void a(com.cmic.sso.sdk.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, aVar, str) == null) {
            if (TextUtils.isEmpty(aVar.b("interfaceType", ""))) {
                aVar.a("interfaceType", str);
                return;
            }
            aVar.a("interfaceType", aVar.b("interfaceType") + ParamableElem.DIVIDE_PARAM + str);
        }
    }

    public static void b(com.cmic.sso.sdk.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, aVar, str) == null) {
            if (TextUtils.isEmpty(aVar.b("interfaceCode", ""))) {
                aVar.a("interfaceCode", str);
                return;
            }
            aVar.a("interfaceCode", aVar.b("interfaceCode") + ParamableElem.DIVIDE_PARAM + str);
        }
    }

    public static void c(com.cmic.sso.sdk.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, aVar, str) == null) {
            if (TextUtils.isEmpty(aVar.b("interfaceElasped", ""))) {
                aVar.a("interfaceElasped", str);
                return;
            }
            aVar.a("interfaceElasped", aVar.b("interfaceElasped") + ParamableElem.DIVIDE_PARAM + str);
        }
    }

    public static boolean a(com.cmic.sso.sdk.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
            if (k.a("logCloseTime", 0L) + (aVar.l() * 60 * 60 * 1000) >= System.currentTimeMillis()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return UUID.randomUUID().toString().replaceAll("-", "");
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return d().replace("-", "");
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return UUID.randomUUID().toString();
        }
        return (String) invokeV.objValue;
    }
}
