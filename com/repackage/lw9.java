package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bv9;
import rx.exceptions.CompositeException;
/* loaded from: classes6.dex */
public final class lw9<T> implements bv9.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bv9<T> a;
    public final lv9<? super T> b;
    public final lv9<Throwable> c;

    /* loaded from: classes6.dex */
    public static final class a<T> extends cv9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final cv9<? super T> b;
        public final lv9<? super T> c;
        public final lv9<Throwable> d;

        public a(cv9<? super T> cv9Var, lv9<? super T> lv9Var, lv9<Throwable> lv9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv9Var, lv9Var, lv9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cv9Var;
            this.c = lv9Var;
            this.d = lv9Var2;
        }

        @Override // com.repackage.cv9
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    jv9.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.repackage.cv9
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    jv9.h(th, this, t);
                }
            }
        }
    }

    public lw9(bv9<T> bv9Var, lv9<? super T> lv9Var, lv9<Throwable> lv9Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bv9Var, lv9Var, lv9Var2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bv9Var;
        this.b = lv9Var;
        this.c = lv9Var2;
    }

    @Override // com.repackage.bv9.c, com.repackage.lv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((cv9) ((cv9) obj));
    }

    public void call(cv9<? super T> cv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cv9Var) == null) {
            a aVar = new a(cv9Var, this.b, this.c);
            cv9Var.a(aVar);
            this.a.j(aVar);
        }
    }
}
