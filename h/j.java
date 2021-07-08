package h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class j<T> implements e<T>, k {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long NOT_SET = Long.MIN_VALUE;
    public transient /* synthetic */ FieldHolder $fh;
    public f producer;
    public long requested;
    public final j<?> subscriber;
    public final h.o.d.h subscriptions;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j() {
        this(null, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((j) objArr[0], ((Boolean) objArr[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void addToRequested(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65539, this, j) == null) {
            long j2 = this.requested;
            if (j2 == Long.MIN_VALUE) {
                this.requested = j;
                return;
            }
            long j3 = j2 + j;
            if (j3 < 0) {
                this.requested = Long.MAX_VALUE;
            } else {
                this.requested = j3;
            }
        }
    }

    public final void add(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            this.subscriptions.a(kVar);
        }
    }

    @Override // h.k
    public final boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.subscriptions.isUnsubscribed() : invokeV.booleanValue;
    }

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public final void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            if (j >= 0) {
                synchronized (this) {
                    if (this.producer != null) {
                        this.producer.request(j);
                        return;
                    }
                    addToRequested(j);
                    return;
                }
            }
            throw new IllegalArgumentException("number requested cannot be negative: " + j);
        }
    }

    public void setProducer(f fVar) {
        long j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            synchronized (this) {
                j = this.requested;
                this.producer = fVar;
                z = this.subscriber != null && j == Long.MIN_VALUE;
            }
            if (z) {
                this.subscriber.setProducer(this.producer);
            } else if (j == Long.MIN_VALUE) {
                this.producer.request(Long.MAX_VALUE);
            } else {
                this.producer.request(j);
            }
        }
    }

    @Override // h.k
    public final void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.subscriptions.unsubscribe();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(j<?> jVar) {
        this(jVar, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((j) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public j(j<?> jVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.requested = Long.MIN_VALUE;
        this.subscriber = jVar;
        this.subscriptions = (!z || jVar == null) ? new h.o.d.h() : jVar.subscriptions;
    }
}
