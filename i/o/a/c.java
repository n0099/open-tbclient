package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import rx.internal.operators.OnSubscribeAmb$Selection;
/* loaded from: classes10.dex */
public final class c<T> extends i.j<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.j<? super T> f78955e;

    /* renamed from: f  reason: collision with root package name */
    public final OnSubscribeAmb$Selection<T> f78956f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f78957g;

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f78957g) {
                return true;
            }
            if (this.f78956f.get() == this) {
                this.f78957g = true;
                return true;
            } else if (this.f78956f.compareAndSet(null, this)) {
                this.f78956f.unsubscribeOthers(this);
                this.f78957g = true;
                return true;
            } else {
                this.f78956f.unsubscribeLosers();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // i.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && b()) {
            this.f78955e.onCompleted();
        }
    }

    @Override // i.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) && b()) {
            this.f78955e.onError(th);
        }
    }

    @Override // i.e
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, t) == null) && b()) {
            this.f78955e.onNext(t);
        }
    }
}
