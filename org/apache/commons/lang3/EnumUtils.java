package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class EnumUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CANNOT_STORE_S_S_VALUES_IN_S_BITS = "Cannot store %s %s values in %s bits";
    public static final String ENUM_CLASS_MUST_BE_DEFINED = "EnumClass must be defined.";
    public static final String NULL_ELEMENTS_NOT_PERMITTED = "null elements not permitted";
    public static final String S_DOES_NOT_SEEM_TO_BE_AN_ENUM_TYPE = "%s does not seem to be an Enum type";
    public transient /* synthetic */ FieldHolder $fh;

    public EnumUtils() {
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

    public static <E extends Enum<E>> Class<E> asEnum(Class<E> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
            Validate.notNull(cls, ENUM_CLASS_MUST_BE_DEFINED, new Object[0]);
            Validate.isTrue(cls.isEnum(), S_DOES_NOT_SEEM_TO_BE_AN_ENUM_TYPE, cls);
            return cls;
        }
        return (Class) invokeL.objValue;
    }

    public static <E extends Enum<E>> Class<E> checkBitVectorable(Class<E> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cls)) == null) {
            Enum[] enumArr = (Enum[]) asEnum(cls).getEnumConstants();
            Validate.isTrue(enumArr.length <= 64, CANNOT_STORE_S_S_VALUES_IN_S_BITS, Integer.valueOf(enumArr.length), cls.getSimpleName(), 64);
            return cls;
        }
        return (Class) invokeL.objValue;
    }

    public static <E extends Enum<E>> long generateBitVector(Class<E> cls, Iterable<? extends E> iterable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, iterable)) == null) {
            checkBitVectorable(cls);
            Validate.notNull(iterable);
            Iterator<? extends E> it = iterable.iterator();
            long j2 = 0;
            while (it.hasNext()) {
                E next = it.next();
                Validate.isTrue(next != null, NULL_ELEMENTS_NOT_PERMITTED, new Object[0]);
                j2 |= 1 << next.ordinal();
            }
            return j2;
        }
        return invokeLL.longValue;
    }

    public static <E extends Enum<E>> long[] generateBitVectors(Class<E> cls, Iterable<? extends E> iterable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, cls, iterable)) == null) {
            asEnum(cls);
            Validate.notNull(iterable);
            EnumSet noneOf = EnumSet.noneOf(cls);
            Iterator<? extends E> it = iterable.iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                E next = it.next();
                if (next == null) {
                    z = false;
                }
                Validate.isTrue(z, NULL_ELEMENTS_NOT_PERMITTED, new Object[0]);
                noneOf.add(next);
            }
            long[] jArr = new long[((cls.getEnumConstants().length - 1) / 64) + 1];
            Iterator it2 = noneOf.iterator();
            while (it2.hasNext()) {
                Enum r0 = (Enum) it2.next();
                int ordinal = r0.ordinal() / 64;
                jArr[ordinal] = jArr[ordinal] | (1 << (r0.ordinal() % 64));
            }
            ArrayUtils.reverse(jArr);
            return jArr;
        }
        return (long[]) invokeLL.objValue;
    }

    public static <E extends Enum<E>> E getEnum(Class<E> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, cls, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                return (E) Enum.valueOf(cls, str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return (E) invokeLL.objValue;
    }

    public static <E extends Enum<E>> List<E> getEnumList(Class<E> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cls)) == null) ? new ArrayList(Arrays.asList(cls.getEnumConstants())) : (List) invokeL.objValue;
    }

    public static <E extends Enum<E>> Map<String, E> getEnumMap(Class<E> cls) {
        InterceptResult invokeL;
        E[] enumConstants;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (E e2 : cls.getEnumConstants()) {
                linkedHashMap.put(e2.name(), e2);
            }
            return linkedHashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static <E extends Enum<E>> boolean isValidEnum(Class<E> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, cls, str)) == null) {
            if (str == null) {
                return false;
            }
            try {
                Enum.valueOf(cls, str);
                return true;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static <E extends Enum<E>> EnumSet<E> processBitVector(Class<E> cls, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65547, null, cls, j2)) == null) {
            checkBitVectorable(cls).getEnumConstants();
            return processBitVectors(cls, j2);
        }
        return (EnumSet) invokeLJ.objValue;
    }

    public static <E extends Enum<E>> EnumSet<E> processBitVectors(Class<E> cls, long... jArr) {
        InterceptResult invokeLL;
        E[] enumConstants;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, cls, jArr)) == null) {
            EnumSet<E> noneOf = EnumSet.noneOf(asEnum(cls));
            long[] clone = ArrayUtils.clone((long[]) Validate.notNull(jArr));
            ArrayUtils.reverse(clone);
            for (E e2 : cls.getEnumConstants()) {
                int ordinal = e2.ordinal() / 64;
                if (ordinal < clone.length && (clone[ordinal] & (1 << (e2.ordinal() % 64))) != 0) {
                    noneOf.add(e2);
                }
            }
            return noneOf;
        }
        return (EnumSet) invokeLL.objValue;
    }

    public static <E extends Enum<E>> long generateBitVector(Class<E> cls, E... eArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, eArr)) == null) {
            Validate.noNullElements(eArr);
            return generateBitVector(cls, Arrays.asList(eArr));
        }
        return invokeLL.longValue;
    }

    public static <E extends Enum<E>> long[] generateBitVectors(Class<E> cls, E... eArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, cls, eArr)) == null) {
            asEnum(cls);
            Validate.noNullElements(eArr);
            EnumSet noneOf = EnumSet.noneOf(cls);
            Collections.addAll(noneOf, eArr);
            long[] jArr = new long[((cls.getEnumConstants().length - 1) / 64) + 1];
            Iterator it = noneOf.iterator();
            while (it.hasNext()) {
                Enum r0 = (Enum) it.next();
                int ordinal = r0.ordinal() / 64;
                jArr[ordinal] = jArr[ordinal] | (1 << (r0.ordinal() % 64));
            }
            ArrayUtils.reverse(jArr);
            return jArr;
        }
        return (long[]) invokeLL.objValue;
    }
}
