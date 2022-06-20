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
/* loaded from: classes6.dex */
public class i0<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public static final Executor i;
    public static volatile f j;
    public static i0<?> k;
    public static i0<Boolean> l;
    public static i0<Boolean> m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public boolean b;
    public boolean c;
    public TResult d;
    public Exception e;
    public boolean f;
    public k0 g;
    public List<h0<TResult, Void>> h;

    /* loaded from: classes6.dex */
    public class a implements h0<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j0 a;
        public final /* synthetic */ h0 b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ g0 d;

        public a(i0 i0Var, j0 j0Var, h0 h0Var, Executor executor, g0 g0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i0Var, j0Var, h0Var, executor, g0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j0Var;
            this.b = h0Var;
            this.c = executor;
            this.d = g0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.h0
        /* renamed from: a */
        public Void then(i0<TResult> i0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i0Var)) == null) {
                i0.d(this.a, this.b, i0Var, this.c, this.d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements h0<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j0 a;
        public final /* synthetic */ h0 b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ g0 d;

        public b(i0 i0Var, j0 j0Var, h0 h0Var, Executor executor, g0 g0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i0Var, j0Var, h0Var, executor, g0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j0Var;
            this.b = h0Var;
            this.c = executor;
            this.d = g0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.h0
        /* renamed from: a */
        public Void then(i0<TResult> i0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i0Var)) == null) {
                i0.c(this.a, this.b, i0Var, this.c, this.d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g0 a;
        public final /* synthetic */ j0 b;
        public final /* synthetic */ h0 c;
        public final /* synthetic */ i0 d;

        public c(g0 g0Var, j0 j0Var, h0 h0Var, i0 i0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g0Var, j0Var, h0Var, i0Var};
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
            this.b = j0Var;
            this.c = h0Var;
            this.d = i0Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.repackage.j0 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g0 g0Var = this.a;
                if (g0Var != null && g0Var.a()) {
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

    /* loaded from: classes6.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g0 a;
        public final /* synthetic */ j0 b;
        public final /* synthetic */ h0 c;
        public final /* synthetic */ i0 d;

        /* loaded from: classes6.dex */
        public class a implements h0<TContinuationResult, Void> {
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
            /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.repackage.j0 */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.repackage.h0
            /* renamed from: a */
            public Void then(i0<TContinuationResult> i0Var) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i0Var)) == null) {
                    g0 g0Var = this.a.a;
                    if (g0Var != null && g0Var.a()) {
                        this.a.b.b();
                        return null;
                    }
                    if (i0Var.n()) {
                        this.a.b.b();
                    } else if (i0Var.p()) {
                        this.a.b.c(i0Var.k());
                    } else {
                        this.a.b.setResult(i0Var.l());
                    }
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }

        public d(g0 g0Var, j0 j0Var, h0 h0Var, i0 i0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g0Var, j0Var, h0Var, i0Var};
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
            this.b = j0Var;
            this.c = h0Var;
            this.d = i0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g0 g0Var = this.a;
                if (g0Var != null && g0Var.a()) {
                    this.b.b();
                    return;
                }
                try {
                    i0 i0Var = (i0) this.c.then(this.d);
                    if (i0Var == null) {
                        this.b.setResult(null);
                    } else {
                        i0Var.e(new a(this));
                    }
                } catch (CancellationException unused) {
                    this.b.b();
                } catch (Exception e) {
                    this.b.c(e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g0 a;
        public final /* synthetic */ j0 b;
        public final /* synthetic */ Callable c;

        public e(g0 g0Var, j0 j0Var, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g0Var, j0Var, callable};
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
            this.b = j0Var;
            this.c = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.repackage.j0 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g0 g0Var = this.a;
                if (g0Var != null && g0Var.a()) {
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

    /* loaded from: classes6.dex */
    public interface f {
        void a(i0<?> i0Var, UnobservedTaskException unobservedTaskException);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964039170, "Lcom/repackage/i0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964039170, "Lcom/repackage/i0;");
                return;
            }
        }
        f0.a();
        i = f0.b();
        e0.c();
        k = new i0<>((Object) null);
        l = new i0<>(Boolean.TRUE);
        m = new i0<>(Boolean.FALSE);
        new i0(true);
    }

    public i0() {
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

    public static <TContinuationResult, TResult> void c(j0<TContinuationResult> j0Var, h0<TResult, i0<TContinuationResult>> h0Var, i0<TResult> i0Var, Executor executor, g0 g0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, j0Var, h0Var, i0Var, executor, g0Var) == null) {
            try {
                executor.execute(new d(g0Var, j0Var, h0Var, i0Var));
            } catch (Exception e2) {
                j0Var.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> i0<TResult> call(Callable<TResult> callable, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, callable, executor)) == null) ? call(callable, executor, null) : (i0) invokeLL.objValue;
    }

    public static <TContinuationResult, TResult> void d(j0<TContinuationResult> j0Var, h0<TResult, TContinuationResult> h0Var, i0<TResult> i0Var, Executor executor, g0 g0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65547, null, j0Var, h0Var, i0Var, executor, g0Var) == null) {
            try {
                executor.execute(new c(g0Var, j0Var, h0Var, i0Var));
            } catch (Exception e2) {
                j0Var.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> i0<TResult> i(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, exc)) == null) {
            j0 j0Var = new j0();
            j0Var.c(exc);
            return j0Var.a();
        }
        return (i0) invokeL.objValue;
    }

    public static <TResult> i0<TResult> j(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, tresult)) == null) {
            if (tresult == null) {
                return (i0<TResult>) k;
            }
            if (tresult instanceof Boolean) {
                return ((Boolean) tresult).booleanValue() ? (i0<TResult>) l : (i0<TResult>) m;
            }
            j0 j0Var = new j0();
            j0Var.setResult(tresult);
            return j0Var.a();
        }
        return (i0) invokeL.objValue;
    }

    public static f m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? j : (f) invokeV.objValue;
    }

    public <TContinuationResult> i0<TContinuationResult> e(h0<TResult, TContinuationResult> h0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, h0Var)) == null) ? f(h0Var, i, null) : (i0) invokeL.objValue;
    }

    public <TContinuationResult> i0<TContinuationResult> f(h0<TResult, TContinuationResult> h0Var, Executor executor, g0 g0Var) {
        InterceptResult invokeLLL;
        boolean o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h0Var, executor, g0Var)) == null) {
            j0 j0Var = new j0();
            synchronized (this.a) {
                o = o();
                if (!o) {
                    this.h.add(new a(this, j0Var, h0Var, executor, g0Var));
                }
            }
            if (o) {
                d(j0Var, h0Var, this, executor, g0Var);
            }
            return j0Var.a();
        }
        return (i0) invokeLLL.objValue;
    }

    public <TContinuationResult> i0<TContinuationResult> g(h0<TResult, i0<TContinuationResult>> h0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, h0Var)) == null) ? h(h0Var, i, null) : (i0) invokeL.objValue;
    }

    public <TContinuationResult> i0<TContinuationResult> h(h0<TResult, i0<TContinuationResult>> h0Var, Executor executor, g0 g0Var) {
        InterceptResult invokeLLL;
        boolean o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, h0Var, executor, g0Var)) == null) {
            j0 j0Var = new j0();
            synchronized (this.a) {
                o = o();
                if (!o) {
                    this.h.add(new b(this, j0Var, h0Var, executor, g0Var));
                }
            }
            if (o) {
                c(j0Var, h0Var, this, executor, g0Var);
            }
            return j0Var.a();
        }
        return (i0) invokeLLL.objValue;
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
                for (h0<TResult, Void> h0Var : this.h) {
                    try {
                        h0Var.then(this);
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
                    this.g = new k0(this);
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

    public static <TResult> i0<TResult> call(Callable<TResult> callable, Executor executor, g0 g0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, callable, executor, g0Var)) == null) {
            j0 j0Var = new j0();
            try {
                executor.execute(new e(g0Var, j0Var, callable));
            } catch (Exception e2) {
                j0Var.c(new ExecutorException(e2));
            }
            return j0Var.a();
        }
        return (i0) invokeLLL.objValue;
    }

    public i0(TResult tresult) {
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

    public static <TResult> i0<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, callable)) == null) ? call(callable, i, null) : (i0) invokeL.objValue;
    }

    public static <TResult> i0<TResult> call(Callable<TResult> callable, g0 g0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, callable, g0Var)) == null) ? call(callable, i, g0Var) : (i0) invokeLL.objValue;
    }

    public i0(boolean z) {
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
