package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yy9;
import rx.exceptions.CompositeException;
/* loaded from: classes6.dex */
public final class j0a<T> implements yy9.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yy9<T> a;
    public final iz9<? super T> b;
    public final iz9<Throwable> c;

    /* loaded from: classes6.dex */
    public static final class a<T> extends zy9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final zy9<? super T> b;
        public final iz9<? super T> c;
        public final iz9<Throwable> d;

        public a(zy9<? super T> zy9Var, iz9<? super T> iz9Var, iz9<Throwable> iz9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy9Var, iz9Var, iz9Var2};
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
            this.c = iz9Var;
            this.d = iz9Var2;
        }

        @Override // com.repackage.zy9
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    gz9.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.repackage.zy9
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    gz9.h(th, this, t);
                }
            }
        }
    }

    public j0a(yy9<T> yy9Var, iz9<? super T> iz9Var, iz9<Throwable> iz9Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yy9Var, iz9Var, iz9Var2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = yy9Var;
        this.b = iz9Var;
        this.c = iz9Var2;
    }

    @Override // com.repackage.yy9.c, com.repackage.iz9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((zy9) ((zy9) obj));
    }

    public void call(zy9<? super T> zy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zy9Var) == null) {
            a aVar = new a(zy9Var, this.b, this.c);
            zy9Var.a(aVar);
            this.a.j(aVar);
        }
    }
}
