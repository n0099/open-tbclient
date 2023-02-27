package com.huawei.hms.common.util;

import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes8.dex */
public final class Base64Utils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FLAG_DEFAULT = 0;
    public static final int FLAG_URL = 10;
    public static final int FLAG_URL_NOPADDING = 11;
    public static final String TAG = "Base64Utils";
    public transient /* synthetic */ FieldHolder $fh;

    public Base64Utils() {
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

    public static byte[] decode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            byte[] bArr = new byte[0];
            if (str != null) {
                try {
                    return Base64.decode(str, 0);
                } catch (IllegalArgumentException e) {
                    HMSLog.e(TAG, "decode failed : " + e.getMessage());
                }
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] decodeUrlSafe(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            byte[] bArr = new byte[0];
            if (str != null) {
                try {
                    return Base64.decode(str, 10);
                } catch (IllegalArgumentException e) {
                    HMSLog.e(TAG, "decodeUrlSafe failed : " + e.getMessage());
                }
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] decodeUrlSafeNoPadding(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            byte[] bArr = new byte[0];
            if (str != null) {
                try {
                    return Base64.decode(str, 11);
                } catch (IllegalArgumentException e) {
                    HMSLog.e(TAG, "decodeUrlSafeNoPadding failed : " + e.getMessage());
                }
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            if (bArr != null) {
                return Base64.encodeToString(bArr, 0);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String encodeUrlSafe(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            if (bArr != null) {
                return Base64.encodeToString(bArr, 10);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String encodeUrlSafeNoPadding(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            if (bArr != null) {
                return Base64.encodeToString(bArr, 11);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
