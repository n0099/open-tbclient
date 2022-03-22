package okio;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class Utf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Utf8() {
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

    public static long size(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? size(str, 0, str.length()) : invokeL.longValue;
    }

    public static long size(String str, int i, int i2) {
        InterceptResult invokeLII;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, str, i, i2)) == null) {
            if (str != null) {
                if (i < 0) {
                    throw new IllegalArgumentException("beginIndex < 0: " + i);
                } else if (i2 >= i) {
                    if (i2 > str.length()) {
                        throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                    }
                    long j2 = 0;
                    while (i < i2) {
                        char charAt = str.charAt(i);
                        if (charAt < 128) {
                            j2++;
                        } else {
                            if (charAt < 2048) {
                                j = 2;
                            } else if (charAt < 55296 || charAt > 57343) {
                                j = 3;
                            } else {
                                int i3 = i + 1;
                                char charAt2 = i3 < i2 ? str.charAt(i3) : (char) 0;
                                if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                                    j2++;
                                    i = i3;
                                } else {
                                    j2 += 4;
                                    i += 2;
                                }
                            }
                            j2 += j;
                        }
                        i++;
                    }
                    return j2;
                } else {
                    throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
                }
            }
            throw new IllegalArgumentException("string == null");
        }
        return invokeLII.longValue;
    }
}
