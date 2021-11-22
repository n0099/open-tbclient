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
    public static final Executor f72517i;
    public static volatile f j;
    public static e<?> k;
    public static e<Boolean> l;
    public static e<Boolean> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Object f72518a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f72519b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f72520c;

    /* renamed from: d  reason: collision with root package name */
    public TResult f72521d;

    /* renamed from: e  reason: collision with root package name */
    public Exception f72522e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f72523f;

    /* renamed from: g  reason: collision with root package name */
    public g f72524g;

    /* renamed from: h  reason: collision with root package name */
    public List<d.d<TResult, Void>> f72525h;

    /* loaded from: classes2.dex */
    public class a implements d.d<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.f f72526a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.d f72527b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f72528c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.c f72529d;

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
            this.f72526a = fVar;
            this.f72527b = dVar;
            this.f72528c = executor;
            this.f72529d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                e.d(this.f72526a, this.f72527b, eVar, this.f72528c, this.f72529d);
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
        public final /* synthetic */ d.f f72530a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.d f72531b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f72532c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.c f72533d;

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
            this.f72530a = fVar;
            this.f72531b = dVar;
            this.f72532c = executor;
            this.f72533d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                e.c(this.f72530a, this.f72531b, eVar, this.f72532c, this.f72533d);
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
        public final /* synthetic */ d.c f72534e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.f f72535f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.d f72536g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f72537h;

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
            this.f72534e = cVar;
            this.f72535f = fVar;
            this.f72536g = dVar;
            this.f72537h = eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: d.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.c cVar = this.f72534e;
                if (cVar != null && cVar.a()) {
                    this.f72535f.b();
                    return;
                }
                try {
                    this.f72535f.setResult(this.f72536g.then(this.f72537h));
                } catch (CancellationException unused) {
                    this.f72535f.b();
                } catch (Exception e2) {
                    this.f72535f.c(e2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f72538e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.f f72539f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.d f72540g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f72541h;

        /* loaded from: classes2.dex */
        public class a implements d.d<TContinuationResult, Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f72542a;

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
                this.f72542a = dVar;
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
                    d.c cVar = this.f72542a.f72538e;
                    if (cVar != null && cVar.a()) {
                        this.f72542a.f72539f.b();
                        return null;
                    }
                    if (eVar.n()) {
                        this.f72542a.f72539f.b();
                    } else if (eVar.p()) {
                        this.f72542a.f72539f.c(eVar.k());
                    } else {
                        this.f72542a.f72539f.setResult(eVar.l());
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
            this.f72538e = cVar;
            this.f72539f = fVar;
            this.f72540g = dVar;
            this.f72541h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.c cVar = this.f72538e;
                if (cVar != null && cVar.a()) {
                    this.f72539f.b();
                    return;
                }
                try {
                    e eVar = (e) this.f72540g.then(this.f72541h);
                    if (eVar == null) {
                        this.f72539f.setResult(null);
                    } else {
                        eVar.e(new a(this));
                    }
                } catch (CancellationException unused) {
                    this.f72539f.b();
                } catch (Exception e2) {
                    this.f72539f.c(e2);
                }
            }
        }
    }

    /* renamed from: d.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC2076e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f72543e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.f f72544f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Callable f72545g;

        public RunnableC2076e(d.c cVar, d.f fVar, Callable callable) {
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
            this.f72543e = cVar;
            this.f72544f = fVar;
            this.f72545g = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: d.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.c cVar = this.f72543e;
                if (cVar != null && cVar.a()) {
                    this.f72544f.b();
                    return;
                }
                try {
                    this.f72544f.setResult(this.f72545g.call());
                } catch (CancellationException unused) {
                    this.f72544f.b();
                } catch (Exception e2) {
                    this.f72544f.c(e2);
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
        f72517i = d.b.b();
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
        this.f72518a = new Object();
        this.f72525h = new ArrayList();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? f(dVar, f72517i, null) : (e) invokeL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> f(d.d<TResult, TContinuationResult> dVar, Executor executor, d.c cVar) {
        InterceptResult invokeLLL;
        boolean o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, executor, cVar)) == null) {
            d.f fVar = new d.f();
            synchronized (this.f72518a) {
                o = o();
                if (!o) {
                    this.f72525h.add(new a(this, fVar, dVar, executor, cVar));
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) ? h(dVar, f72517i, null) : (e) invokeL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> h(d.d<TResult, e<TContinuationResult>> dVar, Executor executor, d.c cVar) {
        InterceptResult invokeLLL;
        boolean o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, dVar, executor, cVar)) == null) {
            d.f fVar = new d.f();
            synchronized (this.f72518a) {
                o = o();
                if (!o) {
                    this.f72525h.add(new b(this, fVar, dVar, executor, cVar));
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
            synchronized (this.f72518a) {
                if (this.f72522e != null) {
                    this.f72523f = true;
                    if (this.f72524g != null) {
                        this.f72524g.a();
                        this.f72524g = null;
                    }
                }
                exc = this.f72522e;
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
            synchronized (this.f72518a) {
                tresult = this.f72521d;
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
            synchronized (this.f72518a) {
                z = this.f72520c;
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
            synchronized (this.f72518a) {
                z = this.f72519b;
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
            synchronized (this.f72518a) {
                z = k() != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.f72518a) {
                for (d.d<TResult, Void> dVar : this.f72525h) {
                    try {
                        dVar.then(this);
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception e3) {
                        throw new RuntimeException(e3);
                    }
                }
                this.f72525h = null;
            }
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this.f72518a) {
                if (this.f72519b) {
                    return false;
                }
                this.f72519b = true;
                this.f72520c = true;
                this.f72518a.notifyAll();
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
            synchronized (this.f72518a) {
                if (this.f72519b) {
                    return false;
                }
                this.f72519b = true;
                this.f72522e = exc;
                this.f72523f = false;
                this.f72518a.notifyAll();
                q();
                if (!this.f72523f && m() != null) {
                    this.f72524g = new g(this);
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
            synchronized (this.f72518a) {
                if (this.f72519b) {
                    return false;
                }
                this.f72519b = true;
                this.f72521d = tresult;
                this.f72518a.notifyAll();
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
                executor.execute(new RunnableC2076e(cVar, fVar, callable));
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
        this.f72518a = new Object();
        this.f72525h = new ArrayList();
        t(tresult);
    }

    public static <TResult> e<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, callable)) == null) ? call(callable, f72517i, null) : (e) invokeL.objValue;
    }

    public static <TResult> e<TResult> call(Callable<TResult> callable, d.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, callable, cVar)) == null) ? call(callable, f72517i, cVar) : (e) invokeLL.objValue;
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
        this.f72518a = new Object();
        this.f72525h = new ArrayList();
        if (z) {
            r();
        } else {
            t(null);
        }
    }
}
