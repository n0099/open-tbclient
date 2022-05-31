package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.tu9;
import com.repackage.uu9;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class dw9<T> implements uu9.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final uu9.c<T> a;
    public final long b;
    public final TimeUnit c;
    public final tu9 d;

    /* loaded from: classes5.dex */
    public static final class a<T> extends vu9<T> implements dv9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final vu9<? super T> b;
        public final tu9.a c;
        public final long d;
        public final TimeUnit e;
        public T f;
        public Throwable g;

        public a(vu9<? super T> vu9Var, tu9.a aVar, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu9Var, aVar, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vu9Var;
            this.c = aVar;
            this.d = j;
            this.e = timeUnit;
        }

        @Override // com.repackage.vu9
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.g = th;
                this.c.c(this, this.d, this.e);
            }
        }

        @Override // com.repackage.vu9
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f = t;
                this.c.c(this, this.d, this.e);
            }
        }

        @Override // com.repackage.dv9
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Throwable th = this.g;
                    if (th != null) {
                        this.g = null;
                        this.b.b(th);
                    } else {
                        T t = this.f;
                        this.f = null;
                        this.b.c(t);
                    }
                } finally {
                    this.c.unsubscribe();
                }
            }
        }
    }

    public dw9(uu9.c<T> cVar, long j, TimeUnit timeUnit, tu9 tu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Long.valueOf(j), timeUnit, tu9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
        this.d = tu9Var;
        this.b = j;
        this.c = timeUnit;
    }

    @Override // com.repackage.uu9.c, com.repackage.ev9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((vu9) ((vu9) obj));
    }

    public void call(vu9<? super T> vu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vu9Var) == null) {
            tu9.a createWorker = this.d.createWorker();
            a aVar = new a(vu9Var, createWorker, this.b, this.c);
            vu9Var.a(createWorker);
            vu9Var.a(aVar);
            this.a.call(aVar);
        }
    }
}
