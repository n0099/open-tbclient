package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class CharSequenceUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NOT_FOUND = -1;
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

    public static int indexOf(CharSequence charSequence, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, charSequence, i2, i3)) == null) {
            if (charSequence instanceof String) {
                return ((String) charSequence).indexOf(i2, i3);
            }
            int length = charSequence.length();
            if (i3 < 0) {
                i3 = 0;
            }
            while (i3 < length) {
                if (charSequence.charAt(i3) == i2) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        return invokeLII.intValue;
    }

    public static int lastIndexOf(CharSequence charSequence, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, charSequence, i2, i3)) == null) {
            if (charSequence instanceof String) {
                return ((String) charSequence).lastIndexOf(i2, i3);
            }
            int length = charSequence.length();
            if (i3 < 0) {
                return -1;
            }
            if (i3 >= length) {
                i3 = length - 1;
            }
            while (i3 >= 0) {
                if (charSequence.charAt(i3) == i2) {
                    return i3;
                }
                i3--;
            }
            return -1;
        }
        return invokeLII.intValue;
    }

    public static boolean regionMatches(CharSequence charSequence, boolean z, int i2, CharSequence charSequence2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{charSequence, Boolean.valueOf(z), Integer.valueOf(i2), charSequence2, Integer.valueOf(i3), Integer.valueOf(i4)})) != null) {
            return invokeCommon.booleanValue;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z, i2, (String) charSequence2, i3, i4);
        }
        int length = charSequence.length() - i2;
        int length2 = charSequence2.length() - i3;
        if (i2 < 0 || i3 < 0 || i4 < 0 || length < i4 || length2 < i4) {
            return false;
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

    public static CharSequence subSequence(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, charSequence, i2)) == null) {
            if (charSequence == null) {
                return null;
            }
            return charSequence.subSequence(i2, charSequence.length());
        }
        return (CharSequence) invokeLI.objValue;
    }

    public static char[] toCharArray(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, charSequence)) == null) {
            if (charSequence instanceof String) {
                return ((String) charSequence).toCharArray();
            }
            int length = charSequence.length();
            char[] cArr = new char[charSequence.length()];
            for (int i2 = 0; i2 < length; i2++) {
                cArr[i2] = charSequence.charAt(i2);
            }
            return cArr;
        }
        return (char[]) invokeL.objValue;
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, charSequence, charSequence2, i2)) == null) ? charSequence.toString().indexOf(charSequence2.toString(), i2) : invokeLLI.intValue;
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, charSequence, charSequence2, i2)) == null) ? charSequence.toString().lastIndexOf(charSequence2.toString(), i2) : invokeLLI.intValue;
    }
}
