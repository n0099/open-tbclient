package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yr9;
import rx.exceptions.CompositeException;
/* loaded from: classes6.dex */
public final class it9<T> implements yr9.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yr9<T> a;
    public final is9<? super T> b;
    public final is9<Throwable> c;

    /* loaded from: classes6.dex */
    public static final class a<T> extends zr9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final zr9<? super T> b;
        public final is9<? super T> c;
        public final is9<Throwable> d;

        public a(zr9<? super T> zr9Var, is9<? super T> is9Var, is9<Throwable> is9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zr9Var, is9Var, is9Var2};
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
            this.c = is9Var;
            this.d = is9Var2;
        }

        @Override // com.repackage.zr9
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    gs9.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.repackage.zr9
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    gs9.h(th, this, t);
                }
            }
        }
    }

    public it9(yr9<T> yr9Var, is9<? super T> is9Var, is9<Throwable> is9Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yr9Var, is9Var, is9Var2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = yr9Var;
        this.b = is9Var;
        this.c = is9Var2;
    }

    @Override // com.repackage.yr9.c, com.repackage.is9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((zr9) ((zr9) obj));
    }

    public void call(zr9<? super T> zr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zr9Var) == null) {
            a aVar = new a(zr9Var, this.b, this.c);
            zr9Var.a(aVar);
            this.a.j(aVar);
        }
    }
}
