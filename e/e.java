package e;

import androidx.core.view.InputDeviceCompat;
import bolts.ExecutorException;
import bolts.UnobservedTaskException;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes4.dex */
public class e<TResult> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final Executor f61632i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile f f61633j;
    public static e<?> k;
    public static e<Boolean> l;
    public static e<Boolean> m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61634b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61635c;

    /* renamed from: d  reason: collision with root package name */
    public TResult f61636d;

    /* renamed from: e  reason: collision with root package name */
    public Exception f61637e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61638f;

    /* renamed from: g  reason: collision with root package name */
    public g f61639g;

    /* renamed from: h  reason: collision with root package name */
    public List<e.d<TResult, Void>> f61640h;

    /* loaded from: classes4.dex */
    public class a implements e.d<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e.d f61641b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f61642c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.c f61643d;

        public a(e eVar, e.f fVar, e.d dVar, Executor executor, e.c cVar) {
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
            this.a = fVar;
            this.f61641b = dVar;
            this.f61642c = executor;
            this.f61643d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // e.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                e.d(this.a, this.f61641b, eVar, this.f61642c, this.f61643d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements e.d<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e.d f61644b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f61645c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.c f61646d;

        public b(e eVar, e.f fVar, e.d dVar, Executor executor, e.c cVar) {
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
            this.a = fVar;
            this.f61644b = dVar;
            this.f61645c = executor;
            this.f61646d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // e.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                e.c(this.a, this.f61644b, eVar, this.f61645c, this.f61646d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f61647e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.f f61648f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e.d f61649g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f61650h;

        public c(e.c cVar, e.f fVar, e.d dVar, e eVar) {
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
            this.f61647e = cVar;
            this.f61648f = fVar;
            this.f61649g = dVar;
            this.f61650h = eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: e.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.c cVar = this.f61647e;
                if (cVar != null && cVar.a()) {
                    this.f61648f.b();
                    return;
                }
                try {
                    this.f61648f.setResult(this.f61649g.then(this.f61650h));
                } catch (CancellationException unused) {
                    this.f61648f.b();
                } catch (Exception e2) {
                    this.f61648f.c(e2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f61651e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.f f61652f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e.d f61653g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f61654h;

        /* loaded from: classes4.dex */
        public class a implements e.d<TContinuationResult, Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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
                this.a = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: e.f */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // e.d
            /* renamed from: a */
            public Void then(e<TContinuationResult> eVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                    e.c cVar = this.a.f61651e;
                    if (cVar != null && cVar.a()) {
                        this.a.f61652f.b();
                        return null;
                    }
                    if (eVar.n()) {
                        this.a.f61652f.b();
                    } else if (eVar.p()) {
                        this.a.f61652f.c(eVar.k());
                    } else {
                        this.a.f61652f.setResult(eVar.l());
                    }
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }

        public d(e.c cVar, e.f fVar, e.d dVar, e eVar) {
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
            this.f61651e = cVar;
            this.f61652f = fVar;
            this.f61653g = dVar;
            this.f61654h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.c cVar = this.f61651e;
                if (cVar != null && cVar.a()) {
                    this.f61652f.b();
                    return;
                }
                try {
                    e eVar = (e) this.f61653g.then(this.f61654h);
                    if (eVar == null) {
                        this.f61652f.setResult(null);
                    } else {
                        eVar.e(new a(this));
                    }
                } catch (CancellationException unused) {
                    this.f61652f.b();
                } catch (Exception e2) {
                    this.f61652f.c(e2);
                }
            }
        }
    }

    /* renamed from: e.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class RunnableC2275e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f61655e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.f f61656f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Callable f61657g;

        public RunnableC2275e(e.c cVar, e.f fVar, Callable callable) {
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
            this.f61655e = cVar;
            this.f61656f = fVar;
            this.f61657g = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: e.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.c cVar = this.f61655e;
                if (cVar != null && cVar.a()) {
                    this.f61656f.b();
                    return;
                }
                try {
                    this.f61656f.setResult(this.f61657g.call());
                } catch (CancellationException unused) {
                    this.f61656f.b();
                } catch (Exception e2) {
                    this.f61656f.c(e2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(e<?> eVar, UnobservedTaskException unobservedTaskException);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(73244844, "Le/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(73244844, "Le/e;");
                return;
            }
        }
        e.b.a();
        f61632i = e.b.b();
        e.a.c();
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
        this.a = new Object();
        this.f61640h = new ArrayList();
    }

    public static <TContinuationResult, TResult> void c(e.f<TContinuationResult> fVar, e.d<TResult, e<TContinuationResult>> dVar, e<TResult> eVar, Executor executor, e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, fVar, dVar, eVar, executor, cVar) == null) {
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

    public static <TContinuationResult, TResult> void d(e.f<TContinuationResult> fVar, e.d<TResult, TContinuationResult> dVar, e<TResult> eVar, Executor executor, e.c cVar) {
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
            e.f fVar = new e.f();
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
            e.f fVar = new e.f();
            fVar.setResult(tresult);
            return fVar.a();
        }
        return (e) invokeL.objValue;
    }

    public static f m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? f61633j : (f) invokeV.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> e(e.d<TResult, TContinuationResult> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? f(dVar, f61632i, null) : (e) invokeL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> f(e.d<TResult, TContinuationResult> dVar, Executor executor, e.c cVar) {
        InterceptResult invokeLLL;
        boolean o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, executor, cVar)) == null) {
            e.f fVar = new e.f();
            synchronized (this.a) {
                o = o();
                if (!o) {
                    this.f61640h.add(new a(this, fVar, dVar, executor, cVar));
                }
            }
            if (o) {
                d(fVar, dVar, this, executor, cVar);
            }
            return fVar.a();
        }
        return (e) invokeLLL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> g(e.d<TResult, e<TContinuationResult>> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) ? h(dVar, f61632i, null) : (e) invokeL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> h(e.d<TResult, e<TContinuationResult>> dVar, Executor executor, e.c cVar) {
        InterceptResult invokeLLL;
        boolean o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, dVar, executor, cVar)) == null) {
            e.f fVar = new e.f();
            synchronized (this.a) {
                o = o();
                if (!o) {
                    this.f61640h.add(new b(this, fVar, dVar, executor, cVar));
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
            synchronized (this.a) {
                if (this.f61637e != null) {
                    this.f61638f = true;
                    if (this.f61639g != null) {
                        this.f61639g.a();
                        this.f61639g = null;
                    }
                }
                exc = this.f61637e;
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
            synchronized (this.a) {
                tresult = this.f61636d;
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
            synchronized (this.a) {
                z = this.f61635c;
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
            synchronized (this.a) {
                z = this.f61634b;
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
            synchronized (this.a) {
                z = k() != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.a) {
                for (e.d<TResult, Void> dVar : this.f61640h) {
                    try {
                        dVar.then(this);
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception e3) {
                        throw new RuntimeException(e3);
                    }
                }
                this.f61640h = null;
            }
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this.a) {
                if (this.f61634b) {
                    return false;
                }
                this.f61634b = true;
                this.f61635c = true;
                this.a.notifyAll();
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
            synchronized (this.a) {
                if (this.f61634b) {
                    return false;
                }
                this.f61634b = true;
                this.f61637e = exc;
                this.f61638f = false;
                this.a.notifyAll();
                q();
                if (!this.f61638f && m() != null) {
                    this.f61639g = new g(this);
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
            synchronized (this.a) {
                if (this.f61634b) {
                    return false;
                }
                this.f61634b = true;
                this.f61636d = tresult;
                this.a.notifyAll();
                q();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static <TResult> e<TResult> call(Callable<TResult> callable, Executor executor, e.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, callable, executor, cVar)) == null) {
            e.f fVar = new e.f();
            try {
                executor.execute(new RunnableC2275e(cVar, fVar, callable));
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
        this.a = new Object();
        this.f61640h = new ArrayList();
        t(tresult);
    }

    public static <TResult> e<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, callable)) == null) ? call(callable, f61632i, null) : (e) invokeL.objValue;
    }

    public static <TResult> e<TResult> call(Callable<TResult> callable, e.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, callable, cVar)) == null) ? call(callable, f61632i, cVar) : (e) invokeLL.objValue;
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
        this.a = new Object();
        this.f61640h = new ArrayList();
        if (z) {
            r();
        } else {
            t(null);
        }
    }
}
