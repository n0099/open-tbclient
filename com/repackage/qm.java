package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
public class qm {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Object a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            return c(obj, obj.getClass(), "dexElements");
        }
        return invokeL.objValue;
    }

    public static DexFile b(ClassLoader classLoader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, classLoader)) == null) {
            if (classLoader == null) {
                return null;
            }
            boolean z = true;
            try {
                Class.forName("dalvik.system.BaseDexClassLoader");
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            try {
                if (!z) {
                    Object c = c(classLoader, DexClassLoader.class, "mDexs");
                    if (c == null) {
                        return null;
                    }
                    return (DexFile) Array.get(c, 0);
                }
                Object a = a(d(classLoader));
                if (a == null) {
                    return null;
                }
                return (DexFile) c(Array.get(a, 0), Class.forName("dalvik.system.DexPathList$Element"), "dexFile");
            } catch (Exception unused2) {
                return null;
            }
        }
        return (DexFile) invokeL.objValue;
    }

    public static Object c(Object obj, Class<?> cls, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, obj, cls, str)) == null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (NoSuchFieldException | SecurityException | Exception unused) {
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    public static Object d(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            try {
                return c(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
            } catch (ClassNotFoundException | Exception unused) {
                return null;
            }
        }
        return invokeL.objValue;
    }
}
