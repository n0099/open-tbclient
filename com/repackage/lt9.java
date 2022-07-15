package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xr9;
import com.repackage.yr9;
/* loaded from: classes6.dex */
public final class lt9<T> implements yr9.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yr9.c<T> a;
    public final xr9 b;

    /* loaded from: classes6.dex */
    public static final class a<T> extends zr9<T> implements hs9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final zr9<? super T> b;
        public final xr9.a c;
        public T d;
        public Throwable e;

        public a(zr9<? super T> zr9Var, xr9.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zr9Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zr9Var;
            this.c = aVar;
        }

        @Override // com.repackage.zr9
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.e = th;
                this.c.b(this);
            }
        }

        @Override // com.repackage.zr9
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.d = t;
                this.c.b(this);
            }
        }

        @Override // com.repackage.hs9
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Throwable th = this.e;
                    if (th != null) {
                        this.e = null;
                        this.b.b(th);
                    } else {
                        T t = this.d;
                        this.d = null;
                        this.b.c(t);
                    }
                } finally {
                    this.c.unsubscribe();
                }
            }
        }
    }

    public lt9(yr9.c<T> cVar, xr9 xr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, xr9Var};
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
        this.b = xr9Var;
    }

    @Override // com.repackage.yr9.c, com.repackage.is9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((zr9) ((zr9) obj));
    }

    public void call(zr9<? super T> zr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zr9Var) == null) {
            xr9.a createWorker = this.b.createWorker();
            a aVar = new a(zr9Var, createWorker);
            zr9Var.a(createWorker);
            zr9Var.a(aVar);
            this.a.call(aVar);
        }
    }
}
