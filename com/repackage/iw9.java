package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.uu9;
import com.repackage.vu9;
/* loaded from: classes6.dex */
public final class iw9<T> implements vu9.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vu9.c<T> a;
    public final uu9 b;

    /* loaded from: classes6.dex */
    public static final class a<T> extends wu9<T> implements ev9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final wu9<? super T> b;
        public final uu9.a c;
        public T d;
        public Throwable e;

        public a(wu9<? super T> wu9Var, uu9.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu9Var, aVar};
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
        }

        @Override // com.repackage.wu9
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.e = th;
                this.c.b(this);
            }
        }

        @Override // com.repackage.wu9
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.d = t;
                this.c.b(this);
            }
        }

        @Override // com.repackage.ev9
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

    public iw9(vu9.c<T> cVar, uu9 uu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, uu9Var};
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
        this.b = uu9Var;
    }

    @Override // com.repackage.vu9.c, com.repackage.fv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((wu9) ((wu9) obj));
    }

    public void call(wu9<? super T> wu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
            uu9.a createWorker = this.b.createWorker();
            a aVar = new a(wu9Var, createWorker);
            wu9Var.a(createWorker);
            wu9Var.a(aVar);
            this.a.call(aVar);
        }
    }
}
