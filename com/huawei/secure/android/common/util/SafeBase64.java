package com.huawei.secure.android.common.util;

import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SafeBase64 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "SafeBase64";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1850757748, "Lcom/huawei/secure/android/common/util/SafeBase64;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1850757748, "Lcom/huawei/secure/android/common/util/SafeBase64;");
        }
    }

    public SafeBase64() {
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

    public static byte[] decode(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            try {
                return Base64.decode(str, i);
            } catch (Exception e) {
                String str2 = a;
                Log.e(str2, e.getClass().getSimpleName() + " , message2 : " + e.getMessage());
                return new byte[0];
            }
        }
        return (byte[]) invokeLI.objValue;
    }

    public static byte[] encode(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, bArr, i)) == null) {
            try {
                return Base64.encode(bArr, i);
            } catch (Exception e) {
                String str = a;
                Log.e(str, e.getClass().getSimpleName() + " , message3 : " + e.getMessage());
                return new byte[0];
            }
        }
        return (byte[]) invokeLI.objValue;
    }

    public static String encodeToString(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, bArr, i)) == null) {
            try {
                return Base64.encodeToString(bArr, i);
            } catch (Exception e) {
                String str = a;
                Log.e(str, e.getClass().getSimpleName() + " , message5 : " + e.getMessage());
                return "";
            }
        }
        return (String) invokeLI.objValue;
    }

    public static byte[] decode(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i)) == null) {
            try {
                return Base64.decode(bArr, i);
            } catch (Exception e) {
                String str = a;
                Log.e(str, e.getClass().getSimpleName() + " , message0 : " + e.getMessage());
                return new byte[0];
            }
        }
        return (byte[]) invokeLI.objValue;
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i, i2, i3)) == null) {
            try {
                return Base64.decode(bArr, i, i2, i3);
            } catch (Exception e) {
                String str = a;
                Log.e(str, e.getClass().getSimpleName() + " , message1 : " + e.getMessage());
                return new byte[0];
            }
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65542, null, bArr, i, i2, i3)) == null) {
            try {
                return Base64.encode(bArr, i, i2, i3);
            } catch (Exception e) {
                String str = a;
                Log.e(str, e.getClass().getSimpleName() + " , message4 : " + e.getMessage());
                return new byte[0];
            }
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static String encodeToString(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65544, null, bArr, i, i2, i3)) == null) {
            try {
                return Base64.encodeToString(bArr, i, i2, i3);
            } catch (Exception e) {
                String str = a;
                Log.e(str, e.getClass().getSimpleName() + " , message6 : " + e.getMessage());
                return "";
            }
        }
        return (String) invokeLIII.objValue;
    }
}
