package d.a.s.d.d;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.bridge.multiprocess.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s.d.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes8.dex */
public class b extends d.a.s.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public volatile g f67755g;

    /* renamed from: h  reason: collision with root package name */
    public volatile d.a.s.d.c.a f67756h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f67757i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile Future<Boolean> l;
    public volatile Future<Boolean> m;
    public volatile boolean n;
    public String o;
    public Object p;
    public Object q;

    /* loaded from: classes8.dex */
    public class a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f67758e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67758e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f67758e.f67756h = new d.a.s.d.c.a();
                this.f67758e.f67756h.b(this.f67758e.f67715e);
                this.f67758e.f67756h.c(this.f67758e.f67716f);
                this.f67758e.j = true;
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* renamed from: d.a.s.d.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class CallableC1896b implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f67759e;

        public CallableC1896b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67759e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b bVar = this.f67759e;
                bVar.f67755g = new g(bVar, bVar.o);
                this.f67759e.f67755g.b(this.f67759e.f67715e);
                this.f67759e.f67755g.c(this.f67759e.f67716f);
                this.f67759e.k = true;
                if (this.f67759e.f67755g.n()) {
                    this.f67759e.n = true;
                    return Boolean.TRUE;
                }
                this.f67759e.n = false;
                this.f67759e.f67757i = false;
                this.f67759e.p();
                return Boolean.FALSE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new Object();
        this.q = new Object();
        this.f67757i = true;
        this.j = false;
        this.o = str;
    }

    @Override // d.a.s.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            if (this.f67757i) {
                s();
                if (this.n) {
                    this.f67755g.a(str, bundle, cVar);
                    return;
                }
            }
            m();
            this.f67756h.a(str, bundle, cVar);
        }
    }

    @Override // d.a.s.d.a
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f67757i) {
                s();
                if (this.n) {
                    return this.f67755g.d(str);
                }
            }
            m();
            return this.f67756h.d(str);
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.s.d.a
    public void e(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            if (this.f67757i) {
                synchronized (this.p) {
                    v();
                }
                return;
            }
            synchronized (this.q) {
                p();
            }
        }
    }

    @Override // d.a.s.d.a
    public a.d f(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bundle)) == null) {
            if (this.f67757i) {
                s();
                if (this.n) {
                    a.d f2 = this.f67755g.f(str, bundle);
                    if (f2.b()) {
                        return f2;
                    }
                    this.f67757i = false;
                }
            }
            m();
            return this.f67756h.f(str, bundle);
        }
        return (a.d) invokeLL.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f67757i = false;
            p();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f67757i || this.j) {
            return;
        }
        synchronized (this.q) {
            p();
        }
        try {
            this.m.get();
        } catch (Exception unused) {
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !this.j && this.m == null) {
            this.m = this.f67715e.f67720d.submit(new a(this));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f67757i) {
            if (!this.k) {
                synchronized (this.p) {
                    v();
                }
            }
            try {
                this.l.get();
            } catch (Exception unused) {
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !this.k && this.l == null) {
            this.l = this.f67715e.f67720d.submit(new CallableC1896b(this));
        }
    }
}
