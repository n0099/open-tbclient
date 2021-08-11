package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.text.StrBuilder;
/* loaded from: classes2.dex */
public class ObjectUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final Null NULL;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class Null implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7092611880189329093L;
        public transient /* synthetic */ FieldHolder $fh;

        public Null() {
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

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? ObjectUtils.NULL : invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(561917284, "Lorg/apache/commons/lang3/ObjectUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(561917284, "Lorg/apache/commons/lang3/ObjectUtils;");
                return;
            }
        }
        NULL = new Null();
    }

    public ObjectUtils() {
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

    public static byte CONST(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b2)) == null) ? b2 : invokeB.byteValue;
    }

    public static char CONST(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 : invokeCommon.charValue;
    }

    public static double CONST(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Double.valueOf(d2)})) == null) ? d2 : invokeCommon.doubleValue;
    }

    public static float CONST(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(AdIconUtil.AD_TEXT_ID, null, f2)) == null) ? f2 : invokeF.floatValue;
    }

    public static int CONST(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? i2 : invokeI.intValue;
    }

    public static long CONST(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j2)) == null) ? j2 : invokeJ.longValue;
    }

    public static <T> T CONST(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, t)) == null) ? t : (T) invokeL.objValue;
    }

    public static short CONST(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Short.valueOf(s)})) == null) ? s : invokeCommon.shortValue;
    }

    public static boolean CONST(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65546, null, z)) == null) ? z : invokeZ.booleanValue;
    }

    public static byte CONST_BYTE(int i2) throws IllegalArgumentException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) {
            if (i2 < -128 || i2 > 127) {
                throw new IllegalArgumentException("Supplied value must be a valid byte literal between -128 and 127: [" + i2 + PreferencesUtil.RIGHT_MOUNT);
            }
            return (byte) i2;
        }
        return invokeI.byteValue;
    }

    public static short CONST_SHORT(int i2) throws IllegalArgumentException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) {
            if (i2 < -32768 || i2 > 32767) {
                throw new IllegalArgumentException("Supplied value must be a valid byte literal between -32768 and 32767: [" + i2 + PreferencesUtil.RIGHT_MOUNT);
            }
            return (short) i2;
        }
        return invokeI.shortValue;
    }

    public static boolean allNotNull(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, objArr)) == null) {
            if (objArr == null) {
                return false;
            }
            for (Object obj : objArr) {
                if (obj == null) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean anyNotNull(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, objArr)) == null) ? firstNonNull(objArr) != null : invokeL.booleanValue;
    }

    public static <T> T clone(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65551, null, t)) != null) {
            return (T) invokeL.objValue;
        }
        if (!(t instanceof Cloneable)) {
            return null;
        }
        if (t.getClass().isArray()) {
            Class<?> componentType = t.getClass().getComponentType();
            if (!componentType.isPrimitive()) {
                return (T) ((Object[]) t).clone();
            }
            int length = Array.getLength(t);
            T t2 = (T) Array.newInstance(componentType, length);
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return t2;
                }
                Array.set(t2, i2, Array.get(t, i2));
                length = i2;
            }
        } else {
            try {
                return (T) t.getClass().getMethod("clone", new Class[0]).invoke(t, new Object[0]);
            } catch (IllegalAccessException e2) {
                throw new CloneFailedException("Cannot clone Cloneable type " + t.getClass().getName(), e2);
            } catch (NoSuchMethodException e3) {
                throw new CloneFailedException("Cloneable type " + t.getClass().getName() + " has no clone method", e3);
            } catch (InvocationTargetException e4) {
                throw new CloneFailedException("Exception cloning Cloneable type " + t.getClass().getName(), e4.getCause());
            }
        }
    }

    public static <T> T cloneIfPossible(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, t)) == null) {
            T t2 = (T) clone(t);
            return t2 == null ? t : t2;
        }
        return (T) invokeL.objValue;
    }

    public static <T extends Comparable<? super T>> int compare(T t, T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, t, t2)) == null) ? compare(t, t2, false) : invokeLL.intValue;
    }

    public static <T> T defaultIfNull(T t, T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, t, t2)) == null) ? t != null ? t : t2 : (T) invokeLL.objValue;
    }

    @Deprecated
    public static boolean equals(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, obj, obj2)) == null) {
            if (obj == obj2) {
                return true;
            }
            if (obj == null || obj2 == null) {
                return false;
            }
            return obj.equals(obj2);
        }
        return invokeLL.booleanValue;
    }

    public static <T> T firstNonNull(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, tArr)) == null) {
            if (tArr != null) {
                for (T t : tArr) {
                    if (t != null) {
                        return t;
                    }
                }
                return null;
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    @Deprecated
    public static int hashCode(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, obj)) == null) {
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static int hashCodeMulti(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, objArr)) == null) {
            int i2 = 1;
            if (objArr != null) {
                for (Object obj : objArr) {
                    i2 = (i2 * 31) + hashCode(obj);
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static String identityToString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            identityToString(sb, obj);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static <T extends Comparable<? super T>> T max(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, tArr)) == null) {
            T t = null;
            if (tArr != null) {
                for (T t2 : tArr) {
                    if (compare(t2, t, false) > 0) {
                        t = t2;
                    }
                }
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    public static <T extends Comparable<? super T>> T median(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, tArr)) == null) {
            Validate.notEmpty(tArr);
            Validate.noNullElements(tArr);
            TreeSet treeSet = new TreeSet();
            Collections.addAll(treeSet, tArr);
            return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
        }
        return (T) invokeL.objValue;
    }

    public static <T extends Comparable<? super T>> T min(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, tArr)) == null) {
            T t = null;
            if (tArr != null) {
                for (T t2 : tArr) {
                    if (compare(t2, t, true) < 0) {
                        t = t2;
                    }
                }
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    public static <T> T mode(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, tArr)) == null) {
            if (ArrayUtils.isNotEmpty(tArr)) {
                HashMap hashMap = new HashMap(tArr.length);
                int i2 = 0;
                for (T t : tArr) {
                    MutableInt mutableInt = (MutableInt) hashMap.get(t);
                    if (mutableInt == null) {
                        hashMap.put(t, new MutableInt(1));
                    } else {
                        mutableInt.increment();
                    }
                }
                while (true) {
                    T t2 = null;
                    for (Map.Entry entry : hashMap.entrySet()) {
                        int intValue = ((MutableInt) entry.getValue()).intValue();
                        if (intValue == i2) {
                            break;
                        } else if (intValue > i2) {
                            t2 = (T) entry.getKey();
                            i2 = intValue;
                        }
                    }
                    return t2;
                }
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static boolean notEqual(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, obj, obj2)) == null) ? !equals(obj, obj2) : invokeLL.booleanValue;
    }

    @Deprecated
    public static String toString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, obj)) == null) ? obj == null ? "" : obj.toString() : (String) invokeL.objValue;
    }

    public static <T extends Comparable<? super T>> int compare(T t, T t2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65554, null, t, t2, z)) == null) {
            if (t == t2) {
                return 0;
            }
            if (t == null) {
                return z ? 1 : -1;
            } else if (t2 == null) {
                return z ? -1 : 1;
            } else {
                return t.compareTo(t2);
            }
        }
        return invokeLLZ.intValue;
    }

    @Deprecated
    public static String toString(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, obj, str)) == null) ? obj == null ? str : obj.toString() : (String) invokeLL.objValue;
    }

    public static void identityToString(Appendable appendable, Object obj) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, appendable, obj) == null) {
            if (obj != null) {
                appendable.append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj)));
                return;
            }
            throw new NullPointerException("Cannot get the toString of a null identity");
        }
    }

    public static <T> T median(Comparator<T> comparator, T... tArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, comparator, tArr)) == null) {
            Validate.notEmpty(tArr, "null/empty items", new Object[0]);
            Validate.noNullElements(tArr);
            Validate.notNull(comparator, "null comparator", new Object[0]);
            TreeSet treeSet = new TreeSet(comparator);
            Collections.addAll(treeSet, tArr);
            return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
        }
        return (T) invokeLL.objValue;
    }

    public static void identityToString(StrBuilder strBuilder, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, strBuilder, obj) == null) {
            if (obj != null) {
                strBuilder.append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj)));
                return;
            }
            throw new NullPointerException("Cannot get the toString of a null identity");
        }
    }

    public static void identityToString(StringBuffer stringBuffer, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, stringBuffer, obj) == null) {
            if (obj != null) {
                stringBuffer.append(obj.getClass().getName());
                stringBuffer.append('@');
                stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
                return;
            }
            throw new NullPointerException("Cannot get the toString of a null identity");
        }
    }

    public static void identityToString(StringBuilder sb, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, sb, obj) == null) {
            if (obj != null) {
                sb.append(obj.getClass().getName());
                sb.append('@');
                sb.append(Integer.toHexString(System.identityHashCode(obj)));
                return;
            }
            throw new NullPointerException("Cannot get the toString of a null identity");
        }
    }
}
