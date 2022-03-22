package com.sdk.base.framework.f.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.kwad.yoga.YogaNodeJNIBase;
import com.sdk.base.framework.c.f;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f42594b;
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
        boolean z = f.f42567b;
        a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', WebvttCueParser.CHAR_SLASH};
        f42594b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 63, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, BaseNCodec.PAD_DEFAULT, -1, -1, -1, 0, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, YogaNodeJNIBase.LAYOUT_BORDER_START_INDEX, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 42, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, Cea608Decoder.CTRL_END_OF_CAPTION, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    }

    public c() {
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

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuffer stringBuffer = new StringBuffer(((bArr.length - 1) / 3) << 6);
            int i = 0;
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i3 = i2 % 3;
                int i4 = 16 - (i3 << 3);
                i |= (bArr[i2] << i4) & (255 << i4);
                if (i3 == 2 || i2 == bArr.length - 1) {
                    stringBuffer.append(a[(16515072 & i) >>> 18]);
                    stringBuffer.append(a[(258048 & i) >>> 12]);
                    stringBuffer.append(a[(i & 4032) >>> 6]);
                    stringBuffer.append(a[i & 63]);
                    i = 0;
                }
            }
            if (bArr.length % 3 > 0) {
                stringBuffer.setCharAt(stringBuffer.length() - 1, '=');
            }
            if (bArr.length % 3 == 1) {
                stringBuffer.setCharAt(stringBuffer.length() - 2, '=');
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
                int i = str.charAt(length + (-1)) == '=' ? 1 : 0;
                if (str.charAt(length - 2) == '=') {
                    i++;
                }
                int i2 = ((length / 4) * 3) - i;
                byte[] bArr = new byte[i2];
                for (int i3 = 0; i3 < length; i3 += 4) {
                    int i4 = (i3 / 4) * 3;
                    char charAt = str.charAt(i3);
                    char charAt2 = str.charAt(i3 + 1);
                    char charAt3 = str.charAt(i3 + 2);
                    char charAt4 = str.charAt(i3 + 3);
                    byte[] bArr2 = f42594b;
                    int i5 = (bArr2[charAt] << 18) | (bArr2[charAt2] << 12) | (bArr2[charAt3] << 6) | bArr2[charAt4];
                    bArr[i4] = (byte) ((i5 >> 16) & 255);
                    if (i3 < length - 4) {
                        bArr[i4 + 1] = (byte) ((i5 >> 8) & 255);
                        bArr[i4 + 2] = (byte) i5;
                    } else {
                        int i6 = i4 + 1;
                        if (i6 < i2) {
                            bArr[i6] = (byte) ((i5 >> 8) & 255);
                        }
                        int i7 = i4 + 2;
                        if (i7 < i2) {
                            bArr[i7] = (byte) i5;
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
