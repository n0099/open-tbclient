package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ru9;
import com.repackage.uu9;
import java.util.concurrent.TimeoutException;
/* loaded from: classes6.dex */
public class dw9<T> implements ru9.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;
    public final b<T> b;
    public final ru9<? extends T> c;
    public final uu9 d;

    /* loaded from: classes6.dex */
    public interface a<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3);
    }

    /* loaded from: classes6.dex */
    public interface b<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    /* loaded from: classes6.dex */
    public static final class c<T> extends xu9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final nz9 e;
        public final uy9<T> f;
        public final b<T> g;
        public final ru9<? extends T> h;
        public final uu9.a i;
        public final kw9 j;
        public boolean k;
        public long l;

        /* loaded from: classes6.dex */
        public class a extends xu9<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = cVar;
            }

            @Override // com.repackage.xu9
            public void f(tu9 tu9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, tu9Var) == null) {
                    this.e.j.c(tu9Var);
                }
            }

            @Override // com.repackage.su9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.f.onCompleted();
                }
            }

            @Override // com.repackage.su9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.f.onError(th);
                }
            }

            @Override // com.repackage.su9
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.e.f.onNext(t);
                }
            }
        }

        public c(uy9<T> uy9Var, b<T> bVar, nz9 nz9Var, ru9<? extends T> ru9Var, uu9.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uy9Var, bVar, nz9Var, ru9Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = uy9Var;
            this.g = bVar;
            this.e = nz9Var;
            this.h = ru9Var;
            this.i = aVar;
            this.j = new kw9();
        }

        @Override // com.repackage.xu9
        public void f(tu9 tu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tu9Var) == null) {
                this.j.c(tu9Var);
            }
        }

        public void g(long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                synchronized (this) {
                    z = true;
                    if (j != this.l || this.k) {
                        z = false;
                    } else {
                        this.k = true;
                    }
                }
                if (z) {
                    if (this.h == null) {
                        this.f.onError(new TimeoutException());
                        return;
                    }
                    a aVar = new a(this);
                    this.h.B(aVar);
                    this.e.a(aVar);
                }
            }
        }

        @Override // com.repackage.su9
        public void onCompleted() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    z = true;
                    if (this.k) {
                        z = false;
                    } else {
                        this.k = true;
                    }
                }
                if (z) {
                    this.e.unsubscribe();
                    this.f.onCompleted();
                }
            }
        }

        @Override // com.repackage.su9
        public void onError(Throwable th) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                synchronized (this) {
                    z = true;
                    if (this.k) {
                        z = false;
                    } else {
                        this.k = true;
                    }
                }
                if (z) {
                    this.e.unsubscribe();
                    this.f.onError(th);
                }
            }
        }

        @Override // com.repackage.su9
        public void onNext(T t) {
            long j;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                synchronized (this) {
                    if (!this.k) {
                        j = this.l + 1;
                        this.l = j;
                        z = true;
                    } else {
                        j = this.l;
                        z = false;
                    }
                }
                if (z) {
                    this.f.onNext(t);
                    this.e.a((yu9) this.g.call(this, Long.valueOf(j), t, this.i));
                }
            }
        }
    }

    public dw9(a<T> aVar, b<T> bVar, ru9<? extends T> ru9Var, uu9 uu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, ru9Var, uu9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
        this.b = bVar;
        this.c = ru9Var;
        this.d = uu9Var;
    }

    @Override // com.repackage.ru9.b, com.repackage.jv9
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((xu9) ((xu9) obj));
    }

    public xu9<? super T> call(xu9<? super T> xu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xu9Var)) == null) {
            uu9.a createWorker = this.d.createWorker();
            xu9Var.b(createWorker);
            uy9 uy9Var = new uy9(xu9Var);
            nz9 nz9Var = new nz9();
            uy9Var.b(nz9Var);
            c cVar = new c(uy9Var, this.b, nz9Var, this.c, createWorker);
            uy9Var.b(cVar);
            uy9Var.f(cVar.j);
            nz9Var.a((yu9) this.a.call(cVar, 0L, createWorker));
            return cVar;
        }
        return (xu9) invokeL.objValue;
    }
}
