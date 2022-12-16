package com.sdk.q;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static char[] a;
    public static byte[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1592839548, "Lcom/sdk/q/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1592839548, "Lcom/sdk/q/d;");
                return;
            }
        }
        a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', WebvttCueParser.CHAR_SLASH};
        b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, BaseNCodec.PAD_DEFAULT, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, ExifInterface.START_CODE, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
        if (r5 != (-1)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
        r1.write(((r4 & 15) << 4) | ((r5 & 60) >>> 2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
        r4 = r2 + 1;
        r2 = r8[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
        if (r2 != 61) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006f, code lost:
        r2 = com.sdk.q.d.b[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0073, code lost:
        if (r4 >= r0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0075, code lost:
        if (r2 == (-1)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007a, code lost:
        if (r2 != (-1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007d, code lost:
        r1.write(r2 | ((r5 & 3) << 6));
        r2 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        InterceptResult invokeL;
        int i;
        byte b2;
        int i2;
        byte b3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            byte[] bytes = str.getBytes(Charset.defaultCharset());
            int length = bytes.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
            int i3 = 0;
            loop0: while (i3 < length) {
                while (true) {
                    i = i3 + 1;
                    b2 = b[bytes[i3]];
                    if (i >= length || b2 != -1) {
                        break;
                    }
                    i3 = i;
                }
                if (b2 == -1) {
                    break;
                }
                while (true) {
                    i2 = i + 1;
                    b3 = b[bytes[i]];
                    if (i2 >= length || b3 != -1) {
                        break;
                    }
                    i = i2;
                }
                if (b3 == -1) {
                    break;
                }
                byteArrayOutputStream.write((b2 << 2) | ((b3 & 48) >>> 4));
                while (true) {
                    int i4 = i2 + 1;
                    byte b4 = bytes[i2];
                    if (b4 == 61) {
                        break loop0;
                    }
                    byte b5 = b[b4];
                    if (i4 >= length || b5 != -1) {
                        break;
                    }
                    i2 = i4;
                }
            }
            return new String(byteArrayOutputStream.toByteArray(), Charset.defaultCharset());
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            byte[] bytes = str.getBytes(IMAudioTransRequest.CHARSET);
            StringBuffer stringBuffer = new StringBuffer();
            int length = bytes.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                int i3 = bytes[i] & 255;
                if (i2 == length) {
                    stringBuffer.append(a[i3 >>> 2]);
                    stringBuffer.append(a[(i3 & 3) << 4]);
                    str2 = "==";
                } else {
                    int i4 = i2 + 1;
                    int i5 = bytes[i2] & 255;
                    if (i4 == length) {
                        stringBuffer.append(a[i3 >>> 2]);
                        stringBuffer.append(a[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                        stringBuffer.append(a[(i5 & 15) << 2]);
                        str2 = "=";
                    } else {
                        int i6 = i4 + 1;
                        int i7 = bytes[i4] & 255;
                        stringBuffer.append(a[i3 >>> 2]);
                        stringBuffer.append(a[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                        stringBuffer.append(a[((i5 & 15) << 2) | ((i7 & 192) >>> 6)]);
                        stringBuffer.append(a[i7 & 63]);
                        i = i6;
                    }
                }
                stringBuffer.append(str2);
                break;
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }
}
