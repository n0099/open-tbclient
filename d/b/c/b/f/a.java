package d.b.c.b.f;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.b.c.b.i;
import d.b.c.b.k;
import d.b.c.b.l;
import d.b.c.b.m;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/* loaded from: classes8.dex */
public class a implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static a f68955i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f68956e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<Thread.UncaughtExceptionHandler> f68957f;

    /* renamed from: g  reason: collision with root package name */
    public b f68958g;

    /* renamed from: h  reason: collision with root package name */
    public long f68959h;

    /* renamed from: d.b.c.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1964a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68960e;

        public C1964a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68960e = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            super.run();
            try {
                while (true) {
                    SystemClock.sleep(Math.abs(new Random().nextLong()) % 5000);
                    this.f68960e.g();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68957f = new HashSet<>();
        this.f68959h = -1L;
        g();
        e();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f68955i == null) {
                f68955i = new a();
            }
            return f68955i;
        }
        return (a) invokeV.objValue;
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f68958g = bVar;
        }
    }

    public final boolean d(Thread thread, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thread, th)) == null) {
            k g2 = m.c().g();
            if (g2 != null) {
                try {
                    return g2.a(th, thread);
                } catch (Throwable unused) {
                    return true;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                new C1964a(this).start();
            } catch (Throwable unused) {
            }
        }
    }

    public final void f(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, thread, th) == null) {
            List<i> e2 = m.c().e();
            com.bytedance.tea.crash.c cVar = com.bytedance.tea.crash.c.f32379b;
            for (i iVar : e2) {
                try {
                    iVar.a(cVar, l.n.a(th), thread);
                } catch (Throwable th2) {
                    l.k.c(th2);
                }
            }
        }
    }

    public final void g() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) == this) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        if (this.f68956e == null) {
            this.f68956e = defaultUncaughtExceptionHandler;
        } else {
            this.f68957f.add(defaultUncaughtExceptionHandler);
        }
    }

    public final void h(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, thread, th) == null) {
            try {
                Iterator<Thread.UncaughtExceptionHandler> it = this.f68957f.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().uncaughtException(thread, th);
                    } catch (Throwable unused) {
                    }
                }
                this.f68956e.uncaughtException(thread, th);
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, thread, th) == null) || SystemClock.uptimeMillis() - this.f68959h < 20000) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f68959h = SystemClock.uptimeMillis();
            d2 = d(thread, th);
        } finally {
            try {
            } finally {
            }
        }
        if (d2) {
            com.bytedance.tea.crash.c cVar = com.bytedance.tea.crash.c.f32379b;
            f(thread, th);
            if (d2 && this.f68958g != null && this.f68958g.a(th)) {
                this.f68958g.a(currentTimeMillis, thread, th);
                Log.i("crash_dispatcher", "end dispose " + th);
            }
        }
    }
}
