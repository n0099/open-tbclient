package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xy9;
import com.repackage.yy9;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class i0a<T> implements yy9.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yy9.c<T> a;
    public final long b;
    public final TimeUnit c;
    public final xy9 d;

    /* loaded from: classes6.dex */
    public static final class a<T> extends zy9<T> implements hz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final zy9<? super T> b;
        public final xy9.a c;
        public final long d;
        public final TimeUnit e;
        public T f;
        public Throwable g;

        public a(zy9<? super T> zy9Var, xy9.a aVar, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy9Var, aVar, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zy9Var;
            this.c = aVar;
            this.d = j;
            this.e = timeUnit;
        }

        @Override // com.repackage.zy9
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.g = th;
                this.c.c(this, this.d, this.e);
            }
        }

        @Override // com.repackage.zy9
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f = t;
                this.c.c(this, this.d, this.e);
            }
        }

        @Override // com.repackage.hz9
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

    public i0a(yy9.c<T> cVar, long j, TimeUnit timeUnit, xy9 xy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Long.valueOf(j), timeUnit, xy9Var};
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
        this.d = xy9Var;
        this.b = j;
        this.c = timeUnit;
    }

    @Override // com.repackage.yy9.c, com.repackage.iz9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((zy9) ((zy9) obj));
    }

    public void call(zy9<? super T> zy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zy9Var) == null) {
            xy9.a createWorker = this.d.createWorker();
            a aVar = new a(zy9Var, createWorker, this.b, this.c);
            zy9Var.a(createWorker);
            zy9Var.a(aVar);
            this.a.call(aVar);
        }
    }
}
