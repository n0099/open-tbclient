package com.sina.weibo.sdk.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
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
        for (int i = 0; i < 256; i++) {
            codes[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            codes[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            codes[i3] = (byte) ((i3 + 26) - 97);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            codes[i4] = (byte) ((i4 + 52) - 48);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (byte b : bArr) {
                byte b2 = codes[b & 255];
                if (b2 >= 0) {
                    i3 += 6;
                    i2 = (i2 << 6) | b2;
                    if (i3 >= 8) {
                        i3 -= 8;
                        bArr2[i] = (byte) ((i2 >> i3) & 255);
                        i++;
                    }
                }
            }
            if (i == length) {
                return bArr2;
            }
            throw new RuntimeException("miscalculated data length!");
        }
        return (byte[]) invokeL.objValue;
    }

    public static char[] encode(byte[] bArr) {
        InterceptResult invokeL;
        boolean z;
        int i;
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
                int i8 = i3 + 3;
                char[] cArr2 = alphabet;
                int i9 = 64;
                if (z2) {
                    i = i6 & 63;
                } else {
                    i = 64;
                }
                cArr[i8] = cArr2[i];
                int i10 = i6 >> 6;
                int i11 = i3 + 2;
                char[] cArr3 = alphabet;
                if (z) {
                    i9 = i10 & 63;
                }
                cArr[i11] = cArr3[i9];
                int i12 = i10 >> 6;
                char[] cArr4 = alphabet;
                cArr[i3 + 1] = cArr4[i12 & 63];
                cArr[i3 + 0] = cArr4[(i12 >> 6) & 63];
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
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
                int i8 = i3 + 3;
                char[] cArr = alphabet;
                int i9 = 64;
                if (z2) {
                    i = i6 & 63;
                } else {
                    i = 64;
                }
                bArr2[i8] = (byte) cArr[i];
                int i10 = i6 >> 6;
                int i11 = i3 + 2;
                char[] cArr2 = alphabet;
                if (z) {
                    i9 = i10 & 63;
                }
                bArr2[i11] = (byte) cArr2[i9];
                int i12 = i10 >> 6;
                char[] cArr3 = alphabet;
                bArr2[i3 + 1] = (byte) cArr3[i12 & 63];
                bArr2[i3 + 0] = (byte) cArr3[(i12 >> 6) & 63];
                i2 += 3;
                i3 += 4;
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }
}
