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
/* loaded from: classes6.dex */
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) ? encodeHex(bArr, 0) : (String) invokeL.objValue;
    }

    public static String encodeHex(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i)) == null) {
            int length = bArr.length;
            char[] cArr = new char[(length << 1) + (i > 0 ? length / i : 0)];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (i > 0 && i3 % i == 0 && i2 > 0) {
                    cArr[i2] = SignatureImpl.SEP;
                    i2++;
                }
                int i4 = i2 + 1;
                char[] cArr2 = DIGITS;
                cArr[i2] = cArr2[(bArr[i3] & 240) >>> 4];
                i2 = i4 + 1;
                cArr[i4] = cArr2[bArr[i3] & 15];
            }
            return new String(cArr);
        }
        return (String) invokeLI.objValue;
    }
}
