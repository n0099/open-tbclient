package rx.subjects;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cv9;
import com.baidu.tieba.gv9;
import com.baidu.tieba.hv9;
import com.baidu.tieba.vv9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements cv9, hv9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -5006209596735204567L;
    public transient /* synthetic */ FieldHolder $fh;
    public final gv9<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested;
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(gv9<? super T> gv9Var, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gv9Var, replaySubject$ReplayState};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actual = gv9Var;
        this.requested = new AtomicLong();
        this.state = replaySubject$ReplayState;
    }

    @Override // com.baidu.tieba.hv9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.actual.isUnsubscribed() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.cv9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i > 0) {
                vv9.b(this.requested, j);
                this.state.buffer.a(this);
            } else if (i >= 0) {
            } else {
                throw new IllegalArgumentException("n >= required but it was " + j);
            }
        }
    }

    @Override // com.baidu.tieba.hv9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.state.remove(this);
        }
    }
}
