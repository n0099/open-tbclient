package com.facebook.common.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
import org.apache.commons.lang3.text.FormattableUtils;
/* loaded from: classes3.dex */
public final class Preconditions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Preconditions() {
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

    public static String badElementIndex(int i2, int i3, @Nullable String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65537, null, i2, i3, str)) == null) {
            if (i2 < 0) {
                return format("%s (%s) must not be negative", str, Integer.valueOf(i2));
            }
            if (i3 >= 0) {
                return format("%s (%s) must be less than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
            }
            throw new IllegalArgumentException("negative size: " + i3);
        }
        return (String) invokeIIL.objValue;
    }

    public static String badPositionIndex(int i2, int i3, @Nullable String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i2, i3, str)) == null) {
            if (i2 < 0) {
                return format("%s (%s) must not be negative", str, Integer.valueOf(i2));
            }
            if (i3 >= 0) {
                return format("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
            }
            throw new IllegalArgumentException("negative size: " + i3);
        }
        return (String) invokeIIL.objValue;
    }

    public static String badPositionIndexes(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65539, null, i2, i3, i4)) == null) {
            if (i2 < 0 || i2 > i4) {
                return badPositionIndex(i2, i4, "start index");
            }
            return (i3 < 0 || i3 > i4) ? badPositionIndex(i3, i4, "end index") : format("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        return (String) invokeIII.objValue;
    }

    public static void checkArgument(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) && !z) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkElementIndex(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65543, null, i2, i3)) == null) ? checkElementIndex(i2, i3, "index") : invokeII.intValue;
    }

    public static <T> T checkNotNull(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, t)) == null) {
            if (t != null) {
                return t;
            }
            throw null;
        }
        return (T) invokeL.objValue;
    }

    public static int checkPositionIndex(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65548, null, i2, i3)) == null) ? checkPositionIndex(i2, i3, "index") : invokeII.intValue;
    }

    public static void checkPositionIndexes(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65550, null, i2, i3, i4) == null) {
            if (i2 < 0 || i3 < i2 || i3 > i4) {
                throw new IndexOutOfBoundsException(badPositionIndexes(i2, i3, i4));
            }
        }
    }

    public static void checkState(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65551, null, z) == null) && !z) {
            throw new IllegalStateException();
        }
    }

    public static String format(@Nullable String str, @Nullable Object... objArr) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, str, objArr)) == null) {
            String valueOf = String.valueOf(str);
            StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
            int i2 = 0;
            int i3 = 0;
            while (i2 < objArr.length && (indexOf = valueOf.indexOf(FormattableUtils.SIMPLEST_FORMAT, i3)) != -1) {
                sb.append(valueOf.substring(i3, indexOf));
                sb.append(objArr[i2]);
                i3 = indexOf + 2;
                i2++;
            }
            sb.append(valueOf.substring(i3));
            if (i2 < objArr.length) {
                sb.append(" [");
                sb.append(objArr[i2]);
                for (int i4 = i2 + 1; i4 < objArr.length; i4++) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(objArr[i4]);
                }
                sb.append(']');
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static void checkArgument(boolean z, @Nullable Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65541, null, z, obj) == null) && !z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int checkElementIndex(int i2, int i3, @Nullable String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65544, null, i2, i3, str)) == null) {
            if (i2 < 0 || i2 >= i3) {
                throw new IndexOutOfBoundsException(badElementIndex(i2, i3, str));
            }
            return i2;
        }
        return invokeIIL.intValue;
    }

    public static <T> T checkNotNull(T t, @Nullable Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, t, obj)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.valueOf(obj));
        }
        return (T) invokeLL.objValue;
    }

    public static int checkPositionIndex(int i2, int i3, @Nullable String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65549, null, i2, i3, str)) == null) {
            if (i2 < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException(badPositionIndex(i2, i3, str));
            }
            return i2;
        }
        return invokeIIL.intValue;
    }

    public static void checkState(boolean z, @Nullable Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65552, null, z, obj) == null) && !z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z, @Nullable String str, @Nullable Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Boolean.valueOf(z), str, objArr}) == null) && !z) {
            throw new IllegalArgumentException(format(str, objArr));
        }
    }

    public static <T> T checkNotNull(T t, @Nullable String str, @Nullable Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, t, str, objArr)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(format(str, objArr));
        }
        return (T) invokeLLL.objValue;
    }

    public static void checkState(boolean z, @Nullable String str, @Nullable Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Boolean.valueOf(z), str, objArr}) == null) && !z) {
            throw new IllegalStateException(format(str, objArr));
        }
    }
}
