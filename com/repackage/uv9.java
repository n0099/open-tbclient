package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ru9;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes7.dex */
public final class uv9<T> implements ru9.b<Boolean, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final jv9<? super T, Boolean> a;
    public final boolean b;

    /* loaded from: classes7.dex */
    public class a extends xu9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean e;
        public boolean f;
        public final /* synthetic */ SingleDelayedProducer g;
        public final /* synthetic */ xu9 h;
        public final /* synthetic */ uv9 i;

        public a(uv9 uv9Var, SingleDelayedProducer singleDelayedProducer, xu9 xu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv9Var, singleDelayedProducer, xu9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = uv9Var;
            this.g = singleDelayedProducer;
            this.h = xu9Var;
        }

        @Override // com.repackage.su9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f) {
                return;
            }
            this.f = true;
            if (this.e) {
                this.g.setValue(Boolean.FALSE);
            } else {
                this.g.setValue(Boolean.valueOf(this.i.b));
            }
        }

        @Override // com.repackage.su9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (!this.f) {
                    this.f = true;
                    this.h.onError(th);
                    return;
                }
                yy9.j(th);
            }
        }

        @Override // com.repackage.su9
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f) {
                return;
            }
            this.e = true;
            try {
                if (this.i.a.call(t).booleanValue()) {
                    this.f = true;
                    this.g.setValue(Boolean.valueOf(true ^ this.i.b));
                    unsubscribe();
                }
            } catch (Throwable th) {
                dv9.g(th, this, t);
            }
        }
    }

    public uv9(jv9<? super T, Boolean> jv9Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jv9Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jv9Var;
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ru9.b, com.repackage.jv9
    public xu9<? super T> call(xu9<? super Boolean> xu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xu9Var)) == null) {
            SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(xu9Var);
            a aVar = new a(this, singleDelayedProducer, xu9Var);
            xu9Var.b(aVar);
            xu9Var.f(singleDelayedProducer);
            return aVar;
        }
        return (xu9) invokeL.objValue;
    }
}
