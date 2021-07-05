package d.a.w.a.a;

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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f70722f;

    /* renamed from: g  reason: collision with root package name */
    public static int f70723g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f70724a;

    /* renamed from: b  reason: collision with root package name */
    public int f70725b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.w.a.d.a f70726c;

    /* renamed from: d  reason: collision with root package name */
    public ScheduledExecutorService f70727d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Integer, d.a.w.a.a.c> f70728e;

    /* renamed from: d.a.w.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1954a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f70729e;

        public RunnableC1954a(a aVar) {
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
            this.f70729e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70729e.f70726c.b();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d.a.w.a.a.c f70730e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f70731f;

        public b(a aVar, d.a.w.a.a.c cVar) {
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
            this.f70731f = aVar;
            this.f70730e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70731f.f70726c.j(this.f70730e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d.a.w.a.a.c f70732e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f70733f;

        public c(a aVar, d.a.w.a.a.c cVar) {
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
            this.f70733f = aVar;
            this.f70732e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70733f.f70726c.e(this.f70732e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1763341133, "Ld/a/w/a/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1763341133, "Ld/a/w/a/a/a;");
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
        this.f70728e = new ConcurrentHashMap<>();
        this.f70724a = context;
        this.f70725b = g.g(context, "flow_handle", f70723g);
        this.f70726c = d.a.w.a.d.a.i(this.f70724a);
        this.f70727d = Executors.newSingleThreadScheduledExecutor();
    }

    public static a h(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f70722f == null) {
                synchronized (a.class) {
                    if (f70722f == null) {
                        f70722f = new a(context);
                    }
                }
            }
            return f70722f;
        }
        return (a) invokeL.objValue;
    }

    public synchronized d.a.w.a.a.c b(int i2) {
        InterceptResult invokeI;
        d.a.w.a.a.c d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            synchronized (this) {
                d2 = d(i2);
            }
            return d2;
        }
        return (d.a.w.a.a.c) invokeI.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f70727d.execute(new RunnableC1954a(this));
        }
    }

    public final d.a.w.a.a.c d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (!this.f70728e.containsKey(Integer.valueOf(i2))) {
                this.f70725b++;
                d.a.w.a.h.e.a("BehaviorProcess", "FlowHandle:" + this.f70725b);
                d.a.w.a.a.c cVar = new d.a.w.a.a.c(this.f70724a, i2, this.f70725b);
                this.f70728e.put(Integer.valueOf(i2), cVar);
                this.f70727d.execute(new b(this, cVar));
                g.l(this.f70724a, "flow_handle", this.f70725b);
                return cVar;
            }
            return this.f70728e.get(Integer.valueOf(i2));
        }
        return (d.a.w.a.a.c) invokeI.objValue;
    }

    public synchronized void e(d.a.w.a.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            synchronized (this) {
                if (this.f70728e.containsKey(Integer.valueOf(cVar.f70735a))) {
                    this.f70728e.remove(Integer.valueOf(cVar.f70735a));
                    d.a.w.a.h.e.a("BehaviorProcess", "flow endFlow");
                    this.f70727d.execute(new c(this, cVar));
                }
            }
        }
    }

    public ScheduledExecutorService f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f70727d : (ScheduledExecutorService) invokeV.objValue;
    }

    public synchronized d.a.w.a.a.c g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            synchronized (this) {
                if (this.f70728e.containsKey(Integer.valueOf(i2))) {
                    return this.f70728e.get(Integer.valueOf(i2));
                }
                return new d.a.w.a.a.b(this.f70724a, i2, f70723g);
            }
        }
        return (d.a.w.a.a.c) invokeI.objValue;
    }
}
