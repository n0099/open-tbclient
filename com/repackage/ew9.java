package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.uu9;
import com.repackage.vu9;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class ew9<T> implements vu9.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vu9.c<T> a;
    public final long b;
    public final TimeUnit c;
    public final uu9 d;

    /* loaded from: classes6.dex */
    public static final class a<T> extends wu9<T> implements ev9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final wu9<? super T> b;
        public final uu9.a c;
        public final long d;
        public final TimeUnit e;
        public T f;
        public Throwable g;

        public a(wu9<? super T> wu9Var, uu9.a aVar, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu9Var, aVar, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wu9Var;
            this.c = aVar;
            this.d = j;
            this.e = timeUnit;
        }

        @Override // com.repackage.wu9
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.g = th;
                this.c.c(this, this.d, this.e);
            }
        }

        @Override // com.repackage.wu9
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f = t;
                this.c.c(this, this.d, this.e);
            }
        }

        @Override // com.repackage.ev9
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

    public ew9(vu9.c<T> cVar, long j, TimeUnit timeUnit, uu9 uu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Long.valueOf(j), timeUnit, uu9Var};
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
        this.d = uu9Var;
        this.b = j;
        this.c = timeUnit;
    }

    @Override // com.repackage.vu9.c, com.repackage.fv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((wu9) ((wu9) obj));
    }

    public void call(wu9<? super T> wu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
            uu9.a createWorker = this.d.createWorker();
            a aVar = new a(wu9Var, createWorker, this.b, this.c);
            wu9Var.a(createWorker);
            wu9Var.a(aVar);
            this.a.call(aVar);
        }
    }
}
