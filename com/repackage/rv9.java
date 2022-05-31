package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qu9;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class rv9<T, R> implements qu9.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final qu9<T> a;
    public final iv9<? super T, ? extends R> b;

    /* loaded from: classes7.dex */
    public static final class a<T, R> extends wu9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final wu9<? super R> e;
        public final iv9<? super T, ? extends R> f;
        public boolean g;

        public a(wu9<? super R> wu9Var, iv9<? super T, ? extends R> iv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu9Var, iv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = wu9Var;
            this.f = iv9Var;
        }

        @Override // com.repackage.wu9
        public void f(su9 su9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, su9Var) == null) {
                this.e.f(su9Var);
            }
        }

        @Override // com.repackage.ru9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.g) {
                return;
            }
            this.e.onCompleted();
        }

        @Override // com.repackage.ru9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.g) {
                    xy9.j(th);
                    return;
                }
                this.g = true;
                this.e.onError(th);
            }
        }

        @Override // com.repackage.ru9
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                try {
                    this.e.onNext(this.f.call(t));
                } catch (Throwable th) {
                    cv9.e(th);
                    unsubscribe();
                    onError(OnErrorThrowable.addValueAsLastCause(th, t));
                }
            }
        }
    }

    public rv9(qu9<T> qu9Var, iv9<? super T, ? extends R> iv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qu9Var, iv9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = qu9Var;
        this.b = iv9Var;
    }

    @Override // com.repackage.qu9.a, com.repackage.ev9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((wu9) ((wu9) obj));
    }

    public void call(wu9<? super R> wu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
            a aVar = new a(wu9Var, this.b);
            wu9Var.b(aVar);
            this.a.B(aVar);
        }
    }
}
