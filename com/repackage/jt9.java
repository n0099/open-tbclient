package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ur9;
import com.repackage.yr9;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public final class jt9<T> implements yr9.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ur9.a<T> a;

    /* loaded from: classes6.dex */
    public static final class a<T> extends as9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final zr9<? super T> e;
        public T f;
        public int g;

        public a(zr9<? super T> zr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zr9Var;
        }

        @Override // com.repackage.vr9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.g;
                if (i == 0) {
                    this.e.b(new NoSuchElementException());
                } else if (i == 1) {
                    this.g = 2;
                    T t = this.f;
                    this.f = null;
                    this.e.c(t);
                }
            }
        }

        @Override // com.repackage.vr9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.g == 2) {
                    bw9.j(th);
                    return;
                }
                this.f = null;
                this.e.b(th);
            }
        }

        @Override // com.repackage.vr9
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                int i = this.g;
                if (i == 0) {
                    this.g = 1;
                    this.f = t;
                } else if (i == 1) {
                    this.g = 2;
                    this.e.b(new IndexOutOfBoundsException("The upstream produced more than one value"));
                }
            }
        }
    }

    public jt9(ur9.a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
    }

    @Override // com.repackage.yr9.c, com.repackage.is9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((zr9) ((zr9) obj));
    }

    public void call(zr9<? super T> zr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zr9Var) == null) {
            a aVar = new a(zr9Var);
            zr9Var.a(aVar);
            this.a.call(aVar);
        }
    }
}
