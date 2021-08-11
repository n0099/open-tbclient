package com.sdk.base.framework.f.i;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes10.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static char[] f75217a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f75218b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1065952390, "Lcom/sdk/base/framework/f/i/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1065952390, "Lcom/sdk/base/framework/f/i/d;");
                return;
            }
        }
        f75217a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        f75218b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    }

    public static String a(String str) {
        InterceptResult invokeL;
        int i2;
        byte b2;
        int i3;
        byte b3;
        int i4;
        byte b4;
        int i5;
        byte b5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            byte[] bytes = str.getBytes(Charset.defaultCharset());
            int length = bytes.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
            int i6 = 0;
            loop0: while (i6 < length) {
                while (true) {
                    i2 = i6 + 1;
                    b2 = f75218b[bytes[i6]];
                    if (i2 >= length || b2 != -1) {
                        break;
                    }
                    i6 = i2;
                }
                if (b2 == -1) {
                    break;
                }
                while (true) {
                    i3 = i2 + 1;
                    b3 = f75218b[bytes[i2]];
                    if (i3 >= length || b3 != -1) {
                        break;
                    }
                    i2 = i3;
                }
                if (b3 == -1) {
                    break;
                }
                byteArrayOutputStream.write((b2 << 2) | ((b3 & 48) >>> 4));
                while (true) {
                    i4 = i3 + 1;
                    byte b6 = bytes[i3];
                    if (b6 == 61) {
                        break loop0;
                    }
                    b4 = f75218b[b6];
                    if (i4 >= length || b4 != -1) {
                        break;
                    }
                    i3 = i4;
                }
                if (b4 == -1) {
                    break;
                }
                byteArrayOutputStream.write(((b3 & 15) << 4) | ((b4 & 60) >>> 2));
                while (true) {
                    i5 = i4 + 1;
                    byte b7 = bytes[i4];
                    if (b7 == 61) {
                        break loop0;
                    }
                    b5 = f75218b[b7];
                    if (i5 >= length || b5 != -1) {
                        break;
                    }
                    i4 = i5;
                }
                if (b5 == -1) {
                    break;
                }
                byteArrayOutputStream.write(b5 | ((b4 & 3) << 6));
                i6 = i5;
            }
            return new String(byteArrayOutputStream.toByteArray(), Charset.defaultCharset());
        }
        return (String) invokeL.objValue;
    }
}
