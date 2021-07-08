package d.a.u.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f67615f;

    /* renamed from: g  reason: collision with root package name */
    public static int f67616g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f67617a;

    /* renamed from: b  reason: collision with root package name */
    public int f67618b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.u.a.d.a f67619c;

    /* renamed from: d  reason: collision with root package name */
    public ScheduledExecutorService f67620d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Integer, d.a.u.a.a.c> f67621e;

    /* renamed from: d.a.u.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1917a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f67622e;

        public RunnableC1917a(a aVar) {
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
            this.f67622e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67622e.f67619c.b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d.a.u.a.a.c f67623e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f67624f;

        public b(a aVar, d.a.u.a.a.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67624f = aVar;
            this.f67623e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67624f.f67619c.j(this.f67623e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d.a.u.a.a.c f67625e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f67626f;

        public c(a aVar, d.a.u.a.a.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67626f = aVar;
            this.f67625e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67626f.f67619c.e(this.f67625e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-953994507, "Ld/a/u/a/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-953994507, "Ld/a/u/a/a/a;");
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f67621e = new ConcurrentHashMap<>();
        this.f67617a = context;
        this.f67618b = g.g(context, "flow_handle", f67616g);
        this.f67619c = d.a.u.a.d.a.i(this.f67617a);
        this.f67620d = Executors.newSingleThreadScheduledExecutor();
    }

    public static a h(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f67615f == null) {
                synchronized (a.class) {
                    if (f67615f == null) {
                        f67615f = new a(context);
                    }
                }
            }
            return f67615f;
        }
        return (a) invokeL.objValue;
    }

    public synchronized d.a.u.a.a.c b(int i2) {
        InterceptResult invokeI;
        d.a.u.a.a.c d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            synchronized (this) {
                d2 = d(i2);
            }
            return d2;
        }
        return (d.a.u.a.a.c) invokeI.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f67620d.execute(new RunnableC1917a(this));
        }
    }

    public final d.a.u.a.a.c d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (!this.f67621e.containsKey(Integer.valueOf(i2))) {
                this.f67618b++;
                d.a.u.a.h.e.a("BehaviorProcess", "FlowHandle:" + this.f67618b);
                d.a.u.a.a.c cVar = new d.a.u.a.a.c(this.f67617a, i2, this.f67618b);
                this.f67621e.put(Integer.valueOf(i2), cVar);
                this.f67620d.execute(new b(this, cVar));
                g.l(this.f67617a, "flow_handle", this.f67618b);
                return cVar;
            }
            return this.f67621e.get(Integer.valueOf(i2));
        }
        return (d.a.u.a.a.c) invokeI.objValue;
    }

    public synchronized void e(d.a.u.a.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            synchronized (this) {
                if (this.f67621e.containsKey(Integer.valueOf(cVar.f67628a))) {
                    this.f67621e.remove(Integer.valueOf(cVar.f67628a));
                    d.a.u.a.h.e.a("BehaviorProcess", "flow endFlow");
                    this.f67620d.execute(new c(this, cVar));
                }
            }
        }
    }

    public ScheduledExecutorService f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f67620d : (ScheduledExecutorService) invokeV.objValue;
    }

    public synchronized d.a.u.a.a.c g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            synchronized (this) {
                if (this.f67621e.containsKey(Integer.valueOf(i2))) {
                    return this.f67621e.get(Integer.valueOf(i2));
                }
                return new d.a.u.a.a.b(this.f67617a, i2, f67616g);
            }
        }
        return (d.a.u.a.a.c) invokeI.objValue;
    }
}
