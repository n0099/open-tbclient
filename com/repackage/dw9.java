package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.tu9;
import rx.exceptions.CompositeException;
/* loaded from: classes6.dex */
public final class dw9<T> implements tu9.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tu9<T> a;
    public final dv9<? super T> b;
    public final dv9<Throwable> c;

    /* loaded from: classes6.dex */
    public static final class a<T> extends uu9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final uu9<? super T> b;
        public final dv9<? super T> c;
        public final dv9<Throwable> d;

        public a(uu9<? super T> uu9Var, dv9<? super T> dv9Var, dv9<Throwable> dv9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uu9Var, dv9Var, dv9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uu9Var;
            this.c = dv9Var;
            this.d = dv9Var2;
        }

        @Override // com.repackage.uu9
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    bv9.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.repackage.uu9
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    bv9.h(th, this, t);
                }
            }
        }
    }

    public dw9(tu9<T> tu9Var, dv9<? super T> dv9Var, dv9<Throwable> dv9Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tu9Var, dv9Var, dv9Var2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tu9Var;
        this.b = dv9Var;
        this.c = dv9Var2;
    }

    @Override // com.repackage.tu9.c, com.repackage.dv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((uu9) ((uu9) obj));
    }

    public void call(uu9<? super T> uu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uu9Var) == null) {
            a aVar = new a(uu9Var, this.b, this.c);
            uu9Var.a(aVar);
            this.a.j(aVar);
        }
    }
}
