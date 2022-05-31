package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.uu9;
import rx.exceptions.CompositeException;
/* loaded from: classes5.dex */
public final class ew9<T> implements uu9.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final uu9<T> a;
    public final ev9<? super T> b;
    public final ev9<Throwable> c;

    /* loaded from: classes5.dex */
    public static final class a<T> extends vu9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final vu9<? super T> b;
        public final ev9<? super T> c;
        public final ev9<Throwable> d;

        public a(vu9<? super T> vu9Var, ev9<? super T> ev9Var, ev9<Throwable> ev9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu9Var, ev9Var, ev9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vu9Var;
            this.c = ev9Var;
            this.d = ev9Var2;
        }

        @Override // com.repackage.vu9
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    cv9.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.repackage.vu9
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    cv9.h(th, this, t);
                }
            }
        }
    }

    public ew9(uu9<T> uu9Var, ev9<? super T> ev9Var, ev9<Throwable> ev9Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uu9Var, ev9Var, ev9Var2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = uu9Var;
        this.b = ev9Var;
        this.c = ev9Var2;
    }

    @Override // com.repackage.uu9.c, com.repackage.ev9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((vu9) ((vu9) obj));
    }

    public void call(vu9<? super T> vu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vu9Var) == null) {
            a aVar = new a(vu9Var, this.b, this.c);
            vu9Var.a(aVar);
            this.a.j(aVar);
        }
    }
}
