package com.repackage;

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
/* loaded from: classes5.dex */
public class f0<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public static final Executor i;
    public static volatile f j;
    public static f0<?> k;
    public static f0<Boolean> l;
    public static f0<Boolean> m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public boolean b;
    public boolean c;
    public TResult d;
    public Exception e;
    public boolean f;
    public h0 g;
    public List<e0<TResult, Void>> h;

    /* loaded from: classes5.dex */
    public class a implements e0<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g0 a;
        public final /* synthetic */ e0 b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ d0 d;

        public a(f0 f0Var, g0 g0Var, e0 e0Var, Executor executor, d0 d0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f0Var, g0Var, e0Var, executor, d0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g0Var;
            this.b = e0Var;
            this.c = executor;
            this.d = d0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e0
        /* renamed from: a */
        public Void then(f0<TResult> f0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f0Var)) == null) {
                f0.d(this.a, this.b, f0Var, this.c, this.d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements e0<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g0 a;
        public final /* synthetic */ e0 b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ d0 d;

        public b(f0 f0Var, g0 g0Var, e0 e0Var, Executor executor, d0 d0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f0Var, g0Var, e0Var, executor, d0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g0Var;
            this.b = e0Var;
            this.c = executor;
            this.d = d0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e0
        /* renamed from: a */
        public Void then(f0<TResult> f0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f0Var)) == null) {
                f0.c(this.a, this.b, f0Var, this.c, this.d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0 a;
        public final /* synthetic */ g0 b;
        public final /* synthetic */ e0 c;
        public final /* synthetic */ f0 d;

        public c(d0 d0Var, g0 g0Var, e0 e0Var, f0 f0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, g0Var, e0Var, f0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d0Var;
            this.b = g0Var;
            this.c = e0Var;
            this.d = f0Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.repackage.g0 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d0 d0Var = this.a;
                if (d0Var != null && d0Var.a()) {
                    this.b.b();
                    return;
                }
                try {
                    this.b.setResult(this.c.then(this.d));
                } catch (CancellationException unused) {
                    this.b.b();
                } catch (Exception e) {
                    this.b.c(e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0 a;
        public final /* synthetic */ g0 b;
        public final /* synthetic */ e0 c;
        public final /* synthetic */ f0 d;

        /* loaded from: classes5.dex */
        public class a implements e0<TContinuationResult, Void> {
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.repackage.g0 */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.repackage.e0
            /* renamed from: a */
            public Void then(f0<TContinuationResult> f0Var) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f0Var)) == null) {
                    d0 d0Var = this.a.a;
                    if (d0Var != null && d0Var.a()) {
                        this.a.b.b();
                        return null;
                    }
                    if (f0Var.n()) {
                        this.a.b.b();
                    } else if (f0Var.p()) {
                        this.a.b.c(f0Var.k());
                    } else {
                        this.a.b.setResult(f0Var.l());
                    }
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }

        public d(d0 d0Var, g0 g0Var, e0 e0Var, f0 f0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, g0Var, e0Var, f0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d0Var;
            this.b = g0Var;
            this.c = e0Var;
            this.d = f0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d0 d0Var = this.a;
                if (d0Var != null && d0Var.a()) {
                    this.b.b();
                    return;
                }
                try {
                    f0 f0Var = (f0) this.c.then(this.d);
                    if (f0Var == null) {
                        this.b.setResult(null);
                    } else {
                        f0Var.e(new a(this));
                    }
                } catch (CancellationException unused) {
                    this.b.b();
                } catch (Exception e) {
                    this.b.c(e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0 a;
        public final /* synthetic */ g0 b;
        public final /* synthetic */ Callable c;

        public e(d0 d0Var, g0 g0Var, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, g0Var, callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d0Var;
            this.b = g0Var;
            this.c = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.repackage.g0 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d0 d0Var = this.a;
                if (d0Var != null && d0Var.a()) {
                    this.b.b();
                    return;
                }
                try {
                    this.b.setResult(this.c.call());
                } catch (CancellationException unused) {
                    this.b.b();
                } catch (Exception e) {
                    this.b.c(e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(f0<?> f0Var, UnobservedTaskException unobservedTaskException);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964042053, "Lcom/repackage/f0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964042053, "Lcom/repackage/f0;");
                return;
            }
        }
        c0.a();
        i = c0.b();
        b0.c();
        k = new f0<>((Object) null);
        l = new f0<>(Boolean.TRUE);
        m = new f0<>(Boolean.FALSE);
        new f0(true);
    }

    public f0() {
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
        this.h = new ArrayList();
    }

    public static <TContinuationResult, TResult> void c(g0<TContinuationResult> g0Var, e0<TResult, f0<TContinuationResult>> e0Var, f0<TResult> f0Var, Executor executor, d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, g0Var, e0Var, f0Var, executor, d0Var) == null) {
            try {
                executor.execute(new d(d0Var, g0Var, e0Var, f0Var));
            } catch (Exception e2) {
                g0Var.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> f0<TResult> call(Callable<TResult> callable, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, callable, executor)) == null) ? call(callable, executor, null) : (f0) invokeLL.objValue;
    }

    public static <TContinuationResult, TResult> void d(g0<TContinuationResult> g0Var, e0<TResult, TContinuationResult> e0Var, f0<TResult> f0Var, Executor executor, d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65547, null, g0Var, e0Var, f0Var, executor, d0Var) == null) {
            try {
                executor.execute(new c(d0Var, g0Var, e0Var, f0Var));
            } catch (Exception e2) {
                g0Var.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> f0<TResult> i(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, exc)) == null) {
            g0 g0Var = new g0();
            g0Var.c(exc);
            return g0Var.a();
        }
        return (f0) invokeL.objValue;
    }

    public static <TResult> f0<TResult> j(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, tresult)) == null) {
            if (tresult == null) {
                return (f0<TResult>) k;
            }
            if (tresult instanceof Boolean) {
                return ((Boolean) tresult).booleanValue() ? (f0<TResult>) l : (f0<TResult>) m;
            }
            g0 g0Var = new g0();
            g0Var.setResult(tresult);
            return g0Var.a();
        }
        return (f0) invokeL.objValue;
    }

    public static f m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? j : (f) invokeV.objValue;
    }

    public <TContinuationResult> f0<TContinuationResult> e(e0<TResult, TContinuationResult> e0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e0Var)) == null) ? f(e0Var, i, null) : (f0) invokeL.objValue;
    }

    public <TContinuationResult> f0<TContinuationResult> f(e0<TResult, TContinuationResult> e0Var, Executor executor, d0 d0Var) {
        InterceptResult invokeLLL;
        boolean o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e0Var, executor, d0Var)) == null) {
            g0 g0Var = new g0();
            synchronized (this.a) {
                o = o();
                if (!o) {
                    this.h.add(new a(this, g0Var, e0Var, executor, d0Var));
                }
            }
            if (o) {
                d(g0Var, e0Var, this, executor, d0Var);
            }
            return g0Var.a();
        }
        return (f0) invokeLLL.objValue;
    }

    public <TContinuationResult> f0<TContinuationResult> g(e0<TResult, f0<TContinuationResult>> e0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e0Var)) == null) ? h(e0Var, i, null) : (f0) invokeL.objValue;
    }

    public <TContinuationResult> f0<TContinuationResult> h(e0<TResult, f0<TContinuationResult>> e0Var, Executor executor, d0 d0Var) {
        InterceptResult invokeLLL;
        boolean o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, e0Var, executor, d0Var)) == null) {
            g0 g0Var = new g0();
            synchronized (this.a) {
                o = o();
                if (!o) {
                    this.h.add(new b(this, g0Var, e0Var, executor, d0Var));
                }
            }
            if (o) {
                c(g0Var, e0Var, this, executor, d0Var);
            }
            return g0Var.a();
        }
        return (f0) invokeLLL.objValue;
    }

    public Exception k() {
        InterceptResult invokeV;
        Exception exc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this.a) {
                if (this.e != null) {
                    this.f = true;
                    if (this.g != null) {
                        this.g.a();
                        this.g = null;
                    }
                }
                exc = this.e;
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
                tresult = this.d;
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
                z = this.c;
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
                z = this.b;
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
                for (e0<TResult, Void> e0Var : this.h) {
                    try {
                        e0Var.then(this);
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception e3) {
                        throw new RuntimeException(e3);
                    }
                }
                this.h = null;
            }
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this.a) {
                if (this.b) {
                    return false;
                }
                this.b = true;
                this.c = true;
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
                if (this.b) {
                    return false;
                }
                this.b = true;
                this.e = exc;
                this.f = false;
                this.a.notifyAll();
                q();
                if (!this.f && m() != null) {
                    this.g = new h0(this);
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
                if (this.b) {
                    return false;
                }
                this.b = true;
                this.d = tresult;
                this.a.notifyAll();
                q();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static <TResult> f0<TResult> call(Callable<TResult> callable, Executor executor, d0 d0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, callable, executor, d0Var)) == null) {
            g0 g0Var = new g0();
            try {
                executor.execute(new e(d0Var, g0Var, callable));
            } catch (Exception e2) {
                g0Var.c(new ExecutorException(e2));
            }
            return g0Var.a();
        }
        return (f0) invokeLLL.objValue;
    }

    public f0(TResult tresult) {
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
        this.h = new ArrayList();
        t(tresult);
    }

    public static <TResult> f0<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, callable)) == null) ? call(callable, i, null) : (f0) invokeL.objValue;
    }

    public static <TResult> f0<TResult> call(Callable<TResult> callable, d0 d0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, callable, d0Var)) == null) ? call(callable, i, d0Var) : (f0) invokeLL.objValue;
    }

    public f0(boolean z) {
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
        this.h = new ArrayList();
        if (z) {
            r();
        } else {
            t(null);
        }
    }
}
