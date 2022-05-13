package com.repackage;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.te1;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class ye1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ye1 f;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicBoolean a;
    public AtomicBoolean b;
    public AtomicBoolean c;
    public AtomicBoolean d;
    public HashMap<Integer, te1.a> e;

    public ye1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.e = new HashMap<>();
    }

    public static ye1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f == null) {
                synchronized (ye1.class) {
                    if (f == null) {
                        f = new ye1();
                    }
                }
            }
            return f;
        }
        return (ye1) invokeV.objValue;
    }

    public synchronized int a(te1.a aVar) {
        InterceptResult invokeL;
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            synchronized (this) {
                currentTimeMillis = (int) System.currentTimeMillis();
                this.e.put(Integer.valueOf(currentTimeMillis), aVar);
            }
            return currentTimeMillis;
        }
        return invokeL.intValue;
    }

    public synchronized Pair<Boolean, te1.a> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            synchronized (this) {
                if (!this.e.containsKey(Integer.valueOf(i))) {
                    return new Pair<>(Boolean.FALSE, null);
                }
                if1.a().b(i);
                this.e.remove(Integer.valueOf(i));
                return new Pair<>(Boolean.TRUE, this.e.get(Integer.valueOf(i)));
            }
        }
        return (Pair) invokeI.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.a.set(z);
        }
    }

    public boolean e(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.a.compareAndSet(z, z2) : invokeCommon.booleanValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.b.set(z);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b.get() : invokeV.booleanValue;
    }

    public synchronized boolean h(int i) {
        InterceptResult invokeI;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            synchronized (this) {
                containsKey = this.e.containsKey(Integer.valueOf(i));
            }
            return containsKey;
        }
        return invokeI.booleanValue;
    }

    public boolean i(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.b.compareAndSet(z, z2) : invokeCommon.booleanValue;
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.c.set(z);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c.get() : invokeV.booleanValue;
    }

    public synchronized boolean l(int i) {
        InterceptResult invokeI;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            synchronized (this) {
                containsKey = this.e.containsKey(Integer.valueOf(i));
            }
            return containsKey;
        }
        return invokeI.booleanValue;
    }

    public boolean m(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.c.compareAndSet(z, z2) : invokeCommon.booleanValue;
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.d.set(z);
        }
    }

    public boolean o(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.d.compareAndSet(z, z2) : invokeCommon.booleanValue;
    }
}
