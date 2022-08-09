package okio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* loaded from: classes8.dex */
public final class Base64 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] MAP;
    public static final byte[] URL_MAP;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1040892395, "Lokio/Base64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1040892395, "Lokio/Base64;");
                return;
            }
        }
        MAP = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, Cea608Decoder.CTRL_END_OF_CAPTION};
        URL_MAP = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
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

    public static byte[] decode(String str) {
        InterceptResult invokeL;
        int i;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int length = str.length();
            while (length > 0 && ((charAt = str.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
                length--;
            }
            int i2 = (int) ((length * 6) / 8);
            byte[] bArr = new byte[i2];
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                char charAt2 = str.charAt(i6);
                if (charAt2 >= 'A' && charAt2 <= 'Z') {
                    i = charAt2 - 'A';
                } else if (charAt2 >= 'a' && charAt2 <= 'z') {
                    i = charAt2 - 'G';
                } else if (charAt2 >= '0' && charAt2 <= '9') {
                    i = charAt2 + 4;
                } else if (charAt2 == '+' || charAt2 == '-') {
                    i = 62;
                } else if (charAt2 == '/' || charAt2 == '_') {
                    i = 63;
                } else {
                    if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                        return null;
                    }
                }
                i4 = (i4 << 6) | ((byte) i);
                i3++;
                if (i3 % 4 == 0) {
                    int i7 = i5 + 1;
                    bArr[i5] = (byte) (i4 >> 16);
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) (i4 >> 8);
                    bArr[i8] = (byte) i4;
                    i5 = i8 + 1;
                }
            }
            int i9 = i3 % 4;
            if (i9 == 1) {
                return null;
            }
            if (i9 == 2) {
                bArr[i5] = (byte) ((i4 << 12) >> 16);
                i5++;
            } else if (i9 == 3) {
                int i10 = i4 << 6;
                int i11 = i5 + 1;
                bArr[i5] = (byte) (i10 >> 16);
                i5 = i11 + 1;
                bArr[i11] = (byte) (i10 >> 8);
            }
            if (i5 == i2) {
                return bArr;
            }
            byte[] bArr2 = new byte[i5];
            System.arraycopy(bArr, 0, bArr2, 0, i5);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) ? encode(bArr, MAP) : (String) invokeL.objValue;
    }

    public static String encodeUrl(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) ? encode(bArr, URL_MAP) : (String) invokeL.objValue;
    }

    public static String encode(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, bArr2)) == null) {
            byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
            int length = bArr.length - (bArr.length % 3);
            int i = 0;
            for (int i2 = 0; i2 < length; i2 += 3) {
                int i3 = i + 1;
                bArr3[i] = bArr2[(bArr[i2] & 255) >> 2];
                int i4 = i3 + 1;
                int i5 = i2 + 1;
                bArr3[i3] = bArr2[((bArr[i2] & 3) << 4) | ((bArr[i5] & 255) >> 4)];
                int i6 = i4 + 1;
                int i7 = i2 + 2;
                bArr3[i4] = bArr2[((bArr[i5] & 15) << 2) | ((bArr[i7] & 255) >> 6)];
                i = i6 + 1;
                bArr3[i6] = bArr2[bArr[i7] & 63];
            }
            int length2 = bArr.length % 3;
            if (length2 == 1) {
                int i8 = i + 1;
                bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
                int i9 = i8 + 1;
                bArr3[i8] = bArr2[(bArr[length] & 3) << 4];
                bArr3[i9] = BaseNCodec.PAD_DEFAULT;
                bArr3[i9 + 1] = BaseNCodec.PAD_DEFAULT;
            } else if (length2 == 2) {
                int i10 = i + 1;
                bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
                int i11 = i10 + 1;
                int i12 = length + 1;
                bArr3[i10] = bArr2[((bArr[i12] & 255) >> 4) | ((bArr[length] & 3) << 4)];
                bArr3[i11] = bArr2[(bArr[i12] & 15) << 2];
                bArr3[i11 + 1] = BaseNCodec.PAD_DEFAULT;
            }
            try {
                return new String(bArr3, "US-ASCII");
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return (String) invokeLL.objValue;
    }
}
