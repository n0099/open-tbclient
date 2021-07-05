package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.f;
import h.o.a.a;
import h.o.a.m;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -657299606803478389L;
    public transient /* synthetic */ FieldHolder $fh;
    public final m<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(m<?, ?> mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parent = mVar;
    }

    @Override // h.f
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + j);
            } else if (i2 > 0) {
                a.b(this, j);
                this.parent.b();
            }
        }
    }
}
