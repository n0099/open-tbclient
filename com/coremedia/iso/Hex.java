package com.coremedia.iso;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes7.dex */
public class Hex {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] DIGITS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(153869742, "Lcom/coremedia/iso/Hex;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(153869742, "Lcom/coremedia/iso/Hex;");
                return;
            }
        }
        DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public Hex() {
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

    public static byte[] decodeHex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            while (i < str.length()) {
                int i2 = i + 2;
                byteArrayOutputStream.write(Integer.parseInt(str.substring(i, i2), 16));
                i = i2;
            }
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public static String encodeHex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            return encodeHex(bArr, 0);
        }
        return (String) invokeL.objValue;
    }

    public static String encodeHex(byte[] bArr, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i)) == null) {
            int length = bArr.length;
            int i3 = length << 1;
            if (i > 0) {
                i2 = length / i;
            } else {
                i2 = 0;
            }
            char[] cArr = new char[i3 + i2];
            int i4 = 0;
            for (int i5 = 0; i5 < length; i5++) {
                if (i > 0 && i5 % i == 0 && i4 > 0) {
                    cArr[i4] = SignatureImpl.SEP;
                    i4++;
                }
                int i6 = i4 + 1;
                char[] cArr2 = DIGITS;
                cArr[i4] = cArr2[(bArr[i5] & 240) >>> 4];
                i4 = i6 + 1;
                cArr[i6] = cArr2[bArr[i5] & 15];
            }
            return new String(cArr);
        }
        return (String) invokeLI.objValue;
    }
}
