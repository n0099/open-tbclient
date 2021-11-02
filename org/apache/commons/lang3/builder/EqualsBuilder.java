package org.apache.commons.lang3.builder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.Pair;
/* loaded from: classes3.dex */
public class EqualsBuilder implements Builder<Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadLocal<Set<Pair<IDKey, IDKey>>> REGISTRY;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isEquals;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1559191634, "Lorg/apache/commons/lang3/builder/EqualsBuilder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1559191634, "Lorg/apache/commons/lang3/builder/EqualsBuilder;");
                return;
            }
        }
        REGISTRY = new ThreadLocal<>();
    }

    public EqualsBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isEquals = true;
    }

    private void appendArray(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, obj, obj2) == null) {
            if (obj.getClass() != obj2.getClass()) {
                setEquals(false);
            } else if (obj instanceof long[]) {
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
                append((Object[]) obj, (Object[]) obj2);
            }
        }
    }

    public static Pair<IDKey, IDKey> getRegisterPair(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, obj, obj2)) == null) ? Pair.of(new IDKey(obj), new IDKey(obj2)) : (Pair) invokeLL.objValue;
    }

    public static Set<Pair<IDKey, IDKey>> getRegistry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? REGISTRY.get() : (Set) invokeV.objValue;
    }

    public static boolean isRegistered(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, obj, obj2)) == null) {
            Set<Pair<IDKey, IDKey>> registry = getRegistry();
            Pair<IDKey, IDKey> registerPair = getRegisterPair(obj, obj2);
            return registry != null && (registry.contains(registerPair) || registry.contains(Pair.of(registerPair.getLeft(), registerPair.getRight())));
        }
        return invokeLL.booleanValue;
    }

    public static void reflectionAppend(Object obj, Object obj2, Class<?> cls, EqualsBuilder equalsBuilder, boolean z, String[] strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{obj, obj2, cls, equalsBuilder, Boolean.valueOf(z), strArr}) == null) || isRegistered(obj, obj2)) {
            return;
        }
        try {
            register(obj, obj2);
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (int i2 = 0; i2 < declaredFields.length && equalsBuilder.isEquals; i2++) {
                Field field = declaredFields[i2];
                if (!ArrayUtils.contains(strArr, field.getName()) && !field.getName().contains("$") && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(EqualsExclude.class))) {
                    try {
                        equalsBuilder.append(field.get(obj), field.get(obj2));
                    } catch (IllegalAccessException unused) {
                        throw new InternalError("Unexpected IllegalAccessException");
                    }
                }
            }
        } finally {
            unregister(obj, obj2);
        }
    }

    public static boolean reflectionEquals(Object obj, Object obj2, Collection<String> collection) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, obj, obj2, collection)) == null) ? reflectionEquals(obj, obj2, ReflectionToStringBuilder.toNoNullStringArray(collection)) : invokeLLL.booleanValue;
    }

    public static void register(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, obj, obj2) == null) {
            Set<Pair<IDKey, IDKey>> registry = getRegistry();
            if (registry == null) {
                registry = new HashSet<>();
                REGISTRY.set(registry);
            }
            registry.add(getRegisterPair(obj, obj2));
        }
    }

    public static void unregister(Object obj, Object obj2) {
        Set<Pair<IDKey, IDKey>> registry;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, obj, obj2) == null) || (registry = getRegistry()) == null) {
            return;
        }
        registry.remove(getRegisterPair(obj, obj2));
        if (registry.isEmpty()) {
            REGISTRY.remove();
        }
    }

    public EqualsBuilder append(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, obj, obj2)) == null) {
            if (this.isEquals && obj != obj2) {
                if (obj != null && obj2 != null) {
                    if (!obj.getClass().isArray()) {
                        this.isEquals = obj.equals(obj2);
                    } else {
                        appendArray(obj, obj2);
                    }
                    return this;
                }
                setEquals(false);
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeLL.objValue;
    }

    public EqualsBuilder appendSuper(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            if (this.isEquals) {
                this.isEquals = z;
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeZ.objValue;
    }

    public boolean isEquals() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.isEquals : invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.isEquals = true;
        }
    }

    public void setEquals(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.isEquals = z;
        }
    }

    public static boolean reflectionEquals(Object obj, Object obj2, String... strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, obj, obj2, strArr)) == null) ? reflectionEquals(obj, obj2, false, null, strArr) : invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.lang3.builder.Builder
    public Boolean build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? Boolean.valueOf(isEquals()) : (Boolean) invokeV.objValue;
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, null, obj, obj2, z)) == null) ? reflectionEquals(obj, obj2, z, null, new String[0]) : invokeLLZ.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
        if (r2.isInstance(r11) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
        if (r1.isInstance(r12) == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
        r1 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean reflectionEquals(Object obj, Object obj2, boolean z, Class<?> cls, String... strArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{obj, obj2, Boolean.valueOf(z), cls, strArr})) == null) {
            if (obj == obj2) {
                return true;
            }
            if (obj != null && obj2 != null) {
                Class<?> cls2 = obj.getClass();
                Class<?> cls3 = obj2.getClass();
                if (!cls2.isInstance(obj2)) {
                    if (cls3.isInstance(obj)) {
                    }
                }
                EqualsBuilder equalsBuilder = new EqualsBuilder();
                try {
                    if (cls2.isArray()) {
                        equalsBuilder.append(obj, obj2);
                    } else {
                        reflectionAppend(obj, obj2, cls2, equalsBuilder, z, strArr);
                        while (cls2.getSuperclass() != null && cls2 != cls) {
                            cls2 = cls2.getSuperclass();
                            reflectionAppend(obj, obj2, cls2, equalsBuilder, z, strArr);
                        }
                    }
                    return equalsBuilder.isEquals();
                } catch (IllegalArgumentException unused) {
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public EqualsBuilder append(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (this.isEquals) {
                this.isEquals = j == j2;
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeCommon.objValue;
    }

    public EqualsBuilder append(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            if (this.isEquals) {
                this.isEquals = i2 == i3;
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeII.objValue;
    }

    public EqualsBuilder append(short s, short s2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Short.valueOf(s), Short.valueOf(s2)})) == null) {
            if (this.isEquals) {
                this.isEquals = s == s2;
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeCommon.objValue;
    }

    public EqualsBuilder append(char c2, char c3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Character.valueOf(c2), Character.valueOf(c3)})) == null) {
            if (this.isEquals) {
                this.isEquals = c2 == c3;
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeCommon.objValue;
    }

    public EqualsBuilder append(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) {
            if (this.isEquals) {
                this.isEquals = b2 == b3;
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeCommon.objValue;
    }

    public EqualsBuilder append(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) ? !this.isEquals ? this : append(Double.doubleToLongBits(d2), Double.doubleToLongBits(d3)) : (EqualsBuilder) invokeCommon.objValue;
    }

    public EqualsBuilder append(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? !this.isEquals ? this : append(Float.floatToIntBits(f2), Float.floatToIntBits(f3)) : (EqualsBuilder) invokeCommon.objValue;
    }

    public EqualsBuilder append(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.isEquals) {
                this.isEquals = z == z2;
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeCommon.objValue;
    }

    public EqualsBuilder append(Object[] objArr, Object[] objArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, objArr, objArr2)) == null) {
            if (this.isEquals && objArr != objArr2) {
                if (objArr != null && objArr2 != null) {
                    if (objArr.length != objArr2.length) {
                        setEquals(false);
                        return this;
                    }
                    for (int i2 = 0; i2 < objArr.length && this.isEquals; i2++) {
                        append(objArr[i2], objArr2[i2]);
                    }
                    return this;
                }
                setEquals(false);
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeLL.objValue;
    }

    public EqualsBuilder append(long[] jArr, long[] jArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, jArr, jArr2)) == null) {
            if (this.isEquals && jArr != jArr2) {
                if (jArr != null && jArr2 != null) {
                    if (jArr.length != jArr2.length) {
                        setEquals(false);
                        return this;
                    }
                    for (int i2 = 0; i2 < jArr.length && this.isEquals; i2++) {
                        append(jArr[i2], jArr2[i2]);
                    }
                    return this;
                }
                setEquals(false);
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeLL.objValue;
    }

    public EqualsBuilder append(int[] iArr, int[] iArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, iArr, iArr2)) == null) {
            if (this.isEquals && iArr != iArr2) {
                if (iArr != null && iArr2 != null) {
                    if (iArr.length != iArr2.length) {
                        setEquals(false);
                        return this;
                    }
                    for (int i2 = 0; i2 < iArr.length && this.isEquals; i2++) {
                        append(iArr[i2], iArr2[i2]);
                    }
                    return this;
                }
                setEquals(false);
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeLL.objValue;
    }

    public EqualsBuilder append(short[] sArr, short[] sArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, sArr, sArr2)) == null) {
            if (this.isEquals && sArr != sArr2) {
                if (sArr != null && sArr2 != null) {
                    if (sArr.length != sArr2.length) {
                        setEquals(false);
                        return this;
                    }
                    for (int i2 = 0; i2 < sArr.length && this.isEquals; i2++) {
                        append(sArr[i2], sArr2[i2]);
                    }
                    return this;
                }
                setEquals(false);
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeLL.objValue;
    }

    public EqualsBuilder append(char[] cArr, char[] cArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, cArr, cArr2)) == null) {
            if (this.isEquals && cArr != cArr2) {
                if (cArr != null && cArr2 != null) {
                    if (cArr.length != cArr2.length) {
                        setEquals(false);
                        return this;
                    }
                    for (int i2 = 0; i2 < cArr.length && this.isEquals; i2++) {
                        append(cArr[i2], cArr2[i2]);
                    }
                    return this;
                }
                setEquals(false);
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeLL.objValue;
    }

    public EqualsBuilder append(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bArr, bArr2)) == null) {
            if (this.isEquals && bArr != bArr2) {
                if (bArr != null && bArr2 != null) {
                    if (bArr.length != bArr2.length) {
                        setEquals(false);
                        return this;
                    }
                    for (int i2 = 0; i2 < bArr.length && this.isEquals; i2++) {
                        append(bArr[i2], bArr2[i2]);
                    }
                    return this;
                }
                setEquals(false);
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeLL.objValue;
    }

    public EqualsBuilder append(double[] dArr, double[] dArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, dArr, dArr2)) == null) {
            if (this.isEquals && dArr != dArr2) {
                if (dArr != null && dArr2 != null) {
                    if (dArr.length != dArr2.length) {
                        setEquals(false);
                        return this;
                    }
                    for (int i2 = 0; i2 < dArr.length && this.isEquals; i2++) {
                        append(dArr[i2], dArr2[i2]);
                    }
                    return this;
                }
                setEquals(false);
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeLL.objValue;
    }

    public EqualsBuilder append(float[] fArr, float[] fArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, fArr, fArr2)) == null) {
            if (this.isEquals && fArr != fArr2) {
                if (fArr != null && fArr2 != null) {
                    if (fArr.length != fArr2.length) {
                        setEquals(false);
                        return this;
                    }
                    for (int i2 = 0; i2 < fArr.length && this.isEquals; i2++) {
                        append(fArr[i2], fArr2[i2]);
                    }
                    return this;
                }
                setEquals(false);
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeLL.objValue;
    }

    public EqualsBuilder append(boolean[] zArr, boolean[] zArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, zArr, zArr2)) == null) {
            if (this.isEquals && zArr != zArr2) {
                if (zArr != null && zArr2 != null) {
                    if (zArr.length != zArr2.length) {
                        setEquals(false);
                        return this;
                    }
                    for (int i2 = 0; i2 < zArr.length && this.isEquals; i2++) {
                        append(zArr[i2], zArr2[i2]);
                    }
                    return this;
                }
                setEquals(false);
                return this;
            }
            return this;
        }
        return (EqualsBuilder) invokeLL.objValue;
    }
}
