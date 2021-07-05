package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import rx.internal.operators.OnSubscribeAmb$Selection;
/* loaded from: classes10.dex */
public final class c<T> extends h.j<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.j<? super T> f75396e;

    /* renamed from: f  reason: collision with root package name */
    public final OnSubscribeAmb$Selection<T> f75397f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f75398g;

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f75398g) {
                return true;
            }
            if (this.f75397f.get() == this) {
                this.f75398g = true;
                return true;
            } else if (this.f75397f.compareAndSet(null, this)) {
                this.f75397f.unsubscribeOthers(this);
                this.f75398g = true;
                return true;
            } else {
                this.f75397f.unsubscribeLosers();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // h.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && b()) {
            this.f75396e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) && b()) {
            this.f75396e.onError(th);
        }
    }

    @Override // h.e
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, t) == null) && b()) {
            this.f75396e.onNext(t);
        }
    }
}
