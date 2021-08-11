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
import org.apache.commons.lang3.Validate;
/* loaded from: classes2.dex */
public class HashCodeBuilder implements Builder<Integer> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_INITIAL_VALUE = 17;
    public static final int DEFAULT_MULTIPLIER_VALUE = 37;
    public static final ThreadLocal<Set<IDKey>> REGISTRY;
    public transient /* synthetic */ FieldHolder $fh;
    public final int iConstant;
    public int iTotal;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1704773558, "Lorg/apache/commons/lang3/builder/HashCodeBuilder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1704773558, "Lorg/apache/commons/lang3/builder/HashCodeBuilder;");
                return;
            }
        }
        REGISTRY = new ThreadLocal<>();
    }

    public HashCodeBuilder() {
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
        this.iTotal = 0;
        this.iConstant = 37;
        this.iTotal = 17;
    }

    private void appendArray(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, obj) == null) {
            if (obj instanceof long[]) {
                append((long[]) obj);
            } else if (obj instanceof int[]) {
                append((int[]) obj);
            } else if (obj instanceof short[]) {
                append((short[]) obj);
            } else if (obj instanceof char[]) {
                append((char[]) obj);
            } else if (obj instanceof byte[]) {
                append((byte[]) obj);
            } else if (obj instanceof double[]) {
                append((double[]) obj);
            } else if (obj instanceof float[]) {
                append((float[]) obj);
            } else if (obj instanceof boolean[]) {
                append((boolean[]) obj);
            } else {
                append((Object[]) obj);
            }
        }
    }

    public static Set<IDKey> getRegistry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? REGISTRY.get() : (Set) invokeV.objValue;
    }

    public static boolean isRegistered(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, obj)) == null) {
            Set<IDKey> registry = getRegistry();
            return registry != null && registry.contains(new IDKey(obj));
        }
        return invokeL.booleanValue;
    }

    public static void reflectionAppend(Object obj, Class<?> cls, HashCodeBuilder hashCodeBuilder, boolean z, String[] strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{obj, cls, hashCodeBuilder, Boolean.valueOf(z), strArr}) == null) || isRegistered(obj)) {
            return;
        }
        try {
            register(obj);
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (Field field : declaredFields) {
                if (!ArrayUtils.contains(strArr, field.getName()) && !field.getName().contains("$") && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(HashCodeExclude.class))) {
                    try {
                        hashCodeBuilder.append(field.get(obj));
                    } catch (IllegalAccessException unused) {
                        throw new InternalError("Unexpected IllegalAccessException");
                    }
                }
            }
        } finally {
            unregister(obj);
        }
    }

    public static int reflectionHashCode(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65543, null, i2, i3, obj)) == null) ? reflectionHashCode(i2, i3, obj, false, null, new String[0]) : invokeIIL.intValue;
    }

    public static void register(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, obj) == null) {
            Set<IDKey> registry = getRegistry();
            if (registry == null) {
                registry = new HashSet<>();
                REGISTRY.set(registry);
            }
            registry.add(new IDKey(obj));
        }
    }

    public static void unregister(Object obj) {
        Set<IDKey> registry;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, null, obj) == null) || (registry = getRegistry()) == null) {
            return;
        }
        registry.remove(new IDKey(obj));
        if (registry.isEmpty()) {
            REGISTRY.remove();
        }
    }

    public HashCodeBuilder append(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.iTotal = (this.iTotal * this.iConstant) + (!z ? 1 : 0);
            return this;
        }
        return (HashCodeBuilder) invokeZ.objValue;
    }

    public HashCodeBuilder appendSuper(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            this.iTotal = (this.iTotal * this.iConstant) + i2;
            return this;
        }
        return (HashCodeBuilder) invokeI.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? toHashCode() : invokeV.intValue;
    }

    public int toHashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.iTotal : invokeV.intValue;
    }

    public static int reflectionHashCode(int i2, int i3, Object obj, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), obj, Boolean.valueOf(z)})) == null) ? reflectionHashCode(i2, i3, obj, z, null, new String[0]) : invokeCommon.intValue;
    }

    public HashCodeBuilder append(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, zArr)) == null) {
            if (zArr == null) {
                this.iTotal *= this.iConstant;
            } else {
                for (boolean z : zArr) {
                    append(z);
                }
            }
            return this;
        }
        return (HashCodeBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.lang3.builder.Builder
    public Integer build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? Integer.valueOf(toHashCode()) : (Integer) invokeV.objValue;
    }

    public static <T> int reflectionHashCode(int i2, int i3, T t, boolean z, Class<? super T> cls, String... strArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), t, Boolean.valueOf(z), cls, strArr})) == null) {
            if (t != null) {
                HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(i2, i3);
                Class<?> cls2 = t.getClass();
                reflectionAppend(t, cls2, hashCodeBuilder, z, strArr);
                while (cls2.getSuperclass() != null && cls2 != cls) {
                    cls2 = cls2.getSuperclass();
                    reflectionAppend(t, cls2, hashCodeBuilder, z, strArr);
                }
                return hashCodeBuilder.toHashCode();
            }
            throw new IllegalArgumentException("The object to build a hash code for must not be null");
        }
        return invokeCommon.intValue;
    }

    public HashCodeBuilder(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.iTotal = 0;
        Validate.isTrue(i2 % 2 != 0, "HashCodeBuilder requires an odd initial value", new Object[0]);
        Validate.isTrue(i3 % 2 != 0, "HashCodeBuilder requires an odd multiplier", new Object[0]);
        this.iConstant = i3;
        this.iTotal = i2;
    }

    public HashCodeBuilder append(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(1048576, this, b2)) == null) {
            this.iTotal = (this.iTotal * this.iConstant) + b2;
            return this;
        }
        return (HashCodeBuilder) invokeB.objValue;
    }

    public HashCodeBuilder append(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bArr)) == null) {
            if (bArr == null) {
                this.iTotal *= this.iConstant;
            } else {
                for (byte b2 : bArr) {
                    append(b2);
                }
            }
            return this;
        }
        return (HashCodeBuilder) invokeL.objValue;
    }

    public HashCodeBuilder append(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.iTotal = (this.iTotal * this.iConstant) + c2;
            return this;
        }
        return (HashCodeBuilder) invokeCommon.objValue;
    }

    public HashCodeBuilder append(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cArr)) == null) {
            if (cArr == null) {
                this.iTotal *= this.iConstant;
            } else {
                for (char c2 : cArr) {
                    append(c2);
                }
            }
            return this;
        }
        return (HashCodeBuilder) invokeL.objValue;
    }

    public static int reflectionHashCode(Object obj, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, obj, z)) == null) ? reflectionHashCode(17, 37, obj, z, null, new String[0]) : invokeLZ.intValue;
    }

    public static int reflectionHashCode(Object obj, Collection<String> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, obj, collection)) == null) ? reflectionHashCode(obj, ReflectionToStringBuilder.toNoNullStringArray(collection)) : invokeLL.intValue;
    }

    public static int reflectionHashCode(Object obj, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, obj, strArr)) == null) ? reflectionHashCode(17, 37, obj, false, null, strArr) : invokeLL.intValue;
    }

    public HashCodeBuilder append(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)})) == null) ? append(Double.doubleToLongBits(d2)) : (HashCodeBuilder) invokeCommon.objValue;
    }

    public HashCodeBuilder append(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, dArr)) == null) {
            if (dArr == null) {
                this.iTotal *= this.iConstant;
            } else {
                for (double d2 : dArr) {
                    append(d2);
                }
            }
            return this;
        }
        return (HashCodeBuilder) invokeL.objValue;
    }

    public HashCodeBuilder append(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
            this.iTotal = (this.iTotal * this.iConstant) + Float.floatToIntBits(f2);
            return this;
        }
        return (HashCodeBuilder) invokeF.objValue;
    }

    public HashCodeBuilder append(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, fArr)) == null) {
            if (fArr == null) {
                this.iTotal *= this.iConstant;
            } else {
                for (float f2 : fArr) {
                    append(f2);
                }
            }
            return this;
        }
        return (HashCodeBuilder) invokeL.objValue;
    }

    public HashCodeBuilder append(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.iTotal = (this.iTotal * this.iConstant) + i2;
            return this;
        }
        return (HashCodeBuilder) invokeI.objValue;
    }

    public HashCodeBuilder append(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, iArr)) == null) {
            if (iArr == null) {
                this.iTotal *= this.iConstant;
            } else {
                for (int i2 : iArr) {
                    append(i2);
                }
            }
            return this;
        }
        return (HashCodeBuilder) invokeL.objValue;
    }

    public HashCodeBuilder append(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            this.iTotal = (this.iTotal * this.iConstant) + ((int) (j2 ^ (j2 >> 32)));
            return this;
        }
        return (HashCodeBuilder) invokeJ.objValue;
    }

    public HashCodeBuilder append(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, jArr)) == null) {
            if (jArr == null) {
                this.iTotal *= this.iConstant;
            } else {
                for (long j2 : jArr) {
                    append(j2);
                }
            }
            return this;
        }
        return (HashCodeBuilder) invokeL.objValue;
    }

    public HashCodeBuilder append(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == null) {
                this.iTotal *= this.iConstant;
            } else if (obj.getClass().isArray()) {
                appendArray(obj);
            } else {
                this.iTotal = (this.iTotal * this.iConstant) + obj.hashCode();
            }
            return this;
        }
        return (HashCodeBuilder) invokeL.objValue;
    }

    public HashCodeBuilder append(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, objArr)) == null) {
            if (objArr == null) {
                this.iTotal *= this.iConstant;
            } else {
                for (Object obj : objArr) {
                    append(obj);
                }
            }
            return this;
        }
        return (HashCodeBuilder) invokeL.objValue;
    }

    public HashCodeBuilder append(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Short.valueOf(s)})) == null) {
            this.iTotal = (this.iTotal * this.iConstant) + s;
            return this;
        }
        return (HashCodeBuilder) invokeCommon.objValue;
    }

    public HashCodeBuilder append(short[] sArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, sArr)) == null) {
            if (sArr == null) {
                this.iTotal *= this.iConstant;
            } else {
                for (short s : sArr) {
                    append(s);
                }
            }
            return this;
        }
        return (HashCodeBuilder) invokeL.objValue;
    }
}
