package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.mutable.MutableInt;
/* loaded from: classes3.dex */
public class ArrayUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean[] EMPTY_BOOLEAN_ARRAY;
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY;
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY;
    public static final char[] EMPTY_CHAR_ARRAY;
    public static final Class<?>[] EMPTY_CLASS_ARRAY;
    public static final double[] EMPTY_DOUBLE_ARRAY;
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY;
    public static final float[] EMPTY_FLOAT_ARRAY;
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY;
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY;
    public static final int[] EMPTY_INT_ARRAY;
    public static final long[] EMPTY_LONG_ARRAY;
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY;
    public static final Object[] EMPTY_OBJECT_ARRAY;
    public static final short[] EMPTY_SHORT_ARRAY;
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY;
    public static final String[] EMPTY_STRING_ARRAY;
    public static final int INDEX_NOT_FOUND = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1238771096, "Lorg/apache/commons/lang3/ArrayUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1238771096, "Lorg/apache/commons/lang3/ArrayUtils;");
                return;
            }
        }
        EMPTY_OBJECT_ARRAY = new Object[0];
        EMPTY_CLASS_ARRAY = new Class[0];
        EMPTY_STRING_ARRAY = new String[0];
        EMPTY_LONG_ARRAY = new long[0];
        EMPTY_LONG_OBJECT_ARRAY = new Long[0];
        EMPTY_INT_ARRAY = new int[0];
        EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
        EMPTY_SHORT_ARRAY = new short[0];
        EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
        EMPTY_BYTE_ARRAY = new byte[0];
        EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
        EMPTY_DOUBLE_ARRAY = new double[0];
        EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
        EMPTY_FLOAT_ARRAY = new float[0];
        EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
        EMPTY_BOOLEAN_ARRAY = new boolean[0];
        EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
        EMPTY_CHAR_ARRAY = new char[0];
        EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];
    }

    public ArrayUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static <T> T[] add(T[] tArr, T t) {
        InterceptResult invokeLL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, tArr, t)) == null) {
            if (tArr != null) {
                cls = tArr.getClass().getComponentType();
            } else if (t != null) {
                cls = t.getClass();
            } else {
                throw new IllegalArgumentException("Arguments cannot both be null");
            }
            T[] tArr2 = (T[]) ((Object[]) copyArrayGrow1(tArr, cls));
            tArr2[tArr2.length - 1] = t;
            return tArr2;
        }
        return (T[]) ((Object[]) invokeLL.objValue);
    }

    public static <T> T[] addAll(T[] tArr, T... tArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, tArr, tArr2)) == null) {
            if (tArr == null) {
                return (T[]) clone(tArr2);
            }
            if (tArr2 == null) {
                return (T[]) clone(tArr);
            }
            Class<?> componentType = tArr.getClass().getComponentType();
            T[] tArr3 = (T[]) ((Object[]) Array.newInstance(componentType, tArr.length + tArr2.length));
            System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
            try {
                System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
                return tArr3;
            } catch (ArrayStoreException e2) {
                Class<?> componentType2 = tArr2.getClass().getComponentType();
                if (!componentType.isAssignableFrom(componentType2)) {
                    throw new IllegalArgumentException("Cannot store " + componentType2.getName() + " in an array of " + componentType.getName(), e2);
                }
                throw e2;
            }
        }
        return (T[]) ((Object[]) invokeLL.objValue);
    }

    public static <T> T[] clone(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, tArr)) == null) {
            if (tArr == null) {
                return null;
            }
            return (T[]) ((Object[]) tArr.clone());
        }
        return (T[]) ((Object[]) invokeL.objValue);
    }

    public static boolean contains(Object[] objArr, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65582, null, objArr, obj)) == null) ? indexOf(objArr, obj) != -1 : invokeLL.booleanValue;
    }

    public static Object copyArrayGrow1(Object obj, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65585, null, obj, cls)) == null) {
            if (obj != null) {
                int length = Array.getLength(obj);
                Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + 1);
                System.arraycopy(obj, 0, newInstance, 0, length);
                return newInstance;
            }
            return Array.newInstance(cls, 1);
        }
        return invokeLL.objValue;
    }

    public static int getLength(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, obj)) == null) {
            if (obj == null) {
                return 0;
            }
            return Array.getLength(obj);
        }
        return invokeL.intValue;
    }

    public static int hashCode(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65587, null, obj)) == null) ? new HashCodeBuilder().append(obj).toHashCode() : invokeL.intValue;
    }

    public static int indexOf(Object[] objArr, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65602, null, objArr, obj)) == null) ? indexOf(objArr, obj, 0) : invokeLL.intValue;
    }

    public static boolean isEmpty(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65614, null, objArr)) == null) ? getLength(objArr) == 0 : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isEquals(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65617, null, obj, obj2)) == null) ? new EqualsBuilder().append(obj, obj2).isEquals() : invokeLL.booleanValue;
    }

    public static <T> boolean isNotEmpty(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65624, null, tArr)) == null) ? !isEmpty(tArr) : invokeL.booleanValue;
    }

    public static boolean isSameLength(Object[] objArr, Object[] objArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65633, null, objArr, objArr2)) == null) ? getLength(objArr) == getLength(objArr2) : invokeLL.booleanValue;
    }

    public static boolean isSameType(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65636, null, obj, obj2)) == null) {
            if (obj != null && obj2 != null) {
                return obj.getClass().getName().equals(obj2.getClass().getName());
            }
            throw new IllegalArgumentException("The Array must not be null");
        }
        return invokeLL.booleanValue;
    }

    public static <T extends Comparable<? super T>> boolean isSorted(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65643, null, tArr)) == null) ? isSorted(tArr, new Comparator<T>() { // from class: org.apache.commons.lang3.ArrayUtils.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Incorrect types in method signature: (TT;TT;)I */
            @Override // java.util.Comparator
            public int compare(Comparable comparable, Comparable comparable2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, comparable, comparable2)) == null) ? comparable.compareTo(comparable2) : invokeLL.intValue;
            }
        }) : invokeL.booleanValue;
    }

    public static int lastIndexOf(Object[] objArr, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65661, null, objArr, obj)) == null) ? lastIndexOf(objArr, obj, Integer.MAX_VALUE) : invokeLL.intValue;
    }

    public static <T> T[] nullToEmpty(T[] tArr, Class<T[]> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65682, null, tArr, cls)) == null) {
            if (cls != null) {
                return tArr == null ? cls.cast(Array.newInstance(cls.getComponentType(), 0)) : tArr;
            }
            throw new IllegalArgumentException("The type must not be null");
        }
        return (T[]) ((Object[]) invokeLL.objValue);
    }

    public static <T> T[] remove(T[] tArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65694, null, tArr, i2)) == null) ? (T[]) ((Object[]) remove((Object) tArr, i2)) : (T[]) ((Object[]) invokeLI.objValue);
    }

    public static <T> T[] removeAll(T[] tArr, int... iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65705, null, tArr, iArr)) == null) ? (T[]) ((Object[]) removeAll((Object) tArr, iArr)) : (T[]) ((Object[]) invokeLL.objValue);
    }

    public static boolean[] removeAllOccurences(boolean[] zArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(65716, null, zArr, z)) != null) {
            return (boolean[]) invokeLZ.objValue;
        }
        int indexOf = indexOf(zArr, z);
        if (indexOf == -1) {
            return clone(zArr);
        }
        int[] iArr = new int[zArr.length - indexOf];
        iArr[0] = indexOf;
        int i2 = 1;
        while (true) {
            int indexOf2 = indexOf(zArr, z, iArr[i2 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i2] = indexOf2;
                i2++;
            } else {
                return removeAll(zArr, Arrays.copyOf(iArr, i2));
            }
        }
    }

    public static <T> T[] removeElement(T[] tArr, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65723, null, tArr, obj)) == null) {
            int indexOf = indexOf(tArr, obj);
            if (indexOf == -1) {
                return (T[]) clone(tArr);
            }
            return (T[]) remove((Object[]) tArr, indexOf);
        }
        return (T[]) ((Object[]) invokeLL.objValue);
    }

    public static <T> T[] removeElements(T[] tArr, T... tArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65732, null, tArr, tArr2)) == null) {
            if (!isEmpty(tArr) && !isEmpty(tArr2)) {
                HashMap hashMap = new HashMap(tArr2.length);
                for (T t : tArr2) {
                    MutableInt mutableInt = (MutableInt) hashMap.get(t);
                    if (mutableInt == null) {
                        hashMap.put(t, new MutableInt(1));
                    } else {
                        mutableInt.increment();
                    }
                }
                BitSet bitSet = new BitSet();
                for (int i2 = 0; i2 < tArr.length; i2++) {
                    T t2 = tArr[i2];
                    MutableInt mutableInt2 = (MutableInt) hashMap.get(t2);
                    if (mutableInt2 != null) {
                        if (mutableInt2.decrementAndGet() == 0) {
                            hashMap.remove(t2);
                        }
                        bitSet.set(i2);
                    }
                }
                return (T[]) ((Object[]) removeAll(tArr, bitSet));
            }
            return (T[]) clone(tArr);
        }
        return (T[]) ((Object[]) invokeLL.objValue);
    }

    public static void reverse(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65747, null, objArr) == null) || objArr == null) {
            return;
        }
        reverse(objArr, 0, objArr.length);
    }

    public static void shift(Object[] objArr, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65765, null, objArr, i2) == null) || objArr == null) {
            return;
        }
        shift(objArr, 0, objArr.length, i2);
    }

    public static <T> T[] subarray(T[] tArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65777, null, tArr, i2, i3)) == null) {
            if (tArr == null) {
                return null;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (i3 > tArr.length) {
                i3 = tArr.length;
            }
            int i4 = i3 - i2;
            Class<?> componentType = tArr.getClass().getComponentType();
            if (i4 <= 0) {
                return (T[]) ((Object[]) Array.newInstance(componentType, 0));
            }
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(componentType, i4));
            System.arraycopy(tArr, i2, tArr2, 0, i4);
            return tArr2;
        }
        return (T[]) ((Object[]) invokeLII.objValue);
    }

    public static void swap(Object[] objArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65792, null, objArr, i2, i3) == null) || objArr == null || objArr.length == 0) {
            return;
        }
        swap(objArr, i2, i3, 1);
    }

    public static <T> T[] toArray(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65798, null, tArr)) == null) ? tArr : (T[]) ((Object[]) invokeL.objValue);
    }

    public static Map<Object, Object> toMap(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65799, null, objArr)) == null) {
            if (objArr == null) {
                return null;
            }
            HashMap hashMap = new HashMap((int) (objArr.length * 1.5d));
            for (int i2 = 0; i2 < objArr.length; i2++) {
                Object obj = objArr[i2];
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    hashMap.put(entry.getKey(), entry.getValue());
                } else if (obj instanceof Object[]) {
                    Object[] objArr2 = (Object[]) obj;
                    if (objArr2.length >= 2) {
                        hashMap.put(objArr2[0], objArr2[1]);
                    } else {
                        throw new IllegalArgumentException("Array element " + i2 + ", '" + obj + "', has a length less than 2");
                    }
                } else {
                    throw new IllegalArgumentException("Array element " + i2 + ", '" + obj + "', is neither of type Map.Entry nor an Array");
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Character[] toObject(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65802, null, cArr)) == null) {
            if (cArr == null) {
                return null;
            }
            if (cArr.length == 0) {
                return EMPTY_CHARACTER_OBJECT_ARRAY;
            }
            Character[] chArr = new Character[cArr.length];
            for (int i2 = 0; i2 < cArr.length; i2++) {
                chArr[i2] = Character.valueOf(cArr[i2]);
            }
            return chArr;
        }
        return (Character[]) invokeL.objValue;
    }

    public static char[] toPrimitive(Character[] chArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65811, null, chArr)) == null) {
            if (chArr == null) {
                return null;
            }
            if (chArr.length == 0) {
                return EMPTY_CHAR_ARRAY;
            }
            char[] cArr = new char[chArr.length];
            for (int i2 = 0; i2 < chArr.length; i2++) {
                cArr[i2] = chArr[i2].charValue();
            }
            return cArr;
        }
        return (char[]) invokeL.objValue;
    }

    public static String toString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65825, null, obj)) == null) ? toString(obj, StringUtil.EMPTY_ARRAY) : (String) invokeL.objValue;
    }

    public static long[] clone(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, jArr)) == null) {
            if (jArr == null) {
                return null;
            }
            return (long[]) jArr.clone();
        }
        return (long[]) invokeL.objValue;
    }

    public static boolean contains(long[] jArr, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65581, null, jArr, j)) == null) ? indexOf(jArr, j) != -1 : invokeLJ.booleanValue;
    }

    public static int indexOf(Object[] objArr, Object obj, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65603, null, objArr, obj, i2)) == null) {
            if (objArr == null) {
                return -1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (obj == null) {
                while (i2 < objArr.length) {
                    if (objArr[i2] == null) {
                        return i2;
                    }
                    i2++;
                }
            } else {
                while (i2 < objArr.length) {
                    if (obj.equals(objArr[i2])) {
                        return i2;
                    }
                    i2++;
                }
            }
            return -1;
        }
        return invokeLLI.intValue;
    }

    public static boolean isEmpty(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65613, null, jArr)) == null) ? getLength(jArr) == 0 : invokeL.booleanValue;
    }

    public static boolean isNotEmpty(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65623, null, jArr)) == null) ? !isEmpty(jArr) : invokeL.booleanValue;
    }

    public static boolean isSameLength(long[] jArr, long[] jArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65632, null, jArr, jArr2)) == null) ? getLength(jArr) == getLength(jArr2) : invokeLL.booleanValue;
    }

    public static <T> boolean isSorted(T[] tArr, Comparator<T> comparator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65644, null, tArr, comparator)) == null) {
            if (comparator != null) {
                if (tArr != null && tArr.length >= 2) {
                    T t = tArr[0];
                    int length = tArr.length;
                    int i2 = 1;
                    while (i2 < length) {
                        T t2 = tArr[i2];
                        if (comparator.compare(t, t2) > 0) {
                            return false;
                        }
                        i2++;
                        t = t2;
                    }
                }
                return true;
            }
            throw new IllegalArgumentException("Comparator should not be null.");
        }
        return invokeLL.booleanValue;
    }

    public static int lastIndexOf(Object[] objArr, Object obj, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65662, null, objArr, obj, i2)) == null) {
            if (objArr != null && i2 >= 0) {
                if (i2 >= objArr.length) {
                    i2 = objArr.length - 1;
                }
                if (obj == null) {
                    while (i2 >= 0) {
                        if (objArr[i2] == null) {
                            return i2;
                        }
                        i2--;
                    }
                } else if (objArr.getClass().getComponentType().isInstance(obj)) {
                    while (i2 >= 0) {
                        if (obj.equals(objArr[i2])) {
                            return i2;
                        }
                        i2--;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeLLI.intValue;
    }

    public static boolean[] remove(boolean[] zArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65696, null, zArr, i2)) == null) ? (boolean[]) remove((Object) zArr, i2) : (boolean[]) invokeLI.objValue;
    }

    public static byte[] removeAll(byte[] bArr, int... iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65699, null, bArr, iArr)) == null) ? (byte[]) removeAll((Object) bArr, iArr) : (byte[]) invokeLL.objValue;
    }

    public static void reverse(long[] jArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65745, null, jArr) == null) || jArr == null) {
            return;
        }
        reverse(jArr, 0, jArr.length);
    }

    public static void shift(long[] jArr, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65763, null, jArr, i2) == null) || jArr == null) {
            return;
        }
        shift(jArr, 0, jArr.length, i2);
    }

    public static String toString(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65826, null, obj, str)) == null) ? obj == null ? str : new ToStringBuilder(obj, ToStringStyle.SIMPLE_STYLE).append(obj).toString() : (String) invokeLL.objValue;
    }

    public static int[] clone(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, iArr)) == null) {
            if (iArr == null) {
                return null;
            }
            return (int[]) iArr.clone();
        }
        return (int[]) invokeL.objValue;
    }

    public static boolean contains(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65580, null, iArr, i2)) == null) ? indexOf(iArr, i2) != -1 : invokeLI.booleanValue;
    }

    public static boolean isEmpty(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65612, null, iArr)) == null) ? getLength(iArr) == 0 : invokeL.booleanValue;
    }

    public static boolean isNotEmpty(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65622, null, iArr)) == null) ? !isEmpty(iArr) : invokeL.booleanValue;
    }

    public static boolean isSameLength(int[] iArr, int[] iArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65631, null, iArr, iArr2)) == null) ? getLength(iArr) == getLength(iArr2) : invokeLL.booleanValue;
    }

    public static Object[] nullToEmpty(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65681, null, objArr)) == null) ? isEmpty(objArr) ? EMPTY_OBJECT_ARRAY : objArr : (Object[]) invokeL.objValue;
    }

    public static byte[] remove(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65688, null, bArr, i2)) == null) ? (byte[]) remove((Object) bArr, i2) : (byte[]) invokeLI.objValue;
    }

    public static short[] removeAll(short[] sArr, int... iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65706, null, sArr, iArr)) == null) ? (short[]) removeAll((Object) sArr, iArr) : (short[]) invokeLL.objValue;
    }

    public static void reverse(int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65743, null, iArr) == null) || iArr == null) {
            return;
        }
        reverse(iArr, 0, iArr.length);
    }

    public static void shift(int[] iArr, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65761, null, iArr, i2) == null) || iArr == null) {
            return;
        }
        shift(iArr, 0, iArr.length, i2);
    }

    public static void swap(long[] jArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65790, null, jArr, i2, i3) == null) || jArr == null || jArr.length == 0) {
            return;
        }
        swap(jArr, i2, i3, 1);
    }

    public static short[] clone(short[] sArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, sArr)) == null) {
            if (sArr == null) {
                return null;
            }
            return (short[]) sArr.clone();
        }
        return (short[]) invokeL.objValue;
    }

    public static boolean contains(short[] sArr, short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65583, null, new Object[]{sArr, Short.valueOf(s)})) == null) ? indexOf(sArr, s) != -1 : invokeCommon.booleanValue;
    }

    public static boolean isEmpty(short[] sArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65615, null, sArr)) == null) ? getLength(sArr) == 0 : invokeL.booleanValue;
    }

    public static boolean isNotEmpty(short[] sArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65625, null, sArr)) == null) ? !isEmpty(sArr) : invokeL.booleanValue;
    }

    public static boolean isSameLength(short[] sArr, short[] sArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65634, null, sArr, sArr2)) == null) ? getLength(sArr) == getLength(sArr2) : invokeLL.booleanValue;
    }

    public static char[] remove(char[] cArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65689, null, cArr, i2)) == null) ? (char[]) remove((Object) cArr, i2) : (char[]) invokeLI.objValue;
    }

    public static int[] removeAll(int[] iArr, int... iArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65703, null, iArr, iArr2)) == null) ? (int[]) removeAll((Object) iArr, iArr2) : (int[]) invokeLL.objValue;
    }

    public static boolean[] removeElement(boolean[] zArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65725, null, zArr, z)) == null) {
            int indexOf = indexOf(zArr, z);
            if (indexOf == -1) {
                return clone(zArr);
            }
            return remove(zArr, indexOf);
        }
        return (boolean[]) invokeLZ.objValue;
    }

    public static void reverse(short[] sArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65749, null, sArr) == null) || sArr == null) {
            return;
        }
        reverse(sArr, 0, sArr.length);
    }

    public static void shift(short[] sArr, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65767, null, sArr, i2) == null) || sArr == null) {
            return;
        }
        shift(sArr, 0, sArr.length, i2);
    }

    public static char[] clone(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, cArr)) == null) {
            if (cArr == null) {
                return null;
            }
            return (char[]) cArr.clone();
        }
        return (char[]) invokeL.objValue;
    }

    public static boolean contains(char[] cArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, null, new Object[]{cArr, Character.valueOf(c2)})) == null) ? indexOf(cArr, c2) != -1 : invokeCommon.booleanValue;
    }

    public static boolean isEmpty(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65609, null, cArr)) == null) ? getLength(cArr) == 0 : invokeL.booleanValue;
    }

    public static boolean isNotEmpty(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65619, null, cArr)) == null) ? !isEmpty(cArr) : invokeL.booleanValue;
    }

    public static boolean isSameLength(char[] cArr, char[] cArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65628, null, cArr, cArr2)) == null) ? getLength(cArr) == getLength(cArr2) : invokeLL.booleanValue;
    }

    public static Class<?>[] nullToEmpty(Class<?>[] clsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65676, null, clsArr)) == null) ? isEmpty(clsArr) ? EMPTY_CLASS_ARRAY : clsArr : (Class[]) invokeL.objValue;
    }

    public static double[] remove(double[] dArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65690, null, dArr, i2)) == null) ? (double[]) remove((Object) dArr, i2) : (double[]) invokeLI.objValue;
    }

    public static char[] removeAll(char[] cArr, int... iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65700, null, cArr, iArr)) == null) ? (char[]) removeAll((Object) cArr, iArr) : (char[]) invokeLL.objValue;
    }

    public static void reverse(char[] cArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65737, null, cArr) == null) || cArr == null) {
            return;
        }
        reverse(cArr, 0, cArr.length);
    }

    public static void shift(char[] cArr, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65755, null, cArr, i2) == null) || cArr == null) {
            return;
        }
        shift(cArr, 0, cArr.length, i2);
    }

    public static void swap(int[] iArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65788, null, iArr, i2, i3) == null) || iArr == null || iArr.length == 0) {
            return;
        }
        swap(iArr, i2, i3, 1);
    }

    public static boolean[] add(boolean[] zArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65556, null, zArr, z)) == null) {
            boolean[] zArr2 = (boolean[]) copyArrayGrow1(zArr, Boolean.TYPE);
            zArr2[zArr2.length - 1] = z;
            return zArr2;
        }
        return (boolean[]) invokeLZ.objValue;
    }

    public static byte[] clone(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            return (byte[]) bArr.clone();
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean contains(byte[] bArr, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65575, null, new Object[]{bArr, Byte.valueOf(b2)})) == null) ? indexOf(bArr, b2) != -1 : invokeCommon.booleanValue;
    }

    public static int indexOf(long[] jArr, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65600, null, jArr, j)) == null) ? indexOf(jArr, j, 0) : invokeLJ.intValue;
    }

    public static boolean isEmpty(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65608, null, bArr)) == null) ? getLength(bArr) == 0 : invokeL.booleanValue;
    }

    public static boolean isNotEmpty(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65618, null, bArr)) == null) ? !isEmpty(bArr) : invokeL.booleanValue;
    }

    public static boolean isSameLength(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65627, null, bArr, bArr2)) == null) ? getLength(bArr) == getLength(bArr2) : invokeLL.booleanValue;
    }

    public static float[] remove(float[] fArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65691, null, fArr, i2)) == null) ? (float[]) remove((Object) fArr, i2) : (float[]) invokeLI.objValue;
    }

    public static long[] removeAll(long[] jArr, int... iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65704, null, jArr, iArr)) == null) ? (long[]) removeAll((Object) jArr, iArr) : (long[]) invokeLL.objValue;
    }

    public static void reverse(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65735, null, bArr) == null) || bArr == null) {
            return;
        }
        reverse(bArr, 0, bArr.length);
    }

    public static void shift(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65753, null, bArr, i2) == null) || bArr == null) {
            return;
        }
        shift(bArr, 0, bArr.length, i2);
    }

    public static Long[] toObject(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65806, null, jArr)) == null) {
            if (jArr == null) {
                return null;
            }
            if (jArr.length == 0) {
                return EMPTY_LONG_OBJECT_ARRAY;
            }
            Long[] lArr = new Long[jArr.length];
            for (int i2 = 0; i2 < jArr.length; i2++) {
                lArr[i2] = Long.valueOf(jArr[i2]);
            }
            return lArr;
        }
        return (Long[]) invokeL.objValue;
    }

    public static char[] toPrimitive(Character[] chArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65812, null, new Object[]{chArr, Character.valueOf(c2)})) == null) {
            if (chArr == null) {
                return null;
            }
            if (chArr.length == 0) {
                return EMPTY_CHAR_ARRAY;
            }
            char[] cArr = new char[chArr.length];
            for (int i2 = 0; i2 < chArr.length; i2++) {
                Character ch = chArr[i2];
                cArr[i2] = ch == null ? c2 : ch.charValue();
            }
            return cArr;
        }
        return (char[]) invokeCommon.objValue;
    }

    public static double[] clone(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, dArr)) == null) {
            if (dArr == null) {
                return null;
            }
            return (double[]) dArr.clone();
        }
        return (double[]) invokeL.objValue;
    }

    public static boolean contains(double[] dArr, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65577, null, new Object[]{dArr, Double.valueOf(d2)})) == null) ? indexOf(dArr, d2) != -1 : invokeCommon.booleanValue;
    }

    public static int indexOf(long[] jArr, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65601, null, new Object[]{jArr, Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            if (jArr == null) {
                return -1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            while (i2 < jArr.length) {
                if (j == jArr[i2]) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static boolean isEmpty(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65610, null, dArr)) == null) ? getLength(dArr) == 0 : invokeL.booleanValue;
    }

    public static boolean isNotEmpty(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65620, null, dArr)) == null) ? !isEmpty(dArr) : invokeL.booleanValue;
    }

    public static boolean isSameLength(double[] dArr, double[] dArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65629, null, dArr, dArr2)) == null) ? getLength(dArr) == getLength(dArr2) : invokeLL.booleanValue;
    }

    public static int lastIndexOf(long[] jArr, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65659, null, jArr, j)) == null) ? lastIndexOf(jArr, j, Integer.MAX_VALUE) : invokeLJ.intValue;
    }

    public static String[] nullToEmpty(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65684, null, strArr)) == null) ? isEmpty(strArr) ? EMPTY_STRING_ARRAY : strArr : (String[]) invokeL.objValue;
    }

    public static int[] remove(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65692, null, iArr, i2)) == null) ? (int[]) remove((Object) iArr, i2) : (int[]) invokeLI.objValue;
    }

    public static float[] removeAll(float[] fArr, int... iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65702, null, fArr, iArr)) == null) ? (float[]) removeAll((Object) fArr, iArr) : (float[]) invokeLL.objValue;
    }

    public static byte[] removeElement(byte[] bArr, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65717, null, new Object[]{bArr, Byte.valueOf(b2)})) == null) {
            int indexOf = indexOf(bArr, b2);
            if (indexOf == -1) {
                return clone(bArr);
            }
            return remove(bArr, indexOf);
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static void reverse(double[] dArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65739, null, dArr) == null) || dArr == null) {
            return;
        }
        reverse(dArr, 0, dArr.length);
    }

    public static void shift(double[] dArr, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65757, null, dArr, i2) == null) || dArr == null) {
            return;
        }
        shift(dArr, 0, dArr.length, i2);
    }

    public static long[] subarray(long[] jArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65776, null, jArr, i2, i3)) == null) {
            if (jArr == null) {
                return null;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (i3 > jArr.length) {
                i3 = jArr.length;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return EMPTY_LONG_ARRAY;
            }
            long[] jArr2 = new long[i4];
            System.arraycopy(jArr, i2, jArr2, 0, i4);
            return jArr2;
        }
        return (long[]) invokeLII.objValue;
    }

    public static void swap(short[] sArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65794, null, sArr, i2, i3) == null) || sArr == null || sArr.length == 0) {
            return;
        }
        swap(sArr, i2, i3, 1);
    }

    public static byte[] add(byte[] bArr, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Byte.valueOf(b2)})) == null) {
            byte[] bArr2 = (byte[]) copyArrayGrow1(bArr, Byte.TYPE);
            bArr2[bArr2.length - 1] = b2;
            return bArr2;
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static float[] clone(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, fArr)) == null) {
            if (fArr == null) {
                return null;
            }
            return (float[]) fArr.clone();
        }
        return (float[]) invokeL.objValue;
    }

    public static boolean contains(double[] dArr, double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65578, null, new Object[]{dArr, Double.valueOf(d2), Double.valueOf(d3)})) == null) ? indexOf(dArr, d2, 0, d3) != -1 : invokeCommon.booleanValue;
    }

    public static boolean isEmpty(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65611, null, fArr)) == null) ? getLength(fArr) == 0 : invokeL.booleanValue;
    }

    public static boolean isNotEmpty(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65621, null, fArr)) == null) ? !isEmpty(fArr) : invokeL.booleanValue;
    }

    public static boolean isSameLength(float[] fArr, float[] fArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65630, null, fArr, fArr2)) == null) ? getLength(fArr) == getLength(fArr2) : invokeLL.booleanValue;
    }

    public static boolean isSorted(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65641, null, iArr)) == null) {
            if (iArr != null && iArr.length >= 2) {
                int i2 = iArr[0];
                int length = iArr.length;
                int i3 = 1;
                while (i3 < length) {
                    int i4 = iArr[i3];
                    if (NumberUtils.compare(i2, i4) > 0) {
                        return false;
                    }
                    i3++;
                    i2 = i4;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int lastIndexOf(long[] jArr, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65660, null, new Object[]{jArr, Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            if (jArr != null && i2 >= 0) {
                if (i2 >= jArr.length) {
                    i2 = jArr.length - 1;
                }
                while (i2 >= 0) {
                    if (j == jArr[i2]) {
                        return i2;
                    }
                    i2--;
                }
                return -1;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static long[] remove(long[] jArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65693, null, jArr, i2)) == null) ? (long[]) remove((Object) jArr, i2) : (long[]) invokeLI.objValue;
    }

    public static double[] removeAll(double[] dArr, int... iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65701, null, dArr, iArr)) == null) ? (double[]) removeAll((Object) dArr, iArr) : (double[]) invokeLL.objValue;
    }

    public static char[] removeAllOccurences(char[] cArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65709, null, new Object[]{cArr, Character.valueOf(c2)})) != null) {
            return (char[]) invokeCommon.objValue;
        }
        int indexOf = indexOf(cArr, c2);
        if (indexOf == -1) {
            return clone(cArr);
        }
        int[] iArr = new int[cArr.length - indexOf];
        iArr[0] = indexOf;
        int i2 = 1;
        while (true) {
            int indexOf2 = indexOf(cArr, c2, iArr[i2 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i2] = indexOf2;
                i2++;
            } else {
                return removeAll(cArr, Arrays.copyOf(iArr, i2));
            }
        }
    }

    public static void reverse(float[] fArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65741, null, fArr) == null) || fArr == null) {
            return;
        }
        reverse(fArr, 0, fArr.length);
    }

    public static void shift(float[] fArr, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65759, null, fArr, i2) == null) || fArr == null) {
            return;
        }
        shift(fArr, 0, fArr.length, i2);
    }

    public static boolean[] clone(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, zArr)) == null) {
            if (zArr == null) {
                return null;
            }
            return (boolean[]) zArr.clone();
        }
        return (boolean[]) invokeL.objValue;
    }

    public static boolean contains(float[] fArr, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65579, null, fArr, f2)) == null) ? indexOf(fArr, f2) != -1 : invokeLF.booleanValue;
    }

    public static int indexOf(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65598, null, iArr, i2)) == null) ? indexOf(iArr, i2, 0) : invokeLI.intValue;
    }

    public static boolean isEmpty(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65616, null, zArr)) == null) ? getLength(zArr) == 0 : invokeL.booleanValue;
    }

    public static boolean isNotEmpty(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65626, null, zArr)) == null) ? !isEmpty(zArr) : invokeL.booleanValue;
    }

    public static boolean isSameLength(boolean[] zArr, boolean[] zArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65635, null, zArr, zArr2)) == null) ? getLength(zArr) == getLength(zArr2) : invokeLL.booleanValue;
    }

    public static long[] nullToEmpty(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65672, null, jArr)) == null) ? isEmpty(jArr) ? EMPTY_LONG_ARRAY : jArr : (long[]) invokeL.objValue;
    }

    public static short[] remove(short[] sArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65695, null, sArr, i2)) == null) ? (short[]) remove((Object) sArr, i2) : (short[]) invokeLI.objValue;
    }

    public static boolean[] removeAll(boolean[] zArr, int... iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65707, null, zArr, iArr)) == null) ? (boolean[]) removeAll((Object) zArr, iArr) : (boolean[]) invokeLL.objValue;
    }

    public static void reverse(boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65751, null, zArr) == null) || zArr == null) {
            return;
        }
        reverse(zArr, 0, zArr.length);
    }

    public static void shift(boolean[] zArr, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65769, null, zArr, i2) == null) || zArr == null) {
            return;
        }
        shift(zArr, 0, zArr.length, i2);
    }

    public static void swap(char[] cArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65782, null, cArr, i2, i3) == null) || cArr == null || cArr.length == 0) {
            return;
        }
        swap(cArr, i2, i3, 1);
    }

    public static char[] add(char[] cArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{cArr, Character.valueOf(c2)})) == null) {
            char[] cArr2 = (char[]) copyArrayGrow1(cArr, Character.TYPE);
            cArr2[cArr2.length - 1] = c2;
            return cArr2;
        }
        return (char[]) invokeCommon.objValue;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65584, null, zArr, z)) == null) ? indexOf(zArr, z) != -1 : invokeLZ.booleanValue;
    }

    public static int indexOf(int[] iArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65599, null, iArr, i2, i3)) == null) {
            if (iArr == null) {
                return -1;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            while (i3 < iArr.length) {
                if (i2 == iArr[i3]) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        return invokeLII.intValue;
    }

    public static Object remove(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65687, null, obj, i2)) == null) {
            int length = getLength(obj);
            if (i2 >= 0 && i2 < length) {
                int i3 = length - 1;
                Object newInstance = Array.newInstance(obj.getClass().getComponentType(), i3);
                System.arraycopy(obj, 0, newInstance, 0, i2);
                if (i2 < i3) {
                    System.arraycopy(obj, i2 + 1, newInstance, i2, (length - i2) - 1);
                }
                return newInstance;
            }
            throw new IndexOutOfBoundsException("Index: " + i2 + ", Length: " + length);
        }
        return invokeLI.objValue;
    }

    public static Object removeAll(Object obj, int... iArr) {
        InterceptResult invokeLL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65698, null, obj, iArr)) == null) {
            int length = getLength(obj);
            int[] clone = clone(iArr);
            Arrays.sort(clone);
            if (isNotEmpty(clone)) {
                int length2 = clone.length;
                int i4 = length;
                i2 = 0;
                while (true) {
                    length2--;
                    if (length2 < 0) {
                        break;
                    }
                    i3 = clone[length2];
                    if (i3 < 0 || i3 >= length) {
                        break;
                    } else if (i3 < i4) {
                        i2++;
                        i4 = i3;
                    }
                }
                throw new IndexOutOfBoundsException("Index: " + i3 + ", Length: " + length);
            }
            i2 = 0;
            int i5 = length - i2;
            Object newInstance = Array.newInstance(obj.getClass().getComponentType(), i5);
            if (i2 < length) {
                int length3 = clone.length - 1;
                while (length3 >= 0) {
                    int i6 = clone[length3];
                    int i7 = length - i6;
                    if (i7 > 1) {
                        int i8 = i7 - 1;
                        i5 -= i8;
                        System.arraycopy(obj, i6 + 1, newInstance, i5, i8);
                    }
                    length3--;
                    length = i6;
                }
                if (length > 0) {
                    System.arraycopy(obj, 0, newInstance, 0, length);
                }
            }
            return newInstance;
        }
        return invokeLL.objValue;
    }

    public static char[] removeElement(char[] cArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65718, null, new Object[]{cArr, Character.valueOf(c2)})) == null) {
            int indexOf = indexOf(cArr, c2);
            if (indexOf == -1) {
                return clone(cArr);
            }
            return remove(cArr, indexOf);
        }
        return (char[]) invokeCommon.objValue;
    }

    public static void reverse(boolean[] zArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65752, null, zArr, i2, i3) == null) || zArr == null) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int min = Math.min(zArr.length, i3) - 1;
        while (min > i2) {
            boolean z = zArr[min];
            zArr[min] = zArr[i2];
            zArr[i2] = z;
            min--;
            i2++;
        }
    }

    public static void shift(boolean[] zArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65770, null, zArr, i2, i3, i4) == null) || zArr == null || i2 >= zArr.length - 1 || i3 <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 >= zArr.length) {
            i3 = zArr.length;
        }
        int i5 = i3 - i2;
        if (i5 <= 1) {
            return;
        }
        int i6 = i4 % i5;
        if (i6 < 0) {
            i6 += i5;
        }
        while (i5 > 1 && i6 > 0) {
            int i7 = i5 - i6;
            if (i6 > i7) {
                swap(zArr, i2, (i5 + i2) - i7, i7);
                int i8 = i6;
                i6 -= i7;
                i5 = i8;
            } else if (i6 < i7) {
                swap(zArr, i2, i2 + i7, i6);
                i2 += i6;
                i5 = i7;
            } else {
                swap(zArr, i2, i7 + i2, i6);
                return;
            }
        }
    }

    public static int lastIndexOf(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65657, null, iArr, i2)) == null) ? lastIndexOf(iArr, i2, Integer.MAX_VALUE) : invokeLI.intValue;
    }

    public static int[] nullToEmpty(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65671, null, iArr)) == null) ? isEmpty(iArr) ? EMPTY_INT_ARRAY : iArr : (int[]) invokeL.objValue;
    }

    public static void swap(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65780, null, bArr, i2, i3) == null) || bArr == null || bArr.length == 0) {
            return;
        }
        swap(bArr, i2, i3, 1);
    }

    public static Integer[] toObject(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65805, null, iArr)) == null) {
            if (iArr == null) {
                return null;
            }
            if (iArr.length == 0) {
                return EMPTY_INTEGER_OBJECT_ARRAY;
            }
            Integer[] numArr = new Integer[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                numArr[i2] = Integer.valueOf(iArr[i2]);
            }
            return numArr;
        }
        return (Integer[]) invokeL.objValue;
    }

    public static double[] add(double[] dArr, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{dArr, Double.valueOf(d2)})) == null) {
            double[] dArr2 = (double[]) copyArrayGrow1(dArr, Double.TYPE);
            dArr2[dArr2.length - 1] = d2;
            return dArr2;
        }
        return (double[]) invokeCommon.objValue;
    }

    public static boolean[] addAll(boolean[] zArr, boolean... zArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, zArr, zArr2)) == null) {
            if (zArr == null) {
                return clone(zArr2);
            }
            if (zArr2 == null) {
                return clone(zArr);
            }
            boolean[] zArr3 = new boolean[zArr.length + zArr2.length];
            System.arraycopy(zArr, 0, zArr3, 0, zArr.length);
            System.arraycopy(zArr2, 0, zArr3, zArr.length, zArr2.length);
            return zArr3;
        }
        return (boolean[]) invokeLL.objValue;
    }

    public static int indexOf(short[] sArr, short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65604, null, new Object[]{sArr, Short.valueOf(s)})) == null) ? indexOf(sArr, s, 0) : invokeCommon.intValue;
    }

    public static int lastIndexOf(int[] iArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65658, null, iArr, i2, i3)) == null) {
            if (iArr != null && i3 >= 0) {
                if (i3 >= iArr.length) {
                    i3 = iArr.length - 1;
                }
                while (i3 >= 0) {
                    if (i2 == iArr[i3]) {
                        return i3;
                    }
                    i3--;
                }
                return -1;
            }
            return -1;
        }
        return invokeLII.intValue;
    }

    public static int[] subarray(int[] iArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65775, null, iArr, i2, i3)) == null) {
            if (iArr == null) {
                return null;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (i3 > iArr.length) {
                i3 = iArr.length;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return EMPTY_INT_ARRAY;
            }
            int[] iArr2 = new int[i4];
            System.arraycopy(iArr, i2, iArr2, 0, i4);
            return iArr2;
        }
        return (int[]) invokeLII.objValue;
    }

    public static long[] toPrimitive(Long[] lArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65819, null, lArr)) == null) {
            if (lArr == null) {
                return null;
            }
            if (lArr.length == 0) {
                return EMPTY_LONG_ARRAY;
            }
            long[] jArr = new long[lArr.length];
            for (int i2 = 0; i2 < lArr.length; i2++) {
                jArr[i2] = lArr[i2].longValue();
            }
            return jArr;
        }
        return (long[]) invokeL.objValue;
    }

    public static int indexOf(short[] sArr, short s, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65605, null, new Object[]{sArr, Short.valueOf(s), Integer.valueOf(i2)})) == null) {
            if (sArr == null) {
                return -1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            while (i2 < sArr.length) {
                if (s == sArr[i2]) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static boolean isSorted(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65642, null, jArr)) == null) {
            if (jArr != null && jArr.length >= 2) {
                long j = jArr[0];
                int length = jArr.length;
                int i2 = 1;
                while (i2 < length) {
                    long j2 = jArr[i2];
                    if (NumberUtils.compare(j, j2) > 0) {
                        return false;
                    }
                    i2++;
                    j = j2;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static short[] nullToEmpty(short[] sArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65685, null, sArr)) == null) ? isEmpty(sArr) ? EMPTY_SHORT_ARRAY : sArr : (short[]) invokeL.objValue;
    }

    public static double[] removeElement(double[] dArr, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65719, null, new Object[]{dArr, Double.valueOf(d2)})) == null) {
            int indexOf = indexOf(dArr, d2);
            if (indexOf == -1) {
                return clone(dArr);
            }
            return remove(dArr, indexOf);
        }
        return (double[]) invokeCommon.objValue;
    }

    public static void swap(double[] dArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65784, null, dArr, i2, i3) == null) || dArr == null || dArr.length == 0) {
            return;
        }
        swap(dArr, i2, i3, 1);
    }

    public static float[] add(float[] fArr, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65545, null, fArr, f2)) == null) {
            float[] fArr2 = (float[]) copyArrayGrow1(fArr, Float.TYPE);
            fArr2[fArr2.length - 1] = f2;
            return fArr2;
        }
        return (float[]) invokeLF.objValue;
    }

    public static void reverse(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65736, null, bArr, i2, i3) == null) || bArr == null) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int min = Math.min(bArr.length, i3) - 1;
        while (min > i2) {
            byte b2 = bArr[min];
            bArr[min] = bArr[i2];
            bArr[i2] = b2;
            min--;
            i2++;
        }
    }

    public static int indexOf(char[] cArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65590, null, new Object[]{cArr, Character.valueOf(c2)})) == null) ? indexOf(cArr, c2, 0) : invokeCommon.intValue;
    }

    public static int lastIndexOf(short[] sArr, short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65663, null, new Object[]{sArr, Short.valueOf(s)})) == null) ? lastIndexOf(sArr, s, Integer.MAX_VALUE) : invokeCommon.intValue;
    }

    public static char[] nullToEmpty(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65668, null, cArr)) == null) ? isEmpty(cArr) ? EMPTY_CHAR_ARRAY : cArr : (char[]) invokeL.objValue;
    }

    public static byte[] removeAllOccurences(byte[] bArr, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65708, null, new Object[]{bArr, Byte.valueOf(b2)})) != null) {
            return (byte[]) invokeCommon.objValue;
        }
        int indexOf = indexOf(bArr, b2);
        if (indexOf == -1) {
            return clone(bArr);
        }
        int[] iArr = new int[bArr.length - indexOf];
        iArr[0] = indexOf;
        int i2 = 1;
        while (true) {
            int indexOf2 = indexOf(bArr, b2, iArr[i2 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i2] = indexOf2;
                i2++;
            } else {
                return removeAll(bArr, Arrays.copyOf(iArr, i2));
            }
        }
    }

    public static void swap(float[] fArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65786, null, fArr, i2, i3) == null) || fArr == null || fArr.length == 0) {
            return;
        }
        swap(fArr, i2, i3, 1);
    }

    public static int[] add(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, iArr, i2)) == null) {
            int[] iArr2 = (int[]) copyArrayGrow1(iArr, Integer.TYPE);
            iArr2[iArr2.length - 1] = i2;
            return iArr2;
        }
        return (int[]) invokeLI.objValue;
    }

    public static int indexOf(char[] cArr, char c2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65591, null, new Object[]{cArr, Character.valueOf(c2), Integer.valueOf(i2)})) == null) {
            if (cArr == null) {
                return -1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            while (i2 < cArr.length) {
                if (c2 == cArr[i2]) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static int lastIndexOf(short[] sArr, short s, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65664, null, new Object[]{sArr, Short.valueOf(s), Integer.valueOf(i2)})) == null) {
            if (sArr != null && i2 >= 0) {
                if (i2 >= sArr.length) {
                    i2 = sArr.length - 1;
                }
                while (i2 >= 0) {
                    if (s == sArr[i2]) {
                        return i2;
                    }
                    i2--;
                }
                return -1;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static float[] removeElement(float[] fArr, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65720, null, fArr, f2)) == null) {
            int indexOf = indexOf(fArr, f2);
            if (indexOf == -1) {
                return clone(fArr);
            }
            return remove(fArr, indexOf);
        }
        return (float[]) invokeLF.objValue;
    }

    public static byte[] removeElements(byte[] bArr, byte... bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65726, null, bArr, bArr2)) == null) {
            if (!isEmpty(bArr) && !isEmpty(bArr2)) {
                HashMap hashMap = new HashMap(bArr2.length);
                for (byte b2 : bArr2) {
                    Byte valueOf = Byte.valueOf(b2);
                    MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                    if (mutableInt == null) {
                        hashMap.put(valueOf, new MutableInt(1));
                    } else {
                        mutableInt.increment();
                    }
                }
                BitSet bitSet = new BitSet();
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    byte b3 = bArr[i2];
                    MutableInt mutableInt2 = (MutableInt) hashMap.get(Byte.valueOf(b3));
                    if (mutableInt2 != null) {
                        if (mutableInt2.decrementAndGet() == 0) {
                            hashMap.remove(Byte.valueOf(b3));
                        }
                        bitSet.set(i2);
                    }
                }
                return (byte[]) removeAll(bArr, bitSet);
            }
            return clone(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static Short[] toObject(short[] sArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65807, null, sArr)) == null) {
            if (sArr == null) {
                return null;
            }
            if (sArr.length == 0) {
                return EMPTY_SHORT_OBJECT_ARRAY;
            }
            Short[] shArr = new Short[sArr.length];
            for (int i2 = 0; i2 < sArr.length; i2++) {
                shArr[i2] = Short.valueOf(sArr[i2]);
            }
            return shArr;
        }
        return (Short[]) invokeL.objValue;
    }

    public static char[] addAll(char[] cArr, char... cArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, cArr, cArr2)) == null) {
            if (cArr == null) {
                return clone(cArr2);
            }
            if (cArr2 == null) {
                return clone(cArr);
            }
            char[] cArr3 = new char[cArr.length + cArr2.length];
            System.arraycopy(cArr, 0, cArr3, 0, cArr.length);
            System.arraycopy(cArr2, 0, cArr3, cArr.length, cArr2.length);
            return cArr3;
        }
        return (char[]) invokeLL.objValue;
    }

    public static byte[] nullToEmpty(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65667, null, bArr)) == null) ? isEmpty(bArr) ? EMPTY_BYTE_ARRAY : bArr : (byte[]) invokeL.objValue;
    }

    public static void shift(byte[] bArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65754, null, bArr, i2, i3, i4) == null) || bArr == null || i2 >= bArr.length - 1 || i3 <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 >= bArr.length) {
            i3 = bArr.length;
        }
        int i5 = i3 - i2;
        if (i5 <= 1) {
            return;
        }
        int i6 = i4 % i5;
        if (i6 < 0) {
            i6 += i5;
        }
        while (i5 > 1 && i6 > 0) {
            int i7 = i5 - i6;
            if (i6 > i7) {
                swap(bArr, i2, (i5 + i2) - i7, i7);
                int i8 = i6;
                i6 -= i7;
                i5 = i8;
            } else if (i6 < i7) {
                swap(bArr, i2, i2 + i7, i6);
                i2 += i6;
                i5 = i7;
            } else {
                swap(bArr, i2, i7 + i2, i6);
                return;
            }
        }
    }

    public static short[] subarray(short[] sArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65778, null, sArr, i2, i3)) == null) {
            if (sArr == null) {
                return null;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (i3 > sArr.length) {
                i3 = sArr.length;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return EMPTY_SHORT_ARRAY;
            }
            short[] sArr2 = new short[i4];
            System.arraycopy(sArr, i2, sArr2, 0, i4);
            return sArr2;
        }
        return (short[]) invokeLII.objValue;
    }

    public static void swap(boolean[] zArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65796, null, zArr, i2, i3) == null) || zArr == null || zArr.length == 0) {
            return;
        }
        swap(zArr, i2, i3, 1);
    }

    public static long[] toPrimitive(Long[] lArr, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65820, null, lArr, j)) == null) {
            if (lArr == null) {
                return null;
            }
            if (lArr.length == 0) {
                return EMPTY_LONG_ARRAY;
            }
            long[] jArr = new long[lArr.length];
            for (int i2 = 0; i2 < lArr.length; i2++) {
                Long l = lArr[i2];
                jArr[i2] = l == null ? j : l.longValue();
            }
            return jArr;
        }
        return (long[]) invokeLJ.objValue;
    }

    public static long[] add(long[] jArr, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65550, null, jArr, j)) == null) {
            long[] jArr2 = (long[]) copyArrayGrow1(jArr, Long.TYPE);
            jArr2[jArr2.length - 1] = j;
            return jArr2;
        }
        return (long[]) invokeLJ.objValue;
    }

    public static int indexOf(byte[] bArr, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65588, null, new Object[]{bArr, Byte.valueOf(b2)})) == null) ? indexOf(bArr, b2, 0) : invokeCommon.intValue;
    }

    public static boolean isSorted(short[] sArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65645, null, sArr)) == null) {
            if (sArr != null && sArr.length >= 2) {
                short s = sArr[0];
                int length = sArr.length;
                int i2 = 1;
                while (i2 < length) {
                    short s2 = sArr[i2];
                    if (NumberUtils.compare(s, s2) > 0) {
                        return false;
                    }
                    i2++;
                    s = s2;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void reverse(char[] cArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65738, null, cArr, i2, i3) == null) || cArr == null) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int min = Math.min(cArr.length, i3) - 1;
        while (min > i2) {
            char c2 = cArr[min];
            cArr[min] = cArr[i2];
            cArr[i2] = c2;
            min--;
            i2++;
        }
    }

    public static int indexOf(byte[] bArr, byte b2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65589, null, new Object[]{bArr, Byte.valueOf(b2), Integer.valueOf(i2)})) == null) {
            if (bArr == null) {
                return -1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            while (i2 < bArr.length) {
                if (b2 == bArr[i2]) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static int lastIndexOf(char[] cArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65649, null, new Object[]{cArr, Character.valueOf(c2)})) == null) ? lastIndexOf(cArr, c2, Integer.MAX_VALUE) : invokeCommon.intValue;
    }

    public static double[] nullToEmpty(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65669, null, dArr)) == null) ? isEmpty(dArr) ? EMPTY_DOUBLE_ARRAY : dArr : (double[]) invokeL.objValue;
    }

    public static int[] removeElement(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65721, null, iArr, i2)) == null) {
            int indexOf = indexOf(iArr, i2);
            if (indexOf == -1) {
                return clone(iArr);
            }
            return remove(iArr, indexOf);
        }
        return (int[]) invokeLI.objValue;
    }

    public static void swap(boolean[] zArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65797, null, zArr, i2, i3, i4) == null) || zArr == null || zArr.length == 0 || i2 >= zArr.length || i3 >= zArr.length) {
            return;
        }
        int i5 = 0;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int min = Math.min(Math.min(i4, zArr.length - i2), zArr.length - i3);
        while (i5 < min) {
            boolean z = zArr[i2];
            zArr[i2] = zArr[i3];
            zArr[i3] = z;
            i5++;
            i2++;
            i3++;
        }
    }

    public static short[] add(short[] sArr, short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{sArr, Short.valueOf(s)})) == null) {
            short[] sArr2 = (short[]) copyArrayGrow1(sArr, Short.TYPE);
            sArr2[sArr2.length - 1] = s;
            return sArr2;
        }
        return (short[]) invokeCommon.objValue;
    }

    public static int lastIndexOf(char[] cArr, char c2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65650, null, new Object[]{cArr, Character.valueOf(c2), Integer.valueOf(i2)})) == null) {
            if (cArr != null && i2 >= 0) {
                if (i2 >= cArr.length) {
                    i2 = cArr.length - 1;
                }
                while (i2 >= 0) {
                    if (c2 == cArr[i2]) {
                        return i2;
                    }
                    i2--;
                }
                return -1;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static int indexOf(double[] dArr, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65592, null, new Object[]{dArr, Double.valueOf(d2)})) == null) ? indexOf(dArr, d2, 0) : invokeCommon.intValue;
    }

    public static float[] nullToEmpty(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65670, null, fArr)) == null) ? isEmpty(fArr) ? EMPTY_FLOAT_ARRAY : fArr : (float[]) invokeL.objValue;
    }

    public static Byte[] toObject(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65801, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            if (bArr.length == 0) {
                return EMPTY_BYTE_OBJECT_ARRAY;
            }
            Byte[] bArr2 = new Byte[bArr.length];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr2[i2] = Byte.valueOf(bArr[i2]);
            }
            return bArr2;
        }
        return (Byte[]) invokeL.objValue;
    }

    public static <T> T[] add(T[] tArr, int i2, T t) {
        InterceptResult invokeLIL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65551, null, tArr, i2, t)) == null) {
            if (tArr != null) {
                cls = tArr.getClass().getComponentType();
            } else if (t != null) {
                cls = t.getClass();
            } else {
                throw new IllegalArgumentException("Array and element cannot both be null");
            }
            return (T[]) ((Object[]) add(tArr, i2, t, cls));
        }
        return (T[]) ((Object[]) invokeLIL.objValue);
    }

    public static byte[] addAll(byte[] bArr, byte... bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, bArr, bArr2)) == null) {
            if (bArr == null) {
                return clone(bArr2);
            }
            if (bArr2 == null) {
                return clone(bArr);
            }
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static int indexOf(double[] dArr, double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65593, null, new Object[]{dArr, Double.valueOf(d2), Double.valueOf(d3)})) == null) ? indexOf(dArr, d2, 0, d3) : invokeCommon.intValue;
    }

    public static Object removeAll(Object obj, BitSet bitSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65697, null, obj, bitSet)) == null) {
            int length = getLength(obj);
            Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length - bitSet.cardinality());
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int nextSetBit = bitSet.nextSetBit(i2);
                if (nextSetBit == -1) {
                    break;
                }
                int i4 = nextSetBit - i2;
                if (i4 > 0) {
                    System.arraycopy(obj, i2, newInstance, i3, i4);
                    i3 += i4;
                }
                i2 = bitSet.nextClearBit(nextSetBit);
            }
            int i5 = length - i2;
            if (i5 > 0) {
                System.arraycopy(obj, i2, newInstance, i3, i5);
            }
            return newInstance;
        }
        return invokeLL.objValue;
    }

    public static short[] removeAllOccurences(short[] sArr, short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65715, null, new Object[]{sArr, Short.valueOf(s)})) != null) {
            return (short[]) invokeCommon.objValue;
        }
        int indexOf = indexOf(sArr, s);
        if (indexOf == -1) {
            return clone(sArr);
        }
        int[] iArr = new int[sArr.length - indexOf];
        iArr[0] = indexOf;
        int i2 = 1;
        while (true) {
            int indexOf2 = indexOf(sArr, s, iArr[i2 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i2] = indexOf2;
                i2++;
            } else {
                return removeAll(sArr, Arrays.copyOf(iArr, i2));
            }
        }
    }

    public static long[] removeElement(long[] jArr, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65722, null, jArr, j)) == null) {
            int indexOf = indexOf(jArr, j);
            if (indexOf == -1) {
                return clone(jArr);
            }
            return remove(jArr, indexOf);
        }
        return (long[]) invokeLJ.objValue;
    }

    public static void reverse(double[] dArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65740, null, dArr, i2, i3) == null) || dArr == null) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int min = Math.min(dArr.length, i3) - 1;
        while (min > i2) {
            double d2 = dArr[min];
            dArr[min] = dArr[i2];
            dArr[i2] = d2;
            min--;
            i2++;
        }
    }

    public static char[] subarray(char[] cArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65772, null, cArr, i2, i3)) == null) {
            if (cArr == null) {
                return null;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (i3 > cArr.length) {
                i3 = cArr.length;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return EMPTY_CHAR_ARRAY;
            }
            char[] cArr2 = new char[i4];
            System.arraycopy(cArr, i2, cArr2, 0, i4);
            return cArr2;
        }
        return (char[]) invokeLII.objValue;
    }

    public static int indexOf(double[] dArr, double d2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65594, null, new Object[]{dArr, Double.valueOf(d2), Integer.valueOf(i2)})) == null) {
            if (isEmpty(dArr)) {
                return -1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            while (i2 < dArr.length) {
                if (d2 == dArr[i2]) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static boolean isSorted(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65639, null, dArr)) == null) {
            if (dArr != null && dArr.length >= 2) {
                double d2 = dArr[0];
                int length = dArr.length;
                int i2 = 1;
                while (i2 < length) {
                    double d3 = dArr[i2];
                    if (Double.compare(d2, d3) > 0) {
                        return false;
                    }
                    i2++;
                    d2 = d3;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int lastIndexOf(byte[] bArr, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65647, null, new Object[]{bArr, Byte.valueOf(b2)})) == null) ? lastIndexOf(bArr, b2, Integer.MAX_VALUE) : invokeCommon.intValue;
    }

    public static boolean[] nullToEmpty(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65686, null, zArr)) == null) ? isEmpty(zArr) ? EMPTY_BOOLEAN_ARRAY : zArr : (boolean[]) invokeL.objValue;
    }

    public static int[] toPrimitive(Integer[] numArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65817, null, numArr)) == null) {
            if (numArr == null) {
                return null;
            }
            if (numArr.length == 0) {
                return EMPTY_INT_ARRAY;
            }
            int[] iArr = new int[numArr.length];
            for (int i2 = 0; i2 < numArr.length; i2++) {
                iArr[i2] = numArr[i2].intValue();
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static int lastIndexOf(byte[] bArr, byte b2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65648, null, new Object[]{bArr, Byte.valueOf(b2), Integer.valueOf(i2)})) == null) {
            if (bArr != null && i2 >= 0) {
                if (i2 >= bArr.length) {
                    i2 = bArr.length - 1;
                }
                while (i2 >= 0) {
                    if (b2 == bArr[i2]) {
                        return i2;
                    }
                    i2--;
                }
                return -1;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static void shift(char[] cArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65756, null, cArr, i2, i3, i4) == null) || cArr == null || i2 >= cArr.length - 1 || i3 <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 >= cArr.length) {
            i3 = cArr.length;
        }
        int i5 = i3 - i2;
        if (i5 <= 1) {
            return;
        }
        int i6 = i4 % i5;
        if (i6 < 0) {
            i6 += i5;
        }
        while (i5 > 1 && i6 > 0) {
            int i7 = i5 - i6;
            if (i6 > i7) {
                swap(cArr, i2, (i5 + i2) - i7, i7);
                int i8 = i6;
                i6 -= i7;
                i5 = i8;
            } else if (i6 < i7) {
                swap(cArr, i2, i2 + i7, i6);
                i2 += i6;
                i5 = i7;
            } else {
                swap(cArr, i2, i7 + i2, i6);
                return;
            }
        }
    }

    public static void swap(byte[] bArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65781, null, bArr, i2, i3, i4) == null) || bArr == null || bArr.length == 0 || i2 >= bArr.length || i3 >= bArr.length) {
            return;
        }
        int i5 = 0;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int min = Math.min(Math.min(i4, bArr.length - i2), bArr.length - i3);
        while (i5 < min) {
            byte b2 = bArr[i2];
            bArr[i2] = bArr[i3];
            bArr[i3] = b2;
            i5++;
            i2++;
            i3++;
        }
    }

    public static Long[] nullToEmpty(Long[] lArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65680, null, lArr)) == null) ? isEmpty(lArr) ? EMPTY_LONG_OBJECT_ARRAY : lArr : (Long[]) invokeL.objValue;
    }

    public static short[] removeElement(short[] sArr, short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65724, null, new Object[]{sArr, Short.valueOf(s)})) == null) {
            int indexOf = indexOf(sArr, s);
            if (indexOf == -1) {
                return clone(sArr);
            }
            return remove(sArr, indexOf);
        }
        return (short[]) invokeCommon.objValue;
    }

    public static boolean[] add(boolean[] zArr, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{zArr, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? (boolean[]) add(zArr, i2, Boolean.valueOf(z), Boolean.TYPE) : (boolean[]) invokeCommon.objValue;
    }

    public static int indexOf(double[] dArr, double d2, int i2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65595, null, new Object[]{dArr, Double.valueOf(d2), Integer.valueOf(i2), Double.valueOf(d3)})) == null) {
            if (isEmpty(dArr)) {
                return -1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            double d4 = d2 - d3;
            double d5 = d2 + d3;
            while (i2 < dArr.length) {
                if (dArr[i2] >= d4 && dArr[i2] <= d5) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static void reverse(float[] fArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65742, null, fArr, i2, i3) == null) || fArr == null) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int min = Math.min(fArr.length, i3) - 1;
        while (min > i2) {
            float f2 = fArr[min];
            fArr[min] = fArr[i2];
            fArr[i2] = f2;
            min--;
            i2++;
        }
    }

    public static Double[] toObject(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65803, null, dArr)) == null) {
            if (dArr == null) {
                return null;
            }
            if (dArr.length == 0) {
                return EMPTY_DOUBLE_OBJECT_ARRAY;
            }
            Double[] dArr2 = new Double[dArr.length];
            for (int i2 = 0; i2 < dArr.length; i2++) {
                dArr2[i2] = Double.valueOf(dArr[i2]);
            }
            return dArr2;
        }
        return (Double[]) invokeL.objValue;
    }

    public static char[] add(char[] cArr, int i2, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{cArr, Integer.valueOf(i2), Character.valueOf(c2)})) == null) ? (char[]) add(cArr, i2, Character.valueOf(c2), Character.TYPE) : (char[]) invokeCommon.objValue;
    }

    public static short[] addAll(short[] sArr, short... sArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, sArr, sArr2)) == null) {
            if (sArr == null) {
                return clone(sArr2);
            }
            if (sArr2 == null) {
                return clone(sArr);
            }
            short[] sArr3 = new short[sArr.length + sArr2.length];
            System.arraycopy(sArr, 0, sArr3, 0, sArr.length);
            System.arraycopy(sArr2, 0, sArr3, sArr.length, sArr2.length);
            return sArr3;
        }
        return (short[]) invokeLL.objValue;
    }

    public static int lastIndexOf(double[] dArr, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65651, null, new Object[]{dArr, Double.valueOf(d2)})) == null) ? lastIndexOf(dArr, d2, Integer.MAX_VALUE) : invokeCommon.intValue;
    }

    public static Integer[] nullToEmpty(Integer[] numArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65679, null, numArr)) == null) ? isEmpty(numArr) ? EMPTY_INTEGER_OBJECT_ARRAY : numArr : (Integer[]) invokeL.objValue;
    }

    public static byte[] subarray(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65771, null, bArr, i2, i3)) == null) {
            if (bArr == null) {
                return null;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (i3 > bArr.length) {
                i3 = bArr.length;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return EMPTY_BYTE_ARRAY;
            }
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i2, bArr2, 0, i4);
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static byte[] add(byte[] bArr, int i2, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bArr, Integer.valueOf(i2), Byte.valueOf(b2)})) == null) ? (byte[]) add(bArr, i2, Byte.valueOf(b2), Byte.TYPE) : (byte[]) invokeCommon.objValue;
    }

    public static boolean isSorted(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65640, null, fArr)) == null) {
            if (fArr != null && fArr.length >= 2) {
                float f2 = fArr[0];
                int length = fArr.length;
                int i2 = 1;
                while (i2 < length) {
                    float f3 = fArr[i2];
                    if (Float.compare(f2, f3) > 0) {
                        return false;
                    }
                    i2++;
                    f2 = f3;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int lastIndexOf(double[] dArr, double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65652, null, new Object[]{dArr, Double.valueOf(d2), Double.valueOf(d3)})) == null) ? lastIndexOf(dArr, d2, Integer.MAX_VALUE, d3) : invokeCommon.intValue;
    }

    public static int[] toPrimitive(Integer[] numArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65818, null, numArr, i2)) == null) {
            if (numArr == null) {
                return null;
            }
            if (numArr.length == 0) {
                return EMPTY_INT_ARRAY;
            }
            int[] iArr = new int[numArr.length];
            for (int i3 = 0; i3 < numArr.length; i3++) {
                Integer num = numArr[i3];
                iArr[i3] = num == null ? i2 : num.intValue();
            }
            return iArr;
        }
        return (int[]) invokeLI.objValue;
    }

    public static short[] add(short[] sArr, int i2, short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{sArr, Integer.valueOf(i2), Short.valueOf(s)})) == null) ? (short[]) add(sArr, i2, Short.valueOf(s), Short.TYPE) : (short[]) invokeCommon.objValue;
    }

    public static int indexOf(float[] fArr, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65596, null, fArr, f2)) == null) ? indexOf(fArr, f2, 0) : invokeLF.intValue;
    }

    public static int lastIndexOf(double[] dArr, double d2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65653, null, new Object[]{dArr, Double.valueOf(d2), Integer.valueOf(i2)})) == null) {
            if (!isEmpty(dArr) && i2 >= 0) {
                if (i2 >= dArr.length) {
                    i2 = dArr.length - 1;
                }
                while (i2 >= 0) {
                    if (d2 == dArr[i2]) {
                        return i2;
                    }
                    i2--;
                }
                return -1;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static Short[] nullToEmpty(Short[] shArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65683, null, shArr)) == null) ? isEmpty(shArr) ? EMPTY_SHORT_OBJECT_ARRAY : shArr : (Short[]) invokeL.objValue;
    }

    public static int[] removeAllOccurences(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65712, null, iArr, i2)) != null) {
            return (int[]) invokeLI.objValue;
        }
        int indexOf = indexOf(iArr, i2);
        if (indexOf == -1) {
            return clone(iArr);
        }
        int[] iArr2 = new int[iArr.length - indexOf];
        iArr2[0] = indexOf;
        int i3 = 1;
        while (true) {
            int indexOf2 = indexOf(iArr, i2, iArr2[i3 - 1] + 1);
            if (indexOf2 != -1) {
                iArr2[i3] = indexOf2;
                i3++;
            } else {
                return removeAll(iArr, Arrays.copyOf(iArr2, i3));
            }
        }
    }

    public static void swap(char[] cArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65783, null, cArr, i2, i3, i4) == null) || cArr == null || cArr.length == 0 || i2 >= cArr.length || i3 >= cArr.length) {
            return;
        }
        int i5 = 0;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int min = Math.min(Math.min(i4, cArr.length - i2), cArr.length - i3);
        while (i5 < min) {
            char c2 = cArr[i2];
            cArr[i2] = cArr[i3];
            cArr[i3] = c2;
            i5++;
            i2++;
            i3++;
        }
    }

    public static int[] add(int[] iArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65548, null, iArr, i2, i3)) == null) ? (int[]) add(iArr, i2, Integer.valueOf(i3), Integer.TYPE) : (int[]) invokeLII.objValue;
    }

    public static int indexOf(float[] fArr, float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65597, null, new Object[]{fArr, Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            if (isEmpty(fArr)) {
                return -1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            while (i2 < fArr.length) {
                if (f2 == fArr[i2]) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static void reverse(int[] iArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65744, null, iArr, i2, i3) == null) || iArr == null) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int min = Math.min(iArr.length, i3) - 1;
        while (min > i2) {
            int i4 = iArr[min];
            iArr[min] = iArr[i2];
            iArr[i2] = i4;
            min--;
            i2++;
        }
    }

    public static long[] add(long[] jArr, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{jArr, Integer.valueOf(i2), Long.valueOf(j)})) == null) ? (long[]) add(jArr, i2, Long.valueOf(j), Long.TYPE) : (long[]) invokeCommon.objValue;
    }

    public static Character[] nullToEmpty(Character[] chArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65675, null, chArr)) == null) ? isEmpty(chArr) ? EMPTY_CHARACTER_OBJECT_ARRAY : chArr : (Character[]) invokeL.objValue;
    }

    public static void shift(double[] dArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65758, null, dArr, i2, i3, i4) == null) || dArr == null || i2 >= dArr.length - 1 || i3 <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 >= dArr.length) {
            i3 = dArr.length;
        }
        int i5 = i3 - i2;
        if (i5 <= 1) {
            return;
        }
        int i6 = i4 % i5;
        if (i6 < 0) {
            i6 += i5;
        }
        while (i5 > 1 && i6 > 0) {
            int i7 = i5 - i6;
            if (i6 > i7) {
                swap(dArr, i2, (i5 + i2) - i7, i7);
                int i8 = i6;
                i6 -= i7;
                i5 = i8;
            } else if (i6 < i7) {
                swap(dArr, i2, i2 + i7, i6);
                i2 += i6;
                i5 = i7;
            } else {
                swap(dArr, i2, i7 + i2, i6);
                return;
            }
        }
    }

    public static Float[] toObject(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65804, null, fArr)) == null) {
            if (fArr == null) {
                return null;
            }
            if (fArr.length == 0) {
                return EMPTY_FLOAT_OBJECT_ARRAY;
            }
            Float[] fArr2 = new Float[fArr.length];
            for (int i2 = 0; i2 < fArr.length; i2++) {
                fArr2[i2] = Float.valueOf(fArr[i2]);
            }
            return fArr2;
        }
        return (Float[]) invokeL.objValue;
    }

    public static float[] add(float[] fArr, int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{fArr, Integer.valueOf(i2), Float.valueOf(f2)})) == null) ? (float[]) add(fArr, i2, Float.valueOf(f2), Float.TYPE) : (float[]) invokeCommon.objValue;
    }

    public static int[] addAll(int[] iArr, int... iArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, iArr, iArr2)) == null) {
            if (iArr == null) {
                return clone(iArr2);
            }
            if (iArr2 == null) {
                return clone(iArr);
            }
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            return iArr3;
        }
        return (int[]) invokeLL.objValue;
    }

    public static short[] removeElements(short[] sArr, short... sArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65733, null, sArr, sArr2)) == null) {
            if (!isEmpty(sArr) && !isEmpty(sArr2)) {
                HashMap hashMap = new HashMap(sArr2.length);
                for (short s : sArr2) {
                    Short valueOf = Short.valueOf(s);
                    MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                    if (mutableInt == null) {
                        hashMap.put(valueOf, new MutableInt(1));
                    } else {
                        mutableInt.increment();
                    }
                }
                BitSet bitSet = new BitSet();
                for (int i2 = 0; i2 < sArr.length; i2++) {
                    short s2 = sArr[i2];
                    MutableInt mutableInt2 = (MutableInt) hashMap.get(Short.valueOf(s2));
                    if (mutableInt2 != null) {
                        if (mutableInt2.decrementAndGet() == 0) {
                            hashMap.remove(Short.valueOf(s2));
                        }
                        bitSet.set(i2);
                    }
                }
                return (short[]) removeAll(sArr, bitSet);
            }
            return clone(sArr);
        }
        return (short[]) invokeLL.objValue;
    }

    public static double[] subarray(double[] dArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65773, null, dArr, i2, i3)) == null) {
            if (dArr == null) {
                return null;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (i3 > dArr.length) {
                i3 = dArr.length;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return EMPTY_DOUBLE_ARRAY;
            }
            double[] dArr2 = new double[i4];
            System.arraycopy(dArr, i2, dArr2, 0, i4);
            return dArr2;
        }
        return (double[]) invokeLII.objValue;
    }

    public static double[] add(double[] dArr, int i2, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{dArr, Integer.valueOf(i2), Double.valueOf(d2)})) == null) ? (double[]) add(dArr, i2, Double.valueOf(d2), Double.TYPE) : (double[]) invokeCommon.objValue;
    }

    public static int indexOf(boolean[] zArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65606, null, zArr, z)) == null) ? indexOf(zArr, z, 0) : invokeLZ.intValue;
    }

    public static boolean isSorted(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65637, null, bArr)) == null) {
            if (bArr != null && bArr.length >= 2) {
                byte b2 = bArr[0];
                int length = bArr.length;
                int i2 = 1;
                while (i2 < length) {
                    byte b3 = bArr[i2];
                    if (NumberUtils.compare(b2, b3) > 0) {
                        return false;
                    }
                    i2++;
                    b2 = b3;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int lastIndexOf(double[] dArr, double d2, int i2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65654, null, new Object[]{dArr, Double.valueOf(d2), Integer.valueOf(i2), Double.valueOf(d3)})) == null) {
            if (!isEmpty(dArr) && i2 >= 0) {
                if (i2 >= dArr.length) {
                    i2 = dArr.length - 1;
                }
                double d4 = d2 - d3;
                double d5 = d2 + d3;
                while (i2 >= 0) {
                    if (dArr[i2] >= d4 && dArr[i2] <= d5) {
                        return i2;
                    }
                    i2--;
                }
                return -1;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static Byte[] nullToEmpty(Byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65674, null, bArr)) == null) ? isEmpty(bArr) ? EMPTY_BYTE_OBJECT_ARRAY : bArr : (Byte[]) invokeL.objValue;
    }

    public static Object add(Object obj, int i2, Object obj2, Class<?> cls) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65538, null, obj, i2, obj2, cls)) == null) {
            if (obj == null) {
                if (i2 == 0) {
                    Object newInstance = Array.newInstance(cls, 1);
                    Array.set(newInstance, 0, obj2);
                    return newInstance;
                }
                throw new IndexOutOfBoundsException("Index: " + i2 + ", Length: 0");
            }
            int length = Array.getLength(obj);
            if (i2 <= length && i2 >= 0) {
                Object newInstance2 = Array.newInstance(cls, length + 1);
                System.arraycopy(obj, 0, newInstance2, 0, i2);
                Array.set(newInstance2, i2, obj2);
                if (i2 < length) {
                    System.arraycopy(obj, i2, newInstance2, i2 + 1, length - i2);
                }
                return newInstance2;
            }
            throw new IndexOutOfBoundsException("Index: " + i2 + ", Length: " + length);
        }
        return invokeLILL.objValue;
    }

    public static int indexOf(boolean[] zArr, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65607, null, new Object[]{zArr, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (isEmpty(zArr)) {
                return -1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            while (i2 < zArr.length) {
                if (z == zArr[i2]) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static void reverse(long[] jArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65746, null, jArr, i2, i3) == null) || jArr == null) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int min = Math.min(jArr.length, i3) - 1;
        while (min > i2) {
            long j = jArr[min];
            jArr[min] = jArr[i2];
            jArr[i2] = j;
            min--;
            i2++;
        }
    }

    public static void swap(double[] dArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65785, null, dArr, i2, i3, i4) == null) || dArr == null || dArr.length == 0 || i2 >= dArr.length || i3 >= dArr.length) {
            return;
        }
        int i5 = 0;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int min = Math.min(Math.min(i4, dArr.length - i2), dArr.length - i3);
        while (i5 < min) {
            double d2 = dArr[i2];
            dArr[i2] = dArr[i3];
            dArr[i3] = d2;
            i5++;
            i2++;
            i3++;
        }
    }

    public static short[] toPrimitive(Short[] shArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65821, null, shArr)) == null) {
            if (shArr == null) {
                return null;
            }
            if (shArr.length == 0) {
                return EMPTY_SHORT_ARRAY;
            }
            short[] sArr = new short[shArr.length];
            for (int i2 = 0; i2 < shArr.length; i2++) {
                sArr[i2] = shArr[i2].shortValue();
            }
            return sArr;
        }
        return (short[]) invokeL.objValue;
    }

    public static Double[] nullToEmpty(Double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65677, null, dArr)) == null) ? isEmpty(dArr) ? EMPTY_DOUBLE_OBJECT_ARRAY : dArr : (Double[]) invokeL.objValue;
    }

    public static long[] removeAllOccurences(long[] jArr, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(65713, null, jArr, j)) != null) {
            return (long[]) invokeLJ.objValue;
        }
        int indexOf = indexOf(jArr, j);
        if (indexOf == -1) {
            return clone(jArr);
        }
        int[] iArr = new int[jArr.length - indexOf];
        iArr[0] = indexOf;
        int i2 = 1;
        while (true) {
            int indexOf2 = indexOf(jArr, j, iArr[i2 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i2] = indexOf2;
                i2++;
            } else {
                return removeAll(jArr, Arrays.copyOf(iArr, i2));
            }
        }
    }

    public static Boolean[] toObject(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65800, null, zArr)) == null) {
            if (zArr == null) {
                return null;
            }
            if (zArr.length == 0) {
                return EMPTY_BOOLEAN_OBJECT_ARRAY;
            }
            Boolean[] boolArr = new Boolean[zArr.length];
            for (int i2 = 0; i2 < zArr.length; i2++) {
                boolArr[i2] = zArr[i2] ? Boolean.TRUE : Boolean.FALSE;
            }
            return boolArr;
        }
        return (Boolean[]) invokeL.objValue;
    }

    public static long[] addAll(long[] jArr, long... jArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, jArr, jArr2)) == null) {
            if (jArr == null) {
                return clone(jArr2);
            }
            if (jArr2 == null) {
                return clone(jArr);
            }
            long[] jArr3 = new long[jArr.length + jArr2.length];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
            System.arraycopy(jArr2, 0, jArr3, jArr.length, jArr2.length);
            return jArr3;
        }
        return (long[]) invokeLL.objValue;
    }

    public static int lastIndexOf(float[] fArr, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65655, null, fArr, f2)) == null) ? lastIndexOf(fArr, f2, Integer.MAX_VALUE) : invokeLF.intValue;
    }

    public static Float[] nullToEmpty(Float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65678, null, fArr)) == null) ? isEmpty(fArr) ? EMPTY_FLOAT_OBJECT_ARRAY : fArr : (Float[]) invokeL.objValue;
    }

    public static float[] subarray(float[] fArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65774, null, fArr, i2, i3)) == null) {
            if (fArr == null) {
                return null;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (i3 > fArr.length) {
                i3 = fArr.length;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return EMPTY_FLOAT_ARRAY;
            }
            float[] fArr2 = new float[i4];
            System.arraycopy(fArr, i2, fArr2, 0, i4);
            return fArr2;
        }
        return (float[]) invokeLII.objValue;
    }

    public static boolean isSorted(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65638, null, cArr)) == null) {
            if (cArr != null && cArr.length >= 2) {
                char c2 = cArr[0];
                int length = cArr.length;
                int i2 = 1;
                while (i2 < length) {
                    char c3 = cArr[i2];
                    if (CharUtils.compare(c2, c3) > 0) {
                        return false;
                    }
                    i2++;
                    c2 = c3;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int lastIndexOf(float[] fArr, float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65656, null, new Object[]{fArr, Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            if (!isEmpty(fArr) && i2 >= 0) {
                if (i2 >= fArr.length) {
                    i2 = fArr.length - 1;
                }
                while (i2 >= 0) {
                    if (f2 == fArr[i2]) {
                        return i2;
                    }
                    i2--;
                }
                return -1;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static void reverse(Object[] objArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65748, null, objArr, i2, i3) == null) || objArr == null) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int min = Math.min(objArr.length, i3) - 1;
        while (min > i2) {
            Object obj = objArr[min];
            objArr[min] = objArr[i2];
            objArr[i2] = obj;
            min--;
            i2++;
        }
    }

    public static void shift(float[] fArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65760, null, fArr, i2, i3, i4) == null) || fArr == null || i2 >= fArr.length - 1 || i3 <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 >= fArr.length) {
            i3 = fArr.length;
        }
        int i5 = i3 - i2;
        if (i5 <= 1) {
            return;
        }
        int i6 = i4 % i5;
        if (i6 < 0) {
            i6 += i5;
        }
        while (i5 > 1 && i6 > 0) {
            int i7 = i5 - i6;
            if (i6 > i7) {
                swap(fArr, i2, (i5 + i2) - i7, i7);
                int i8 = i6;
                i6 -= i7;
                i5 = i8;
            } else if (i6 < i7) {
                swap(fArr, i2, i2 + i7, i6);
                i2 += i6;
                i5 = i7;
            } else {
                swap(fArr, i2, i7 + i2, i6);
                return;
            }
        }
    }

    public static Boolean[] nullToEmpty(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65673, null, boolArr)) == null) ? isEmpty(boolArr) ? EMPTY_BOOLEAN_OBJECT_ARRAY : boolArr : (Boolean[]) invokeL.objValue;
    }

    public static void swap(float[] fArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65787, null, fArr, i2, i3, i4) == null) || fArr == null || fArr.length == 0 || i2 >= fArr.length || i3 >= fArr.length) {
            return;
        }
        int i5 = 0;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int min = Math.min(Math.min(i4, fArr.length - i2), fArr.length - i3);
        while (i5 < min) {
            float f2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = f2;
            i5++;
            i2++;
            i3++;
        }
    }

    public static short[] toPrimitive(Short[] shArr, short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65822, null, new Object[]{shArr, Short.valueOf(s)})) == null) {
            if (shArr == null) {
                return null;
            }
            if (shArr.length == 0) {
                return EMPTY_SHORT_ARRAY;
            }
            short[] sArr = new short[shArr.length];
            for (int i2 = 0; i2 < shArr.length; i2++) {
                Short sh = shArr[i2];
                sArr[i2] = sh == null ? s : sh.shortValue();
            }
            return sArr;
        }
        return (short[]) invokeCommon.objValue;
    }

    public static float[] addAll(float[] fArr, float... fArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, fArr, fArr2)) == null) {
            if (fArr == null) {
                return clone(fArr2);
            }
            if (fArr2 == null) {
                return clone(fArr);
            }
            float[] fArr3 = new float[fArr.length + fArr2.length];
            System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
            System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
            return fArr3;
        }
        return (float[]) invokeLL.objValue;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65665, null, zArr, z)) == null) ? lastIndexOf(zArr, z, Integer.MAX_VALUE) : invokeLZ.intValue;
    }

    public static void reverse(short[] sArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65750, null, sArr, i2, i3) == null) || sArr == null) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int min = Math.min(sArr.length, i3) - 1;
        while (min > i2) {
            short s = sArr[min];
            sArr[min] = sArr[i2];
            sArr[i2] = s;
            min--;
            i2++;
        }
    }

    public static boolean[] subarray(boolean[] zArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65779, null, zArr, i2, i3)) == null) {
            if (zArr == null) {
                return null;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (i3 > zArr.length) {
                i3 = zArr.length;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return EMPTY_BOOLEAN_ARRAY;
            }
            boolean[] zArr2 = new boolean[i4];
            System.arraycopy(zArr, i2, zArr2, 0, i4);
            return zArr2;
        }
        return (boolean[]) invokeLII.objValue;
    }

    public static boolean isSorted(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65646, null, zArr)) == null) {
            if (zArr != null && zArr.length >= 2) {
                boolean z = zArr[0];
                int length = zArr.length;
                int i2 = 1;
                while (i2 < length) {
                    boolean z2 = zArr[i2];
                    if (BooleanUtils.compare(z, z2) > 0) {
                        return false;
                    }
                    i2++;
                    z = z2;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65666, null, new Object[]{zArr, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (!isEmpty(zArr) && i2 >= 0) {
                if (i2 >= zArr.length) {
                    i2 = zArr.length - 1;
                }
                while (i2 >= 0) {
                    if (z == zArr[i2]) {
                        return i2;
                    }
                    i2--;
                }
                return -1;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static float[] removeAllOccurences(float[] fArr, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLF = interceptable.invokeLF(65711, null, fArr, f2)) != null) {
            return (float[]) invokeLF.objValue;
        }
        int indexOf = indexOf(fArr, f2);
        if (indexOf == -1) {
            return clone(fArr);
        }
        int[] iArr = new int[fArr.length - indexOf];
        iArr[0] = indexOf;
        int i2 = 1;
        while (true) {
            int indexOf2 = indexOf(fArr, f2, iArr[i2 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i2] = indexOf2;
                i2++;
            } else {
                return removeAll(fArr, Arrays.copyOf(iArr, i2));
            }
        }
    }

    public static void swap(int[] iArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65789, null, iArr, i2, i3, i4) == null) || iArr == null || iArr.length == 0 || i2 >= iArr.length || i3 >= iArr.length) {
            return;
        }
        int i5 = 0;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int min = Math.min(Math.min(i4, iArr.length - i2), iArr.length - i3);
        while (i5 < min) {
            int i6 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i6;
            i5++;
            i2++;
            i3++;
        }
    }

    public static void shift(int[] iArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65762, null, iArr, i2, i3, i4) == null) || iArr == null || i2 >= iArr.length - 1 || i3 <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 >= iArr.length) {
            i3 = iArr.length;
        }
        int i5 = i3 - i2;
        if (i5 <= 1) {
            return;
        }
        int i6 = i4 % i5;
        if (i6 < 0) {
            i6 += i5;
        }
        while (i5 > 1 && i6 > 0) {
            int i7 = i5 - i6;
            if (i6 > i7) {
                swap(iArr, i2, (i5 + i2) - i7, i7);
                int i8 = i6;
                i6 -= i7;
                i5 = i8;
            } else if (i6 < i7) {
                swap(iArr, i2, i2 + i7, i6);
                i2 += i6;
                i5 = i7;
            } else {
                swap(iArr, i2, i7 + i2, i6);
                return;
            }
        }
    }

    public static byte[] toPrimitive(Byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65809, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            if (bArr.length == 0) {
                return EMPTY_BYTE_ARRAY;
            }
            byte[] bArr2 = new byte[bArr.length];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr2[i2] = bArr[i2].byteValue();
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public static double[] addAll(double[] dArr, double... dArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, dArr, dArr2)) == null) {
            if (dArr == null) {
                return clone(dArr2);
            }
            if (dArr2 == null) {
                return clone(dArr);
            }
            double[] dArr3 = new double[dArr.length + dArr2.length];
            System.arraycopy(dArr, 0, dArr3, 0, dArr.length);
            System.arraycopy(dArr2, 0, dArr3, dArr.length, dArr2.length);
            return dArr3;
        }
        return (double[]) invokeLL.objValue;
    }

    public static int[] removeElements(int[] iArr, int... iArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65730, null, iArr, iArr2)) == null) {
            if (!isEmpty(iArr) && !isEmpty(iArr2)) {
                HashMap hashMap = new HashMap(iArr2.length);
                for (int i2 : iArr2) {
                    Integer valueOf = Integer.valueOf(i2);
                    MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                    if (mutableInt == null) {
                        hashMap.put(valueOf, new MutableInt(1));
                    } else {
                        mutableInt.increment();
                    }
                }
                BitSet bitSet = new BitSet();
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    int i4 = iArr[i3];
                    MutableInt mutableInt2 = (MutableInt) hashMap.get(Integer.valueOf(i4));
                    if (mutableInt2 != null) {
                        if (mutableInt2.decrementAndGet() == 0) {
                            hashMap.remove(Integer.valueOf(i4));
                        }
                        bitSet.set(i3);
                    }
                }
                return (int[]) removeAll(iArr, bitSet);
            }
            return clone(iArr);
        }
        return (int[]) invokeLL.objValue;
    }

    public static void swap(long[] jArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65791, null, jArr, i2, i3, i4) == null) || jArr == null || jArr.length == 0 || i2 >= jArr.length || i3 >= jArr.length) {
            return;
        }
        int i5 = 0;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int min = Math.min(Math.min(i4, jArr.length - i2), jArr.length - i3);
        while (i5 < min) {
            long j = jArr[i2];
            jArr[i2] = jArr[i3];
            jArr[i3] = j;
            i5++;
            i2++;
            i3++;
        }
    }

    public static double[] removeAllOccurences(double[] dArr, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65710, null, new Object[]{dArr, Double.valueOf(d2)})) != null) {
            return (double[]) invokeCommon.objValue;
        }
        int indexOf = indexOf(dArr, d2);
        if (indexOf == -1) {
            return clone(dArr);
        }
        int[] iArr = new int[dArr.length - indexOf];
        iArr[0] = indexOf;
        int i2 = 1;
        while (true) {
            int indexOf2 = indexOf(dArr, d2, iArr[i2 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i2] = indexOf2;
                i2++;
            } else {
                return removeAll(dArr, Arrays.copyOf(iArr, i2));
            }
        }
    }

    public static byte[] toPrimitive(Byte[] bArr, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65810, null, new Object[]{bArr, Byte.valueOf(b2)})) == null) {
            if (bArr == null) {
                return null;
            }
            if (bArr.length == 0) {
                return EMPTY_BYTE_ARRAY;
            }
            byte[] bArr2 = new byte[bArr.length];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                Byte b3 = bArr[i2];
                bArr2[i2] = b3 == null ? b2 : b3.byteValue();
            }
            return bArr2;
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static void shift(long[] jArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65764, null, jArr, i2, i3, i4) == null) || jArr == null || i2 >= jArr.length - 1 || i3 <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 >= jArr.length) {
            i3 = jArr.length;
        }
        int i5 = i3 - i2;
        if (i5 <= 1) {
            return;
        }
        int i6 = i4 % i5;
        if (i6 < 0) {
            i6 += i5;
        }
        while (i5 > 1 && i6 > 0) {
            int i7 = i5 - i6;
            if (i6 > i7) {
                swap(jArr, i2, (i5 + i2) - i7, i7);
                int i8 = i6;
                i6 -= i7;
                i5 = i8;
            } else if (i6 < i7) {
                swap(jArr, i2, i2 + i7, i6);
                i2 += i6;
                i5 = i7;
            } else {
                swap(jArr, i2, i7 + i2, i6);
                return;
            }
        }
    }

    public static void swap(Object[] objArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65793, null, objArr, i2, i3, i4) == null) || objArr == null || objArr.length == 0 || i2 >= objArr.length || i3 >= objArr.length) {
            return;
        }
        int i5 = 0;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int min = Math.min(Math.min(i4, objArr.length - i2), objArr.length - i3);
        while (i5 < min) {
            Object obj = objArr[i2];
            objArr[i2] = objArr[i3];
            objArr[i3] = obj;
            i5++;
            i2++;
            i3++;
        }
    }

    public static double[] toPrimitive(Double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65813, null, dArr)) == null) {
            if (dArr == null) {
                return null;
            }
            if (dArr.length == 0) {
                return EMPTY_DOUBLE_ARRAY;
            }
            double[] dArr2 = new double[dArr.length];
            for (int i2 = 0; i2 < dArr.length; i2++) {
                dArr2[i2] = dArr[i2].doubleValue();
            }
            return dArr2;
        }
        return (double[]) invokeL.objValue;
    }

    public static <T> T[] removeAllOccurences(T[] tArr, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65714, null, tArr, t)) != null) {
            return (T[]) ((Object[]) invokeLL.objValue);
        }
        int indexOf = indexOf(tArr, t);
        if (indexOf == -1) {
            return (T[]) clone(tArr);
        }
        int[] iArr = new int[tArr.length - indexOf];
        iArr[0] = indexOf;
        int i2 = 1;
        while (true) {
            int indexOf2 = indexOf(tArr, t, iArr[i2 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i2] = indexOf2;
                i2++;
            } else {
                return (T[]) removeAll((Object[]) tArr, Arrays.copyOf(iArr, i2));
            }
        }
    }

    public static void shift(Object[] objArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65766, null, objArr, i2, i3, i4) == null) || objArr == null || i2 >= objArr.length - 1 || i3 <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 >= objArr.length) {
            i3 = objArr.length;
        }
        int i5 = i3 - i2;
        if (i5 <= 1) {
            return;
        }
        int i6 = i4 % i5;
        if (i6 < 0) {
            i6 += i5;
        }
        while (i5 > 1 && i6 > 0) {
            int i7 = i5 - i6;
            if (i6 > i7) {
                swap(objArr, i2, (i5 + i2) - i7, i7);
                int i8 = i6;
                i6 -= i7;
                i5 = i8;
            } else if (i6 < i7) {
                swap(objArr, i2, i2 + i7, i6);
                i2 += i6;
                i5 = i7;
            } else {
                swap(objArr, i2, i7 + i2, i6);
                return;
            }
        }
    }

    public static void swap(short[] sArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65795, null, sArr, i2, i3, i4) == null) || sArr == null || sArr.length == 0 || i2 >= sArr.length || i3 >= sArr.length) {
            return;
        }
        int i5 = 0;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i2 == i3) {
            return;
        }
        int min = Math.min(Math.min(i4, sArr.length - i2), sArr.length - i3);
        while (i5 < min) {
            short s = sArr[i2];
            sArr[i2] = sArr[i3];
            sArr[i3] = s;
            i5++;
            i2++;
            i3++;
        }
    }

    public static double[] toPrimitive(Double[] dArr, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65814, null, new Object[]{dArr, Double.valueOf(d2)})) == null) {
            if (dArr == null) {
                return null;
            }
            if (dArr.length == 0) {
                return EMPTY_DOUBLE_ARRAY;
            }
            double[] dArr2 = new double[dArr.length];
            for (int i2 = 0; i2 < dArr.length; i2++) {
                Double d3 = dArr[i2];
                dArr2[i2] = d3 == null ? d2 : d3.doubleValue();
            }
            return dArr2;
        }
        return (double[]) invokeCommon.objValue;
    }

    public static char[] removeElements(char[] cArr, char... cArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65727, null, cArr, cArr2)) == null) {
            if (!isEmpty(cArr) && !isEmpty(cArr2)) {
                HashMap hashMap = new HashMap(cArr2.length);
                for (char c2 : cArr2) {
                    Character valueOf = Character.valueOf(c2);
                    MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                    if (mutableInt == null) {
                        hashMap.put(valueOf, new MutableInt(1));
                    } else {
                        mutableInt.increment();
                    }
                }
                BitSet bitSet = new BitSet();
                for (int i2 = 0; i2 < cArr.length; i2++) {
                    char c3 = cArr[i2];
                    MutableInt mutableInt2 = (MutableInt) hashMap.get(Character.valueOf(c3));
                    if (mutableInt2 != null) {
                        if (mutableInt2.decrementAndGet() == 0) {
                            hashMap.remove(Character.valueOf(c3));
                        }
                        bitSet.set(i2);
                    }
                }
                return (char[]) removeAll(cArr, bitSet);
            }
            return clone(cArr);
        }
        return (char[]) invokeLL.objValue;
    }

    public static void shift(short[] sArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65768, null, sArr, i2, i3, i4) == null) || sArr == null || i2 >= sArr.length - 1 || i3 <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 >= sArr.length) {
            i3 = sArr.length;
        }
        int i5 = i3 - i2;
        if (i5 <= 1) {
            return;
        }
        int i6 = i4 % i5;
        if (i6 < 0) {
            i6 += i5;
        }
        while (i5 > 1 && i6 > 0) {
            int i7 = i5 - i6;
            if (i6 > i7) {
                swap(sArr, i2, (i5 + i2) - i7, i7);
                int i8 = i6;
                i6 -= i7;
                i5 = i8;
            } else if (i6 < i7) {
                swap(sArr, i2, i2 + i7, i6);
                i2 += i6;
                i5 = i7;
            } else {
                swap(sArr, i2, i7 + i2, i6);
                return;
            }
        }
    }

    public static float[] toPrimitive(Float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65815, null, fArr)) == null) {
            if (fArr == null) {
                return null;
            }
            if (fArr.length == 0) {
                return EMPTY_FLOAT_ARRAY;
            }
            float[] fArr2 = new float[fArr.length];
            for (int i2 = 0; i2 < fArr.length; i2++) {
                fArr2[i2] = fArr[i2].floatValue();
            }
            return fArr2;
        }
        return (float[]) invokeL.objValue;
    }

    public static float[] toPrimitive(Float[] fArr, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65816, null, fArr, f2)) == null) {
            if (fArr == null) {
                return null;
            }
            if (fArr.length == 0) {
                return EMPTY_FLOAT_ARRAY;
            }
            float[] fArr2 = new float[fArr.length];
            for (int i2 = 0; i2 < fArr.length; i2++) {
                Float f3 = fArr[i2];
                fArr2[i2] = f3 == null ? f2 : f3.floatValue();
            }
            return fArr2;
        }
        return (float[]) invokeLF.objValue;
    }

    public static Object toPrimitive(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65808, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> wrapperToPrimitive = ClassUtils.wrapperToPrimitive(obj.getClass().getComponentType());
            if (Integer.TYPE.equals(wrapperToPrimitive)) {
                return toPrimitive((Integer[]) obj);
            }
            if (Long.TYPE.equals(wrapperToPrimitive)) {
                return toPrimitive((Long[]) obj);
            }
            if (Short.TYPE.equals(wrapperToPrimitive)) {
                return toPrimitive((Short[]) obj);
            }
            if (Double.TYPE.equals(wrapperToPrimitive)) {
                return toPrimitive((Double[]) obj);
            }
            return Float.TYPE.equals(wrapperToPrimitive) ? toPrimitive((Float[]) obj) : obj;
        }
        return invokeL.objValue;
    }

    public static long[] removeElements(long[] jArr, long... jArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65731, null, jArr, jArr2)) == null) {
            if (!isEmpty(jArr) && !isEmpty(jArr2)) {
                HashMap hashMap = new HashMap(jArr2.length);
                for (long j : jArr2) {
                    Long valueOf = Long.valueOf(j);
                    MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                    if (mutableInt == null) {
                        hashMap.put(valueOf, new MutableInt(1));
                    } else {
                        mutableInt.increment();
                    }
                }
                BitSet bitSet = new BitSet();
                for (int i2 = 0; i2 < jArr.length; i2++) {
                    long j2 = jArr[i2];
                    MutableInt mutableInt2 = (MutableInt) hashMap.get(Long.valueOf(j2));
                    if (mutableInt2 != null) {
                        if (mutableInt2.decrementAndGet() == 0) {
                            hashMap.remove(Long.valueOf(j2));
                        }
                        bitSet.set(i2);
                    }
                }
                return (long[]) removeAll(jArr, bitSet);
            }
            return clone(jArr);
        }
        return (long[]) invokeLL.objValue;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65823, null, boolArr)) == null) {
            if (boolArr == null) {
                return null;
            }
            if (boolArr.length == 0) {
                return EMPTY_BOOLEAN_ARRAY;
            }
            boolean[] zArr = new boolean[boolArr.length];
            for (int i2 = 0; i2 < boolArr.length; i2++) {
                zArr[i2] = boolArr[i2].booleanValue();
            }
            return zArr;
        }
        return (boolean[]) invokeL.objValue;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65824, null, boolArr, z)) == null) {
            if (boolArr == null) {
                return null;
            }
            if (boolArr.length == 0) {
                return EMPTY_BOOLEAN_ARRAY;
            }
            boolean[] zArr = new boolean[boolArr.length];
            for (int i2 = 0; i2 < boolArr.length; i2++) {
                Boolean bool = boolArr[i2];
                zArr[i2] = bool == null ? z : bool.booleanValue();
            }
            return zArr;
        }
        return (boolean[]) invokeLZ.objValue;
    }

    public static float[] removeElements(float[] fArr, float... fArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65729, null, fArr, fArr2)) == null) {
            if (!isEmpty(fArr) && !isEmpty(fArr2)) {
                HashMap hashMap = new HashMap(fArr2.length);
                for (float f2 : fArr2) {
                    Float valueOf = Float.valueOf(f2);
                    MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                    if (mutableInt == null) {
                        hashMap.put(valueOf, new MutableInt(1));
                    } else {
                        mutableInt.increment();
                    }
                }
                BitSet bitSet = new BitSet();
                for (int i2 = 0; i2 < fArr.length; i2++) {
                    float f3 = fArr[i2];
                    MutableInt mutableInt2 = (MutableInt) hashMap.get(Float.valueOf(f3));
                    if (mutableInt2 != null) {
                        if (mutableInt2.decrementAndGet() == 0) {
                            hashMap.remove(Float.valueOf(f3));
                        }
                        bitSet.set(i2);
                    }
                }
                return (float[]) removeAll(fArr, bitSet);
            }
            return clone(fArr);
        }
        return (float[]) invokeLL.objValue;
    }

    public static double[] removeElements(double[] dArr, double... dArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65728, null, dArr, dArr2)) == null) {
            if (!isEmpty(dArr) && !isEmpty(dArr2)) {
                HashMap hashMap = new HashMap(dArr2.length);
                for (double d2 : dArr2) {
                    Double valueOf = Double.valueOf(d2);
                    MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                    if (mutableInt == null) {
                        hashMap.put(valueOf, new MutableInt(1));
                    } else {
                        mutableInt.increment();
                    }
                }
                BitSet bitSet = new BitSet();
                for (int i2 = 0; i2 < dArr.length; i2++) {
                    double d3 = dArr[i2];
                    MutableInt mutableInt2 = (MutableInt) hashMap.get(Double.valueOf(d3));
                    if (mutableInt2 != null) {
                        if (mutableInt2.decrementAndGet() == 0) {
                            hashMap.remove(Double.valueOf(d3));
                        }
                        bitSet.set(i2);
                    }
                }
                return (double[]) removeAll(dArr, bitSet);
            }
            return clone(dArr);
        }
        return (double[]) invokeLL.objValue;
    }

    public static boolean[] removeElements(boolean[] zArr, boolean... zArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65734, null, zArr, zArr2)) == null) {
            if (!isEmpty(zArr) && !isEmpty(zArr2)) {
                HashMap hashMap = new HashMap(2);
                for (boolean z : zArr2) {
                    Boolean valueOf = Boolean.valueOf(z);
                    MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                    if (mutableInt == null) {
                        hashMap.put(valueOf, new MutableInt(1));
                    } else {
                        mutableInt.increment();
                    }
                }
                BitSet bitSet = new BitSet();
                for (int i2 = 0; i2 < zArr.length; i2++) {
                    boolean z2 = zArr[i2];
                    MutableInt mutableInt2 = (MutableInt) hashMap.get(Boolean.valueOf(z2));
                    if (mutableInt2 != null) {
                        if (mutableInt2.decrementAndGet() == 0) {
                            hashMap.remove(Boolean.valueOf(z2));
                        }
                        bitSet.set(i2);
                    }
                }
                return (boolean[]) removeAll(zArr, bitSet);
            }
            return clone(zArr);
        }
        return (boolean[]) invokeLL.objValue;
    }
}
