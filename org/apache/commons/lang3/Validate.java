package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class Validate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified exclusive range of %s to %s";
    public static final String DEFAULT_FINITE_EX_MESSAGE = "The value is invalid: %f";
    public static final String DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified inclusive range of %s to %s";
    public static final String DEFAULT_IS_ASSIGNABLE_EX_MESSAGE = "Cannot assign a %s to a %s";
    public static final String DEFAULT_IS_INSTANCE_OF_EX_MESSAGE = "Expected type: %s, actual: %s";
    public static final String DEFAULT_IS_NULL_EX_MESSAGE = "The validated object is null";
    public static final String DEFAULT_IS_TRUE_EX_MESSAGE = "The validated expression is false";
    public static final String DEFAULT_MATCHES_PATTERN_EX = "The string %s does not match the pattern %s";
    public static final String DEFAULT_NOT_BLANK_EX_MESSAGE = "The validated character sequence is blank";
    public static final String DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE = "The validated array is empty";
    public static final String DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence is empty";
    public static final String DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE = "The validated collection is empty";
    public static final String DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE = "The validated map is empty";
    public static final String DEFAULT_NOT_NAN_EX_MESSAGE = "The validated value is not a number";
    public static final String DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE = "The validated array contains null element at index: %d";
    public static final String DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE = "The validated collection contains null element at index: %d";
    public static final String DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE = "The validated array index is invalid: %d";
    public static final String DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence index is invalid: %d";
    public static final String DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE = "The validated collection index is invalid: %d";
    public static final String DEFAULT_VALID_STATE_EX_MESSAGE = "The validated state is false";
    public transient /* synthetic */ FieldHolder $fh;

    public Validate() {
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

    public static <T> void exclusiveBetween(T t, T t2, Comparable<T> comparable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, t, t2, comparable) == null) {
            if (comparable.compareTo(t) <= 0 || comparable.compareTo(t2) >= 0) {
                throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, comparable, t, t2));
            }
        }
    }

    public static void finite(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Double.valueOf(d2)}) == null) {
            finite(d2, DEFAULT_FINITE_EX_MESSAGE, Double.valueOf(d2));
        }
    }

    public static <T> void inclusiveBetween(T t, T t2, Comparable<T> comparable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, t, t2, comparable) == null) {
            if (comparable.compareTo(t) < 0 || comparable.compareTo(t2) > 0) {
                throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, comparable, t, t2));
            }
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, cls, cls2) == null) || cls.isAssignableFrom(cls2)) {
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = cls2 == null ? StringUtil.NULL_STRING : cls2.getName();
        objArr[1] = cls.getName();
        throw new IllegalArgumentException(String.format(DEFAULT_IS_ASSIGNABLE_EX_MESSAGE, objArr));
    }

    public static void isInstanceOf(Class<?> cls, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, null, cls, obj) == null) || cls.isInstance(obj)) {
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = cls.getName();
        objArr[1] = obj == null ? StringUtil.NULL_STRING : obj.getClass().getName();
        throw new IllegalArgumentException(String.format(DEFAULT_IS_INSTANCE_OF_EX_MESSAGE, objArr));
    }

    public static void isTrue(boolean z, String str, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{Boolean.valueOf(z), str, Long.valueOf(j2)}) == null) && !z) {
            throw new IllegalArgumentException(String.format(str, Long.valueOf(j2)));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65559, null, charSequence, str) == null) && !Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format(DEFAULT_MATCHES_PATTERN_EX, charSequence, str));
        }
    }

    public static <T> T[] noNullElements(T[] tArr, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65564, null, tArr, str, objArr)) == null) {
            notNull(tArr);
            for (int i2 = 0; i2 < tArr.length; i2++) {
                if (tArr[i2] == null) {
                    throw new IllegalArgumentException(String.format(str, ArrayUtils.add((Integer[]) objArr, Integer.valueOf(i2))));
                }
            }
            return tArr;
        }
        return (T[]) ((Object[]) invokeLLL.objValue);
    }

    public static <T extends CharSequence> T notBlank(T t, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65566, null, t, str, objArr)) == null) {
            if (t != null) {
                if (StringUtils.isBlank(t)) {
                    throw new IllegalArgumentException(String.format(str, objArr));
                }
                return t;
            }
            throw new NullPointerException(String.format(str, objArr));
        }
        return (T) invokeLLL.objValue;
    }

    public static <T> T[] notEmpty(T[] tArr, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65574, null, tArr, str, objArr)) == null) {
            if (tArr != null) {
                if (tArr.length != 0) {
                    return tArr;
                }
                throw new IllegalArgumentException(String.format(str, objArr));
            }
            throw new NullPointerException(String.format(str, objArr));
        }
        return (T[]) ((Object[]) invokeLLL.objValue);
    }

    public static void notNaN(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65575, null, new Object[]{Double.valueOf(d2)}) == null) {
            notNaN(d2, DEFAULT_NOT_NAN_EX_MESSAGE, new Object[0]);
        }
    }

    public static <T> T notNull(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65577, null, t)) == null) ? (T) notNull(t, DEFAULT_IS_NULL_EX_MESSAGE, new Object[0]) : (T) invokeL.objValue;
    }

    public static <T> T[] validIndex(T[] tArr, int i2, String str, Object... objArr) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65584, null, tArr, i2, str, objArr)) == null) {
            notNull(tArr);
            if (i2 < 0 || i2 >= tArr.length) {
                throw new IndexOutOfBoundsException(String.format(str, objArr));
            }
            return tArr;
        }
        return (T[]) ((Object[]) invokeLILL.objValue);
    }

    public static void validState(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65585, null, z) == null) && !z) {
            throw new IllegalStateException(DEFAULT_VALID_STATE_EX_MESSAGE);
        }
    }

    public static void finite(double d2, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Double.valueOf(d2), str, objArr}) == null) {
            if (Double.isNaN(d2) || Double.isInfinite(d2)) {
                throw new IllegalArgumentException(String.format(str, objArr));
            }
        }
    }

    public static void isTrue(boolean z, String str, double d2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{Boolean.valueOf(z), str, Double.valueOf(d2)}) == null) && !z) {
            throw new IllegalArgumentException(String.format(str, Double.valueOf(d2)));
        }
    }

    public static void notNaN(double d2, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65576, null, new Object[]{Double.valueOf(d2), str, objArr}) == null) && Double.isNaN(d2)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T notNull(T t, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65578, null, t, str, objArr)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.format(str, objArr));
        }
        return (T) invokeLLL.objValue;
    }

    public static void validState(boolean z, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65586, null, new Object[]{Boolean.valueOf(z), str, objArr}) == null) && !z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static <T> void exclusiveBetween(T t, T t2, Comparable<T> comparable, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, t, t2, comparable, str, objArr) == null) {
            if (comparable.compareTo(t) <= 0 || comparable.compareTo(t2) >= 0) {
                throw new IllegalArgumentException(String.format(str, objArr));
            }
        }
    }

    public static <T> void inclusiveBetween(T t, T t2, Comparable<T> comparable, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65550, null, t, t2, comparable, str, objArr) == null) {
            if (comparable.compareTo(t) < 0 || comparable.compareTo(t2) > 0) {
                throw new IllegalArgumentException(String.format(str, objArr));
            }
        }
    }

    public static void isTrue(boolean z, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{Boolean.valueOf(z), str, objArr}) == null) && !z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65560, null, charSequence, str, str2, objArr) == null) && !Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format(str2, objArr));
        }
    }

    public static void isTrue(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65555, null, z) == null) && !z) {
            throw new IllegalArgumentException(DEFAULT_IS_TRUE_EX_MESSAGE);
        }
    }

    public static <T extends CharSequence> T notBlank(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, t)) == null) ? (T) notBlank(t, DEFAULT_NOT_BLANK_EX_MESSAGE, new Object[0]) : (T) invokeL.objValue;
    }

    public static <T> T[] notEmpty(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, tArr)) == null) ? (T[]) notEmpty(tArr, DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE, new Object[0]) : (T[]) ((Object[]) invokeL.objValue);
    }

    public static <T> T[] validIndex(T[] tArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65583, null, tArr, i2)) == null) ? (T[]) validIndex(tArr, i2, DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE, Integer.valueOf(i2)) : (T[]) ((Object[]) invokeLI.objValue);
    }

    public static void exclusiveBetween(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            if (j4 <= j2 || j4 >= j3) {
                throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, Long.valueOf(j4), Long.valueOf(j2), Long.valueOf(j3)));
            }
        }
    }

    public static void inclusiveBetween(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            if (j4 < j2 || j4 > j3) {
                throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, Long.valueOf(j4), Long.valueOf(j2), Long.valueOf(j3)));
            }
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65552, null, cls, cls2, str, objArr) == null) && !cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isInstanceOf(Class<?> cls, Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65554, null, cls, obj, str, objArr) == null) && !cls.isInstance(obj)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends Collection<?>> T notEmpty(T t, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65570, null, t, str, objArr)) == null) {
            if (t != null) {
                if (t.isEmpty()) {
                    throw new IllegalArgumentException(String.format(str, objArr));
                }
                return t;
            }
            throw new NullPointerException(String.format(str, objArr));
        }
        return (T) invokeLLL.objValue;
    }

    public static <T extends Collection<?>> T validIndex(T t, int i2, String str, Object... objArr) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65582, null, t, i2, str, objArr)) == null) {
            notNull(t);
            if (i2 < 0 || i2 >= t.size()) {
                throw new IndexOutOfBoundsException(String.format(str, objArr));
            }
            return t;
        }
        return (T) invokeLILL.objValue;
    }

    public static void exclusiveBetween(long j2, long j3, long j4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str}) == null) {
            if (j4 <= j2 || j4 >= j3) {
                throw new IllegalArgumentException(String.format(str, new Object[0]));
            }
        }
    }

    public static void inclusiveBetween(long j2, long j3, long j4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str}) == null) {
            if (j4 < j2 || j4 > j3) {
                throw new IllegalArgumentException(String.format(str, new Object[0]));
            }
        }
    }

    public static <T> T[] noNullElements(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, tArr)) == null) ? (T[]) noNullElements(tArr, DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE, new Object[0]) : (T[]) ((Object[]) invokeL.objValue);
    }

    public static void exclusiveBetween(double d2, double d3, double d4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)}) == null) {
            if (d4 <= d2 || d4 >= d3) {
                throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, Double.valueOf(d4), Double.valueOf(d2), Double.valueOf(d3)));
            }
        }
    }

    public static void inclusiveBetween(double d2, double d3, double d4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)}) == null) {
            if (d4 < d2 || d4 > d3) {
                throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, Double.valueOf(d4), Double.valueOf(d2), Double.valueOf(d3)));
            }
        }
    }

    public static <T extends Iterable<?>> T noNullElements(T t, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65562, null, t, str, objArr)) == null) {
            notNull(t);
            int i2 = 0;
            for (Object obj : t) {
                if (obj == null) {
                    throw new IllegalArgumentException(String.format(str, ArrayUtils.addAll(objArr, Integer.valueOf(i2))));
                }
                i2++;
            }
            return t;
        }
        return (T) invokeLLL.objValue;
    }

    public static void exclusiveBetween(double d2, double d3, double d4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), str}) == null) {
            if (d4 <= d2 || d4 >= d3) {
                throw new IllegalArgumentException(String.format(str, new Object[0]));
            }
        }
    }

    public static void inclusiveBetween(double d2, double d3, double d4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), str}) == null) {
            if (d4 < d2 || d4 > d3) {
                throw new IllegalArgumentException(String.format(str, new Object[0]));
            }
        }
    }

    public static <T extends Collection<?>> T notEmpty(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, t)) == null) ? (T) notEmpty(t, DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE, new Object[0]) : (T) invokeL.objValue;
    }

    public static <T extends Collection<?>> T validIndex(T t, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65581, null, t, i2)) == null) ? (T) validIndex(t, i2, DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE, Integer.valueOf(i2)) : (T) invokeLI.objValue;
    }

    public static <T extends Map<?, ?>> T notEmpty(T t, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65572, null, t, str, objArr)) == null) {
            if (t != null) {
                if (t.isEmpty()) {
                    throw new IllegalArgumentException(String.format(str, objArr));
                }
                return t;
            }
            throw new NullPointerException(String.format(str, objArr));
        }
        return (T) invokeLLL.objValue;
    }

    public static <T extends CharSequence> T validIndex(T t, int i2, String str, Object... objArr) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65580, null, t, i2, str, objArr)) == null) {
            notNull(t);
            if (i2 < 0 || i2 >= t.length()) {
                throw new IndexOutOfBoundsException(String.format(str, objArr));
            }
            return t;
        }
        return (T) invokeLILL.objValue;
    }

    public static <T extends Iterable<?>> T noNullElements(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, t)) == null) ? (T) noNullElements(t, DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE, new Object[0]) : (T) invokeL.objValue;
    }

    public static <T extends Map<?, ?>> T notEmpty(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, t)) == null) ? (T) notEmpty(t, DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE, new Object[0]) : (T) invokeL.objValue;
    }

    public static <T extends CharSequence> T validIndex(T t, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65579, null, t, i2)) == null) ? (T) validIndex(t, i2, DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE, Integer.valueOf(i2)) : (T) invokeLI.objValue;
    }

    public static <T extends CharSequence> T notEmpty(T t, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65568, null, t, str, objArr)) == null) {
            if (t != null) {
                if (t.length() != 0) {
                    return t;
                }
                throw new IllegalArgumentException(String.format(str, objArr));
            }
            throw new NullPointerException(String.format(str, objArr));
        }
        return (T) invokeLLL.objValue;
    }

    public static <T extends CharSequence> T notEmpty(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, t)) == null) ? (T) notEmpty(t, DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE, new Object[0]) : (T) invokeL.objValue;
    }
}
