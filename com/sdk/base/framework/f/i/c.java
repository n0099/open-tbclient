package com.sdk.base.framework.f.i;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.sdk.base.framework.c.f;
import io.flutter.plugin.common.StandardMessageCodec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes10.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f75596a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f75597b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1065952359, "Lcom/sdk/base/framework/f/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1065952359, "Lcom/sdk/base/framework/f/i/c;");
                return;
            }
        }
        boolean z = f.f75550b;
        f75596a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        f75597b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 63, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, 0, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    }

    public c() {
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

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuffer stringBuffer = new StringBuffer(((bArr.length - 1) / 3) << 6);
            int i2 = 0;
            for (int i3 = 0; i3 < bArr.length; i3++) {
                int i4 = i3 % 3;
                int i5 = 16 - (i4 << 3);
                i2 |= (bArr[i3] << i5) & (255 << i5);
                if (i4 == 2 || i3 == bArr.length - 1) {
                    stringBuffer.append(f75596a[(16515072 & i2) >>> 18]);
                    stringBuffer.append(f75596a[(258048 & i2) >>> 12]);
                    stringBuffer.append(f75596a[(i2 & 4032) >>> 6]);
                    stringBuffer.append(f75596a[i2 & 63]);
                    i2 = 0;
                }
            }
            if (bArr.length % 3 > 0) {
                stringBuffer.setCharAt(stringBuffer.length() - 1, com.alipay.sdk.encrypt.a.f35988h);
            }
            if (bArr.length % 3 == 1) {
                stringBuffer.setCharAt(stringBuffer.length() - 2, com.alipay.sdk.encrypt.a.f35988h);
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return null;
            }
            int length = str.length();
            if (length % 4 == 0) {
                if (str.length() == 0) {
                    return new byte[0];
                }
                int i2 = str.charAt(length + (-1)) == '=' ? 1 : 0;
                if (str.charAt(length - 2) == '=') {
                    i2++;
                }
                int i3 = ((length / 4) * 3) - i2;
                byte[] bArr = new byte[i3];
                for (int i4 = 0; i4 < length; i4 += 4) {
                    int i5 = (i4 / 4) * 3;
                    char charAt = str.charAt(i4);
                    char charAt2 = str.charAt(i4 + 1);
                    char charAt3 = str.charAt(i4 + 2);
                    char charAt4 = str.charAt(i4 + 3);
                    byte[] bArr2 = f75597b;
                    int i6 = (bArr2[charAt] << 18) | (bArr2[charAt2] << StandardMessageCodec.LIST) | (bArr2[charAt3] << 6) | bArr2[charAt4];
                    bArr[i5] = (byte) ((i6 >> 16) & 255);
                    if (i4 < length - 4) {
                        bArr[i5 + 1] = (byte) ((i6 >> 8) & 255);
                        bArr[i5 + 2] = (byte) i6;
                    } else {
                        int i7 = i5 + 1;
                        if (i7 < i3) {
                            bArr[i7] = (byte) ((i6 >> 8) & 255);
                        }
                        int i8 = i5 + 2;
                        if (i8 < i3) {
                            bArr[i8] = (byte) i6;
                        }
                    }
                }
                return bArr;
            }
            throw new IllegalArgumentException("Base64 string length must be 4*n");
        }
        return (byte[]) invokeL.objValue;
    }
}
