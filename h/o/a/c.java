package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import rx.internal.operators.OnSubscribeAmb$Selection;
/* loaded from: classes2.dex */
public final class c<T> extends h.j<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final h.j<? super T> f71887i;
    public final OnSubscribeAmb$Selection<T> j;
    public boolean k;

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.k) {
                return true;
            }
            if (this.j.get() == this) {
                this.k = true;
                return true;
            } else if (this.j.compareAndSet(null, this)) {
                this.j.unsubscribeOthers(this);
                this.k = true;
                return true;
            } else {
                this.j.unsubscribeLosers();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // h.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && g()) {
            this.f71887i.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) && g()) {
            this.f71887i.onError(th);
        }
    }

    @Override // h.e
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, t) == null) && g()) {
            this.f71887i.onNext(t);
        }
    }
}
