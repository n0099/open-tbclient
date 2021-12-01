package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.f;
import i.j;
import i.k;
import i.o.a.p;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes3.dex */
public final class OperatorPublish$InnerProducer<T> extends AtomicLong implements f, k {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long NOT_REQUESTED = -4611686018427387904L;
    public static final long UNSUBSCRIBED = Long.MIN_VALUE;
    public static final long serialVersionUID = -4453897557930727610L;
    public transient /* synthetic */ FieldHolder $fh;
    public final j<? super T> child;
    public final p<T> parent;

    public OperatorPublish$InnerProducer(p<T> pVar, j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pVar, jVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parent = pVar;
        this.child = jVar;
        lazySet(-4611686018427387904L);
    }

    @Override // i.k
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? get() == Long.MIN_VALUE : invokeV.booleanValue;
    }

    public long produced(long j2) {
        InterceptResult invokeJ;
        long j3;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (j2 > 0) {
                do {
                    j3 = get();
                    if (j3 == -4611686018427387904L) {
                        throw new IllegalStateException("Produced without request");
                    }
                    if (j3 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    j4 = j3 - j2;
                    if (j4 < 0) {
                        throw new IllegalStateException("More produced (" + j2 + ") than requested (" + j3 + SmallTailInfo.EMOTION_SUFFIX);
                    }
                } while (!compareAndSet(j3, j4));
                return j4;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }
        return invokeJ.longValue;
    }

    @Override // i.f
    public void request(long j2) {
        int i2;
        long j3;
        long j4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) || j2 < 0) {
            return;
        }
        do {
            j3 = get();
            if (j3 == Long.MIN_VALUE) {
                return;
            }
            if (j3 >= 0 && i2 == 0) {
                return;
            }
            if (j3 == -4611686018427387904L) {
                j4 = j2;
            } else {
                j4 = j3 + j2;
                if (j4 < 0) {
                    j4 = Long.MAX_VALUE;
                }
            }
        } while (!compareAndSet(j3, j4));
        this.parent.g();
    }

    @Override // i.k
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
            return;
        }
        this.parent.h(this);
        this.parent.g();
    }
}
