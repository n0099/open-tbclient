package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.operators.NotificationLite;
import rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator;
/* loaded from: classes10.dex */
public final class d<T, R> extends h.j<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final OnSubscribeCombineLatest$LatestCoordinator<T, R> f75399e;

    /* renamed from: f  reason: collision with root package name */
    public final int f75400f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f75401g;

    public d(OnSubscribeCombineLatest$LatestCoordinator<T, R> onSubscribeCombineLatest$LatestCoordinator, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {onSubscribeCombineLatest$LatestCoordinator, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75399e = onSubscribeCombineLatest$LatestCoordinator;
        this.f75400f = i2;
        request(onSubscribeCombineLatest$LatestCoordinator.bufferSize);
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            request(j);
        }
    }

    @Override // h.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f75401g) {
            return;
        }
        this.f75401g = true;
        this.f75399e.combine(null, this.f75400f);
    }

    @Override // h.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            if (this.f75401g) {
                h.r.c.j(th);
                return;
            }
            this.f75399e.onError(th);
            this.f75401g = true;
            this.f75399e.combine(null, this.f75400f);
        }
    }

    @Override // h.e
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, t) == null) || this.f75401g) {
            return;
        }
        this.f75399e.combine(NotificationLite.h(t), this.f75400f);
    }
}
