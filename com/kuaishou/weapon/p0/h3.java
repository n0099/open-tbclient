package com.kuaishou.weapon.p0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes10.dex */
public class h3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Object a(Class<?> cls, Object obj, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, cls, obj, str)) == null) {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        }
        return invokeLLL.objValue;
    }

    public static Object a(Class<?> cls, Object obj, String str, Object... objArr) {
        InterceptResult invokeLLLL;
        Class<?>[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, cls, obj, str, objArr)) == null) {
            if (objArr != null) {
                clsArr = new Class[objArr.length];
                for (int i = 0; i < objArr.length; i++) {
                    clsArr[i] = objArr[i].getClass();
                }
            } else {
                clsArr = null;
            }
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        }
        return invokeLLLL.objValue;
    }

    public static Object a(String str, Object obj, String str2, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, obj, str2, objArr)) == null) ? a(Class.forName(str), obj, str2, objArr) : invokeLLLL.objValue;
    }

    public static Object a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) ? a(Class.forName(str), (Object) null, str2) : invokeLL.objValue;
    }

    public static Method a(Class cls, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Class<?>[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, cls, str, objArr)) == null) {
            if (objArr != null) {
                try {
                    clsArr = new Class[objArr.length];
                    for (int i = 0; i < objArr.length; i++) {
                        clsArr[i] = objArr[i].getClass();
                    }
                } catch (Exception unused) {
                    return null;
                }
            } else {
                clsArr = null;
            }
            return cls.getDeclaredMethod(str, clsArr);
        }
        return (Method) invokeLLL.objValue;
    }
}
