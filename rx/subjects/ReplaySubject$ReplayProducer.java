package rx.subjects;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.f;
import i.j;
import i.k;
import i.o.a.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements f, k {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -5006209596735204567L;
    public transient /* synthetic */ FieldHolder $fh;
    public final j<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested;
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(j<? super T> jVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, replaySubject$ReplayState};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actual = jVar;
        this.requested = new AtomicLong();
        this.state = replaySubject$ReplayState;
    }

    @Override // i.k
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.actual.isUnsubscribed() : invokeV.booleanValue;
    }

    @Override // i.f
    public void request(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 > 0) {
                a.b(this.requested, j2);
                this.state.buffer.a(this);
            } else if (i2 >= 0) {
            } else {
                throw new IllegalArgumentException("n >= required but it was " + j2);
            }
        }
    }

    @Override // i.k
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.state.remove(this);
        }
    }
}
