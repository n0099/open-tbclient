package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qu9;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes7.dex */
public final class tv9<T> implements qu9.b<Boolean, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final iv9<? super T, Boolean> a;
    public final boolean b;

    /* loaded from: classes7.dex */
    public class a extends wu9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean e;
        public boolean f;
        public final /* synthetic */ SingleDelayedProducer g;
        public final /* synthetic */ wu9 h;
        public final /* synthetic */ tv9 i;

        public a(tv9 tv9Var, SingleDelayedProducer singleDelayedProducer, wu9 wu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv9Var, singleDelayedProducer, wu9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = tv9Var;
            this.g = singleDelayedProducer;
            this.h = wu9Var;
        }

        @Override // com.repackage.ru9
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

        @Override // com.repackage.ru9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (!this.f) {
                    this.f = true;
                    this.h.onError(th);
                    return;
                }
                xy9.j(th);
            }
        }

        @Override // com.repackage.ru9
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
                cv9.g(th, this, t);
            }
        }
    }

    public tv9(iv9<? super T, Boolean> iv9Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iv9Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = iv9Var;
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.qu9.b, com.repackage.iv9
    public wu9<? super T> call(wu9<? super Boolean> wu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wu9Var)) == null) {
            SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(wu9Var);
            a aVar = new a(this, singleDelayedProducer, wu9Var);
            wu9Var.b(aVar);
            wu9Var.f(singleDelayedProducer);
            return aVar;
        }
        return (wu9) invokeL.objValue;
    }
}
