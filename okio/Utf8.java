package okio;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class Utf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Utf8() {
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

    public static long size(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? size(str, 0, str.length()) : invokeL.longValue;
    }

    public static long size(String str, int i2, int i3) {
        InterceptResult invokeLII;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, str, i2, i3)) == null) {
            if (str != null) {
                if (i2 < 0) {
                    throw new IllegalArgumentException("beginIndex < 0: " + i2);
                } else if (i3 >= i2) {
                    if (i3 > str.length()) {
                        throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
                    }
                    long j2 = 0;
                    while (i2 < i3) {
                        char charAt = str.charAt(i2);
                        if (charAt < 128) {
                            j2++;
                        } else {
                            if (charAt < 2048) {
                                j = 2;
                            } else if (charAt < 55296 || charAt > 57343) {
                                j = 3;
                            } else {
                                int i4 = i2 + 1;
                                char charAt2 = i4 < i3 ? str.charAt(i4) : (char) 0;
                                if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                                    j2++;
                                    i2 = i4;
                                } else {
                                    j2 += 4;
                                    i2 += 2;
                                }
                            }
                            j2 += j;
                        }
                        i2++;
                    }
                    return j2;
                } else {
                    throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
                }
            }
            throw new IllegalArgumentException("string == null");
        }
        return invokeLII.longValue;
    }
}
