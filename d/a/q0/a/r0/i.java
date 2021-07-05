package d.a.q0.a.r0;

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
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50328c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile i f50329d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<h> f50330a;

    /* renamed from: b  reason: collision with root package name */
    public g f50331b;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Semaphore f50332e;

        public a(i iVar, Semaphore semaphore) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, semaphore};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50332e = semaphore;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50332e.release();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(126170314, "Ld/a/q0/a/r0/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(126170314, "Ld/a/q0/a/r0/i;");
                return;
            }
        }
        f50328c = d.a.q0.a.k.f49133a;
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50330a = new ArrayList<>();
        this.f50331b = new g();
    }

    public static i d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f50329d == null) {
                synchronized (i.class) {
                    if (f50329d == null) {
                        f50329d = new i();
                    }
                }
            }
            return f50329d;
        }
        return (i) invokeV.objValue;
    }

    public static synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (i.class) {
                if (f50329d != null) {
                    f50329d.f();
                    f50329d = null;
                }
            }
        }
    }

    public final void a(@NonNull h hVar, @NonNull ArrayList<h> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hVar, arrayList) == null) {
            if (f50328c) {
                Log.i("FileSystemTaskManager", "addToWaitList: " + hVar + "," + arrayList.size() + "," + this.f50330a.size());
            }
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                next.i();
                hVar.a(next);
            }
            this.f50330a.add(hVar);
        }
    }

    public final h b(@NonNull Semaphore semaphore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, semaphore)) == null) ? new h(this, new a(this, semaphore), "JS_WAKE_UP_TASK", null) : (h) invokeL.objValue;
    }

    public final synchronized boolean c(Semaphore semaphore, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, semaphore, strArr)) == null) {
            synchronized (this) {
                ArrayList<h> c2 = this.f50331b.c(strArr);
                if (c2 != null && c2.size() != 0) {
                    a(b(semaphore), c2);
                    return true;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean e(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hVar)) == null) ? hVar != null && "JS_WAKE_UP_TASK".equals(hVar.c()) : invokeL.booleanValue;
    }

    public final synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.f50331b.b();
                Iterator<h> it = this.f50330a.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (e(next)) {
                        next.h();
                    }
                }
                this.f50330a.clear();
            }
        }
    }

    public synchronized void g(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            synchronized (this) {
                if (hVar == null) {
                    return;
                }
                this.f50331b.d(hVar, hVar.b());
                if (hVar.e()) {
                    if (f50328c) {
                        Log.i("FileSystemTaskManager", "onTaskComplete: " + hVar + "," + this.f50330a.size());
                    }
                    for (int size = this.f50330a.size() - 1; size >= 0; size--) {
                        h hVar2 = this.f50330a.get(size);
                        hVar2.g(hVar);
                        if (hVar2.d()) {
                            this.f50330a.remove(size);
                            hVar2.f();
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
                h hVar = new h(this, runnable, str, strArr);
                ArrayList<h> c2 = this.f50331b.c(strArr);
                this.f50331b.a(hVar, strArr);
                if (c2 != null && c2.size() != 0) {
                    a(hVar, c2);
                }
                hVar.f();
            }
        }
    }

    public final void j(Semaphore semaphore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, semaphore) == null) {
            try {
                semaphore.tryAcquire(10L, TimeUnit.SECONDS);
            } catch (Exception e2) {
                if (f50328c) {
                    Log.e("FileSystemTaskManager", "semaphore.acquire: " + e2);
                }
            }
        }
    }

    public void k(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strArr) == null) {
            Semaphore semaphore = new Semaphore(0);
            if (c(semaphore, strArr)) {
                if (f50328c) {
                    Log.i("FileSystemTaskManager", "waitIfHasPathDependence: " + Arrays.toString(strArr));
                }
                j(semaphore);
            }
        }
    }
}
