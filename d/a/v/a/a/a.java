package d.a.v.a.a;

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
    public static volatile a f68293f;

    /* renamed from: g  reason: collision with root package name */
    public static int f68294g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f68295a;

    /* renamed from: b  reason: collision with root package name */
    public int f68296b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.v.a.d.a f68297c;

    /* renamed from: d  reason: collision with root package name */
    public ScheduledExecutorService f68298d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Integer, d.a.v.a.a.c> f68299e;

    /* renamed from: d.a.v.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1922a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68300e;

        public RunnableC1922a(a aVar) {
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
            this.f68300e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68300e.f68297c.b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d.a.v.a.a.c f68301e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f68302f;

        public b(a aVar, d.a.v.a.a.c cVar) {
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
            this.f68302f = aVar;
            this.f68301e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68302f.f68297c.j(this.f68301e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d.a.v.a.a.c f68303e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f68304f;

        public c(a aVar, d.a.v.a.a.c cVar) {
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
            this.f68304f = aVar;
            this.f68303e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68304f.f68297c.e(this.f68303e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(788815828, "Ld/a/v/a/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(788815828, "Ld/a/v/a/a/a;");
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
        this.f68299e = new ConcurrentHashMap<>();
        this.f68295a = context;
        this.f68296b = g.g(context, "flow_handle", f68294g);
        this.f68297c = d.a.v.a.d.a.i(this.f68295a);
        this.f68298d = Executors.newSingleThreadScheduledExecutor();
    }

    public static a h(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f68293f == null) {
                synchronized (a.class) {
                    if (f68293f == null) {
                        f68293f = new a(context);
                    }
                }
            }
            return f68293f;
        }
        return (a) invokeL.objValue;
    }

    public synchronized d.a.v.a.a.c b(int i2) {
        InterceptResult invokeI;
        d.a.v.a.a.c d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            synchronized (this) {
                d2 = d(i2);
            }
            return d2;
        }
        return (d.a.v.a.a.c) invokeI.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f68298d.execute(new RunnableC1922a(this));
        }
    }

    public final d.a.v.a.a.c d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (!this.f68299e.containsKey(Integer.valueOf(i2))) {
                this.f68296b++;
                d.a.v.a.h.e.a("BehaviorProcess", "FlowHandle:" + this.f68296b);
                d.a.v.a.a.c cVar = new d.a.v.a.a.c(this.f68295a, i2, this.f68296b);
                this.f68299e.put(Integer.valueOf(i2), cVar);
                this.f68298d.execute(new b(this, cVar));
                g.l(this.f68295a, "flow_handle", this.f68296b);
                return cVar;
            }
            return this.f68299e.get(Integer.valueOf(i2));
        }
        return (d.a.v.a.a.c) invokeI.objValue;
    }

    public synchronized void e(d.a.v.a.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            synchronized (this) {
                if (this.f68299e.containsKey(Integer.valueOf(cVar.f68306a))) {
                    this.f68299e.remove(Integer.valueOf(cVar.f68306a));
                    d.a.v.a.h.e.a("BehaviorProcess", "flow endFlow");
                    this.f68298d.execute(new c(this, cVar));
                }
            }
        }
    }

    public ScheduledExecutorService f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68298d : (ScheduledExecutorService) invokeV.objValue;
    }

    public synchronized d.a.v.a.a.c g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            synchronized (this) {
                if (this.f68299e.containsKey(Integer.valueOf(i2))) {
                    return this.f68299e.get(Integer.valueOf(i2));
                }
                return new d.a.v.a.a.b(this.f68295a, i2, f68294g);
            }
        }
        return (d.a.v.a.a.c) invokeI.objValue;
    }
}
