package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* renamed from: com.kuaishou.weapon.p0.ᐧᐧ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0436 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0436() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m909(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            if (systemClassLoader != null) {
                try {
                    systemClassLoader.loadClass(str).newInstance();
                } catch (ClassNotFoundException unused) {
                    return false;
                } catch (IllegalAccessException | InstantiationException unused2) {
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m910() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return Modifier.isNative(Throwable.class.getDeclaredMethod("getStackTrace", new Class[0]).getModifiers());
            } catch (NoSuchMethodException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m911() {
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

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m912() {
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

    /* renamed from: ʾ  reason: contains not printable characters */
    public boolean m913() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? m909(C0438.f616) : invokeV.booleanValue;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public boolean m914() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                throw new Exception("");
            } catch (Exception e) {
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    if (stackTraceElement.getClassName().contains(C0438.f615)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* renamed from: ˆ  reason: contains not printable characters */
    public boolean m915() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            if (systemClassLoader != null) {
                try {
                    systemClassLoader.loadClass(C0438.f614).newInstance();
                } catch (ClassNotFoundException unused) {
                    return false;
                } catch (IllegalAccessException | InstantiationException unused2) {
                    return true;
                }
            }
            if (systemClassLoader != null) {
                try {
                    systemClassLoader.loadClass(C0438.f615).newInstance();
                } catch (ClassNotFoundException unused3) {
                    return false;
                } catch (IllegalAccessException | InstantiationException unused4) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public boolean m916() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                Field declaredField = ClassLoader.getSystemClassLoader().loadClass(C0438.f615).getDeclaredField("disableHooks");
                declaredField.setAccessible(true);
                declaredField.set(null, Boolean.TRUE);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
