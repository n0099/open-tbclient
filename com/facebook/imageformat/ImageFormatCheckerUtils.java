package com.facebook.imageformat;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes12.dex */
public class ImageFormatCheckerUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ImageFormatCheckerUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public static int indexOfPattern(byte[] bArr, int i2, byte[] bArr2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bArr, Integer.valueOf(i2), bArr2, Integer.valueOf(i3)})) == null) {
            Preconditions.checkNotNull(bArr);
            Preconditions.checkNotNull(bArr2);
            if (i3 > i2) {
                return -1;
            }
            int i4 = 0;
            byte b2 = bArr2[0];
            int i5 = i2 - i3;
            while (i4 <= i5) {
                if (bArr[i4] != b2) {
                    do {
                        i4++;
                        if (i4 > i5) {
                            break;
                        }
                    } while (bArr[i4] != b2);
                }
                if (i4 <= i5) {
                    int i6 = i4 + 1;
                    int i7 = (i6 + i3) - 1;
                    for (int i8 = 1; i6 < i7 && bArr[i6] == bArr2[i8]; i8++) {
                        i6++;
                    }
                    if (i6 == i7) {
                        return i4;
                    }
                }
                i4++;
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
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
