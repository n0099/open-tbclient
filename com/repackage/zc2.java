package com.repackage;

import android.util.Log;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class zc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static volatile zc2 d;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<yc2> a;
    public xc2 b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Semaphore a;

        public a(zc2 zc2Var, Semaphore semaphore) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zc2Var, semaphore};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = semaphore;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.release();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755116888, "Lcom/repackage/zc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755116888, "Lcom/repackage/zc2;");
                return;
            }
        }
        c = eh1.a;
    }

    public zc2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.b = new xc2();
    }

    public static zc2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (zc2.class) {
                    if (d == null) {
                        d = new zc2();
                    }
                }
            }
            return d;
        }
        return (zc2) invokeV.objValue;
    }

    public static synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (zc2.class) {
                if (d != null) {
                    d.f();
                    d = null;
                }
            }
        }
    }

    public final void a(@NonNull yc2 yc2Var, @NonNull ArrayList<yc2> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, yc2Var, arrayList) == null) {
            if (c) {
                Log.i("FileSystemTaskManager", "addToWaitList: " + yc2Var + "," + arrayList.size() + "," + this.a.size());
            }
            Iterator<yc2> it = arrayList.iterator();
            while (it.hasNext()) {
                yc2 next = it.next();
                next.i();
                yc2Var.a(next);
            }
            this.a.add(yc2Var);
        }
    }

    public final yc2 b(@NonNull Semaphore semaphore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, semaphore)) == null) ? new yc2(this, new a(this, semaphore), "JS_WAKE_UP_TASK", null) : (yc2) invokeL.objValue;
    }

    public final synchronized boolean c(Semaphore semaphore, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, semaphore, strArr)) == null) {
            synchronized (this) {
                ArrayList<yc2> c2 = this.b.c(strArr);
                if (c2 != null && c2.size() != 0) {
                    a(b(semaphore), c2);
                    return true;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean e(yc2 yc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, yc2Var)) == null) ? yc2Var != null && "JS_WAKE_UP_TASK".equals(yc2Var.c()) : invokeL.booleanValue;
    }

    public final synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.b.b();
                Iterator<yc2> it = this.a.iterator();
                while (it.hasNext()) {
                    yc2 next = it.next();
                    if (e(next)) {
                        next.h();
                    }
                }
                this.a.clear();
            }
        }
    }

    public synchronized void g(yc2 yc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yc2Var) == null) {
            synchronized (this) {
                if (yc2Var == null) {
                    return;
                }
                this.b.d(yc2Var, yc2Var.b());
                if (yc2Var.e()) {
                    if (c) {
                        Log.i("FileSystemTaskManager", "onTaskComplete: " + yc2Var + "," + this.a.size());
                    }
                    for (int size = this.a.size() - 1; size >= 0; size--) {
                        yc2 yc2Var2 = this.a.get(size);
                        yc2Var2.g(yc2Var);
                        if (yc2Var2.d()) {
                            this.a.remove(size);
                            yc2Var2.f();
                        }
                    }
                }
            }
        }
    }

    public synchronized void h(@NonNull Runnable runnable, String str, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, runnable, str, strArr) == null) {
            synchronized (this) {
                yc2 yc2Var = new yc2(this, runnable, str, strArr);
                ArrayList<yc2> c2 = this.b.c(strArr);
                this.b.a(yc2Var, strArr);
                if (c2 != null && c2.size() != 0) {
                    a(yc2Var, c2);
                }
                yc2Var.f();
            }
        }
    }

    public final void j(Semaphore semaphore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, semaphore) == null) {
            try {
                semaphore.tryAcquire(10L, TimeUnit.SECONDS);
            } catch (Exception e) {
                if (c) {
                    Log.e("FileSystemTaskManager", "semaphore.acquire: " + e);
                }
            }
        }
    }

    public void k(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strArr) == null) {
            Semaphore semaphore = new Semaphore(0);
            if (c(semaphore, strArr)) {
                if (c) {
                    Log.i("FileSystemTaskManager", "waitIfHasPathDependence: " + Arrays.toString(strArr));
                }
                j(semaphore);
            }
        }
    }
}
