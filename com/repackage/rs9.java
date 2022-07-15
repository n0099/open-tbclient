package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import rx.internal.operators.OnSubscribeAmb$Selection;
/* loaded from: classes7.dex */
public final class rs9<T> extends as9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final as9<? super T> e;
    public final OnSubscribeAmb$Selection<T> f;
    public boolean g;

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.g) {
                return true;
            }
            if (this.f.get() == this) {
                this.g = true;
                return true;
            } else if (this.f.compareAndSet(null, this)) {
                this.f.unsubscribeOthers(this);
                this.g = true;
                return true;
            } else {
                this.f.unsubscribeLosers();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.vr9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && g()) {
            this.e.onCompleted();
        }
    }

    @Override // com.repackage.vr9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) && g()) {
            this.e.onError(th);
        }
    }

    @Override // com.repackage.vr9
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, t) == null) && g()) {
            this.e.onNext(t);
        }
    }
}
