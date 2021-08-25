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
    public static final Executor f78152i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile f f78153j;
    public static e<?> k;
    public static e<Boolean> l;
    public static e<Boolean> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Object f78154a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f78155b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f78156c;

    /* renamed from: d  reason: collision with root package name */
    public TResult f78157d;

    /* renamed from: e  reason: collision with root package name */
    public Exception f78158e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f78159f;

    /* renamed from: g  reason: collision with root package name */
    public g f78160g;

    /* renamed from: h  reason: collision with root package name */
    public List<e.d<TResult, Void>> f78161h;

    /* loaded from: classes10.dex */
    public class a implements e.d<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e.f f78162a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e.d f78163b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f78164c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.c f78165d;

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
            this.f78162a = fVar;
            this.f78163b = dVar;
            this.f78164c = executor;
            this.f78165d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // e.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                e.f(this.f78162a, this.f78163b, eVar, this.f78164c, this.f78165d);
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
        public final /* synthetic */ e.f f78166a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e.d f78167b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f78168c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.c f78169d;

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
            this.f78166a = fVar;
            this.f78167b = dVar;
            this.f78168c = executor;
            this.f78169d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // e.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                e.e(this.f78166a, this.f78167b, eVar, this.f78168c, this.f78169d);
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
        public final /* synthetic */ e.c f78170e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.f f78171f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e.d f78172g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f78173h;

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
            this.f78170e = cVar;
            this.f78171f = fVar;
            this.f78172g = dVar;
            this.f78173h = eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: e.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.c cVar = this.f78170e;
                if (cVar != null && cVar.a()) {
                    this.f78171f.b();
                    return;
                }
                try {
                    this.f78171f.d(this.f78172g.then(this.f78173h));
                } catch (CancellationException unused) {
                    this.f78171f.b();
                } catch (Exception e2) {
                    this.f78171f.c(e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f78174e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.f f78175f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e.d f78176g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f78177h;

        /* loaded from: classes10.dex */
        public class a implements e.d<TContinuationResult, Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f78178a;

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
                this.f78178a = dVar;
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
                    e.c cVar = this.f78178a.f78174e;
                    if (cVar != null && cVar.a()) {
                        this.f78178a.f78175f.b();
                        return null;
                    }
                    if (eVar.p()) {
                        this.f78178a.f78175f.b();
                    } else if (eVar.r()) {
                        this.f78178a.f78175f.c(eVar.m());
                    } else {
                        this.f78178a.f78175f.d(eVar.n());
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
            this.f78174e = cVar;
            this.f78175f = fVar;
            this.f78176g = dVar;
            this.f78177h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.c cVar = this.f78174e;
                if (cVar != null && cVar.a()) {
                    this.f78175f.b();
                    return;
                }
                try {
                    e eVar = (e) this.f78176g.then(this.f78177h);
                    if (eVar == null) {
                        this.f78175f.d(null);
                    } else {
                        eVar.g(new a(this));
                    }
                } catch (CancellationException unused) {
                    this.f78175f.b();
                } catch (Exception e2) {
                    this.f78175f.c(e2);
                }
            }
        }
    }

    /* renamed from: e.e$e  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class RunnableC2107e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f78179e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.f f78180f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Callable f78181g;

        public RunnableC2107e(e.c cVar, e.f fVar, Callable callable) {
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
            this.f78179e = cVar;
            this.f78180f = fVar;
            this.f78181g = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: e.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.c cVar = this.f78179e;
                if (cVar != null && cVar.a()) {
                    this.f78180f.b();
                    return;
                }
                try {
                    this.f78180f.d(this.f78181g.call());
                } catch (CancellationException unused) {
                    this.f78180f.b();
                } catch (Exception e2) {
                    this.f78180f.c(e2);
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
        f78152i = e.b.b();
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
        this.f78154a = new Object();
        this.f78161h = new ArrayList();
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
                executor.execute(new RunnableC2107e(cVar, fVar, callable));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f78153j : (f) invokeV.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> g(e.d<TResult, TContinuationResult> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? h(dVar, f78152i, null) : (e) invokeL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> h(e.d<TResult, TContinuationResult> dVar, Executor executor, e.c cVar) {
        InterceptResult invokeLLL;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, executor, cVar)) == null) {
            e.f fVar = new e.f();
            synchronized (this.f78154a) {
                q = q();
                if (!q) {
                    this.f78161h.add(new a(this, fVar, dVar, executor, cVar));
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) ? j(dVar, f78152i, null) : (e) invokeL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> j(e.d<TResult, e<TContinuationResult>> dVar, Executor executor, e.c cVar) {
        InterceptResult invokeLLL;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, dVar, executor, cVar)) == null) {
            e.f fVar = new e.f();
            synchronized (this.f78154a) {
                q = q();
                if (!q) {
                    this.f78161h.add(new b(this, fVar, dVar, executor, cVar));
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
            synchronized (this.f78154a) {
                if (this.f78158e != null) {
                    this.f78159f = true;
                    if (this.f78160g != null) {
                        this.f78160g.a();
                        this.f78160g = null;
                    }
                }
                exc = this.f78158e;
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
            synchronized (this.f78154a) {
                tresult = this.f78157d;
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
            synchronized (this.f78154a) {
                z = this.f78156c;
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
            synchronized (this.f78154a) {
                z = this.f78155b;
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
            synchronized (this.f78154a) {
                z = m() != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.f78154a) {
                for (e.d<TResult, Void> dVar : this.f78161h) {
                    try {
                        dVar.then(this);
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception e3) {
                        throw new RuntimeException(e3);
                    }
                }
                this.f78161h = null;
            }
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this.f78154a) {
                if (this.f78155b) {
                    return false;
                }
                this.f78155b = true;
                this.f78156c = true;
                this.f78154a.notifyAll();
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
            synchronized (this.f78154a) {
                if (this.f78155b) {
                    return false;
                }
                this.f78155b = true;
                this.f78158e = exc;
                this.f78159f = false;
                this.f78154a.notifyAll();
                s();
                if (!this.f78159f && o() != null) {
                    this.f78160g = new g(this);
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
            synchronized (this.f78154a) {
                if (this.f78155b) {
                    return false;
                }
                this.f78155b = true;
                this.f78157d = tresult;
                this.f78154a.notifyAll();
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
        this.f78154a = new Object();
        this.f78161h = new ArrayList();
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
        this.f78154a = new Object();
        this.f78161h = new ArrayList();
        if (z) {
            t();
        } else {
            v(null);
        }
    }
}
