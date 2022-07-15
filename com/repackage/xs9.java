package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ur9;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes7.dex */
public final class xs9<T> implements ur9.b<Boolean, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ms9<? super T, Boolean> a;
    public final boolean b;

    /* loaded from: classes7.dex */
    public class a extends as9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean e;
        public boolean f;
        public final /* synthetic */ SingleDelayedProducer g;
        public final /* synthetic */ as9 h;
        public final /* synthetic */ xs9 i;

        public a(xs9 xs9Var, SingleDelayedProducer singleDelayedProducer, as9 as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xs9Var, singleDelayedProducer, as9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = xs9Var;
            this.g = singleDelayedProducer;
            this.h = as9Var;
        }

        @Override // com.repackage.vr9
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

        @Override // com.repackage.vr9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (!this.f) {
                    this.f = true;
                    this.h.onError(th);
                    return;
                }
                bw9.j(th);
            }
        }

        @Override // com.repackage.vr9
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
                gs9.g(th, this, t);
            }
        }
    }

    public xs9(ms9<? super T, Boolean> ms9Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ms9Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ms9Var;
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ur9.b, com.repackage.ms9
    public as9<? super T> call(as9<? super Boolean> as9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, as9Var)) == null) {
            SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(as9Var);
            a aVar = new a(this, singleDelayedProducer, as9Var);
            as9Var.b(aVar);
            as9Var.f(singleDelayedProducer);
            return aVar;
        }
        return (as9) invokeL.objValue;
    }
}
