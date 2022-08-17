package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.vu9;
import rx.exceptions.CompositeException;
/* loaded from: classes6.dex */
public final class fw9<T> implements vu9.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vu9<T> a;
    public final fv9<? super T> b;
    public final fv9<Throwable> c;

    /* loaded from: classes6.dex */
    public static final class a<T> extends wu9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final wu9<? super T> b;
        public final fv9<? super T> c;
        public final fv9<Throwable> d;

        public a(wu9<? super T> wu9Var, fv9<? super T> fv9Var, fv9<Throwable> fv9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu9Var, fv9Var, fv9Var2};
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
            this.c = fv9Var;
            this.d = fv9Var2;
        }

        @Override // com.repackage.wu9
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    dv9.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.repackage.wu9
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    dv9.h(th, this, t);
                }
            }
        }
    }

    public fw9(vu9<T> vu9Var, fv9<? super T> fv9Var, fv9<Throwable> fv9Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vu9Var, fv9Var, fv9Var2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = vu9Var;
        this.b = fv9Var;
        this.c = fv9Var2;
    }

    @Override // com.repackage.vu9.c, com.repackage.fv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((wu9) ((wu9) obj));
    }

    public void call(wu9<? super T> wu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
            a aVar = new a(wu9Var, this.b, this.c);
            wu9Var.a(aVar);
            this.a.j(aVar);
        }
    }
}
