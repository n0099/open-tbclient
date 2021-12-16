package org.apache.commons.codec.binary4util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CharSequenceUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CharSequenceUtils() {
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

    public static boolean regionMatches(CharSequence charSequence, boolean z, int i2, CharSequence charSequence2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{charSequence, Boolean.valueOf(z), Integer.valueOf(i2), charSequence2, Integer.valueOf(i3), Integer.valueOf(i4)})) != null) {
            return invokeCommon.booleanValue;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z, i2, (String) charSequence2, i3, i4);
        }
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i6 = i2 + 1;
            char charAt = charSequence.charAt(i2);
            int i7 = i3 + 1;
            char charAt2 = charSequence2.charAt(i3);
            if (charAt != charAt2) {
                if (!z) {
                    return false;
                }
                if (Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                    return false;
                }
            }
            i2 = i6;
            i4 = i5;
            i3 = i7;
        }
    }
}
