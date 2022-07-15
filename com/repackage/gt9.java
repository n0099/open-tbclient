package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ur9;
import com.repackage.xr9;
import java.util.concurrent.TimeoutException;
/* loaded from: classes6.dex */
public class gt9<T> implements ur9.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;
    public final b<T> b;
    public final ur9<? extends T> c;
    public final xr9 d;

    /* loaded from: classes6.dex */
    public interface a<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3);
    }

    /* loaded from: classes6.dex */
    public interface b<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    /* loaded from: classes6.dex */
    public static final class c<T> extends as9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final qw9 e;
        public final xv9<T> f;
        public final b<T> g;
        public final ur9<? extends T> h;
        public final xr9.a i;
        public final nt9 j;
        public boolean k;
        public long l;

        /* loaded from: classes6.dex */
        public class a extends as9<T> {
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

            @Override // com.repackage.as9
            public void f(wr9 wr9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wr9Var) == null) {
                    this.e.j.c(wr9Var);
                }
            }

            @Override // com.repackage.vr9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.f.onCompleted();
                }
            }

            @Override // com.repackage.vr9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.f.onError(th);
                }
            }

            @Override // com.repackage.vr9
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.e.f.onNext(t);
                }
            }
        }

        public c(xv9<T> xv9Var, b<T> bVar, qw9 qw9Var, ur9<? extends T> ur9Var, xr9.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv9Var, bVar, qw9Var, ur9Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = xv9Var;
            this.g = bVar;
            this.e = qw9Var;
            this.h = ur9Var;
            this.i = aVar;
            this.j = new nt9();
        }

        @Override // com.repackage.as9
        public void f(wr9 wr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr9Var) == null) {
                this.j.c(wr9Var);
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

        @Override // com.repackage.vr9
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

        @Override // com.repackage.vr9
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

        @Override // com.repackage.vr9
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
                    this.e.a((bs9) this.g.call(this, Long.valueOf(j), t, this.i));
                }
            }
        }
    }

    public gt9(a<T> aVar, b<T> bVar, ur9<? extends T> ur9Var, xr9 xr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, ur9Var, xr9Var};
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
        this.c = ur9Var;
        this.d = xr9Var;
    }

    @Override // com.repackage.ur9.b, com.repackage.ms9
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((as9) ((as9) obj));
    }

    public as9<? super T> call(as9<? super T> as9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, as9Var)) == null) {
            xr9.a createWorker = this.d.createWorker();
            as9Var.b(createWorker);
            xv9 xv9Var = new xv9(as9Var);
            qw9 qw9Var = new qw9();
            xv9Var.b(qw9Var);
            c cVar = new c(xv9Var, this.b, qw9Var, this.c, createWorker);
            xv9Var.b(cVar);
            xv9Var.f(cVar.j);
            qw9Var.a((bs9) this.a.call(cVar, 0L, createWorker));
            return cVar;
        }
        return (as9) invokeL.objValue;
    }
}
