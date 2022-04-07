package com.heytap.mcssdk.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;
/* loaded from: classes5.dex */
public class CryptoUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_RADIX = 16;
    public static final String DES_KEY = "com.nearme.mcs";
    public transient /* synthetic */ FieldHolder $fh;

    public CryptoUtil() {
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

    public static String desDecrypt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return DESUtil.decrypt(str, getDesKey());
                } catch (Exception e) {
                    LogUtil.e("desDecrypt-" + e.getMessage());
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String desEncrypt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return DESUtil.encrypt(str, getDesKey());
                } catch (Exception e) {
                    LogUtil.e("desEncrypt-" + e.getMessage());
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String getDesKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            byte[] swapBytes = swapBytes(getUTF8Bytes(DES_KEY));
            return swapBytes != null ? new String(swapBytes, Charset.forName("UTF-8")) : "";
        }
        return (String) invokeV.objValue;
    }

    public static byte[] getUTF8Bytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str == null) {
                return new byte[0];
            }
            try {
                return str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return new byte[0];
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static String parseByte2HexStr(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString.toUpperCase(Locale.getDefault()));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] parseHexStr2Byte(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str.length() <= 0) {
                return null;
            }
            byte[] bArr = new byte[str.length() / 2];
            for (int i = 0; i < str.length() / 2; i++) {
                int i2 = i * 2;
                int i3 = i2 + 1;
                bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] swapBytes(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
            for (int i = 0; i < length; i += 2) {
                byte b = bArr[i];
                int i2 = i + 1;
                bArr[i] = bArr[i2];
                bArr[i2] = b;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }
}
