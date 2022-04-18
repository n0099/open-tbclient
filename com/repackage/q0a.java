package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fz9;
import rx.exceptions.CompositeException;
/* loaded from: classes6.dex */
public final class q0a<T> implements fz9.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final fz9<T> a;
    public final pz9<? super T> b;
    public final pz9<Throwable> c;

    /* loaded from: classes6.dex */
    public static final class a<T> extends gz9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final gz9<? super T> b;
        public final pz9<? super T> c;
        public final pz9<Throwable> d;

        public a(gz9<? super T> gz9Var, pz9<? super T> pz9Var, pz9<Throwable> pz9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz9Var, pz9Var, pz9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gz9Var;
            this.c = pz9Var;
            this.d = pz9Var2;
        }

        @Override // com.repackage.gz9
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    nz9.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.repackage.gz9
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    nz9.h(th, this, t);
                }
            }
        }
    }

    public q0a(fz9<T> fz9Var, pz9<? super T> pz9Var, pz9<Throwable> pz9Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fz9Var, pz9Var, pz9Var2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fz9Var;
        this.b = pz9Var;
        this.c = pz9Var2;
    }

    @Override // com.repackage.fz9.c, com.repackage.pz9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((gz9) ((gz9) obj));
    }

    public void call(gz9<? super T> gz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gz9Var) == null) {
            a aVar = new a(gz9Var, this.b, this.c);
            gz9Var.a(aVar);
            this.a.j(aVar);
        }
    }
}
