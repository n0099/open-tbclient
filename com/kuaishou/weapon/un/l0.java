package com.kuaishou.weapon.un;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
public class l0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l0() {
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

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            if (systemClassLoader != null) {
                try {
                    systemClassLoader.loadClass(str).newInstance();
                } catch (ClassNotFoundException unused) {
                    return false;
                } catch (IllegalAccessException unused2) {
                    return true;
                } catch (InstantiationException e) {
                    x0.a(e);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return Modifier.isNative(Throwable.class.getDeclaredMethod("getStackTrace", new Class[0]).getModifiers());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return System.getProperty("vxp");
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                String str = System.getenv("CLASSPATH");
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return str.contains("XposedBridge");
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? a(m0.c) : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                throw new Exception("");
            } catch (Exception e) {
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    if (stackTraceElement.getClassName().contains(m0.b)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            if (systemClassLoader != null) {
                try {
                    systemClassLoader.loadClass(m0.a).newInstance();
                } catch (ClassNotFoundException unused) {
                    return false;
                } catch (IllegalAccessException unused2) {
                    return true;
                } catch (InstantiationException e) {
                    x0.a(e);
                    return true;
                }
            }
            if (systemClassLoader != null) {
                try {
                    systemClassLoader.loadClass(m0.b).newInstance();
                } catch (ClassNotFoundException e2) {
                    x0.a(e2);
                    return false;
                } catch (IllegalAccessException e3) {
                    x0.a(e3);
                    return true;
                } catch (InstantiationException e4) {
                    x0.a(e4);
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                Field declaredField = ClassLoader.getSystemClassLoader().loadClass(m0.b).getDeclaredField("disableHooks");
                declaredField.setAccessible(true);
                declaredField.set(null, Boolean.TRUE);
                return true;
            } catch (ClassNotFoundException e) {
                x0.a(e);
                return false;
            } catch (IllegalAccessException e2) {
                x0.a(e2);
                return false;
            } catch (NoSuchFieldException e3) {
                x0.a(e3);
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
