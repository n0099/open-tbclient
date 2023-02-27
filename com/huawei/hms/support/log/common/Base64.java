package com.huawei.hms.support.log.common;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.huawei.hms.common.internal.TransactionIdCreater;
/* loaded from: classes8.dex */
public final class Base64 {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] a;
    public static final byte[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1839510498, "Lcom/huawei/hms/support/log/common/Base64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1839510498, "Lcom/huawei/hms/support/log/common/Base64;");
                return;
            }
        }
        a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', WebvttCueParser.CHAR_SLASH, '='};
        b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, com.baidu.webkit.internal.Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 37, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, ExifInterface.START_CODE, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
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

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int length = str.length();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt > 255 || b[charAt] < 0) {
                    length--;
                }
            }
            return length;
        }
        return invokeL.intValue;
    }

    public static String encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            return encode(bArr, bArr.length);
        }
        return (String) invokeL.objValue;
    }

    public static byte[] decode(String str) {
        InterceptResult invokeL;
        byte b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int a2 = a(str);
            int i = (a2 / 4) * 3;
            int i2 = a2 % 4;
            if (i2 == 3) {
                i += 2;
            }
            if (i2 == 2) {
                i++;
            }
            byte[] bArr = new byte[i];
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < str.length(); i6++) {
                char charAt = str.charAt(i6);
                if (charAt > 255) {
                    b2 = -1;
                } else {
                    b2 = b[charAt];
                }
                if (b2 >= 0) {
                    i5 += 6;
                    i4 = (i4 << 6) | b2;
                    if (i5 >= 8) {
                        i5 -= 8;
                        bArr[i3] = (byte) (255 & (i4 >> i5));
                        i3++;
                    }
                }
            }
            if (i3 != i) {
                return new byte[0];
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String encode(byte[] bArr, int i) {
        InterceptResult invokeLI;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, bArr, i)) == null) {
            char[] cArr = new char[((i + 2) / 3) * 4];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                int i5 = (bArr[i3] & 255) << 8;
                int i6 = i3 + 1;
                boolean z2 = true;
                if (i6 < i) {
                    i5 |= bArr[i6] & 255;
                    z = true;
                } else {
                    z = false;
                }
                int i7 = i5 << 8;
                int i8 = i3 + 2;
                if (i8 < i) {
                    i7 |= bArr[i8] & 255;
                } else {
                    z2 = false;
                }
                int i9 = i4 + 3;
                char[] cArr2 = a;
                int i10 = 64;
                if (z2) {
                    i2 = i7 & 63;
                } else {
                    i2 = 64;
                }
                cArr[i9] = cArr2[i2];
                int i11 = i7 >> 6;
                int i12 = i4 + 2;
                char[] cArr3 = a;
                if (z) {
                    i10 = i11 & 63;
                }
                cArr[i12] = cArr3[i10];
                int i13 = i11 >> 6;
                char[] cArr4 = a;
                cArr[i4 + 1] = cArr4[i13 & 63];
                cArr[i4 + 0] = cArr4[(i13 >> 6) & 63];
                i3 += 3;
                i4 += 4;
            }
            return new String(cArr);
        }
        return (String) invokeLI.objValue;
    }
}
