package org.apache.commons.base.binary4util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class CharSequenceUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CharSequenceUtils() {
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

    public static boolean regionMatches(CharSequence charSequence, boolean z, int i, CharSequence charSequence2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{charSequence, Boolean.valueOf(z), Integer.valueOf(i), charSequence2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
                return ((String) charSequence).regionMatches(z, i, (String) charSequence2, i2, i3);
            }
            while (true) {
                int i4 = i3 - 1;
                if (i3 > 0) {
                    int i5 = i + 1;
                    char charAt = charSequence.charAt(i);
                    int i6 = i2 + 1;
                    char charAt2 = charSequence2.charAt(i2);
                    if (charAt != charAt2) {
                        if (!z) {
                            return false;
                        }
                        if (Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                            return false;
                        }
                    }
                    i = i5;
                    i3 = i4;
                    i2 = i6;
                } else {
                    return true;
                }
            }
        } else {
            return invokeCommon.booleanValue;
        }
    }
}
