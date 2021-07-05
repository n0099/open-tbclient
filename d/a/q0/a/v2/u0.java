package d.a.q0.a.v2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.AnyThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u0 implements d.a.q0.a.v2.e1.b<Exception> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f51411i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f51412e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f51413f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f51414g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f51415h;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f51416e;

        /* renamed from: d.a.q0.a.v2.u0$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1007a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f51417e;

            public RunnableC1007a(a aVar) {
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
                this.f51417e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (u0.f51411i) {
                        Log.d("SwanH2HeartBeatManager", "do updateCore, isStop=" + this.f51417e.f51416e.f51415h);
                    }
                    if (this.f51417e.f51416e.f51415h) {
                        return;
                    }
                    this.f51417e.f51416e.i();
                }
            }
        }

        public a(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51416e = u0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ProcessUtils.isMainProcess()) {
                    this.f51416e.f51415h = false;
                    synchronized (u0.class) {
                        this.f51416e.f51412e = System.currentTimeMillis();
                        if (this.f51416e.f51414g != null) {
                            this.f51416e.f51413f.removeCallbacks(this.f51416e.f51414g);
                        }
                        this.f51416e.f51414g = new RunnableC1007a(this);
                        long a2 = d.a.q0.n.j.i.l.a(300) * 1000;
                        this.f51416e.f51413f.postDelayed(this.f51416e.f51414g, a2);
                        if (u0.f51411i) {
                            Log.d("SwanH2HeartBeatManager", "wait next heart beat: " + a2);
                        }
                    }
                    return;
                }
                d.a.q0.a.v1.b.d.b(c.class, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f51418e;

        public b(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51418e = u0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.n.b.j(new d.a.q0.n.i.m.h(0), new d.a.q0.a.h0.m.i(this.f51418e, true));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                u0.j().l();
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final u0 f51419a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(810546790, "Ld/a/q0/a/v2/u0$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(810546790, "Ld/a/q0/a/v2/u0$d;");
                    return;
                }
            }
            f51419a = new u0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-267312666, "Ld/a/q0/a/v2/u0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-267312666, "Ld/a/q0/a/v2/u0;");
                return;
            }
        }
        f51411i = d.a.q0.a.k.f49133a;
    }

    public /* synthetic */ u0(a aVar) {
        this();
    }

    public static u0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? d.f51419a : (u0) invokeV.objValue;
    }

    @AnyThread
    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q.k(new b(this), "SwanH2HeartBeatManager");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.v2.e1.b
    /* renamed from: k */
    public void onCallback(Exception exc) {
        d.a.q0.n.h.a pmsError;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            this.f51414g = null;
            if (f51411i) {
                Log.w("SwanH2HeartBeatManager", "onCallback", exc);
            }
            if (exc != null) {
                Throwable cause = exc.getCause();
                if ((cause instanceof PMSException) && (pmsError = ((PMSException) cause).getPmsError()) != null && pmsError.f53931d >= 500) {
                    m();
                    d.a.q0.n.j.i.l.f54080a = false;
                    d.a.q0.a.e0.d.h("SwanH2HeartBeatManager", "update core heartBeat exception: code=" + pmsError.f53931d);
                    return;
                }
                l();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && d.a.q0.n.j.i.l.f54080a) {
            if (f51411i) {
                Log.d("SwanH2HeartBeatManager", "startHeartBeat");
            }
            q.k(new a(this), "SwanH2HeartBeatManager");
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && d.a.q0.n.j.i.l.f54080a) {
            if (f51411i) {
                Log.d("SwanH2HeartBeatManager", "stopHeartBeat");
            }
            this.f51415h = true;
            Runnable runnable = this.f51414g;
            if (runnable != null) {
                this.f51413f.removeCallbacks(runnable);
            }
            this.f51414g = null;
        }
    }

    public u0() {
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
        this.f51415h = false;
        this.f51413f = new Handler(Looper.getMainLooper());
    }
}
