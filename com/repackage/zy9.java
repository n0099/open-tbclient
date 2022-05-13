package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.wx9;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes7.dex */
public final class zy9<T> implements wx9.b<Boolean, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final oy9<? super T, Boolean> a;
    public final boolean b;

    /* loaded from: classes7.dex */
    public class a extends cy9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean e;
        public boolean f;
        public final /* synthetic */ SingleDelayedProducer g;
        public final /* synthetic */ cy9 h;
        public final /* synthetic */ zy9 i;

        public a(zy9 zy9Var, SingleDelayedProducer singleDelayedProducer, cy9 cy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy9Var, singleDelayedProducer, cy9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = zy9Var;
            this.g = singleDelayedProducer;
            this.h = cy9Var;
        }

        @Override // com.repackage.xx9
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

        @Override // com.repackage.xx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (!this.f) {
                    this.f = true;
                    this.h.onError(th);
                    return;
                }
                d2a.j(th);
            }
        }

        @Override // com.repackage.xx9
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
                iy9.g(th, this, t);
            }
        }
    }

    public zy9(oy9<? super T, Boolean> oy9Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oy9Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = oy9Var;
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wx9.b, com.repackage.oy9
    public cy9<? super T> call(cy9<? super Boolean> cy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cy9Var)) == null) {
            SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(cy9Var);
            a aVar = new a(this, singleDelayedProducer, cy9Var);
            cy9Var.b(aVar);
            cy9Var.f(singleDelayedProducer);
            return aVar;
        }
        return (cy9) invokeL.objValue;
    }
}
