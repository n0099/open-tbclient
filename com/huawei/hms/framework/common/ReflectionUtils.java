package com.huawei.hms.framework.common;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes10.dex */
public class ReflectionUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ReflectionUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public ReflectionUtils() {
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

    public static boolean checkCompatible(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                tryLoadClass(str);
                return true;
            } catch (Exception unused) {
                Logger.w("ReflectionUtils", str + "ClassNotFoundException");
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static Class<?> getClass(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
        return (Class) invokeL.objValue;
    }

    public static void tryLoadClass(String str) throws ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            ClassLoader classLoader = ReflectionUtils.class.getClassLoader();
            if (classLoader != null) {
                classLoader.loadClass(str);
                return;
            }
            throw new ClassNotFoundException("not found classloader");
        }
    }

    public static boolean checkCompatible(String str, String str2, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, clsArr)) == null) {
            try {
                if (str != null && str2 != null) {
                    Class.forName(str).getDeclaredMethod(str2, clsArr);
                    Logger.v("ReflectionUtils", "has method : " + str2);
                    return true;
                }
                Logger.w("ReflectionUtils", "targetClass is  null or name is null:");
                return false;
            } catch (RuntimeException unused) {
                Logger.w("ReflectionUtils", str + " RuntimeException");
                return false;
            } catch (Exception unused2) {
                Logger.w("ReflectionUtils", str2 + " NoSuchMethodException");
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static void setClassType(Class<?>[] clsArr, Object obj, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65547, null, clsArr, obj, i) == null) {
            if (obj instanceof Integer) {
                clsArr[i] = Integer.TYPE;
            } else if (obj instanceof Long) {
                clsArr[i] = Long.TYPE;
            } else if (obj instanceof Double) {
                clsArr[i] = Double.TYPE;
            } else if (obj instanceof Float) {
                clsArr[i] = Float.TYPE;
            } else if (obj instanceof Boolean) {
                clsArr[i] = Boolean.TYPE;
            } else if (obj instanceof Character) {
                clsArr[i] = Character.TYPE;
            } else if (obj instanceof Byte) {
                clsArr[i] = Byte.TYPE;
            } else if (obj instanceof Void) {
                clsArr[i] = Void.TYPE;
            } else if (obj instanceof Short) {
                clsArr[i] = Short.TYPE;
            } else {
                clsArr[i] = obj.getClass();
            }
        }
    }

    public static Field getField(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str)) == null) {
            if (obj != null && !TextUtils.isEmpty(str)) {
                try {
                    Field declaredField = obj.getClass().getDeclaredField(str);
                    AccessController.doPrivileged(new PrivilegedAction(declaredField) { // from class: com.huawei.hms.framework.common.ReflectionUtils.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Field val$field;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {declaredField};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$field = declaredField;
                        }

                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                                this.val$field.setAccessible(true);
                                return null;
                            }
                            return invokeV.objValue;
                        }
                    });
                    return declaredField;
                } catch (IllegalArgumentException e) {
                    Logger.e("ReflectionUtils", "Exception in getField :: IllegalArgumentException:", e);
                } catch (NoSuchFieldException e2) {
                    Logger.e("ReflectionUtils", "Exception in getField :: NoSuchFieldException:", e2);
                } catch (SecurityException e3) {
                    Logger.e("ReflectionUtils", "not security int method getField,SecurityException:", e3);
                }
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }

    public static Object getFieldObj(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, obj, str)) == null) {
            if (obj == null || TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                Field declaredField = obj.getClass().getDeclaredField(str);
                AccessController.doPrivileged(new PrivilegedAction(declaredField) { // from class: com.huawei.hms.framework.common.ReflectionUtils.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Field val$field;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {declaredField};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$field = declaredField;
                    }

                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            this.val$field.setAccessible(true);
                            return null;
                        }
                        return invokeV.objValue;
                    }
                });
                return declaredField.get(obj);
            } catch (IllegalAccessException e) {
                Logger.e("ReflectionUtils", "Exception in getFieldObj :: IllegalAccessException:", e);
                return null;
            } catch (IllegalArgumentException e2) {
                Logger.e("ReflectionUtils", "Exception in getFieldObj :: IllegalArgumentException:", e2);
                return null;
            } catch (NoSuchFieldException e3) {
                Logger.e("ReflectionUtils", "Exception in getFieldObj :: NoSuchFieldException:", e3);
                return null;
            } catch (SecurityException e4) {
                Logger.e("ReflectionUtils", "not security int method getFieldObj,SecurityException:", e4);
                return null;
            }
        }
        return invokeLL.objValue;
    }

    public static Object getStaticFieldObj(String str, String str2) {
        InterceptResult invokeLL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            if (str == null || (cls = getClass(str)) == null || TextUtils.isEmpty(str2)) {
                return null;
            }
            try {
                Field declaredField = cls.getDeclaredField(str2);
                AccessController.doPrivileged(new PrivilegedAction(declaredField) { // from class: com.huawei.hms.framework.common.ReflectionUtils.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Field val$field;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {declaredField};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$field = declaredField;
                    }

                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            this.val$field.setAccessible(true);
                            return null;
                        }
                        return invokeV.objValue;
                    }
                });
                return declaredField.get(cls);
            } catch (IllegalAccessException e) {
                Logger.e("ReflectionUtils", "Exception in getFieldObj :: IllegalAccessException:", e);
                return null;
            } catch (IllegalArgumentException e2) {
                Logger.e("ReflectionUtils", "Exception in getFieldObj :: IllegalArgumentException:", e2);
                return null;
            } catch (NoSuchFieldException e3) {
                Logger.e("ReflectionUtils", "Exception in getFieldObj :: NoSuchFieldException:", e3);
                return null;
            } catch (SecurityException e4) {
                Logger.e("ReflectionUtils", "not security int method getStaticFieldObj,SecurityException:", e4);
                return null;
            }
        }
        return invokeLL.objValue;
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, cls, str, clsArr)) == null) {
            if (cls != null && str != null) {
                try {
                    return cls.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException e) {
                    Logger.e("ReflectionUtils", "NoSuchMethodException:", e);
                    return null;
                } catch (SecurityException e2) {
                    Logger.e("ReflectionUtils", "SecurityException:", e2);
                    return null;
                }
            }
            Logger.w("ReflectionUtils", "targetClass is  null pr name is null:");
            return null;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Object invokeStaticMethod(String str, String str2, Object... objArr) {
        InterceptResult invokeLLL;
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, str, str2, objArr)) == null) {
            if (str == null) {
                return null;
            }
            if (objArr != null) {
                int length = objArr.length;
                clsArr = new Class[length];
                for (int i = 0; i < length; i++) {
                    setClassType(clsArr, objArr[i], i);
                }
            } else {
                clsArr = null;
            }
            Method method = getMethod(getClass(str), str2, clsArr);
            if (method == null) {
                return null;
            }
            return invoke(null, method, objArr);
        }
        return invokeLLL.objValue;
    }

    public static Object invoke(Object obj, Method method, Object... objArr) throws UnsupportedOperationException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, obj, method, objArr)) == null) {
            if (method == null) {
                return null;
            }
            try {
                return method.invoke(obj, objArr);
            } catch (RuntimeException e) {
                Logger.e("ReflectionUtils", "RuntimeException in invoke:", e);
                return null;
            } catch (Exception e2) {
                Logger.e("ReflectionUtils", "Exception in invoke:", e2);
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    public static Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, str, str2, clsArr, objArr)) == null) {
            Method method = getMethod(getClass(str), str2, clsArr);
            if (method == null) {
                return null;
            }
            return invoke(null, method, objArr);
        }
        return invokeLLLL.objValue;
    }
}
