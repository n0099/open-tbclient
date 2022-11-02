package com.yy.hiidostatis.inner.util.cipher;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes8.dex */
public class TextUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadLocal<MessageDigest> MD5_DIGEST;
    public static final char[] hexDigits;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1358626150, "Lcom/yy/hiidostatis/inner/util/cipher/TextUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1358626150, "Lcom/yy/hiidostatis/inner/util/cipher/TextUtils;");
                return;
            }
        }
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        MD5_DIGEST = new ThreadLocal<MessageDigest>() { // from class: com.yy.hiidostatis.inner.util.cipher.TextUtils.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.lang.ThreadLocal
            public MessageDigest initialValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    try {
                        return MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                }
                return (MessageDigest) invokeV.objValue;
            }
        };
    }

    public TextUtils() {
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

    public static String bytes2hex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            char[] cArr = new char[bArr.length * 2];
            int i = 0;
            for (byte b : bArr) {
                int i2 = i + 1;
                char[] cArr2 = hexDigits;
                cArr[i] = cArr2[(b >>> 4) & 15];
                i = i2 + 1;
                cArr[i2] = cArr2[b & 15];
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }

    public static String format8length(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            StringBuffer stringBuffer = new StringBuffer(8);
            int length = 8 - (i + "").length();
            while (true) {
                int i2 = length - 1;
                if (length > 0) {
                    stringBuffer.append(0);
                    length = i2;
                } else {
                    stringBuffer.append(i);
                    return stringBuffer.toString();
                }
            }
        } else {
            return (String) invokeI.objValue;
        }
    }

    public static byte[] decodeBase64(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return Base64Util.decode(str);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String encodeBase64(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            return Base64Util.encode(bArr);
        }
        return (String) invokeL.objValue;
    }

    public static byte[] hex2Bytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            return hex2Bytes(str, 0);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String length2DecimalChar(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            return format8length(i);
        }
        return (String) invokeI.objValue;
    }

    public static byte[] md5byte(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) {
            MessageDigest messageDigest = MD5_DIGEST.get();
            messageDigest.reset();
            messageDigest.update(bArr);
            return messageDigest.digest();
        }
        return (byte[]) invokeL.objValue;
    }

    public static String removeLN(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            return str.replace("\n", "");
        }
        return (String) invokeL.objValue;
    }

    public static int getDecimalCharLength(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str.length() >= 8) {
                int i = 0;
                for (int i2 = 0; i2 < 8; i2++) {
                    i = ((i * 10) + str.charAt(i2)) - 48;
                }
                return i;
            }
            throw new IllegalArgumentException("Wrong hex size : " + str.length() + ", at least 8 bytes");
        }
        return invokeL.intValue;
    }

    public static byte[] hex2Bytes(String str, int i) {
        InterceptResult invokeLI;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, str, i)) == null) {
            if (str.length() % 2 == 0) {
                if (str.length() > i) {
                    byte[] bArr = new byte[(str.length() - i) / 2];
                    int i4 = 0;
                    while (i < str.length()) {
                        char charAt = str.charAt(i);
                        char charAt2 = str.charAt(i + 1);
                        if (charAt < 'a') {
                            i2 = charAt - '0';
                        } else {
                            i2 = (charAt + '\n') - 97;
                        }
                        if (charAt2 < 'a') {
                            i3 = charAt2 - '0';
                        } else {
                            i3 = (charAt2 + '\n') - 97;
                        }
                        bArr[i4] = (byte) ((i2 << 4) | i3);
                        i4++;
                        i += 2;
                    }
                    return bArr;
                }
                throw new IllegalArgumentException("Wrong hex size : " + str.length() + " , expect larger than " + i);
            }
            throw new IllegalArgumentException("Wrong hex size : " + str.length());
        }
        return (byte[]) invokeLI.objValue;
    }

    public static String wrapDecimalLength(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, str, i)) == null) {
            return String.format("%s%s", format8length(i), str);
        }
        return (String) invokeLI.objValue;
    }
}
