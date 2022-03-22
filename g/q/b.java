package g.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.k;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
/* loaded from: classes7.dex */
public final class b implements g.c, k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g.c a;

    /* renamed from: b  reason: collision with root package name */
    public k f45041b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45042c;

    public b(g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
    }

    @Override // g.k
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45042c || this.f45041b.isUnsubscribed() : invokeV.booleanValue;
    }

    @Override // g.c
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f45042c) {
            return;
        }
        this.f45042c = true;
        try {
            this.a.onCompleted();
        } catch (Throwable th) {
            g.m.a.e(th);
            throw new OnCompletedFailedException(th);
        }
    }

    @Override // g.c
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            g.r.c.j(th);
            if (this.f45042c) {
                return;
            }
            this.f45042c = true;
            try {
                this.a.onError(th);
            } catch (Throwable th2) {
                g.m.a.e(th2);
                throw new OnErrorFailedException(new CompositeException(th, th2));
            }
        }
    }

    @Override // g.c
    public void onSubscribe(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) {
            this.f45041b = kVar;
            try {
                this.a.onSubscribe(this);
            } catch (Throwable th) {
                g.m.a.e(th);
                kVar.unsubscribe();
                onError(th);
            }
        }
    }

    @Override // g.k
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f45041b.unsubscribe();
        }
    }
}
