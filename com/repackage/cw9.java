package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qu9;
import com.repackage.tu9;
import java.util.concurrent.TimeoutException;
/* loaded from: classes5.dex */
public class cw9<T> implements qu9.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;
    public final b<T> b;
    public final qu9<? extends T> c;
    public final tu9 d;

    /* loaded from: classes5.dex */
    public interface a<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3);
    }

    /* loaded from: classes5.dex */
    public interface b<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    /* loaded from: classes5.dex */
    public static final class c<T> extends wu9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final mz9 e;
        public final ty9<T> f;
        public final b<T> g;
        public final qu9<? extends T> h;
        public final tu9.a i;
        public final jw9 j;
        public boolean k;
        public long l;

        /* loaded from: classes5.dex */
        public class a extends wu9<T> {
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

            @Override // com.repackage.wu9
            public void f(su9 su9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, su9Var) == null) {
                    this.e.j.c(su9Var);
                }
            }

            @Override // com.repackage.ru9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.f.onCompleted();
                }
            }

            @Override // com.repackage.ru9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.f.onError(th);
                }
            }

            @Override // com.repackage.ru9
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.e.f.onNext(t);
                }
            }
        }

        public c(ty9<T> ty9Var, b<T> bVar, mz9 mz9Var, qu9<? extends T> qu9Var, tu9.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ty9Var, bVar, mz9Var, qu9Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ty9Var;
            this.g = bVar;
            this.e = mz9Var;
            this.h = qu9Var;
            this.i = aVar;
            this.j = new jw9();
        }

        @Override // com.repackage.wu9
        public void f(su9 su9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, su9Var) == null) {
                this.j.c(su9Var);
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

        @Override // com.repackage.ru9
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

        @Override // com.repackage.ru9
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

        @Override // com.repackage.ru9
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
                    this.e.a((xu9) this.g.call(this, Long.valueOf(j), t, this.i));
                }
            }
        }
    }

    public cw9(a<T> aVar, b<T> bVar, qu9<? extends T> qu9Var, tu9 tu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, qu9Var, tu9Var};
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
        this.c = qu9Var;
        this.d = tu9Var;
    }

    @Override // com.repackage.qu9.b, com.repackage.iv9
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((wu9) ((wu9) obj));
    }

    public wu9<? super T> call(wu9<? super T> wu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wu9Var)) == null) {
            tu9.a createWorker = this.d.createWorker();
            wu9Var.b(createWorker);
            ty9 ty9Var = new ty9(wu9Var);
            mz9 mz9Var = new mz9();
            ty9Var.b(mz9Var);
            c cVar = new c(ty9Var, this.b, mz9Var, this.c, createWorker);
            ty9Var.b(cVar);
            ty9Var.f(cVar.j);
            mz9Var.a((xu9) this.a.call(cVar, 0L, createWorker));
            return cVar;
        }
        return (wu9) invokeL.objValue;
    }
}
