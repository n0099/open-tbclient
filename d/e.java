package d;

import androidx.core.view.InputDeviceCompat;
import bolts.ExecutorException;
import bolts.UnobservedTaskException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class e<TResult> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final Executor f71599i;
    public static volatile f j;
    public static e<?> k;
    public static e<Boolean> l;
    public static e<Boolean> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Object f71600a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f71601b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f71602c;

    /* renamed from: d  reason: collision with root package name */
    public TResult f71603d;

    /* renamed from: e  reason: collision with root package name */
    public Exception f71604e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f71605f;

    /* renamed from: g  reason: collision with root package name */
    public g f71606g;

    /* renamed from: h  reason: collision with root package name */
    public List<d.d<TResult, Void>> f71607h;

    /* loaded from: classes2.dex */
    public class a implements d.d<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.f f71608a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.d f71609b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f71610c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.c f71611d;

        public a(e eVar, d.f fVar, d.d dVar, Executor executor, d.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, fVar, dVar, executor, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71608a = fVar;
            this.f71609b = dVar;
            this.f71610c = executor;
            this.f71611d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                e.d(this.f71608a, this.f71609b, eVar, this.f71610c, this.f71611d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.d<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.f f71612a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.d f71613b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f71614c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.c f71615d;

        public b(e eVar, d.f fVar, d.d dVar, Executor executor, d.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, fVar, dVar, executor, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71612a = fVar;
            this.f71613b = dVar;
            this.f71614c = executor;
            this.f71615d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                e.c(this.f71612a, this.f71613b, eVar, this.f71614c, this.f71615d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f71616e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.f f71617f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.d f71618g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f71619h;

        public c(d.c cVar, d.f fVar, d.d dVar, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar, dVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71616e = cVar;
            this.f71617f = fVar;
            this.f71618g = dVar;
            this.f71619h = eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: d.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.c cVar = this.f71616e;
                if (cVar != null && cVar.a()) {
                    this.f71617f.b();
                    return;
                }
                try {
                    this.f71617f.setResult(this.f71618g.then(this.f71619h));
                } catch (CancellationException unused) {
                    this.f71617f.b();
                } catch (Exception e2) {
                    this.f71617f.c(e2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f71620e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.f f71621f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.d f71622g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f71623h;

        /* loaded from: classes2.dex */
        public class a implements d.d<TContinuationResult, Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f71624a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71624a = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: d.f */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // d.d
            /* renamed from: a */
            public Void then(e<TContinuationResult> eVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                    d.c cVar = this.f71624a.f71620e;
                    if (cVar != null && cVar.a()) {
                        this.f71624a.f71621f.b();
                        return null;
                    }
                    if (eVar.n()) {
                        this.f71624a.f71621f.b();
                    } else if (eVar.p()) {
                        this.f71624a.f71621f.c(eVar.k());
                    } else {
                        this.f71624a.f71621f.setResult(eVar.l());
                    }
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }

        public d(d.c cVar, d.f fVar, d.d dVar, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar, dVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71620e = cVar;
            this.f71621f = fVar;
            this.f71622g = dVar;
            this.f71623h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.c cVar = this.f71620e;
                if (cVar != null && cVar.a()) {
                    this.f71621f.b();
                    return;
                }
                try {
                    e eVar = (e) this.f71622g.then(this.f71623h);
                    if (eVar == null) {
                        this.f71621f.setResult(null);
                    } else {
                        eVar.e(new a(this));
                    }
                } catch (CancellationException unused) {
                    this.f71621f.b();
                } catch (Exception e2) {
                    this.f71621f.c(e2);
                }
            }
        }
    }

    /* renamed from: d.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC2040e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f71625e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.f f71626f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Callable f71627g;

        public RunnableC2040e(d.c cVar, d.f fVar, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar, callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71625e = cVar;
            this.f71626f = fVar;
            this.f71627g = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: d.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.c cVar = this.f71625e;
                if (cVar != null && cVar.a()) {
                    this.f71626f.b();
                    return;
                }
                try {
                    this.f71626f.setResult(this.f71627g.call());
                } catch (CancellationException unused) {
                    this.f71626f.b();
                } catch (Exception e2) {
                    this.f71626f.c(e2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(e<?> eVar, UnobservedTaskException unobservedTaskException);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(73215053, "Ld/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(73215053, "Ld/e;");
                return;
            }
        }
        d.b.a();
        f71599i = d.b.b();
        d.a.c();
        k = new e<>((Object) null);
        l = new e<>(Boolean.TRUE);
        m = new e<>(Boolean.FALSE);
        new e(true);
    }

    public e() {
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
        this.f71600a = new Object();
        this.f71607h = new ArrayList();
    }

    public static <TContinuationResult, TResult> void c(d.f<TContinuationResult> fVar, d.d<TResult, e<TContinuationResult>> dVar, e<TResult> eVar, Executor executor, d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(AdIconUtil.BAIDU_LOGO_ID, null, fVar, dVar, eVar, executor, cVar) == null) {
            try {
                executor.execute(new d(cVar, fVar, dVar, eVar));
            } catch (Exception e2) {
                fVar.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> e<TResult> call(Callable<TResult> callable, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, callable, executor)) == null) ? call(callable, executor, null) : (e) invokeLL.objValue;
    }

    public static <TContinuationResult, TResult> void d(d.f<TContinuationResult> fVar, d.d<TResult, TContinuationResult> dVar, e<TResult> eVar, Executor executor, d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65547, null, fVar, dVar, eVar, executor, cVar) == null) {
            try {
                executor.execute(new c(cVar, fVar, dVar, eVar));
            } catch (Exception e2) {
                fVar.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> e<TResult> i(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, exc)) == null) {
            d.f fVar = new d.f();
            fVar.c(exc);
            return fVar.a();
        }
        return (e) invokeL.objValue;
    }

    public static <TResult> e<TResult> j(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, tresult)) == null) {
            if (tresult == null) {
                return (e<TResult>) k;
            }
            if (tresult instanceof Boolean) {
                return ((Boolean) tresult).booleanValue() ? (e<TResult>) l : (e<TResult>) m;
            }
            d.f fVar = new d.f();
            fVar.setResult(tresult);
            return fVar.a();
        }
        return (e) invokeL.objValue;
    }

    public static f m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? j : (f) invokeV.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> e(d.d<TResult, TContinuationResult> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? f(dVar, f71599i, null) : (e) invokeL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> f(d.d<TResult, TContinuationResult> dVar, Executor executor, d.c cVar) {
        InterceptResult invokeLLL;
        boolean o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, executor, cVar)) == null) {
            d.f fVar = new d.f();
            synchronized (this.f71600a) {
                o = o();
                if (!o) {
                    this.f71607h.add(new a(this, fVar, dVar, executor, cVar));
                }
            }
            if (o) {
                d(fVar, dVar, this, executor, cVar);
            }
            return fVar.a();
        }
        return (e) invokeLLL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> g(d.d<TResult, e<TContinuationResult>> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) ? h(dVar, f71599i, null) : (e) invokeL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> h(d.d<TResult, e<TContinuationResult>> dVar, Executor executor, d.c cVar) {
        InterceptResult invokeLLL;
        boolean o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, dVar, executor, cVar)) == null) {
            d.f fVar = new d.f();
            synchronized (this.f71600a) {
                o = o();
                if (!o) {
                    this.f71607h.add(new b(this, fVar, dVar, executor, cVar));
                }
            }
            if (o) {
                c(fVar, dVar, this, executor, cVar);
            }
            return fVar.a();
        }
        return (e) invokeLLL.objValue;
    }

    public Exception k() {
        InterceptResult invokeV;
        Exception exc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this.f71600a) {
                if (this.f71604e != null) {
                    this.f71605f = true;
                    if (this.f71606g != null) {
                        this.f71606g.a();
                        this.f71606g = null;
                    }
                }
                exc = this.f71604e;
            }
            return exc;
        }
        return (Exception) invokeV.objValue;
    }

    public TResult l() {
        InterceptResult invokeV;
        TResult tresult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this.f71600a) {
                tresult = this.f71603d;
            }
            return tresult;
        }
        return (TResult) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.f71600a) {
                z = this.f71602c;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.f71600a) {
                z = this.f71601b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this.f71600a) {
                z = k() != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.f71600a) {
                for (d.d<TResult, Void> dVar : this.f71607h) {
                    try {
                        dVar.then(this);
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception e3) {
                        throw new RuntimeException(e3);
                    }
                }
                this.f71607h = null;
            }
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this.f71600a) {
                if (this.f71601b) {
                    return false;
                }
                this.f71601b = true;
                this.f71602c = true;
                this.f71600a.notifyAll();
                q();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean s(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, exc)) == null) {
            synchronized (this.f71600a) {
                if (this.f71601b) {
                    return false;
                }
                this.f71601b = true;
                this.f71604e = exc;
                this.f71605f = false;
                this.f71600a.notifyAll();
                q();
                if (!this.f71605f && m() != null) {
                    this.f71606g = new g(this);
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean t(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, tresult)) == null) {
            synchronized (this.f71600a) {
                if (this.f71601b) {
                    return false;
                }
                this.f71601b = true;
                this.f71603d = tresult;
                this.f71600a.notifyAll();
                q();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static <TResult> e<TResult> call(Callable<TResult> callable, Executor executor, d.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, callable, executor, cVar)) == null) {
            d.f fVar = new d.f();
            try {
                executor.execute(new RunnableC2040e(cVar, fVar, callable));
            } catch (Exception e2) {
                fVar.c(new ExecutorException(e2));
            }
            return fVar.a();
        }
        return (e) invokeLLL.objValue;
    }

    public e(TResult tresult) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tresult};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f71600a = new Object();
        this.f71607h = new ArrayList();
        t(tresult);
    }

    public static <TResult> e<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, callable)) == null) ? call(callable, f71599i, null) : (e) invokeL.objValue;
    }

    public static <TResult> e<TResult> call(Callable<TResult> callable, d.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, callable, cVar)) == null) ? call(callable, f71599i, cVar) : (e) invokeLL.objValue;
    }

    public e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f71600a = new Object();
        this.f71607h = new ArrayList();
        if (z) {
            r();
        } else {
            t(null);
        }
    }
}
