package com.dxmpay.apollon.utils;

import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Character;
import java.net.URLEncoder;
import org.apache.commons.lang3.CharUtils;
/* loaded from: classes7.dex */
public final class EncodeUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EncodeUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean a(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Character.valueOf(c2)})) == null) ? (c2 & 255) != c2 : invokeCommon.booleanValue;
    }

    public static String encodeCommParms(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                try {
                    return URLEncoder.encode(new String(Base64.encode(str.getBytes(), 0)), "utf-8");
                } catch (Exception e2) {
                    LogUtil.e("EncodeUtils", "encodeCommParms failed", e2);
                    return "";
                }
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String gbk2Unicode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (a(charAt)) {
                    stringBuffer.append("\\u" + Integer.toHexString(charAt));
                } else {
                    stringBuffer.append(charAt);
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String gbk2utf8(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? unicodeToUtf8(gbk2Unicode(str)) : (String) invokeL.objValue;
    }

    public static String unicode2GBK(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                if (i2 < length - 1) {
                    int i3 = i2 + 2;
                    if ("\\u".equals(str.substring(i2, i3))) {
                        i2 += 6;
                        stringBuffer.append((char) Integer.parseInt(str.substring(i3, i2), 16));
                    }
                }
                stringBuffer.append(str.charAt(i2));
                i2++;
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String unicodeToUtf8(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            int length = str.length();
            StringBuffer stringBuffer = new StringBuffer(length);
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                char charAt = str.charAt(i2);
                if (charAt == '\\') {
                    i2 = i3 + 1;
                    char charAt2 = str.charAt(i3);
                    if (charAt2 == 'u') {
                        int i4 = 0;
                        int i5 = 0;
                        while (i4 < 4) {
                            int i6 = i2 + 1;
                            char charAt3 = str.charAt(i2);
                            switch (charAt3) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    i5 = ((i5 << 4) + charAt3) - 48;
                                    break;
                                default:
                                    switch (charAt3) {
                                        case 'A':
                                        case 'B':
                                        case 'C':
                                        case 'D':
                                        case 'E':
                                        case 'F':
                                            i5 = (((i5 << 4) + 10) + charAt3) - 65;
                                            break;
                                        default:
                                            switch (charAt3) {
                                                case 'a':
                                                case 'b':
                                                case 'c':
                                                case 'd':
                                                case 'e':
                                                case 'f':
                                                    i5 = (((i5 << 4) + 10) + charAt3) - 97;
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                                            }
                                    }
                            }
                            i4++;
                            i2 = i6;
                        }
                        stringBuffer.append((char) i5);
                    } else {
                        if (charAt2 == 't') {
                            charAt2 = '\t';
                        } else if (charAt2 == 'r') {
                            charAt2 = CharUtils.CR;
                        } else if (charAt2 == 'n') {
                            charAt2 = '\n';
                        } else if (charAt2 == 'f') {
                            charAt2 = '\f';
                        }
                        stringBuffer.append(charAt2);
                    }
                } else {
                    stringBuffer.append(charAt);
                    i2 = i3;
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String utf82gbk(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? unicode2GBK(utf8ToUnicode(str)) : (String) invokeL.objValue;
    }

    public static String utf8ToUnicode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            char[] charArray = str.toCharArray();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < str.length(); i2++) {
                Character.UnicodeBlock of = Character.UnicodeBlock.of(charArray[i2]);
                if (of == Character.UnicodeBlock.BASIC_LATIN) {
                    stringBuffer.append(charArray[i2]);
                } else if (of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                    stringBuffer.append((char) (charArray[i2] - 65248));
                } else {
                    String hexString = Integer.toHexString((short) charArray[i2]);
                    stringBuffer.append(("\\u" + hexString).toLowerCase());
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }
}
