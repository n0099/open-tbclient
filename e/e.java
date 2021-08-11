package e;

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
/* loaded from: classes10.dex */
public class e<TResult> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final Executor f77951i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile f f77952j;
    public static e<?> k;
    public static e<Boolean> l;
    public static e<Boolean> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Object f77953a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f77954b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f77955c;

    /* renamed from: d  reason: collision with root package name */
    public TResult f77956d;

    /* renamed from: e  reason: collision with root package name */
    public Exception f77957e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f77958f;

    /* renamed from: g  reason: collision with root package name */
    public g f77959g;

    /* renamed from: h  reason: collision with root package name */
    public List<e.d<TResult, Void>> f77960h;

    /* loaded from: classes10.dex */
    public class a implements e.d<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e.f f77961a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e.d f77962b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f77963c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.c f77964d;

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
            this.f77961a = fVar;
            this.f77962b = dVar;
            this.f77963c = executor;
            this.f77964d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // e.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                e.f(this.f77961a, this.f77962b, eVar, this.f77963c, this.f77964d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b implements e.d<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e.f f77965a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e.d f77966b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f77967c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.c f77968d;

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
            this.f77965a = fVar;
            this.f77966b = dVar;
            this.f77967c = executor;
            this.f77968d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // e.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                e.e(this.f77965a, this.f77966b, eVar, this.f77967c, this.f77968d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f77969e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.f f77970f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e.d f77971g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f77972h;

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
            this.f77969e = cVar;
            this.f77970f = fVar;
            this.f77971g = dVar;
            this.f77972h = eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: e.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.c cVar = this.f77969e;
                if (cVar != null && cVar.a()) {
                    this.f77970f.b();
                    return;
                }
                try {
                    this.f77970f.d(this.f77971g.then(this.f77972h));
                } catch (CancellationException unused) {
                    this.f77970f.b();
                } catch (Exception e2) {
                    this.f77970f.c(e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f77973e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.f f77974f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e.d f77975g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f77976h;

        /* loaded from: classes10.dex */
        public class a implements e.d<TContinuationResult, Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f77977a;

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
                this.f77977a = dVar;
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
                    e.c cVar = this.f77977a.f77973e;
                    if (cVar != null && cVar.a()) {
                        this.f77977a.f77974f.b();
                        return null;
                    }
                    if (eVar.p()) {
                        this.f77977a.f77974f.b();
                    } else if (eVar.r()) {
                        this.f77977a.f77974f.c(eVar.m());
                    } else {
                        this.f77977a.f77974f.d(eVar.n());
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
            this.f77973e = cVar;
            this.f77974f = fVar;
            this.f77975g = dVar;
            this.f77976h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.c cVar = this.f77973e;
                if (cVar != null && cVar.a()) {
                    this.f77974f.b();
                    return;
                }
                try {
                    e eVar = (e) this.f77975g.then(this.f77976h);
                    if (eVar == null) {
                        this.f77974f.d(null);
                    } else {
                        eVar.g(new a(this));
                    }
                } catch (CancellationException unused) {
                    this.f77974f.b();
                } catch (Exception e2) {
                    this.f77974f.c(e2);
                }
            }
        }
    }

    /* renamed from: e.e$e  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class RunnableC2103e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f77978e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.f f77979f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Callable f77980g;

        public RunnableC2103e(e.c cVar, e.f fVar, Callable callable) {
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
            this.f77978e = cVar;
            this.f77979f = fVar;
            this.f77980g = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: e.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.c cVar = this.f77978e;
                if (cVar != null && cVar.a()) {
                    this.f77979f.b();
                    return;
                }
                try {
                    this.f77979f.d(this.f77980g.call());
                } catch (CancellationException unused) {
                    this.f77979f.b();
                } catch (Exception e2) {
                    this.f77979f.c(e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
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
        f77951i = e.b.b();
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
        this.f77953a = new Object();
        this.f77960h = new ArrayList();
    }

    public static <TResult> e<TResult> c(Callable<TResult> callable, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, callable, executor)) == null) ? d(callable, executor, null) : (e) invokeLL.objValue;
    }

    public static <TResult> e<TResult> d(Callable<TResult> callable, Executor executor, e.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, callable, executor, cVar)) == null) {
            e.f fVar = new e.f();
            try {
                executor.execute(new RunnableC2103e(cVar, fVar, callable));
            } catch (Exception e2) {
                fVar.c(new ExecutorException(e2));
            }
            return fVar.a();
        }
        return (e) invokeLLL.objValue;
    }

    public static <TContinuationResult, TResult> void e(e.f<TContinuationResult> fVar, e.d<TResult, e<TContinuationResult>> dVar, e<TResult> eVar, Executor executor, e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65544, null, fVar, dVar, eVar, executor, cVar) == null) {
            try {
                executor.execute(new d(cVar, fVar, dVar, eVar));
            } catch (Exception e2) {
                fVar.c(new ExecutorException(e2));
            }
        }
    }

    public static <TContinuationResult, TResult> void f(e.f<TContinuationResult> fVar, e.d<TResult, TContinuationResult> dVar, e<TResult> eVar, Executor executor, e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65545, null, fVar, dVar, eVar, executor, cVar) == null) {
            try {
                executor.execute(new c(cVar, fVar, dVar, eVar));
            } catch (Exception e2) {
                fVar.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> e<TResult> k(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, exc)) == null) {
            e.f fVar = new e.f();
            fVar.c(exc);
            return fVar.a();
        }
        return (e) invokeL.objValue;
    }

    public static <TResult> e<TResult> l(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tresult)) == null) {
            if (tresult == null) {
                return (e<TResult>) k;
            }
            if (tresult instanceof Boolean) {
                return ((Boolean) tresult).booleanValue() ? (e<TResult>) l : (e<TResult>) m;
            }
            e.f fVar = new e.f();
            fVar.d(tresult);
            return fVar.a();
        }
        return (e) invokeL.objValue;
    }

    public static f o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f77952j : (f) invokeV.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> g(e.d<TResult, TContinuationResult> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? h(dVar, f77951i, null) : (e) invokeL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> h(e.d<TResult, TContinuationResult> dVar, Executor executor, e.c cVar) {
        InterceptResult invokeLLL;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, executor, cVar)) == null) {
            e.f fVar = new e.f();
            synchronized (this.f77953a) {
                q = q();
                if (!q) {
                    this.f77960h.add(new a(this, fVar, dVar, executor, cVar));
                }
            }
            if (q) {
                f(fVar, dVar, this, executor, cVar);
            }
            return fVar.a();
        }
        return (e) invokeLLL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> i(e.d<TResult, e<TContinuationResult>> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) ? j(dVar, f77951i, null) : (e) invokeL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> j(e.d<TResult, e<TContinuationResult>> dVar, Executor executor, e.c cVar) {
        InterceptResult invokeLLL;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, dVar, executor, cVar)) == null) {
            e.f fVar = new e.f();
            synchronized (this.f77953a) {
                q = q();
                if (!q) {
                    this.f77960h.add(new b(this, fVar, dVar, executor, cVar));
                }
            }
            if (q) {
                e(fVar, dVar, this, executor, cVar);
            }
            return fVar.a();
        }
        return (e) invokeLLL.objValue;
    }

    public Exception m() {
        InterceptResult invokeV;
        Exception exc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this.f77953a) {
                if (this.f77957e != null) {
                    this.f77958f = true;
                    if (this.f77959g != null) {
                        this.f77959g.a();
                        this.f77959g = null;
                    }
                }
                exc = this.f77957e;
            }
            return exc;
        }
        return (Exception) invokeV.objValue;
    }

    public TResult n() {
        InterceptResult invokeV;
        TResult tresult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this.f77953a) {
                tresult = this.f77956d;
            }
            return tresult;
        }
        return (TResult) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.f77953a) {
                z = this.f77955c;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.f77953a) {
                z = this.f77954b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this.f77953a) {
                z = m() != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.f77953a) {
                for (e.d<TResult, Void> dVar : this.f77960h) {
                    try {
                        dVar.then(this);
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception e3) {
                        throw new RuntimeException(e3);
                    }
                }
                this.f77960h = null;
            }
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this.f77953a) {
                if (this.f77954b) {
                    return false;
                }
                this.f77954b = true;
                this.f77955c = true;
                this.f77953a.notifyAll();
                s();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean u(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, exc)) == null) {
            synchronized (this.f77953a) {
                if (this.f77954b) {
                    return false;
                }
                this.f77954b = true;
                this.f77957e = exc;
                this.f77958f = false;
                this.f77953a.notifyAll();
                s();
                if (!this.f77958f && o() != null) {
                    this.f77959g = new g(this);
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean v(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, tresult)) == null) {
            synchronized (this.f77953a) {
                if (this.f77954b) {
                    return false;
                }
                this.f77954b = true;
                this.f77956d = tresult;
                this.f77953a.notifyAll();
                s();
                return true;
            }
        }
        return invokeL.booleanValue;
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
        this.f77953a = new Object();
        this.f77960h = new ArrayList();
        v(tresult);
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
        this.f77953a = new Object();
        this.f77960h = new ArrayList();
        if (z) {
            t();
        } else {
            v(null);
        }
    }
}
