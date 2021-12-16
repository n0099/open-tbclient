package okio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.io.UnsupportedEncodingException;
/* loaded from: classes4.dex */
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
        MAP = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        URL_MAP = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};
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

    public static byte[] decode(String str) {
        InterceptResult invokeL;
        int i2;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int length = str.length();
            while (length > 0 && ((charAt = str.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
                length--;
            }
            int i3 = (int) ((length * 6) / 8);
            byte[] bArr = new byte[i3];
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                char charAt2 = str.charAt(i7);
                if (charAt2 >= 'A' && charAt2 <= 'Z') {
                    i2 = charAt2 - 'A';
                } else if (charAt2 >= 'a' && charAt2 <= 'z') {
                    i2 = charAt2 - 'G';
                } else if (charAt2 >= '0' && charAt2 <= '9') {
                    i2 = charAt2 + 4;
                } else if (charAt2 == '+' || charAt2 == '-') {
                    i2 = 62;
                } else if (charAt2 == '/' || charAt2 == '_') {
                    i2 = 63;
                } else {
                    if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                        return null;
                    }
                }
                i5 = (i5 << 6) | ((byte) i2);
                i4++;
                if (i4 % 4 == 0) {
                    int i8 = i6 + 1;
                    bArr[i6] = (byte) (i5 >> 16);
                    int i9 = i8 + 1;
                    bArr[i8] = (byte) (i5 >> 8);
                    bArr[i9] = (byte) i5;
                    i6 = i9 + 1;
                }
            }
            int i10 = i4 % 4;
            if (i10 == 1) {
                return null;
            }
            if (i10 == 2) {
                bArr[i6] = (byte) ((i5 << 12) >> 16);
                i6++;
            } else if (i10 == 3) {
                int i11 = i5 << 6;
                int i12 = i6 + 1;
                bArr[i6] = (byte) (i11 >> 16);
                i6 = i12 + 1;
                bArr[i12] = (byte) (i11 >> 8);
            }
            if (i6 == i3) {
                return bArr;
            }
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, 0, bArr2, 0, i6);
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
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3 += 3) {
                int i4 = i2 + 1;
                bArr3[i2] = bArr2[(bArr[i3] & 255) >> 2];
                int i5 = i4 + 1;
                int i6 = i3 + 1;
                bArr3[i4] = bArr2[((bArr[i3] & 3) << 4) | ((bArr[i6] & 255) >> 4)];
                int i7 = i5 + 1;
                int i8 = i3 + 2;
                bArr3[i5] = bArr2[((bArr[i6] & 15) << 2) | ((bArr[i8] & 255) >> 6)];
                i2 = i7 + 1;
                bArr3[i7] = bArr2[bArr[i8] & 63];
            }
            int length2 = bArr.length % 3;
            if (length2 == 1) {
                int i9 = i2 + 1;
                bArr3[i2] = bArr2[(bArr[length] & 255) >> 2];
                int i10 = i9 + 1;
                bArr3[i9] = bArr2[(bArr[length] & 3) << 4];
                bArr3[i10] = 61;
                bArr3[i10 + 1] = 61;
            } else if (length2 == 2) {
                int i11 = i2 + 1;
                bArr3[i2] = bArr2[(bArr[length] & 255) >> 2];
                int i12 = i11 + 1;
                int i13 = length + 1;
                bArr3[i11] = bArr2[((bArr[i13] & 255) >> 4) | ((bArr[length] & 3) << 4)];
                bArr3[i12] = bArr2[(bArr[i13] & 15) << 2];
                bArr3[i12 + 1] = 61;
            }
            try {
                return new String(bArr3, "US-ASCII");
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return (String) invokeLL.objValue;
    }
}
