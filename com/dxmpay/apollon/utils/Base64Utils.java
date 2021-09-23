package com.dxmpay.apollon.utils;

import android.os.Build;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes9.dex */
public class Base64Utils {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Boolean f69740a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1457046611, "Lcom/dxmpay/apollon/utils/Base64Utils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1457046611, "Lcom/dxmpay/apollon/utils/Base64Utils;");
                return;
            }
        }
        f69740a = Boolean.valueOf(Build.VERSION.SDK_INT >= 8);
    }

    public Base64Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static byte[] decode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (f69740a.booleanValue()) {
                return Base64.decode(bArr, 2);
            }
            try {
                return com.dxmpay.apollon.utils.support.Base64.decode(bArr);
            } catch (IOException e2) {
                throw new IllegalArgumentException(e2.getLocalizedMessage());
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            if (f69740a.booleanValue()) {
                return Base64.encode(bArr, 2);
            }
            return com.dxmpay.apollon.utils.support.Base64.encodeBytesToBytes(bArr);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String encodeToString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
            if (f69740a.booleanValue()) {
                return Base64.encodeToString(bArr, 2);
            }
            return com.dxmpay.apollon.utils.support.Base64.encodeBytes(bArr);
        }
        return (String) invokeL.objValue;
    }

    public static byte[] decode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (f69740a.booleanValue()) {
                return Base64.decode(str, 2);
            }
            try {
                return com.dxmpay.apollon.utils.support.Base64.decode(str);
            } catch (IOException e2) {
                throw new IllegalArgumentException(e2.getLocalizedMessage());
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
