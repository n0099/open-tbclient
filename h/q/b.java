package h.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.k;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
/* loaded from: classes9.dex */
public final class b implements h.c, k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.c f73157e;

    /* renamed from: f  reason: collision with root package name */
    public k f73158f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f73159g;

    public b(h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73157e = cVar;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f73159g || this.f73158f.isUnsubscribed() : invokeV.booleanValue;
    }

    @Override // h.c
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f73159g) {
            return;
        }
        this.f73159g = true;
        try {
            this.f73157e.onCompleted();
        } catch (Throwable th) {
            h.m.a.e(th);
            throw new OnCompletedFailedException(th);
        }
    }

    @Override // h.c
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            h.r.c.j(th);
            if (this.f73159g) {
                return;
            }
            this.f73159g = true;
            try {
                this.f73157e.onError(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                throw new OnErrorFailedException(new CompositeException(th, th2));
            }
        }
    }

    @Override // h.c
    public void onSubscribe(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) {
            this.f73158f = kVar;
            try {
                this.f73157e.onSubscribe(this);
            } catch (Throwable th) {
                h.m.a.e(th);
                kVar.unsubscribe();
                onError(th);
            }
        }
    }

    @Override // h.k
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f73158f.unsubscribe();
        }
    }
}
