package com.heytap.mcssdk.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.msp.push.encrypt.AESEncrypt;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = null;
    public static final String b = "Y29tLm5lYXJtZS5tY3M=";
    public static String c = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1335122203, "Lcom/heytap/mcssdk/utils/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1335122203, "Lcom/heytap/mcssdk/utils/b;");
        }
    }

    public b() {
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

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (TextUtils.isEmpty(c)) {
                c = new String(com.heytap.mcssdk.a.a.b(b));
            }
            byte[] a2 = a(a(c));
            return a2 != null ? new String(a2, Charset.forName("UTF-8")) : "";
        }
        return (String) invokeV.objValue;
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
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

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
            for (int i = 0; i < length; i += 2) {
                byte b2 = bArr[i];
                int i2 = i + 1;
                bArr[i] = bArr[i2];
                bArr[i2] = b2;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            String str2 = "";
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                str2 = c.a(str, a());
                d.b("sdkDecrypt desDecrypt des data " + str2);
                z = true;
            } catch (Exception e) {
                d.b("sdkDecrypt DES excepiton " + e.toString());
                z = false;
            }
            if (TextUtils.isEmpty(str2) ? false : z) {
                return str2;
            }
            try {
                str2 = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
                a = "AES";
                e.f().b(a);
                d.b("sdkDecrypt desDecrypt aes data " + str2);
                return str2;
            } catch (Exception e2) {
                d.b("sdkDecrypt AES excepiton " + e2.toString());
                return str2;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            String str2 = "";
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                str2 = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
                d.b("sdkDecrypt aesDecrypt aes data " + str2);
                z = true;
            } catch (Exception e) {
                d.b("sdkDecrypt AES excepiton " + e.toString());
                z = false;
            }
            if (TextUtils.isEmpty(str2) ? false : z) {
                return str2;
            }
            try {
                str2 = c.a(str, a());
                a = Coder.KEY_DES;
                e.f().b(a);
                d.b("sdkDecrypt aesDecrypt des data " + str2);
                return str2;
            } catch (Exception e2) {
                d.b("sdkDecrypt DES excepiton " + e2.toString());
                return str2;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            d.b("sdkDecrypt start data " + str);
            if (TextUtils.isEmpty(a)) {
                a = e.f().e();
            }
            if (Coder.KEY_DES.equals(a)) {
                d.b("sdkDecrypt start DES");
                return b(str);
            }
            d.b("sdkDecrypt start AES");
            return c(str);
        }
        return (String) invokeL.objValue;
    }
}
