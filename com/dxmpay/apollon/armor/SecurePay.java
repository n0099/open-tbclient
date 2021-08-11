package com.dxmpay.apollon.armor;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class SecurePay {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INPUT_ID_CVV = 2;
    public static final int INPUT_ID_CVV_MAX_LEN = 3;
    public static final int INPUT_ID_PW = 1;
    public static final String KEY = "key";
    public static final int SIG_RSA_MD2 = 2;
    public static final int SIG_RSA_MD4 = 3;
    public static final int SIG_RSA_MD5 = 4;
    public static final int SIG_RSA_RAW = 0;
    public static final int SIG_RSA_SHA1 = 5;
    public static final int SIG_RSA_SHA224 = 14;
    public static final int SIG_RSA_SHA256 = 11;
    public static final int SIG_RSA_SHA384 = 12;
    public static final int SIG_RSA_SHA512 = 13;

    /* renamed from: a  reason: collision with root package name */
    public static SecurePay f68904a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f68905b = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(355931184, "Lcom/dxmpay/apollon/armor/SecurePay;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(355931184, "Lcom/dxmpay/apollon/armor/SecurePay;");
                return;
            }
        }
        try {
            System.loadLibrary("dxm_wsp_v1_1");
        } catch (UnsatisfiedLinkError e2) {
            f68905b = false;
            String str = "load library failed, " + e2.getMessage();
        }
    }

    public SecurePay() {
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

    public static synchronized SecurePay getInstance() {
        InterceptResult invokeV;
        SecurePay securePay;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (SecurePay.class) {
                if (f68904a == null) {
                    SecurePay securePay2 = new SecurePay();
                    f68904a = securePay2;
                    try {
                        securePay2.init();
                    } catch (Throwable unused) {
                    }
                }
                securePay = f68904a;
            }
            return securePay;
        }
        return (SecurePay) invokeV.objValue;
    }

    public static String unicodeDecode(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            int i3 = 0;
            while (i3 < length) {
                char charAt = str.charAt(i3);
                if (charAt == '\\' && (i2 = i3 + 1) != length && str.charAt(i2) == 'u') {
                    int i4 = i3 + 2;
                    i3 += 6;
                    sb.append((char) Integer.parseInt(str.substring(i4, i3), 16));
                } else {
                    sb.append(charAt);
                    i3++;
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public boolean checkLicense(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? checkSign(context) == 0 : invokeL.booleanValue;
    }

    public native int checkSign(Context context);

    public native void clearKeyboard(int i2);

    public native String decrypt(String str);

    public String decryptProxy(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return decrypt(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public native String encrypt(String str);

    public String encryptProxy(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                return encrypt(str);
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public native String getA(long j2);

    public native String getB(int i2);

    public native String getC(int i2);

    public native String getDyKey(byte[] bArr, byte[] bArr2, int i2, int i3);

    public native String getSafeStr(int i2);

    public native String getToken();

    public native String getak();

    public native String getpw();

    public String getpwProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            try {
                return getpw();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public native void init();

    public native int inputKeyboardChar(int i2, char c2, int i3);

    public native String localDecrypt(String str);

    public native String localDecrypt1(String str);

    public String localDecryptProxy(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            try {
                return localDecrypt(str);
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public native String localEncrypt(String str);

    public native String localEncrypt1(String str);

    public String localEncryptProxy(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            try {
                return localEncrypt(str);
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public native String mapScancode(String str);

    public boolean prepareCompleted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? f68905b : invokeV.booleanValue;
    }

    public native String rsaDecrypt(String str);

    public native int rsaVerify(int i2, int i3, int i4, byte[] bArr, byte[] bArr2);

    public native String tokenDecrypt(String str);

    public native String tokenEncrypt(String str);
}
