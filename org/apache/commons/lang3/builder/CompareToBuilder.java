package org.apache.commons.lang3.builder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Comparator;
import org.apache.commons.lang3.ArrayUtils;
/* loaded from: classes4.dex */
public class CompareToBuilder implements Builder<Integer> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int comparison;

    public CompareToBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.comparison = 0;
    }

    private void appendArray(Object obj, Object obj2, Comparator<?> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, obj, obj2, comparator) == null) {
            if (obj instanceof long[]) {
                append((long[]) obj, (long[]) obj2);
            } else if (obj instanceof int[]) {
                append((int[]) obj, (int[]) obj2);
            } else if (obj instanceof short[]) {
                append((short[]) obj, (short[]) obj2);
            } else if (obj instanceof char[]) {
                append((char[]) obj, (char[]) obj2);
            } else if (obj instanceof byte[]) {
                append((byte[]) obj, (byte[]) obj2);
            } else if (obj instanceof double[]) {
                append((double[]) obj, (double[]) obj2);
            } else if (obj instanceof float[]) {
                append((float[]) obj, (float[]) obj2);
            } else if (obj instanceof boolean[]) {
                append((boolean[]) obj, (boolean[]) obj2);
            } else {
                append((Object[]) obj, (Object[]) obj2, comparator);
            }
        }
    }

    public static void reflectionAppend(Object obj, Object obj2, Class<?> cls, CompareToBuilder compareToBuilder, boolean z, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{obj, obj2, cls, compareToBuilder, Boolean.valueOf(z), strArr}) == null) {
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (int i2 = 0; i2 < declaredFields.length && compareToBuilder.comparison == 0; i2++) {
                Field field = declaredFields[i2];
                if (!ArrayUtils.contains(strArr, field.getName()) && !field.getName().contains("$") && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                    try {
                        compareToBuilder.append(field.get(obj), field.get(obj2));
                    } catch (IllegalAccessException unused) {
                        throw new InternalError("Unexpected IllegalAccessException");
                    }
                }
            }
        }
    }

    public static int reflectionCompare(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, obj, obj2)) == null) ? reflectionCompare(obj, obj2, false, null, new String[0]) : invokeLL.intValue;
    }

    public CompareToBuilder append(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, obj, obj2)) == null) ? append(obj, obj2, (Comparator<?>) null) : (CompareToBuilder) invokeLL.objValue;
    }

    public CompareToBuilder appendSuper(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            if (this.comparison != 0) {
                return this;
            }
            this.comparison = i2;
            return this;
        }
        return (CompareToBuilder) invokeI.objValue;
    }

    public int toComparison() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.comparison : invokeV.intValue;
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, obj, obj2, z)) == null) ? reflectionCompare(obj, obj2, z, null, new String[0]) : invokeLLZ.intValue;
    }

    public CompareToBuilder append(Object obj, Object obj2, Comparator<?> comparator) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, obj, obj2, comparator)) == null) {
            if (this.comparison == 0 && obj != obj2) {
                if (obj == null) {
                    this.comparison = -1;
                    return this;
                } else if (obj2 == null) {
                    this.comparison = 1;
                    return this;
                } else {
                    if (obj.getClass().isArray()) {
                        appendArray(obj, obj2, comparator);
                    } else if (comparator == null) {
                        this.comparison = ((Comparable) obj).compareTo(obj2);
                    } else {
                        this.comparison = comparator.compare(obj, obj2);
                    }
                    return this;
                }
            }
            return this;
        }
        return (CompareToBuilder) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.lang3.builder.Builder
    public Integer build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? Integer.valueOf(toComparison()) : (Integer) invokeV.objValue;
    }

    public static int reflectionCompare(Object obj, Object obj2, Collection<String> collection) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, obj2, collection)) == null) ? reflectionCompare(obj, obj2, ReflectionToStringBuilder.toNoNullStringArray(collection)) : invokeLLL.intValue;
    }

    public static int reflectionCompare(Object obj, Object obj2, String... strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, obj, obj2, strArr)) == null) ? reflectionCompare(obj, obj2, false, null, strArr) : invokeLLL.intValue;
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z, Class<?> cls, String... strArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{obj, obj2, Boolean.valueOf(z), cls, strArr})) == null) {
            if (obj == obj2) {
                return 0;
            }
            if (obj != null && obj2 != null) {
                Class<?> cls2 = obj.getClass();
                if (cls2.isInstance(obj2)) {
                    CompareToBuilder compareToBuilder = new CompareToBuilder();
                    reflectionAppend(obj, obj2, cls2, compareToBuilder, z, strArr);
                    while (cls2.getSuperclass() != null && cls2 != cls) {
                        cls2 = cls2.getSuperclass();
                        reflectionAppend(obj, obj2, cls2, compareToBuilder, z, strArr);
                    }
                    return compareToBuilder.toComparison();
                }
                throw new ClassCastException();
            }
            throw null;
        }
        return invokeCommon.intValue;
    }

    public CompareToBuilder append(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (this.comparison != 0) {
                return this;
            }
            int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
            this.comparison = i2 < 0 ? -1 : i2 > 0 ? 1 : 0;
            return this;
        }
        return (CompareToBuilder) invokeCommon.objValue;
    }

    public CompareToBuilder append(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            if (this.comparison != 0) {
                return this;
            }
            this.comparison = i2 < i3 ? -1 : i2 > i3 ? 1 : 0;
            return this;
        }
        return (CompareToBuilder) invokeII.objValue;
    }

    public CompareToBuilder append(short s, short s2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Short.valueOf(s), Short.valueOf(s2)})) == null) {
            if (this.comparison != 0) {
                return this;
            }
            this.comparison = s < s2 ? -1 : s > s2 ? 1 : 0;
            return this;
        }
        return (CompareToBuilder) invokeCommon.objValue;
    }

    public CompareToBuilder append(char c2, char c3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Character.valueOf(c2), Character.valueOf(c3)})) == null) {
            if (this.comparison != 0) {
                return this;
            }
            this.comparison = c2 < c3 ? -1 : c2 > c3 ? 1 : 0;
            return this;
        }
        return (CompareToBuilder) invokeCommon.objValue;
    }

    public CompareToBuilder append(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) {
            if (this.comparison != 0) {
                return this;
            }
            this.comparison = b2 < b3 ? -1 : b2 > b3 ? 1 : 0;
            return this;
        }
        return (CompareToBuilder) invokeCommon.objValue;
    }

    public CompareToBuilder append(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            if (this.comparison != 0) {
                return this;
            }
            this.comparison = Double.compare(d2, d3);
            return this;
        }
        return (CompareToBuilder) invokeCommon.objValue;
    }

    public CompareToBuilder append(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.comparison != 0) {
                return this;
            }
            this.comparison = Float.compare(f2, f3);
            return this;
        }
        return (CompareToBuilder) invokeCommon.objValue;
    }

    public CompareToBuilder append(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.comparison == 0 && z != z2) {
                if (!z) {
                    this.comparison = -1;
                } else {
                    this.comparison = 1;
                }
                return this;
            }
            return this;
        }
        return (CompareToBuilder) invokeCommon.objValue;
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, objArr, objArr2)) == null) ? append(objArr, objArr2, (Comparator<?>) null) : (CompareToBuilder) invokeLL.objValue;
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2, Comparator<?> comparator) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, objArr, objArr2, comparator)) == null) {
            if (this.comparison == 0 && objArr != objArr2) {
                if (objArr == null) {
                    this.comparison = -1;
                    return this;
                } else if (objArr2 == null) {
                    this.comparison = 1;
                    return this;
                } else if (objArr.length != objArr2.length) {
                    this.comparison = objArr.length >= objArr2.length ? 1 : -1;
                    return this;
                } else {
                    for (int i2 = 0; i2 < objArr.length && this.comparison == 0; i2++) {
                        append(objArr[i2], objArr2[i2], comparator);
                    }
                    return this;
                }
            }
            return this;
        }
        return (CompareToBuilder) invokeLLL.objValue;
    }

    public CompareToBuilder append(long[] jArr, long[] jArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, jArr, jArr2)) == null) {
            if (this.comparison == 0 && jArr != jArr2) {
                if (jArr == null) {
                    this.comparison = -1;
                    return this;
                } else if (jArr2 == null) {
                    this.comparison = 1;
                    return this;
                } else if (jArr.length != jArr2.length) {
                    this.comparison = jArr.length >= jArr2.length ? 1 : -1;
                    return this;
                } else {
                    for (int i2 = 0; i2 < jArr.length && this.comparison == 0; i2++) {
                        append(jArr[i2], jArr2[i2]);
                    }
                    return this;
                }
            }
            return this;
        }
        return (CompareToBuilder) invokeLL.objValue;
    }

    public CompareToBuilder append(int[] iArr, int[] iArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, iArr, iArr2)) == null) {
            if (this.comparison == 0 && iArr != iArr2) {
                if (iArr == null) {
                    this.comparison = -1;
                    return this;
                } else if (iArr2 == null) {
                    this.comparison = 1;
                    return this;
                } else if (iArr.length != iArr2.length) {
                    this.comparison = iArr.length >= iArr2.length ? 1 : -1;
                    return this;
                } else {
                    for (int i2 = 0; i2 < iArr.length && this.comparison == 0; i2++) {
                        append(iArr[i2], iArr2[i2]);
                    }
                    return this;
                }
            }
            return this;
        }
        return (CompareToBuilder) invokeLL.objValue;
    }

    public CompareToBuilder append(short[] sArr, short[] sArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, sArr, sArr2)) == null) {
            if (this.comparison == 0 && sArr != sArr2) {
                if (sArr == null) {
                    this.comparison = -1;
                    return this;
                } else if (sArr2 == null) {
                    this.comparison = 1;
                    return this;
                } else if (sArr.length != sArr2.length) {
                    this.comparison = sArr.length >= sArr2.length ? 1 : -1;
                    return this;
                } else {
                    for (int i2 = 0; i2 < sArr.length && this.comparison == 0; i2++) {
                        append(sArr[i2], sArr2[i2]);
                    }
                    return this;
                }
            }
            return this;
        }
        return (CompareToBuilder) invokeLL.objValue;
    }

    public CompareToBuilder append(char[] cArr, char[] cArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, cArr, cArr2)) == null) {
            if (this.comparison == 0 && cArr != cArr2) {
                if (cArr == null) {
                    this.comparison = -1;
                    return this;
                } else if (cArr2 == null) {
                    this.comparison = 1;
                    return this;
                } else if (cArr.length != cArr2.length) {
                    this.comparison = cArr.length >= cArr2.length ? 1 : -1;
                    return this;
                } else {
                    for (int i2 = 0; i2 < cArr.length && this.comparison == 0; i2++) {
                        append(cArr[i2], cArr2[i2]);
                    }
                    return this;
                }
            }
            return this;
        }
        return (CompareToBuilder) invokeLL.objValue;
    }

    public CompareToBuilder append(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bArr, bArr2)) == null) {
            if (this.comparison == 0 && bArr != bArr2) {
                if (bArr == null) {
                    this.comparison = -1;
                    return this;
                } else if (bArr2 == null) {
                    this.comparison = 1;
                    return this;
                } else if (bArr.length != bArr2.length) {
                    this.comparison = bArr.length >= bArr2.length ? 1 : -1;
                    return this;
                } else {
                    for (int i2 = 0; i2 < bArr.length && this.comparison == 0; i2++) {
                        append(bArr[i2], bArr2[i2]);
                    }
                    return this;
                }
            }
            return this;
        }
        return (CompareToBuilder) invokeLL.objValue;
    }

    public CompareToBuilder append(double[] dArr, double[] dArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, dArr, dArr2)) == null) {
            if (this.comparison == 0 && dArr != dArr2) {
                if (dArr == null) {
                    this.comparison = -1;
                    return this;
                } else if (dArr2 == null) {
                    this.comparison = 1;
                    return this;
                } else if (dArr.length != dArr2.length) {
                    this.comparison = dArr.length >= dArr2.length ? 1 : -1;
                    return this;
                } else {
                    for (int i2 = 0; i2 < dArr.length && this.comparison == 0; i2++) {
                        append(dArr[i2], dArr2[i2]);
                    }
                    return this;
                }
            }
            return this;
        }
        return (CompareToBuilder) invokeLL.objValue;
    }

    public CompareToBuilder append(float[] fArr, float[] fArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, fArr, fArr2)) == null) {
            if (this.comparison == 0 && fArr != fArr2) {
                if (fArr == null) {
                    this.comparison = -1;
                    return this;
                } else if (fArr2 == null) {
                    this.comparison = 1;
                    return this;
                } else if (fArr.length != fArr2.length) {
                    this.comparison = fArr.length >= fArr2.length ? 1 : -1;
                    return this;
                } else {
                    for (int i2 = 0; i2 < fArr.length && this.comparison == 0; i2++) {
                        append(fArr[i2], fArr2[i2]);
                    }
                    return this;
                }
            }
            return this;
        }
        return (CompareToBuilder) invokeLL.objValue;
    }

    public CompareToBuilder append(boolean[] zArr, boolean[] zArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, zArr, zArr2)) == null) {
            if (this.comparison == 0 && zArr != zArr2) {
                if (zArr == null) {
                    this.comparison = -1;
                    return this;
                } else if (zArr2 == null) {
                    this.comparison = 1;
                    return this;
                } else if (zArr.length != zArr2.length) {
                    this.comparison = zArr.length >= zArr2.length ? 1 : -1;
                    return this;
                } else {
                    for (int i2 = 0; i2 < zArr.length && this.comparison == 0; i2++) {
                        append(zArr[i2], zArr2[i2]);
                    }
                    return this;
                }
            }
            return this;
        }
        return (CompareToBuilder) invokeLL.objValue;
    }
}
