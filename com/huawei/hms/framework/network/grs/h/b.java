package com.huawei.hms.framework.network.grs.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.common.Logger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "b";
    public static final Pattern b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2128864648, "Lcom/huawei/hms/framework/network/grs/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2128864648, "Lcom/huawei/hms/framework/network/grs/h/b;");
                return;
            }
        }
        b = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? a(str, "SHA-256") : (String) invokeL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65538, null, str, str2)) != null) {
            return (String) invokeLL.objValue;
        }
        try {
            try {
                return a(MessageDigest.getInstance(str2).digest(str.getBytes("UTF-8")));
            } catch (NoSuchAlgorithmException unused) {
                str3 = a;
                str4 = "encrypt NoSuchAlgorithmException";
                Logger.w(str3, str4);
                return null;
            }
        } catch (UnsupportedEncodingException unused2) {
            str3 = a;
            str4 = "encrypt UnsupportedEncodingException";
        }
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 1;
            if (str.length() == 1) {
                return "*";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < str.length(); i2++) {
                String str2 = str.charAt(i2) + "";
                if (b.matcher(str2).matches()) {
                    if (i % 2 == 0) {
                        str2 = "*";
                    }
                    i++;
                }
                stringBuffer.append(str2);
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }
}
