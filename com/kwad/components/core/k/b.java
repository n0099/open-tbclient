package com.kwad.components.core.k;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile boolean a = true;
    public static volatile boolean b = false;
    public static volatile Set<c> c = null;
    public static volatile b d = null;
    public static volatile int e = 204800;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1273781402, "Lcom/kwad/components/core/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1273781402, "Lcom/kwad/components/core/k/b;");
                return;
            }
        }
        c = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (b.class) {
                    if (d == null) {
                        d = new b();
                    }
                }
            }
            return d;
        }
        return (b) invokeV.objValue;
    }

    public static InputStream a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, inputStream)) == null) ? b(inputStream) : (InputStream) invokeL.objValue;
    }

    public static synchronized void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar) == null) {
            synchronized (b.class) {
                if (c.contains(cVar)) {
                    c.remove(cVar);
                }
            }
        }
    }

    public static void a(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (i > 0) {
                e = i * 1024;
            }
            a = z;
        }
    }

    public static synchronized InputStream b(@NonNull InputStream inputStream) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, inputStream)) == null) {
            synchronized (b.class) {
                cVar = new c(inputStream, e / (c.size() + 1));
                c.add(cVar);
            }
            return cVar;
        }
        return (InputStream) invokeL.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a : invokeV.booleanValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? e / 1024 : invokeV.intValue;
    }

    public final synchronized int d() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                i = 0;
                try {
                    for (c cVar : c) {
                        i += (int) cVar.a();
                    }
                } catch (Exception unused) {
                }
            }
            return i;
        }
        return invokeV.intValue;
    }
}
