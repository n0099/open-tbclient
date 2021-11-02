package com.yy.hiidostatis.inner.util.cipher;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes2.dex */
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                    } catch (NoSuchAlgorithmException e2) {
                        throw new RuntimeException(e2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = 0;
            for (byte b2 : bArr) {
                int i3 = i2 + 1;
                char[] cArr2 = hexDigits;
                cArr[i2] = cArr2[(b2 >>> 4) & 15];
                i2 = i3 + 1;
                cArr[i3] = cArr2[b2 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }

    public static byte[] decodeBase64(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? Base64Util.decode(str) : (byte[]) invokeL.objValue;
    }

    public static String encodeBase64(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) ? Base64Util.encode(bArr) : (String) invokeL.objValue;
    }

    public static String format8length(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) != null) {
            return (String) invokeI.objValue;
        }
        StringBuffer stringBuffer = new StringBuffer(8);
        int length = 8 - (i2 + "").length();
        while (true) {
            int i3 = length - 1;
            if (length > 0) {
                stringBuffer.append(0);
                length = i3;
            } else {
                stringBuffer.append(i2);
                return stringBuffer.toString();
            }
        }
    }

    public static int getDecimalCharLength(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (str.length() < 8) {
                throw new IllegalArgumentException("Wrong hex size : " + str.length() + ", at least 8 bytes");
            }
            int i2 = 0;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 = ((i2 * 10) + str.charAt(i3)) - 48;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static byte[] hex2Bytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? hex2Bytes(str, 0) : (byte[]) invokeL.objValue;
    }

    public static String length2DecimalChar(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? format8length(i2) : (String) invokeI.objValue;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? str.replace(StringUtils.LF, "") : (String) invokeL.objValue;
    }

    public static String wrapDecimalLength(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, str, i2)) == null) ? String.format("%s%s", format8length(i2), str) : (String) invokeLI.objValue;
    }

    public static byte[] hex2Bytes(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, str, i2)) == null) {
            if (str.length() % 2 == 0) {
                if (str.length() > i2) {
                    byte[] bArr = new byte[(str.length() - i2) / 2];
                    int i3 = 0;
                    while (i2 < str.length()) {
                        char charAt = str.charAt(i2);
                        char charAt2 = str.charAt(i2 + 1);
                        bArr[i3] = (byte) (((charAt < 'a' ? charAt - '0' : (charAt + '\n') - 97) << 4) | (charAt2 < 'a' ? charAt2 - '0' : (charAt2 + '\n') - 97));
                        i3++;
                        i2 += 2;
                    }
                    return bArr;
                }
                throw new IllegalArgumentException("Wrong hex size : " + str.length() + " , expect larger than " + i2);
            }
            throw new IllegalArgumentException("Wrong hex size : " + str.length());
        }
        return (byte[]) invokeLI.objValue;
    }
}
