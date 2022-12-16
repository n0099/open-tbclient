package com.kwad.components.core.l;

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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile boolean IA = false;
    public static volatile Set<c> IB = null;
    public static volatile b Ix = null;
    public static volatile int Iy = 204800;
    public static volatile boolean Iz = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1273811193, "Lcom/kwad/components/core/l/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1273811193, "Lcom/kwad/components/core/l/b;");
                return;
            }
        }
        IB = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
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

    public static synchronized void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cVar) == null) {
            synchronized (b.class) {
                if (IB.contains(cVar)) {
                    IB.remove(cVar);
                }
            }
        }
    }

    public static void e(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (i > 0) {
                Iy = i * 1024;
            }
            Iz = z;
        }
    }

    public static boolean ln() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Iz : invokeV.booleanValue;
    }

    public static int lo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? Iy / 1024 : invokeV.intValue;
    }

    public static b or() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (Ix == null) {
                synchronized (b.class) {
                    if (Ix == null) {
                        Ix = new b();
                    }
                }
            }
            return Ix;
        }
        return (b) invokeV.objValue;
    }

    public static synchronized InputStream wrap(@NonNull InputStream inputStream) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, inputStream)) == null) {
            synchronized (b.class) {
                cVar = new c(inputStream, Iy / (IB.size() + 1));
                IB.add(cVar);
            }
            return cVar;
        }
        return (InputStream) invokeL.objValue;
    }

    public static InputStream wrapInputStream(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, inputStream)) == null) ? wrap(inputStream) : (InputStream) invokeL.objValue;
    }

    public final synchronized int lp() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                i = 0;
                try {
                    for (c cVar : IB) {
                        i += (int) cVar.os();
                    }
                } catch (Exception unused) {
                }
            }
            return i;
        }
        return invokeV.intValue;
    }
}
