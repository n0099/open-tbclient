package com.qq.e.comm.util;

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
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
/* loaded from: classes10.dex */
public class Md5Util {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f75419a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074720132, "Lcom/qq/e/comm/util/Md5Util;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074720132, "Lcom/qq/e/comm/util/Md5Util;");
                return;
            }
        }
        f75419a = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    }

    public Md5Util() {
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

    public static String byteArrayToHexString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 : bArr) {
                if (i2 < 0) {
                    i2 += 256;
                }
                stringBuffer.append(f75419a[i2 / 16] + f75419a[i2 % 16]);
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String encode(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        if (file == null) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String byteArrayToHexString = byteArrayToHexString(messageDigest.digest());
                try {
                    fileInputStream2.close();
                } catch (Exception unused) {
                }
                return byteArrayToHexString;
            } catch (Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                return "";
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String encode(String str) {
        String str2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            str2 = new String(str);
            try {
                return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(str2.getBytes("UTF-8")));
            } catch (Exception unused) {
                return str2;
            }
        } catch (Exception unused2) {
            str2 = null;
        }
    }

    public static String encodeBase64String(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(Base64.decode(str, 0)));
            } catch (Exception unused) {
                GDTLogger.d("Exception while md5 base64String");
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static byte[] hexStringtoByteArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (str.length() % 2 != 0) {
                return null;
            }
            byte[] bArr = new byte[str.length() / 2];
            for (int i2 = 0; i2 < str.length() - 1; i2 += 2) {
                char charAt = str.charAt(i2);
                char charAt2 = str.charAt(i2 + 1);
                char lowerCase = Character.toLowerCase(charAt);
                char lowerCase2 = Character.toLowerCase(charAt2);
                int i3 = ((lowerCase <= '9' ? lowerCase - '0' : (lowerCase - 'a') + 10) << 4) + (lowerCase2 <= '9' ? lowerCase2 - '0' : (lowerCase2 - 'a') + 10);
                if (i3 > 127) {
                    i3 -= 256;
                }
                bArr[i2 / 2] = (byte) i3;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }
}
