package com.huawei.hms.framework.common;

import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.secure.android.common.util.SafeBase64;
/* loaded from: classes8.dex */
public class SecurityBase64Utils {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile boolean IS_AEGIS_BASE64_LIBRARY_LOADED = false;
    public static final String SAFE_BASE64_PATH = "com.huawei.secure.android.common.util.SafeBase64";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1600704029, "Lcom/huawei/hms/framework/common/SecurityBase64Utils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1600704029, "Lcom/huawei/hms/framework/common/SecurityBase64Utils;");
        }
    }

    public SecurityBase64Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean checkCompatible(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            ClassLoader classLoader = SecurityBase64Utils.class.getClassLoader();
            if (classLoader == null) {
                return false;
            }
            try {
                classLoader.loadClass(str);
                synchronized (SecurityBase64Utils.class) {
                    IS_AEGIS_BASE64_LIBRARY_LOADED = true;
                }
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static byte[] decode(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) {
            if (!IS_AEGIS_BASE64_LIBRARY_LOADED && !checkCompatible(SAFE_BASE64_PATH)) {
                try {
                    return Base64.decode(str, i);
                } catch (Exception unused) {
                    return new byte[0];
                }
            }
            return SafeBase64.decode(str, i);
        }
        return (byte[]) invokeLI.objValue;
    }

    public static String encodeToString(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i)) == null) {
            if (!IS_AEGIS_BASE64_LIBRARY_LOADED && !checkCompatible(SAFE_BASE64_PATH)) {
                try {
                    return Base64.encodeToString(bArr, i);
                } catch (Exception unused) {
                    return null;
                }
            }
            return SafeBase64.encodeToString(bArr, i);
        }
        return (String) invokeLI.objValue;
    }
}
