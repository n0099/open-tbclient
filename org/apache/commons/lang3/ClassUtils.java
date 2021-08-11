package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.mutable.MutableObject;
/* loaded from: classes2.dex */
public class ClassUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INNER_CLASS_SEPARATOR;
    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
    public static final String PACKAGE_SEPARATOR;
    public static final char PACKAGE_SEPARATOR_CHAR = '.';
    public static final Map<String, String> abbreviationMap;
    public static final Map<String, Class<?>> namePrimitiveMap;
    public static final Map<Class<?>, Class<?>> primitiveWrapperMap;
    public static final Map<String, String> reverseAbbreviationMap;
    public static final Map<Class<?>, Class<?>> wrapperPrimitiveMap;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class Interfaces {
        public static final /* synthetic */ Interfaces[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Interfaces EXCLUDE;
        public static final Interfaces INCLUDE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-801243951, "Lorg/apache/commons/lang3/ClassUtils$Interfaces;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-801243951, "Lorg/apache/commons/lang3/ClassUtils$Interfaces;");
                    return;
                }
            }
            INCLUDE = new Interfaces("INCLUDE", 0);
            Interfaces interfaces = new Interfaces("EXCLUDE", 1);
            EXCLUDE = interfaces;
            $VALUES = new Interfaces[]{INCLUDE, interfaces};
        }

        public Interfaces(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Interfaces valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Interfaces) Enum.valueOf(Interfaces.class, str) : (Interfaces) invokeL.objValue;
        }

        public static Interfaces[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Interfaces[]) $VALUES.clone() : (Interfaces[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1579089479, "Lorg/apache/commons/lang3/ClassUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1579089479, "Lorg/apache/commons/lang3/ClassUtils;");
                return;
            }
        }
        PACKAGE_SEPARATOR = String.valueOf('.');
        INNER_CLASS_SEPARATOR = String.valueOf('$');
        HashMap hashMap = new HashMap();
        namePrimitiveMap = hashMap;
        hashMap.put("boolean", Boolean.TYPE);
        namePrimitiveMap.put("byte", Byte.TYPE);
        namePrimitiveMap.put("char", Character.TYPE);
        namePrimitiveMap.put("short", Short.TYPE);
        namePrimitiveMap.put("int", Integer.TYPE);
        namePrimitiveMap.put("long", Long.TYPE);
        namePrimitiveMap.put("double", Double.TYPE);
        namePrimitiveMap.put(ShaderParams.VALUE_TYPE_FLOAT, Float.TYPE);
        namePrimitiveMap.put("void", Void.TYPE);
        HashMap hashMap2 = new HashMap();
        primitiveWrapperMap = hashMap2;
        hashMap2.put(Boolean.TYPE, Boolean.class);
        primitiveWrapperMap.put(Byte.TYPE, Byte.class);
        primitiveWrapperMap.put(Character.TYPE, Character.class);
        primitiveWrapperMap.put(Short.TYPE, Short.class);
        primitiveWrapperMap.put(Integer.TYPE, Integer.class);
        primitiveWrapperMap.put(Long.TYPE, Long.class);
        primitiveWrapperMap.put(Double.TYPE, Double.class);
        primitiveWrapperMap.put(Float.TYPE, Float.class);
        Map<Class<?>, Class<?>> map = primitiveWrapperMap;
        Class<?> cls = Void.TYPE;
        map.put(cls, cls);
        wrapperPrimitiveMap = new HashMap();
        for (Map.Entry<Class<?>, Class<?>> entry : primitiveWrapperMap.entrySet()) {
            Class<?> key = entry.getKey();
            Class<?> value = entry.getValue();
            if (!key.equals(value)) {
                wrapperPrimitiveMap.put(value, key);
            }
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put("int", "I");
        hashMap3.put("boolean", "Z");
        hashMap3.put(ShaderParams.VALUE_TYPE_FLOAT, "F");
        hashMap3.put("long", "J");
        hashMap3.put("short", "S");
        hashMap3.put("byte", "B");
        hashMap3.put("double", "D");
        hashMap3.put("char", "C");
        HashMap hashMap4 = new HashMap();
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            hashMap4.put(entry2.getValue(), entry2.getKey());
        }
        abbreviationMap = Collections.unmodifiableMap(hashMap3);
        reverseAbbreviationMap = Collections.unmodifiableMap(hashMap4);
    }

    public ClassUtils() {
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

    public static List<Class<?>> convertClassNamesToClasses(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (String str : list) {
                try {
                    arrayList.add(Class.forName(str));
                } catch (Exception unused) {
                    arrayList.add(null);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<String> convertClassesToClassNames(List<Class<?>> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Class<?> cls : list) {
                if (cls == null) {
                    arrayList.add(null);
                } else {
                    arrayList.add(cls.getName());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String getAbbreviatedName(Class<?> cls, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, i2)) == null) ? cls == null ? "" : getAbbreviatedName(cls.getName(), i2) : (String) invokeLI.objValue;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, cls)) == null) {
            if (cls == null) {
                return null;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            getAllInterfaces(cls, linkedHashSet);
            return new ArrayList(linkedHashSet);
        }
        return (List) invokeL.objValue;
    }

    public static List<Class<?>> getAllSuperclasses(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cls)) == null) {
            if (cls == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
                arrayList.add(superclass);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String getCanonicalName(String str) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            String deleteWhitespace = StringUtils.deleteWhitespace(str);
            if (deleteWhitespace == null) {
                return null;
            }
            int i2 = 0;
            while (deleteWhitespace.startsWith(PreferencesUtil.LEFT_MOUNT)) {
                i2++;
                deleteWhitespace = deleteWhitespace.substring(1);
            }
            if (i2 < 1) {
                return deleteWhitespace;
            }
            if (deleteWhitespace.startsWith("L")) {
                if (deleteWhitespace.endsWith(";")) {
                    length = deleteWhitespace.length() - 1;
                } else {
                    length = deleteWhitespace.length();
                }
                deleteWhitespace = deleteWhitespace.substring(1, length);
            } else if (deleteWhitespace.length() > 0) {
                deleteWhitespace = reverseAbbreviationMap.get(deleteWhitespace.substring(0, 1));
            }
            StringBuilder sb = new StringBuilder(deleteWhitespace);
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append("[]");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static Class<?> getClass(ClassLoader classLoader, String str, boolean z) throws ClassNotFoundException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65547, null, classLoader, str, z)) == null) {
            try {
                if (namePrimitiveMap.containsKey(str)) {
                    return namePrimitiveMap.get(str);
                }
                return Class.forName(toCanonicalName(str), z, classLoader);
            } catch (ClassNotFoundException e2) {
                int lastIndexOf = str.lastIndexOf(46);
                if (lastIndexOf != -1) {
                    try {
                        return getClass(classLoader, str.substring(0, lastIndexOf) + '$' + str.substring(lastIndexOf + 1), z);
                    } catch (ClassNotFoundException unused) {
                        throw e2;
                    }
                }
                throw e2;
            }
        }
        return (Class) invokeLLZ.objValue;
    }

    public static String getPackageCanonicalName(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, obj, str)) == null) ? obj == null ? str : getPackageCanonicalName(obj.getClass().getName()) : (String) invokeLL.objValue;
    }

    public static String getPackageName(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, obj, str)) == null) ? obj == null ? str : getPackageName(obj.getClass()) : (String) invokeLL.objValue;
    }

    public static Method getPublicMethod(Class<?> cls, String str, Class<?>... clsArr) throws SecurityException, NoSuchMethodException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, null, cls, str, clsArr)) == null) {
            Method method = cls.getMethod(str, clsArr);
            if (Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
                return method;
            }
            ArrayList<Class> arrayList = new ArrayList();
            arrayList.addAll(getAllInterfaces(cls));
            arrayList.addAll(getAllSuperclasses(cls));
            for (Class cls2 : arrayList) {
                if (Modifier.isPublic(cls2.getModifiers())) {
                    try {
                        Method method2 = cls2.getMethod(str, clsArr);
                        if (Modifier.isPublic(method2.getDeclaringClass().getModifiers())) {
                            return method2;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                }
            }
            throw new NoSuchMethodException("Can't find a public method for " + str + " " + ArrayUtils.toString(clsArr));
        }
        return (Method) invokeLLL.objValue;
    }

    public static String getShortCanonicalName(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, obj, str)) == null) ? obj == null ? str : getShortCanonicalName(obj.getClass().getName()) : (String) invokeLL.objValue;
    }

    public static String getShortClassName(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, obj, str)) == null) ? obj == null ? str : getShortClassName(obj.getClass()) : (String) invokeLL.objValue;
    }

    public static String getSimpleName(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, cls)) == null) ? cls == null ? "" : cls.getSimpleName() : (String) invokeL.objValue;
    }

    public static Iterable<Class<?>> hierarchy(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, cls)) == null) ? hierarchy(cls, Interfaces.EXCLUDE) : (Iterable) invokeL.objValue;
    }

    public static boolean isAssignable(Class<?>[] clsArr, Class<?>... clsArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, clsArr, clsArr2)) == null) ? isAssignable(clsArr, clsArr2, SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_5)) : invokeLL.booleanValue;
    }

    public static boolean isInnerClass(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, cls)) == null) ? (cls == null || cls.getEnclosingClass() == null) ? false : true : invokeL.booleanValue;
    }

    public static boolean isPrimitiveOrWrapper(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, cls)) == null) {
            if (cls == null) {
                return false;
            }
            return cls.isPrimitive() || isPrimitiveWrapper(cls);
        }
        return invokeL.booleanValue;
    }

    public static boolean isPrimitiveWrapper(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, cls)) == null) ? wrapperPrimitiveMap.containsKey(cls) : invokeL.booleanValue;
    }

    public static Class<?> primitiveToWrapper(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, null, cls)) == null) ? (cls == null || !cls.isPrimitive()) ? cls : primitiveWrapperMap.get(cls) : (Class) invokeL.objValue;
    }

    public static Class<?>[] primitivesToWrappers(Class<?>... clsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, clsArr)) == null) {
            if (clsArr == null) {
                return null;
            }
            if (clsArr.length == 0) {
                return clsArr;
            }
            Class<?>[] clsArr2 = new Class[clsArr.length];
            for (int i2 = 0; i2 < clsArr.length; i2++) {
                clsArr2[i2] = primitiveToWrapper(clsArr[i2]);
            }
            return clsArr2;
        }
        return (Class[]) invokeL.objValue;
    }

    public static String toCanonicalName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, str)) == null) {
            String deleteWhitespace = StringUtils.deleteWhitespace(str);
            if (deleteWhitespace != null) {
                if (deleteWhitespace.endsWith("[]")) {
                    StringBuilder sb = new StringBuilder();
                    while (deleteWhitespace.endsWith("[]")) {
                        deleteWhitespace = deleteWhitespace.substring(0, deleteWhitespace.length() - 2);
                        sb.append(PreferencesUtil.LEFT_MOUNT);
                    }
                    String str2 = abbreviationMap.get(deleteWhitespace);
                    if (str2 != null) {
                        sb.append(str2);
                    } else {
                        sb.append("L");
                        sb.append(deleteWhitespace);
                        sb.append(";");
                    }
                    return sb.toString();
                }
                return deleteWhitespace;
            }
            throw new NullPointerException("className must not be null.");
        }
        return (String) invokeL.objValue;
    }

    public static Class<?>[] toClass(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, objArr)) == null) {
            if (objArr == null) {
                return null;
            }
            if (objArr.length == 0) {
                return ArrayUtils.EMPTY_CLASS_ARRAY;
            }
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                clsArr[i2] = objArr[i2] == null ? null : objArr[i2].getClass();
            }
            return clsArr;
        }
        return (Class[]) invokeL.objValue;
    }

    public static Class<?> wrapperToPrimitive(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65578, null, cls)) == null) ? wrapperPrimitiveMap.get(cls) : (Class) invokeL.objValue;
    }

    public static Class<?>[] wrappersToPrimitives(Class<?>... clsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, clsArr)) == null) {
            if (clsArr == null) {
                return null;
            }
            if (clsArr.length == 0) {
                return clsArr;
            }
            Class<?>[] clsArr2 = new Class[clsArr.length];
            for (int i2 = 0; i2 < clsArr.length; i2++) {
                clsArr2[i2] = wrapperToPrimitive(clsArr[i2]);
            }
            return clsArr2;
        }
        return (Class[]) invokeL.objValue;
    }

    public static String getAbbreviatedName(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, str, i2)) == null) {
            if (i2 > 0) {
                if (str == null) {
                    return "";
                }
                int countMatches = StringUtils.countMatches((CharSequence) str, '.');
                String[] strArr = new String[countMatches + 1];
                int length = str.length() - 1;
                for (int i3 = countMatches; i3 >= 0; i3--) {
                    int lastIndexOf = str.lastIndexOf(46, length);
                    String substring = str.substring(lastIndexOf + 1, length + 1);
                    i2 -= substring.length();
                    if (i3 > 0) {
                        i2--;
                    }
                    if (i3 == countMatches) {
                        strArr[i3] = substring;
                    } else if (i2 > 0) {
                        strArr[i3] = substring;
                    } else {
                        strArr[i3] = substring.substring(0, 1);
                    }
                    length = lastIndexOf - 1;
                }
                return StringUtils.join((Object[]) strArr, '.');
            }
            throw new IllegalArgumentException("len must be > 0");
        }
        return (String) invokeLI.objValue;
    }

    public static String getPackageCanonicalName(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, cls)) == null) ? cls == null ? "" : getPackageCanonicalName(cls.getName()) : (String) invokeL.objValue;
    }

    public static String getPackageName(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, cls)) == null) ? cls == null ? "" : getPackageName(cls.getName()) : (String) invokeL.objValue;
    }

    public static String getShortCanonicalName(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, cls)) == null) ? cls == null ? "" : getShortCanonicalName(cls.getName()) : (String) invokeL.objValue;
    }

    public static String getShortClassName(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, cls)) == null) ? cls == null ? "" : getShortClassName(cls.getName()) : (String) invokeL.objValue;
    }

    public static String getSimpleName(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, obj, str)) == null) ? obj == null ? str : getSimpleName(obj.getClass()) : (String) invokeLL.objValue;
    }

    public static Iterable<Class<?>> hierarchy(Class<?> cls, Interfaces interfaces) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, cls, interfaces)) == null) {
            Iterable<Class<?>> iterable = new Iterable<Class<?>>(cls) { // from class: org.apache.commons.lang3.ClassUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Class val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {cls};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$type = cls;
                }

                @Override // java.lang.Iterable
                public Iterator<Class<?>> iterator() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new Iterator<Class<?>>(this, new MutableObject(this.val$type)) { // from class: org.apache.commons.lang3.ClassUtils.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$0;
                        public final /* synthetic */ MutableObject val$next;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$next = r7;
                        }

                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            InterceptResult invokeV2;
                            Interceptable interceptable3 = $ic;
                            return (interceptable3 == null || (invokeV2 = interceptable3.invokeV(1048576, this)) == null) ? this.val$next.getValue() != null : invokeV2.booleanValue;
                        }

                        @Override // java.util.Iterator
                        public void remove() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048579, this) == null) {
                                throw new UnsupportedOperationException();
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.Iterator
                        public Class<?> next() {
                            InterceptResult invokeV2;
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || (invokeV2 = interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                Class<?> cls2 = (Class) this.val$next.getValue();
                                this.val$next.setValue(cls2.getSuperclass());
                                return cls2;
                            }
                            return (Class) invokeV2.objValue;
                        }
                    } : (Iterator) invokeV.objValue;
                }
            };
            return interfaces != Interfaces.INCLUDE ? iterable : new Iterable<Class<?>>(iterable) { // from class: org.apache.commons.lang3.ClassUtils.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Iterable val$classes;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iterable};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$classes = iterable;
                }

                @Override // java.lang.Iterable
                public Iterator<Class<?>> iterator() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new Iterator<Class<?>>(this, this.val$classes.iterator(), new HashSet()) { // from class: org.apache.commons.lang3.ClassUtils.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public Iterator<Class<?>> interfaces;
                        public final /* synthetic */ AnonymousClass2 this$0;
                        public final /* synthetic */ Set val$seenInterfaces;
                        public final /* synthetic */ Iterator val$wrapped;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7, r8};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$wrapped = r7;
                            this.val$seenInterfaces = r8;
                            this.interfaces = Collections.emptySet().iterator();
                        }

                        private void walkInterfaces(Set<Class<?>> set, Class<?> cls2) {
                            Class<?>[] interfaces2;
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeLL(65537, this, set, cls2) == null) {
                                for (Class<?> cls3 : cls2.getInterfaces()) {
                                    if (!this.val$seenInterfaces.contains(cls3)) {
                                        set.add(cls3);
                                    }
                                    walkInterfaces(set, cls3);
                                }
                            }
                        }

                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            InterceptResult invokeV2;
                            Interceptable interceptable3 = $ic;
                            return (interceptable3 == null || (invokeV2 = interceptable3.invokeV(1048576, this)) == null) ? this.interfaces.hasNext() || this.val$wrapped.hasNext() : invokeV2.booleanValue;
                        }

                        @Override // java.util.Iterator
                        public void remove() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048579, this) == null) {
                                throw new UnsupportedOperationException();
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.Iterator
                        public Class<?> next() {
                            InterceptResult invokeV2;
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || (invokeV2 = interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                if (this.interfaces.hasNext()) {
                                    Class<?> next = this.interfaces.next();
                                    this.val$seenInterfaces.add(next);
                                    return next;
                                }
                                Class<?> cls2 = (Class) this.val$wrapped.next();
                                LinkedHashSet linkedHashSet = new LinkedHashSet();
                                walkInterfaces(linkedHashSet, cls2);
                                this.interfaces = linkedHashSet.iterator();
                                return cls2;
                            }
                            return (Class) invokeV2.objValue;
                        }
                    } : (Iterator) invokeV.objValue;
                }
            };
        }
        return (Iterable) invokeLL.objValue;
    }

    public static boolean isAssignable(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65570, null, clsArr, clsArr2, z)) == null) {
            if (ArrayUtils.isSameLength(clsArr, clsArr2)) {
                if (clsArr == null) {
                    clsArr = ArrayUtils.EMPTY_CLASS_ARRAY;
                }
                if (clsArr2 == null) {
                    clsArr2 = ArrayUtils.EMPTY_CLASS_ARRAY;
                }
                for (int i2 = 0; i2 < clsArr.length; i2++) {
                    if (!isAssignable(clsArr[i2], clsArr2[i2], z)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static String getPackageCanonicalName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) ? getPackageName(getCanonicalName(str)) : (String) invokeL.objValue;
    }

    public static String getPackageName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            if (StringUtils.isEmpty(str)) {
                return "";
            }
            while (str.charAt(0) == '[') {
                str = str.substring(1);
            }
            if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
                str = str.substring(1);
            }
            int lastIndexOf = str.lastIndexOf(46);
            return lastIndexOf == -1 ? "" : str.substring(0, lastIndexOf);
        }
        return (String) invokeL.objValue;
    }

    public static String getShortCanonicalName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) ? getShortClassName(getCanonicalName(str)) : (String) invokeL.objValue;
    }

    public static String getShortClassName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            if (StringUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            if (str.startsWith(PreferencesUtil.LEFT_MOUNT)) {
                while (str.charAt(0) == '[') {
                    str = str.substring(1);
                    sb.append("[]");
                }
                if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
                    str = str.substring(1, str.length() - 1);
                }
                if (reverseAbbreviationMap.containsKey(str)) {
                    str = reverseAbbreviationMap.get(str);
                }
            }
            int lastIndexOf = str.lastIndexOf(46);
            int indexOf = str.indexOf(36, lastIndexOf != -1 ? lastIndexOf + 1 : 0);
            String substring = str.substring(lastIndexOf + 1);
            if (indexOf != -1) {
                substring = substring.replace('$', '.');
            }
            return substring + ((Object) sb);
        }
        return (String) invokeL.objValue;
    }

    public static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> hashSet) {
        Class<?>[] interfaces;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, cls, hashSet) == null) {
            while (cls != null) {
                for (Class<?> cls2 : cls.getInterfaces()) {
                    if (hashSet.add(cls2)) {
                        getAllInterfaces(cls2, hashSet);
                    }
                }
                cls = cls.getSuperclass();
            }
        }
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, cls, cls2)) == null) ? isAssignable(cls, cls2, SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_5)) : invokeLL.booleanValue;
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65568, null, cls, cls2, z)) == null) {
            if (cls2 == null) {
                return false;
            }
            if (cls == null) {
                return !cls2.isPrimitive();
            }
            if (z) {
                if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = primitiveToWrapper(cls)) == null) {
                    return false;
                }
                if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = wrapperToPrimitive(cls)) == null) {
                    return false;
                }
            }
            if (cls.equals(cls2)) {
                return true;
            }
            if (cls.isPrimitive()) {
                if (cls2.isPrimitive()) {
                    if (Integer.TYPE.equals(cls)) {
                        return Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                    } else if (Long.TYPE.equals(cls)) {
                        return Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                    } else if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
                        return false;
                    } else {
                        if (Float.TYPE.equals(cls)) {
                            return Double.TYPE.equals(cls2);
                        }
                        if (Character.TYPE.equals(cls)) {
                            return Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                        } else if (Short.TYPE.equals(cls)) {
                            return Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                        } else if (Byte.TYPE.equals(cls)) {
                            return Short.TYPE.equals(cls2) || Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                        } else {
                            return false;
                        }
                    }
                }
                return false;
            }
            return cls2.isAssignableFrom(cls);
        }
        return invokeLLZ.booleanValue;
    }

    public static Class<?> getClass(ClassLoader classLoader, String str) throws ClassNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, classLoader, str)) == null) ? getClass(classLoader, str, true) : (Class) invokeLL.objValue;
    }

    public static Class<?> getClass(String str) throws ClassNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? getClass(str, true) : (Class) invokeL.objValue;
    }

    public static Class<?> getClass(String str, boolean z) throws ClassNotFoundException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65549, null, str, z)) == null) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = ClassUtils.class.getClassLoader();
            }
            return getClass(contextClassLoader, str, z);
        }
        return (Class) invokeLZ.objValue;
    }
}
