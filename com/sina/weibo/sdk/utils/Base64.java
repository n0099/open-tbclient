package com.sina.weibo.sdk.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class Base64 {
    public static /* synthetic */ Interceptable $ic;
    public static char[] alphabet;
    public static byte[] codes;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1920382822, "Lcom/sina/weibo/sdk/utils/Base64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1920382822, "Lcom/sina/weibo/sdk/utils/Base64;");
                return;
            }
        }
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
        codes = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            codes[i2] = -1;
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            codes[i3] = (byte) (i3 - 65);
        }
        for (int i4 = 97; i4 <= 122; i4++) {
            codes[i4] = (byte) ((i4 + 26) - 97);
        }
        for (int i5 = 48; i5 <= 57; i5++) {
            codes[i5] = (byte) ((i5 + 52) - 48);
        }
        byte[] bArr = codes;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public Base64() {
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

    public static byte[] decode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            int length = ((bArr.length + 3) / 4) * 3;
            if (bArr.length > 0 && bArr[bArr.length - 1] == 61) {
                length--;
            }
            if (bArr.length > 1 && bArr[bArr.length - 2] == 61) {
                length--;
            }
            byte[] bArr2 = new byte[length];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (byte b2 : bArr) {
                byte b3 = codes[b2 & 255];
                if (b3 >= 0) {
                    i4 += 6;
                    i3 = (i3 << 6) | b3;
                    if (i4 >= 8) {
                        i4 -= 8;
                        bArr2[i2] = (byte) ((i3 >> i4) & 255);
                        i2++;
                    }
                }
            }
            if (i2 == length) {
                return bArr2;
            }
            throw new RuntimeException("miscalculated data length!");
        }
        return (byte[]) invokeL.objValue;
    }

    public static char[] encode(byte[] bArr) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            char[] cArr = new char[((bArr.length + 2) / 3) * 4];
            int i2 = 0;
            int i3 = 0;
            while (i2 < bArr.length) {
                int i4 = (bArr[i2] & 255) << 8;
                int i5 = i2 + 1;
                boolean z2 = true;
                if (i5 < bArr.length) {
                    i4 |= bArr[i5] & 255;
                    z = true;
                } else {
                    z = false;
                }
                int i6 = i4 << 8;
                int i7 = i2 + 2;
                if (i7 < bArr.length) {
                    i6 |= bArr[i7] & 255;
                } else {
                    z2 = false;
                }
                int i8 = 64;
                cArr[i3 + 3] = alphabet[z2 ? i6 & 63 : 64];
                int i9 = i6 >> 6;
                int i10 = i3 + 2;
                char[] cArr2 = alphabet;
                if (z) {
                    i8 = i9 & 63;
                }
                cArr[i10] = cArr2[i8];
                int i11 = i9 >> 6;
                char[] cArr3 = alphabet;
                cArr[i3 + 1] = cArr3[i11 & 63];
                cArr[i3 + 0] = cArr3[(i11 >> 6) & 63];
                i2 += 3;
                i3 += 4;
            }
            return cArr;
        }
        return (char[]) invokeL.objValue;
    }

    public static byte[] encodebyte(byte[] bArr) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, bArr)) == null) {
            byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
            int i2 = 0;
            int i3 = 0;
            while (i2 < bArr.length) {
                int i4 = (bArr[i2] & 255) << 8;
                int i5 = i2 + 1;
                boolean z2 = true;
                if (i5 < bArr.length) {
                    i4 |= bArr[i5] & 255;
                    z = true;
                } else {
                    z = false;
                }
                int i6 = i4 << 8;
                int i7 = i2 + 2;
                if (i7 < bArr.length) {
                    i6 |= bArr[i7] & 255;
                } else {
                    z2 = false;
                }
                int i8 = 64;
                bArr2[i3 + 3] = (byte) alphabet[z2 ? i6 & 63 : 64];
                int i9 = i6 >> 6;
                int i10 = i3 + 2;
                char[] cArr = alphabet;
                if (z) {
                    i8 = i9 & 63;
                }
                bArr2[i10] = (byte) cArr[i8];
                int i11 = i9 >> 6;
                char[] cArr2 = alphabet;
                bArr2[i3 + 1] = (byte) cArr2[i11 & 63];
                bArr2[i3 + 0] = (byte) cArr2[(i11 >> 6) & 63];
                i2 += 3;
                i3 += 4;
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }
}
