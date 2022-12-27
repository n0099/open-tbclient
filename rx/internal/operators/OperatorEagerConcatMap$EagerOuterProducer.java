package rx.internal.operators;

import com.baidu.tieba.e3a;
import com.baidu.tieba.g4a;
import com.baidu.tieba.x3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements e3a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -657299606803478389L;
    public transient /* synthetic */ FieldHolder $fh;
    public final g4a<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(g4a<?, ?> g4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g4aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parent = g4aVar;
    }

    @Override // com.baidu.tieba.e3a
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    x3a.b(this, j);
                    this.parent.g();
                    return;
                }
                return;
            }
            throw new IllegalStateException("n >= 0 required but it was " + j);
        }
    }
}
