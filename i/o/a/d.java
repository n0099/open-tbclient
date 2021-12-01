package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.operators.NotificationLite;
import rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator;
/* loaded from: classes3.dex */
public final class d<T, R> extends i.j<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final OnSubscribeCombineLatest$LatestCoordinator<T, R> f63651i;

    /* renamed from: j  reason: collision with root package name */
    public final int f63652j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f63653k;

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
        this.f63651i = onSubscribeCombineLatest$LatestCoordinator;
        this.f63652j = i2;
        e(onSubscribeCombineLatest$LatestCoordinator.bufferSize);
    }

    public void g(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            e(j2);
        }
    }

    @Override // i.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f63653k) {
            return;
        }
        this.f63653k = true;
        this.f63651i.combine(null, this.f63652j);
    }

    @Override // i.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            if (this.f63653k) {
                i.r.c.j(th);
                return;
            }
            this.f63651i.onError(th);
            this.f63653k = true;
            this.f63651i.combine(null, this.f63652j);
        }
    }

    @Override // i.e
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, t) == null) || this.f63653k) {
            return;
        }
        this.f63651i.combine(NotificationLite.h(t), this.f63652j);
    }
}
