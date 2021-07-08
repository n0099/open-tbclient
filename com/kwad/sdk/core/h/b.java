package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f34610a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f34611b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Set<c> f34612c = null;

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f34613d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f34614e = 204800;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1890071317, "Lcom/kwad/sdk/core/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1890071317, "Lcom/kwad/sdk/core/h/b;");
                return;
            }
        }
        f34612c = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    }

    public b() {
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

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f34613d == null) {
                synchronized (b.class) {
                    if (f34613d == null) {
                        f34613d = new b();
                    }
                }
            }
            return f34613d;
        }
        return (b) invokeV.objValue;
    }

    public static synchronized InputStream a(@NonNull InputStream inputStream) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, inputStream)) == null) {
            synchronized (b.class) {
                cVar = new c(inputStream, f34614e / (f34612c.size() + 1));
                f34612c.add(cVar);
            }
            return cVar;
        }
        return (InputStream) invokeL.objValue;
    }

    public static synchronized void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar) == null) {
            synchronized (b.class) {
                if (f34612c.contains(cVar)) {
                    f34612c.remove(cVar);
                }
            }
        }
    }

    public void a(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (i2 > 0) {
                f34614e = i2 * 1024;
            }
            f34610a = z;
        }
    }

    public InputStream b(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream)) == null) ? a(inputStream) : (InputStream) invokeL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f34610a : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f34614e / 1024 : invokeV.intValue;
    }

    public synchronized int d() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                i2 = 0;
                for (c cVar : f34612c) {
                    i2 += (int) cVar.a();
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }
}
