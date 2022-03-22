package com.facebook.imageformat;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class ImageFormatCheckerUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ImageFormatCheckerUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static byte[] asciiBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            Preconditions.checkNotNull(str);
            try {
                return str.getBytes(HTTP.ASCII);
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("ASCII not found!", e2);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static int indexOfPattern(byte[] bArr, int i, byte[] bArr2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2)})) == null) {
            Preconditions.checkNotNull(bArr);
            Preconditions.checkNotNull(bArr2);
            if (i2 > i) {
                return -1;
            }
            int i3 = 0;
            byte b2 = bArr2[0];
            int i4 = i - i2;
            while (i3 <= i4) {
                if (bArr[i3] != b2) {
                    do {
                        i3++;
                        if (i3 > i4) {
                            break;
                        }
                    } while (bArr[i3] != b2);
                }
                if (i3 <= i4) {
                    int i5 = i3 + 1;
                    int i6 = (i5 + i2) - 1;
                    for (int i7 = 1; i5 < i6 && bArr[i5] == bArr2[i7]; i7++) {
                        i5++;
                    }
                    if (i5 == i6) {
                        return i3;
                    }
                }
                i3++;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static boolean startsWithPattern(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, bArr2)) == null) {
            Preconditions.checkNotNull(bArr);
            Preconditions.checkNotNull(bArr2);
            if (bArr2.length > bArr.length) {
                return false;
            }
            for (int i = 0; i < bArr2.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
