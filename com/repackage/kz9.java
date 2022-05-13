package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ay9;
import rx.exceptions.CompositeException;
/* loaded from: classes6.dex */
public final class kz9<T> implements ay9.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ay9<T> a;
    public final ky9<? super T> b;
    public final ky9<Throwable> c;

    /* loaded from: classes6.dex */
    public static final class a<T> extends by9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final by9<? super T> b;
        public final ky9<? super T> c;
        public final ky9<Throwable> d;

        public a(by9<? super T> by9Var, ky9<? super T> ky9Var, ky9<Throwable> ky9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {by9Var, ky9Var, ky9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = by9Var;
            this.c = ky9Var;
            this.d = ky9Var2;
        }

        @Override // com.repackage.by9
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    iy9.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.repackage.by9
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    iy9.h(th, this, t);
                }
            }
        }
    }

    public kz9(ay9<T> ay9Var, ky9<? super T> ky9Var, ky9<Throwable> ky9Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ay9Var, ky9Var, ky9Var2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ay9Var;
        this.b = ky9Var;
        this.c = ky9Var2;
    }

    @Override // com.repackage.ay9.c, com.repackage.ky9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((by9) ((by9) obj));
    }

    public void call(by9<? super T> by9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, by9Var) == null) {
            a aVar = new a(by9Var, this.b, this.c);
            by9Var.a(aVar);
            this.a.j(aVar);
        }
    }
}
