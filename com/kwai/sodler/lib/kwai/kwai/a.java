package com.kwai.sodler.lib.kwai.kwai;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public final class a extends PathClassLoader {
    public static /* synthetic */ Interceptable $ic;
    public static a axB;
    public static List axC;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseDexClassLoader axA;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1293346433, "Lcom/kwai/sodler/lib/kwai/kwai/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1293346433, "Lcom/kwai/sodler/lib/kwai/kwai/a;");
                return;
            }
        }
        axC = new CopyOnWriteArrayList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BaseDexClassLoader baseDexClassLoader) {
        super("", baseDexClassLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseDexClassLoader};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (ClassLoader) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.axA = baseDexClassLoader;
    }

    public static void a(BaseDexClassLoader baseDexClassLoader) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, baseDexClassLoader) == null) && axB == null) {
            axB = new a(baseDexClassLoader);
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final Class findClass(String str) {
        InterceptResult invokeL;
        Class<?> loadClass;
        Class<?> loadClass2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Class<?> cls = null;
            try {
                loadClass2 = this.axA.loadClass(str);
            } catch (Throwable th) {
                th = th;
            }
            if (Activity.class.isAssignableFrom(loadClass2)) {
                return loadClass2;
            }
            th = null;
            cls = loadClass2;
            if (cls == null) {
                for (ClassLoader classLoader : axC) {
                    try {
                        loadClass = classLoader.loadClass(str);
                    } catch (Throwable unused) {
                    }
                    if (loadClass != null) {
                        return loadClass;
                    }
                }
                if (th instanceof ClassNotFoundException) {
                    throw th;
                }
                throw new ClassNotFoundException(str, th);
            }
            return cls;
        }
        return (Class) invokeL.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.axA.findLibrary(str) : (String) invokeL.objValue;
    }

    @Override // java.lang.ClassLoader
    public final URL getResource(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.axA.getResource(str) : (URL) invokeL.objValue;
    }

    @Override // java.lang.ClassLoader
    public final InputStream getResourceAsStream(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.axA.getResourceAsStream(str) : (InputStream) invokeL.objValue;
    }

    @Override // java.lang.ClassLoader
    public final Enumeration getResources(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.axA.getResources(str) : (Enumeration) invokeL.objValue;
    }

    @Override // java.lang.ClassLoader
    public final Class loadClass(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? findClass(str) : (Class) invokeL.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader
    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.axA.toString() : (String) invokeV.objValue;
    }
}
