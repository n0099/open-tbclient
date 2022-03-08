package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/* loaded from: classes9.dex */
public class AnnotationUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final ToStringStyle TO_STRING_STYLE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1073579052, "Lorg/apache/commons/lang3/AnnotationUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1073579052, "Lorg/apache/commons/lang3/AnnotationUtils;");
                return;
            }
        }
        TO_STRING_STYLE = new ToStringStyle() { // from class: org.apache.commons.lang3.AnnotationUtils.1
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 1;
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
                        return;
                    }
                }
                setDefaultFullDetail(true);
                setArrayContentDetail(true);
                setUseClassName(true);
                setUseShortClassName(true);
                setUseIdentityHashCode(false);
                setContentStart("(");
                setContentEnd(SmallTailInfo.EMOTION_SUFFIX);
                setFieldSeparator(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                setArrayStart(PreferencesUtil.LEFT_MOUNT);
                setArrayEnd(PreferencesUtil.RIGHT_MOUNT);
            }

            @Override // org.apache.commons.lang3.builder.ToStringStyle
            public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, stringBuffer, str, obj) == null) {
                    if (obj instanceof Annotation) {
                        obj = AnnotationUtils.toString((Annotation) obj);
                    }
                    super.appendDetail(stringBuffer, str, obj);
                }
            }

            @Override // org.apache.commons.lang3.builder.ToStringStyle
            public String getShortClassName(Class<?> cls) {
                InterceptResult invokeL;
                Class<?> cls2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
                    Iterator<Class<?>> it = ClassUtils.getAllInterfaces(cls).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            cls2 = null;
                            break;
                        }
                        cls2 = it.next();
                        if (Annotation.class.isAssignableFrom(cls2)) {
                            break;
                        }
                    }
                    return new StringBuilder(cls2 == null ? "" : cls2.getName()).insert(0, '@').toString();
                }
                return (String) invokeL.objValue;
            }
        };
    }

    public AnnotationUtils() {
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

    public static boolean annotationArrayMemberEquals(Annotation[] annotationArr, Annotation[] annotationArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, annotationArr, annotationArr2)) == null) {
            if (annotationArr.length != annotationArr2.length) {
                return false;
            }
            for (int i2 = 0; i2 < annotationArr.length; i2++) {
                if (!equals(annotationArr[i2], annotationArr2[i2])) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean arrayMemberEquals(Class<?> cls, Object obj, Object obj2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cls, obj, obj2)) == null) {
            if (cls.isAnnotation()) {
                return annotationArrayMemberEquals((Annotation[]) obj, (Annotation[]) obj2);
            }
            if (cls.equals(Byte.TYPE)) {
                return Arrays.equals((byte[]) obj, (byte[]) obj2);
            }
            if (cls.equals(Short.TYPE)) {
                return Arrays.equals((short[]) obj, (short[]) obj2);
            }
            if (cls.equals(Integer.TYPE)) {
                return Arrays.equals((int[]) obj, (int[]) obj2);
            }
            if (cls.equals(Character.TYPE)) {
                return Arrays.equals((char[]) obj, (char[]) obj2);
            }
            if (cls.equals(Long.TYPE)) {
                return Arrays.equals((long[]) obj, (long[]) obj2);
            }
            if (cls.equals(Float.TYPE)) {
                return Arrays.equals((float[]) obj, (float[]) obj2);
            }
            if (cls.equals(Double.TYPE)) {
                return Arrays.equals((double[]) obj, (double[]) obj2);
            }
            if (cls.equals(Boolean.TYPE)) {
                return Arrays.equals((boolean[]) obj, (boolean[]) obj2);
            }
            return Arrays.equals((Object[]) obj, (Object[]) obj2);
        }
        return invokeLLL.booleanValue;
    }

    public static int arrayMemberHash(Class<?> cls, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, obj)) == null) {
            if (cls.equals(Byte.TYPE)) {
                return Arrays.hashCode((byte[]) obj);
            }
            if (cls.equals(Short.TYPE)) {
                return Arrays.hashCode((short[]) obj);
            }
            if (cls.equals(Integer.TYPE)) {
                return Arrays.hashCode((int[]) obj);
            }
            if (cls.equals(Character.TYPE)) {
                return Arrays.hashCode((char[]) obj);
            }
            if (cls.equals(Long.TYPE)) {
                return Arrays.hashCode((long[]) obj);
            }
            if (cls.equals(Float.TYPE)) {
                return Arrays.hashCode((float[]) obj);
            }
            if (cls.equals(Double.TYPE)) {
                return Arrays.hashCode((double[]) obj);
            }
            if (cls.equals(Boolean.TYPE)) {
                return Arrays.hashCode((boolean[]) obj);
            }
            return Arrays.hashCode((Object[]) obj);
        }
        return invokeLL.intValue;
    }

    public static boolean equals(Annotation annotation, Annotation annotation2) {
        InterceptResult invokeLL;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, annotation, annotation2)) == null) {
            if (annotation == annotation2) {
                return true;
            }
            if (annotation != null && annotation2 != null) {
                Class<? extends Annotation> annotationType = annotation.annotationType();
                Class<? extends Annotation> annotationType2 = annotation2.annotationType();
                Validate.notNull(annotationType, "Annotation %s with null annotationType()", annotation);
                Validate.notNull(annotationType2, "Annotation %s with null annotationType()", annotation2);
                if (!annotationType.equals(annotationType2)) {
                    return false;
                }
                try {
                    for (Method method : annotationType.getDeclaredMethods()) {
                        if (method.getParameterTypes().length == 0 && isValidAnnotationMemberType(method.getReturnType()) && !memberEquals(method.getReturnType(), method.invoke(annotation, new Object[0]), method.invoke(annotation2, new Object[0]))) {
                            return false;
                        }
                    }
                    return true;
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int hashCode(Annotation annotation) {
        InterceptResult invokeL;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, annotation)) == null) {
            int i2 = 0;
            for (Method method : annotation.annotationType().getDeclaredMethods()) {
                try {
                    Object invoke = method.invoke(annotation, new Object[0]);
                    if (invoke != null) {
                        i2 += hashMember(method.getName(), invoke);
                    } else {
                        throw new IllegalStateException(String.format("Annotation method %s returned null", method));
                    }
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static int hashMember(String str, Object obj) {
        InterceptResult invokeLL;
        int hashCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, obj)) == null) {
            int hashCode2 = str.hashCode() * 127;
            if (obj.getClass().isArray()) {
                hashCode = arrayMemberHash(obj.getClass().getComponentType(), obj);
            } else if (obj instanceof Annotation) {
                hashCode = hashCode((Annotation) obj);
            } else {
                hashCode = obj.hashCode();
            }
            return hashCode2 ^ hashCode;
        }
        return invokeLL.intValue;
    }

    public static boolean isValidAnnotationMemberType(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cls)) == null) {
            if (cls == null) {
                return false;
            }
            if (cls.isArray()) {
                cls = cls.getComponentType();
            }
            return cls.isPrimitive() || cls.isEnum() || cls.isAnnotation() || String.class.equals(cls) || Class.class.equals(cls);
        }
        return invokeL.booleanValue;
    }

    public static boolean memberEquals(Class<?> cls, Object obj, Object obj2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, cls, obj, obj2)) == null) {
            if (obj == obj2) {
                return true;
            }
            if (obj == null || obj2 == null) {
                return false;
            }
            if (cls.isArray()) {
                return arrayMemberEquals(cls.getComponentType(), obj, obj2);
            }
            if (cls.isAnnotation()) {
                return equals((Annotation) obj, (Annotation) obj2);
            }
            return obj.equals(obj2);
        }
        return invokeLLL.booleanValue;
    }

    public static String toString(Annotation annotation) {
        InterceptResult invokeL;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, annotation)) == null) {
            ToStringBuilder toStringBuilder = new ToStringBuilder(annotation, TO_STRING_STYLE);
            for (Method method : annotation.annotationType().getDeclaredMethods()) {
                if (method.getParameterTypes().length <= 0) {
                    try {
                        toStringBuilder.append(method.getName(), method.invoke(annotation, new Object[0]));
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception e3) {
                        throw new RuntimeException(e3);
                    }
                }
            }
            return toStringBuilder.build();
        }
        return (String) invokeL.objValue;
    }
}
